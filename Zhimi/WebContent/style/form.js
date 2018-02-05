$(function(){
  $('#button').on('click', function(){
	  $('#documentForm').submit();
  });
});

document.body.setAttribute('ontouchstart', '');
// android
//document.title = "WeUI表单序列化示例";
