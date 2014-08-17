package com.hilonggroupmes.domain.task;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 任务信息实体类
 * 
 * <p>记录任务的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * <p>task_id 任务信息主键
 * 
 * <p>task_code 任务编码
 * 
 * <p>task_productspc 生产标准
 * 
 * <p>task_acceptspc 检验标准
 * 
 * <p>task_weldtype 焊接类型
 * 
 * <p>task_process 任务工序
 * 
 * <p>task_order 关联订单
 * 
 * <p>task_state 任务状态
 * 
 * <p>task_bigintime 任务开始时间
 * 
 * <p>task_endtime 任务结束时间
 * 
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */
@Entity
@Table(name="MES_Task")
public class TaskInfo implements Serializable {
	
	private static final long serialVersionUID = 6562449000866199442L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer task_id;
	
	private Integer task_code;
	
	private Integer task_productspc;
	
	private Integer task_acceptspc;
	
	private Integer task_order;
	
	private Integer task_state;
	
	private String task_weldtype;
	
	private Integer task_process;
	
	private Date task_bigintime;
	
	private Date task_endtime;

	public Integer getTask_id() {
		return task_id;
	}

	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}

	public Integer getTask_code() {
		return task_code;
	}

	public void setTask_code(Integer task_code) {
		this.task_code = task_code;
	}

	public Integer getTask_productspc() {
		return task_productspc;
	}

	public void setTask_productspc(Integer task_productspc) {
		this.task_productspc = task_productspc;
	}

	public Integer getTask_acceptspc() {
		return task_acceptspc;
	}

	public void setTask_acceptspc(Integer task_acceptspc) {
		this.task_acceptspc = task_acceptspc;
	}

	public Integer getTask_order() {
		return task_order;
	}

	public void setTask_order(Integer task_order) {
		this.task_order = task_order;
	}

	public Integer getTask_state() {
		return task_state;
	}

	public String getTask_weldtype() {
		return task_weldtype;
	}

	public void setTask_weldtype(String task_weldtype) {
		this.task_weldtype = task_weldtype;
	}

	public void setTask_state(Integer task_state) {
		this.task_state = task_state;
	}

	public Date getTask_bigintime() {
		return task_bigintime;
	}

	public void setTask_bigintime(Date task_bigintime) {
		this.task_bigintime = task_bigintime;
	}

	public Date getTask_endtime() {
		return task_endtime;
	}

	public void setTask_endtime(Date task_endtime) {
		this.task_endtime = task_endtime;
	}

	public Integer getTask_process() {
		return task_process;
	}

	public void setTask_process(Integer task_process) {
		this.task_process = task_process;
	}	
}
