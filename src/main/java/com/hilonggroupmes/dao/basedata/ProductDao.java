package com.hilonggroupmes.dao.basedata;

import java.util.List;
import java.util.Map;

import com.hilonggroupmes.dao.base.BaseDao;
import com.hilonggroupmes.domain.basedata.ProductInfo;

public interface ProductDao extends BaseDao<ProductInfo> {
	
	/**
	 * 根据主键ID删除产品信息实体
	 * @author 付伟杰
	 * @param product_id 要删除的钢管信息的主键ID
	 */
	public void deleteProductById(Long product_id);
	
	public List<ProductInfo> getProductByPage(Integer page,Integer rows,Map<String,Object> paremeters);

	public Long getProductNum(Map<String,Object> paremeters);
	
	public void deleteProductByIds(String ids);
	
	public ProductInfo getProductById(Long product_id);

}
