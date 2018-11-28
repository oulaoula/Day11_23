package com.order.biz;

import java.util.List;

import com.order.entity.Orders;

public interface OrdersMapperBiz {
    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
    
    public List<Orders> findOrdersWithUserResultMap() ;
}