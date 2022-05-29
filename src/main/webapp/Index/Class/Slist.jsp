<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <jsp:directive.page import="java.util.List" />
<jsp:directive.page import="Class.bean.Student" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Slist</title>
<script type="text/javascript">

	function doDelete(ClassNumber,Number) {
		/* 如果这里弹出的对话框，用户点击的是确定，就马上去请求Servlet。 
		如何知道用户点击的是确定。
		如何在js的方法中请求servlet。 */
		var flag = confirm("是否确定删除?");
		if(flag){
			//表明点了确定。 访问servlet。 在当前标签页上打开 超链接，
			
			location.href="studeleteServlet?ClassNumber="+ClassNumber+"&Number="+Number;
		}
	}
</script>
</head>
<body>
<h3><a href="/ClassSystem/SListServlet">显示所有学生列表</a></h3><br>
<form action="/ClassSystem/SearchStudentServlet" method="post">
		<table border="1" >
		
			<tr >
				<td colspan="8">
					
					按课程名查询:<input type="text" name="ClassName"/>
					&nbsp;
					按学生名查询:<input type="text" name="Name"/>
					&nbsp;
					按性别查询:<select name="Sex">
								<option value="">--请选择--
								<option value="男">男
								<option value="女">女
							  </select>
					
					&nbsp;&nbsp;&nbsp;
					<input type="submit" value="查询">
					&nbsp;&nbsp;&nbsp;
					<a href="/ClassSystem/Index/Class/stuinsert.jsp">添加</a>
				</td>
			</tr>
		
		  <tr align="center">
			<td>课程名</td>
			<td>课程号</td>
			<td>姓名</td>
			<td>学号</td>
			<td>性别</td>
			<td>年龄</td>
		  </tr>
		  <%List <Student> Slist=(List <Student>)request.getAttribute("Slist"); 
		  int i=0;
		  if(Slist!=null)
		  while(Slist.size()>i){%>
			  
				  <tr align="center">
					<td><%=Slist.get(i).getClassName() %></td>
					<td><%=Slist.get(i).getClassNumber() %></td>
					<td><%=Slist.get(i).getName() %></td>
					<td><%=Slist.get(i).getNumber() %></td>
					<td><%=Slist.get(i).getSex() %></td>
					<td><%=Slist.get(i).getAge() %></td>
					 <td><a href="SEditServlet?ClassNumber=<%=Slist.get(i).getClassNumber() %>&Number=<%=Slist.get(i).getNumber() %>">更新</a>&nbsp;&nbsp;<a href="#" onclick="doDelete(<%=Slist.get(i).getClassNumber() %>,<%=Slist.get(i).getNumber() %>)">删除</a></td>
				  </tr>
		<% i++;}%>

		  </table>
	  </form>
</body>
</html>