package cmt.getData.action;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

import com.opensymphony.xwork2.ActionProxy;

public class GETTEXT115Test extends StrutsSpringTestCase{
	
	private GETTEXT115 action;
	private ActionProxy proxy;
	@Test
	public void testGETTEXT115Action() throws Exception{
		request.setParameter("wallet", "03");//01是01否03不限制
		request.setParameter("begDt", "20110601");
		request.setParameter("endDt", "20130831");
		proxy = getActionProxy("/com/GETTEXT115.action");
		action=(GETTEXT115)proxy.getAction();
		String result = proxy.execute();
		assertEquals(null, result);
		assertNotNull(action.execute());
	}
}
