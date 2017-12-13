<%@include file="/WEB-INF/views/common/header.jsp"%>


<div align="center">

	ユーザID：<%=session.getAttribute("user_id")%>の削除が完了しました。

	<%
session.invalidate();
%>

</div>





<%@include file="/WEB-INF/views/common/footer.jsp"%>