package com.hilonggroupmes.domain.basedata;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 钢管类型信息实体类
 * 
 * <p>记录钢管类型的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * pipetype_id  钢管类型信息主键
 *	
 * pipetype_name 类型名称
 *	
 * pipetype_spc 执行标准
 *	
 * pipetype_steelgrade 钢级
 *	
 * pipetype_type 钢管类型 ：1 基管   2 衬管   3 复合管
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
	private Integer pipetype_id;
	
	private String pipetype_name;
	
	private String pipetype_spc;
	
	private String pipetype_steelgrade;
	
	private Integer pipetype_type;

	public Integer getPipetype_id() {
		return pipetype_id;
	}

	public void setPipetype_id(Integer pipetype_id) {
		this.pipetype_id = pipetype_id;
	}

	public String getPipetype_name() {
		return pipetype_name;
	}

	public void setPipetype_name(String pipetype_name) {
		this.pipetype_name = pipetype_name;
	}

	public String getPipetype_spc() {
		return pipetype_spc;
	}

	public void setPipetype_spc(String pipetype_spc) {
		this.pipetype_spc = pipetype_spc;
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

}
