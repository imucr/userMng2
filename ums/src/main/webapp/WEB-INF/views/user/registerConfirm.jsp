<%@include file="/WEB-INF/views/common/header.jsp"%>

<div align="center">
	<table border="0">
		<tr>
			<td align="right">ユーザーID:</td>
			<td>${userId}</td>
		</tr>

		<tr>
			<td align="right">名前:</td>
			<td>${username}</td>
		</tr>

		<tr>
			<td align="right">生年月日:</td>
			<td>${birthDay}</td>
		</tr>
		
		<tr>
			<td align="right">住所:</td>
			<td>${address}</td>
		</tr>
		
		<tr>
			<td align="right">電話番号:</td>
			<td>${telNum}</td>
		</tr>						

		<tr>
			<td align="right">権限:</td>
			<td>${roles}	</td>
		</tr>
				
	</table>

<form action="${pageContext.request.contextPath}/user/register" method="get"> <!-- FIXME POSTに修正 -->
	
	<input type="submit" value="確認"/>
	<input type="submit" name="redo" value="やり直し" />
		<!-- FIXME やり直しボタンをPOSTに -->
		<!-- QUESTION 表示された値を、戻ったフォームページに自動的に表示されるようにするには？　MEMO redirectとforwardの違い：JSP本 p186 -->
		
</form>
</div>


<%@include file="/WEB-INF/views/common/footer.jsp"%>