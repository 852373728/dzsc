<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
$(function(){
	$.post("/foot/getOne.do",function(result){
		$("#PageFoot").html(result.msg.msg);
	},"json");
});

	
</script>
<div class="footer_banner margin_top15"></div>
<div id="PageFoot" style="background-color: #f0f0f0;padding: 40px;"></div>
