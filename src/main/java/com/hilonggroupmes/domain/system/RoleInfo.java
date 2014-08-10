package com.hilonggroupmes.domain.system;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色信息实体类
 * 
 * <p>记录角色的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * <p>role_id 角色信息主键
 * 
 * <p>role_code 角色信息编码
 * 
 * <p>role_name 角色名称
 * 
 * <p>role_remark 角色备注
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */
@Entity
@Table(name="MES_Role")
public class RoleInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4478767553957097426L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer role_id;
	
	private String role_code;
	
	private String role_name;
	
	private String role_remark;

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_remark() {
		return role_remark;
	}

	public void setRole_remark(String role_remark) {
		this.role_remark = role_remark;
	}
	
}
