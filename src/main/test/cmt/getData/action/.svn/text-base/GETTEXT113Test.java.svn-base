package cmt.getData.action;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

import com.opensymphony.xwork2.ActionProxy;

public class GETTEXT113Test extends StrutsSpringTestCase{
	private GETTEXT113 action;
	private ActionProxy proxy;
	@Test
	public void testGETTEXT113Action() throws Exception{
		request.setParameter("merId", "888009953110155");
		request.setParameter("begDt", "20130101");
		request.setParameter("endDt", "20131231");
		proxy = getActionProxy("/com/GETTEXT113.action");
		action=(GETTEXT113)proxy.getAction();
		String result = proxy.execute();
		assertEquals(null, result);
		assertNotNull(action.execute());
	}
}
