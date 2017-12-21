<%@include file="/WEB-INF/views/common/header.jsp"%>

<%@include file="/WEB-INF/views/common/SessionNullOrNot_header.jsp"%>

<div align="center">

<!--  TODO ページめくるhyperlink -->
<!--  TODO 現在ページ位置表示 -->

	<table border="1" cellpadding="0" cellspacing="0" width="500">
		<tr>
			<td>選択</td>
			<td>ユーザーID</td>     <!-- パスワードは出力しない -->
			<td>名前</td>
			<td>生年月日</td>
			<td>住所</td>
			<td>電話番号</td>
			<td>権限</td>
			<td>状態</td>
		</tr>

		  
		<c:forEach items="${list}" var="list">
			<tr>
				<td></td>
				<td>${list.user_id}</td>
				<td>${list.name}</td>
				<td>${list.birth}</td>
				<td>${list.address}</td>
				<td>${list.pn}</td>
				<td>${list.status}</td>
				<td>${list.updated}</td>				
			</tr>
		</c:forEach>
	</table>	<br>
	
<form action="${pageContext.request.contextPath}/user/update" method="get">
	<input type="submit" name="formUserId" value="更新" /><!-- FIXME form&userId=xyzに -->
</form>

<form action="${pageContext.request.contextPath}/user/delete" method="get">
	<input type="submit" name="formUserId" value="削除" /><!-- FIXME form&userId=xyzに -->
</form>

</div>

<%@include file="/WEB-INF/views/common/SessionNullOrNot_footer.jsp"%>

<%@include file="/WEB-INF/views/common/footer.jsp"%>