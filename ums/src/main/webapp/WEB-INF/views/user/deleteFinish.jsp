<%@include file="/WEB-INF/views/common/header.jsp"%>

<%@include file="/WEB-INF/views/common/SessionNullOrNot_header.jsp"%>


<div align="center">

	ユーザID：<%=session.getAttribute("user_id")%>の削除が完了しました。



</div>

<%@include file="/WEB-INF/views/common/SessionNullOrNot_footer.jsp"%>

<%@include file="/WEB-INF/views/common/footer.jsp"%>