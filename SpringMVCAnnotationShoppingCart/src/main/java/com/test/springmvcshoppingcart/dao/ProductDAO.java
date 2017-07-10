package com.test.springmvcshoppingcart.dao;

import com.test.springmvcshoppingcart.entity.Product;
import com.test.springmvcshoppingcart.model.PaginationResult;
import com.test.springmvcshoppingcart.model.ProductInfo;

public interface ProductDAO {
 
    
    
    public Product findProduct(String code);
    
    public ProductInfo findProductInfo(String code) ;
  
    
    public PaginationResult<ProductInfo> queryProducts(int page,
                       int maxResult, int maxNavigationPage  );
    
    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult,
                       int maxNavigationPage, String likeName);
 
    public void save(ProductInfo productInfo);
    
}