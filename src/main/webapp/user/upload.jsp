<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
function upload(){
    var formData = new FormData($("#form1")[0]);  //重点：要用这种方法接收表单的参数
    $.ajax({
        url : "/uploadTrainProduct.do",
        type : 'POST',
        data : formData,
        // 告诉jQuery不要去处理发送的数据
        processData : false,                 
        // 告诉jQuery不要去设置Content-Type请求头
        contentType : false,
        async : false,
        dataType:"json",
        success : function(result) {
            if(result.status){
            	alert(result.msg);
            	$("#upFile").val("");
            }else{
            	alert("上传失败");
            }
        }
    });
}

</script>
<div style="margin-left: 200px;margin-top: 20px;">
	 <form method="post" enctype="multipart/form-data" id="form1">
	 <input type="file" name="file" id="upFile" style="margin-bottom: 20px;" multiple="multiple">
	 <button type="button" class="btn btn-primary" onclick="upload()">上传</button>
	 </form>
	
</div>
