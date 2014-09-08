package com.hilonggroupmes.service.process;

import java.util.List;
import java.util.Map;

import com.hilonggroupmes.domain.process.PipeInfo;

public interface PipeService {
	
	public Long getPipeNum(Map<String,Object> queryPare);
	
	public List<PipeInfo> findPipeByPage(Integer page, Integer rows, Map<String,Object> queryPare);
	
	public Boolean deletePipeByIds(String pipeIds);
	
	public PipeInfo findPipeById(Long pipe_id);
	
	public Long savePipe(PipeInfo pipe);
	
	public void updatePipe(PipeInfo pipe);

}
