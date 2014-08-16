package com.hilonggroupmes.domain.order;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 订单明细信息实体类
 * 
 * <p>记录订单明细的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * <p>orderitem_id 订单明细信息主键
 * 
 * <p>orderitem_order 所属订单号
 * 
 * <p>orderitem_producttype 产品类型
 * 
 * <p>orderitem_quantity 产品数量
 * 
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */
@Entity
@Table(name="MES_OrderItem")
public class OrderItemInfo implements Serializable {
	
	private static final long serialVersionUID = 3308283484462072634L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer orderitem_id;
	
	private Integer orderitem_order;
	
	private Integer orderitem_producttype;
	
	private Double orderitem_quantity;

	public Integer getOrderitem_id() {
		return orderitem_id;
	}

	public void setOrderitem_id(Integer orderitem_id) {
		this.orderitem_id = orderitem_id;
	}

	public Integer getOrderitem_order() {
		return orderitem_order;
	}

	public void setOrderitem_order(Integer orderitem_order) {
		this.orderitem_order = orderitem_order;
	}

	public Integer getOrderitem_producttype() {
		return orderitem_producttype;
	}

	public void setOrderitem_producttype(Integer orderitem_producttype) {
		this.orderitem_producttype = orderitem_producttype;
	}

	public Double getOrderitem_quantity() {
		return orderitem_quantity;
	}

	public void setOrderitem_quantity(Double orderitem_quantity) {
		this.orderitem_quantity = orderitem_quantity;
	}

}
