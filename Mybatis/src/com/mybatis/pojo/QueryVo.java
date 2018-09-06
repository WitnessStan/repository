package com.mybatis.pojo;

import java.io.Serializable;
import java.util.List;

public class QueryVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	
	private Integer[] ids;
	
	private List<Integer> idsList;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public List<Integer> getIdList() {
		return idsList;
	}
	public void setIdList(List<Integer> idsList) {
		this.idsList = idsList;
	}
	
}
