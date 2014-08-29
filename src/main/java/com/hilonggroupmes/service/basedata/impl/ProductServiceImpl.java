package com.hilonggroupmes.service.basedata.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hilonggroupmes.dao.basedata.ProductDao;
import com.hilonggroupmes.domain.basedata.ProductInfo;
import com.hilonggroupmes.service.basedata.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductDao productDao;

	@Override
	public Long getProductNum(Map<String, Object> queryPare) {
		return productDao.getProductNum(queryPare);
	}

	@Override
	public List<ProductInfo> findProductByPage(Integer page, Integer rows,
			Map<String, Object> queryPare) {
		
		return productDao.getProductByPage(page, rows, queryPare);
	}

	@Override
	public Boolean deleteProductByIds(String productIds) {        
		try{
			productDao.deleteProductByIds(productIds);
		}catch(Exception e)
		{
			System.out.println(e.toString());
			return false;
		}
		return true;
	}

	@Override
	public ProductInfo findProductById(Long product_id) {
		return productDao.get(ProductInfo.class, product_id);
	}

	@Override
	public Long saveProduct(ProductInfo product) {
		return (Long)productDao.save(product);
	}

	@Override
	public void updateProduct(ProductInfo product) {
		productDao.update(product);
	}
}
