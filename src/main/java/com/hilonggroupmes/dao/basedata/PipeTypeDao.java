package com.hilonggroupmes.dao.basedata;

import java.util.List;
import java.util.Map;

import com.hilonggroupmes.dao.base.BaseDao;
import com.hilonggroupmes.domain.basedata.PipeTypeInfo;

public interface PipeTypeDao extends BaseDao<PipeTypeInfo> {
	
	/**
	 * 根据主键ID删除钢管信息实体
	 * @author 付伟杰
	 * @param pipeType_id 要删除的钢管信息的主键ID
	 */
	public void deletePipeTypeById(Long pipeType_id);
	
	public List<PipeTypeInfo> getPipeTypeByPage(Integer page,Integer rows,Map<String,Object> paremeters);

	public Long getPipeTypeNum(Map<String,Object> paremeters);
	
	public void deletePipeTypeByIds(String ids);
	
	public PipeTypeInfo getPipeTypeById(Long pipeType_id);

}
