package com.hilonggroupmes.domain.order;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 订单信息实体类
 * 
 * <p>记录订单的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * <p>order_id 订单信息主键
 * 
 * <p>order_number 订单号
 * 
 * <p>order_project 项目名称
 * 
 * <p>order_contractnumber 合同号
 * 
 * <p>order_consignee 交付单位
 * 
 * <p>order_deliverydate 交付时间
 * 
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */
@Entity
@Table(name="MES_Order")
public class OrderInfo implements Serializable {
		
	private static final long serialVersionUID = -3063071163182944839L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer order_id;
	
	private Integer order_number;
	
	private String order_project;
	
	private String order_contractnumber;
	
	private String order_consignee;
	
	private String order_deliverydate;

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getOrder_number() {
		return order_number;
	}

	public void setOrder_number(Integer order_number) {
		this.order_number = order_number;
	}

	public String getOrder_project() {
		return order_project;
	}

	public void setOrder_project(String order_project) {
		this.order_project = order_project;
	}

	public String getOrder_contractnumber() {
		return order_contractnumber;
	}

	public void setOrder_contractnumber(String order_contractnumber) {
		this.order_contractnumber = order_contractnumber;
	}

	public String getOrder_consignee() {
		return order_consignee;
	}

	public void setOrder_consignee(String order_consignee) {
		this.order_consignee = order_consignee;
	}

	public String getOrder_deliverydate() {
		return order_deliverydate;
	}

	public void setOrder_deliverydate(String order_deliverydate) {
		this.order_deliverydate = order_deliverydate;
	}

}
