package cmt.getData.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cmt.getData.services.ComTbldtlService;

import com.huateng.exception.ComException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class GETTEXT122 extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3518408235378225592L;
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
		String begDt = request.getParameter("begDt");
		String endDt = request.getParameter("endDt");
		String[] rowNm = {"手机号码","注册时间"};
		String fileName = "";
		String sql = "";
		String title = begDt+"至"+endDt+fileName;
		if(payType.equals("01")){
			sql = "select distinct trim(MBL_NO)手机号码, max(SIGN_DT) 注册时间 from TBL_APP_QPAG_DTL where SIGN_DT between '"+begDt+"' and '"+endDt+"' and (CAN_DT > '"+endDt+"' or trim(CAN_DT) is null) GROUP BY MBL_NO";
			fileName = "绑定快捷支付用户数据";
		}else if(payType.equals("02")){
			sql = "select distinct trim(PHONE_CD), max(REG_DT) from TBL_APP_OPEN_CANCEL_DTL where REG_DT between '"+begDt+"' and '"+endDt+"' and (trim(CANCEL_DT) is null or CANCEL_DT >  '"+endDt+"') and ACCOUNT_TYPE = '100' group by PHONE_CD";
			fileName = "开通手机支付主账户用户数据";
		}else{
			sql = "select distinct trim(PHONE_CD), max(REG_DT) from TBL_APP_OPEN_CANCEL_DTL where REG_DT between '"+begDt+"' and '"+endDt+"' and (trim(CANCEL_DT) is null or CANCEL_DT >  '"+endDt+"') and ACCOUNT_TYPE = '101' group by PHONE_CD";
			fileName = "开通手机钱包用户数据";
		}
		
		logger.info("本次执行的sql语句为：" + sql);
		// 生成数据文件
		CommonAction action = new CommonAction();
		action.comAction(fileName, sql, comTbldtlService, rowNm, rowNm, title);
	}
}
