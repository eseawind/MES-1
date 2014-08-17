package com.hilonggroupmes.domain.process;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 工序操作记录信息实体类
 * 
 * <p>记录某项目生产工序操作记录的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * <p> processrecord_id 工序操作记录主键
 *	
 * <p> processrecord_fortask 所属任务
 *	
 * <p> processrecord_person 操作人
 *	
 * <p>processrecord_pipe 操作对应的钢管
 *	
 * <p>processrecord_date 操作时间
 * 
 * <p>processrecord_process 所属工序
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */

@Entity
@Table(name="MES_ProcessRecord")
public class ProcessRecordInfo implements Serializable {

	private static final long serialVersionUID = 7708687143310088969L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer processrecord_id;
	
	private String processrecord_fortask;
	
	private String processrecord_person;
	
	private Integer processrecord_pipe;
	
	private Integer processrecord_date;
	
	private Integer processrecord_process;

	public Integer getProcessrecord_id() {
		return processrecord_id;
	}

	public void setProcessrecord_id(Integer processrecord_id) {
		this.processrecord_id = processrecord_id;
	}

	public String getProcessrecord_fortask() {
		return processrecord_fortask;
	}

	public void setProcessrecord_fortask(String processrecord_fortask) {
		this.processrecord_fortask = processrecord_fortask;
	}

	public String getProcessrecord_person() {
		return processrecord_person;
	}

	public void setProcessrecord_person(String processrecord_person) {
		this.processrecord_person = processrecord_person;
	}

	public Integer getProcessrecord_pipe() {
		return processrecord_pipe;
	}

	public void setProcessrecord_pipe(Integer processrecord_pipe) {
		this.processrecord_pipe = processrecord_pipe;
	}

	public Integer getProcessrecord_date() {
		return processrecord_date;
	}

	public void setProcessrecord_date(Integer processrecord_date) {
		this.processrecord_date = processrecord_date;
	}

	public Integer getProcessrecord_process() {
		return processrecord_process;
	}

	public void setProcessrecord_process(Integer processrecord_process) {
		this.processrecord_process = processrecord_process;
	}
	
	
}
