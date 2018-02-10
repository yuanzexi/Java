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

	if($("input[name='id']:checked").length > 0 && $("input[name='level']:checked").length > 0 && $("input[name='skill']:checked").length > 0 && $("input[name='willing']:checked").length > 0){ 
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
<h3>问卷调查：</h3>
<form id="documentForm" action="addSurvey.do" method="post">
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
	<div class="weui_cells_title">请选择最接近的英语水平：</div>
  	<div class="weui_cells weui_cells_radio">
    <label class="weui_cell weui_check_label" for="x15">
      <div class="weui_cell_bd weui_cell_primary">
        <p>大学四级</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="四级" class="weui_check" name="level" id="x15">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x16">
      <div class="weui_cell_bd weui_cell_primary">
        <p>大学六级</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="六级" name="level" class="weui_check" id="x16">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x17">
      <div class="weui_cell_bd weui_cell_primary">
        <p>考研</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="考研" name="level" class="weui_check" id="x17">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x18">
      <div class="weui_cell_bd weui_cell_primary">
        <p>雅思</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="雅思" name="level" class="weui_check" id="x18">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x19">
      <div class="weui_cell_bd weui_cell_primary">
        <p>托福</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="托福" name="level" class="weui_check" id="x19">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x20">
      <div class="weui_cell_bd weui_cell_primary">
        <p>英语爱好者</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="爱好" name="level" class="weui_check" id="x20">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
  </div>
  <div class="weui_cells_title">请选择想锻炼的技能：</div>
  <div class="weui_cells weui_cells_checkbox">
    <label class="weui_cell weui_check_label" for="s11">
      <div class="weui_cell_hd">
        <input type="checkbox" value="听" class="weui_check" name="skill" id="s11">
        <i class="weui_icon_checked"></i>
      </div>
      <div class="weui_cell_bd weui_cell_primary">
        <p>听</p>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="s12">
      <div class="weui_cell_hd">
        <input type="checkbox" value="说" name="skill" class="weui_check" id="s12">
        <i class="weui_icon_checked"></i>
      </div>
      <div class="weui_cell_bd weui_cell_primary">
        <p>说</p>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="s13">
      <div class="weui_cell_hd">
        <input type="checkbox" value="读" name="skill" class="weui_check" id="s13">
        <i class="weui_icon_checked"></i>
      </div>
      <div class="weui_cell_bd weui_cell_primary">
        <p>读</p>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="s14">
      <div class="weui_cell_hd">
        <input type="checkbox" value="写" name="skill" class="weui_check" id="s14">
        <i class="weui_icon_checked"></i>
      </div>
      <div class="weui_cell_bd weui_cell_primary">
        <p>写</p>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="s15">
      <div class="weui_cell_hd">
        <input type="checkbox" value="单词" name="skill" class="weui_check" id="s15">
        <i class="weui_icon_checked"></i>
      </div>
      <div class="weui_cell_bd weui_cell_primary">
        <p>单词</p>
      </div>
    </label>
  </div>
  <div class="weui_cells_title">是否愿意协助管理小组：</div>
  	<div class="weui_cells weui_cells_radio">
    <label class="weui_cell weui_check_label" for="x11">
      <div class="weui_cell_bd weui_cell_primary">
        <p>愿意</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="愿意" class="weui_check" name="willing" id="x11">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="x12">
      <div class="weui_cell_bd weui_cell_primary">
        <p>不愿意</p>
      </div>
      <div class="weui_cell_ft">
        <input type="radio" value="不愿意" name="willing" class="weui_check" id="x12">
        <span class="weui_icon_checked"></span>
      </div>
    </label>
  </div>
  
  <div class="weui_btn_area">
    <a class="weui_btn weui_btn_primary" href="javascript:void(0);" onclick="submit()">提交</a>
  </div>
</form>

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

<!-- 
<div class="weui_cells_title">是否愿意协助管理小组：</div>
  <div class="weui_cells weui_cells_form">
    <div class="weui_cell weui_cell_switch">
      <div class="weui_cell_hd weui_cell_primary">愿意协助管理小组</div>
      <div class="weui_cell_ft">
        <input class="weui_switch" name="willing" value="true" type="checkbox">
      </div>
    </div>
  </div>
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