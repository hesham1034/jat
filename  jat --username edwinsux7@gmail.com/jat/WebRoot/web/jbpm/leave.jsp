<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<script type="text/javascript">
		var _leaveTaskPanel = new jat.jbpm.leave.LeaveTaskPanel();
		_leaveTaskPanel.render("leaveTaskPanelDiv");
	</script>
  </head>
  <body>
  	<div id="leaveTaskPanelDiv"></div>
  </body>
</html>