package com.varchar.www.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varchar.www.model.dao.SupplierDAO;
import com.varchar.www.model.domain.manager.Supplier;

@Controller
public class SupplierController {

	@Autowired
	private SupplierDAO supplierDAO;
	
	@GetMapping("/supplier")
	public String getsupplier(Model model) {
		model.addAttribute("supplier", supplierDAO.getSupplier());
		return "manager/supplier3";
	}
	
	@GetMapping("/insertSupplier")
	public String insertSupplier() {
		
		return "manager/supplier3";
	}
	
	@PostMapping("/searchSupplier")
	public String searchSupplier(@RequestParam(value="searchSupplier") String filter, String searchSupplier, Model model) {
		List<Supplier> supplierList = supplierDAO.searchSupplier(filter, searchSupplier);
		model.addAttribute("supplierList", supplierList);
				
		return "/manager/supplier3";
	}
	
	/*
	 * @GetMapping("/getSupplier") public String getSupplier() {
	 * 
	 * return "manager/supplier"; }
	 */
	
	@GetMapping("/updateSupplier")
	public String updateSupplier() {
		
		return "manager/supplier3";
	}
	
	@GetMapping("/deleteSupplier")
	public String deleteSupplier() {
		
		return "manager/supplier3";
	}
}
