package com.hilonggroupmes.domain.system;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 权限信息实体类
 * 
 * <p>记录权限的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * <p>right_id 权限信息主键
 * 
 * <p>right_code 权限信息编码
 * 
 * <p>right_name 权限名称
 * 
 * <p>right_value 权限值
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */

@Entity
@Table(name="MES_Right")
public class RightInfo implements Serializable {
	
	private static final long serialVersionUID = -251531494898540606L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer right_id;
	
	private String right_name;
	
	private String right_code;
	
	private String right_value;

	public Integer getRight_id() {
		return right_id;
	}

	public void setRight_id(Integer right_id) {
		this.right_id = right_id;
	}

	public String getRight_name() {
		return right_name;
	}

	public void setRight_name(String right_name) {
		this.right_name = right_name;
	}

	public String getRight_code() {
		return right_code;
	}

	public void setRight_code(String right_code) {
		this.right_code = right_code;
	}

	public String getRight_value() {
		return right_value;
	}

	public void setRight_value(String right_value) {
		this.right_value = right_value;
	}

}
