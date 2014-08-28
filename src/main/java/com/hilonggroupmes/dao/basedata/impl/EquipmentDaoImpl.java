package com.hilonggroupmes.dao.basedata.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hilonggroupmes.dao.base.impl.BaseDaoImpl;
import com.hilonggroupmes.dao.basedata.EquipmentDao;
import com.hilonggroupmes.domain.basedata.EquipmentInfo;
import com.hilonggroupmes.utils.CommonUtils;

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
        Map<String,Object> queryInfo = CommonUtils.buildQuery("EquipmentInfo",paremeters);
        String hql_query = (String) queryInfo.get("hql_query");
        List<Object> pare_query = (List<Object>) queryInfo.get("pare_query");
		return super.find(hql_query, pare_query, page, rows);
	}

	@Override
	public Long getEquipmentNum(Map<String, Object> paremeters) {
		
        Map<String,Object> queryInfo = CommonUtils.buildQuery("EquipmentInfo", paremeters);
        String hql_query = (String) queryInfo.get("hql_query");
        List<Object> pare_query = (List<Object>) queryInfo.get("pare_query");
		return super.count(hql_query, pare_query);
	}

	@Override
	public void deleteEquipmentByIds(String ids) {
		super.executeHql("delete from EquipmentInfo e "
				+ "where e.equipment_id in(" + ids +")");
		
	}

	@Override
	public EquipmentInfo getEquipmentById(Long equipment_id) {
		return super.get(EquipmentInfo.class, equipment_id);
	}

}
