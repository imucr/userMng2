<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="left">
ユーザー管理システム
<input type="button" onclick="location.href='${pageContext.request.contextPath}/top'" value="トップページへ" />
</div>

<div align="right">
username ログイン中
<button name="logout" onclick="#">ログアウト</button>
</div>
<hr>