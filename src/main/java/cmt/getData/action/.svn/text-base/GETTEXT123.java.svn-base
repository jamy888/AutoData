package cmt.getData.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cmt.getData.services.ComTbldtlService;

import com.huateng.exception.ComException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class GETTEXT123 extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5491749733720513746L;
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
		String[] rowNm = {"内部用户号","手机号码"};
		String fileName = "手机支付帐户使用用户";
		String title = begDt+"至"+endDt+fileName;
		String sql = "select distinct trim(x2.IP_ID) 内部用户号, "+ 
				"                decode(x1.PHONE_CD, null, 'NULL', x1.PHONE_CD) 手机号码   "+
				"  from TBL_APP_OPEN_CANCEL_DTL x1   "+
				" right join (SELECT DISTINCT IP_ID  "+
				"               FROM (SELECT INNER_USER_NO IP_ID  "+
				"                       FROM TBL_APP_MOBPAY_ACCOUNT_DTL  "+
				"                      WHERE ((TRANS_TYPE IN    "+
				"                            ('02', '04', '05', '24', '25', '26') AND  "+
				"                            BALOFPAY_FLAG = 'D') OR   "+
				"                            (TRANS_TYPE IN ('03', '15', '54', '55') AND  "+
				"                            BALOFPAY_FLAG = 'C') OR  "+
				"                            (TRANS_TYPE = '34' AND BALOFPAY_FLAG = 'D' AND   "+
				"                            ACCOUNT_TYPE = '100')) "+
				"                        AND ACCOUNT_DT BETWEEN '"+begDt+"' AND '"+endDt+"'  "+
				"                        AND REVERED_TRANS_LOG = 'N'  "+
				"                        AND REVERED_LOG = 'N'    "+
				"                     UNION ALL  "+
				"                     SELECT INNER_USER_NO IP_ID   "+
				"                       FROM TBL_APP_MOBWALLET_ACCOUNT_DTL  "+
				"                      WHERE ((TRANS_TYPE IN ('02', '08') AND EXPEND_AMT > 0) OR   "+
				"                            (TRANS_TYPE = '06' AND INCOME_AMT > 0)) "+
				"                        AND REVERED_TRANS_LOG = 'N'  "+
				"                        AND REVERED_LOG = 'N'  "+
				"                        AND ACCOUNT_DT BETWEEN '"+begDt+"' AND '"+endDt+"'  "+
				"                     UNION ALL   "+
				"                     SELECT NVL(B.IP_ID, A.SUB_AC) IP_ID                          "+
				"                       FROM TBL_APP_ECMAC_DTL A, TBL_APP_ECMCRD_DTL B  "+
				"                      WHERE ((A.TX_TYP = '22' AND A.DR_AMT > 0) OR   "+
				"                            (A.TX_TYP IN ('47', '48', '49', '50', '51') AND  "+
				"                            A.CR_AMT > 0))   "+
				"                        AND A.RVS_TX_TYP = 'N'  "+
				"                        AND A.RVS_TX_FLG = 'N'    "+
				"                        AND A.AC_DT BETWEEN '"+begDt+"' AND '"+endDt+"'  "+
				"                        AND A.SUB_AC = B.SUB_AC(+)   "+
				"                     UNION ALL    "+
				"                     SELECT INNER_USER_NO IP_ID  "+
				"                       FROM TBL_APP_MARKETING_TOOL_USEDTL   "+
				"                      WHERE ACCOUNT_DT BETWEEN '"+begDt+"' AND '"+endDt+"'  "+
				"                        AND USE_MARK IN ('1', '2')   "+
				"                        AND PROD_TYPE = '0' "+
				"                        AND TRANS_STA = 'S'   "+
				"                      GROUP BY INNER_USER_NO, INNER_ORDER_NO, ORDER_AMT  "+
				"                     HAVING ORDER_AMT = SUM(USE_AMT)  "+
				"                     UNION ALL  "+
				"                     SELECT NVL(B.USR_NO, A.INNER_USER_ID) IP_ID  "+
				"                       FROM (SELECT PAYFEE_USER_ID, INNER_USER_ID  "+
				"                               FROM TBL_APP_PAY_FEE_DTL    "+
				"                              WHERE PAYFEE_PAYSTAT = '2'   "+
				"                                AND MOBILE_MER_ID = '0'  "+
				"                                AND ORDER_DT BETWEEN '"+begDt+"' AND '"+endDt+"') A, "+
				"                            (SELECT * "+
				"                               FROM TBL_APP_USEINF_DTL   "+
				"                              WHERE USR_STS = '0') B    "+
				"                      WHERE A.PAYFEE_USER_ID = B.MBL_NO(+))) x2  "+
				"    on x1.INTERNEL_USER_CD = x2.IP_ID ";
		
		logger.info("本次执行的sql语句为：" + sql);
		// 生成数据文件
		CommonAction action = new CommonAction();
		action.comAction(fileName, sql, comTbldtlService, rowNm, rowNm, title);
	}
}
