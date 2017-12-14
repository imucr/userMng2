<%@include file="/WEB-INF/views/common/header.jsp"%>

<%
String roles=(String)session.getAttribute("roles");
%>	

<div align="center">
	<table border="0">	

<%--	
		<tr>
			<td align="right">ユーザID:</td>
		<td><%=session.getAttribute("userId")%></td>
		</tr>

 
		<tr>
			<td align="right">名前:</td>
			<td>${username}</td>
		</tr>

		<tr>
			<td align="right">生年月日:</td>
			<td>${birthDay}</td>
		</tr>
		
		<tr>
			<td align="right">住所:</td>
			<td>${address}</td>
		</tr>
		
		<tr>
			<td align="right">電話番号:</td>
			<td>${telNum}</td>
		</tr>						
--%>
		<tr>
			<td align="right">権限:</td>
			<td><%=result(roles)%></td>
		</tr>

				
	</table>

<form action="${pageContext.request.contextPath}/user/register" method="get"> <!-- FIXME POST -->
	
	<input type="submit" value="確認"/>
	<input type="submit" name="redo" value="やり直し" />
		<!-- FIXME　POST　-->
		
</form>
</div>



<%@include file="/WEB-INF/views/common/footer.jsp"%>

<%!
private String result(String roles) {
	if (roles == null) //QUESTION なんでif(roles.equals("on"))から始めちゃダメか
		return "";
	else
		return "ADMIN";

}
%>