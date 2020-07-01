package com.varchar.www.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varchar.www.model.dao.RecordDAO;
import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.domain.record.Record;
import com.varchar.www.model.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordDAO recordDAO;



	@Override
	public List<Record> getStudentRecord(String userId) {

		return recordDAO.getStudentRecord(userId);
	}

	@Override
	public void insertRecord(Record record) {
		recordDAO.insertRecord(record);
	}

	@Override
	public void deleteRecord(String recordNo) {
		// TODO Auto-generated method stub
		recordDAO.deleteRecord(recordNo);
	}

	@Override
	public List<Record> getRecordList(Criteria cri) {
		// TODO Auto-generated method stub
		return recordDAO.getRecordList(cri);
	}

	@Override
	public int getRecordAccount() {
		// TODO Auto-generated method stub
		return recordDAO.getRecordAccount();
	}
	


}
