package com.hilonggroupmes.controller.process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hilonggroupmes.domain.basedata.ProductInfo;
import com.hilonggroupmes.domain.process.ProcedureInfo;
import com.hilonggroupmes.domain.process.ProcedureItemInfo;
import com.hilonggroupmes.service.basedata.ProductService;
import com.hilonggroupmes.service.process.ProcedureService;

@Controller
public class ProcedureController {
	
	@Autowired
	private ProcedureService procedureService;
	
	@Autowired
	private ProductService productService;
	
	private Map<String,Object> resultinfo = new HashMap<String,Object>();

	@RequestMapping("*/listProcedure.do")
	@ResponseBody
	public Map<String,Object> procedureList(int page,int rows,String procedure_name,String procedure_code){		
		resultinfo.clear();
		Map<String,Object> queryPare = new HashMap<String,Object>();
		if(procedure_name!=null)
			queryPare.put("procedure_name", procedure_name);
		if(procedure_code!=null)
		    queryPare.put("equipment_code", procedure_code);
		resultinfo.put("total", procedureService.getProcedureNum(queryPare));
		resultinfo.put("rows", procedureService.findProcedureByPage(page, rows, queryPare));
		return resultinfo;		
	}
	
	@RequestMapping("*/saveProcedure.do")
	@ResponseBody
	public Map<String,Object> userSave(Long procedure_id,String procedure_itemlist,
			                           String procedure_name,String procedure_code,
			                           Integer procedure_type,String procedure_equipment) throws JsonParseException, JsonMappingException, IOException{
		resultinfo.clear();
		List<ProcedureItemInfo> pilist = null;
		ProcedureInfo procedure = new ProcedureInfo();
		procedure.setProcedure_name(procedure_name);
		procedure.setProcedure_code(procedure_code);
		procedure.setProcedure_type(procedure_type);
		procedure.setProcedure_equipment(procedure_equipment);
		procedure.setProcedure_id(procedure_id);
		
		if(procedure_itemlist!=null)
		{
			ObjectMapper mapper = new ObjectMapper();
			JavaType jt = mapper.getTypeFactory().constructParametricType(ArrayList.class, ProcedureItemInfo.class); 
			pilist = (List<ProcedureItemInfo>)mapper.readValue(procedure_itemlist, jt);
			for(int i=0;i<pilist.size();i++)
			{
				pilist.get(i).setProcedureitem_procedure(procedure);
			}
			procedure.setProcedure_items(pilist);
		}
		if(procedure_id!=null)
			procedureService.updateProcedure(procedure);
		else
			procedureService.saveProcedure(procedure);
        resultinfo.put("success", true);
        resultinfo.put("message","工序信息添加成功！");
		return resultinfo;		
	}
	
	@RequestMapping("*/delProcedure.do")
	@ResponseBody
	public Map<String,Object> userDel(HttpServletRequest request){
		String procedureIds = request.getParameter("delids");
		resultinfo.clear();
        if(procedureService.deleteProcedureByIds(procedureIds))
        {
        	resultinfo.put("success", true);
            resultinfo.put("message","工序删除成功！");
        }
        else
        {
        	resultinfo.put("success", false);
        	resultinfo.put("message","工序删除失败！");
        }
		return resultinfo;		
	}
	
	
	@RequestMapping("*/loadProcedure.do")
	@ResponseBody
	public Map<String,Object> loadProcedure(HttpServletRequest request){
		resultinfo.clear();
		Long id =Long.parseLong(request.getParameter("id"));
		ProcedureInfo procedure = procedureService.findProcedureById(id);
        resultinfo.put("procedure_id",procedure.getProcedure_id());
        resultinfo.put("procedure_code", procedure.getProcedure_code());
        resultinfo.put("procedure_name", procedure.getProcedure_name());
        resultinfo.put("procedure_type", procedure.getProcedure_type());
        resultinfo.put("procedure_equipment", procedure.getProcedure_equipment());
		return resultinfo;		
	}
	
	@RequestMapping("*/loadProcedureItem.do")
	@ResponseBody
	public Map<String,Object> procedureItemList(HttpServletRequest resquest){		
		resultinfo.clear();
		List<ProcedureItemInfo> pinlist = new ArrayList<ProcedureItemInfo>();
		String procedure_id = resquest.getParameter("id");
		if(procedure_id!=""&&procedure_id!=null)
		{
			pinlist = procedureService.getProcedureItemByProcedure(Long.parseLong(procedure_id));
		    resultinfo.put("rows", pinlist);
		    resultinfo.put("total", pinlist.size());
		}else
		{
			resultinfo.put("total", 0);
			resultinfo.put("rows", pinlist);
		}
		return resultinfo;		
	}
	
	@RequestMapping("*/loadProcedureList.do")
	@ResponseBody
	public List<ProcedureInfo> procedureList(){		
		return procedureService.getProcedureList();
	}
	
	@RequestMapping("*/addProductProcess.do")
	@ResponseBody
	public Map<String,Object> procedureList(Long product_id,String product_itemlist){	
		
		resultinfo.clear();
		if(product_id ==null)
		{
			resultinfo.put("success", false);
			resultinfo.put("message", "产品信息数据传输错误，请刷新后重新操作！");
		}else {
			ProductInfo pi = productService.findProductById(product_id);
		}
		return resultinfo;	
	}

}
