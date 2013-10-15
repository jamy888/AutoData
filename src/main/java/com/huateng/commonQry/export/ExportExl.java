package com.huateng.commonQry.export;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import com.huateng.common.ComFunc;
import com.huateng.common.Constants;
import com.huateng.query.bean.FieldData;
import com.huateng.query.bean.Result;
import com.huateng.util.SysParam;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class ExportExl {
	public void export(Result result, int count, String title, String filename) throws Exception {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		// 设置生成文件类型
		//String rptType = "application/vnd.ms-excel";
		//String fileType = ".xls";
		// 本地备份文件名称
		//String fileName = title + "_" + ComFunc.getLocalDateTime14();
		// 本地备份文件
		String fileName = filename+"_" + ComFunc.getLocalDateTime14();
		File file = new File(SysParam.getSysParam("RPT_PATH")+"\\"+filename, fileName + ".xls");
		File fileFolder = file.getParentFile();
		if (!fileFolder.exists()) {
			fileFolder.mkdirs();
		}
		process(result, count, new FileOutputStream(file),title);
		logger.info("本次生成的文件名为:"+fileName);
		/*if(!file.exists()){
			process(result, count, new FileOutputStream(file),title);
			//ServletActionContext.getContext().getSession().put("filename", fileName);
			//System.out.println((String) ServletActionContext.getContext().getSession().get("filename"));
			logger.info("本次生成的文件名为:"+fileName);
		}else{
			process11(result, count,file, title,fileName);
			//ServletActionContext.getContext().getSession().put("filename", fileName);
		}*/
		
	}
	
	/**
	 * 生成xls文件
	 * @param cqId
	 * @param result
	 * @param count
	 * @param outputStream
	 * @param fileName 文件名
	 * @param title 标题
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void process(Result result, int count,OutputStream outputStream, String title)
			throws Exception {
		// 生成报表
		WritableWorkbook wwb = Workbook.createWorkbook(outputStream);
		int n = count%50000 == 0 ? count/50000: count/50000 + 1;
		/*// 建立sheet
		WritableSheet ws = wwb.createSheet(title, 0);*/
		// 标题字体
		WritableFont titleWf = new WritableFont(WritableFont.createFont("宋体"),
				20, WritableFont.BOLD);
		// 单元格格式(文本)
		WritableCellFormat labelWcf = new WritableCellFormat();
		labelWcf.setWrap(true);
		labelWcf.setAlignment(Alignment.CENTRE);
		labelWcf.setVerticalAlignment(VerticalAlignment.CENTRE);
		
		for(int k = 0;k<n;k++){
			// 建立sheet
			WritableSheet ws = wwb.createSheet(title+(k+1), k);
			// 生成标题
			ws.addCell(new Label(1, 0, title, new WritableCellFormat(titleWf)));//new Lable(列,行,值,格式)
			// 第一列作为序号列
			ws.addCell(new Label(0, 1, "序号", labelWcf));
			// 循环生成文件
			int m = (k == n-1?(count%50000):((k+1)*50000));
			for(int i = 0; i < m;i++){
				LinkedHashMap<Object, FieldData> map = result.getRow(i).getRowMap();
				Iterator<Entry<Object, FieldData>> it = map.entrySet().iterator();
				// 序号列
				ws.addCell(new Label(0, i + 2, String.valueOf(i + 1), labelWcf));
				int j = 1;
				while(it.hasNext()){
					Entry<Object, FieldData> e = it.next();
					// 列宽为本列最长字符串长度+2
					int oldSize = ws.getColumnWidth(j);
					int newSize = e.getValue().getOpr().length();
					ws.setColumnView(j, oldSize < newSize + 2 ? newSize + 2 : oldSize);
					// 当为列名行时
					if (i == 0) {
						// 设置默认列宽为15
						ws.setColumnView(j, 15);
						// 生成列名
						ws.addCell(new Label(j, 1, e.getKey().toString(),labelWcf));
					}
					// 生成具体值
					ws.addCell(new Label(j++, i + 2, e.getValue().getOpr(),labelWcf));
				}
			}
		}
		try{
			wwb.write();
			wwb.close();
			outputStream.flush();
			outputStream.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*@SuppressWarnings({ "rawtypes", "unchecked" })
	public void process11(Result result, int count,File file, String title,String fileName) {
		try{
			Workbook wb = Workbook.getWorkbook(file);
			int now_rows=wb.getSheet(wb.getNumberOfSheets()-1).getRows();
			if(now_rows>40000){
				File newfile = new File(SysParam.getSysParam("RPT_PATH"), fileName+(filenum++) + ".xls");
			}
			WritableWorkbook wwb = Workbook.createWorkbook(file, wb);
			int num = wwb.getNumberOfSheets();//sheet数目
			WritableSheet ws = (WritableSheet) wwb.getSheet(num-1);
			// 标题字体
			WritableFont titleWf = new WritableFont(WritableFont.createFont("宋体"),20, WritableFont.BOLD);
			// 单元格格式(文本)
			WritableCellFormat labelWcf = new WritableCellFormat();
			labelWcf.setWrap(true);
			labelWcf.setAlignment(Alignment.CENTRE);
			labelWcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			int rows = ws.getRows();//最后一个sheet的行数
			int r = rows+count;//数据总行数，即本sheet原有的行数rows加上新增加的行数count
			if(r<=50002){//每页50000行数据,一行是标题title,一行是列名rowNm
				for (int i = rows; i < r; i++) {
					LinkedHashMap map = result.getRow(i-rows).getRowMap();
					Iterator<Entry<Object, FieldData>> it = map.entrySet().iterator();
					ws.addCell(new Label(0, i, String.valueOf(i-1), labelWcf));// 序号列
					int j = 1;
					while (it.hasNext()) {
						Entry<Object, FieldData> e = it.next();
						// 列宽为本列最长字符串长度+2
						int oldSize = ws.getColumnWidth(j);
						int newSize = e.getValue().getOpr().length();
						ws.setColumnView(j, oldSize < newSize + 2 ? newSize + 2 : oldSize);
						// 当为列名行时
						if (i == 0) {
							ws.setColumnView(j, 15);// 设置默认列宽为15
							ws.addCell(new Label(j, 1, e.getKey().toString(),labelWcf));// 生成列名
						}
						ws.addCell(new Label(j++, i , e.getValue().getOpr(),labelWcf));// 生成具体值
					}
				}
			}else{
				if(50002-rows>0){
					for (int i = rows; i <50002-rows; i++) {
						LinkedHashMap map = result.getRow(i-rows).getRowMap();
						Iterator<Entry<Object, FieldData>> it = map.entrySet().iterator();
						ws.addCell(new Label(0, i, String.valueOf(i- 1), labelWcf));// 序号列
						int j = 1;
						while (it.hasNext()) {
							Entry<Object, FieldData> e = it.next();
							// 列宽为本列最长字符串长度+2
							int oldSize = ws.getColumnWidth(j);
							int newSize = e.getValue().getOpr().length();
							ws.setColumnView(j, oldSize < newSize + 2 ? newSize + 2 : oldSize);
							// 当为列名行时
							if (i == 0) {
								ws.setColumnView(j, 15);// 设置默认列宽为15
								ws.addCell(new Label(j, 1, e.getKey().toString(),labelWcf));// 生成列名
							}
							ws.addCell(new Label(j++, i+1, e.getValue().getOpr(),labelWcf));// 生成具体值
						}
					}
				}
				
				//建立sheet
				wwb.createSheet(title+(num+1), num);
				// 生成标题
				ws.addCell(new Label(1, 0, title, new WritableCellFormat(titleWf)));//new Lable(列,行,值,格式)
				// 第一列作为序号列
				ws.addCell(new Label(0, 1, "序号", labelWcf));
				for(int i = 0; i < count-rows+50002; i++){
					LinkedHashMap map = result.getRow(50002-rows+i).getRowMap();
					Iterator<Entry<Object, FieldData>> it = map.entrySet().iterator();
					ws.addCell(new Label(0, i, String.valueOf(i-rows+ 1), labelWcf));// 序号列
					int j = 1;
					while (it.hasNext()) {
						Entry<Object, FieldData> e = it.next();
						// 列宽为本列最长字符串长度+2
						int oldSize = ws.getColumnWidth(j);
						int newSize = e.getValue().getOpr().length();
						ws.setColumnView(j, oldSize < newSize + 2 ? newSize + 2 : oldSize);
						// 当为列名行时
						if (i == 0) {
							ws.setColumnView(j, 15);// 设置默认列宽为15
							ws.addCell(new Label(j, 1, e.getKey().toString(),labelWcf));// 生成列名
						}
						ws.addCell(new Label(j++, 50002-rows+i + 2, e.getValue().getOpr(),labelWcf));// 生成具体值
					}
				}
			}
			wwb.write();
			
			wwb.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void getAllSheet(File lastFile,List<File> file,String title){
		try {
			Workbook wb = Workbook.getWorkbook(file.get(0));
			WritableWorkbook wwb = Workbook.createWorkbook(lastFile, wb);
			wwb.copySheet(wb.getSheetNames()[0], title, 0);
			//wwb.removeSheet(1); 
			wwb.write();
			for(int index=1;index<file.size();index++){
				Workbook wb1 = Workbook.getWorkbook(file.get(index));
				
				wwb.copySheet(wb1.getSheetNames()[0], title, index);
				//wwb.removeSheet(index+1);
				wwb.write();
			}try {
				wwb.close();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/
	/*public static void main(String[] args){
		List filelist = new ArrayList();
		File lastFile = new File(SysParam.getSysParam("RPT_PATH"), "testExecl" + ".xls");
		File file = new File(SysParam.getSysParam("RPT_PATH"), "111" + ".xls");
		filelist.add(file);
		String title = "test";
		File file1 = new File(SysParam.getSysParam("RPT_PATH"), "222" + ".xls");
		filelist.add(file1);
		getAllSheet(lastFile,filelist,title);
		System.out.println("success");
	}*/
}
