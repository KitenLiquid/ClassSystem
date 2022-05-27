<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="stu1" class="Score.bean.ScoreBean" scope="session"></jsp:useBean>
<%Score.bean.ScoreBean stu=(Score.bean.ScoreBean)session.getAttribute("stu1");%>
<table border="1" width="800">
     <tr align="center">
			<td>成绩</td>
			<td>学号</td>
			<td>课程编号</td>
			<td>课程名</td>
			<td>人数</td>
    </tr>
    <tr align="center">
			<td><%out.println(stu.getScore()+"<br>");%></td>
			<td><%out.println(stu.getNumber()+"<br>"); %></td>
			<td><%out.println(stu.getClassNumber()+"<br>");%></td>
			<td><%out.println(stu.getClassName()+"<br>"); %></td>
			<td><%out.println(stu.getAPnumber()+"<br>");%></td>
    </tr>
</table>
	
</body>
</html>