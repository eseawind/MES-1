package com.hilonggroupmes.controller.basedata;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hilonggroupmes.domain.basedata.EquipmentInfo;
import com.hilonggroupmes.service.basedata.EquipmentService;

@Controller
public class EquipmentController {
	
	@Autowired
	private EquipmentService equipmentService;
	
	private Map<String,Object> resultinfo = new HashMap<String,Object>();	
	
	@RequestMapping("*/listEquipment.do")
	@ResponseBody
	public Map<String,Object> userList(int page,int rows,String equipment_name,String equipment_code){		
		resultinfo.clear();
		Map<String,Object> queryPare = new HashMap<String,Object>();
		if(equipment_name!=null)
			queryPare.put("equipment_name", equipment_name);
		if(equipment_code!=null)
		    queryPare.put("equipment_code", equipment_code);
		resultinfo.put("total", equipmentService.getEquipmentNum(queryPare));
		resultinfo.put("rows", equipmentService.findEquipmentByPage(page, rows, queryPare));
		return resultinfo;		
	}
	
	@RequestMapping("*/delEquipment.do")
	@ResponseBody
	public Map<String,Object> userDel(HttpServletRequest request){
		String equipmentIds = request.getParameter("delids");
		resultinfo.clear();
        if(equipmentService.deleteEquipmentByIds(equipmentIds))
        {
        	resultinfo.put("success", true);
            resultinfo.put("message","设备删除成功！");
        }
        else
        {
        	resultinfo.put("success", false);
        	resultinfo.put("message","设备删除失败！");
        }
		return resultinfo;		
	}
	
	@RequestMapping("*/saveEquipment.do")
	@ResponseBody
	public Map<String,Object> userSave(Long equipment_id,String equipment_name,
			                           String equipment_type,String equipment_code,
			                           Boolean equipment_state,String equipment_manufacturer){
		resultinfo.clear();
		EquipmentInfo equipment =new EquipmentInfo();
		equipment.setEquipment_name(equipment_name);
		equipment.setEquipment_code(equipment_code);
		equipment.setEquipment_type(equipment_type);
		equipment.setEquipment_manufacturer(equipment_manufacturer);
		equipment.setEquipment_state(equipment_state);
		if(equipment_id==null)
			equipmentService.saveEquipment(equipment);
		else
		{
			equipment.setEquipment_id(equipment_id);
			equipmentService.updateEquipment(equipment);
		}
        resultinfo.put("success", true);
        resultinfo.put("message","设备信息添加成功！");
		return resultinfo;		
	}
	
	@RequestMapping("*/loadEquipment.do")
	@ResponseBody
	public Map<String,Object> loadUser(HttpServletRequest request){
		resultinfo.clear();
		Long id =Long.parseLong(request.getParameter("id"));
		EquipmentInfo equipment = equipmentService.findEquipmentById(id);
        resultinfo.put("equipment_id",equipment.getEquipment_id());
        resultinfo.put("equipment_code", equipment.getEquipment_code());
        resultinfo.put("equipment_name", equipment.getEquipment_name());
        resultinfo.put("equipment_type", equipment.getEquipment_type());
        resultinfo.put("equipment_manufacturer", equipment.getEquipment_manufacturer());
        resultinfo.put("equipment_state",equipment.getEquipment_state());
		return resultinfo;		
	}
}
