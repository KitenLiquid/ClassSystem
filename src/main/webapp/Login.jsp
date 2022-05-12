<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>课程管理系统登录</title>
</head>
<body>
<h1>课程管理系统登录</h1>
<form action="LoginVertify" method=post>
<label>账户名称</label><input type="text" name="name" required="required"><br>
<label>密码</label><input type="password" name="password" required="required"><br>
<input type="submit" value="Login">  <input type="reset" value="Reset">
</form>
<%
if(session.getAttribute("Wrong")!=null){
	%>
	<p><%=session.getAttribute("Wrong") %></p>
<%	
}
%>
</body>
</html>
