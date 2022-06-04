<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <jsp:directive.page import="java.util.List" />
<jsp:directive.page import="Class.bean.classxx" />
<jsp:directive.page import="Class.bean.PageBean" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
     <title>教师信息</title>
    <style>
        body{
            font-size: 15px;
            font-family: "Microsoft JhengHei Light";
        }
        li{
            display: block;
        }
        .left-order{
            position: absolute;
            left: 0;
            top: 0;
            width: 20%;
            height: 100%;
            background-color: #373747;
            font-size: 30px;
            color: white;
            font-family: 楷体;
            font-weight: 500;
        }
        .left-order>ul>li{
            position: relative;
            left: -20%;
            border: #ffffff;
            width: 120%;
            height: 100px;
            text-align: center;
            background-color: #2c3850;
            border-bottom:1px solid #4b4a53;
            line-height: 100px;
        }
        h2{
            text-align: center;
        }
        .top-order{
            width: 80%;
            border-bottom:1px solid #7f5fd4;
            position: absolute;
            right: 0;
            height: 4%;
            line-height: 50px;
        }
        .a ul li{
            display: none;
            position: relative;
            left: -27%;
            width: 127%;
            height: 50px;
            font-size: 25px;
            text-align: center;
            line-height: 50px;
            border-bottom:1px solid #ffffff;
            background-color: #2d2d40;
        }
        .a>li:nth-child(1):hover{
            background-color: #5a5a7f;
        }
        .a>li:nth-child(2):hover{
            background-color: #5a5a7f;
        }
        .a>li:nth-child(4):hover{
            background-color: #5a5a7f;
        }
        .a>li:nth-child(6):hover{
            background-color: #5a5a7f;
        }
        .a1>li:nth-child(1):hover{
            background-color: #3d3d57;
        }
        .a1>li:nth-child(2):hover{
            background-color: #3d3d57;
        }
        .a2>li:nth-child(1):hover{
            background-color: #3d3d57;
        }
        .a2>li:nth-child(2):hover{
            background-color: #3d3d57;
        }
        .a3>li:nth-child(1):hover{
            background-color: #3d3d57;
        }
        .a3>li:nth-child(2):hover{
            background-color: #3d3d57;
        }
        .ex{
            position: absolute;
            right: 30px;
            top: 12px;
        }
        .count{
            position: absolute;
            right: 150px;
        }
        h1{
            position: absolute;
            top:30px;
            left: 1000px;
            font-size: 40px;
            font-weight: 700;
        }
        .bottom-change{
            width: 80%;
            border-top:1px solid #7f5fd4;
            position: absolute;
            right: 0;
            bottom: 150px;
        }
        .stuxx{
            position: absolute;
            top:100px;
            left: 500px;
        }
        .bt{
            position: absolute;
            top:30px;
            left: 950px;
        }
        tr{
           
            height:40px;
        }
        td{
             font-size:20px;
             font-color:black;
             font-weight:bold;
        }
    </style>
    <script src="jquery-3.3.1.min.js"></script>
    <script>
        $(function(){
            var f1=false,f2=false,f3=false;
            $(".a>li:nth-child(2)").click(function () {
                if(f1==false){
                    $(".a1>li").css("display","block");
                    f1=true;
                }
                else {
                    $(".a1>li").css("display","none");
                    f1=false;
                }

            })
            $(".a>li:nth-child(4)").click(function () {
                if(f2==false){
                    $(".a2>li").css("display","block");
                    f2=true;
                }
                else {
                    $(".a2>li").css("display","none");
                    f2=false;
                }

            })
            $(".a>li:nth-child(6)").click(function () {
                if(f3==false){
                    $(".a3>li").css("display","block");
                    f3=true;
                }
                else {
                    $(".a3>li").css("display","none");
                    f3=false;
                }
            })
            $(".a1>li:nth-child(1)").click(function () {
                window.location.replace("http://localhost:8080/ClassSystem/Index/Anounce/Anounce.jsp");
            })
            $(".a1>li:nth-child(2)").click(function () {
                window.location.replace(" http://localhost:8080/ClassSystem/Index/Anounce/CreateAnounce.jsp");
            })
            $(".a2>li:nth-child(1)").click(function () {
                window.location.replace("http://localhost:8080/ClassSystem/Index/Class/Slist.jsp");
            })
            $(".a2>li:nth-child(2)").click(function () {
                window.location.replace(" http://localhost:8080/ClassSystem/Index/Class/list.jsp");
            })

        })
        function doDelete(ClassNumber) {
		/* 如果这里弹出的对话框，用户点击的是确定，就马上去请求Servlet。 
		如何知道用户点击的是确定。
		如何在js的方法中请求servlet。 */
		var flag = confirm("是否确定删除?");
		if(flag){
			//表明点了确定。 访问servlet。 在当前标签页上打开 超链接，
			
			location.href="deleteServlet?ClassNumber="+ClassNumber;
		}
	}
    </script>
    <script type="text/javascript">
        function time() {
            var vWeek, vWeek_s, vDay;
            vWeek = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
            var date =  new Date();
            year = date.getFullYear();
            month = date.getMonth() + 1;
            day = date.getDate();
            hours = date.getHours();
            minutes = date.getMinutes();
            seconds = date.getSeconds();
            vWeek_s = date.getDay();
            document.getElementById("time").innerHTML = year + "年" + month + "月" + day + "日" + "\t" + hours + ":" + minutes + ":" + seconds + "\t" + vWeek[vWeek_s];

        };
        setInterval("time()", 1000);
    </script>
