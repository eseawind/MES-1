package com.hilonggroupmes.domain.basedata;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 钢管原材料类型信息实体类
 * 
 * <p>记录钢管类型的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * <p>pipetype_id  钢管类型信息主键
 *	
 * <p>pipetype_name 类型名称
 *	
 * <p>pipetype_spc 执行标准
 *	
 * <p>pipetype_steelgrade 钢级
 *	
 * <p>pipetype_type 钢管类型 ：1 基管   2 衬管
 * 
 * <p>pipetype_supplier
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */

@Entity
@Table(name="MES_PipeType")
public class PipeTypeInfo implements Serializable {
	
	private static final long serialVersionUID = -5143545904943742468L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pipetype_id;
	
	private String pipetype_name;
	
	private String pipetype_spec;
	
	private String pipetype_steelgrade;
	
	private Integer pipetype_type;
	
	private String pipetype_supplier;

	public Long getPipetype_id() {
		return pipetype_id;
	}

	public void setPipetype_id(Long pipetype_id) {
		this.pipetype_id = pipetype_id;
	}

	public String getPipetype_name() {
		return pipetype_name;
	}

	public void setPipetype_name(String pipetype_name) {
		this.pipetype_name = pipetype_name;
	}

	public String getPipetype_spec() {
		return pipetype_spec;
	}

	public void setPipetype_spec(String pipetype_spec) {
		this.pipetype_spec = pipetype_spec;
	}

	public String getPipetype_steelgrade() {
		return pipetype_steelgrade;
	}

	public void setPipetype_steelgrade(String pipetype_steelgrade) {
		this.pipetype_steelgrade = pipetype_steelgrade;
	}

	public Integer getPipetype_type() {
		return pipetype_type;
	}

	public void setPipetype_type(Integer pipetype_type) {
		this.pipetype_type = pipetype_type;
	}

	public String getPipetype_supplier() {
		return pipetype_supplier;
	}

	public void setPipetype_supplier(String pipetype_supplier) {
		this.pipetype_supplier = pipetype_supplier;
	}

}
