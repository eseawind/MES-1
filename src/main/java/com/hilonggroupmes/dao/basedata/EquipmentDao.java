package com.hilonggroupmes.dao.basedata;

import java.util.List;
import java.util.Map;

import com.hilonggroupmes.dao.base.BaseDao;
import com.hilonggroupmes.domain.basedata.EquipmentInfo;

/**
 * 设备信息数据库操作接口
 *
 * <p> 记录有关设备信息的操作接口
 *
 * @author  付伟杰
 * @version 1.0.2014.8.27
 */

public interface EquipmentDao extends BaseDao<EquipmentInfo> {

	/**
	 * 根据主键ID删除设备信息实体
	 * @author 付伟杰
	 * @param equipment_id 要删除的设备信息的主键ID
	 */
	public void deleteEquipmentById(Long equipment_id);
	
	public List<EquipmentInfo> getEquipmentByPage(Integer page,Integer rows,Map<String,Object> paremeters);

	public Long getEquipmentNum(Map<String,Object> paremeters);
	
	public void deleteEquipmentByIds(String ids);
	
	public EquipmentInfo getEquipmentById(Long equipment_id);

}
