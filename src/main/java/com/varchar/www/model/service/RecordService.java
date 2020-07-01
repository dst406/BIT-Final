package com.varchar.www.model.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.domain.record.Record;


public interface RecordService {
	
	int getRecordAccount();
	List<Record> getRecordList(@Param("cri") Criteria cri);
	List<Record> getStudentRecord(String userId);
	void insertRecord(Record record);
	void deleteRecord(String recordNo);
}
