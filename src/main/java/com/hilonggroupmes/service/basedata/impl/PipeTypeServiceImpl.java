package com.hilonggroupmes.service.basedata.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hilonggroupmes.dao.basedata.PipeTypeDao;
import com.hilonggroupmes.domain.basedata.PipeTypeInfo;
import com.hilonggroupmes.service.basedata.PipeTypeService;

@Service("pipeTypeService")
public class PipeTypeServiceImpl implements PipeTypeService {
	
	@Resource
	private PipeTypeDao pipeTypeDao;

	@Override
	public Long getPipeTypeNum(Map<String, Object> queryPare) {
		return pipeTypeDao.getPipeTypeNum(queryPare);
	}

	@Override
	public List<PipeTypeInfo> findPipeTypeByPage(Integer page, Integer rows,
			Map<String, Object> queryPare) {
		return pipeTypeDao.getPipeTypeByPage(page, rows, queryPare);
	}

	@Override
	public Boolean deletePipeTypeByIds(String pipetypeIds) {
		try{
			pipeTypeDao.deletePipeTypeByIds(pipetypeIds);
		}catch(Exception e){
			System.out.println(e.toString());
			return false;
		}
		return true;
	}

	@Override
	public PipeTypeInfo findPipeTypeById(Long pipetype_id) {
		return pipeTypeDao.get(PipeTypeInfo.class, pipetype_id);
	}

	@Override
	public Long savePipeType(PipeTypeInfo pipetype) {
		return (Long)pipeTypeDao.save(pipetype);
	}

	@Override
	public void updatePipeType(PipeTypeInfo pipetype) {
		pipeTypeDao.update(pipetype);
		
	}

}
