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
				<td>${list.roles}</td>				
				<td>${list.status}</td>				
			</tr>
		</c:forEach>
	</table>	<br>

<c:forEach items="${list}" var="list">	
	<form action="${pageContext.request.contextPath}/user/update" method="get">
		<input type="submit" name="form" value="更新" />
		<input type="hidden" name="userId" value="${list.user_id}">			
			<!-- QUESTION JSP ELを活かすため、なんでc:forEachを前後に置かなければならないんだろう ANSWER オブジェクトの内容を出力するには必要、ぐらいで知っておこう-->
			<!-- MEMO 解決に至るまで：JSTLをhtmlの中で使って動く例をネット上でキーワード検索で見つけた。そして上のコードと何が違うか注目すると、答えが出てきた-->
	</form>
</c:forEach>

<c:forEach items="${list}" var="list">	
<form action="${pageContext.request.contextPath}/user/delete" method="get">
	<input type="submit" name="form" value="削除" />
	<input type="hidden" name="userId" value="${list.user_id}">	
</form>
</c:forEach>

</div>

<%@include file="/WEB-INF/views/common/SessionNullOrNot_footer.jsp"%>

<%@include file="/WEB-INF/views/common/footer.jsp"%>