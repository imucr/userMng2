<%@include file="/WEB-INF/views/common/header.jsp"%>

<%@include file="/WEB-INF/views/common/SessionNullOrNot_header.jsp"%>

<div align="center">

	<table border="0">
<!--		<c:forEach items="${deleteList}" var="deleteList"> -->
<form modelAttribute="deleteList">
			<tr>
				<td align="right">ユーザID:</td>
				<td>${deleteList.user_id}</td>
			</tr>
			<tr>
				<td align="right">名前:</td>
				<td>${deleteList.name}</td>
			</tr>
			<tr>
				<td align="right">生年月日:</td>
				<td>${deleteList.birth}</td>
			</tr>
			<tr>
				<td align="right">住所:</td>
				<td>${deleteList.address}</td>
			</tr>
			<tr>
				<td align="right">電話番号:</td>
				<td>${deleteList.pn}</td>
			</tr>

</form>
<!--  		</c:forEach> -->
	</table>

	<form action="${pageContext.request.contextPath}/user/delete"
		method="get">
		<!-- FIXME POST -->
		<input type="submit" value="確認" />
	</form>

	<form action="${pageContext.request.contextPath}/user/delete"
		method="get">
		<!-- FIXME POST -->
		<input type="submit" name="redo" value="やり直し" />
	</form>

</div>

<%@include file="/WEB-INF/views/common/SessionNullOrNot_footer.jsp"%>

<%@include file="/WEB-INF/views/common/footer.jsp"%>