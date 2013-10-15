package cmt.getData.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cmt.getData.services.ComTbldtlService;

import com.huateng.exception.ComException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class GETTEXT111 extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1490082700407755202L;
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
		String title = "生活(公共事业)缴费记录";
		String fileName=title;
		String[] rowNm={"手机号码","缴费金额","缴费时间"};
		String sql = "select SPO_NO as 手机号码, EXPEND_AMT 缴费金额, ACCOUNT_DT 缴费时间" +
				" from TBL_APP_MOBPAY_ACCOUNT_DTL " +
				"where ACCOUNT_DT between '"+begDt+"' and '"+endDt+"' " +
				"AND ACCOUNT_TYPE = '100' " +
				"and REVERED_TRANS_LOG = 'N' " +
				"and REVERED_LOG = 'N' and " +
				"TRANS_TYPE = '26' and " +
				"BUSSINESS_TYPE NOT in ('0801', '0701', '0019', '0119') " +
				"and BALOFPAY_FLAG in ('C', 'D') " +
				"order by ACCOUNT_DT desc";
		logger.info("本次执行的sql语句为："+sql);
		
		//生成数据文件
		CommonAction action = new CommonAction();
		action.comAction(fileName, sql, comTbldtlService, rowNm, rowNm, title);
	}
}
