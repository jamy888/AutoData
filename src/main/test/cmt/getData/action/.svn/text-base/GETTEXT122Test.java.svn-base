package cmt.getData.action;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

import com.opensymphony.xwork2.ActionProxy;

public class GETTEXT122Test extends StrutsSpringTestCase{
	
	private GETTEXT122 action;
	private ActionProxy proxy;
	@Test
	public void testGETTEXT122Action() throws Exception {
		request.setParameter("payType", "01");
		request.setParameter("begDt", "20130101");
		request.setParameter("endDt", "20131231");
		proxy = getActionProxy("/com/GETTEXT122.action");
		action=(GETTEXT122)proxy.getAction();
		String result = proxy.execute();
		assertEquals(null, result);
		assertNotNull(action.execute());
	}
}
