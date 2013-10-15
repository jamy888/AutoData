package com.huateng.common;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class RescodeMapping {

	 private static final String BUNDLE_NAME = "Rescode";

	 private static final ResourceBundle RESOURCE_BUNDLE =
	        ResourceBundle.getBundle(BUNDLE_NAME);

	 private RescodeMapping() {}

	 public static String getRescodeDesc(String key) {
	     try {
	    	 return RESOURCE_BUNDLE.getString(key);
	     } catch (MissingResourceException e) {
	    	 return key ;
	     }
	 }

	 public static String getRescodeDesc(String moduleName, String resCode){
	     try {
             return RESOURCE_BUNDLE.getString(moduleName) + " ： "
                 +RESOURCE_BUNDLE.getString(resCode) + " ！";
         } catch (MissingResourceException mre) {
             return moduleName + resCode ;
         } catch (Exception e) {
             return moduleName + resCode ;
         }
	 }

	   public static String getModuleName(String moduleName,String rspDesc){
	         try {
	             return RESOURCE_BUNDLE.getString(moduleName) + " ： "
	                 + rspDesc + " ！";
	         } catch (MissingResourceException mre) {
	             return moduleName + rspDesc ;
	         } catch (Exception e) {
	             return moduleName + rspDesc ;
	         }
	     }

}
