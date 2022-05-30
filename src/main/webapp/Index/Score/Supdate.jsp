<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="Score.bean.ScoreBean" />
 
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新学生页面</title>

</head>


<body>

<h3>更新</h3>

<form method="post" action="/ClassSystem/SUpdateServlet">
    <%ScoreBean Stu=(ScoreBean)request.getAttribute("Stu");%>
	
	
  <table border="1" width="600">
  <tr>
	<td>学号</td>
	<td><input type="text" name="Number" value="<%=Stu.getNumber() %>"></td>
  </tr>
  <tr>
	<td>课程名</td>
	<td><input type="text" name="ClassName" value="<%=Stu.getClassName() %>"></td>
  </tr>
  <tr>
	<td>课程号</td>
	<td><input type="hidden" name="ClassNumber"  value="<%=Stu.getClassNumber() %>"></td>
  </tr>
  
  <tr>
	<td>分数</td>
	<td><input type="text" name="Score"  value="<%=Stu.getScore() %>"></td>
  </tr>
  <tr>
	<td>选这门课的人数</td>
	<td><input type="text" name="APnumber"  value="<%=Stu.getAPnumber() %>"></td>
  </tr>
  <tr>
	<td colspan="2"> <input type="submit" value="更新"> </td>
  </tr>
  </table>
   </form>
</body>
</html>