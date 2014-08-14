package com.hilonggroupmes.domain.process;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 基管、衬管信息实体类
 * 
 * <p>记录基管、衬管管所涉及到的记录信息的明细列表
 * 
 * <p>属性信息描述：
 * 
 * <p>pipe_Id 基管衬管主键
 *	
 * <p>pipe_num 编号
 *	
 * <p>pipe_type 类型
 * 
 * <p>pipe_state 状态（1 合格  2 不合格   3 报废 ）
 * 
 * <p>pipe_forpro 所属项目订单
 * 
 * @author fuweijie
 * 
 * @version 2014.8.3.1
 *
 */

@Entity
@Table(name="MES_Pipe")
public class PipeInfo implements Serializable {
	
	private static final long serialVersionUID = 7491704393770517116L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pipe_Id;
	
    private String pipe_num;
    
    private Integer pipe_type;
    
    private Integer pipe_state;
    
    private Integer pipe_forpro;

	public Integer getPipe_Id() {
		return pipe_Id;
	}

	public void setPipe_Id(Integer pipe_Id) {
		this.pipe_Id = pipe_Id;
	}

	public String getPipe_num() {
		return pipe_num;
	}

	public void setPipe_num(String pipe_num) {
		this.pipe_num = pipe_num;
	}

	public Integer getPipe_type() {
		return pipe_type;
	}

	public void setPipe_type(Integer pipe_type) {
		this.pipe_type = pipe_type;
	}

	public Integer getPipe_state() {
		return pipe_state;
	}

	public void setPipe_state(Integer pipe_state) {
		this.pipe_state = pipe_state;
	}

	public Integer getPipe_forpro() {
		return pipe_forpro;
	}

	public void setPipe_forpro(Integer pipe_forpro) {
		this.pipe_forpro = pipe_forpro;
	}

}
