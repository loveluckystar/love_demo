<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>http请求测试页</title>
<%@include file="inc/cssjs.jsp" %>
<link href="css/login.css" rel="stylesheet" type="text/css" />  
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<div class="container">

      <form class="form-signin" action="/sp/httpsubmit.action" method="post">
        <h2 class="form-signin-heading">SP后台登陆</h2>
        <label for="httpurl" class="sr-only">url地址</label>
        <input type="text" id="httpurl" name="httpurl"   class="form-control" placeholder="url地址" required autofocus>
        <button class="btn btn-lg btn-primary btn-block" type="submit">提交</button>
      </form>
        结果：${result}

    </div> 
</body>
</html>
