package com.hilonggroupmes.domain.plan;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 计划信息实体类
 * 
 * <p>记录计划的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * <p>plan_id 订单信息主键
 * 
 * <p>plan_number 订单号
 * 
 * <p>plan_begintime 计划开始时间
 * 
 * <p>plan_endtime 计划完成时间
 * 
 * <p>plan_principal 负责人
 * 
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */
@Entity
@Table(name="MES_Plan")
public class PlanInfo implements Serializable {
	
	private static final long serialVersionUID = -4823885965031312267L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
   private Integer plan_id;
   
   private String plan_number;
   
   private Integer plan_order;
   
   private Date plan_begintime;
   
   private Date plan_endtime;
   
   private String plan_principal; 

public Integer getPlan_id() {
	return plan_id;
}

public void setPlan_id(Integer plan_id) {
	this.plan_id = plan_id;
}

public String getPlan_number() {
	return plan_number;
}

public void setPlan_number(String plan_number) {
	this.plan_number = plan_number;
}

public Integer getPlan_order() {
	return plan_order;
}

public void setPlan_order(Integer plan_order) {
	this.plan_order = plan_order;
}

public Date getPlan_begintime() {
	return plan_begintime;
}

public void setPlan_begintime(Date plan_begintime) {
	this.plan_begintime = plan_begintime;
}

public Date getPlan_endtime() {
	return plan_endtime;
}

public void setPlan_endtime(Date plan_endtime) {
	this.plan_endtime = plan_endtime;
}

public String getPlan_principal() {
	return plan_principal;
}

public void setPlan_principal(String plan_principal) {
	this.plan_principal = plan_principal;
}   
  
}
