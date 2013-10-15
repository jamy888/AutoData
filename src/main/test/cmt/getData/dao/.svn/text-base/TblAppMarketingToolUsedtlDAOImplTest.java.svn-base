package cmt.getData.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class TblAppMarketingToolUsedtlDAOImplTest {
	@Autowired
	TblAppMarketingToolUsedtlDAO dao;
	@Test
	public void testSelectExample()throws Exception{
		String sql = "SELECT MOBILE_NO, ACCOUNT_DT, SUM(USE_AMT) "
				+ "FROM TBL_APP_MARKETING_TOOL_USEDTL "
				+ "WHERE ACCOUNT_DT BETWEEN '20130101' AND '20130131' "
				+ "AND USE_MARK IN ('1', '2')" + "AND PROD_TYPE = '0' "
				+ "AND TRANS_STA = 'S' "
				+ "GROUP BY MOBILE_NO, INNER_ORDER_NO, ORDER_AMT, ACCOUNT_DT "
				+ "HAVING ORDER_AMT = SUM(USE_AMT)";
		List data = dao.sqlQuery(sql);
		assertNotNull(data);
		//assertTrue(data);
	}
	
	@Test
	public void testAbvc(){}

	
}
