package cmt.getData.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cmt.getData.services.ComTbldtlService;

import com.huateng.exception.ComException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class GETTEXT112 extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5496769534071756079L;
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
		String fileName = "主账户远程消费记录";
		String title=begDt+"至"+endDt+fileName;
		String[] rowNm={"手机号码","消费日期","消费金额"};
		String sql = "select SPO_NO as 手机号码, ACCOUNT_DT 消费日期, EXPEND_AMT 消费金额 " +
				"from TBL_APP_MOBPAY_ACCOUNT_DTL " +
				"where ACCOUNT_DT between '"+begDt+"' and '"+endDt+"' " +
				"AND ACCOUNT_TYPE = '100' and REVERED_TRANS_LOG = 'N' " +
				"and REVERED_LOG = 'N' and TRANS_TYPE IN ('02', '25') and " +
				"BUSSINESS_TYPE NOT in ('0801', '0701', '0019', '0119') " +
				"and BALOFPAY_FLAG in ('C', 'D') " +
				"order by ACCOUNT_DT desc";
		logger.info("本次执行的sql语句为："+sql);
		
		//生成数据文件
		CommonAction action = new CommonAction();
		action.comAction(fileName, sql, comTbldtlService, rowNm, rowNm, title);
	}
}
