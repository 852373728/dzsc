<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>推荐品种商品的添加</title>
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
	function zt(val,row){
		if(val=="2"){
			return "已通过审核";
		}else if(val=="1"){
			return "待审核";
		}else if(val=="3"){
			return "未通过";
		}
	}
	
	function openTuiJianAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加推荐商品");
		url="BackTuiJian/save.html";
	}
	
	function saveMainShow(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
				var result=eval('('+result+')');
				if(result.state){
					$.messager.alert("系统提示",result.msg);
					resetValue();
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
	
	function openTuiJianModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","修改用户");
		$('#fm').form('load',row);
		url="backKh/save.html?email="+row.email;
	}
	
	function deleteTuiJian(){
		var selectedRows=$('#dg').datagrid("getSelections");
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].email);
		}
		var emails=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("backKh/delete.html",{"emails":emails},function(result){
					if(result.state){
						$.messager.alert("系统提示",result.msg);
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert("系统提示",result.msg);
						$("#dg").datagrid("reload");
					}
				},"json");
			}
		});
	}
	
	
	function resetValue(){
		$("#zt").combobox("setValue",1);
	}
	
	function closeMainShowDialog(){
		resetValue();
		$("#dlg").dialog("close");
	}
</script>
</head>
<body style="margin:1px;">
	<table id="dg" class="easyui-datagrid"
	 fitColumns="true" pagination="true" rownumbers="true"
	 url="backKh/list.do" fit="true" toolbar="#tb">
	 <thead>
	 	<tr>
	 		<th field="cb" checkbox="true" align="center"></th>
	 		<th field="email" width="50" align="center">账号</th>
	 		<th field="password" width="50" align="center" >密码</th>
	 		<th field="dwmc" width="50" align="center" >单位名称</th>
	 		<th field="lxr" width="50" align="center" >联系人</th>
	 		<th field="lxdh" width="50" align="center">联系电话</th>
	 		<th field="adress" width="50" align="center">详细地址</th>
	 		<th field="zt" width="50" align="center" formatter="zt">审核状态</th>
	 		<th field="st_userclass" width="50" align="center" >用户类型</th>
	 		<th field="yxq" width="50" align="center">有效期</th>
	 		<th field="ywybh" width="50" align="center">业务员编号</th>
	 		<th field="ywyxm" width="50" align="center">业务员姓名</th>
	 		<th field="khdm" width="50" align="center">客户代码</th>
	 	</tr>
	 </thead>
	</table>
	<div id="tb">
 		<div>
			<!-- <a href="javascript:;" onclick="openTuiJianAddDialog()" class="easyui-linkbutton" iconCls="icon-add" >添加</a> -->
			<a href="javascript:;" onclick="openTuiJianModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" >修改</a>
			<a href="javascript:;" onclick="deleteTuiJian()" class="easyui-linkbutton" iconCls="icon-remove" >删除</a>
		</div>
	</div>
	<div id="dlg" class="easyui-dialog" style="width: 350px;height:200px;text-align: center;max-height: 100%;"
	 closed="true" buttons="#dlg-buttons">
		<form method="post" id="fm" style="display: inline-block;" enctype="multipart/form-data">
			<table cellspacing="8px" >
				 <tr>
	 				<td>审核：</td>
	 				<td>
	 					<input name="zt" id="zt" class="easyui-combobox" panelHeight="auto" editable="false" data-options="
						valueField: 'id',
						textField: 'text',
						data: [{
							id: 1,
							text: '待审核'
						},{
							id: 2,
							text: '通过'
						},{
							id: 3,
							text: '拒绝'
						}]" />
					</td>
	 			</tr> 
			</table> 
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:;" onclick="saveMainShow()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:;" onclick="closeMainShowDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
	<jsp:include page="spkBack.jsp" />
</body>
</html>