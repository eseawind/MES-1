package com.hilonggroupmes.domain.system;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 部门信息实体类
 * 
 * <p>记录部门的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * <p>department_id 部门信息主键
 * 
 * <p>department_code 部门信息编码
 * 
 * <p>department_name 部门名称
 * 
 * <p>department_for 所属上级部门主键
 * 
 * <p>department_remark 部门信息备注
 * 
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */
@Entity
@Table(name="MES_Department")
public class DepartmentInfo implements Serializable {
	
	private static final long serialVersionUID = 8745335367366164067L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer department_Id;
	
	private String department_code;
	
	private String department_name;
	
	private Integer department_for;
	
	private String department_remark;

	public Integer getDepartment_Id() {
		return department_Id;
	}

	public void setDepartment_Id(Integer department_Id) {
		this.department_Id = department_Id;
	}

	public String getDepartment_code() {
		return department_code;
	}

	public void setDepartment_code(String department_code) {
		this.department_code = department_code;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public Integer getDepartment_for() {
		return department_for;
	}

	public void setDepartment_for(Integer department_for) {
		this.department_for = department_for;
	}

	public String getDepartment_remark() {
		return department_remark;
	}

	public void setDepartment_remark(String department_remark) {
		this.department_remark = department_remark;
	}
}
