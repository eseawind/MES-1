package com.hilonggroupmes.domain.process;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private Integer processitem_id;
	
	private String processitem_proceduce;
	
	private Integer productprocess_sequence;
	
	private String processitem_failspro;
	
	private Integer processitem_forproduct;

	public Integer getProcessitem_id() {
		return processitem_id;
	}

	public void setProcessitem_id(Integer processitem_id) {
		this.processitem_id = processitem_id;
	}

	public String getProcessitem_proceduce() {
		return processitem_proceduce;
	}

	public void setProcessitem_proceduce(String processitem_proceduce) {
		this.processitem_proceduce = processitem_proceduce;
	}

	public Integer getProductprocess_sequence() {
		return productprocess_sequence;
	}

	public void setProductprocess_sequence(Integer productprocess_sequence) {
		this.productprocess_sequence = productprocess_sequence;
	}

	public String getProcessitem_failspro() {
		return processitem_failspro;
	}

	public void setProcessitem_failspro(String processitem_failspro) {
		this.processitem_failspro = processitem_failspro;
	}

	public Integer getProcessitem_forproduct() {
		return processitem_forproduct;
	}

	public void setProcessitem_forproduct(Integer processitem_forproduct) {
		this.processitem_forproduct = processitem_forproduct;
	}

}
