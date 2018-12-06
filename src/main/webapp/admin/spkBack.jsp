<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 该jsp为活动商品和推荐商品的添加商品需要查询商品库的信息而写 -->
<script type="text/javascript">
//下面为spk
function choseGoods(){
	$("#dlg_spk").dialog("open").dialog("setTitle","商品库");
	$('#dg_spk').datagrid({  
	        url: "backSpk/list.do",
	        onDblClickRow:function(index,field,value){
	        	$("#spmc").val(field.spmc);
	        	$("#spkId").val(field.id);
	        	$.post("backSpkLb/getOnebyLbdm.do",{"lbdm":field.web_splbdm},function(result){
	        		goodsType=result;
	        		if($(".hPSC").val()=="1"){
	        			$("#splbMc1").val(result.lbmc);
	        			$("#splbDm").val(result.lbdm);
	        		}else{
	        			$("#splbMc1").val(result.spkLb.lbmc);
	        			$("#splbDm").val(result.spkLb.lbdm);
	        		}
	        	},"json");
	        	$("#dlg_spk").dialog("close");
	    	}
	    });  
}

$(function(){
	$("#spk_yjfl").combobox({
		onSelect:function(record){
			$("#spk_ejfl").combobox("reload","backSpkLb/combobox.do?lbparent="+record.lbdm);
			$("#spk_ejfl").combobox("setValue","");
			$("#dg_spk").datagrid("load",{
				"spmc":$("#searchSpkName").val(),
				"spk_yjfl":record.lbdm,
				"spk_ejfl":$("#spk_ejfl").combobox("getValue")
			});
		}
	});
	$("#spk_ejfl").combobox({
		onSelect:function(record){
			$("#dg_spk").datagrid("load",{
				"spmc":$("#searchSpkName").val(),
				"spk_yjfl":$("#spk_yjfl").combobox("getValue"),
				"spk_ejfl":record.lbdm
			});
		}
	});
});

function searchspk(){
	$("#dg_spk").datagrid("load",{
		"spmc":$("#searchSpkName").val(),
		"spk_yjfl":$("#spk_yjfl").combobox("getValue"),
		"spk_ejfl":$("#spk_ejfl").combobox("getValue")
	});
}

function closeSpkDialog(){
	$("#dlg_spk").dialog("close");
}

function determineSp(){
	var selectedRows=$("#dg_spk").datagrid('getSelections');
	if(selectedRows.length!=1){
		$.messager.alert("系统提示","请选择一个要添加的商品！");
		return;
	}
	var row=selectedRows[0];
	$("#spmc").val(row.spmc);
	$("#spkId").val(row.id);
	$.post("backSpkLb/getOnebyLbdm.do",{"lbdm":row.web_splbdm},function(result){
		goodsType=result;
		if($(".hPSC").val()=="1"){
			$("#splbMc1").val(result.lbmc);
			$("#splbDm").val(result.lbdm);
		}else{
			$("#splbMc1").val(result.spkLb.lbmc);
			$("#splbDm").val(result.spkLb.lbdm);
		}
	},"json");
	$("#dlg_spk").dialog("close");
}
</script>
<div id="dlg_spk" class="easyui-dialog" style="width: 1000px;height: 100%"
 closed="true" buttons="#dlg-buttons_spk">
	<table id="dg_spk" class="easyui-datagrid"
	 fitColumns="true" pagination="true" rownumbers="true"
	 fit="true" data-options="singleSelect:true" toolbar="#tb_spk">
	 <thead>
	 	<tr>
	 		<th field="spmc" width="30" align="center">商品名称</th>
	 		<th field="spdm" width="20" align="center">厂家商品代码</th>
	 		<th field="zjm" width="20" align="center">助记码</th>
	 		<th field="SCCJ1" width="50" align="center">生产企业</th>
	 	</tr>
	 </thead>
	</table>
	<div id="tb_spk">
		<div style="margin-top: 5px;">
			&nbsp;名称:&nbsp;<input type="text" id="searchSpkName" size="20" onkeydown="if(event.keyCode==13) searchspk()"/> 
			&nbsp;一级分类:&nbsp;<input id="spk_yjfl" class="easyui-combobox" data-options="panelHeight:'auto',editable:false,valueField:'lbdm',textField:'lbmc',url:'backSpkLb/combobox.do?cjbz=1'"/>
			&nbsp;二级分类:&nbsp;<input id="spk_ejfl" class="easyui-combobox" data-options="panelHeight:'300px',editable:false,valueField:'lbdm',textField:'lbmc',url:'backSpkLb/combobox.do'"/>
			<a href="javascript:;" onclick="searchspk()" class="easyui-linkbutton" iconCls="icon-search" style="vertical-align: top;">搜索</a>
		</div> 
	</div>
</div>
<div id="dlg-buttons_spk">
	<a href="javascript:;" onclick="determineSp()" class="easyui-linkbutton" iconCls="icon-ok">确定</a>
	<a href="javascript:;" onclick="closeSpkDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>
