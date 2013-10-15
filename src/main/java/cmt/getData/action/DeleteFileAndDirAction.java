package cmt.getData.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.huateng.util.SysParam;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import cmt.dealdata.DeleteFileOrDir;

public class DeleteFileAndDirAction {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	
	
	public void safeExecute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String fileName = request.getParameter("filename");
		
		DeleteFileOrDir dfod = new DeleteFileOrDir();
		dfod.DeleteFolder(fileName);
		logger.info("文件夹"+fileName+"已经删除!");
		File file = new File(SysParam.getSysParam("RPT_PATH")+"\\"+fileName+".zip");
		if(file.exists()){
			file.delete();
			logger.info("文件"+fileName+".zip已经删除!");
		}
	}
}
