package com.hilonggroupmes.domain.process;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 复合(基)管信息实体类（工序流转用）
 * 
 * <p>记录复合管所涉及到的记录信息的明细列表，由于基管编号和复合管编号一致，只在装配过衬管后
 * 
 * <p>类型才有所改变，便于数据记录统一，复合管和基管采用同一实体
 * 
 * <p>属性信息描述：
 * 
 * <p>complexpipe_id 复合管主键
 * 
 * <p>complexpipe_num 复合管编号
 *	
 * <p>complexpipe_basepipe 所用基管
 *	
 * <p>complexpipe_linepipe 所用衬管
 * 
 * <p>complexpipe_type 复合管规格
 * 
 * <p>complexpipe_length 复合管长度
 * 
 * <p>complexpipe_weight 复合管重量
 * 
 * <p>complexpipe_forpro 所属项目订单
 * 
 * <p>complexpipe_state 复合管状态（可用、报废）
 * 
 * <p>complexpipe_process 所处工序
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */

@Entity
@Table(name="MES_ComplexPipe")
public class ComplexPipeInfo implements Serializable {
	
	private static final long serialVersionUID = -3647539416930465720L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer complexpipe_id;
	
	private Integer complexpipe_num;
	
	private Integer complexpipe_basepipe;
	
	private Integer complexpipe_linepipe;
	
	private Integer complexpipe_type;
	
	private Double complexpipe_length;
	
	private Double complexpipe_weight;
	
	private Integer complexpipe_forpro;
	
	private Integer complexpipe_state;
	
	private Integer complexpipe_process;

	public Integer getComplexpipe_id() {
		return complexpipe_id;
	}

	public void setComplexpipe_id(Integer complexpipe_id) {
		this.complexpipe_id = complexpipe_id;
	}

	public Integer getComplexpipe_num() {
		return complexpipe_num;
	}

	public void setComplexpipe_num(Integer complexpipe_num) {
		this.complexpipe_num = complexpipe_num;
	}

	public Integer getComplexpipe_basepipe() {
		return complexpipe_basepipe;
	}

	public void setComplexpipe_basepipe(Integer complexpipe_basepipe) {
		this.complexpipe_basepipe = complexpipe_basepipe;
	}

	public Integer getComplexpipe_linepipe() {
		return complexpipe_linepipe;
	}

	public void setComplexpipe_linepipe(Integer complexpipe_linepipe) {
		this.complexpipe_linepipe = complexpipe_linepipe;
	}

	public Integer getComplexpipe_type() {
		return complexpipe_type;
	}

	public void setComplexpipe_type(Integer complexpipe_type) {
		this.complexpipe_type = complexpipe_type;
	}

	public Double getComplexpipe_length() {
		return complexpipe_length;
	}

	public void setComplexpipe_length(Double complexpipe_length) {
		this.complexpipe_length = complexpipe_length;
	}

	public Double getComplexpipe_weight() {
		return complexpipe_weight;
	}

	public void setComplexpipe_weight(Double complexpipe_weight) {
		this.complexpipe_weight = complexpipe_weight;
	}

	public Integer getComplexpipe_forpro() {
		return complexpipe_forpro;
	}

	public void setComplexpipe_forpro(Integer complexpipe_forpro) {
		this.complexpipe_forpro = complexpipe_forpro;
	}

	public Integer getComplexpipe_state() {
		return complexpipe_state;
	}

	public void setComplexpipe_state(Integer complexpipe_state) {
		this.complexpipe_state = complexpipe_state;
	}

	public Integer getComplexpipe_process() {
		return complexpipe_process;
	}

	public void setComplexpipe_process(Integer complexpipe_process) {
		this.complexpipe_process = complexpipe_process;
	}
	

}
