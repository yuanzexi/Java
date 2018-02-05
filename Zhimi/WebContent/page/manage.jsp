<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理系统</title>
</head>
<body>
<div style="font-size: 20px;">
<a href="other.do" >重置功能</a>
<h3>管理系统：</h3>
<form style="font-size: 20px;" action="update.do" method="post">
<table cellspacing="0" cellpadding="0" border="1" bordercolor="black" style="text-align: right;font-size: 20px;" >
<tr style="font-size: 20px;">
	<td></td>
	<td>姓名</td>
	<td>本周积分</td>
	<td>总积分</td>
	<td>备注</td>
	<td>口语预约</td>
	<td>调查结果</td>
</tr>
<c:forEach items="${userlist}" var="p">
<tr style="font-size: 20px;">
    <td><input name="id" type="radio" value="${p.id}">${p.id}</td>
    <td>${p.username}</td>
    <td>${p.score}</td>
    <td>${p.sum}</td>
    <td>${p.remark}</td>
    <td>${p.oraltime}</td>
    <td>${p.survey1}</td>
    <td><a href="delete.do?id=${p.id }" >删除</a></td>
</tr>
</c:forEach>
</table>
-----------------------------------------------<br>
<input name="id" type="radio" value="0">新增<br>
ID号：<input type="text" name="newid"><br>
姓名：<input type="text" name="username"><br>
本周积分：<input name="score" type="text"><br>
总积分：<input name="sum" type="text"><br>
<input type="submit" value="提交" style="font-size: 20px;">
</form>
</div>
</body>
</html>