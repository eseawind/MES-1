package com.hilonggroupmes.domain.process;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hilonggroupmes.domain.basedata.ProductInfo;

/**
 * 产品工艺顺序信息实体类
 * 
 * <p>记录某产品工艺生产工序的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * <p>productprocess_id 工艺信息主键
 *	
 * <p>productprocess_proceduce 工序标识
 * 
 * <p>productprocess_sequence 工序顺序
 * 
 * <p>productprocess_failspro 打回工序
 *	
 * <p>productprocess_forproduct 对应产品
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */

@Entity
@Table(name="MES_ProductProcess")
public class ProductProcessInfo implements Serializable {

	private static final long serialVersionUID = 7708687143310088969L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productprocess_id;
	
	private String productprocess_proceduce;
	
	private Integer productprocess_sequence;
	
	private String productprocess_failspro;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="productprocess_productid", referencedColumnName="product_id")
	private ProductInfo productprocess_forproduct;

	public Integer getProductprocess_id() {
		return productprocess_id;
	}

	public void setProductprocess_id(Integer productprocess_id) {
		this.productprocess_id = productprocess_id;
	}

	public String getProductprocess_proceduce() {
		return productprocess_proceduce;
	}

	public void setProductprocess_proceduce(String productprocess_proceduce) {
		this.productprocess_proceduce = productprocess_proceduce;
	}

	public Integer getProductprocess_sequence() {
		return productprocess_sequence;
	}

	public void setProductprocess_sequence(Integer productprocess_sequence) {
		this.productprocess_sequence = productprocess_sequence;
	}

	public String getProductprocess_failspro() {
		return productprocess_failspro;
	}

	public void setProductprocess_failspro(String productprocess_failspro) {
		this.productprocess_failspro = productprocess_failspro;
	}

	public ProductInfo getProductprocess_forproduct() {
		return productprocess_forproduct;
	}

	public void setProductprocess_forproduct(ProductInfo productprocess_forproduct) {
		this.productprocess_forproduct = productprocess_forproduct;
	}

}
