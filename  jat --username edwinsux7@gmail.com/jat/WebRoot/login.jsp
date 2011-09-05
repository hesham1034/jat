<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/common.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
     <!-- ExtJs3.2基本配置 -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/extjs/resources/css/ext-all.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery/jquery-1.6.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery/ext-jquery-adapter.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/extjs/ext-all.js"></script>
	<!-- tool -->
	<script type="text/javascript" src="<%=basePath%>js/scommonjs/scommon.js"></script>
    <!-- login -->
	<script type="text/javascript" src="<%=basePath%>js/webjs/login.js"></script>
  </head>
  
  <body>
  	${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message }
  	${param.message == 1 ? "验证码错误 " : ""}
  	<div id="loginForm"></div>
  </body>
</html>
