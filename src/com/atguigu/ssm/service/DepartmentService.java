package com.atguigu.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.ssm.bean.Department;
import com.atguigu.ssm.mapper.DepartmentMapper;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Transactional(readOnly=true)
	public List<Department> getAll(){
		return departmentMapper.getAll();
	}
	
}
