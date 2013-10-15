package cmt.thread;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import cmt.dealdata.DealData;
import cmt.getData.po.TblAppMarketingToolUsedtl;

import com.huateng.common.ComFunc;
import com.huateng.commonQry.export.ExportExl;
import com.huateng.exception.ComException;
import com.huateng.query.bean.Result;
import com.huateng.query.dao.ICommQueryDAO;

public class ReportThread extends Thread {
	private List<Object[]> data;
	private String[] rowNm;//列名 
	private String title;//标题
	private String fileNm;
	public ReportThread(List<Object[]> data, String[] rowNm,String title,String fileNm) {
		this.data = data;
		this.rowNm = rowNm;
		this.title = title;
		this.fileNm = fileNm;
	}

	@SuppressWarnings("unchecked")
	public void run(){
		ICommQueryDAO commQueryDAO;
		try{
			//commQueryDAO = ComFunc.getDao();
			//List<Object[]> data = commQueryDAO.findBySQLQuery(sql);
			if(data.size() != 0){
				Result result = DealData.assembleData(data, rowNm);
				//new ExportReport().export(result, data.size(), fileNm,title);
				new ExportExl().export(result, data.size(), title,fileNm);
			}
		}catch (ComException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
