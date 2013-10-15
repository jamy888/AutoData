package cmt.getData.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cmt.getData.services.ComTbldtlService;

import com.huateng.exception.ComException;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class GETTEXT031 {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ComTbldtlService comTbldtlService;
	public ComTbldtlService getComTbldtlService() {
		return comTbldtlService;
	}
	public void setComTbldtlService(ComTbldtlService comTbldtlService) {
		this.comTbldtlService = comTbldtlService;
	}
	
	public void safeExecute() throws ComException, Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String mobile = request.getParameter("mobile");
		String[] rowNm = {"活动编号","活动名称","面额","余额","领用时间","使用时间","失效时间"};
		String title = "截至目前用户"+mobile+"拥有所有电子券详细信息";
		String fileName = "用户拥有的电子券详细信息";
		String sql = "select MKACT_NO   as 活动编号, "
				+"ACT_NAME   as 活动名称, "
				+"FACE_VALUE as 面额, "
				+"SVC_BAL    as 余额, "
				+"ACC_TM     as 领用时间, "
				+"USE_TM     as 使用时间, "
				+"INVALID_DT as 失效时间 "
				+"from TBL_APP_MARKETING_TOOL_DTL "
				+"where MOBILE = '"+mobile+"' "
				+"and MK_TYPE = '0' "
				+"and TRANSFER_GIV = '0' "
				+"and ISSUER_NO = '09' "
				+"and SVC_STAT not in ('R', 'P', 'D', 'T')";
		
		logger.info("本次执行的sql:"+sql);
		
		CommonAction ca = new CommonAction();
		ca.comAction(fileName, sql, comTbldtlService, rowNm, rowNm, title);
	}
}
