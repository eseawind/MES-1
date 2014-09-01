package com.hilonggroupmes.dao.process;

import java.util.List;
import java.util.Map;

import com.hilonggroupmes.dao.base.BaseDao;
import com.hilonggroupmes.domain.process.ProcedureInfo;
import com.hilonggroupmes.domain.process.ProcedureItemInfo;

public interface ProcedureDao extends BaseDao<ProcedureInfo> {
	
	/**
	 * 根据主键ID删除工序信息实体
	 * @author 付伟杰
	 * @param Procedure_id 要删除的工序信息的主键ID
	 */
	public void deleteProcedureById(Long Procedure_id);
	
	public List<ProcedureInfo> getProcedureByPage(Integer page,Integer rows,Map<String,Object> paremeters);

	public Long getProcedureNum(Map<String,Object> paremeters);
	
	public void deleteProcedureByIds(String ids);
	
	public ProcedureInfo getProcedureById(Long procedure_id);
	
	public List<ProcedureItemInfo> getProcedureItemByProcedure(Long procedure_id);

}
