<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>增加</title>
</head>
<body>
<form action="/ClassSystem/studentServlet" method="post">
        课程号：<input type="text" name="ClassNumber"/><br>
		姓名：<input type="text" name="Name"/><br>
		学号：<input type="text" name="Number"/><br>
		性别：<input type="radio" name="Sex" value="男">男
              <input type="radio" name="Sex" value="女">女<br>
		年龄：<input type="text" name="Age"/><br>
		<br>
		
		<input type="submit" value="增加"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" value="重置"/><br>
	</form>	
</body>
</html>
