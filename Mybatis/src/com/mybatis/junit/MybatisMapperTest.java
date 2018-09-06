package com.mybatis.junit;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.QueryVo;
import com.mybatis.pojo.User;

public class MybatisMapperTest {
	@Test
	public void testMapper() throws Exception {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlsession = sqlsessionfactory.openSession();
		//sqlsession生成实现类，
		UserMapper usermapper = sqlsession.getMapper(UserMapper.class);
		User user = usermapper.findUserById(10);
		System.out.println(user);
	}
	
	@Test
	public void testMapperSexName() throws Exception {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlsession = sqlsessionfactory.openSession();
		UserMapper usermapper = sqlsession.getMapper(UserMapper.class);
		User user = new User();
		user.setSex("1");
		user.setUsername("张小明");
		List<User> users = usermapper.findUserBySexAndName(user);
		for(User u : users) {
			System.out.println(u);
		}
	}
	
	@Test
	public void testFindIds() throws Exception {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlsession = sqlsessionfactory.openSession();
		UserMapper usermapper = sqlsession.getMapper(UserMapper.class);

//		List<Integer> idsList = new ArrayList<>();
//		idsList.add(16);
//		idsList.add(22);
//		idsList.add(24);
//		QueryVo vo = new QueryVo();
//		vo.setIdList(idsList);		
//		List<User> users = usermapper.findUsersByIds(vo);
		

		
		List<Integer> idsList = new ArrayList<>();
		idsList.add(16);
		idsList.add(22);
		idsList.add(24);
		List<User> users = usermapper.findUsersByIds(idsList);
		for(User u : users) {
			System.out.println(u);
		}
		
		
//		Integer[] ids = {16,22,24};
//		List<User> users = usermapper.findUsersByIds(ids);
//		for(User u : users) {
//			System.out.println(u);
//		}
	}
}
