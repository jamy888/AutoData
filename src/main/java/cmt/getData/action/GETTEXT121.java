package cmt.getData.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import cmt.getData.services.ComTbldtlService;

import com.huateng.exception.ComException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class GETTEXT121 extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -474433758285660641L;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ComTbldtlService comTbldtlService;
	public ComTbldtlService getComTbldtlService() {
		return comTbldtlService;
	}
	public void setComTbldtlService(ComTbldtlService comTbldtlService) {
		this.comTbldtlService = comTbldtlService;
	}
	public void safeExecute() throws ComException, Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String begDt = request.getParameter("begDt");
		String endDt = request.getParameter("endDt");
		String fileName = "手机支付用户活跃数据";
		String title = begDt+"至"+endDt+fileName;
		String[] rowNm = {"手机号码","活跃时间"};
		String sql = "select IP_ID 手机号码, ACCOUNT_DT 活跃时间 "+
					"  from (SELECT SPO_NO IP_ID, ACCOUNT_DT    "+
					"          FROM TBL_APP_MOBPAY_ACCOUNT_DTL  "+
					"         WHERE ((TRANS_TYPE IN ('02', '04', '05', '24', '25', '26') AND "+
					"               BALOFPAY_FLAG = 'D') OR    "+
					"               (TRANS_TYPE = '05' AND BUSSINESS_TYPE = 'UMSS' AND  "+
					"               BALOFPAY_FLAG = 'C') OR    "+
					"               (TRANS_TYPE IN ('03', '15', '54', '55') AND  "+
					"               BALOFPAY_FLAG = 'C') OR  "+
					"               (TRANS_TYPE = '34' AND BALOFPAY_FLAG = 'D' AND   "+
					"               ACCOUNT_TYPE = '100'))  "+
					"           AND ACCOUNT_DT BETWEEN '"+begDt+"' AND '"+endDt+"' "+
					"           AND REVERED_TRANS_LOG = 'N'  "+
					"           AND REVERED_LOG = 'N'  "+
					"        union all  "+
					"        SELECT MOBILE_NO IP_ID, ACCOUNT_DT  "+
					"          FROM TBL_APP_MARKETING_TOOL_USEDTL  "+
					"         WHERE ACCOUNT_DT BETWEEN '"+begDt+"' AND '"+endDt+"' "+
					"           AND USE_MARK IN ('1', '2')  "+
					"           AND PROD_TYPE = '0'  "+
					"           AND TRANS_STA = 'S'   "+
					"           AND BUSSINESS_ACCEPT_CHANNEL <> 'LPS' "+
					"         GROUP BY MOBILE_NO, INNER_ORDER_NO, ORDER_AMT, ACCOUNT_DT "+
					"        HAVING ORDER_AMT = SUM(USE_AMT))   "+
					" group by IP_ID, ACCOUNT_DT ";
		logger.info("本次执行的sql语句为：" + sql);

		// 生成数据文件
		CommonAction action = new CommonAction();
		action.comAction(fileName, sql, comTbldtlService, rowNm, rowNm, title);
	}
}
