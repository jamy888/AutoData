package cmt.getData.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cmt.getData.services.ComTbldtlService;

import com.huateng.exception.ComException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class GETTEXT131 extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8144720027972162761L;
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
		String fileName = "电子现金账户总充值金额(联名卡)";
		String title = begDt+"至"+endDt+fileName;
		String[] rowNm = {"联名卡帐号","总金额"};
		String sql = "SELECT distinct trim(SUB_AC) 联名卡帐号,sum(CR_AMT) 总金额 FROM TBL_APP_ECMAC_DTL WHERE RVS_TX_FLG = 'N' AND RVS_TX_TYP = 'N' AND CR_AMT <> 0 AND AC_DT between '"+begDt+"' and '"+endDt+"' AND BUS_TYP IN ('0600', '0700') group by SUB_AC";
		logger.info("本次执行的sql语句为：" + sql);
		// 生成数据文件
		CommonAction action = new CommonAction();
		action.comAction(fileName, sql, comTbldtlService, rowNm, rowNm, title);
	}
}
