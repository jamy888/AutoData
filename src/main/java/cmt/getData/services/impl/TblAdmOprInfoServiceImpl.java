package cmt.getData.services.impl;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import cmt.getData.dao.TblAdmOprInfoDAO;
import cmt.getData.po.TblAdmOprInfo;
import cmt.getData.services.TblAdmOprInfoService;
public class TblAdmOprInfoServiceImpl implements TblAdmOprInfoService{
	
	public TblAdmOprInfoServiceImpl(TblAdmOprInfoDAO tblAdmOprInfoDAO) {
		this.tblAdmOprInfoDAO = tblAdmOprInfoDAO;
	}
	public TblAdmOprInfoServiceImpl() {
	}
	private TblAdmOprInfoDAO tblAdmOprInfoDAO;	
	public TblAdmOprInfoDAO getTblAdmOprInfoDAO() {
		return tblAdmOprInfoDAO;
	}
	public void setTblAdmOprInfoDAO(TblAdmOprInfoDAO tblAdmOprInfoDAO) {
		this.tblAdmOprInfoDAO = tblAdmOprInfoDAO;
	}
	public TblAdmOprInfo selectById(String oprId) throws SQLException{
		return tblAdmOprInfoDAO.selectById(oprId);
	}

}
