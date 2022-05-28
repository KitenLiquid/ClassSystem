<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>增加</title>
</head>
<body>
<form action="/ClassSystem/classServlet" method="post">
		课程名：<input type="text" name="ClassName"/><br>
		课程号：<input type="text" name="ClassNumber"/><br>
		学生人数：<input type="text" name="APnumber"/><br>
		授课教师：<input type="text" name="TName"/><br>
		教师电话：<input type="text" name="PhoneNumber"/><br>
		<br>
		
		<input type="submit" value="增加"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" value="重置"/><br>
	</form>	
</body>
</html>