package cmt.dealdata;

import java.util.List;

import com.huateng.commonQry.export.ExportExl;
import com.huateng.exception.ComException;
import com.huateng.query.bean.Result;

public class Report {
	private List<Object[]> data;
	private String[] rowNm;//列名 
	private String title;//标题
	private String fileName;
	public Report(List<Object[]> data, String[] rowNm,String title,String fileName) {
		this.data = data;
		this.rowNm = rowNm;
		this.title = title;
		this.fileName=fileName;
	}


	public void run(){
		try{
			if(data.size() != 0){
				Result result = DealData.assembleData(data, rowNm);
				new ExportExl().export(result, data.size(), title,fileName);
			}
		}catch (ComException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
