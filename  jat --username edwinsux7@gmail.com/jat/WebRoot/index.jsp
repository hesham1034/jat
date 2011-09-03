<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<!-- 工具 -->
	<script type="text/javascript" src="<%=basePath%>js/scommonjs/scommon.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/scommonjs/override/dialog.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/scommonjs/exception.js"></script>
	<!-- ExtJs插件 -->
	<script type="text/javascript" src="<%=basePath%>js/extjs/plugins/SearchField.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/extjs/plugins/TabCloseMenu.js"></script>
	<!-- 主页 -->
	<script type="text/javascript" src="<%=basePath%>js/webjs/main.js"></script>
	<script type="text/javascript">
		var _main = new jat.main.MainPage();
		_main.render("mainPage");
	</script>
  </head>
  
  <body>
	  	<div id="mainPage"></div>
  </body>
</html>
