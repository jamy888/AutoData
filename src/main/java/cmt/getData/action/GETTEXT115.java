package cmt.getData.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import cmt.getData.services.ComTbldtlService;
import com.huateng.common.ComFunc;
import com.huateng.exception.ComException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class GETTEXT115 extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4941454617153287574L;
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
		
		String wallet = request.getParameter("wallet");
		String begDt = request.getParameter("begDt");
		String endDt = request.getParameter("endDt");
		String nowDate = ComFunc.getLocalDate();
		String fileName = "手机支付历史交易记录";
		String title = begDt+"至"+endDt+"手机支付历史交易记录";
		String[] rowNm = {"手机号码","交易时间","交易金额","交易类型","主账户注册时间"};
		String sql = "";
		if(wallet.equals("01")){
			sql = "select t.SPO_NO     as 手机号码,  "+
					"       t.ACCOUNT_DT as 交易时间,  "+
					"       t.EXPEND_AMT as 交易金额,  "+
					"       t.TRANS_TYPE as 交易类型,  "+
					"       tt.REG_DT    as 主账户注册时间   "+
					"  from TBL_APP_MOBPAY_ACCOUNT_DTL t  "+
					" INNER JOIN (select phone_cd, max(reg_dt) as REG_DT "+
					"               from TBL_APP_OPEN_CANCEL_DTL  "+
					"              where (trim(CANCEL_DT) is null or CANCEL_DT > '"+nowDate+"') "+
					"                and PROVINCE = '09'                                     "+
					"                and phone_cd in (select phone_cd                        "+
					"                                   from TBL_APP_OPEN_CANCEL_DTL         "+
					"                                  where (trim(CANCEL_DT) is null or     "+
					"                                        CANCEL_DT > '"+nowDate+"') "+
					"                                    and PROVINCE = '09'                 "+
					"                                    and ACCOUNT_TYPE = '101')           "+
					"                and ACCOUNT_TYPE = '100'                                "+
					"              group by phone_cd) tt                                     "+
					"    on t.spo_no = tt.phone_cd    "+
					" where t.ACCOUNT_DT between '"+begDt+"' and '"+endDt+"' "+
					"   and t.ACCOUNT_TYPE = '100'  "+
					"   and t.REVERED_TRANS_LOG = 'N'   "+
					"   and t.REVERED_LOG = 'N' "+
					"   and t.TRANS_TYPE IN ('01', '34', '02', '03', '05', '24', '25', '26')  "+
					"   and t.BUSSINESS_TYPE NOT in ('0801', '0701', '0019', '0119')  "+
					"   and t.BALOFPAY_FLAG in ('C', 'D') "+
					"   and t.EXPEND_AMT > 0 ";
		}else if(wallet.equals("02")){
			sql = "select t.SPO_NO     as 手机号码,  "+
					"       t.ACCOUNT_DT as 交易时间,  "+
					"       t.EXPEND_AMT as 交易金额,  "+
					"       t.TRANS_TYPE as 交易类型,  "+
					"       tt.REG_DT    as 主账户注册时间   "+
					"  from TBL_APP_MOBPAY_ACCOUNT_DTL t  "+
					" INNER JOIN (select phone_cd, max(reg_dt) as REG_DT "+
					"               from TBL_APP_OPEN_CANCEL_DTL  "+
					"              where (trim(CANCEL_DT) is null or CANCEL_DT > '"+nowDate+"') "+
					"                and PROVINCE = '09'                                     "+
					"                and phone_cd not in (select phone_cd                        "+
					"                                   from TBL_APP_OPEN_CANCEL_DTL         "+
					"                                  where (trim(CANCEL_DT) is null or     "+
					"                                        CANCEL_DT > '"+nowDate+"') "+
					"                                    and PROVINCE = '09'                 "+
					"                                    and ACCOUNT_TYPE = '101')           "+
					"                and ACCOUNT_TYPE = '100'                                "+
					"              group by phone_cd) tt                                     "+
					"    on t.spo_no = tt.phone_cd    "+
					" where t.ACCOUNT_DT between '"+begDt+"' and '"+endDt+"' "+
					"   and t.ACCOUNT_TYPE = '100'  "+
					"   and t.REVERED_TRANS_LOG = 'N'   "+
					"   and t.REVERED_LOG = 'N' "+
					"   and t.TRANS_TYPE IN ('01', '34', '02', '03', '05', '24', '25', '26')  "+
					"   and t.BUSSINESS_TYPE NOT in ('0801', '0701', '0019', '0119')  "+
					"   and t.BALOFPAY_FLAG in ('C', 'D') "+
					"   and t.EXPEND_AMT > 0 ";
		}else{
			sql = "select t.SPO_NO     as 手机号码,  "+
					"       t.ACCOUNT_DT as 交易时间,  "+
					"       t.EXPEND_AMT as 交易金额,  "+
					"       t.TRANS_TYPE as 交易类型,  "+
					"       tt.REG_DT    as 主账户注册时间   "+
					"  from TBL_APP_MOBPAY_ACCOUNT_DTL t  "+
					" INNER JOIN (select phone_cd, max(reg_dt) as REG_DT "+
					"               from TBL_APP_OPEN_CANCEL_DTL  "+
					"              where (trim(CANCEL_DT) is null or CANCEL_DT > '"+nowDate+"') "+
					"                and PROVINCE = '09'                                     "+
					"                and ACCOUNT_TYPE = '100'                                "+
					"              group by phone_cd) tt                                     "+
					"    on t.spo_no = tt.phone_cd    "+
					" where t.ACCOUNT_DT between '"+begDt+"' and '"+endDt+"' "+
					"   and t.ACCOUNT_TYPE = '100'  "+
					"   and t.REVERED_TRANS_LOG = 'N'   "+
					"   and t.REVERED_LOG = 'N' "+
					"   and t.TRANS_TYPE IN ('01', '34', '02', '03', '05', '24', '25', '26')  "+
					"   and t.BUSSINESS_TYPE NOT in ('0801', '0701', '0019', '0119')  "+
					"   and t.BALOFPAY_FLAG in ('C', 'D') "+
					"   and t.EXPEND_AMT > 0 ";
		}
		logger.info("本次执行的sql语句为：" + sql);

		// 生成数据文件
		CommonAction action = new CommonAction();
		action.comAction(fileName, sql, comTbldtlService, rowNm, rowNm, title);
	}
}
