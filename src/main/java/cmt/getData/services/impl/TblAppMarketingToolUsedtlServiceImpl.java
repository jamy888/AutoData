package cmt.getData.services.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cmt.getData.dao.TblAppMarketingToolUsedtlDAO;
import cmt.getData.po.TblAppMarketingToolUsedtl;
import cmt.getData.services.TblAppMarketingToolUsedtlService;

public class TblAppMarketingToolUsedtlServiceImpl implements
		TblAppMarketingToolUsedtlService {
	private TblAppMarketingToolUsedtlDAO tblAppMarketingToolUsedtldao;

	public TblAppMarketingToolUsedtlDAO getTblAppMarketingToolUsedtldao() {
		return tblAppMarketingToolUsedtldao;
	}
	public void setTblAppMarketingToolUsedtldao(
			TblAppMarketingToolUsedtlDAO tblAppMarketingToolUsedtldao) {
		this.tblAppMarketingToolUsedtldao = tblAppMarketingToolUsedtldao;
	}
	public List<Map> selectExample(String sql) throws SQLException {
		List<Map> list = tblAppMarketingToolUsedtldao.sqlQuery(sql);
		return list;
	}

}
