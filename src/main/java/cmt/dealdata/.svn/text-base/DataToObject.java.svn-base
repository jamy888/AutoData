package cmt.dealdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DataToObject {
	
	/**
	 * 功能:将数据集object按指定的序列params排序
	 * @param object 数据库查询结果数据集
	 * @param params  生成文件内容的列标题
	 * @return 处理好的数据
	 */
	public  List<Object[]> dealData(List<Map> object,String[] params){
		List<Object[]> list = new ArrayList<Object[]>();
		
		for(int i = 0;i<object.size();i++){
			Iterator<?>  it = ((Map<?, ?>)object.get(i)).entrySet().iterator();
			Object[] obj =  new Object[params.length];
			while(it.hasNext()){
				Entry<?, ?> entry = (Entry<?, ?>) it.next();
					for(int n=0;n<params.length;n++){
						if(entry.getKey().toString().trim().equals(params[n].trim())){
							obj[n]= (Object) entry.getValue();
						}
					}
			}
			list.add(obj);
		}
		return list;
	}
	
	/*public static void main(String[] args){
		String[] params = {"MOBILE","SVC_BAL","INVALID_DT"};
		Map map1 = new HashMap();
		map1.put("INVALID_DT", "20120831");
		map1.put("MOBILE", "13524616495");
		map1.put("SVC_BAL", "2.00");
		Map map2 = new HashMap();
		map2.put("INVALID_DT", "20120831");
		map2.put("MOBILE", "13901781688");
		map2.put("SVC_BAL", "9.00");
		List<Map> list = new ArrayList();
		list.add(map1);
		list.add(map2);
		List<Object[]> data = dealData(list,params);
		System.out.println("haha");
	}*/

}
