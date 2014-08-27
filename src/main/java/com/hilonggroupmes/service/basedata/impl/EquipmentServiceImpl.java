package com.hilonggroupmes.service.basedata.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hilonggroupmes.dao.basedata.EquipmentDao;
import com.hilonggroupmes.domain.basedata.EquipmentInfo;
import com.hilonggroupmes.service.basedata.EquipmentService;

@Service("equipmentService")
public class EquipmentServiceImpl implements EquipmentService {
	
	@Resource
	private EquipmentDao equipmentDao;

	@Override
	public Long getEquipmentNum(Map<String, Object> queryPare) {		
		return equipmentDao.getEquipmentNum(queryPare);
	}

	@Override
	public List<EquipmentInfo> findEquipmentByPage(Integer page, Integer rows,
			Map<String, Object> queryPare) {		
		return equipmentDao.getEquipmentByPage(page, rows, queryPare);
	}

	@Override
	public Boolean deleteEquipmentByIds(String equipmentIds) {
		try {
		equipmentDao.deleteEquipmentByIds(equipmentIds);
		}catch(Exception e)
		{
			System.out.println(e.toString());
			return false;
		}
		return true;
	}

	@Override
	public EquipmentInfo findEquipmentById(Long equipment_id) {
		return equipmentDao.getEquipmentById(equipment_id);
	}

	@Override
	public Long saveEquipment(EquipmentInfo equipment) {
		return (Long)equipmentDao.save(equipment);
	}

	@Override
	public void updateEquipment(EquipmentInfo equipment) {
		equipmentDao.update(equipment);
		
	}
	
	
	

}
