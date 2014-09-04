package com.hilonggroupmes.service.process.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hilonggroupmes.dao.process.ProcedureDao;
import com.hilonggroupmes.dao.process.ProcedureItemDao;
import com.hilonggroupmes.domain.process.ProcedureInfo;
import com.hilonggroupmes.domain.process.ProcedureItemInfo;
import com.hilonggroupmes.service.process.ProcedureService;

@Service("procedureService")
public class ProcedureServiceImpl implements ProcedureService {
	
	@Resource
	private ProcedureDao procedureDao;
	
	@Resource
	private ProcedureItemDao procedureItemDao;

	@Override
	public Long getProcedureNum(Map<String, Object> queryPare) {
		return procedureDao.getProcedureNum(queryPare);
	}

	@Override
	public List<ProcedureInfo> findProcedureByPage(Integer page, Integer rows,
			Map<String, Object> queryPare) {
		
		return procedureDao.getProcedureByPage(page, rows, queryPare);
	}

	@Override
	public Boolean deleteProcedureByIds(String procedureIds) {
		try{
			procedureDao.deleteProcedureByIds(procedureIds);			
		}catch(Exception e)
		{
			System.out.println(e.toString());
			return false;
		}
		return true;
	}

	@Override
	public ProcedureInfo findProcedureById(Long procedure_id) {
		return procedureDao.get(ProcedureInfo.class, procedure_id);
	}

	@Override
	public Long saveProcedure(ProcedureInfo procedure) {		
		return (Long)procedureDao.save(procedure);
	}

	@Override
	public void updateProcedure(ProcedureInfo procedure) {
		 procedureDao.update(procedure);

	}

	@Override
	public List<ProcedureItemInfo> getProcedureItemByProcedure(Long procedure_id) {
		ProcedureInfo p = procedureDao.get(ProcedureInfo.class, procedure_id);
		List<ProcedureItemInfo> pi= p.getProcedure_items();
		return pi;
	}

	@Override
	public void saveProcedureItem(ProcedureItemInfo procedure_item) {
		procedureItemDao.saveOrUpdate(procedure_item);
		
	}

	@Override
	public List<ProcedureInfo> getProcedureList() {
		return procedureDao.getProcedureList();
	}


}
