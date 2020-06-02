package com.varchar.www.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;


public interface DAOTest {
	
	@Select("SELECT dname FROM dept")
	public List<String> getDeptNames();
	
}
