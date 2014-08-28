package com.hilonggroupmes.dao.basedata.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hilonggroupmes.dao.base.impl.BaseDaoImpl;
import com.hilonggroupmes.dao.basedata.MaterialDao;
import com.hilonggroupmes.domain.basedata.MaterialInfo;
import com.hilonggroupmes.utils.CommonUtils;

@Repository("materialDao")
public class MaterialDaoImpl extends BaseDaoImpl<MaterialInfo> implements MaterialDao {

	@Override
	public void deleteMaterialById(Long material_id) {
		super.executeHql("delete from MaterialInfo m "
				+ "where m.material_id="+ material_id);
	}

	@Override
	public List<MaterialInfo> getMaterialByPage(Integer page, Integer rows,
			Map<String, Object> paremeters) {
	        Map<String,Object> queryInfo = CommonUtils.buildQuery("MaterialInfo",paremeters);
	        String hql_query = (String) queryInfo.get("hql_query");
	        List<Object> pare_query = (List<Object>) queryInfo.get("pare_query");
			return super.find(hql_query, pare_query, page, rows);
	}

	@Override
	public Long getMaterialNum(Map<String, Object> paremeters) {
	        Map<String,Object> queryInfo = CommonUtils.buildQuery("MaterialInfo",paremeters);
	        String hql_query = (String) queryInfo.get("hql_query");
	        List<Object> pare_query = (List<Object>) queryInfo.get("pare_query");
		return super.count(hql_query, pare_query);
	}

	@Override
	public void deleteMaterialByIds(String ids) {
		super.executeHql("delete from MaterialInfo m where m.material_id in(" + ids +")");

	}

	@Override
	public MaterialInfo getMaterialById(Long material_id) {
		return super.get(MaterialInfo.class, material_id);
	}

}
