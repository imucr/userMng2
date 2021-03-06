<%@include file="/WEB-INF/views/common/header.jsp"%>

<!-- TODO validation保留-->

<div align="center">

	<form:form modelAttribute="uvo2" action="${pageContext.request.contextPath}/user/register" method="get"> <!-- FIXME post -->
		<table border="1">
			<tr>
				<td align="right">ユーザID:</td>
				<td><input type="text" name="userId" /> <!-- <form:errors
						path="userId" /> --></td>
			</tr>

			<tr>
				<td align="right">名前:</td>
				<td><input type="text" name="username" value="" /> <!-- <form:errors
						path="username" /> --> </td>
			</tr>

			<tr>
				<td align="right">生年月日:</td>
				<td><input type="text" name="birthDay" value="" /> <!-- <form:errors
						path="birthDay" /> --> </td>
			</tr>

			<tr>
				<td align="right">住所:</td>
				<td><input type="text" name="address" value="" /> <!-- <form:errors
						path="address" /> --> </td>
			</tr>

			<tr>
				<td align="right">電話番号:</td>
				<td><input type="text" name="telNum" value="" /> <!-- <form:errors
						path="telNum" /> --> </td>
			</tr>


	 
		<tr>
			<td align="right">権限:</td>
			<td>
			
				<form:checkboxes path="roles" items="${checkItems}" delimiter=" " /> <!--<form:errors
						path="roles" /> -->
							
			</td>
		</tr> 


			<tr>
				<td align="right">パスワード:</td>
				<td><input type="password" name="password" /> <!-- <form:errors
						path="password" /> --> </td>
			</tr>

			<tr>
				<td align="right">パスワード確認:</td>
				<td><input type="password" name="confirmPassword" /> <!-- <form:errors
						path="confirmPassword" /> --> </td>
			</tr>

		</table>

		<input type="submit" name="confirm" value="登録" />
	</form:form>
	
</div>


<%@include file="/WEB-INF/views/common/footer.jsp"%>
