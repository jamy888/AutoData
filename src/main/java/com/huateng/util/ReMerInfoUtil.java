package com.huateng.util;

import java.util.List;

import com.huateng.common.ComFunc;
import com.huateng.exception.ComException;
import com.huateng.query.dao.ICommQueryDAO;

public class ReMerInfoUtil extends Thread{
	private static List<Object[]> reMerInfo;
	
	public void setReMerInfo() throws ComException {
		ICommQueryDAO commQueryDAO;
		commQueryDAO = ComFunc.getDao();
		reMerInfo = commQueryDAO.findBySQLQuery("select distinct mer_id,MER_SHORT_NAME from TBL_APP_REMOTEMER_COLD_DTL where trim(MER_SHORT_NAME) is not null");
	}

	public static List<Object[]> getReMerInfo() {
		return reMerInfo;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			setReMerInfo();
		} catch (ComException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
