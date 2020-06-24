package com.varchar.www.model.service;

import java.util.List;


import com.varchar.www.model.domain.record.Record;


public interface RecordService {
	
	List<Record> getRecordList();
	List<Record> getStudentRecord(String userId);
	void insertRecord(Record record);
	void deleteRecord(String recordNo);
}
