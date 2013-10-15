package cmt.getData.action;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

import com.opensymphony.xwork2.ActionProxy;

public class GETTEXT121Test extends StrutsSpringTestCase{
	
	private GETTEXT121 action;
	private ActionProxy proxy;
	@Test
	public void testGETTEXT121Action() throws Exception {
		request.setParameter("begDt", "20130101");
		request.setParameter("endDt", "20131231");
		proxy = getActionProxy("/com/GETTEXT121.action");
		action=(GETTEXT121)proxy.getAction();
		String result = proxy.execute();
		assertEquals(null, result);
		assertNotNull(action.execute());
	}
}
