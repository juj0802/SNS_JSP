<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:main>
<form action="<c:url value="/user/login" />"  method="post">
<table align="center">
    <tr>
        <td colspan="2" align="center" height="40">로그인</td>
    </tr>
    <tr>
        <td>
            <label for="id">아이디 &nbsp;&nbsp;</label>
            <input type="text" id="id">
            <input type="checkbox" name="saveId" id="saveId"${ empty cookie.saveId ? "" : " checked"}>
			<label for="saveId">아이디 저장</label>
        </td>
    </tr>
    <tr>
        <td>
            <label for="pw">비밀번호</label>
            <input type="password" id="pw">
        </td>
    </tr>
    <tr>
        <td align="center"><button type="submit">로그인하기</button></td>
        
    </tr>
    <tr>
        <td align="center">회원이 아니신가요? <br>
                <a href="#">회원가입</a>
        </td>
    </tr>
</table>

</form>


</layout:main>