package com.varchar.www.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.varchar.www.model.domain.manager.SupplierDTO;

public interface SupplierDAO {
	//@Select("SELECT eName FROM emp WHERE empNo = #{empNo}")
	@Select("SELECT * FROM supplier")
	List<SupplierDTO> getSupplier();
	
	@Insert("INSERT INTO supplier (supplier_no, supplier_name, "
			+ "supplier_address, supplier_tel, supplier_date) "
			+ "VALUES (supplier_seq.NEXTVAL, #{supplier_name}, "
			+ "#{supplier_address}, #{supplier_tel}, #{supplier_date}")
	String insertSupplier();
	
	@Update("UPDATE supplier SET supplier_name = #{supplier_name}, "
			+ "supplier_address = #{supplier_address}, supplier_tel = #{supplier_tel}, "
			+ "supplier_date = #{supplier_date} WHERE supplier_no = #{supplier_no}")
	String updateSupplier();
	
	@Delete("DELETE FROM supplier WHERE supplier_no = #{supplier_no}")
	String deleteSupplier();
}
