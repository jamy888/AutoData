package com.huateng.util;

import java.util.LinkedHashMap;
import java.util.Map;

import com.huateng.common.ConstantsBean;

/**
 * Title: SystemDictionaryUnit
 * Description:存放数据字典信息
 * Copyright: Copyright (c) 2007
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2007-8-20
 */
public class SystemDictionaryUnit {
	//存放参数key : tbl_nm    value: HashMap(key : fld_nm value : HashMap(key : fld_val value : fld_desc ) )

	private static LinkedHashMap<String,LinkedHashMap<String,LinkedHashMap<String,String>>> sysDicMap =
		new LinkedHashMap<String,LinkedHashMap<String,LinkedHashMap<String,String>>>();

	/**
	 * add system dictionary record
	 * @param tbl_nm
	 * @param fld_nm
	 * @param fld_val
	 * @param fld_desc
	 */
	public static void addRecord(String tbl_nm,String fld_nm,String fld_val,String fld_desc){
		LinkedHashMap<String,LinkedHashMap<String,String>> subMap;
		LinkedHashMap<String,String> subSubMap;
		if(sysDicMap.containsKey(tbl_nm)){
			subMap = sysDicMap.get(tbl_nm);
			if(subMap.containsKey(fld_nm)){
				subSubMap = subMap.get(fld_nm);
				subSubMap.put(fld_val, fld_desc);
			}else{
				subSubMap = new LinkedHashMap<String,String>();
				subSubMap.put(fld_val, fld_desc);
				subMap.put(fld_nm, subSubMap);
			}
		}else{
			subSubMap = new LinkedHashMap<String,String>();
			subMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
			subSubMap.put(fld_val, fld_desc);
			subMap.put(fld_nm, subSubMap);
			sysDicMap.put(tbl_nm, subMap);
		}
	}

	/**
	 * 获取字段描述值
	 * @param tbl_nm
	 * @param fld_nm
	 * @param fld_val
	 * @return
	 * @throws DomainException
	 */
	public static String getFieldDesc(String tbl_nm,String fld_nm,String fld_val){
		LinkedHashMap<String,LinkedHashMap<String,String>> subMap;
		LinkedHashMap<String,String> subSubMap;
		//if(fld_val.trim()!=null)
		//	fld_val=fld_val.trim();
		if(sysDicMap.containsKey(tbl_nm)){
			subMap = sysDicMap.get(tbl_nm);
			if(subMap.containsKey(fld_nm)){
				subSubMap = subMap.get(fld_nm);
				if(subSubMap.containsKey(fld_val)){
					return subSubMap.get(fld_val);
				}else{
					return fld_val;
				}
			}else{
				return fld_val;
			}
		}else{
			return fld_val;
		}
	}

	/**
	 * �����ֵ�Ϸ���
	 * @param tbl_nm
	 * @param fld_nm
	 * @param fld_val
	 * @return
	 */
	public static String chkFieldDesc(String tbl_nm,String fld_nm,String fld_val){
		LinkedHashMap<String,LinkedHashMap<String,String>> subMap;
		LinkedHashMap<String,String> subSubMap;
		if(sysDicMap.containsKey(tbl_nm)){
			subMap = sysDicMap.get(tbl_nm);
			if(subMap.containsKey(fld_nm)){
				subSubMap = subMap.get(fld_nm);
				if(subSubMap.containsKey(fld_val)){
					return subSubMap.get(fld_val);
				}else{
					return null;
				}
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	/**
	 *
	 * @param tbl_nm
	 * @param fld_nm
	 * @return
	 */
	public static  LinkedHashMap<String,String> getAllFieldDesc(String tbl_nm,String fld_nm){
		LinkedHashMap<String,LinkedHashMap<String,String>> subMap;
		LinkedHashMap<String,String> subSubMap;
		if(sysDicMap.containsKey(tbl_nm)){
			subMap = sysDicMap.get(tbl_nm);
			if(subMap.containsKey(fld_nm)){
				subSubMap = subMap.get(fld_nm);
				return subSubMap;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	/**
	 *
	 * @param tbl_nm
	 * @return
	 */
    public static Map<String,String> getAllKeyDesc(String tbl_nm){
       // HashMap<String,String> subSubMap;
    	Map<String,Map<String,String>> option = ConstantsBean.getMap();
    	Map<String,String> phone = option.get(tbl_nm);
    	//subSubMap=(HashMap)phone;
    	if(phone.isEmpty()||phone==null){
    		return null;
    	}
    	return phone;
    	//Iterator it = phone.keySet().iterator();
    }
}