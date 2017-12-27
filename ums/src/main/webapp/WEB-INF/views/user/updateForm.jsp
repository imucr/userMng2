<%@include file="/WEB-INF/views/common/header.jsp"%>

<%@include file="/WEB-INF/views/common/SessionNullOrNot_header.jsp"%>

<!-- TODO validation機能実装 -->

<div align="center">

<!--<spring:hasBindErrors name="uvo2" />-->
<form action="${pageContext.request.contextPath}/user/update" method="get" modelAttribute="updateList"><!-- FIXME POSTに -->
	<table border="0">
<!--  			<c:forEach items="${updateList}" var="updateList"> QUESTION forEach付けないと、値出力できないんだろう -->
	
		<tr>
			<td align="right">ユーザーID:</td>
			<td>${updateList.user_id}</td>
		</tr>
 
		<tr>
			<td align="right">名前:</td>
			<td><input type="text" name="username" value="${updateList.name}"/> <!--<form:errors path="uvo2.username"/>--> </td>
		</tr>

		<tr>
			<td align="right">生年月日:</td>
			<td><input type="text" name="birthDay" value="${updateList.birth}"/> (yyyy/MM/dd 形式) <!-- <form:errors path="uvo2.birthDay" /> --> </td>
		</tr>
		
		<tr>
			<td align="right">住所:</td>
			<td><input type="text" name="address" value="${updateList.address}"/> <!-- <form:errors path="uvo2.address" /> --> </td>
		</tr>
		
		<tr>
			<td align="right">電話番号:</td>
			<td><input type="text" name="telNum" value="${updateList.pn}"/> <!-- <form:errors path="uvo2.telNum" /> --> </td>
		</tr>						

<!-- 保留
		<tr>
			<td align="right">権限:</td>
			<td>
				<input type="checkbox" name="roles" value="">ADMIN
				<input type="checkbox" name="roles" value="">USER
			</td>
		</tr>
-->			
		<tr>
			<td align="right">パスワード:</td>
			<td><input type="password" name="password" value="${updateList.pw}"/> <!-- <form:errors path="uvo2.password" /> --> </td>
		</tr>		

		<tr>
			<td align="right">パスワード確認:</td>
			<td><input type="password" name="confirmPassword" value=""/> <!-- <form:errors
						path="uvo2.confirmPassword" /> --> </td>
		</tr>

<!--  		</c:forEach>				-->
	</table>
	
	<input type="submit" name="confirm" value="更新"/>
</form>
</div>

<%@include file="/WEB-INF/views/common/SessionNullOrNot_footer.jsp"%>

<%@include file="/WEB-INF/views/common/footer.jsp"%>