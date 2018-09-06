package com.mybatis.junit;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis.mapper.OrdersMapper;
import com.mybatis.pojo.Orders;
import com.mybatis.pojo.User;

public class OrderMapperTest {
	@Test
	public void selectOrdersTest() throws Exception {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlsession = sqlsessionfactory.openSession();
		OrdersMapper ordersmapper = sqlsession.getMapper(OrdersMapper.class);
		List<Orders> orders = ordersmapper.selectOrders();
		for(Orders o : orders) {
			System.out.println(o);
		}
	}
	
	@Test
	public void selectUsersTest() throws Exception {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlsession = sqlsessionfactory.openSession();
		OrdersMapper ordersmapper = sqlsession.getMapper(OrdersMapper.class); 
		List<User> users = ordersmapper.selectUserList();
		for(User u : users) {
			System.out.println(u);
		}
	}
}
