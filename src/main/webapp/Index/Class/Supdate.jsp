<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="Class.bean.Student" />
 
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新学生页面</title>

</head>


<body>

<h3>更新</h3>

<form method="post" action="/ClassSystem/SUpdateServlet">
    <%Student Student=(Student)request.getAttribute("Student");%>
	
	
  <table border="1" width="600">
  <tr>
	<td>课程号</td>
	<td><input type="hidden" name="ClassNumber" value="<%=Student.getClassNumber() %>"></td>
  </tr>
  <tr>
	<td>学号</td>
	<td><input type="hidden" name="Number" value="<%=Student.getNumber() %>"></td>
  </tr>
  <tr>
	<td>姓名</td>
	<td><input type="text" name="Name"  value="<%=Student.getName() %>"></td>
  </tr>
  
  <tr>
	<td>性别</td>
	<td><input type="text" name="Sex"  value="<%=Student.getSex() %>"></td>
  </tr>
  <tr>
	<td>年龄</td>
	<td><input type="text" name="Age"  value="<%=Student.getAge() %>"></td>
  </tr>
  <tr>
	<td colspan="2"> <input type="submit" value="更新"> </td>
  </tr>
  </table>
   </form>
</body>
</html>
