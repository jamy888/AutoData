package com.huateng.commonQry.bean;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.huateng.common.Module;
import com.huateng.common.Rescode;
import com.huateng.exception.ComException;
import com.huateng.query.bean.FieldData;


/**
 * @author Roger.li
 */
public class RowData {

	/** memeber variable: row map. */
	private LinkedHashMap rowMap = null;

	public RowData(){
		rowMap = new LinkedHashMap();
	}

	public LinkedHashMap getRowMap() {
		return rowMap;
	}

	public void setRowMap(LinkedHashMap rowMap) {
		this.rowMap = rowMap;
	}

	/**
	 * add Field
	 * @param fId
	 * @param fd
	 */
	public void addField(String fId,FieldData fd){
		this.rowMap.put(fId, fd);
	}

	/**
	 * remove Field
	 * @param fId
	 */
	public void rmField(String fId){
		this.rowMap.remove(fId);
	}

	/**
	 * getter fieldData by field id
	 * @param fId
	 * @return
	 * @throws AppException
	 */
	public FieldData getField(String fId)throws ComException{
		FieldData fieldData = (FieldData)rowMap.get(fId);
		if(fieldData == null){
			throw new ComException(Module.SYSTEM_MODULE,
					Rescode.ROWDATA_GETFILED_NO_EXISTED,
					"Field Id : " + fId +" no existed");
		}
		return fieldData;
	}
}
