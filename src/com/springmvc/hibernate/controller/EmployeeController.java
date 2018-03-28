package com.springmvc.hibernate.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.hibernate.bean.EmployeeBean;
import com.springmvc.hibernate.entity.EmployeeEntity;
import com.springmvc.hibernate.service.EmployeeService;

@Controller
public class EmployeeController {
	
	
	@Autowired 
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView welcome() {
	  return new ModelAndView("index");
	 }
	
	
	@RequestMapping("/empform")
	public ModelAndView showform() {
		
		return new ModelAndView("empform", "command", new EmployeeBean());
	}
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") EmployeeBean employeeBean) {
		
		System.out.println("Adding/Updating: " + employeeBean.getId() + " " + employeeBean.getEmployeeName() + " " + employeeBean.getEmployeeSalary() + " " + employeeBean.getEmployeeDesignation());
		
		EmployeeEntity employeeEntity = new EmployeeEntity();
		if(employeeBean.getId() != 0) {
			employeeEntity.setId(employeeBean.getId());
		}
		employeeEntity.setEmployeeName(employeeBean.getEmployeeName());
		employeeEntity.setEmployeeSalary(employeeBean.getEmployeeSalary());
		employeeEntity.setEmployeeDesignation(employeeBean.getEmployeeDesignation());
		
		employeeService.saveEmployee(employeeEntity);
		
		return new ModelAndView("success");
	}
	
	
	@RequestMapping("/viewEmployee")
	public String viewEmployees(Model model) {
		List<EmployeeBean> list = employeeService.viewEmployees();
		model.addAttribute("allEmployees", list);
		return "getEmployee";
		
	}
	
	/*@RequestMapping(value = "/deleteEmployee/{empid}", method=RequestMethod.POST)
	public void deleteEmployee(@PathVariable("empid") String id) {
		System.out.println(id);;
		
	}*/

	@RequestMapping(value = "/deleteEmployee", method=RequestMethod.GET)
	public String deleteEmployee(@RequestParam("employeeId") Integer id, Model model) {
	
		System.out.println("I can delete the employee with id: " + id);
		employeeService.deleteEmployee(id);
		return "redirect:/viewEmployee.html";
		
	}
	
	@RequestMapping(value = "/updateEmployee", method=RequestMethod.GET)
	public ModelAndView updateEmployee(@RequestParam("employeeId") Integer id, Model model) {
		System.out.println("I can update the employee with id: " + id);
		EmployeeEntity employeeEntity = employeeService.updateEmployee(id);
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setId(employeeEntity.getId());
		employeeBean.setEmployeeName(employeeEntity.getEmployeeName());
		employeeBean.setEmployeeSalary(employeeEntity.getEmployeeSalary());
		employeeBean.setEmployeeDesignation(employeeEntity.getEmployeeDesignation());
		System.out.println("Update the employee with name: " + employeeBean.getEmployeeName());

		return new ModelAndView("empform", "command", employeeBean);
		

		
	}
}