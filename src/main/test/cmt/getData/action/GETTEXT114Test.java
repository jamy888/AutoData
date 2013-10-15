package cmt.getData.action;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

import com.opensymphony.xwork2.ActionProxy;

public class GETTEXT114Test extends StrutsSpringTestCase{
	
	private GETTEXT114 action;
	private ActionProxy proxy;
	@Test
	public void testGETTEXT114Action1() throws Exception{
		request.setParameter("payType", "01");//01网银缴话费02主账户缴话费
		request.setParameter("limitSum", "01");//01限制02不限制
		request.setParameter("sum", "30");
		request.setParameter("begDt", "20130101");
		request.setParameter("endDt", "20130831");
		proxy = getActionProxy("/com/GETTEXT114.action");
		action=(GETTEXT114)proxy.getAction();
		String result = proxy.execute();
		assertEquals(null, result);
		assertNotNull(action.execute());
	}
	
	@Test
	public void testGETTEXT114Action2() throws Exception{
		request.setParameter("payType", "02");//01网银缴话费02主账户缴话费
		request.setParameter("limitSum", "01");//01限制02不限制
		request.setParameter("sum", "30");
		request.setParameter("begDt", "20120701");
		request.setParameter("endDt", "20120730");
		proxy = getActionProxy("/com/GETTEXT114.action");
		action=(GETTEXT114)proxy.getAction();
		String result = proxy.execute();
		assertEquals(null, result);
		assertNotNull(action.execute());
	}
}
