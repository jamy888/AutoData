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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
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
public class ConstantsBean {
	/**
	 * option
	 */
	private static Map<String,Map<String,String>> option;
	/**
	 *静态同步map与properties 文件
	 */
	static{
		option = new HashMap<String,Map<String,String>>();
		init();
	}
	/**
	 * 初始化Map option 遍历所有key
	 *
	 * @return
	 * @param
	 * @Exception
	 */
	 private static void init(){
		//获取Constants.properties 中所有key
		Enumeration keys = ConstantsDictionary.getAllKeys();
		while(keys.hasMoreElements()){
			String key = (String)keys.nextElement();
			String[] keyArray = key.split("\\.");
			if(keyArray.length!=2){
				continue;
			}
			String priKey = keyArray[0];
			String subKey = keyArray[1];
			Map<String,String> map;
			if(!option.containsKey(priKey)){
				map = new TreeMap<String,String>();
				option.put(priKey,map);
			}else{
				map = (TreeMap<String,String>)option.get(priKey);
			}
				map.put(subKey,ConstantsDictionary.get(key));

		}
		System.out.println(option.size());
		for(int n = 0;n<option.size();n++){
			System.out.println(option.keySet().iterator().next());
		}
	}
/*	*//**
	 * 获取value
	 * @param key
	 * @return
	 * @return
	 * @param
	 * @Exception
	 *//*
	private static String getConstantsValue(String key){
		return ConstantsDictionary.get(key);
	}*/
	/**
	 *  返回由properties生成的Map对象
	 * @return
	 * @return
	 * @param
	 * @Exception
	 */
	public static Map<String,Map<String,String>> getMap(){
		return option;
	}
	/**
	 * 获取一级key
	 * @param defultKey
	 * @return
	 * @return
	 * @param
	 * @Exception
	 */
	public static String getPriKey(String defultKey){
		if(defultKey == null||defultKey.equals("")){
			return null;
		}else{
			String[] keys = defultKey.split("\\.");
			if(keys.length !=2){
				return defultKey;
			}
			String priKey = keys[0];
			return priKey;
		}
	}
	/**
	 * 获取次级key
	 * @param defultKey
	 * @return
	 * @return
	 * @param
	 * @Exception
	 */
	public static String getSubKey(String defultKey){
		if(defultKey == null||defultKey.equals("")){
			return null;
		}else{
			defultKey=defultKey.replace('.', ',');
			String[] keys = defultKey.split(",");
			if(keys.length !=2){
				return defultKey;
			}
			String subKey = keys[1];
			return subKey;
		}
	}
	/**
	 * 输入key.key返回 在properties中所对应的数值
	 * @return
	 * @return
	 * @param
	 * @Exception
	 */
	public static String getDataByOneParam(String oneKey){
		if(oneKey==null||oneKey.length()==0){
			return null;
		}else{
			return ConstantsDictionary.get(oneKey);
		}
	}
	/**
	 * 通过输入两个参数，返回在properties中所对应的数值
	 * @param firstKey
	 * @param secondKey
	 * @return
	 * @return
	 * @param
	 * @Exception
	 */
	public static String getDataByTwoParam(String firstKey,String secondKey){
		return ConstantsDictionary.getConstansValue(firstKey, secondKey);
	}
}
