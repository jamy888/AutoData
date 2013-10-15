package cmt.getData.dao;

import cmt.getData.po.TblAdmOprInfo;
import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;
public class TblAdmOprInfoDAOImpl implements TblAdmOprInfoDAO {
    
    private SqlMapClient sqlMapClient;

    public TblAdmOprInfoDAOImpl() {
	}
	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	public TblAdmOprInfoDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }
    public void insert(TblAdmOprInfo record) throws SQLException {
        sqlMapClient.insert("DEV_POSP_TBL_ADM_OPR_INFO.abatorgenerated_insert", record);
    }
	public TblAdmOprInfo selectById(String oprId) throws SQLException {
		// TODO Auto-generated method stub
		TblAdmOprInfo key = new TblAdmOprInfo();
		key.setOprId(oprId);
		TblAdmOprInfo record = (TblAdmOprInfo)sqlMapClient.queryForObject("DEV_POSP_TBL_ADM_OPR_INFO.abatorgenerated_selectById", key);
		return record;
	}
}