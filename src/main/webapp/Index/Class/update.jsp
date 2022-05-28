<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新学生页面</title>

</head>


<body>

<h3>更新</h3>

<form method="post" action="/ClassSystem/UpdateServlet">
	
  <table>
  <tr>
	<td>课程名</td>
	<td><input type="text" name="ClassName"></td>
  </tr>
  <tr>
	<td>课程号</td>
	<td><input type="text" name="ClassName"></td>
  </tr>
  <tr>
	<td>学生人数</td>
	<td><input type="text" name="APnumber" ></td>
  </tr>
  <tr>
	<td colspan="2"> <input type="submit" value="更新"> </td>
  </tr>
  </table>
   </form>
</body>
</html>
