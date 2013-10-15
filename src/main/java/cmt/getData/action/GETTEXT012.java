package cmt.getData.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cmt.getData.services.ComTbldtlService;

import com.huateng.exception.ComException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class GETTEXT012 extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4206050846386362572L;
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
		String begDt = request.getParameter("begDt");
		String endDt = request.getParameter("endDt");
		int rowNum = Integer.parseInt(request.getParameter("rowNum"));
		
		String title = begDt+"到"+endDt+"上海电子券消费额前"+rowNum+"名的商户数据";
		String sql = "select *"
				+" from (select MER_ID 商户号,"
				+"  MER_NAME 商户名称,"
				+" sum(THIS_MER_TRANS_AMT) 商户交易总金额,"
				+" sum(THIS_CLEAN_REDPAK_AMT) 电子券消费总额,"
				+" sum(THIS_CLEAN_CASH_AMT) 现金消费总额"
				+" from TBL_APP_REMOTEMER_COLD_DTL"
				+" where RECORD_STA = '1'"
				+" and TRANS_ATTR = '0'"
				+" and ACCOUNT_DT between '"+begDt+"' and '"+endDt+"'"
				+" and INNER_ORDER_ID in"
				+" (select INNER_ORDER_ID"
				+" from TBL_APP_REMOTEMER_COLD_DTL"
				+" where TRANS_TYPE in ('02', '25')"
                	+" minus"
                	+" select INNER_ORDER_ID"
                	+" from TBL_APP_REMOTEMER_COLD_DTL"
                	+" where TRANS_TYPE = '20')"
                	+" group by MER_ID,MER_NAME"
                	+" order by sum(THIS_CLEAN_REDPAK_AMT) desc)"
                	+" WHERE ROWNUM <= "+rowNum;
		//String[] rowNm = {"电子券消费总额","现金消费总额","商户交易总金额","商户号","商户名称"};
		String[] params = {"商户号","商户名称","商户交易总金额","电子券消费总额"," 现金消费总额"};
		//String fileName = title;
		logger.info(sql);
		//生成文件
		CommonAction ac = new CommonAction();
		ac.comAction(title, sql, comTbldtlService, params, params, title);
	}

}
