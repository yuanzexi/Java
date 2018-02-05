<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8"> -->
<title>知米世界班</title>
<script src="style/jquery-3.1.0.min.js"></script>
<link rel="stylesheet" href="style/weui.min.css"/>
<script type="text/javascript">
	function submit(){ 

	if($("input[name='id']:checked").length > 0 && $("input[name='point']:checked").length > 0 && $("input[name='task']:checked").length > 0){ 
		 $('#documentForm').submit();
	}else{ 
			$(".weui_dialog_alert").show();
		} 
	} 
	function closeDialog(){ 
		$(".weui_dialog_alert").hide();
	} 
</script>
</head>
<body >
<a href="rankList.do" class="weui_btn weui_btn_primary">查看排行榜</a>
<a href="oralOrder.do" class="weui_btn weui_btn_primary">口语练习预约通道</a>
<a href="preSurvey.do" class="weui_btn weui_btn_primary">加入互助小组</a>
<a href="page/base.apk" class="weui_btn weui_btn_primary">单词猎人版《知米背单词》</a>
<h3>积分登记：</h3>
<form id="documentForm" action="addScore.do" method="post">
  <div class="weui_cells_title">请选择您自己的用户名：</div>
  <div class="weui_cells weui_cells_radio">
  	<c:forEach items="${userlist}" var="p">
	  	<label class="weui_cell weui_check_label" for="${p.id}">
	      <div class="weui_cell_bd weui_cell_primary">
	        <p>${p.username}</p>
	      </div>
	      <div class="weui_cell_ft">
	        <input type="radio" value="${p.id}" class="weui_check" name="id" id="${p.id}">
	        <span class="weui_icon_checked"></span>
	      </div>
	    </label>
	</c:forEach>
	</div>
	<div class="weui_cells_title">请选择本次完成的任务：</div>
  	<div class="weui_cells weui_cells_radio">
    <label class="weui_cell weui_check_label" for="x15">
      <div class="weui_cell_bd weui_cell_primary">
        <p>［纯听］听材料并回答简单问题，1分</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="纯听" class="weui_check" name="task" id="x15">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x16">
      <div class="weui_cell_bd weui_cell_primary">
        <p>［听评］听材料并作出评论/笔记，2分</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="听评" name="task" class="weui_check" id="x16">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x17">
      <div class="weui_cell_bd weui_cell_primary">
        <p>［听写］听材料并写出原文，2分</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="听写" name="task" class="weui_check" id="x17">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x18">
      <div class="weui_cell_bd weui_cell_primary">
        <p>［跟读］跟读给定语音片段，1分</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="跟读" name="task" class="weui_check" id="x18">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x19">
      <div class="weui_cell_bd weui_cell_primary">
        <p>［聊天］参加即时聊天口语活动，2分</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="聊天" name="task" class="weui_check" id="x19">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x20">
      <div class="weui_cell_bd weui_cell_primary">
        <p>［配音］用配音类App配音，1分</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="配音" name="task" class="weui_check" id="x20">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x21">
      <div class="weui_cell_bd weui_cell_primary">
        <p>［语音］具体见任务内容</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="语音" name="task" class="weui_check" id="x21">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x22">
      <div class="weui_cell_bd weui_cell_primary">
        <p>［阅读］读材料并回答简单问题，1分</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="阅读" name="task" class="weui_check" id="x22">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x23">
      <div class="weui_cell_bd weui_cell_primary">
        <p>［读评］读材料并作出评论，2分</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="读评" name="task" class="weui_check" id="x23">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x24">
      <div class="weui_cell_bd weui_cell_primary">
        <p>［写作］具体见任务内容</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="写作" name="task" class="weui_check" id="x24">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x25">
      <div class="weui_cell_bd weui_cell_primary">
        <p>［词汇］具体见任务内容</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="词汇" name="task" class="weui_check" id="x25">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
     <label class="weui_cell weui_check_label" for="x26">
      <div class="weui_cell_bd weui_cell_primary">
        <p>［推文］用公众号发送推文一次，2分</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="推文" name="task" class="weui_check" id="x26">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x27">
      <div class="weui_cell_bd weui_cell_primary">
        <p>［其他］</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="其他" name="task" class="weui_check" id="x27">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
  </div>
	<div class="weui_cells_title">请选择本次获得的积分：</div>
  	<div class="weui_cells weui_cells_radio">
    <label class="weui_cell weui_check_label" for="x11">
      <div class="weui_cell_bd weui_cell_primary">
        <p>1</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="1" class="weui_check" name="point" id="x11">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x12">
      <div class="weui_cell_bd weui_cell_primary">
        <p>2</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="2" name="point" class="weui_check" id="x12">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x13">
      <div class="weui_cell_bd weui_cell_primary">
        <p>3</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="3" name="point" class="weui_check" id="x13">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x14">
      <div class="weui_cell_bd weui_cell_primary">
        <p>4</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="4" name="point" class="weui_check" id="x14">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
  </div>
  <div class="weui_dialog_alert" style="display: none;">
  <div class="weui_mask"></div>
  <div class="weui_dialog">
    <div class="weui_dialog_hd">
      <strong class="weui_dialog_title">警告</strong>
    </div>
    <div class="weui_dialog_bd">信息未填写完整！</div>
    <div class="weui_dialog_ft">
      <a href="javascript:;" onclick="closeDialog()" class="weui_btn_dialog primary">确定</a>
    </div>
  </div>
</div>

  <div class="weui_btn_area">
    <a class="weui_btn weui_btn_primary" href="javascript:void(0);" onclick="submit()">提交</a>
  </div>
</form>




<!-- 
<div style="font-size: 20px;">
<form action="addScore.do" method="post">
*************************************<br>
请选择您自己的用户名：<br>
<table cellspacing="0" cellpadding="0" border="1" bordercolor="black" style="text-align: right;font-size: 20px;" >
<tr style="font-size: 20px;">
	<td></td>
	<td>姓名</td>
	<td>本周积分</td>
	<td>总积分</td>
</tr>
<c:forEach items="${userlist}" var="p">
<tr style="font-size: 20px;">
    <td><input name="id" type="radio" value="${p.id}">${p.id}</td>
    <td>${p.username}</td>
    <td>${p.score}</td>
    <td>${p.sum}</td>
</tr>
</c:forEach>
</table>
*************************************<br>
请选择本次获得的积分：<br>
<input name="point" type="radio" value="1">1<br>
<input name="point" type="radio" value="2">2<br>
<input name="point" type="radio" value="3">3<br>
<input name="point" type="radio" value="4">4<br>
*************************************<br>
<input type="submit" value="提交" style="font-size: 20px;">
</form>
</div>
 -->
</body>
</html>