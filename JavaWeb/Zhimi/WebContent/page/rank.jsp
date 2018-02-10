<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>积分排行榜</title>
</head>
<body>
<div style="font-size: 20px;">
<table cellspacing="0" cellpadding="0" border="1" bordercolor="black" style="text-align:center;font-size: 20px;" >
<h1>知米世界班积分排行榜</h1>
<tr style="font-size: 20px;">
	<td>姓名</td>
	<td>本周积分</td>
	<td>总积分</td>
	<td>本周任务记录</td>
	<td>本周口语预约记录</td>
</tr>
<c:forEach items="${userlist}" var="p">
<tr style="font-size: 20px;">
    <td>${p.username}</td>
    <td>${p.score}</td>
    <td>${p.sum}</td>
    <td>${p.remark }</td>
    <td>${p.oraltime}</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>