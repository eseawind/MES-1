package com.hilonggroupmes.controller.basedata;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hilonggroupmes.domain.basedata.ProductInfo;
import com.hilonggroupmes.service.basedata.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	private Map<String,Object> resultinfo = new HashMap<String,Object>();	
	
	@RequestMapping("*/listProduct.do")
	@ResponseBody
	public Map<String,Object> userList(int page,int rows,String product_name,String product_code){		
		resultinfo.clear();
		Map<String,Object> queryPare = new HashMap<String,Object>();
		if(product_name!=null)
			queryPare.put("product_name", product_name);
		if(product_code!=null)
		    queryPare.put("product_code", product_code);
		resultinfo.put("total", productService.getProductNum(queryPare));
		resultinfo.put("rows", productService.findProductByPage(page, rows, queryPare));
		return resultinfo;		
	}
	
	@RequestMapping("*/delProduct.do")
	@ResponseBody
	public Map<String,Object> userDel(HttpServletRequest request){
		String productIds = request.getParameter("delids");
		resultinfo.clear();
        if(productService.deleteProductByIds(productIds))
        {
        	resultinfo.put("success", true);
            resultinfo.put("message","产品删除成功！");
        }
        else
        {
        	resultinfo.put("success", false);
        	resultinfo.put("message","产品删除失败！");
        }
		return resultinfo;		
	}
	
	@RequestMapping("*/saveProduct.do")
	@ResponseBody
	public Map<String,Object> userSave(Long product_id,String product_name,
			                           String product_spec,String product_code,
			                           String product_steelgrade){
		resultinfo.clear();
		ProductInfo product =new ProductInfo();
		product.setProduct_name(product_name);
		product.setProduct_code(product_code);
		product.setProduct_spec(product_spec);
		product.setProduct_steelgrade(product_steelgrade);
		if(product_id==null)
			productService.saveProduct(product);
		else
		{
			product.setProduct_id(product_id);
			productService.updateProduct(product);
		}
        resultinfo.put("success", true);
        resultinfo.put("message","产品信息添加成功！");
		return resultinfo;		
	}
	
	@RequestMapping("*/loadProduct.do")
	@ResponseBody
	public Map<String,Object> loadUser(HttpServletRequest request){
		resultinfo.clear();
		Long id =Long.parseLong(request.getParameter("id"));
		ProductInfo product = productService.findProductById(id);
        resultinfo.put("product_id",product.getProduct_id());
        resultinfo.put("product_code", product.getProduct_code());
        resultinfo.put("product_name", product.getProduct_name());
        resultinfo.put("product_spec", product.getProduct_spec());
        resultinfo.put("product_steelgrade", product.getProduct_steelgrade());
		return resultinfo;		
	}
}
