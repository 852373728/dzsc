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
	function searchTuiJian(){
		$("#dg").datagrid("load",{
			"twobarName":$("#ejzl").combobox("getText"),
			"searchName":$("#searchName").val()
		});
	}
	
	$(function(){
		$("#ejzl").combobox({
			onSelect:function(record){
				$('#dg').datagrid("load",{
					"twobarName":record.name,
					"searchName":$("#searchName").val()
				});
			}
		});
	});

	
	
	function spdm(val,row){
		if(row.spk!=null){
			return row.spk.spdm;
		}
	}
	function spmc(val,row){
		if(row.spk!=null){
			return row.spk.spmc;
		}
	}
	
	function show(val,row){
		if(val=="0"){
			return "";
		}else{
			return val;
		}
	}
	
	function showCarousel(val,row){
		if(val=="1"){
			return "是";
		}else{
			return "";
		}
	}
	
	function homePageTuijianCarousel(val,row){
		if(val=="1"){
			return "是";
		}else{
			return "";
		}
	}
	
	function sptpljLeft(val,row){
		if(val==""){
			return "";
		}else{
			return "<a class='aa_focus' target='_blank' href='"+val+"'>已上传</a>";
		}
	}
	
	function sptplj_carousel(val,row){
		if(val==""){
			return "";
		}else{
			return "<a class='aa_focus' target='_blank' href='"+val+"'>已上传</a>";
		}
	}
	
	function homePageTuijianCarouselTp(val,row){
		if(val==""){
			return "";
		}else{
			return "<a class='aa_focus' target='_blank' href='"+val+"'>已上传</a>";
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
		$("#dlg").dialog("open").dialog("setTitle","修改推荐商品");
		$('#fm').form('load',row);
		url="BackTuiJian/save.html?id="+row.id;
	}
	
	function deleteTuiJian(){
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
				$.post("BackTuiJian/delete.html",{ids:ids},function(result){
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
		$("#xh").val("");
		$("#pic1").val("");
		$("#xhCarousel").val("");
		$("#pic2").val("");
		$("#homePageTuijianCarouselXh").val("");
		$("#pic3").val("");
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
	 url="BackTuiJian/list.do" fit="true" toolbar="#tb">
	 <thead>
	 	<tr>
	 		<th field="cb" checkbox="true" align="center"></th>
	 		<th field="spk.spmc" width="50" align="center" formatter="spmc">商品名称</th>
	 		<th field="spk.spdm" width="40" align="center" formatter="spdm">厂家商品代码</th>
	 		<th field="twobarName" width="30" align="center">二级</th>
	 		<th field="show" width="20" align="center" formatter="show">展示位置</th>
	 		<th field="xh" width="15" align="center">排序</th>
	 		<th field="sptpljLeft" width="30" align="center" formatter="sptpljLeft">192x258图片</th>
	 		<th field="homePageTuijianCarousel" width="20" align="center" formatter="homePageTuijianCarousel">首页轮播</th>
	 		<th field="homePageTuijianCarouselXh" width="20" align="center" >排序</th>
	 		<th field="homePageTuijianCarouselTp" width="20" align="center" formatter="homePageTuijianCarouselTp">首页图片</th>
	 	</tr>
	 </thead>
	</table>
	<div id="tb">
 		<div>
			<!-- <a href="javascript:;" onclick="openTuiJianAddDialog()" class="easyui-linkbutton" iconCls="icon-add" >添加</a> -->
			<a href="javascript:;" onclick="openTuiJianModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" >修改</a>
			<a href="javascript:;" onclick="deleteTuiJian()" class="easyui-linkbutton" iconCls="icon-remove" >删除</a>
			<span class="zswz">展示位置：1代表首页和推荐页面下每个栏目的五个商品的展示，2代表推荐页面下每个栏目最左边的一个商品展示,192px*258px。首页轮播：首页推荐品种栏目下左边的轮播图片,200px*288px</span>
		</div>
		<div style="margin-top: 5px;">
			&nbsp;名称:&nbsp;<input type="text" id="searchName" size="20" onkeydown="if(event.keyCode==13) searchTuiJian()"/> 
			&nbsp;二级种类:&nbsp;<input class="easyui-combobox" id="ejzl" data-options="panelHeight:'auto',editable:false,valueField:'id',textField:'name',url:'BackTwobar/combobox/4.do'"/>
			<a href="javascript:;" onclick="searchTuiJian()" class="easyui-linkbutton" iconCls="icon-search" style="vertical-align: top;">搜索</a>
		</div> 
	</div>
	<div id="dlg" class="easyui-dialog" style="width: 350px;height:400px;text-align: center;max-height: 100%;"
	 closed="true" buttons="#dlg-buttons">
		<form method="post" id="fm" style="display: inline-block;" enctype="multipart/form-data">
			<table cellspacing="8px" >
	 			<tr>
	 				<td>展示位置：</td>
	 				<td>
	 					<select id="show" name="show" class="zswz">
	 						<option value="0">展示位置</option>
	 						<option value="1">1</option>
	 						<option value="2">2</option>
	 					</select>
	 				</td>
	 			</tr>
	 			<tr>
	 				<td>排列顺序：</td>
	 				<td><input class="moren"  id="xh" type="text" name="xh"/></td>
	 			</tr>
	 			<tr>
	 				<td align="right">图片：</td>
	 				<td>
	 					<input id="pic1" type="file" style="width: 173px;" name="pic1"/>
	 				</td>
	 			</tr> 
	 			 <tr>
	 				<td>首页轮播：</td>
	 				<td>
	 					<select id="homePageTuijianCarousel" name="homePageTuijianCarousel" class="zswz">
	 						<option value="0">否</option>
	 						<option value="1">是</option>
	 					</select>
	 				</td>
	 			 </tr>
	 			 <tr>
	 				<td>排列顺序：</td>
	 				<td><input class="moren"  id="homePageTuijianCarouselXh" type="text" name="homePageTuijianCarouselXh"/></td>
	 			 </tr>
	 			 <tr>
	 				<td align="right">图片：</td>
	 				<td><input id="pic3" type="file" style="width: 173px;" name="pic3"/>
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