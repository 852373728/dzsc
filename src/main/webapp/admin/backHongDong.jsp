<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台活动商品的添加</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/backStyle.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
var url;

 $(function(){
	$("#ejzl").combobox({
		onSelect:function(record){
			$('#dg').datagrid("load",{
				"twoBarId":record.id,
				"searchName":$("#searchName").val()
			});  
		}
	});
	$("#twoBarId").combobox({
		onSelect:function(record){
			$("#threeBarId").combobox("reload","backThreeBar/combobox.do?twoBarId="+record.id);
			$("#threeBarId").combobox("setValue",0);
		}
	});    
});  

function searchHuoDong(){
	$('#dg').datagrid("load",{
		"twoBarId":$("#ejzl").combobox("getValue"),
		"searchName":$("#searchName").val()
	});
}

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

function showName(val,row){
	if(val=="1"){
		return "是";
	}else{
		return "";
	}
}

function show1Name(val,row){
	if(val=="1"){
		return "是";
	}else{
		return "";
	}
}

function underway(val,row){
	if(val=="1"){
		return "是";
	}else{
		return "";
	}
}

function homePageHuoDongCarousel(val,row){
	if(val=="1"){
		return "是";
	}else{
		return "";
	}
}

function homePageHuoDongCarouselTp(val,row){
	if(val==""){
		return "";
	}else{
		return "<a class='aa_focus' target='_blank' href='"+val+"'>已上传</a>";
	}
}

function openHuoDongAddDialog(){
	$("#dlg").dialog("open").dialog("setTitle","添加活动商品");
	url="backHuoDong/save.do";
}
function saveHuoDong(){
	$("#fm").form("submit",{
		url:url,
		onSubmit:function(){
			if($("#twoBarId").combobox("getValue")==0){
				$.messager.alert("系统提示","请选择二级种类");
				return false;
			}
			if($("#hdtime").val()==""){
				$.messager.alert("系统提示","请选择活动结束时间");
				return false;
			}
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
			}
		}
	});
}

function openHuoDongModifyDialog(){
	var selectedRows=$("#dg").datagrid('getSelections');
	if(selectedRows.length!=1){
		$.messager.alert("系统提示","请选择一条要编辑的数据！");
		return;
	}
	var row=selectedRows[0];
	$("#dlg").dialog("open").dialog("setTitle","修改活动商品");
	$('#spmc').val(row.spk.spmc);
	$('#fm').form('load',row);
	$("#threeBarId").combobox("setValue",row.threeBarId);
	url="backHuoDong/save.do?id="+row.id;
}



