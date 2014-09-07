package com.hilonggroupmes.service.process;

import java.util.List;
import java.util.Map;

import com.hilonggroupmes.domain.process.ProcedureInfo;
import com.hilonggroupmes.domain.process.ProcedureItemInfo;
import com.hilonggroupmes.domain.process.ProductProcessInfo;

public interface ProcedureService {
	
	public Long getProcedureNum(Map<String,Object> queryPare);
	
	public List<ProcedureInfo> findProcedureByPage(Integer page, Integer rows, Map<String,Object> queryPare);
	
	public Boolean deleteProcedureByIds(String ProcedureIds);
	
	public ProcedureInfo findProcedureById(Long Procedure_id);
	
	public Long saveProcedure(ProcedureInfo Procedure);
	
	public void updateProcedure(ProcedureInfo Procedure);
	
	public List<ProcedureItemInfo> getProcedureItemByProcedure(Long procedure_id);
	
	public void saveProcedureItem(ProcedureItemInfo procedure_item);
	
	public List<ProcedureInfo> getProcedureList();
	
	public List<ProductProcessInfo> getProductProcessByProduct(Long productprocess_id);

}
