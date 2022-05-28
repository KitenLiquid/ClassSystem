<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <jsp:directive.page import="java.util.List" />
<jsp:directive.page import="Class.bean.classxx" />
    
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
					按教师名查询:<input type="text" name="TName"/>
					&nbsp;
				
					
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
			<td>授课教师</td>
			<td>教师电话</td>
		  </tr>
		  <%List <classxx> list=(List <classxx>)request.getAttribute("list"); 
		  int i=0;
		  if(list!=null)
		  while(list.size()>i){%>
			  
				  <tr align="center">
					<td><%=list.get(i).getClassName() %></td>
					<td><%=list.get(i).getClassNumber() %></td>
					<td><%=list.get(i).getAPnumber() %></td>
					<td><%=list.get(i).getTName() %></td>
					<td><%=list.get(i).getPhoneNumber() %></td>
					 <td><a href="EditServlet?ClassNumber=<%=list.get(i).getClassNumber() %>">更新</a>&nbsp;&nbsp;<a href="#" onclick="doDelete(<%=list.get(i).getClassNumber() %>)">删除</a></td>
				  </tr>
		<% i++;}%>

		  </table>
	  </form>
</body>
</html>