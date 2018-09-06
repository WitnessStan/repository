package com.mybatis.junit;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis.pojo.User;

public class MybatisTest {
	
	@Test
	public void testMybatis() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建sqlsessionfactory
		SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlsession
		SqlSession sqlsession = sqlsessionfactory.openSession();
		
		//执行sql语句
		User user = sqlsession.selectOne("test.findUserById", 10);
		//打印user
		System.out.println(user);
		
		List<Object> users = sqlsession.selectList("test.findUserByName", "王");
		for(Object u : users) {
			System.out.println(u);
		}
		
//		User user2 = new User();
//		user2.setUsername("张飞2");
//		user2.setSex("1");
//		user2.setBirthday(new Date());
//		user2.setAddress("蜀国");
//		int col = sqlsession.insert("test.saveUser", user2);
//		sqlsession.commit();
//		//直接可以获取自增的id
//		System.out.println(user2.getId());
		
//		User user2 = new User();
//		user2.setId(32);
//		user2.setUsername("飞张");
//		user2.setSex("2");
//		user2.setBirthday(new Date());
//		user2.setAddress("蜀国啊");
//		int col = sqlsession.update("test.updateUserById", user2);
//		sqlsession.commit();
		
//		int col = sqlsession.delete("test.deleteUserById", 32);
//		sqlsession.commit();
	}
	
}
