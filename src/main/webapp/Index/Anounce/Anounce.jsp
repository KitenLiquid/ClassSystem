<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公告</title>
<style type="text/css">
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
        #page{
            width: 20px;
            position: absolute;
            right: 150%;
            top: 0px;
        }
        .page{
            position: absolute;
            right: 50%;
            top: 10px;
        }
.change{
display:block;
opacity: 0;
position: absolute;
left:40%;
top:40%;
width: 20%;
height: 20%;
z-index:20;
background-color: #ffffff;
border:1px solid #2c3850;
box-shadow: 10px 10px 10px -4px rgb(0,0,0);
border-radius:20px 20px 20px 20px;
}
.ta{
position: absolute;
right:10%;
top:13%;
border: black;
}
.up{
position: relative;
left:100px;
}
h3{
text-align:center;
}
.K1{
position: absolute;
right:180px;
top:40px;
}
.K2{
position: absolute;
right:50px;
top:40px;
}
.ch1{
position: absolute;
top:70px;
right:100px;
}
.ch2{
position: absolute;
top:100px;
right:100px;
}
.bt{
position: absolute;
bottom:10px;
right:100px;
}
</style>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
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
            
        })
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
<script>
$(function(){
	var index;
	$(".up").click(function () {
		index=$(this).val();
		$(".change").css("opacity","1");
		$(".ch1").css("opacity","0");
		$(".ch2").css("opacity","0");
		$(".av1").val(index);
    });
	$(".cancel").click(function () {
		$(".change").css("opacity","0");
    });
	$("#tr").click(function () {
		if($(".A1").is(":checked")==true){
			$(".ch1").css("opacity","1");
		}
		else{
			$(".ch1").css("opacity","0");
		}
		if($(".A2").is(":checked")==true){
			$(".ch2").css("opacity","1");
		}
		else{
			$(".ch2").css("opacity","0");
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
	<div class="K1"><input type="checkbox"  class="A1" name="A1" value="1">编辑名称</div><div class="K2"><input type="checkbox" class="A2" name="A2" value="2">编辑内容<input type="button" id="tr" name="a2" value="确认"></div><br>
	<div class="ch1"><label>名称</label><input type="text" name="newName"><br></div>
	<div class="ch2"><label>内容</label><input type="text" name="newContent"><br></div>
	<div class="bt"><input type="submit" name="de" class="go" value="确认编辑"><label>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</label><input type="button" class="cancel" value="取消"></div>
	</form>
	</div>
	
	<table class="ta" border=1 cellspacing="5" cellpadding="10" width="1200"> <tr><th>编号</th><th>名称</th><th>内容</th><th>操作</th>
	</tr><%
	
	while(i<l){
	%>	
	
        
  
    <form action="http://localhost:8080/ClassSystem/Delete" method=post>
	<tr><td><%=list.get(i).getNo() %></td><td><%=list.get(i).getName() %></td><td><%=list.get(i).getContent() %></td>
	<td><input type="hidden" name="delete" value="<%=list.get(i).getNo() %>" /> <input type="submit" name="de" value="删除"></form><button  class="up" value="<%=i %>">更新</button></td></tr>
	
	<%
	
		i++;
	}
	%> </table>
	<h1>公告信息</h1>
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
            <li>课程信息</li>
        </ul>
        <li>成绩管理</li>
        <ul class="a3">
            <li>成绩信息</li>
            <li>新建成绩</li>
        </ul>
    </ul>
</div>
<div class="top-order">
    <label id="time" ></label><label class="count">您好，用户${sessionScope.User}</label><button class="ex">退出</button>
</div>
<div class="bottom-change">
    <form action="#" method="get" class="page">
        <input type="text" name="page" id="page"><input type="submit" value="跳转">
    </form>
</div>
	
	    <%
} %>

</body>
</html>