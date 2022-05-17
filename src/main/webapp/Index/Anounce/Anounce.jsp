<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公告</title>
<style type="text/css">
.change{
display:block;
opacity: 0;
position: absolute;
left:40%;
top:40%;
width: 20%;
height: 20%;
}
</style>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
$(function(){
	var index;
	$(".up").click(function () {
		index=$(this).val();
		$(".change").css("opacity","1");
		$(".ch1").css("opacity","0");
		$(".ch2").css("opacity","0");
		$(".av1").val(index);
		alert("1");
    });
	$(".cancel").click(function () {
		$(".change").css("opacity","0");
    });
	$("#tr").click(function () {
		if($(".A1").is(":checked")==true){
			$(".ch1").css("opacity","1");
		}
		if($(".A2").is(":checked")==true){
			$(".ch2").css("opacity","1");
		}
    });
	
})

</script>
</head>
<body>
<jsp:directive.page import="java.util.LinkedList" />
<jsp:directive.page import="Anounce.Bean.Anou" />
 
<%
LinkedList  <Anou>list=(LinkedList<Anou>)session.getAttribute("ListA");
if(list==null){
	%>
	<p>重新刷新界面！!!!! <p>
	<form action="../../AnounServlet" method=post>
<input type="submit" value="刷新">

<%
}
else
{
	int l=list.size(),i=0;
	%> 
	<div class="change"> 
	<form class="update" action="http://localhost:8080/ClassSystem/Update" method=post>
	<h3>修改信息</h3>
	<input type="hidden" name="No" class="av1"><br>
	<input type="checkbox" class="A1" name="A1" value="1">编辑名称<input type="checkbox" class="A2" name="A2" value="2">编辑内容<input type="button" id="tr" name="a2" value="确认"><br>
	<div class="ch1"><label>名称</label><input type="text" name="newName"><br></div>
	<div class="ch2"><label>内容</label><input type="text" name="newContent"><br></div>
	<input type="submit" name="de" value="确认编辑"><input type="button" class="cancel" value="取消">
	</form>
	</div>
	
	<table> <tr><th>编号</th><th>名称</th><th>内容</th><th>操作</th>
	</tr><%
	
	while(i<l){
	%>	
	
        
  
    <form action="http://localhost:8080/ClassSystem/Delete" method=post>
	<tr><td><%=list.get(i).getNo() %></td><td><%=list.get(i).getName() %></td><td><%=list.get(i).getContent() %></td>
	<td><input type="hidden" name="delete" value="<%=list.get(i).getNo() %>" /> <input type="submit" name="de" value="删除"></form><button  class="up" value="<%=i %>">更新</button></td></tr>
	
	<%
	
		i++;
	}
	%> </table>    <%
} %>

</body>
</html>