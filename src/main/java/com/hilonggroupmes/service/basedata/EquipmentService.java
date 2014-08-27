package com.hilonggroupmes.service.basedata;

import java.util.List;
import java.util.Map;

import com.hilonggroupmes.domain.basedata.EquipmentInfo;

public interface EquipmentService {
	
	public Long getEquipmentNum(Map<String,Object> queryPare);
	
	public List<EquipmentInfo> findEquipmentByPage(Integer page, Integer rows, Map<String,Object> queryPare);
	
	public Boolean deleteEquipmentByIds(String equipmentIds);
	
	public EquipmentInfo findEquipmentById(Long equipment_id);
	
	public Long saveEquipment(EquipmentInfo equipment);
	
	public void updateEquipment(EquipmentInfo equipment);

}
