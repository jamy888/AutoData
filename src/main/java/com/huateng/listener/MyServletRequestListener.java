package com.huateng.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import cmt.method.ManageSession;

public class MyServletRequestListener implements ServletRequestListener{

	public void requestDestroyed(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		ManageSession.setRequest(null);
	}

	public void requestInitialized(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		ManageSession.setRequest(event.getServletRequest());
	}

}
