package cmt.getData.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cmt.getData.services.ComTbldtlService;

import com.huateng.exception.ComException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class GETTEXT113 extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2360103126976497879L;
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
		String merId = request.getParameter("merId");
		String begDt = request.getParameter("begDt");
		String endDt = request.getParameter("endDt");
		
		String fileName = "用户主账户购买某商户商品记录";
		String title="用户购买商户"+merId+"商品记录";
		String[] rowNm={"手机号码","交易总金额","红包消费金额","消费日期","现金消费金额"};
		String sql ="select MOBILE_NO             手机号码,  "+
				"       ORDER_AMT             交易总金额,  "+
				"       THIS_CLEAN_REDPAK_AMT 红包消费金额,"+
				"       account_dt            消费日期, "+
				"       t                     现金消费金额  "+
				"  from (select MOBILE_NO,  "+
				"               ORDER_AMT,  "+
				"               sum(out_amt) as t,  "+
				"               sum(in_amt) as tt, "+
				"               THIS_CLEAN_REDPAK_AMT, "+
				"               account_dt  "+
				"          from (select MOBILE_NO,  "+
				"                       ORDER_AMT, "+
				"                       THIS_CLEAN_CASH_AMT as out_amt, "+
				"                       '0' as in_amt, "+
				"                       THIS_CLEAN_REDPAK_AMT,  "+
				"                       account_dt  "+
				"                  from TBL_APP_REMOTEMER_COLD_DTL   "+
				"                 where MER_ID = '"+merId+"' "+
				"                   and ACCOUNT_DT between '"+begDt+"' and '"+endDt+"'"+
				"                   and RECORD_STA = '1'  "+
				"                   and TRANS_TYPE = '02' "+
				"                   and to_number(THIS_CLEAN_CASH_AMT) > 0  "+
				"                union all   "+
				"                select MOBILE_NO, "+
				"                       ORDER_AMT,  "+
				"                       '0' as out_amt,                                      "+
				"                       THIS_CLEAN_CASH_AMT as in_amt,                       "+
				"                       THIS_CLEAN_REDPAK_AMT,                               "+
				"                       account_dt                                           "+
				"                  from TBL_APP_REMOTEMER_COLD_DTL                           "+
				"                 where MER_ID = '"+merId+"' "+
				"                   and ACCOUNT_DT between '"+begDt+"' and '"+endDt+"'"+
				"                   and RECORD_STA = '1'                                     "+
				"                   and TRANS_TYPE = '20'                                    "+
				"                   and INNER_ORDER_ID in                                    "+
				"                       (select INNER_ORDER_ID                               "+
				"                          from TBL_APP_REMOTEMER_COLD_DTL                   "+
				"                         where MER_ID = '"+merId+"' "+
				"                           and ACCOUNT_DT between '"+begDt+"' and '"+endDt+"'"+
				"                           and RECORD_STA = '1'                             "+
				"                           and TRANS_TYPE = '02'))                          "+
				"         group by MOBILE_NO, ORDER_AMT, THIS_CLEAN_REDPAK_AMT, account_dt)  "+
				" where t > tt                                                               ";

		logger.info("本次执行的sql语句为：" + sql);

		// 生成数据文件
		CommonAction action = new CommonAction();
		action.comAction(fileName, sql, comTbldtlService, rowNm, rowNm, title);
	}
}
