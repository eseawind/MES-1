package com.hilonggroupmes.controller.basedata;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hilonggroupmes.domain.basedata.PipeTypeInfo;
import com.hilonggroupmes.service.basedata.PipeTypeService;

@Controller
public class PipeTypeController {

	@Autowired
	private PipeTypeService pipeTypeService;
	
	private Map<String,Object> resultinfo = new HashMap<String,Object>();	
	
	@RequestMapping("*/listPipeType.do")
	@ResponseBody
	public Map<String,Object> userList(int page,int rows,String pipetype_name,
			String pipetype_spc,String pipetype_steelgrade){		
		resultinfo.clear();
		Map<String,Object> queryPare = new HashMap<String,Object>();
		if(pipetype_name!=null)
			queryPare.put("pipetype_name", pipetype_name);
		if(pipetype_spc!=null)
		    queryPare.put("pipetype_spc", pipetype_spc);
		if(pipetype_steelgrade!=null)
		    queryPare.put("pipetype_steelgrade", pipetype_steelgrade);
		resultinfo.put("total", pipeTypeService.getPipeTypeNum(queryPare));
		resultinfo.put("rows", pipeTypeService.findPipeTypeByPage(page, rows, queryPare));
		return resultinfo;		
	}
	
	@RequestMapping("*/delPipeType.do")
	@ResponseBody
	public Map<String,Object> userDel(HttpServletRequest request){
		String pipetypeIds = request.getParameter("delids");
		resultinfo.clear();
        if(pipeTypeService.deletePipeTypeByIds(pipetypeIds))
        {
        	resultinfo.put("success", true);
            resultinfo.put("message","钢管类型删除成功！");
        }
        else
        {
        	resultinfo.put("success", false);
        	resultinfo.put("message","钢管类型删除失败！");
        }
		return resultinfo;		
	}
	
	@RequestMapping("*/savePipeType.do")
	@ResponseBody
	public Map<String,Object> userSave(Long pipetype_id,String pipetype_name,
			                           String pipetype_spec,String pipetype_steelgrade,
			                           Integer pipetype_type,String pipetype_supplier){
		resultinfo.clear();
		PipeTypeInfo pipetype =new PipeTypeInfo();
		pipetype.setPipetype_name(pipetype_name);
		pipetype.setPipetype_spec(pipetype_spec);
		pipetype.setPipetype_steelgrade(pipetype_steelgrade);
		pipetype.setPipetype_type(pipetype_type);
		pipetype.setPipetype_supplier(pipetype_supplier);
		if(pipetype_id==null)
			pipeTypeService.savePipeType(pipetype);
		else
		{
			pipetype.setPipetype_id(pipetype_id);
			pipeTypeService.updatePipeType(pipetype);
		}
        resultinfo.put("success", true);
        resultinfo.put("message","物料信息添加成功！");
		return resultinfo;		
	}
	
	@RequestMapping("*/loadPipeType.do")
	@ResponseBody
	public Map<String,Object> loadUser(HttpServletRequest request){
		resultinfo.clear();
		Long id =Long.parseLong(request.getParameter("id"));
		PipeTypeInfo pipetype = pipeTypeService.findPipeTypeById(id);
        resultinfo.put("pipetype_id",pipetype.getPipetype_id());
        resultinfo.put("pipetype_name", pipetype.getPipetype_name());
        resultinfo.put("pipetype_spec", pipetype.getPipetype_spec());
        resultinfo.put("pipetype_steelgrade", pipetype.getPipetype_steelgrade());
        resultinfo.put("pipetype_supplier", pipetype.getPipetype_supplier());
        resultinfo.put("pipetype_type",pipetype.getPipetype_type());
		return resultinfo;		
	}
}
