package cmt.method;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;




public class ManageSession {
	private static final ThreadLocal<HttpServletRequest> local = new ThreadLocal<HttpServletRequest>();

	public static void setRequest(ServletRequest servletRequest) {
		// TODO Auto-generated method stub
		local.set((HttpServletRequest)servletRequest);
	}  
	public static HttpServletRequest getRequest(){
		return local.get();
	}
	
}
