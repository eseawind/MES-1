package com.hilonggroupmes.domain.process;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 复合管信息实体类
 * 
 * <p>记录复合管所涉及到的记录信息的明细列表
 * 
 * <p>属性信息描述：
 * 
 * <p>complexpipe_id 复合管主键
 * 
 * <p>complexpipe_num 复合管编号
 *	
 * <p>complexpipe_base 所用基管
 *	
 * <p>complexpipe_line 所用衬管
 * 
 * <p>complexpipe_type 复合管规格
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
	
	private Integer complexpipe_base;
	
	private Integer complexpipe_line;
	
	private Integer complexpipe_type;
	
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

	public Integer getComplexpipe_base() {
		return complexpipe_base;
	}

	public void setComplexpipe_base(Integer complexpipe_base) {
		this.complexpipe_base = complexpipe_base;
	}

	public Integer getComplexpipe_line() {
		return complexpipe_line;
	}

	public void setComplexpipe_line(Integer complexpipe_line) {
		this.complexpipe_line = complexpipe_line;
	}

	public Integer getComplexpipe_type() {
		return complexpipe_type;
	}

	public void setComplexpipe_type(Integer complexpipe_type) {
		this.complexpipe_type = complexpipe_type;
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
