package cmt.getData.services;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

//import cmt.getData.po.TblAppMarketingToolUsedtl;
public interface TblAppMarketingToolUsedtlService {
	public List<Map> selectExample(String sql) throws SQLException;
}
