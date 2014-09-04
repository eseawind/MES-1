package com.hilonggroupmes.dao.process.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hilonggroupmes.dao.base.impl.BaseDaoImpl;
import com.hilonggroupmes.dao.process.ProcedureDao;
import com.hilonggroupmes.domain.process.ProcedureInfo;
import com.hilonggroupmes.utils.CommonUtils;


@Repository("procedureDao")
public class ProcedureDaoImpl extends BaseDaoImpl<ProcedureInfo> implements
		ProcedureDao {


	@Override
	public void deleteProcedureById(Long procedure_id) {
		super.executeHql("delete from ProcedureInfo p "
				+ "where p.procedure_id="+ procedure_id);
		
	}

	@Override
	public List<ProcedureInfo> getProcedureByPage(Integer page, Integer rows,
			Map<String, Object> paremeters) {
        Map<String,Object> queryInfo = CommonUtils.buildQuery("ProcedureInfo",paremeters);
        String hql_query = (String) queryInfo.get("hql_query");
        List<Object> pare_query = (List<Object>) queryInfo.get("pare_query");
		return super.find(hql_query, pare_query, page, rows);
	}

	@Override
	public Long getProcedureNum(Map<String, Object> paremeters) {
		
        Map<String,Object> queryInfo = CommonUtils.buildQuery("ProcedureInfo", paremeters);
        String hql_query = (String) queryInfo.get("hql_query");
        List<Object> pare_query = (List<Object>) queryInfo.get("pare_query");
		return super.count(hql_query, pare_query);
	}

	@Override
	public void deleteProcedureByIds(String ids) {
		super.executeHql("delete from ProcedureInfo p "
				+ "where p.procedure_id in(" + ids +")");
		
	}

	@Override
	public ProcedureInfo getProcedureById(Long procedure_id) {
		return super.get(ProcedureInfo.class, procedure_id);
	}

	@Override
	public List<ProcedureInfo> getProcedureList() {
		return super.find("from ProcedureInfo p");
	}

}
