package cmt.getData.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cmt.dealdata.CnZipFileDemo;
import cmt.dealdata.DataToObject;
import cmt.dealdata.DeleteFileOrDir;
import cmt.dealdata.Report;
import cmt.getData.services.ComTbldtlService;

import com.huateng.exception.ComException;
import com.huateng.util.SysParam;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class CommonAction {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 功能:生产数据文件夹和zip文件
	 * @param fileName 文件夹名字
	 * @param sql 需要执行的sql语句
	 * @param params 执行的sql语句的对应字段
	 * @param rowNm 生成文件的字段
	 * @param title 文件内容标题
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void comAction(String fileName,String sql,ComTbldtlService comTbldtlService,String[] params,String[] rowNm,String title) throws Exception,ComException{
		File file = new File(SysParam.getSysParam("RPT_PATH")+"\\"+fileName);
		if(file.exists()){
			DeleteFileOrDir hfc = new DeleteFileOrDir();
			hfc.deleteDirectory(SysParam.getSysParam("RPT_PATH")+"\\"+fileName);
			file.mkdirs();
		}else{
			file.mkdir();
		}
		
		int pageNum = 0;
		pageNum = (comTbldtlService.selectExample(sql).size()%20000==0?comTbldtlService.selectExample(sql).size()/20000:comTbldtlService.selectExample(sql).size()/20000+1);
		if(pageNum!=0){
			try{
				logger.info("本次数据提取需要"+pageNum+"次查询数据库!!");
				for(int i = 0;i<pageNum;i++){
					List<Map> list = (List<Map>) comTbldtlService.selectExample(sql, i*20000, 20000);
					DataToObject datatoobject = new DataToObject();
					List<Object[]> data = datatoobject.dealData(list, params);
					Report report = new Report(data,rowNm,title,fileName);
					report.run();
					logger.info("第"+(i+1)+"次查询完成！");
				}
				
				//将生成的文件列表压缩成ZIP文件
				CnZipFileDemo zt = new CnZipFileDemo();
				try {
					zt.zip(SysParam.getSysParam("RPT_PATH")+"\\"+fileName, SysParam.getSysParam("RPT_PATH")+"\\"+fileName+".zip","GBK");//压缩文件
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				logger.info("***********数据文件生成结束！！！！！！************");
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json");
				response.getWriter().write("{\"fileName\":'"+fileName+"'}");
				response.getWriter().close();
			}catch(Exception e){
				e.printStackTrace();
				logger.error(e.getMessage());
			}
			
		}else{
			logger.info("******************************所查数据为空*******************************");
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().write("{\"fileName\":'null'}");
			response.getWriter().close();
		}
	}

}
