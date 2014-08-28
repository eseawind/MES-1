package com.hilonggroupmes.controller.basedata;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hilonggroupmes.domain.basedata.MaterialInfo;
import com.hilonggroupmes.service.basedata.MaterialService;


@Controller
public class MaterialController {
	
	@Autowired
	private MaterialService materialService;
	
	private Map<String,Object> resultinfo = new HashMap<String,Object>();	
	
	@RequestMapping("*/listMaterial.do")
	@ResponseBody
	public Map<String,Object> userList(int page,int rows,String material_name,String material_code){		
		resultinfo.clear();
		Map<String,Object> queryPare = new HashMap<String,Object>();
		if(material_name!=null)
			queryPare.put("material_name", material_name);
		if(material_code!=null)
		    queryPare.put("material_code", material_code);
		resultinfo.put("total", materialService.getMaterialNum(queryPare));
		resultinfo.put("rows", materialService.findMaterialByPage(page, rows, queryPare));
		return resultinfo;		
	}
	
	@RequestMapping("*/delMaterial.do")
	@ResponseBody
	public Map<String,Object> userDel(HttpServletRequest request){
		String materialIds = request.getParameter("delids");
		resultinfo.clear();
        if(materialService.deleteMaterialByIds(materialIds))
        {
        	resultinfo.put("success", true);
            resultinfo.put("message","物料删除成功！");
        }
        else
        {
        	resultinfo.put("success", false);
        	resultinfo.put("message","物料删除失败！");
        }
		return resultinfo;		
	}
	
	@RequestMapping("*/saveMaterial.do")
	@ResponseBody
	public Map<String,Object> userSave(Long material_id,String material_name,
			                           String material_spec,String material_code,
			                           Integer material_quantity,String material_manufacturer){
		resultinfo.clear();
		MaterialInfo material =new MaterialInfo();
		material.setMaterial_name(material_name);
		material.setMaterial_code(material_code);
		material.setMaterial_spec(material_spec);
		material.setMaterial_manufacturer(material_manufacturer);
		material.setMaterial_quantity(material_quantity);
		if(material_id==null)
			materialService.saveMaterial(material);
		else
		{
			material.setMaterial_id(material_id);
			materialService.updateMaterial(material);
		}
        resultinfo.put("success", true);
        resultinfo.put("message","物料信息添加成功！");
		return resultinfo;		
	}
	
	@RequestMapping("*/loadMaterial.do")
	@ResponseBody
	public Map<String,Object> loadUser(HttpServletRequest request){
		resultinfo.clear();
		Long id =Long.parseLong(request.getParameter("id"));
		MaterialInfo material = materialService.findMaterialById(id);
        resultinfo.put("material_id",material.getMaterial_id());
        resultinfo.put("material_code", material.getMaterial_code());
        resultinfo.put("material_name", material.getMaterial_name());
        resultinfo.put("material_spec", material.getMaterial_spec());
        resultinfo.put("material_manufacturer", material.getMaterial_manufacturer());
        resultinfo.put("material_quantity",material.getMaterial_quantity());
		return resultinfo;		
	}
}
