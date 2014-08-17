package com.hilonggroupmes.domain.process;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 工艺顺序信息实体类
 * 
 * <p>记录某项目生产工艺顺序的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * <p>processitem_id 工艺信息主键
 *	
 * <p>processitem_proceduce 工序标识
 * 
 * <p>processitem_begintag 是否第一工序
 * 
 * <p>processitem_nextpro 下一工序
 * 
 * <p>processitem_failspro 打回工序
 *	
 * <p>processitem_fortask 所属任务
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */

@Entity
@Table(name="MES_ProcessItem")
public class ProcessItemInfo implements Serializable {

	private static final long serialVersionUID = 7708687143310088969L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer processitem_id;
	
	private String processitem_proceduce;
	
	private String processitem_begintag;
	
	private Integer processitem_nextpro;
	
	private Integer processitem_failspro;
	
	private Integer processitem_fortask;

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

	public String getProcessitem_begintag() {
		return processitem_begintag;
	}

	public void setProcessitem_begintag(String processitem_begintag) {
		this.processitem_begintag = processitem_begintag;
	}

	public Integer getProcessitem_nextpro() {
		return processitem_nextpro;
	}

	public void setProcessitem_nextpro(Integer processitem_nextpro) {
		this.processitem_nextpro = processitem_nextpro;
	}

	public Integer getProcessitem_failspro() {
		return processitem_failspro;
	}

	public void setProcessitem_failspro(Integer processitem_failspro) {
		this.processitem_failspro = processitem_failspro;
	}

	public Integer getProcessitem_fortask() {
		return processitem_fortask;
	}

	public void setProcessitem_fortask(Integer processitem_fortask) {
		this.processitem_fortask = processitem_fortask;
	}

}
