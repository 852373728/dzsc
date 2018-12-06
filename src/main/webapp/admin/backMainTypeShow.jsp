<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/backStyle.css">
<title>前台首页药品功效，保健食品等的商品展示</title>
<script type="text/javascript">
var url;
var goodsType;

function searchMainTypeShow(){
	$('#dg').datagrid("load",{
		"homePageshow":$("#leixing").combobox("getValue"),
		"searchName":$("#searchName").val()
	});
}

 $(function(){
	$("#leixing").combobox({
		onSelect:function(record){
			$('#dg').datagrid("load",{
				"homePageshow":record.value,
				"searchName":$("#searchName").val()
			});
		}
	});
	$("#homePageshow").combobox({
		onSelect:function(record){
			if(goodsType!=undefined){
				if(record.value=="1"){
	    			$("#splbMc1").val(goodsType.lbmc);
	    			$("#splbDm").val(goodsType.lbdm);
	    		}else{
	    			if(goodsType.spkLb!=null){
	    				$("#splbMc1").val(goodsType.spkLb.lbmc);
		    			$("#splbDm").val(goodsType.spkLb.lbdm);
	    			}
	    		}
			}
			
		}
	});
	
})
 
function formatSptplj(val,row){
	if(val==""){
		return "";
	}else{
		return "<a class='aa_focus' target='_blank' href='"+val+"'>已上传</a>";
	}
}
function spdm(val,row){
	return row.spk.spdm;
}
function spmc(val,row){
	return row.spk.spmc;
}
function lbmc(val,row){
	return row.spkLb.lbmc;
}

function openMainShowAddDialog(){
	goodsType=null;
	$("#dlg").dialog("open").dialog("setTitle","添加首页展示商品");
	url="backMainTypeShow/save.do";
}

function saveMainShow(){
	$("#fm").form("submit",{
		url:url,
		onSubmit:function(){
			if(!/^\d+$/.test($("#homePagexh").val().trim()))  {
				$("#homePagexh").val(0); 
			}
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
				$.messager.alert("系统提示","添加失败");
			}
		}
	});
}

function openMainShowModifyDialog(){
	var selectedRows=$("#dg").datagrid('getSelections');
	if(selectedRows.length!=1){
		$.messager.alert("系统提示","请选择一条要编辑的数据！");
		return;
	}
	var row=selectedRows[0];
	$("#dlg").dialog("open").dialog("setTitle","修改首页展示商品");
	$('#fm').form('load',row);
	$('#spmc').val(row.spk.spmc);
	$.post("backSpkLb/getOnebyLbdm.do",{"lbdm":row.spk.web_splbdm},function(result){
		goodsType=result;
		$("#splbMc1").val(row.spkLb.lbmc);
	},"json");
	url="backMainTypeShow/save.do?id="+row.id;
}

function deleteMainShow(){
	var selectedRows=$('#dg').datagrid("getSelections");
	if(selectedRows.length==0){
		$.messager.alert("系统提示","请选择要删除的数据！");
		return;
	}
	var strIds=[];
	for(var i=0;i<selectedRows.length;i++){
		strIds.push(selectedRows[i].id);
	}
	var ids=strIds.join(",");
	$.messager.confirm("系统提示","您确认要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
		if(r){
			$.post("backMainTypeShow/delete.do",{ids:ids},function(result){
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
	$("#spmc").val("");
	$("#spkId").val("");
	$("#pic1").val("");
	$("#splbMc1").val("");
	$("#splbDm").val("");
	$("#homePagexh").val("");
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
	 url="backMainTypeShow/list.do" fit="true" toolbar="#tb">
	 <thead>
	 	<tr>
	 		<th field="cb" checkbox="true" align="center"></th>
	 		<th field="spk.spmc" width="50" align="center" formatter="spmc">商品名称</th>
	 		<th field="spk.spdm" width="50" align="center" formatter="spdm">商品代码</th>
	 		<th field="spkLb.lbmc" width="50" align="center" formatter="lbmc">所属分类</th>
	 		<th field="homePageshow" width="50" align="center">首页位置</th>
	 		<th field="homePagexh" width="20" align="center">展示顺序</th>
	 		<th field="onePicTplj" width="50" align="center" formatter="formatSptplj">展示图片</th>
	 	</tr>
	 </thead>
	</table>
	<div id="tb">
 		<div>
			<a href="javascript:;" onclick="openMainShowAddDialog()" class="easyui-linkbutton" iconCls="icon-add" >添加</a>
			<a href="javascript:;" onclick="openMainShowModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" >修改</a>
			<a href="javascript:;" onclick="deleteMainShow()" class="easyui-linkbutton" iconCls="icon-remove" >删除</a>
			<span class="zswz">首页位置：1=二级分类下的四个商品展示。2=一级分类下的一张图片展示，就是最左边的那张图片，3=大家都在找的商品展示，最多展示四条。展示图片：最左边的一张图片，200px*320px</span>
		</div>
		 <div style="margin-top: 5px;">
			&nbsp;名称:&nbsp;<input type="text" id="searchName" size="20" onkeydown="if(event.keyCode==13) searchMainTypeShow()"/>
			&nbsp;首页位置:&nbsp;<select id="leixing" class="easyui-combobox" data-options="panelHeight:'auto',editable:false" style="width:173px;">
								<option value="">all</option>
								<option value="1">1</option>
	 							<option value="2">2</option>
	 							<option value="3">3</option>
							</select>
			<a href="javascript:searchMainTypeShow()" class="easyui-linkbutton" iconCls="icon-search" style="vertical-align: top;">搜索</a>
		</div> 
	</div>
	<div id="dlg" class="easyui-dialog" style="width: 350px;height:300px;text-align: center;"
	 closed="true" buttons="#dlg-buttons">
		<form method="post" id="fm" style="display: inline-block;" enctype="multipart/form-data">
			<table cellspacing="8px">
				<tr>
	 				<td colspan="2" align="center"><a href="javascript:;" onclick="choseGoods()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >选择商品</a></td>
	 			</tr>
				 <tr>
	 				<td>商品名称</td>
	 				<td>
	 					<input id="spmc" type="text" readonly="readonly" class="easyui-validatebox" required="true"/>
						<input type="hidden" id="spkId" name="spkId"/>
					</td>
	 			</tr> 
	 			 <tr>
	 				<td>图片展示：</td>
	 				<td>
	 					<input id="pic1" type="file" style="width: 173px;" name="pic1"/>
	 				</td>
	 			</tr> 
	 			<tr>
	 				<td>展示位置：</td>
	 				<td>
	 					<select id="homePageshow" class="hPSC" name="homePageshow" class="easyui-combobox" data-options="panelHeight:'auto',editable:false" style="width:173px;">
	 						<option value="1">1</option>
	 						<option value="2">2</option>
	 						<option value="3">3</option>
	 					</select>
	 				</td>
	 			</tr>
	 			<tr>
	 				<td>所属分类：</td>
	 				<td>
	 					<input id="splbMc1" class="easyui-validatebox" readonly="readonly"/>
	 					<input name="splbDm" id="splbDm" type="hidden"/>
	 				</td>
	 			</tr>
	 			<tr>
	 				<td>排列顺序：</td>
	 				<td><input  id="homePagexh" type="text" name="homePagexh"/></td>
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