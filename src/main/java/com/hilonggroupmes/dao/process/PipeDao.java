package com.hilonggroupmes.dao.process;

import java.util.List;
import java.util.Map;

import com.hilonggroupmes.domain.process.PipeInfo;

public interface PipeDao {
	
	/**
	 * 根据主键ID删除工序信息实体
	 * @author 付伟杰
	 * @param Pipe_id 要删除的工序信息的主键ID
	 */
	public void deletePipeById(Long Pipe_id);
	
	public List<PipeInfo> getPipeByPage(Integer page,Integer rows,Map<String,Object> paremeters);

	public Long getPipeNum(Map<String,Object> paremeters);
	
	public void deletePipeByIds(String ids);
	
	public PipeInfo getPipeById(Long procedure_id);

}
