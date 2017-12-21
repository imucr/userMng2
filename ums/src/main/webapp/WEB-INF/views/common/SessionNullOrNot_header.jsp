<% 
if(session.getAttribute("LOGIN.OK")==null){%>
	<center>
		<a href="${pageContext.request.contextPath}/login?form">ログイン場面へ</a>
	</center>

<!-- FIXME Xマークエラー出る。作動には問題ないけど目障り。消すこと。-->	
<% }else{%>