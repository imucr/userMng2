<%@include file="/WEB-INF/views/common/header.jsp"%>

<%@include file="/WEB-INF/views/common/SessionNullOrNot_header.jsp"%>

<div align="center">
<form action="${pageContext.request.contextPath}/user/search" method="get"> <!-- TODO 後でPOSTに修正 -->
 		ユーザID：<input type="text" name="user_id"/><br/>
  		名前：<input type="text" name="name"/><br/>
 		生年月日：<input type="text" name="birth"/><br/>
 		住所：<input type="text" name="address"/><br/>
 		電話番号：<input type="text" name="pn"/><br/>
 		権限：<input type="text" name="status"/><br/>
 		状態：<input type="text" name="updated"/><br/> 
 		
		<input type="submit" value="検索" />
	</form>
</div>

<%@include file="/WEB-INF/views/common/SessionNullOrNot_footer.jsp"%>

<%@include file="/WEB-INF/views/common/footer.jsp"%>