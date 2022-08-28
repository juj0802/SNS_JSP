<%@ tag description="공통 레이아웃" pageEncoding="UTF-8" %>
<%@ tag body-content="scriptless" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="header" fragment="true" %>
<%@ attribute name="footer" fragment="true" %>
<%@ attribute name="menu" fragment="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/style.css" />">
		<script src="<c:url value="/static/js/common.js" />"></script>
	</head>
	<body>
		<jsp:invoke fragment="header" />
		<jsp:invoke fragment="menu" />
		
		<jsp:doBody />
		
		<jsp:invoke fragment="footer" />
	</body>
</html>