package com.hilonggroupmes.domain.basedata;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 产品信息实体类
 * 
 * <p>记录产品的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * <p>product_id  产品信息主键
 *	
 * <p>product_name 产品名称
 *	
 * <p>product_code 产品编码
 *	
 * <p>product_spec 执行标准
 * 
 * <p>product_steelgrade 产品钢级
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */
@Entity
@Table(name="MES_Product")
public class ProductInfo implements Serializable  {
	
	private static final long serialVersionUID = 1366742421283130049L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long product_id;
	
	private String product_name;
	
	private String product_code;
	
	private String product_spec;
	
	private String product_steelgrade;

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getProduct_spec() {
		return product_spec;
	}
	
	public void setProduct_spec(String product_spec) {
		this.product_spec = product_spec;
	}

	public String getProduct_steelgrade() {
		return product_steelgrade;
	}

	public void setProduct_steelgrade(String product_steelgrade) {
		this.product_steelgrade = product_steelgrade;
	}	
}
