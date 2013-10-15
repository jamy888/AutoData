package cmt.getData.action;

//import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

import com.opensymphony.xwork2.ActionProxy;

public class DownLoadActionTest extends StrutsSpringTestCase{
	private DownLoadAction action;
	private ActionProxy proxy;
	@Test
	public void testDownLoadAction() throws Exception{
		//ServletActionContext.getContext().getSession().put("filename", "手机支付纯电子券消费数据_20130909174601");
		request.setParameter("filename", "手机支付纯电子券消费数据_20130911144833");
		proxy = getActionProxy("/cmt/download.action");
		action=(DownLoadAction)proxy.getAction();
		String result = proxy.execute();
		assertEquals("success", result);
		assertNotNull(action.execute());
	}
}
