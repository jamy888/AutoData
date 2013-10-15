package cmt.getData.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import cmt.getData.services.ComTbldtlService;
import com.huateng.exception.ComException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class GETTEXT011 extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String TXNCODE4LOG="GETTEXT011";
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
		String transType = request.getParameter("transType");
		String begDt = request.getParameter("begDt");
		String endDt = request.getParameter("endDt");
		String title = "";
		String sql = "SELECT MOBILE_NO, ACCOUNT_DT, SUM(USE_AMT) SUMUSE_AMT "
				+ "FROM TBL_APP_MARKETING_TOOL_USEDTL "
				+ "WHERE ACCOUNT_DT BETWEEN '"+begDt+"' AND '"+endDt+"' "
				+ "AND USE_MARK IN ('1', '2')" + "AND PROD_TYPE = '0' "
				+ "AND TRANS_STA = 'S' "
				+ "GROUP BY MOBILE_NO, INNER_ORDER_NO, ORDER_AMT, ACCOUNT_DT ";
		if(transType.equals("01")){
			title = "手机支付纯电子券消费数据";
			sql = sql + " HAVING ORDER_AMT = SUM(USE_AMT) ";
		}else if(transType.equals("02")){
			title = "电子券消费记录用户数据";
		}else{
			logger.error("交易类型出错！");
		}
		String[] rowNm = {"手机号","交易时间","电子券交易金额"};
		String[] params = {"MOBILE_NO","ACCOUNT_DT","SUMUSE_AMT"};
		String fileName = title;
		if(begDt.equals("")||begDt.equals(null) ||endDt.equals("")||endDt .equals(null)){
			logger.info("**********输入的时间有空值**********");
			//return ERROR;
		}
		logger.info(sql);
		//生成数据文件
		CommonAction action = new CommonAction();
		action.comAction(fileName, sql, comTbldtlService, params, rowNm, title);		
	}
	
	
}
