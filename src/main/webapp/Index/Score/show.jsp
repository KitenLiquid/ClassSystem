<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center">
<jsp:useBean id="Score" class="Score.bean.Score" scope="application"></jsp:useBean>
<jsp:setProperty name="Score" property="*"/>
<h1>查看</h1>
<br>分数：<jsp:getProperty name="Score" property="Score"/>
<br>学号：<jsp:getProperty name="Score" property="Number"/>
<br>班级号：<jsp:getProperty name="Score" property="ClassNumber"/>
</body>
</html>