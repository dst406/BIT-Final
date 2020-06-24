package com.varchar.www.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varchar.www.model.dao.RecordDAO;
import com.varchar.www.model.domain.record.Record;
import com.varchar.www.model.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordDAO recordDAO;

	@Override
	public List<Record> getRecordList() {

		return recordDAO.getRecordList();
	}

	@Override
	public List<Record> getStudentRecord(String userId) {

		return recordDAO.getStudentRecord(userId);
	}

	@Override
	public void insertRecord(Record record) {
		recordDAO.insertRecord(record);
	}
	


}
