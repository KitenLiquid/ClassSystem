<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>课程管理系统登录</title>
<style type="text/css">
body{
        background: url("Resource/1.jpg");
        background-size: cover;
        color: #56e0c1;
    }
    .Login{
        position: absolute;
        top: 30%;
        left: 37%;
        line-height: 35px;
        font-size: 30px;
        text-align: center;
        border:4px solid #5b56e0;
        border-radius:  25px 25px 25px 25px;
        width: 500px;
        height: 250px;
        box-shadow: #373747 30px 30px 20px;
        color: #000000;
        background: rgba(255,255, 255, 0.5);
    }
    .link{
        font-size: 20px;
    }
    h1{
        text-align: center;
        font-size: 60px;
        line-height: 80px;
        font-family: "Microsoft JhengHei UI";
    }
    .gg{
    font-size: 30px;
    position: absolute;
    top: 50%;
    left: 47%;
    color: #ee0053;
    }
</style>
</head>
<body>
<h1>课程管理系统登录</h1>
<div class="Login">
    <br>
<form action="LoginVertify" method=post>
    <label>账户名称:</label><input type="text" name="name" required="required"><br>
    <label>密码:</label><input type="password" name="password" required="required"><br>
    <label class="link"><input type="checkbox" name="radio1" required="required"/>我已经同意并阅读<a target="_blank" href="#">管理员协议</a> <br></label>
    <input type="submit" value="Login">  <input type="reset" value="Reset">
</form>
</div>
<%
if(session.getAttribute("Wrong")!=null){
	%>
	<p><%=session.getAttribute("Wrong") %></p>
<%	
}
%>
</body>
</html>
