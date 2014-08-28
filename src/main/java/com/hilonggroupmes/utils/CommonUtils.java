package com.hilonggroupmes.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUtils {
	
	public static Map<String,Object> buildQuery(String entity_name,
                        Map<String,Object> param){
		Map<String,Object> query_info = new HashMap<String,Object>();
		
		String h_queryEntityByPara = "from " + entity_name + " o";
		List<Object> parameters = new ArrayList<Object>();
		if(!param.isEmpty())
		{
			h_queryEntityByPara += " where ";
			int pareNum = param.size();
			int i=1;
			for(String key:param.keySet())
			{
				if(i!=pareNum)
					h_queryEntityByPara += ("o." + key +"=? and ");
				else
					h_queryEntityByPara += ("o." +key + "=?");
				parameters.add(param.get(key));
				i++;
			}			
		}
		query_info.put("hql_query", h_queryEntityByPara);
		query_info.put("pare_query", parameters);		
		return query_info;
	}

}
