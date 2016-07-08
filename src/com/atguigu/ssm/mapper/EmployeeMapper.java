package com.atguigu.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.atguigu.ssm.bean.Department;
import com.atguigu.ssm.bean.Employee;

public interface EmployeeMapper {
	
	@Select("SELECT emp_id,name,emps_dept_id AS \"dept.deptId\" FROM emps WHERE emp_id=#{empId}")
	Employee get(@Param("empId") Integer empId);
	
	@Update("UPDATE emps SET name=#{name},emps_dept_id=#{dept.deptId} WHERE emp_id=#{empId}")
	void update(Employee employee);
	
	/*@Select("SELECT emp_id AS \"empId\",name,emps_dept_id AS \"dept.deptId\",d.dept_name AS \"dept.deptName\" FROM emps LEFT OUTER JOIN depts d ON emps_dept_id=d.dept_id")*/
	List<Employee> getAll();
	
	@Delete("DELETE FROM emps WHERE emp_id=#{empId}")
	void delete(@Param("empId") Integer empId);
	
	@Insert("INSERT INTO emps(name,emps_dept_id) VALUES(#{name},#{dept.deptId})")
	void save(Employee employee);
}
