<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>知米世界班</title>
</head>
<body>
<div style="font-size: 20px;">
<h3>口语预约：</h3>
<form action="addOral.do" method="post">
*************************************<br>
请选择您自己的用户名：<br>
<table cellspacing="0" cellpadding="0" border="1" bordercolor="black" style="text-align: right;font-size: 20px;" >
<tr style="font-size: 20px;">
	<td></td>
	<td>姓名</td>
	<td>预约时间</td>
</tr>
<c:forEach items="${userlist}" var="p">
<tr style="font-size: 20px;">
    <td><input name="id" type="radio" value="${p.id}">${p.id}</td>
    <td>${p.username}</td>
    <td>${p.oraltime}</td>
</tr>
</c:forEach>
</table>
*************************************<br>
请选择想预约的时间：<br>
<input name="oraltime" type="checkbox" value="周四晚9点">周四晚9点<br>
<input name="oraltime" type="checkbox" value="周四晚9点（试听）">周四晚9点（试听）<br>
*************************************<br>
<input type="submit" value="提交" style="font-size: 20px;">
</form>
</div>
</body>
</html>