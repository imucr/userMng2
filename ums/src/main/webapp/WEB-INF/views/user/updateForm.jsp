<%@include file="/WEB-INF/views/common/header.jsp"%>

<!-- TODO validation機能実装 -->

<div align="center">
<form action="${pageContext.request.contextPath}/user/update" method="get"><!-- FIXME POSTに -->
	<table border="0">
		<tr>
			<td align="right">ユーザーID:</td>
			<td><input type="text" name="userId" value="user_id"/></td>
		</tr>

		<tr>
			<td align="right">名前:</td>
			<td><input type="text" name="username" value="name"/></td>
		</tr>

		<tr>
			<td align="right">生年月日:</td>
			<td><input type="text" name="birthDay" value="birth"/></td>
		</tr>
		
		<tr>
			<td align="right">住所:</td>
			<td><input type="text" name="address" value="address"/></td>
		</tr>
		
		<tr>
			<td align="right">電話番号:</td>
			<td><input type="text" name="telNum" value="pn"/></td>
		</tr>						

		<tr>
			<td align="right">権限:</td>
			<td>
				<input type="checkbox" name="roles" value="">ADMIN
				<input type="checkbox" name="roles" value="">USER
			</td>
		</tr>
				
		<tr>
			<td align="right">パスワード:</td>
			<td><input type="password" name="password" value="password"/></td>
		</tr>		

		<tr>
			<td align="right">パスワード確認:</td>
			<td><input type="password" name="confirmPassword" value="password2"/></td>
		</tr>
				
	</table>
	
	<input type="submit" name="confirm" value="登録"/>
</form>
</div>


<%@include file="/WEB-INF/views/common/footer.jsp"%>