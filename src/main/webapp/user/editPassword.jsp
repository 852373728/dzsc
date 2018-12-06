<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改密码</title>
<script type="text/javascript">
	$(function(){
		$("#m_pwd").on("input propertychange",function(){
			var pattern = /^[0-9A-Za-z]{1,10}$/;
			if($(this).val()==""){
				$(this).next().html("密码不能为空");
			}else if(!pattern.test($(this).val())){
				$(this).next().html("密码格式不正确 ");
			}else{
				$(this).next().html("");
			}
			if($(this).val()!=$("#m_repwd").val()){
				$("#m_repwd").next().html("两次输入的密码不一致");
			}else{
				$("#m_repwd").next().html("");
			}
		});
		$("#m_repwd").on("input propertychange",function(){
			if($(this).val()!=$("#m_pwd").val()){
				$(this).next().html("两次输入的密码不一致");
			}else{
				$(this).next().html("");
			}
		});
	});
	
	function editPassword(){
		var flag=true;
		$(".w753_in").each(function(){
			if($(this).val()==""){
				$(this).next().html("不能为空");
			}
		});
		$(".validError").each(function(){
			if($(this).html()!=""){
				flag=false;
			}
		});
		if(flag){
			var pwd=$("#m_pwd").val();
			$.post("/kh/editPwd.html",{"pwd":pwd},function(result){
				if(result.state){
					alert(result.msg);
					zhuxiao();
				}else{
					alert(result.msg);
				}
			},"json");
		}
	}
</script>
</head>
<body>
	<table class="w753 margin_top10 ">
		<tbody>
			<tr class="title" >
				<td class="td_title" colspan="2">个人信息</td>
			</tr>
			<tr>
				<th>用户名称：</th>
				<td >${editUser.lxr }</td>
			</tr>
			<tr>
				<th>登录账号：</th>
				<td >${editUser.email }</td>
			</tr>
			<tr>
				<th>新密码：</th>
				<td ><input id="m_pwd" class="w753_in" type="password"/>&nbsp;<span class="validError" ></span> </td>
			</tr>
			<tr>
				<th>确认新密码：</th>
		 		<td><input id="m_repwd" class="w753_in" type="password"/>&nbsp;<span class="validError"></span> </td>
			</tr>
			<tr >
				<td style="text-align: center;" colspan="2"><div style="height: 40px;padding-top: 5px;"><button onclick="editPassword()" type="button" class="btn btn-primary btn-xs">确认</button></div> </td>
			</tr>
		</tbody>
	</table>
</body>
</html>