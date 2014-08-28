package com.hilonggroupmes.service.basedata;

import java.util.List;
import java.util.Map;

import com.hilonggroupmes.domain.basedata.PipeTypeInfo;

public interface PipeTypeService {
	
	public Long getPipeTypeNum(Map<String,Object> queryPare);
	
	public List<PipeTypeInfo> findPipeTypeByPage(Integer page, Integer rows, Map<String,Object> queryPare);
	
	public Boolean deletePipeTypeByIds(String pipetypeIds);
	
	public PipeTypeInfo findPipeTypeById(Long pipetype_id);
	
	public Long savePipeType(PipeTypeInfo pipetype);
	
	public void updatePipeType(PipeTypeInfo pipetype);
	

}
