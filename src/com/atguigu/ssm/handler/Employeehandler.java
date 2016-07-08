package com.atguigu.ssm.handler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atguigu.ssm.bean.Department;
import com.atguigu.ssm.bean.Employee;
import com.atguigu.ssm.service.DepartmentService;
import com.atguigu.ssm.service.EmployeeService;

@RequestMapping("/emp")
@Controller
public class Employeehandler {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String show(Map<String,Object> map){
		
		List<Employee> employees = employeeService.getAll();
		map.put("employees", employees);
		map.put("departments",departmentService.getAll());
		return "list";
	}
	
	@RequestMapping(value="/updateUI/{empId}",method=RequestMethod.GET)
	public String toUpdate(@PathVariable("empId") Integer empId,Map<String,Object> map){
		Employee employee=employeeService.get(empId);
		map.put("employee",employee);
		map.put("departments",departmentService.getAll());
		return "update";
	}
	
	@RequestMapping(value="/{empId}",method=RequestMethod.PUT)
	public String update(@PathVariable("empId") Integer empId, Employee employee){
		employee.setEmpId(empId);
		employeeService.update(employee);
		return "redirect:/emp";
	}
	
	@RequestMapping(value="/delete/{empId}",method=RequestMethod.DELETE)
	public String deleteEmp(@PathVariable("empId") Integer empId){
		employeeService.delete(empId);
		return "redirect:/emp";
	}
	
	@RequestMapping(value="/toAddUI",method=RequestMethod.GET)
	public String toadd(Map<String,Object> map){
		List<Department> departments = departmentService.getAll();
		map.put("departments",departments);
		/*model.addAttribute("departments",departments);*/
		/*model.addAttribute("employee",new Employee());*/
		return "add";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveUI(Employee emp){
		employeeService.save(emp);
		return "redirect:/emp";
	}
}
