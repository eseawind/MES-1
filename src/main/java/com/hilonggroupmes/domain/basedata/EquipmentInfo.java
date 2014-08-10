package com.hilonggroupmes.domain.basedata;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 设备信息实体类
 * 
 * <p>记录权限的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * equipment_id  设备信息主键
 *	
 * equipment_name 设备名称
 *	
 * equipment_type 设备类型
 *	
 * equipment_code 设备编号
 *	
 * equipment_state 设备状态
 *
 * equipment_manufacturer 设备厂商
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */
@Entity
@Table(name="MES_Equipment")
public class EquipmentInfo implements Serializable {
	
	private static final long serialVersionUID = 4058477041506546472L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer equipment_id;
	
	private String equipment_name;
	
	private String equipment_type;
	
	private String equipment_code;
	
	private String equipment_state;
	
	private String equipment_manufacturer;

	public Integer getEquipment_id() {
		return equipment_id;
	}

	public void setEquipment_id(Integer equipment_id) {
		this.equipment_id = equipment_id;
	}

	public String getEquipment_name() {
		return equipment_name;
	}

	public void setEquipment_name(String equipment_name) {
		this.equipment_name = equipment_name;
	}

	public String getEquipment_type() {
		return equipment_type;
	}

	public void setEquipment_type(String equipment_type) {
		this.equipment_type = equipment_type;
	}

	public String getEquipment_code() {
		return equipment_code;
	}

	public void setEquipment_code(String equipment_code) {
		this.equipment_code = equipment_code;
	}

	public String getEquipment_state() {
		return equipment_state;
	}

	public void setEquipment_state(String equipment_state) {
		this.equipment_state = equipment_state;
	}

	public String getEquipment_manufacturer() {
		return equipment_manufacturer;
	}

	public void setEquipment_manufacturer(String equipment_manufacturer) {
		this.equipment_manufacturer = equipment_manufacturer;
	}

}
