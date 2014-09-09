package com.hilonggroupmes.service.process.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hilonggroupmes.dao.process.PipeDao;
import com.hilonggroupmes.domain.process.PipeInfo;
import com.hilonggroupmes.service.process.PipeService;

@Service("pipeService")
public class PipeServiceImpl implements PipeService {

	@Resource
	private PipeDao pipeDao;
	
	@Override
	public Long getPipeNum(Map<String, Object> queryPare) {
		return pipeDao.getPipeNum(queryPare);
	}

	@Override
	public List<PipeInfo> findPipeByPage(Integer page, Integer rows,
			Map<String, Object> queryPare) {
		return pipeDao.getPipeByPage(page, rows, queryPare);
	}

	@Override
	public Boolean deletePipeByIds(String pipeIds) {
		try{
			pipeDao.deletePipeByIds(pipeIds);			
		}catch(Exception e)
		{
			System.out.println(e.toString());
			return false;
		}
		return true;
	}

	@Override
	public PipeInfo findPipeById(Long pipe_id) {
		return pipeDao.getPipeById(pipe_id);
	}

	@Override
	public Long savePipe(PipeInfo pipe) {
		return (Long)pipeDao.save(pipe);
	}

	@Override
	public void updatePipe(PipeInfo pipe) {
		pipeDao.update(pipe);
		
	}

}
