package com.hilonggroupmes.dao.basedata.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hilonggroupmes.dao.base.impl.BaseDaoImpl;
import com.hilonggroupmes.dao.basedata.PipeTypeDao;
import com.hilonggroupmes.domain.basedata.PipeTypeInfo;
import com.hilonggroupmes.utils.CommonUtils;

@Repository("PipeTypeDao")
public class PipeTypeDaoImpl extends BaseDaoImpl<PipeTypeInfo> implements
		PipeTypeDao {

	@Override
	public void deletePipeTypeById(Long pipetype_id) {
		super.executeHql("delete from PipeTypeInfo p "
				+ "where p.pipetype_id="+ pipetype_id);
	}

	@Override
	public List<PipeTypeInfo> getPipeTypeByPage(Integer page, Integer rows,
			Map<String, Object> paremeters) {
	        Map<String,Object> queryInfo = CommonUtils.buildQuery("PipeTypeInfo",paremeters);
	        String hql_query = (String) queryInfo.get("hql_query");
	        List<Object> pare_query = (List<Object>) queryInfo.get("pare_query");
			return super.find(hql_query, pare_query, page, rows);
	}

	@Override
	public Long getPipeTypeNum(Map<String, Object> paremeters) {
	        Map<String,Object> queryInfo = CommonUtils.buildQuery("PipeTypeInfo",paremeters);
	        String hql_query = (String) queryInfo.get("hql_query");
	        List<Object> pare_query = (List<Object>) queryInfo.get("pare_query");
		return super.count(hql_query, pare_query);
	}

	@Override
	public void deletePipeTypeByIds(String ids) {
		super.executeHql("delete from PipeTypeInfo p where p.pipetype_id in(" + ids +")");

	}

	@Override
	public PipeTypeInfo getPipeTypeById(Long pipetype_id) {
		return super.get(PipeTypeInfo.class, pipetype_id);
	}

}
