package cmt.getData.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cmt.getData.services.ComTbldtlService;

import com.huateng.exception.ComException;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class GETTEXT022 {
	
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
		String use = request.getParameter("use");
		String mktId = request.getParameter("mktId");
		String begDt = request.getParameter("begDt");
		String endDt = request.getParameter("endDt");
		String[] rowNm = {"抵价券编号","领用人手机号","领用时间","使用时间","面额","余额"};
		String title = "";
		String sql = "select trim(SVC_NO)     抵价券编号, "
				+ "trim(MOBILE)     领用人手机号, " 
				+ "trim(ACC_TM)     领用时间, "
				+"trim(USE_TM)     使用时间, "
				+ "trim(FACE_VALUE) 面额, " 
				+ "trim(SVC_BAL)    余额 "
				+ "from TBL_APP_MARKETING_TOOL_DTL "
				+ "where MK_TYPE = '0' "
				+"and TRANSFER_GIV = '0' "
				+"and MKACT_NO = '"+mktId+"' "
				+"and substr(ACC_TM, 1, 8) between '"+ begDt + "' and '" + endDt + "' ";
		if(use.equals("01")){
			title="活动"+mktId+"下发红包中使用完的数据明细";
			sql =sql + "and SVC_STAT in ('U', 'D', 'T')";
		}else if(use.equals("02")){
			title="活动"+mktId+"下发红包中部分使用的数据明细";
			sql = sql+" and to_number(SVC_BAL) > 0 and to_number(SVC_BAL) < to_number(FACE_VALUE) and SVC_STAT not in ('T') ";
		}else if(use.equals("03")){
			title="活动"+mktId+"下发红包中从未使用的数据明细";
			sql = sql + " and SVC_STAT not in ('D', 'T') and to_number(SVC_BAL) = to_number(FACE_VALUE) ";
		}else if(use.equals("04")){
			title="活动"+mktId+"下发红包使用数据明细";
		}else{
			logger.info("请选择活动下发红包使用情况");
		}
		logger.info(sql);
		 CommonAction ca = new CommonAction();
		 ca.comAction(title, sql, comTbldtlService, rowNm, rowNm, title);
	}
}
