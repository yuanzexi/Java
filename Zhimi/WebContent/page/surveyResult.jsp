<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>调查问卷结果</title>
</head>
<body>
<div style="font-size: 20px;">
<table cellspacing="0" cellpadding="0" border="1" bordercolor="black" style="text-align:center;font-size: 20px;" >
<h1>调查问卷结果</h1>
<tr style="font-size: 20px;">
	<td>姓名</td>
	<td>英语背景</td>
</tr>
<c:forEach items="${userlist}" var="p">
<tr style="font-size: 20px;">
	<td>${p.username}</td>
    <td>${p.survey1}</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>