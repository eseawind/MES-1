package com.hilonggroupmes.service.basedata;

import java.util.List;
import java.util.Map;

import com.hilonggroupmes.domain.basedata.MaterialInfo;

public interface MaterialService {
	
	public Long getMaterialNum(Map<String,Object> queryPare);
	
	public List<MaterialInfo> findMaterialByPage(Integer page, Integer rows, Map<String,Object> queryPare);
	
	public Boolean deleteMaterialByIds(String materialIds);
	
	public MaterialInfo findMaterialById(Long material_id);
	
	public Long saveMaterial(MaterialInfo material);
	
	public void updateMaterial(MaterialInfo material);

}
