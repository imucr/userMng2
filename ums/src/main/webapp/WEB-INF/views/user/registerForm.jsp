<%@include file="/WEB-INF/views/common/header.jsp"%>

<!-- TODO validation保留-->

<div align="center">
	<h2>register 'form'</h2>

	<spring:hasBindErrors name="uvo2" />
	<form action="${pageContext.request.contextPath}/user/register"
		method="get">
		<!-- FIXME post -->
		<table border="1">
			<tr>
				<td align="right">ユーザID:</td>
				<td><input type="text" name="userId" /> <form:errors
						path="uvo2.userId" /></td>
			</tr>

			<tr>
				<td align="right">名前:</td>
				<td><input type="text" name="username" value="" /></td>
			</tr>

			<tr>
				<td align="right">生年月日:</td>
				<td><input type="text" name="birthDay" value="" /></td>
			</tr>

			<tr>
				<td align="right">住所:</td>
				<td><input type="text" name="address" value="" /></td>
			</tr>

			<tr>
				<td align="right">電話番号:</td>
				<td><input type="text" name="telNum" value="" /></td>
			</tr>


			<!--  
		<tr>
			<td align="right">権限:</td>
			<td>
				<input type="checkbox" name="roles">ADMIN
				<input type="checkbox" name="roles2">USER 
			</td>
		</tr> 
-->

			<tr>
				<td align="right">パスワード:</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td align="right">パスワード確認:</td>
				<td><input type="password" name="confirmPassword" /></td>
			</tr>

		</table>

		<input type="submit" name="confirm" value="登録" />
	</form>
</div>


<%@include file="/WEB-INF/views/common/footer.jsp"%>
