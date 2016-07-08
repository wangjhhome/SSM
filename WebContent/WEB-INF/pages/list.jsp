<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<c:if test="${empty employees }">
		<h2>暂时没有数据！</h2>
	</c:if>
	
	<c:if test="${!empty employees }">
		
		<table border="1">
		<tr>
			<th>员工编号</th>
			<th>员工姓名</th>
			<th>员工部门</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${employees }" var="employee">
			<tr>
			 	<td>${employee.empId }</td>
				<td>${employee.name }</td>
				<td>${employee.dept.deptName }</td>
				<td>
					<form action="${pageContext.request.contextPath }/emp/delete/${employee.empId}" method="POST">
						<input type="hidden" name="_method" value="DELETE">
						<input type="submit" value="删除">
					</form>
					<%-- <a href="${pageContext.request.contextPath }/emp/delete/${employee.empId}">删除</a> --%>
				</td>
				<td><a href="${pageContext.request.contextPath }/emp/updateUI/${employee.empId}">修改</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="${pageContext.request.contextPath }/emp/toAddUI">添加新用户</a></td>
		</tr>
	</table>
	</c:if>
	</center>
	
</body>
</html>