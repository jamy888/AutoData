package cmt.getData.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cmt.getData.services.ComTbldtlService;

import com.huateng.exception.ComException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class GETTEXT114 extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7582354219271870276L;
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
		String payType = request.getParameter("payType");
		String limitSum = request.getParameter("limitSum");
		String sum = request.getParameter("sum");
		String begDt = request.getParameter("begDt");
		String endDt = request.getParameter("endDt");
		
		String fileName = "缴话费记录数据";
		String title="";
		String[] rowNm={"手机号码","缴费日期","缴费金额"};
		String sql = "";
		if(payType.equals("01")&&limitSum.equals("01")){
			title="网银累计缴话费"+sum+"元(包含)以上客户数据";
			sql="select trim(PAYFEE_USER_ID) 手机号码,ORDER_DT 缴费日期,PAYOFF_AMT 缴费金额 from TBL_APP_PAY_FEE_DTL where INNER_ORDER_STAT = '2' and SYSTEM_CHANNEL = 'CMPAY' and BUSSINESS_CHANNEL in ('CMPAY', 'NETAC', 'NETBK') and MOBILE_MER_ID = '0' and ORDER_DT between '"+begDt+"' and '"+endDt+"' group by trim(PAYFEE_USER_ID),ORDER_DT,PAYOFF_AMT having sum(PAYOFF_AMT)>="+sum;
		}else if(payType.equals("01")&&limitSum.equals("02")){
			title="网银缴话费客户数据";
			sql="select trim(PAYFEE_USER_ID) 手机号码,ORDER_DT 缴费日期,PAYOFF_AMT 缴费金额 from TBL_APP_PAY_FEE_DTL where INNER_ORDER_STAT = '2' and SYSTEM_CHANNEL = 'CMPAY' and BUSSINESS_CHANNEL in ('CMPAY', 'NETAC', 'NETBK') and MOBILE_MER_ID = '0' and ORDER_DT between '"+begDt+"' and '"+endDt+"'";
		}else if(payType.equals("02")&&limitSum.equals("01")){
			title="手机支付主账户累计缴话费"+sum+"元(包含)以上客户数据";
			sql="select SPO_NO as 手机号码,ACCOUNT_DT 缴费日期,EXPEND_AMT 缴费金额 from TBL_APP_MOBPAY_ACCOUNT_DTL where ACCOUNT_DT between '"+begDt+"' and '"+endDt+"' AND ACCOUNT_TYPE = '100' and REVERED_TRANS_LOG = 'N' and REVERED_LOG = 'N' and TRANS_TYPE = '24' and BUSSINESS_TYPE NOT in ('0801', '0701', '0019', '0119') and BALOFPAY_FLAG in ('C', 'D') group by SPO_NO,ACCOUNT_DT,EXPEND_AMT having sum(EXPEND_AMT)>="+sum;
		}else{
			title="主账户缴话费客户数据";
			sql="select SPO_NO as 手机号码,ACCOUNT_DT 缴费日期,EXPEND_AMT 缴费金额 from TBL_APP_MOBPAY_ACCOUNT_DTL where ACCOUNT_DT between '"+begDt+"' and '"+endDt+"' AND ACCOUNT_TYPE = '100' and REVERED_TRANS_LOG = 'N' and REVERED_LOG = 'N' and TRANS_TYPE = '24' and BUSSINESS_TYPE NOT in ('0801', '0701', '0019', '0119') and BALOFPAY_FLAG in ('C', 'D')";
		}
		logger.info("本次执行的sql语句为：" + sql);

		// 生成数据文件
		CommonAction action = new CommonAction();
		action.comAction(fileName, sql, comTbldtlService, rowNm, rowNm, title);
	}
}
