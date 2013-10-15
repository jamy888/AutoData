package cmt.getData.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cmt.getData.services.ComTbldtlService;

import com.huateng.exception.ComException;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class GETTEXT042 {
	
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
		String getOrUse = request.getParameter("getOrUse");
		String begDt = request.getParameter("begDt");
		String endDt = request.getParameter("endDt");
		String sql="";
		String title="";
		String fileName="";
		String[] rowNm = {"时间(月)","总金额"};
		String[] params={"时间","总金额"};
		if(getOrUse.equals("01")){
			sql="select substr(ACC_TM,1,6) 时间,sum(FACE_VALUE) 总金额  "
					+"from TBL_APP_MARKETING_TOOL_DTL  where "
					+"substr(ACC_TM,1,8) between '20110601' and '20120630'  "
					+"and MK_TYPE = '0'  "
					+"and TRANSFER_GIV='0'  "
					+"and trim(ISSUER_NO) = '09' "
					+"group by substr(ACC_TM,1,6) order by 1";
			title=begDt+"到"+endDt+"每月发放电子券金额";
			fileName="上海移动每月发放电子券金额";
		}else if(getOrUse.equals("02")){
			sql="select substr(ACCOUNT_DT, 1, 6) 时间, sum(to_number(USE_AMT)) 总金额 " +
					"from TBL_APP_MARKETING_TOOL_USEDTL " +
					"where substr(ACCOUNT_DT, 1, 8) between '"+begDt+"' and '"+endDt+"' " +
					"and USE_MARK in ('1', '2') " +
					"and PROD_TYPE = '0' " +
					"and TRANS_STA = 'S'  " +
					"and BUSSINESS_ACCEPT_CHANNEL <> 'LPS'	 group by substr(ACCOUNT_DT, 1, 6)	 " +
					"order by 1";
			title=begDt+"到"+endDt+"每月使用电子券金额";
			fileName="上海移动用户每月使用电子券金额";
		}
		logger.info("本次执行sql语句为:"+sql);

		CommonAction ca = new CommonAction();
		ca.comAction(fileName, sql, comTbldtlService, params, rowNm, title);
	}
}
