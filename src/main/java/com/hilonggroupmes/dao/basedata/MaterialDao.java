package com.hilonggroupmes.dao.basedata;

import java.util.List;
import java.util.Map;

import com.hilonggroupmes.dao.base.BaseDao;
import com.hilonggroupmes.domain.basedata.MaterialInfo;

public interface MaterialDao extends BaseDao<MaterialInfo> {
	
	/**
	 * 根据主键ID删除物料信息实体
	 * @author 付伟杰
	 * @param material_id 要删除的物料信息的主键ID
	 */
	public void deleteMaterialById(Long material_id);
	
	public List<MaterialInfo> getMaterialByPage(Integer page,Integer rows,Map<String,Object> paremeters);

	public Long getMaterialNum(Map<String,Object> paremeters);
	
	public void deleteMaterialByIds(String ids);
	
	public MaterialInfo getMaterialById(Long material_id);

}
