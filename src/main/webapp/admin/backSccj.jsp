<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>生产厂家</title>
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

var url;

/* function aa(val,row){
	return "<a class='aa_focus' href='javascript:openDetails("+row.id+")'>详情</a>";
}

function openDetails(id){
	 window.parent.openTab('厂家详情','sccjDetails.jsp?sccjId='+id,'icon-detail');
} */

function lbdm(val,row){
	if(row.spkLb!=null){
		return row.spkLb.lbmc;
	}
}

function renqiShow(val,row){
	if(val=="1"){
		return "是";
	}else{
		return "";
	}
}

function tuijianShow(val,row){
	if(val=="1"){
		return "是";
	}else{
		return "";
	}
}

function tplj(val,row){
	if(val==""){
		return "";
	}else{
		return "<a class='aa_focus' target='_blank' href='/image_xhyyPt/spk/"+val+"'>已上传</a>";
	}
}

function show(val,row){
	if(val=="1"){
		return "是";
	}else{
		return "";
	}
}

function openSccjModifyDialog(){
	var selectedRows=$("#dg").datagrid('getSelections');
	if(selectedRows.length!=1){
		$.messager.alert("系统提示","请选择一条要编辑的数据！");
		return;
	}
	var row=selectedRows[0];
	$("#dlg").dialog("open").dialog("setTitle","修改生产厂家");
	$('#fm').form('load',row);
	url="backSccj/save.html?id="+row.id;
}

function saveSccj(){
	$("#fm").form("submit",{
		url:url,
		onSubmit:function(){
			$(".moren").each(function(){
				if(!/^\d+$/.test($(this).val().trim()))  {
					$(this).val(0); 
				}
			});
			return $(this).form("validate");
		},
		success:function(result){
			var result=eval('('+result+')');
			if(result.state){
				$.messager.alert("系统提示",result.msg);
				$("#dlg").dialog("close");
				$("#dg").datagrid("reload");
			}else{
				$.messager.alert("系统提示",result.msg);
				$("#dlg").dialog("close");
				$("#dg").datagrid("reload");
			}
		}
	});
}

function closeSccjldialog(){
	$("#dlg").dialog("close");
}
</script>
</head>
<body>
<table id="dg" class="easyui-datagrid"
  pagination="true" rownumbers="true" fitColumns="true"
 url="backSccj/list.do" fit="true" toolbar="#tb">
 <thead>
 	<tr>
 		<th field="cb" checkbox="true" align="center"></th>
 		<!-- <th field="aa" width="50px" align="center" formatter="aa">操作</th> -->
 		<th field="cjmc" width="50" align="center">名称</th>
 		<th field="cjjj" width="50" align="center">简介</th>
 		<th field="xh" width="50" align="center">排序</th>
 		<th field="show" width="50" align="center" formatter="show">条件显示</th>
 		<th field="tplj" width="50" align="center" formatter="tplj">图片</th>
 		<th field="spkLb.lbdm" width="50" align="center" formatter="lbdm">首页位置</th>
 		<th field="tuijianShow" width="50" align="center" formatter="tuijianShow">推荐</th>
 		<th field="tuijianxh" width="50" align="center">推荐排序</th>
 		<th field="pinpaiShow" width="50" align="center" formatter="renqiShow">人气品牌</th>
 		<th field="pinpaixh" width="50" align="center">推荐排序</th>
 	</tr>
 </thead>
</table>
<div id="tb">
	<div>
		<a href="javascript:;" onclick="openSccjModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" >修改</a>
		<span class="zswz">条件显示：可供页面等的生产厂家是否显示，推荐：推荐品种页面的右边的厂家图片显示，人气品牌：品牌专区的人气品牌的厂家图片显示</span>
	</div>
</div>
<div id="dlg" class="easyui-dialog" style="width:350px;height:400px;text-align: center;max-height: 100%;"
	 closed="true" buttons="#dlg-buttons">
		<form method="post" id="fm" style="display: inline-block;">
			<table cellspacing="8px" >
	 			<tr>
	 				<td>名称：</td>
	 				<td>
	 					<input id="cjmc" type="text" name="cjmc" readonly="readonly"/>
	 				</td>
	 			</tr>
	 			<tr>
	 				<td>排序：</td>
	 				<td>
	 					<input class="moren" id="xh" type="text" name="xh" />
	 				</td>
	 			</tr>
	 			<tr>
	 				<td>条件显示：</td>
	 				<td>
	 					<input name="show" id="show" class="easyui-combobox" panelHeight="auto" editable="false" data-options="
							valueField: 'id',
							textField: 'text',
							data: [{
								id: 0,
								text: '否'
							},{
								id: 1,
								text: '是'
							}]" />
	 				</td>
	 			</tr>
	 			<tr>
	 				<td>首页位置：</td>
	 				<td>
	 					<input id="splbDm" name="splbDm" class="easyui-combobox" data-options="panelHeight:'auto',editable:false,valueField:'lbdm',textField:'lbmc',url:'backSpkLb/combobox.do?cjbz=1'"/>
	 				</td>
	 			</tr>
	 			<tr>
	 				<td>推荐：</td>
	 				<td>
	 					<input name="tuijianShow" id="tuijianShow" class="easyui-combobox" panelHeight="auto" editable="false" data-options="
							valueField: 'id',
							textField: 'text',
							data: [{
								id: 0,
								text: '否'
							},{
								id: 1,
								text: '是'
							}]" />
	 				</td>
	 			</tr>
	 			<tr>
	 				<td>推荐排序：</td>
	 				<td>
	 					<input class="moren" id="tuijianxh" type="text" name="tuijianxh" />
	 				</td>
	 			</tr>
	 			<tr>
	 				<td>人气品牌：</td>
	 				<td>
	 					<input name="pinpaiShow" id="pinpaiShow" class="easyui-combobox" panelHeight="auto" editable="false" data-options="
							valueField: 'id',
							textField: 'text',
							data: [{
								id: 0,
								text: '否'
							},{
								id: 1,
								text: '是'
							}]" />
	 				</td>
	 			</tr>
	 			<tr>
	 				<td>人气排序：</td>
	 				<td>
	 					<input class="moren" id="pinpaixh" type="text" name="pinpaixh" />
	 				</td>
	 			</tr>
			</table> 
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:;" onclick="saveSccj()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:;" onclick="closeSccjldialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>



</body>
</html>