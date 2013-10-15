package cmt.getData.dao;

import cmt.getData.po.TblAppMarketingToolUsedtl;
import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TblAppMarketingToolUsedtlDAOImpl implements TblAppMarketingToolUsedtlDAO {
    
    private SqlMapClient sqlMapClient;

    public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	public TblAppMarketingToolUsedtlDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }
    public TblAppMarketingToolUsedtlDAOImpl() {
	}
    
	public void insert(TblAppMarketingToolUsedtl record) throws SQLException {
        sqlMapClient.insert("CMST_TBL_APP_MARKETING_TOOL_USEDTL.abatorgenerated_insert", record);
    }
	
	public List selectExample(List str)throws SQLException{
		return sqlMapClient.queryForList("CMST_TBL_APP_MARKETING_TOOL_USEDTL.abatorgenerated_selectExample", str);
	}
	public List<Map> sqlQuery(String sql){
		try {
			return sqlMapClient.queryForList("COM_TBL.sqlQuery",sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}