package com.hilonggroupmes.dao.basedata.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hilonggroupmes.dao.base.impl.BaseDaoImpl;
import com.hilonggroupmes.dao.basedata.EquipmentDao;
import com.hilonggroupmes.domain.basedata.EquipmentInfo;

@Repository("equipmentDao")
public class EquipmentDaoImpl extends BaseDaoImpl<EquipmentInfo> implements EquipmentDao {

	@Override
	public void deleteEquipmentById(Long equipment_id) {
		super.executeHql("delete from EquipmentInfo e "
				+ "where e.equipment_id="+ equipment_id);
		
	}

	@Override
	public List<EquipmentInfo> getEquipmentByPage(Integer page, Integer rows,
			Map<String, Object> paremeters) {
		String h_getEquipmentByPage = "from EquipmentInfo e";
		List<Object> param = new ArrayList<Object>();
		if(!paremeters.isEmpty())
		{
			h_getEquipmentByPage += " where ";
			int pareNum = paremeters.size();
			int i=1;
			for(String key:paremeters.keySet())
			{
				if(i!=pareNum)
					h_getEquipmentByPage += ("e." + key +"=? and ");
				else
					h_getEquipmentByPage += ("e." +key + "=?");
				param.add(paremeters.get(key));
				i++;
			}			
		}
		return super.find(h_getEquipmentByPage, param, page, rows);
	}

	@Override
	public Long getEquipmentNum(Map<String, Object> paremeters) {
		
		String h_getEquipmentByPage = "select count(*) from EquipmentInfo e";
		List<Object> param = new ArrayList<Object>();
		if(!paremeters.isEmpty())
		{
			h_getEquipmentByPage += " where ";
			int pareNum = paremeters.size();
			int i=1;
			for(String key:paremeters.keySet())
			{
				if(i!=pareNum)
					h_getEquipmentByPage += ("e." + key +"=? and ");
				else
					h_getEquipmentByPage += ("e." + key +"=?");
				param.add(paremeters.get(key));
				i++;
			}
		}
		return super.count(h_getEquipmentByPage, param);
	}

	@Override
	public void deleteEquipmentByIds(String ids) {
		super.executeHql("delete from EquipmentInfo e where e.equipment_id in(" + ids +")");
		
	}

	@Override
	public EquipmentInfo getEquipmentById(Long equipment_id) {
		return super.get(EquipmentInfo.class, equipment_id);
	}

}
