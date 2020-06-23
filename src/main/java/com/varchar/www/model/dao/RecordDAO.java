package com.varchar.www.model.dao;

import java.util.List;

import com.varchar.www.model.domain.record.Record;

public interface RecordDAO {

	List<Record> getRecordList();
	List<Record> getStudentRecord(String userId);
}
