<% 
if(session.getAttribute("LOGIN.OK")==null){%>
	<center>
		<a href="${pageContext.request.contextPath}/login?form">ログイン場面へ</a>
	</center>
	
<% }else{%>