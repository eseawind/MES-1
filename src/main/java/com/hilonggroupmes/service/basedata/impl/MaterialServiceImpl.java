package com.hilonggroupmes.service.basedata.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hilonggroupmes.dao.basedata.MaterialDao;
import com.hilonggroupmes.domain.basedata.MaterialInfo;
import com.hilonggroupmes.service.basedata.MaterialService;

@Service("materialService")
public class MaterialServiceImpl implements MaterialService {
	
	@Resource
	private MaterialDao materialDao;

	@Override
	public Long getMaterialNum(Map<String, Object> queryPare) {
		return materialDao.getMaterialNum(queryPare);
	}

	@Override
	public List<MaterialInfo> findMaterialByPage(Integer page, Integer rows,
			Map<String, Object> queryPare) {
		
		return materialDao.getMaterialByPage(page, rows, queryPare);
	}

	@Override
	public Boolean deleteMaterialByIds(String materialIds) {        
		try{
			materialDao.deleteMaterialByIds(materialIds);
		}catch(Exception e)
		{
			System.out.println(e.toString());
			return false;
		}
		return true;
	}

	@Override
	public MaterialInfo findMaterialById(Long material_id) {
		return materialDao.get(MaterialInfo.class, material_id);
	}

	@Override
	public Long saveMaterial(MaterialInfo material) {
		return (Long)materialDao.save(material);
	}

	@Override
	public void updateMaterial(MaterialInfo material) {
		materialDao.update(material);
	}

}