function deleteHuoDong(){
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
			$.post("backHuoDong/delete.do",{ids:ids},function(result){
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
	$("#twoBarId").combobox("setValue",0);
	$("#show").val("");
	$("#xh").val("");
	$("#show1").val("");
	$("#xh1").val("");
	$("#homePageHuoDongCarousel").val("");
	$("#homePageHuoDongCarouselXh").val("");
	$("#pic1").val("");
	$("#sfyx").val("1");
	$("#huoDongContent").val("");
	$("#hdtime").val("");
}

function closeHuoDongdialog(){
	resetValue();
	$("#dlg").dialog("close");
}

</script>
</head>
<body style="margin:1px;">
	<table id="dg" class="easyui-datagrid" fit="true"
	 pagination="true" rownumbers="true"
	 url="backHuoDong/list.do" toolbar="#tb" nowrap="false">
	 <thead data-options="frozen:true">
	 	<tr>
	 		<th field="cb" checkbox="true" align="center"></th>
	 		<th field="spmc" width="200px" align="center" formatter="spmc">商品名称</th>
	 		<th field="spdm" width="80px" align="center" formatter="spdm">厂家商品代码</th>
	 	</tr>
	 </thead>
	 <thead >
	 	<tr>
	 		<th field="twoBarName" width="100px" align="center">二级</th>
	 		<th field="sfyx" width="60px" align="center" formatter="underway">正在进行</th>
	 		<th field="hdtime" width="100px" align="center">结束时间</th>
	 		<th field="huoDongContent" width="200px" align="center">活动内容</th>
	 		<th field="show" width="60px" align="center" formatter="showName">活动显示</th>
	 		<th field="xh" width="60px" align="center">活动排序</th>
	 		<th field="show1" width="60px" align="center" formatter="show1Name">首页显示</th>
	 		<th field="xh1" width="60px" align="center">首页排序</th>
	 		<th field="homePageHuoDongCarousel" width="60px" align="center" formatter="homePageHuoDongCarousel">首页轮播</th>
	 		<th field="homePageHuoDongCarouselXh" width="60px" align="center" >排序</th>
	 		<th field="homePageHuoDongCarouselTp" width="60px" align="center" formatter="homePageHuoDongCarouselTp">首页图片</th>
	 	</tr>
	 </thead>
	</table>
	<div id="tb">
 		<div>
			<a href="javascript:;" onclick="openHuoDongAddDialog()" class="easyui-linkbutton" iconCls="icon-add" >添加</a>
			<a href="javascript:;" onclick="openHuoDongModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" >修改</a>
			<a href="javascript:;" onclick="deleteHuoDong()" class="easyui-linkbutton" iconCls="icon-remove" >删除</a>
			<span class="zswz">活动显示：指活动专区页面下每个三级栏目下的6个商品显示，首页显示：指首页活动专区二级栏目下的5个商品显示。首页轮播：首页最新活动栏目下左边的轮播图片,200px*288px</span>
		</div>
		 <div style="margin-top: 5px;">
			&nbsp;类型:&nbsp;<input type="text" id="searchName" size="20" onkeydown="if(event.keyCode==13) searchHuoDong()"/> 
			&nbsp;二级分类:&nbsp;<input class="easyui-combobox" id="ejzl" data-options="panelHeight:'auto',editable:false,valueField:'id',textField:'name',url:'BackTwobar/combobox/5.do'"/>
			<a href="javascript:searchHuoDong()" class="easyui-linkbutton" iconCls="icon-search" style="vertical-align: top;">搜索</a>
		</div> 
	</div>
	<div id="dlg" class="easyui-dialog" style="width: 600px;height:450px;text-align: center;max-height: 100%;"
	 closed="true" buttons="#dlg-buttons">
		<form method="post" id="fm" style="display: inline-block;" enctype="multipart/form-data">
			<table cellspacing="8px" >
				<tr>
					<td></td>
	 				<td colspan="3" align="center"><a href="javascript:;" onclick="choseGoods()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >选择商品</a></td>
	 			</tr>
				<tr>
	 				<td>商品名称：</td>
	 				<td colspan="3">
	 					<input id="spmc" type="text" readonly="readonly" class="easyui-validatebox" required="true"/>
						<input type="hidden" id="spkId" name="spkId"/>
					</td>
	 			</tr> 
	 			<tr>
	 				<td>二级分类：</td>
	 				<td>
	 					<input name="twoBarId" id="twoBarId" class="easyui-combobox" data-options="panelHeight:'auto',editable:false,valueField:'id',textField:'name',url:'BackTwobar/combobox/5.do'"/>
	 				</td>
	 				<td>结束时间：</td>
	 				<td>
	 					<input name="hdtime" style="cursor: pointer;" class="Wdate" id="hdtime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd 00:00:00',readOnly:true})" />
	 				</td>
	 			</tr>
	 			<tr>
	 				<td>活动显示：</td>
	 				<td>
	 					<select id="show" name="show" class="zswz">
	 						<option value="">否</option>
	 						<option value="1">是</option>
	 					</select>
	 				</td>
	 				<td>活动排列顺序：</td>
	 				<td><input class="moren"  id="xh" type="text" name="xh"/></td>
	 			</tr>
	 			<tr>
	 				<td>首页显示：</td>
	 				<td>
	 					<select id="show1" name="show1" class="zswz">
	 						<option value="">否</option>
	 						<option value="1">是</option>
	 					</select>
	 				</td>
	 				<td>首页排列顺序：</td>
	 				<td><input class="moren" id="xh1" type="text" name="xh1"/></td>
	 			</tr>
	 			<tr>
	 				<td>首页轮播：</td>
	 				<td>
	 					<select id="homePageHuoDongCarousel" name="homePageHuoDongCarousel" class="zswz">
	 						<option value="">否</option>
	 						<option value="1">是</option>
	 					</select>
	 				</td>
	 				<td>排列顺序：</td>
	 				<td><input class="moren" id="homePageHuoDongCarouselXh" type="text" name="homePageHuoDongCarouselXh"/></td>
	 			 </tr>
	 			 <tr>
	 				<td align="right">图片：</td>
	 				<td>
	 					<input id="pic1" type="file" style="width: 173px;" name="pic1"/>
	 				</td>
	 				<td>正在进行：</td>
	 				<td>
	 					<select id="sfyx" name="sfyx" class="zswz">
	 						<option value="1">是</option>
	 						<option value="0">否</option>
	 					</select>
	 				</td>
	 			 </tr>
	 			<tr>
	 				<td>活动内容：</td>
	 				<td colspan="3">
	 					<textarea id="huoDongContent" class="huodongneirong" name="huoDongContent"></textarea>
	 				</td>
	 			</tr>
			</table> 
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:;" onclick="saveHuoDong()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:;" onclick="closeHuoDongdialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
	<jsp:include page="spkBack.jsp" />

</body>
</html>