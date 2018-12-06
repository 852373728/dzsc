<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品库的一级分类</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/backStyle.css">
<script type="text/javascript">
var biaoji;
$(function(){
	
	$('#dg').treegrid({
		url:'backSpkLb/treeList.do?lbparent=z',
		onLoadSuccess:function(){
			$("#dg").treegrid('expandAll');
		},
		onClickCell:function(field,row){
			$('#dg').treegrid('endEdit', biaoji);
			$('#dg').treegrid('beginEdit', row.lbdm);
			biaoji=row.lbdm;
		}
	});
});
function show(val,row){
	if(row.show=="1"){
		return "是";
	}
}

function savesplb(){
	$('#dg').treegrid('endEdit', biaoji);
	 var obj_tgd = $('#dg');
     if (obj_tgd.treegrid('getChanges').length == 0)//未操作，不保存
         return;
     //同datagrid 一样 分别取修改、新增和删除的行数据
     var data = JSON.stringify(obj_tgd.treegrid('getChanges', "updated")); //otype: this[frmname + 'savetype'],
     $.post("backSpkLb/save.do",{data:data},function(result){
    	 if(result.state){
				$.messager.alert("系统提示",result.msg);
				$("#dg").treegrid("reload");
			}else{
				$.messager.alert("系统提示",result.msg);
				$("#dg").treegrid("reload");
			}
     },"json");
}

</script>



</head>
<body style="margin:1px;">
<table id="dg" class="easyui-treegrid"
 data-options="idField:'lbdm',treeField:'lbmc',fit:true,fitColumns:true,rownumbers:true" toolbar="#tb">
 <thead>
 	<tr>
 		<th field="lbmc" width="50" align="left">分类名称</th>
 		<th field="xh" width="50" align="center" editor="numberbox">序号</th>
 		<th field="show" width="50" align="center" formatter="show" editor="{type:'checkbox',options:{on:'1',off:''}}">是否显示</th>
 	</tr>
 </thead>
</table>
<div id="tb">
	<div>
		<a href="javascript:;" onclick="savesplb()" class="easyui-linkbutton" iconCls="icon-ok" >保存</a>
	</div>
</div>

</body>
</html>