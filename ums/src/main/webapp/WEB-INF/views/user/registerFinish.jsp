<%@include file="/WEB-INF/views/common/header.jsp"%>

<div align="center"></div>

ユーザID：<%=session.getAttribute("userId")%>の登録が完了しました。

<%
session.invalidate();
%>

<%@include file="/WEB-INF/views/common/footer.jsp"%>