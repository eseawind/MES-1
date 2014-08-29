package com.hilonggroupmes.service.basedata;

import java.util.List;
import java.util.Map;

import com.hilonggroupmes.domain.basedata.ProductInfo;

public interface ProductService {
	
	public Long getProductNum(Map<String,Object> queryPare);
	
	public List<ProductInfo> findProductByPage(Integer page, Integer rows, Map<String,Object> queryPare);
	
	public Boolean deleteProductByIds(String productIds);
	
	public ProductInfo findProductById(Long product_id);
	
	public Long saveProduct(ProductInfo product);
	
	public void updateProduct(ProductInfo product);

}
