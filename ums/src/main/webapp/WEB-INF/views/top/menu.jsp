<%@include file="/WEB-INF/views/common/header.jsp"%>

<center>

	<form action="${pageContext.request.contextPath}/user/register" method="get">
		<input type="submit" name="form" value="登録"> <!-- MEMO 或いはこうやってもいい　<button name="form">登録</button> <input type=button こんなのは存在しない-->
	</form>

	<form action="${pageContext.request.contextPath}/user/search" method="get">
		<input type="submit" name="form" value="検索">
	</form>

</center>

<%@include file="/WEB-INF/views/common/footer.jsp"%>
