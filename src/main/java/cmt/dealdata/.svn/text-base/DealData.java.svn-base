package cmt.dealdata;

import java.util.List;

import com.huateng.commonQry.bean.RowData;
import com.huateng.query.bean.FieldData;
import com.huateng.query.bean.Result;

public class DealData {
	
	public static Result assembleData(List<Object[]> data, String[] rowNm) {
		RowData rowData = null;
		Result result = (new Result(null, data));
		for (int i = 0; i < data.size(); i++) {
			rowData = new RowData();

			for (int j = 0; j < rowNm.length; j++) {
				rowData.addField(rowNm[j],new FieldData(data.get(i)[j]==null?" ":data.get(i)[j].toString().trim(),data.get(i)[j]==null?" ":data.get(i)[j].toString().trim()));
			}
			result.addRow(rowData);
		}
		return result;
	}
}
