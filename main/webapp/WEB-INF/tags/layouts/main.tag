<%@ tag description="메인 레이아웃" pageEncoding="UTF-8" %>
<%@ tag body-content="scriptless" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:common>
	<jsp:attribute name="header">
		<h1>헤더</h1>
	</jsp:attribute>
	<jsp:attribute name="menu">
		<h2>메인 메뉴</h2>
	</jsp:attribute>
	<jsp:attribute name="footer">
		<h1>푸터</h1>
	</jsp:attribute>
	<jsp:body>
		<jsp:doBody />
	</jsp:body>
</layout:common>