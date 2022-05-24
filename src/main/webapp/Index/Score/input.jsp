<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	body {
		text-align:center;
	}
</style>
<body>
	<h2>添加新成绩</h2> 
	<form action="/ClassSystem/SearchServlet" Method="post">
	请输入成绩: <input type="text" name="Score"> <br><br>
	请输入学号: <input type="text" name="Number"> <br><br>
	请输入课程编号: <input type="text" name="ClassNumber"> <br><br>
	请输入课程名: <input type="text" name="ClassName"> <br><br>
	<input type="submit" value="插入数据"/>&nbsp;&nbsp;
	<input type="reset"  />
	</form>
	
</body>
</html>