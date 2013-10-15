package cmt.getData.dao;

import cmt.getData.po.TblAdmOprInfo;
import java.sql.SQLException;

public interface TblAdmOprInfoDAO {
    
    void insert(TblAdmOprInfo record) throws SQLException;
    TblAdmOprInfo selectById(String oprId) throws SQLException;
}