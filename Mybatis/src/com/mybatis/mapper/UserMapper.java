package com.mybatis.mapper;

import java.util.List;

import com.mybatis.pojo.QueryVo;
import com.mybatis.pojo.User;

public interface UserMapper {
	
	public User findUserById(Integer id);
	public List<User> findUserBySexAndName(User user);
	
	public List<User> findUsersByIds(QueryVo vo);
	public List<User> findUsersByIds(List<Integer> idsList);
	public List<User> findUsersByIds(Integer[] ids);
}
