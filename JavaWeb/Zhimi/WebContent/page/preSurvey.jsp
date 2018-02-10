<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>知米世界班</title>
<script src="style/jquery-3.1.0.min.js"></script>
<link rel="stylesheet" href="style/weui.min.css"/>
<script src="style/form.js"></script>
<script type="text/javascript">
	function checkValidate(){ 

	if($("input:checked").length >= 4){ 

		window.location.href="survey.do"; 
	}else{ 

		$(".weui_dialog_alert").show();
	} 
	} 
	function closeDialog(){ 

		$(".weui_dialog_alert").hide();
		} 
</script>
</head>
<body>
<div style="font-size: 20px;">
<h3>申请须知</h3>
*************************************<br>
<div class="weui_cells_title">勾选以确认：</div>
  <div class="weui_cells weui_cells_checkbox">
  	<label class="weui_cell weui_check_label" for="s10">
      <div class="weui_cell_hd">
        <input type="checkbox" value="z" class="weui_check" name="clause" id="s10">
        <i class="weui_icon_checked"></i>
      </div>
      <div class="weui_cell_bd weui_cell_primary">
        <p>互助小组的宗旨为“相互分享、相互督促、相互纠正”。</p>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="s11">
      <div class="weui_cell_hd">
        <input type="checkbox" value="a" class="weui_check" name="clause" id="s11">
        <i class="weui_icon_checked"></i>
      </div>
      <div class="weui_cell_bd weui_cell_primary">
        <p>每个小组4人左右，希望大家在小组中互相了解，互相学习，有更高的学习积极性。</p>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="s12">
      <div class="weui_cell_hd">
        <input type="checkbox" value="b" name="clause" class="weui_check" id="s12">
        <i class="weui_icon_checked"></i>
      </div>
      <div class="weui_cell_bd weui_cell_primary">
        <p>互助小组自愿加入,加入后请与同组同学共同制定互助计划。</p>
      </div>
    </label>
    <label class="weui_cell weui_check_label" for="s13">
      <div class="weui_cell_hd">
        <input type="checkbox" value="c" name="clause" class="weui_check" id="s13">
        <i class="weui_icon_checked"></i>
      </div>
      <div class="weui_cell_bd weui_cell_primary">
        <p>申请加入须在后续背景调查界面登记自己的英语背景，登记结束后将根据背景相似程度进行分组。</p>
      </div>
    </label>
  </div>
  <div class="weui_dialog_alert" style="display: none;">
  <div class="weui_mask"></div>
  <div class="weui_dialog">
    <div class="weui_dialog_hd">
      <strong class="weui_dialog_title">警告</strong>
    </div>
    <div class="weui_dialog_bd">只有同意所有条款才能进入调查问卷！</div>
    <div class="weui_dialog_ft">
      <a href="javascript:;" class="weui_btn_dialog primary" onclick="closeDialog()">确定</a>
    </div>
  </div>
</div>
<a onclick="checkValidate()" href="javascript:void(0)" class="weui_btn weui_btn_primary">同意</a><br>
<a href="nameList.do" class="weui_btn weui_btn_primary">不同意</a>

</div>
</body>
</html>