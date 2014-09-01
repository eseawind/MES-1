package com.hilonggroupmes.controller.process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hilonggroupmes.domain.process.ProcedureInfo;
import com.hilonggroupmes.domain.process.ProcedureItemInfo;
import com.hilonggroupmes.service.process.ProcedureService;

@Controller
public class ProcedureController {
	
	@Autowired
	private ProcedureService procedureService;
	
	private Map<String,Object> resultinfo = new HashMap<String,Object>();
	
	@RequestMapping("*/saveProcedure.do")
	@ResponseBody
	public Map<String,Object> userSave(Long procedure_id,String procedure_itemlist,
			                           String procedure_name,String procedure_code,
			                           Integer procedure_type,String procedure_equipment) throws JsonParseException, JsonMappingException, IOException{
		resultinfo.clear();
		
		ProcedureInfo procedure = new ProcedureInfo();
		procedure.setProcedure_name(procedure_name);
		procedure.setProcedure_code(procedure_code);
		procedure.setProcedure_type(procedure_type);
		procedure.setProcedure_equipment(procedure_equipment);
		
		if(procedure_itemlist!=null)
		{
			ObjectMapper mapper = new ObjectMapper();
			JavaType jt = mapper.getTypeFactory().constructParametricType(ArrayList.class, ProcedureItemInfo.class); 
			List<ProcedureItemInfo> pilist = (List<ProcedureItemInfo>)mapper.readValue(procedure_itemlist, jt);
			for(int i=0;i<pilist.size();i++)
			{
				ProcedureItemInfo pe = (ProcedureItemInfo)pilist.get(i);
                procedure.getProcedure_items().add(pe);
			}
		}
		if(procedure_id!=null)
			procedureService.updateProcedure(procedure);
		else
			procedureService.saveProcedure(procedure);
				
        resultinfo.put("success", true);
        resultinfo.put("message","工序信息添加成功！");
		return resultinfo;		
	}

}
