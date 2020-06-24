package com.varchar.www.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.varchar.www.model.domain.manager.CategoryDTO;

@Service
public interface AccountingService {

	void monthTotalIncome();
	void monthTotalExpenditure();
	void monthTotalNETIncome();
	
	void yearAccountingGraph();
	List<CategoryDTO> fixedCategoryList();
	List<CategoryDTO> variableCategoryList();
	
	void insertIncome();
	void getIncome();
	void updateIncome();
	void deleteIncome();
	
	
	
	
	
	
	
}
