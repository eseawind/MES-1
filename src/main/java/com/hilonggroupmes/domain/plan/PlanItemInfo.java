package com.hilonggroupmes.domain.plan;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 计划物料明细信息实体类
 * 
 * <p>记录计划物料明细的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * <p>planitem_id 计划明细信息主键
 * 
 * <p>planitem_plan 订单明细信息主键
 * 
 * <p>planitem_materialtype 材料类型 （1 主材料钢管  2其他附属材料）
 * 
 * <p>planitem_detailtype 二级明细类型（分别和pipetype、material做外键记录）
 * 
 * <p>planitem_quantity 材料数量
 * 
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */
@Entity
@Table(name="MES_PlanItem")
public class PlanItemInfo implements Serializable {
	
	private static final long serialVersionUID = 3308283484462072634L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer planitem_id;
	
	private Integer planitem_plan;
	
	private Integer planitem_detailtype;
	
	private Integer planitem_materialtype;
	
	private Double planitem_quantity;

	public Integer getPlanitem_id() {
		return planitem_id;
	}

	public void setPlanitem_id(Integer planitem_id) {
		this.planitem_id = planitem_id;
	}

	public Integer getPlanitem_plan() {
		return planitem_plan;
	}

	public void setPlanitem_plan(Integer planitem_plan) {
		this.planitem_plan = planitem_plan;
	}

	public Integer getPlanitem_detailtype() {
		return planitem_detailtype;
	}

	public void setPlanitem_detailtype(Integer planitem_detailtype) {
		this.planitem_detailtype = planitem_detailtype;
	}

	public Integer getPlanitem_materialtype() {
		return planitem_materialtype;
	}

	public void setPlanitem_materialtype(Integer planitem_materialtype) {
		this.planitem_materialtype = planitem_materialtype;
	}

	public Double getPlanitem_quantity() {
		return planitem_quantity;
	}

	public void setPlanitem_quantity(Double planitem_quantity) {
		this.planitem_quantity = planitem_quantity;
	}

}
