package com.hilonggroupmes.domain.process;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 基管、衬管信息实体类（工序流转用）
 * 
 * <p>记录基管、衬管所涉及到的记录信息的明细列表
 * 
 * <p>属性信息描述：
 * 
 * <p>pipe_Id 基管、衬管主键
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
@Table(name="MES_LinePipe")
public class PipeInfo implements Serializable {
	
	private static final long serialVersionUID = 7491704393770517116L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer linepipe_Id;
	
    private String linepipe_num;
    
    private Integer linepipe_type;
    
    private Integer linepipe_state;
    
    private Integer linepipe_forpro;

	public Integer getLinepipe_Id() {
		return linepipe_Id;
	}

	public void setLinepipe_Id(Integer linepipe_Id) {
		this.linepipe_Id = linepipe_Id;
	}

	public String getLinepipe_num() {
		return linepipe_num;
	}

	public void setLinepipe_num(String linepipe_num) {
		this.linepipe_num = linepipe_num;
	}

	public Integer getLinepipe_type() {
		return linepipe_type;
	}

	public void setLinepipe_type(Integer linepipe_type) {
		this.linepipe_type = linepipe_type;
	}

	public Integer getLinepipe_state() {
		return linepipe_state;
	}

	public void setLinepipe_state(Integer linepipe_state) {
		this.linepipe_state = linepipe_state;
	}

	public Integer getLinepipe_forpro() {
		return linepipe_forpro;
	}

	public void setLinepipe_forpro(Integer linepipe_forpro) {
		this.linepipe_forpro = linepipe_forpro;
	}

}
