package com.hilonggroupmes.domain.process;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 工艺信息实体类
 * 
 * <p>记录工艺的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * <p>process_id 工艺信息主键
 *	
 * <p>process_name 工艺名称
 *	
 * <p>process_code 工艺编码
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */

@Entity
@Table(name="MES_Process")
public class ProcessInfo implements Serializable {

	private static final long serialVersionUID = 7708687143310088969L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer process_id;
	
	private String process_name;
	
	private String process_code;

	public Integer getProcess_id() {
		return process_id;
	}

	public void setProcess_id(Integer process_id) {
		this.process_id = process_id;
	}

	public String getProcess_name() {
		return process_name;
	}

	public void setProcess_name(String process_name) {
		this.process_name = process_name;
	}

	public String getProcess_code() {
		return process_code;
	}

	public void setProcess_code(String process_code) {
		this.process_code = process_code;
	}
	
	
	
}
