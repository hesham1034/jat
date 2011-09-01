<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.scommon.util.SessionUtil"%>
<%@ include file="common/common.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>template</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- css -->
	<!-- ExtJs3.2基本配置 -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/extjs/resources/css/ext-all.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery/jquery-1.6.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery/ext-jquery-adapter.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/extjs/ext-all.js"></script>
	<!-- pushlet2.0.4 -->
	<script type="text/javascript" src="<%=basePath%>js/pushlet/ajax-pushlet-client.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/pushlet/callBack.js"></script>
	<!-- 工具 -->
	<script type="text/javascript" src="<%=basePath%>js/scommonjs/scommon.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/scommonjs/override/dialog.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/scommonjs/exception.js"></script>
	<!-- ExtJs插件 -->
	<script type="text/javascript" src="<%=basePath%>js/extjs/plugins/SearchField.js"></script>
	
	<script type="text/javascript">
	</script>
  </head>
  
  <body>
  	<!-- 设置系统基路径，便于JS取出 -->
	<input type="hidden" id="basePath" value="<%=basePath%>"/>
	
  </body>
</html>
