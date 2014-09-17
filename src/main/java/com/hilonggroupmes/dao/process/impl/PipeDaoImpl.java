package com.hilonggroupmes.dao.process.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hilonggroupmes.dao.base.impl.BaseDaoImpl;
import com.hilonggroupmes.dao.process.PipeDao;
import com.hilonggroupmes.domain.process.PipeInfo;
import com.hilonggroupmes.utils.CommonUtils;

@Repository("pipeDao")
public class PipeDaoImpl extends BaseDaoImpl<PipeInfo> implements PipeDao {

	@Override
	public void deletePipeById(Long Pipe_id) {
		super.delete(super.get(PipeInfo.class, Pipe_id));
	}

	@Override
	public List<PipeInfo> getPipeByPage(Integer page, Integer rows,
			Map<String, Object> paremeters) {
		 Map<String,Object> queryInfo = CommonUtils.buildQuery("PipeInfo",paremeters);
	     String hql_query = (String) queryInfo.get("hql_query");
	     List<Object> pare_query = (List<Object>) queryInfo.get("pare_query");
	     return super.find(hql_query, pare_query, page, rows);
	}

	@Override
	public Long getPipeNum(Map<String, Object> paremeters) {		
        Map<String,Object> queryInfo = CommonUtils.buildQuery("PipeInfo", paremeters);
        String hql_query = (String) queryInfo.get("hql_query");
        List<Object> pare_query = (List<Object>) queryInfo.get("pare_query");
		return super.count(hql_query, pare_query);
	}

	@Override
	public void deletePipeByIds(String ids) {
		super.executeHql("delete from PipeInfo p where p.pipe_id in(" + ids +")");

	}

	@Override
	public PipeInfo getPipeById(Long pipe_id) {
		return super.get(PipeInfo.class, pipe_id);
	}
}
