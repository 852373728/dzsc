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
<title>主页</title>
<script type="text/javascript">


function refreshSystem(){
	$.post("refresh.do",{},function(result){
		if(result.state){
			$.messager.alert("系统提示",result.msg);
		}else{
			$.messager.alert("系统提示","缓存刷新失败，请联系管理员！");
		}
	},"json");
}

$(document).ready(function() {
	// 监听右键事件，创建右键菜单
    $('#tabs').tabs({
        onContextMenu:function(e, title,index){
            e.preventDefault();
            if(index>=0){
                $('#menu').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                }).data("tabTitle", title);
            }
        }
    });
	
	 // 右键菜单click
    $("#menu").menu({
        onClick : function (item) {
            closeTab(this, item.name);
        }
    });
	 
    function closeTab(menu, type) {
        var allTabs = $("#tabs").tabs('tabs');
        var allTabtitle = [];
        $.each(allTabs, function (i, n) {
            var opt = $(n).panel('options');
            if (opt.closable)
                allTabtitle.push(opt.title);
        });
        var curTabTitle = $(menu).data("tabTitle");
        var curTabIndex = $("#tabs").tabs("getTabIndex", $("#tabs").tabs("getTab", curTabTitle));
        switch (type) {
       		case 1: // 刷新当前标签页
	            var panel = $("#tabs").tabs("getTab", curTabTitle).panel("refresh");
	            break;
            case 2: // 关闭当前标签页
                $("#tabs").tabs("close", curTabIndex);
                return false;
                break;
            case 3: // 关闭全部标签页
                for (var i = 0; i < allTabtitle.length; i++) {
                    $('#tabs').tabs('close', allTabtitle[i]);
                }
                break;
            case 4: // 关闭其他标签页
                for (var i = 0; i < allTabtitle.length; i++) {
                    if (curTabTitle != allTabtitle[i])
                        $('#tabs').tabs('close', allTabtitle[i]);
                }
                $('#tabs').tabs('select', curTabTitle);
                break;
            case 5: // 关闭右侧标签页
                for (var i = curTabIndex+1; i < allTabtitle.length; i++) {
                    $('#tabs').tabs('close', allTabtitle[i]);
                }
                $('#tabs').tabs('select', curTabTitle);
                break;
            case 6: // 关闭左侧标签页
                for (var i = 0; i < curTabIndex; i++) {
                    $('#tabs').tabs('close', allTabtitle[i]);
                }
                $('#tabs').tabs('select', curTabTitle);
                break;
        }
    }
});




function openTab(text,url,iconCls){
	if($('#tabs').tabs("exists",text)){
		$('#tabs').tabs("select",text);
	}else{
		var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/admin/"+url+"'></iframe>";
		$('#tabs').tabs("add",{
			title:text,
			iconCls:iconCls,
			closable:true,
			content:content
		});
	}
}
</script>
</head>
<body class="easyui-layout">
	<div region="north" style="height: 30px;background-color: #E0ECFF;text-align: center;">
		<font size="3" style="line-height: 30px;">
			<strong>当前用户：</strong><span id="username1">${administrator.userName}</span>
		</font>
	</div>
	<div region="center">
		<div id="tabs" class="easyui-tabs" fit="true" border="false"></div>
	</div>
	<div data-options="region:'west'" style="width: 200px;"  title="导航菜单" split="true">
		<div class="easyui-accordion" data-options="fit:true,border:false">
			<!-- <div title="用户管理" data-options="iconCls:'icon-user'" style="padding: 10px;">
				<a href="javascript:openTab('用户管理','userManager.jsp','icon-user')" class="twoBtn easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'">管理用户</a>
			</div> -->
			<div title="推荐和活动专区" data-options="selected:true,iconCls:'icon-manage'" style="padding: 10px;">
				<a href="javascript:openTab('推荐与活动二级分类','backTwobar.jsp','icon-manage')" class="twoBtn easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'">推荐与活动二级分类</a>
				<a href="javascript:openTab('推荐品种','backTuiJian.jsp','icon-manage')" class="twoBtn easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'">推荐品种</a>
				<a href="javascript:openTab('活动商品','backHongDong.jsp','icon-manage')" class="twoBtn easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'">活动商品</a>
			</div>
			<div title="轮播热点" data-options="iconCls:'icon-manage'" style="padding: 10px;">
				<a href="javascript:openTab('轮播热点','backMainShow.jsp','icon-manage')" class="twoBtn easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'">轮播热点</a>
			</div>
			<div title="系统管理" data-options="iconCls:'icon-manage'" style="padding: 10px;">
				<a href="javascript:;" onclick="refreshSystem()" class="twoBtn easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'">刷新缓存</a>
				<a href="javascript:openTab('碎片','suipian.jsp','icon-manage')" class="twoBtn easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'">碎片</a>
			</div>
		</div>
	</div>
<div id="menu" class="easyui-menu" >
    <div id="mm-tabrefresh" data-options="name:1,iconCls:'icon-refresh'"> 刷新当前标签页</div>
    <div class="menu-sep"></div>
    <div id="mm-tabclose" data-options="name:2,iconCls:'icon-closetab'">关闭当前标签页</div>
    <div id="mm-tabcloseall" data-options="name:3,iconCls:'icon-closealltab'">关闭全部标签页</div>
    <div id="mm-tabcloseother" data-options="name:4,iconCls:'icon-closeothertab'">关闭其他标签页</div>
    <div id="mm-tabcloseright" data-options="name:5,iconCls:'icon-closerighttab'">关闭右侧标签页</div>
    <div id="mm-tabcloseleft" data-options="name:6,iconCls:'icon-closelefttab'">关闭左侧标签页</div>
 </div>
</body>
</html>