package com.huateng.common;

/**
 * Title: the system property
 * Description: the system property
 * Copyright: Copyright (c) 2006
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.0, 2006-12-25
 */
public class SystemDProperty {
	/** memeber variable: production_mode. */
	public final static String PRODUCTION_MODE = "COM.HUATENG.PRODUCTION_MODE";
	public final static String JOLT_ADDRESS = "COM.HUATENG.JOLT_ADDRESS";
	/**
	 * get system property value
	 * @param key
	 * @return
	 */
	public static String getDSystemProperty(String key){
		return System.getProperty(key);
	}
	/**
	 * is production mode
	 * @return
	 */
	public static boolean isProductionMode(){
		String prod = getDSystemProperty(PRODUCTION_MODE);
		if(prod==null||prod.equalsIgnoreCase(ComCons.TRUE_STRING)){
			return true;
		}
		return false;
	}
}
