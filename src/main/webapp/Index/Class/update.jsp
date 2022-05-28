<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="Class.bean.classxx" />
 
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新学生页面</title>

</head>


<body>

<h3>更新</h3>

<form method="post" action="/ClassSystem/UpdateServlet">
    <%classxx Class=(classxx)request.getAttribute("Class");%>
	
	
  <table border="1" width="600">
  <tr>
	<td>课程号</td>
	<td><input type="hidden" name="ClassNumber" value="<%=Class.getClassNumber() %>"></td>
  </tr>
  <tr>
	<td>课程名</td>
	<td><input type="text" name="ClassName"  value="<%=Class.getClassName() %>"></td>
  </tr>
  
  <tr>
	<td>学生人数</td>
	<td><input type="text" name="APnumber"  value="<%=Class.getAPnumber() %>"></td>
  </tr>
  <tr>
	<td>授课教师</td>
	<td><input type="text" name="TName"  value="<%=Class.getTName() %>"></td>
  </tr>
  <tr>
	<td>教师电话</td>
	<td><input type="text" name="PhoneNumber"  value="<%=Class.getPhoneNumber() %>"></td>
  </tr>
  <tr>
	<td colspan="2"> <input type="submit" value="更新"> </td>
  </tr>
  </table>
   </form>
</body>
</html>
