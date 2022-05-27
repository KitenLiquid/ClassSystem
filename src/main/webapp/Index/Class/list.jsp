<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
<h3><a href="/ClassSystem/ClassListServlet">显示所有课程列表</a></h3><br>
<form action="/ClassSystem/SearchClassServlet" method="post">
		<table border="1" >
		
			<tr >
				<td colspan="8">
					
					按课程名查询:<input type="text" name="ClassName"/>
					&nbsp;
					按课程号查询:<input type="text" name="ClassNumber"/>
					&nbsp;&nbsp;&nbsp;
					<input type="submit" value="查询">
					&nbsp;&nbsp;&nbsp;
					<a href="add.jsp">添加</a>
				</td>
			</tr>
		
		  <tr align="center">
			<td>课程名</td>
			<td>课程号</td>
			<td>课程人数</td>
		  </tr>
		  
			  <c:forEach items="${list }" var="Class">
				  <tr align="center">
					<td>${classxx.ClassName }</td>
					<td>${classxx.ClassNumber }</td>
					<td>${classxx.APnumber }</td>
					
				  </tr>
			  </c:forEach>
		  </table>
	  </form>
</body>
</html>