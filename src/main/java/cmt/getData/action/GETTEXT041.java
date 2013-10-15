package cmt.getData.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cmt.dealdata.DataToObject;
import cmt.getData.services.ComTbldtlService;

import com.huateng.common.ComFunc;
import com.huateng.exception.ComException;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class GETTEXT041 {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ComTbldtlService comTbldtlService;
	public ComTbldtlService getComTbldtlService() {
		return comTbldtlService;
	}
	public void setComTbldtlService(ComTbldtlService comTbldtlService) {
		this.comTbldtlService = comTbldtlService;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void safeExecute() throws ComException, Exception{
		String nowDate = ComFunc.getLocalDate();
		String sql="select sum(SVC_BAL) sum ,count(distinct trim(MOBILE)) count "
				+"from TBL_APP_MARKETING_TOOL_DTL "
				+"where to_number(SVC_BAL) > 0  " 
				+"and INVALID_DT >= '"+nowDate+"' "
				+"and MK_TYPE = '0'  " 
				+"and trim(ISSUER_NO) = '09'"
				+"and SVC_STAT not in ('R', 'P', 'E', 'D', 'T')";
		logger.info("本次执行的sql:"+sql);
		String sumSave =  "";
		String count =  "";
		String[] params={"SUM","COUNT"};
		List<Map> list= (List<Map>) comTbldtlService.selectExample(sql);
		try{
			if(list.size()!=0){
				logger.info("******************************数据查询结束*******************************");
				DataToObject datatoobject = new DataToObject();
				List<Object[]> data = datatoobject.dealData(list, params);
				sumSave=data.get(0)[0].toString();
				count=data.get(0)[1].toString();
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json");
				response.getWriter().write("{\"sumSave\":'"+sumSave+"',\"count\":'"+count+"'}");
				response.getWriter().close();
			}else{
				logger.info("******************************所查数据为空*******************************");
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json");
				response.getWriter().write("{\"sumSave\":'null',\"count\":'null'}");
				response.getWriter().close();
			}
		}catch(Exception e){		
			logger.error("查询出错:"+e.getMessage());
		}
	}
}
