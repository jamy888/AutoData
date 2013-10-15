package cmt.getData.action;



import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import cmt.getData.services.ComTbldtlService;

import com.huateng.common.ComFunc;
import com.huateng.exception.ComException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class GETTEXT021 extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 71743135136609889L;
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
		String mobilePay = request.getParameter("mobilePay");
		String active = request.getParameter("active");
		String abegDt = request.getParameter("abegDt");
		String aendDt = request.getParameter("aendDt");
		String begDt = request.getParameter("begDt");
		String endDt = request.getParameter("endDt");
		String[] rowNm = {"手机号码","电子券余额","到期时间"};
		String title = "电子券到期数据";
		String fileName ="未剔除未开通手机支付(活跃无限制)"+ title;
		String nowDate = ComFunc.getLocalDate();
		String[] params = {"MOBILE","SVC_BAL","INVALID_DT"};
		
		//支付活跃查询语句sql1
		String sql1 = "select SPO_NO as MOBILE "
				+" from TBL_APP_MOBPAY_ACCOUNT_DTL "
				+" where ACCOUNT_DT between '"+abegDt+"' and '"+aendDt+"' "
				+" AND ACCOUNT_TYPE = '100' "
				+" and REVERED_TRANS_LOG = 'N' "
				+" and REVERED_LOG = 'N' "
				+" and TRANS_TYPE IN ('01', '34', '02', '03', '05', '24', '25', '26') "
				+" and BUSSINESS_TYPE NOT in ('0801', '0701', '0019', '0119') "
				+" and BALOFPAY_FLAG in ('C', 'D') "
				+" union all "
				+" select MOBILE_NO  MOBILE "
				+"from TBL_APP_MARKETING_TOOL_USEDTL "
				+" where USE_MARK in ('1', '2') "
				+"  and PROD_TYPE = '0' "
				+" and TRANS_STA = 'S' "
				+" and ACCOUNT_DT between '"+abegDt+"' and '"+aendDt+"' "
				+" and BUSSINESS_ACCEPT_CHANNEL <> 'LPS' "
				+" group by MOBILE_NO, INNER_ORDER_NO, ORDER_AMT "
				+" having ORDER_AMT = sum(USE_AMT)";
		//开通手机支付业务用户查询语句sql2
		String sql2 = "select distinct trim(PHONE_CD) MOBILE from TBL_APP_OPEN_CANCEL_DTL where (trim(CANCEL_DT) is null or CANCEL_DT > '"+nowDate+"') and ACCOUNT_TYPE = '100'";
		//电子券到期sql3
		String sql = "select MOBILE,SVC_BAL,INVALID_DT from TBL_APP_MARKETING_TOOL_DTL where INVALID_DT between '"+begDt+"' and '"+endDt+"' and to_number(SVC_BAL) > 0 and MK_TYPE = '0' and SVC_STAT not in ('R', 'P', 'D', 'T','E')";
				
		if(active=="01"&&mobilePay =="01"){//有活跃sql1&&剔除未开通手机支付业务-sql2
			sql=sql + "and MOBILE in ("+sql1+"minus"+sql2+")";
			fileName ="剔除未开通手机支付(有活跃)"+ title;
		}else if(active=="02"&&mobilePay =="01"){//无活跃-sql1&&剔除未开通手机支付业务-sql2
			sql=sql + "and MOBILE not in ("+sql1+"union all"+sql2+")";
			fileName ="剔除未开通手机支付(无活跃)"+ title;
		}else if(active=="01"&&mobilePay =="02"){//有活跃sql1&&不剔除未开通手机支付业务sql2
			sql=sql + "and MOBILE in ("+sql1+")";
			fileName ="未剔除未开通手机支付(有活跃)"+ title;
		}else if(active=="02"&&mobilePay =="02"){ //无活跃-sql&&不剔除开通手机支付业务sql2
			sql=sql + "and MOBILE not in ("+sql1+")";
			fileName ="未剔除未开通手机支付(无活跃)"+ title;
		}else if(active=="03"&&mobilePay=="01"){//活跃不限&&剔除开通手机支付业务sql2
			sql=sql + "and MOBILE in ("+sql2+")";
			fileName ="未剔除未开通手机支付(活跃无限制)"+ title;
		}/*else if(active=="03"&&mobilePay=="02"){//活跃不限&&不剔除开通手机支付业务sql2
			//sql=sql ;
		}*/
		logger.info(sql);
		
		
		CommonAction ca = new CommonAction();
		ca.comAction(fileName, sql, comTbldtlService, params, rowNm, title);
	}
		
}
