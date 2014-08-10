package com.hilonggroupmes.domain.process;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 工序明细信息实体类
 * 
 * <p>记录工序中所涉及到的记录信息的明细列表
 * 
 * <p>属性信息描述：
 * 
 * <p>procedureitem_id 工序明细主键
 *	
 * <p>procedureitem_name 工序明细名称
 *	
 * <p>procedureitem_code 工序明细编码
 * 
 * <p>procedureitem_valuetype 工序明细记录值类型（整形，浮点型，字符型）
 * 
 * <p>procedureitem_valuescope 工序明细记录范围（1.5-2,sa1.5-sa2.0-sa2.5）
 * 
 * <p>procedureitem_procedure 工艺设备
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */

@Entity
@Table(name="MES_ProcedureItem")
public class ProcedureItemInfo implements Serializable {
	
	private static final long serialVersionUID = -4888995133003966314L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer procedureitem_id;
	
	private String procedureitem_name;
	
	private String procedureitem_code;
	
	private String procedureitem_type;
	
	private String procedureitem_valuescope;
	
	private Integer procedureitem_procedure;

	public Integer getProcedureitem_id() {
		return procedureitem_id;
	}

	public void setProcedureitem_id(Integer procedureitem_id) {
		this.procedureitem_id = procedureitem_id;
	}

	public String getProcedureitem_name() {
		return procedureitem_name;
	}

	public void setProcedureitem_name(String procedureitem_name) {
		this.procedureitem_name = procedureitem_name;
	}

	public String getProcedureitem_code() {
		return procedureitem_code;
	}

	public void setProcedureitem_code(String procedureitem_code) {
		this.procedureitem_code = procedureitem_code;
	}

	public String getProcedureitem_type() {
		return procedureitem_type;
	}

	public void setProcedureitem_type(String procedureitem_type) {
		this.procedureitem_type = procedureitem_type;
	}

	public String getProcedureitem_valuescope() {
		return procedureitem_valuescope;
	}

	public void setProcedureitem_valuescope(String procedureitem_valuescope) {
		this.procedureitem_valuescope = procedureitem_valuescope;
	}

	public Integer getProcedureitem_procedure() {
		return procedureitem_procedure;
	}

	public void setProcedureitem_procedure(Integer procedureitem_procedure) {
		this.procedureitem_procedure = procedureitem_procedure;
	}
	
}
