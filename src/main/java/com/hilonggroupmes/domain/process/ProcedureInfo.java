package com.hilonggroupmes.domain.process;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 工序信息实体类
 * 
 * <p>记录工序的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * <p>procedure_id 工序信息主键
 *	
 * <p>procedure_name 工序名称
 *	
 * <p>procedure_code 工序编码
 * 
 * <p>procedure_type 工序类型（内部、外协）
 * 
 * <p>procedure_equipment 工序设备
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */

@Entity
@Table(name="MES_Procedure")
public class ProcedureInfo implements Serializable {
	
	private static final long serialVersionUID = -4888995133003966314L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long procedure_id;
	
	private String procedure_name;
	
	private String procedure_code;
	
	private Integer procedure_type;
	
	private String procedure_equipment;
	
	@JsonIgnore
	@OneToMany(mappedBy = "procedureitem_procedure",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<ProcedureItemInfo> procedure_items = new ArrayList<ProcedureItemInfo>();

	public Long getProcedure_id() {
		return procedure_id;
	}

	public void setProcedure_id(Long procedure_id) {
		this.procedure_id = procedure_id;
	}

	public String getProcedure_name() {
		return procedure_name;
	}

	public void setProcedure_name(String procedure_name) {
		this.procedure_name = procedure_name;
	}

	public String getProcedure_code() {
		return procedure_code;
	}

	public void setProcedure_code(String procedure_code) {
		this.procedure_code = procedure_code;
	}

	public Integer getProcedure_type() {
		return procedure_type;
	}

	public void setProcedure_type(Integer procedure_type) {
		this.procedure_type = procedure_type;
	}

	public String getProcedure_equipment() {
		return procedure_equipment;
	}

	public void setProcedure_equipment(String procedure_equipment) {
		this.procedure_equipment = procedure_equipment;
	}

	public List<ProcedureItemInfo> getProcedure_items() {
		return procedure_items;
	}

	public void setProcedure_items(List<ProcedureItemInfo> procedure_items) {
		this.procedure_items = procedure_items;
	}

}
