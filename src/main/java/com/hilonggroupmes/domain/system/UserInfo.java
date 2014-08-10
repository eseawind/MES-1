package com.hilonggroupmes.domain.system;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户信息实体类
 * 
 * 记录用户的相关属性信息 
 * 
 * 属性信息描述：
 * 
 * <p>user_id 用户信息主键
 * 
 * <p>user_accont 用户账号
 * 
 * <p>user_name 用户名称
 * 
 * <p>user_password 用户密码
 * 
 * <p>user_department 用户所属部门
 * 
 * <p>user_role 用户所属角色
 * 
 * <p>user_state 用户状态 
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */

@Entity
@Table(name="MES_User")
public class UserInfo implements Serializable  {
	
	
	private static final long serialVersionUID = -4589666052411999372L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long user_id;  
	
	private String user_accont; 
	
	private String user_name; 
	
	private String user_password; 
	
	private Integer user_department;
	
	private Integer user_role;
	
	private Boolean user_state; 

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_accont() {
		return user_accont;
	}

	public void setUser_accont(String user_accont) {
		this.user_accont = user_accont;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public Integer getUser_department() {
		return user_department;
	}

	public void setUser_department(Integer user_department) {
		this.user_department = user_department;
	}

	public Integer getUser_role() {
		return user_role;
	}

	public void setUser_role(Integer user_role) {
		this.user_role = user_role;
	}

	public Boolean getUser_state() {
		return user_state;
	}

	public void setUser_state(Boolean user_state) {
		this.user_state = user_state;
	}

}
