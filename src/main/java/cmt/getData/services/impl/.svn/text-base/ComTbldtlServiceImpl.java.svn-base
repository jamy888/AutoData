package cmt.getData.services.impl;

import java.util.List;

import cmt.getData.dao.ComTbldtlDAO;
import cmt.getData.services.ComTbldtlService;

public class ComTbldtlServiceImpl implements ComTbldtlService {
	private ComTbldtlDAO comTbldtlDAO;

	public ComTbldtlDAO getComTbldtlDAO() {
		return comTbldtlDAO;
	}
	public void setComTbldtlDAO(ComTbldtlDAO comTbldtlDAO) {
		this.comTbldtlDAO = comTbldtlDAO;
	}

	public List<?> selectExample(String sql) {
		List<?> list = comTbldtlDAO.sqlQuery(sql);
		return list;
	}
	public List<?> selectExample(String sql, int current, int maxResult) {
		List<?> list = comTbldtlDAO.sqlQuery(sql, current, maxResult);
		return list;
	}
	public String sqlSum(String sql){
		return comTbldtlDAO.sqlSum(sql);
		
	}
	public List<?> selectMap(String sql) {
		
		return comTbldtlDAO.sqlMap(sql);
	}

}
