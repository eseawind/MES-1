package com.hilonggroupmes.dao.process;

import java.util.List;

import com.hilonggroupmes.domain.basedata.ProductInfo;
import com.hilonggroupmes.domain.process.ProductProcessInfo;

public interface ProductProcessDao {
	
	public List<ProductProcessInfo> getProductProcessByProduct(ProductInfo pi);

}
