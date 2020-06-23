package com.varchar.www.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.varchar.www.model.dao.SupplierDAO;

@Controller
public class SupplierController {

	@Autowired
	private SupplierDAO supplierDAO;
	
	@GetMapping("/supplier")
	public String getsupplier(Model model) {
		model.addAttribute("supplier", supplierDAO.getSupplier());
		return "manager/supplier";
	}
	
	@GetMapping("/insertSupplier")
	public String insertSupplier() {
		
		return "manager/supplier";
	}
	
	/*
	 * @GetMapping("/getSupplier") public String getSupplier() {
	 * 
	 * return "manager/supplier"; }
	 */
	
	@GetMapping("/updateSupplier")
	public String updateSupplier() {
		
		return "manager/supplier";
	}
	
	@GetMapping("/deleteSupplier")
	public String deleteSupplier() {
		
		return "manager/supplier";
	}
}
