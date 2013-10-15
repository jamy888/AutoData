package cmt.getData.services;

import java.sql.SQLException;

import cmt.getData.po.TblAdmOprInfo;

public interface TblAdmOprInfoService {
	public TblAdmOprInfo selectById(String oprId) throws SQLException;

}
