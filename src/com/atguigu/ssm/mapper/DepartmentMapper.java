package com.atguigu.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.atguigu.ssm.bean.Department;

public interface DepartmentMapper {
	
	@Select("SELECT dept_id AS \"deptId\",dept_name AS \"deptName\" FROM depts")
	List<Department> getAll();
	
	@Select("SELECT dept_id, dept_name FROM depts WHERE dept_id = #{emps_dept_id}")
	Department get(@Param("emps_dept_id") Integer emps_dept_id);
}
