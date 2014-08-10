package com.hilonggroupmes.domain.process;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 工序信息实体类
 * 
 * <p>记录工序的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * <p>procedure_id 工艺信息主键
 *	
 * <p>procedure_name 工艺名称
 *	
 * <p>procedure_code 工艺编码
 * 
 * <p>procedure_type 工艺类型（内部、外协）
 * 
 * <p>procedure_equipment 工艺设备
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
	private Integer procedure_id;
	
	private String procedure_name;
	
	private String procedure_code;
	
	private String procedure_type;
	
	private String procedure_equipment;

	public Integer getProcedure_id() {
		return procedure_id;
	}

	public void setProcedure_id(Integer procedure_id) {
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

	public String getProcedure_type() {
		return procedure_type;
	}

	public void setProcedure_type(String procedure_type) {
		this.procedure_type = procedure_type;
	}

	public String getProcedure_equipment() {
		return procedure_equipment;
	}

	public void setProcedure_equipment(String procedure_equipment) {
		this.procedure_equipment = procedure_equipment;
	}

}
