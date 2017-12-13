<%@include file="/WEB-INF/views/common/header.jsp"%>

<!-- TODO validation機能実装 -->

<div align="center">
<form action="${pageContext.request.contextPath}/user/register" method="get"> <!-- FIXME post修正 -->
	<table border="0">
		<tr>
			<td align="right">ユーザーID:</td>
			<td><input type="text" name="userId" value=""/></td>
		</tr>

		<tr>
			<td align="right">名前:</td>
			<td><input type="text" name="username" value=""/></td>
		</tr>

		<tr>
			<td align="right">生年月日:</td>
			<td><input type="text" name="birthDay" value=""/></td>
		</tr>
		
		<tr>
			<td align="right">住所:</td>
			<td><input type="text" name="address" value=""/></td>
		</tr>
		
		<tr>
			<td align="right">電話番号:</td>
			<td><input type="text" name="telNum" value=""/></td>
		</tr>						

		<tr>
			<td align="right">権限:</td>
			<td>
				<input type="checkbox" name="roles" value="1">ADMIN <!-- MEMO value: 送信される値 -->
				<input type="checkbox" name="roles" value="2">USER
			</td>
		</tr>
				
		<tr>
			<td align="right">パスワード:</td>
			<td><input type="password" name="password" /></td>
		</tr>		

		<tr>
			<td align="right">パスワード確認:</td>
			<td><input type="password" name="confirmPassword" /></td>
		</tr>
				
	</table>
	
	<input type="submit" name="confirm" value="登録"/>
</form>
</div>


<%@include file="/WEB-INF/views/common/footer.jsp"%>
