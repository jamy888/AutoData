package cmt.getData.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cmt.getData.services.ComTbldtlService;

import com.huateng.exception.ComException;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class GETTEXT023 {
	
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
		String useFlag = request.getParameter("useFlag");
		String title = "";
		//String fileName = "";
		String sql = "";
		String[] rowNm={};
		if(useFlag.equals("01")){
			String[] rownm = {"手机号码","最近一次使用电子券时间","最近一次使用电子券金额","是否有过转让行为","是否有过转赠行为"};
			rowNm=rownm;
			title="2011年9月1日至今用户最近一次使用电子券情况";
			sql = "select x.mobile 手机号码, "
					+"x.last_use_tm 最近一次使用电子券时间, "
					+"x.last_use_amt 最近一次使用电子券金额, "
					+"decode(y.SVC_STAT, 'T', 'Y', 'N') as 是否有过转让行为, "
					+"decode(y.SVC_STAT, 'D', 'Y', 'N') as 是否有过转赠行为 "
					+"from (select trim(p.MOBILE) as mobile, "
					+"t.max_ustm as last_use_tm, "
					+"sum(p.FACE_VALUE - p.SVC_BAL) as last_use_amt "
					+"from TBL_APP_MARKETING_TOOL_DTL p "
					+"inner join (select trim(MOBILE) as mobile, max(USE_TM) as max_ustm "
					+"from TBL_APP_MARKETING_TOOL_DTL "
					+"where trim(ISSUER_NO) = '09' "
					+"and MKACT_NO not in ('1104060003','1106090001','1107120001','1106020003','1010270126')  "
					+"and MK_TYPE = '0' "
					+"and TRANSFER_GIV = '0' "
	                +"and substr(ACC_TM, 1, 8) >= '20110901' "
	                +"group by MOBILE) t "
	                +"on trim(p.MOBILE) = t.MOBILE "
	                +"and p.USE_TM = t.max_ustm "
	                +"group by p.MOBILE, t.max_ustm) x "
	                +"left join (select distinct (trim(MOBILE)) as mobile, SVC_STAT "
	                +"from TBL_APP_MARKETING_TOOL_DTL "
	                +"where SVC_STAT in ('D', 'T')) y "
	                +"on x.mobile = y.mobile";
		}else if(useFlag.equals("01")){
			String[] rownm={"手机号码","发放红包总金额"};
			title="2011年9月1日至今用户没有使用过上海移动下发电子券情况";
			rowNm=rownm;
			sql = "select trim(s.MOBILE) as mobile, sum_face_value "
					+"from (select trim(MOBILE) as mobile,max(USE_TM) as max_ustm,sum(FACE_VALUE) as sum_face_value "
					+"from TBL_APP_MARKETING_TOOL_DTL "
					+"where trim(ISSUER_NO) = '09' "
					+"and MKACT_NO not in ('1104060003','1106090001','1107120001','1106020003','1010270126') "
					+"and MK_TYPE = '0' "
					+"and TRANSFER_GIV = '0' "
					+"and substr(ACC_TM, 1, 8) >= '20110901' "
					+"group by MOBILE) s "
					+"where trim(s.max_ustm) is null";
		}
		logger.info("本次执行的SQL语句:"+sql);
		
		CommonAction ca = new CommonAction();
		ca.comAction(title, sql, comTbldtlService, rowNm, rowNm, title);
	}
}
