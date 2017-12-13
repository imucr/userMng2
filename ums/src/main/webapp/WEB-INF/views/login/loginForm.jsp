<%@include file="/WEB-INF/views/common/header.jsp"%>

<div align="center">
<form action="${pageContext.request.contextPath}/top" method="GET"> <!-- FIXME postに修正 -->
	<table border="0">
		<tr>
			<td>ユーザーID:</td>
			<td><input type="text" name="userId" /></td>
		</tr>
		
		<tr>
			<td>パスワード:</td>
			<td><input type="password" name="password" /></td>
		</tr>		
	</table>
	
	<input type="submit" value="ログイン"/>
</form>
</div>

<%@include file="/WEB-INF/views/common/footer.jsp"%>
	<!-- MEMO https://stackoverflow.com/questions/18846556/how-to-include-jsps-file-from-another-folder -->

	<!-- QUESTION vs jsp:include page~
		 ANSWER https://stackoverflow.com/questions/7879906/what-is-the-difference-between-jspinclude-page-and-include-file	
	-->