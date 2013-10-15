package cmt.getData.action;


import org.apache.struts2.ServletActionContext;


//import org.apache.struts.action.ActionForm;
//import org.apache.struts.action.ActionForward;
//import org.apache.struts.action.ActionMapping;

//import cmt.db.po.TblAdmOprInfo;
import cmt.getData.po.TblAdmOprInfo;
import cmt.getData.services.TblAdmOprInfoService;
//import cmt.struts.action.base.SafeAction;

import com.huateng.common.ComFunc;
import com.huateng.common.Constants;
//import com.huateng.common.DescUtil;
import com.huateng.common.EncryptionTool;
import com.huateng.common.Rescode;
import com.huateng.common.RescodeMapping;
import com.huateng.common.UserSessionInfo;
import com.huateng.exception.ComException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * ADMLOGIN01:操作员登录
 * @author Bobby.Jin
 *
 */
public class ADMLOGIN01 extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	final public static String TXNCODE4LOG = "ADMLOGIN01";
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private String brhId;
	private String oprId;
	private String oprPwd;
	private TblAdmOprInfoService tblAdmOprInfoservice;
	public TblAdmOprInfoService getTblAdmOprInfoservice() {
		return tblAdmOprInfoservice;
	}
	public void setTblAdmOprInfoservice(TblAdmOprInfoService tblAdmOprInfoservice) {
		this.tblAdmOprInfoservice = tblAdmOprInfoservice;
	}
	public String getBrhId() {
		return brhId;
	}
	public void setBrhId(String brhId) {
		this.brhId = brhId;
	}
	public String getOprId() {
		return oprId;
	}
	public void setOprId(String oprId) {
		this.oprId = oprId;
	}
	public String getOprPwd() {
		return oprPwd;
	}
	public void setOprPwd(String oprPwd) {
		this.oprPwd = oprPwd;
	}
	public String login() throws ComException{
		return safeExecute();
	}
	public String safeExecute() throws ComException {
		try {
			// 获取页面内容 
			//String brhId = request.getParameter("brhId").trim();
			//String oprId = request.getParameter("oprId").trim();
			//String oprPwd = request.getParameter("oprPwd").trim();

			log.info("机构号:[" + brhId + "] || 操作员号:[" + oprId + "]");

			String tmpOprId = ComFunc.fillString(oprId, ' ', 10, true);
			// 获取BO
			/*I_ADMLOGIN01_BO admLogin01BO = (I_ADMLOGIN01_BO) ContextUtil
					.getBean("ADMLOGIN01BO");*/
			// 根据oprId, brhId分别获得oprInfo, brhInfo
			TblAdmOprInfo oprInfo = tblAdmOprInfoservice.selectById(tmpOprId);
			// 判断机构号和操作员号是否存在
			if (null == oprInfo)
				throw new ComException("柜员不存在");
			// 输入的机构号与表中的操作员的机构号不符
			// 验密
			EncryptionTool.init("7D1E7A731D081811");
			byte[] oprPwdByte = EncryptionTool.encrypt_pwd(oprPwd);
			String oprPassword = new String(oprPwdByte);
			String pwd = oprInfo.getOprPwd().toString().trim();
			if (!pwd.equals(oprPassword))
				throw new ComException("密码错误");
			// 操作员状态为“无效”
			if (oprInfo.getOprStat().trim().equals("0")) {
				throw new ComException("操作员无效");
			}
			//设置UserSessionInfo
            UserSessionInfo userSessionInfo = new UserSessionInfo();
            userSessionInfo.setOprId(oprId);
            userSessionInfo.setOprType(oprInfo.getOprType().trim());
            userSessionInfo.setOprNm(oprInfo.getOprNm().trim());
            userSessionInfo.setOprContTelno(oprInfo.getOprContTelno());
            userSessionInfo.setBrhId(oprInfo.getBrhId().trim());
            userSessionInfo.setBrhNm(oprInfo.getBrhName().trim());
            userSessionInfo.setRoleId(oprInfo.getRoleId().trim());
            /*request.getSession().setAttribute("OPR_INFO", userSessionInfo);
            request.setAttribute(Constants.TXNSTA, Constants.CONS_SUCCESS);
            request.setAttribute(Constants.RSPCODE, Rescode.RES_SUCCESS);
            request.setAttribute(Constants.MESSAGE, RescodeMapping.getRescodeDesc(Rescode.RES_SUCCESS));*/
            ServletActionContext.getContext().getSession().put("OPR_INFO",userSessionInfo);
            ServletActionContext.getContext().getSession().put(Constants.TXNSTA, Constants.CONS_SUCCESS);
            ServletActionContext.getContext().getSession().put(Constants.RSPCODE, Rescode.RES_SUCCESS);
            ServletActionContext.getContext().getSession().put(Constants.MESSAGE, RescodeMapping.getRescodeDesc(Rescode.RES_SUCCESS));
			log.info("登录成功！");
			return SUCCESS;
		} catch (ComException e) {
			//log.info(DescUtil.getDesc(e.getErrCd()), e);
			log.info(e.getErrMessage()+","+e.getMessage());
			//ComFunc.passRequestParams(request);
			/*request.setAttribute(Constants.ERRMSG, e.getMessage());
			request.setAttribute(Constants.TXNSTA, Constants.CONS_FAILURE);
            request.setAttribute(Constants.RSPCODE, Rescode.RES_FAILURE);*/
			ServletActionContext.getContext().getSession().put(Constants.ERRMSG, e.getMessage());
			ServletActionContext.getContext().getSession().put(Constants.TXNSTA, Constants.CONS_FAILURE);
			ServletActionContext.getContext().getSession().put(Constants.RSPCODE, Rescode.RES_FAILURE);
			return INPUT;
		} catch (Exception e) {
			log.error("柜员登录出错", e);
			//ComFunc.passRequestParams(request);
			/*request.setAttribute(Constants.ERRMSG, "系统错 ");
			request.setAttribute(Constants.TXNSTA, Constants.CONS_FAILURE);
            request.setAttribute(Constants.RSPCODE, Rescode.RES_FAILURE);*/
            ServletActionContext.getContext().getSession().put(Constants.ERRMSG, "系统错 ");
            ServletActionContext.getContext().getSession().put(Constants.TXNSTA, Constants.CONS_FAILURE);
            ServletActionContext.getContext().getSession().put(Constants.RSPCODE, Rescode.RES_FAILURE);
			return ERROR;
		}
	}
}