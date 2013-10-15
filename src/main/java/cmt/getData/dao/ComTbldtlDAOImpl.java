package cmt.getData.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

public class ComTbldtlDAOImpl implements ComTbldtlDAO {
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	public ComTbldtlDAOImpl() {
	}
	public ComTbldtlDAOImpl(SqlMapClient sqlMapClient) {
		super();
		this.sqlMapClient = sqlMapClient;
	}
	
	public List sqlQuery(String sql) {
		try {
			return sqlMapClient.queryForList("COM_TBL.sqlQuery",sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public List sqlQuery(String sql,int current, int maxResult) {
		try {
			return sqlMapClient.queryForList("COM_TBL.sqlQuery", sql, current, maxResult);
			//return sqlMapClient.queryForList("COM_TBL.sqlQuery", current, maxResult);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public String sqlSum(String sql){
		try {
			return  sqlMapClient.queryForObject("COM_TBL.sqlSum", sql).toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public List<?> sqlMap(String sql) {
		try {
			return sqlMapClient.queryForList("COM_TBL.sqlSum", sql);
			//return sqlMapClient.queryForList("COM_TBL.sqlQuery", current, maxResult);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
