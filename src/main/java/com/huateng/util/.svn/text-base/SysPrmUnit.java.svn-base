package com.huateng.util;

import java.util.HashMap;

import com.huateng.common.Module;
import com.huateng.common.Rescode;
import com.huateng.exception.ComException;


/**
 * Title: SysPrmUnit
 * Description:
 * Copyright: Copyright (c) 2007
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2007-8-20
 */
public class SysPrmUnit {

	public final static String PARAM_ID = "param_id";
	public final static String MAGIC_ID = "magic_id";

	private static HashMap<String,HashMap<String,String>> sysPrmMap = new HashMap<String,HashMap<String,String>>();

	private static HashMap<String,String> sysPrmDefMap = new HashMap<String,String>();

	/**
	 * 增加SysPrm记录
	 *
	 * 存放参数：key: param_id; value: HashMap(key: magic_id; value: param_value_tx)
	 *
	 * @param param_id
	 * @param magic_id
	 * @param param_value_tx
	 */
	public static void addRecord(String param_id, String magic_id,
			String param_value_tx) {
		HashMap<String,String> subMap;
		if (sysPrmMap.containsKey(param_id)) {
			subMap =  sysPrmMap.get(param_id);
			subMap.put(magic_id, param_value_tx);
		} else {
			subMap = new HashMap<String,String>();
			subMap.put(magic_id, param_value_tx);
			sysPrmMap.put(param_id, subMap);
		}
	}
	/**
	 * add sys_param_def record
	 * @param param_id
	 * @param default_val_tx
	 */
	public static void addDefRecord(String param_id,String default_val_tx){
		if(!sysPrmDefMap.containsKey(param_id)){
			sysPrmDefMap.put(param_id, default_val_tx);
		}
	}

	/**
	 * 获取参数值(不取默认值）
	 *
	 * @param param_id
	 * @param magic_id
	 * @return
	 * @throws ComException
	 */
	public static String getParamValueTxNoDef(String param_id, String magic_id)
			throws ComException {
		HashMap<String,String> subMap;
		if (sysPrmMap.containsKey(param_id)) {
			subMap = sysPrmMap.get(param_id);
			if (subMap.containsKey(magic_id)) {
				return (String) subMap.get(magic_id);
			} else {
				throw new ComException(Module.SYSTEM_MODULE,
						Rescode.SYSPRMUNIT_GETPARAM_NODEF_NO_PARAM_ID,
						"param_id : " + param_id + " no existed");
			}
		} else {
			throw new ComException(Module.SYSTEM_MODULE,
					Rescode.SYSPRMUNIT_GETPARAM_NODEF_NO_MAGIC_ID,
					"param_id : " + param_id + " magic_id : " + magic_id
							+ " no existed");
		}
	}

	/**
	 * 获取参数值（可取默认值)
	 *
	 * @param param_id
	 * @param magic_id
	 * @return
	 * @throws ComException
	 */
	public static String getParamValueTx(String param_id, String magic_id)
			throws ComException {
		HashMap<String,String> subMap;
		if (sysPrmMap.containsKey(param_id)) {
			subMap =  sysPrmMap.get(param_id);
			if (subMap.containsKey(magic_id)) {
				return (String) subMap.get(magic_id);
			} else {
				if (sysPrmDefMap.containsKey(param_id)) {
					return (String) sysPrmDefMap.get(param_id);
				} else {
					throw new ComException(Module.SYSTEM_MODULE,
							Rescode.SYSPRMUNIT_GETPARAM_NO_PARAM_ID,
							"param_id : " + param_id + " no existed");
				}
			}
		} else {
			if (sysPrmDefMap.containsKey(param_id)) {
				return (String) sysPrmDefMap.get(param_id);
			} else {
				throw new ComException(Module.SYSTEM_MODULE,
						Rescode.SYSPRMUNIT_GETPARAM_NO_MAGIC_ID,
						"param_id : " + param_id + " magic_id : " + magic_id
								+ " no existed");
			}
		}
	}

	/**
	 * 设置参数值
	 * @param param_id
	 * @param magic_id
	 * @param value
	 * @throws ComException
	 */
	public static synchronized void updateParamValueTx(String param_id, String magic_id, String value)throws ComException {
		HashMap<String,String> subMap;
		if (sysPrmMap.containsKey(param_id)) {
			subMap =  sysPrmMap.get(param_id);
			subMap.put(magic_id, value);
		} else {
			subMap = new HashMap<String,String>();
			subMap.put(magic_id, value);
			sysPrmMap.put(param_id, subMap);
		}
	}
}
