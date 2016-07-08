package com.atguigu.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.ssm.bean.Employee;
import com.atguigu.ssm.mapper.EmployeeMapper;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Transactional
	public void update(Employee emp){
		employeeMapper.update(emp);
	}
	
	@Transactional(readOnly=true)
	public Employee get(Integer id){
		return employeeMapper.get(id);
	}
	
	@Transactional(readOnly=true)
	public List<Employee> getAll(){
		return employeeMapper.getAll();
	}
	
	@Transactional
	public void delete(Integer empId){
		employeeMapper.delete(empId);
	}
	
	@Transactional
	public void save(Employee emp){
		employeeMapper.save(emp);
	}
}
