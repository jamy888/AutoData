package com.huateng.util;

import org.springframework.context.ApplicationContext;

import com.huateng.common.Module;
import com.huateng.common.Rescode;
import com.huateng.exception.ComException;

public class ContextUtil {
	private static ApplicationContext context;

	public static ApplicationContext getContext() {
		return context;
	}

	public static Object getBean(String beanId) throws ComException {
		Object bean = context.getBean(beanId);
		if (bean == null)
			throw new ComException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, "bean id = " + bean + " not found");
		return bean;
	}

	/**
	 * author cloud li
	 * **/
	public static <T> T getBean(String beanId,Class<T> classType){
		//return (T)context.getBean(beanId);
		return classType.cast(context.getBean(beanId));
	}

	public static void setContext(ApplicationContext ctx) {
		context = ctx;
	}
/*
	public static ServiceBeanFactory getServiceBeanFactory() {
		return (ServiceBeanFactory) getContext().getBean("ServiceBeanFactory");
	}

	public static ServicePoolFactory getServicePoolFactory() {
		return (ServicePoolFactory) getContext().getBean("ServicePoolFactory");
	}
*/
	/**
	 * ��ʼ�� ServicePool
	 *
	 * @throws Exception
	 */
	/*
	public static void initServicePool() throws Exception {
		ServicePoolFactory factory = getServicePoolFactory();
		Iterator it = factory.getPoolMap().keySet().iterator();
		String name;
		ServiceSoftReferenceObjectPool pool;
		while (it.hasNext()) {
			name = (String) it.next();
			pool = (ServiceSoftReferenceObjectPool) factory.getPoolMap().get(name);
			System.out.println("*************init pool : " + name + " begin *****************");
			pool.init();
			System.out.println("*************init pool : " + name + " end   *****************");
		}
	}
	*/

}
