package com.hilonggroupmes.domain.process;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 工序操作记录子项信息实体类
 * 
 * <p>记录某项目生产工序操作记录明细的相关属性信息 
 * 
 * <p>属性信息描述：
 * 
 * <p> processrecorditem_id 工序操作记录明细主键
 *	
 * <p> processrecorditem_name 工序操作记录明细项名称
 *	
 * <p> processrecorditem_value 工序操作记录明细项值
 *	
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */

@Entity
@Table(name="MES_ProcessRecordItem")
public class ProcessRecordItemInfo implements Serializable {

	private static final long serialVersionUID = 7708687143310088969L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer processrecorditem_id;
	
	private String processrecord_name;
	
	private String processrecord_value;

	public Integer getProcessrecorditem_id() {
		return processrecorditem_id;
	}

	public void setProcessrecorditem_id(Integer processrecorditem_id) {
		this.processrecorditem_id = processrecorditem_id;
	}

	public String getProcessrecord_name() {
		return processrecord_name;
	}

	public void setProcessrecord_name(String processrecord_name) {
		this.processrecord_name = processrecord_name;
	}

	public String getProcessrecord_value() {
		return processrecord_value;
	}

	public void setProcessrecord_value(String processrecord_value) {
		this.processrecord_value = processrecord_value;
	}
	
}