</head>
<body>

<div class="left-order">
    <h2>课程管理系统</h2>
    <ul class="a">
        <li>管理员主页</li>
        <li class="b1">公告管理</li>
        <ul class="a1">
            <li>公告信息</li>
            <li>公告发布</li>
        </ul>
        <li>基本信息管理</li>
        <ul class="a2">
            <li>学生信息</li>
            <li>老师信息</li>
        </ul>
        <li>成绩管理</li>
        <ul class="a3">
            <li>成绩信息</li>
            <li>新建成绩</li>
        </ul>
    </ul>
</div>
<div class="bt"><h2>教师信息列表</h2></div>
<div class="stuxx">
<form action="/ClassSystem/SearchClassServlet" method="post">
		<table border="1" width="1100">
		
			<tr >
				<td colspan="8">
					
					按课程名查询:<input type="text" name="ClassName"/>
					&nbsp;
					按教师名查询:<input type="text" name="TName"/>
					&nbsp;
				
					
					&nbsp;&nbsp;&nbsp;
					<input type="submit" value="查询">
					&nbsp;&nbsp;&nbsp;
					<a href="/ClassSystem/Index/Class/insert.jsp">添加</a>
				</td>
			</tr>
		
		  <tr align="center">
			<td>课程名</td>
			<td>课程号</td>
			<td>课程人数</td>
			<td>授课教师</td>
			<td>教师电话</td>
		  </tr>
		  <%List<classxx> list=(List<classxx>)request.getAttribute("list"); 
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
		<% i++;}
		else{
			request.getRequestDispatcher("/SearchClassServlet").forward(request, response);
		}%>
	<tr>
	 <%PageBean<classxx> pageBean=(PageBean<classxx>)request.getAttribute("pageBean");%>
			   <tr>
			  	<td colspan="8">
			  		第 ${pageBean.currentPage } / ${pageBean.totalPage }
			  		&nbsp;&nbsp;
			  		每页显示${pageBean.pageSize }条  &nbsp;&nbsp;&nbsp;
			  		总的记录数${pageBean.totalSize } &nbsp;&nbsp;&nbsp;
			  		<c:if test="${pageBean.currentPage !=1 }">
			  			<a href="/ClassSystem/SearchClassServlet?currentPage=1">首页</a>
						| <a href="/ClassSystem/SearchClassServlet?currentPage=${pageBean.currentPage-1 }">上一页</a>
			  		</c:if>
			  		
			  		<c:forEach begin="1" end="${pageBean.totalPage }" var="i">
			  			<c:if test="${pageBean.currentPage == i }">
			  				${i }
			  			</c:if>
			  			<c:if test="${pageBean.currentPage != i }">
			  				<a href="/ClassSystem/SearchClassServlet?currentPage=${i }">${i }</a>
			  			</c:if>
			  		
			  		</c:forEach>
			  		
			  		
			  		<c:if test="${pageBean.currentPage !=pageBean.totalPage }">
			  			<a href="/ClassSystem/SearchClassServlet?currentPage=${pageBean.currentPage+1 }">下一页</a> | 
			  			<a href="/ClassSystem/SearchClassServlet?currentPage=${pageBean.totalPage }">尾页</a>
			  		</c:if>
			  	</td>
			  </tr>
		  </table>
	  </form>


</div>
<div class="top-order">
    <label id="time" ></label><label class="count">您好，用户</label><button class="ex">退出</button>
</div>
<div class="bottom-change">
</div>
</body>

</html>