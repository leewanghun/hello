package com.test.springmvcshoppingcart.dao;

import java.util.List;

import com.test.springmvcshoppingcart.model.CartInfo;
import com.test.springmvcshoppingcart.model.OrderDetailInfo;
import com.test.springmvcshoppingcart.model.OrderInfo;
import com.test.springmvcshoppingcart.model.PaginationResult;

public interface OrderDAO {
	 
    public void saveOrder(CartInfo cartInfo);
 
    public PaginationResult<OrderInfo> listOrderInfo(int page,
            int maxResult, int maxNavigationPage);
    
    public OrderInfo getOrderInfo(String orderId);
    
    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);
 
}
