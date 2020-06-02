package com.varchar.www.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BoardDAO {
	
	
	@Select("SELECT eName FROM emp WHERE empNo = #{empNo}")
	public String getUserName(@Param("empNo") int empNo);
	
}
