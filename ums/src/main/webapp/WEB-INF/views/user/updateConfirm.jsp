<%@include file="/WEB-INF/views/common/header.jsp"%>

<div align="center">

<form action="${pageContext.request.contextPath}/user/update" method="get"> <!-- FIXME POSTに修正 -->

	<table border="0">
		<tr>
			<td align="right">ユーザーID:</td>
			<td><%=session.getAttribute("userId")%></td>
		</tr>

		<tr>
			<td align="right">名前:</td>
			<td><%=session.getAttribute("username")%></td>
		</tr>

		<tr>
			<td align="right">生年月日:</td>
			<td><%=session.getAttribute("birthDay")%></td>
		</tr>
		
		<tr>
			<td align="right">住所:</td>
			<td><%=session.getAttribute("address")%></td>
		</tr>
		
		<tr>
			<td align="right">電話番号:</td>
			<td><%=session.getAttribute("telNum")%></td>
		</tr>						

<%-- 保留
		<tr>
			<td align="right">権限:</td>
			<td>${roles}	</td>
		</tr>
--%>
				
	</table>
	
	<input type="submit" value="確認"/>
</form>

<form action="${pageContext.request.contextPath}/user/update" method="get"> <!-- FIXME POSTに修正 -->	
	<input type="submit" name="redo" value="やり直し" />
</form>

</div>


<%@include file="/WEB-INF/views/common/footer.jsp"%>