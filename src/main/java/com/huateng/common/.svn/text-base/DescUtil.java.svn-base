package com.huateng.common;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DescUtil {

	 private static final String BUNDLE_NAME = "Rescode";

	 private static final ResourceBundle RESOURCE_BUNDLE =
	        ResourceBundle.getBundle(BUNDLE_NAME);

	 private DescUtil() {}

	 public static String getDesc(String key) {
	     try {
	    	 return RESOURCE_BUNDLE.getString(key);
	     } catch (MissingResourceException e) {
	    	 return key ;
	     }
	 }
}
