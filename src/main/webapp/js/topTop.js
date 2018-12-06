//写cookies，有时间
function setCookieHasTime(name,value){
	var Days = 30;
	var exp = new Date();
	exp.setTime(exp.getTime() + Days*24*60*60*1000);
	document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString()+";path=/";
	}
//写cookies，没有时间
function setCookieNoTime(name,value){
	document.cookie = name + "="+ escape (value)+";path=/";
	}
function getCookie(name){
	var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
	if(arr=document.cookie.match(reg))
	return unescape(arr[2]);
	else
	return null;
}

//删除cookies
function delCookie(name){
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval=getCookie(name);
	if(cval!=null)
	document.cookie= name + "="+cval+";expires="+exp.toGMTString()+";path=/";
}
function toyanzheng(){
		if($("#username").val()==""){
			$("#loginMessage").html("请输入你的帐号");
			return false;
		}
		if($("#pwd").val()==""){
			$("#loginMessage").html("请输入你的密码");
			return false;
		}
		if($("#captchaCode").val()==""){
			$("#loginMessage").html("请输入验证码");
			return false;
		}
         var params = $("#myform").serialize();  
         $.ajax( {  
             type : "POST",  
             url : "/kh/login.html",  
             data : params,  
             dataType:"json",
             success : function(result) { 
            	if(result.state){
            		 $("#wait").show();
              		 $("#loginBtn").attr("disabled", true); 
              		 $('#loginMessage').html("");
              		 var currentUser= result.currentUser;
        			 if($('#remember').is(':checked')){
        				setCookieHasTime("email",currentUser.email);
        				setCookieHasTime("password",currentUser.password);
      				 }else{
      					setCookieNoTime("email",currentUser.email);
      					setCookieNoTime("password",currentUser.password);
      				 }
        			 window.location.reload();
            	}else{
            		$('#loginMessage').html(result.msg);
               		loadimage();
            	}
             }  
         });  
	}
