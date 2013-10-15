package cmt.getData.action;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import com.huateng.util.SysParam;
import com.opensymphony.xwork2.ActionSupport;

public class DownLoadAction extends ActionSupport {

    private static final long serialVersionUID = 1656950476675155655L;
    private String filename;
    private String directory;

    @Override
    public String execute() throws Exception {
    	return SUCCESS;
    }

    public InputStream getInputStream() throws Exception {
    	//filename = new String(filename.getBytes("gb2312"),"ISO8859-1");//中文乱码解决
    	this.directory=SysParam.getSysParam("RPT_PATH");
        //java.net.URLEncoder.encode(filename,"UTF-8");//解决中文乱码问题
    	String dir = directory +"\\"+ filename + ".zip";
    	System.out.println(dir);
        return new FileInputStream(dir);    //如果dir是绝对路径
        //return ServletActionContext.getServletContext().getResourceAsStream(dir);    //如果dir是Resource下的相对路径
    }
    
    

	public String getFilename() {
		try {
			return new String(this.filename.getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "获取文件名失败";
		}
	}
	public void setFilename(String filename) throws UnsupportedEncodingException{
		this.filename = filename;
		//this.filename=new String(filename.getBytes("ISO-8859-1"),"UTF-8");//解决文件中文名乱码问题
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
}
