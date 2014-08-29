package com.hilonggroupmes.dao.basedata.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hilonggroupmes.dao.base.impl.BaseDaoImpl;
import com.hilonggroupmes.dao.basedata.ProductDao;
import com.hilonggroupmes.domain.basedata.ProductInfo;
import com.hilonggroupmes.utils.CommonUtils;

@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<ProductInfo> implements
		ProductDao {


	@Override
	public void deleteProductById(Long product_id) {
		super.executeHql("delete from ProductInfo p "
				+ "where p.product_id="+ product_id);
	}

	@Override
	public List<ProductInfo> getProductByPage(Integer page, Integer rows,
			Map<String, Object> paremeters) {
	        Map<String,Object> queryInfo = CommonUtils.buildQuery("ProductInfo",paremeters);
	        String hql_query = (String) queryInfo.get("hql_query");
	        List<Object> pare_query = (List<Object>) queryInfo.get("pare_query");
			return super.find(hql_query, pare_query, page, rows);
	}

	@Override
	public Long getProductNum(Map<String, Object> paremeters) {
	        Map<String,Object> queryInfo = CommonUtils.buildQuery("ProductInfo",paremeters);
	        String hql_query = (String) queryInfo.get("hql_query");
	        List<Object> pare_query = (List<Object>) queryInfo.get("pare_query");
		return super.count(hql_query, pare_query);
	}

	@Override
	public void deleteProductByIds(String ids) {
		super.executeHql("delete from ProductInfo p where p.product_id in(" + ids +")");
	}

	@Override
	public ProductInfo getProductById(Long product_id) {
		return super.get(ProductInfo.class, product_id);
	}

}
