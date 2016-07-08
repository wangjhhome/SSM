<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<form action="${pageContext.request.contextPath }/emp/save" method="post">
	<table border="1">
		<tr>
			<td colspan="2"><h3>添加信息</h3></td>
		</tr>
		<tr>
			<td>员工姓名</td>
			<td><input name="name" type="text"/></td>
		</tr>
		<tr>
			<td>部门</td>
			<td>
				<select name="dept.deptId">
					<c:forEach items="${departments }" var="department">
						<option value="${department.deptId}" label="${department.deptName }">
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="保存"></td>
		</tr>
		<%-- 员工姓名：<input name="name" type="text"/>
		<br><br>
		部门：
		<select name="dept.deptId">
			<c:forEach items="${departments }" var="department">
				<option value="${department.deptId}" label="${department.deptName }">
			</c:forEach>
		</select>
		<br><br>
		<input type="submit" value="保存"> --%>
	</table>
	</form>
	</center>
</body>
</html>