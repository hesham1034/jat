<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<body>
		<!-- 设置系统基路径，便于JS取出 -->
<input type="hidden" id="basePath" value="<%=basePath%>"/>
	</body>
</html>
