package com.hilonggroupmes.dao.process.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hilonggroupmes.dao.base.impl.BaseDaoImpl;
import com.hilonggroupmes.dao.process.ProductProcessDao;
import com.hilonggroupmes.domain.basedata.ProductInfo;
import com.hilonggroupmes.domain.process.ProductProcessInfo;

@Repository("productProcessDao")
public class ProductProcessDaoImpl extends BaseDaoImpl<ProductProcessInfo>
		implements ProductProcessDao {

	@Override
	public List<ProductProcessInfo> getProductProcessByProduct(ProductInfo pi) {
		Object[] param = {pi};
		String h_getProductProcess ="from ProductProcessInfo p where p.productprocess_forproduct=?";
		return super.find(h_getProductProcess,param);
	}

}
