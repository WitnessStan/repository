package com.mybatis.mapper;

import java.util.List;

import com.mybatis.pojo.Orders;
import com.mybatis.pojo.User;

public interface OrdersMapper {
	public Orders findOrderById(Integer id);
	public List<Orders> selectOrders(); //一个订单一个用户 一对一
	public List<User> selectUserList(); //一个用户多个订单  一对多
}
