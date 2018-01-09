<%@include file="/WEB-INF/views/common/header.jsp"%>

<div align="center">

<form action="${pageContext.request.contextPath}/password/change" method="GET"> <!-- FIXME POST -->
	<table border="0">
		<tr>
			<td>パスワード:</td>
			<td><input type="text" name="password" /></td>
		</tr>
		
		<tr>
			<td>パスワード確認:</td>
			<td><input type="text" name="confirmPassword" /></td> <!-- TODO validation -->
		</tr>		
	</table>
	
	<input type="submit" value="パスワード変更"/>
</form>

</div>

<%@include file="/WEB-INF/views/common/footer.jsp"%>