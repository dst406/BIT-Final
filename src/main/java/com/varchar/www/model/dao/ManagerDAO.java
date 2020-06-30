package com.varchar.www.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.varchar.www.model.domain.manager.CareerVO;
import com.varchar.www.model.domain.manager.Season;
import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.domain.teacher.Teacher;
import com.varchar.www.model.domain.teacher.TeacherVO;

@Mapper
public interface ManagerDAO {
	
	List<Teacher> getManagerTeacherList(@Param("cri") Criteria cri ,@Param("authority_code") String authority_code);
	Teacher getManagerInfo(String authorityCode);
	List<CareerVO> getManagerCareer(String userId);
	List<Season> getSeasonList();
	void updateManagerInfo(TeacherVO manager);

}
