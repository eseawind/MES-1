package com.hilonggroupmes.domain.basedata;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 物料信息实体类
 * 
 * <p>记录物料的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * <p>material_id 物料信息主键
 * 
 * <p>material_name 物料名称
 * 
 * <p>material_code 物料编码
 * 
 * <p>material_spec 物料规格
 * 
 * <p>material_manufacturer 物料厂商
 * 
 * <p>material_quantity 物料数量
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */

@Entity
@Table(name="MES_Material")
public class MaterialInfo implements Serializable {
	
	private static final long serialVersionUID = 8850205332210771546L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer material_id;
	
	private String material_name;
	
	private String material_code;
	
	private String material_spec;
	
	private String material_manufacturer;
	
	private Integer material_quantity;

	public Integer getMaterial_id() {
		return material_id;
	}

	public void setMaterial_id(Integer material_id) {
		this.material_id = material_id;
	}

	public String getMaterial_name() {
		return material_name;
	}

	public void setMaterial_name(String material_name) {
		this.material_name = material_name;
	}

	public String getMaterial_code() {
		return material_code;
	}

	public void setMaterial_code(String material_code) {
		this.material_code = material_code;
	}

	public String getMaterial_spec() {
		return material_spec;
	}

	public void setMaterial_spec(String material_spec) {
		this.material_spec = material_spec;
	}

	public String getMaterial_manufacturer() {
		return material_manufacturer;
	}

	public void setMaterial_manufacturer(String material_manufacturer) {
		this.material_manufacturer = material_manufacturer;
	}

	public Integer getMaterial_quantity() {
		return material_quantity;
	}

	public void setMaterial_quantity(Integer material_quantity) {
		this.material_quantity = material_quantity;
	}

}
