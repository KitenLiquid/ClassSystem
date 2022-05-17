<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>创建公告</title>
</head>
<body>
<form action="../../CreateServlet" method=post>
<label>编号</label><input type="text" name="nno" required="required">
<label>名称</label><input type="text" name="nname" required="required">
<label>内容</label><input type="text" name="ncontent" required="required">
<input type="submit" value="创建">
</form>
</body>
</html>