/* @(#)
 *
 * Project:
 *
 * Modify Information:
 * =============================================================================
 *   Author         Date           Description
 *   ------------ ---------- ---------------------------------------------------
 *                                 first release
 *
 *
 * Copyright Notice:
 * =============================================================================
 *       Copyright 2008 Huateng Software, Inc. All rights reserved.
 *
 *       This software is the confidential and proprietary information of
 *       Shanghai HUATENG Software Co., Ltd. ("Confidential Information").
 *       You shall not disclose such Confidential Information and shall use it
 *       only in accordance with the terms of the license agreement you entered
 *       into with Huateng.
 *
 * Warning:
 * =============================================================================
 *
 */
package com.huateng.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * <p><strong>
 * Description:</strong>
 * </p>
 * <p><strong>
 * Copyright:</strong>&copy2008 Huateng
 * </p>
 * <p><strong>
 * Company:</strong>上海华腾软件系统有限公司
 * </p>
 * @author zhanglu
 * @version 1.0
 */
public class ConstantsDictionary {
	/**
	 * prop
	 */
	public static Properties prop = new Properties();
	/**
	 * log
	 */
	public static Logger log = Logger.getLogger(ConstantsDictionary.class);
	//读取Constants.properties文件
	static {
		InputStream is = ConstantsDictionary.class.getClassLoader().getResourceAsStream("BufferConstants.properties");
	    try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	/**
	 * 通过 key和value返回所对应的值
	 * @param key
	 * @param value
	 * @return
	 * @return
	 * @param
	 * @Exception
	 */
	public static String getConstansValue(String key,String value){
		String data = null;
		if(prop!=null){
			data = prop.getProperty(key+"."+value);
			return data;
		}
		return value;
	}
	/**
	 * 返回所有key
	 * @return
	 * @return
	 * @param
	 * @Exception
	 */
	public static Enumeration<Object> getAllKeys(){
		return prop.keys();
	}
	/**
	 * 根据key得到value
	 * @param key
	 * @return
	 * @return
	 * @param
	 * @Exception
	 */
	public static String get(String key) {
		if(key != null||prop.containsKey(key)){
			return prop.getProperty(key);
		}
		return key;

	}
}
