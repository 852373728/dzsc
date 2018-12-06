<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品详情</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<script type="text/javascript" src="${pageContext.request.contextPath}/myJs/judgeUser.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.2.min.js"></script> 
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/backStyle.css">
<script type="text/javascript">
	$(function(){
		$.post("spk_getSpkById.action",{spkId:'${param.spkId}'},function(spk){
			$("#spmc").html(spk.spmc);
			$("#spdm").html(spk.spdm);
			$("#nbspdm").html(spk.nbspdm);
			$("#dw").html(spk.dw);
			if(spk.sptplj_800x800==""){
				$("#800x800td").append("<img src='../image/default_100x100.jpg' />");
			}else{
				var pic=spk.sptplj_800x800.split(",");
				pic.pop();
				for(var i=0;i<pic.length;i++){
					var str='<a target="_blank" href="'+pic[i]+'"><img title="点击查看原大小" src="'+pic[i]+'"/></a>';
					$("#800x800td").append(str);
				}
			}
			if(spk.onePic==""){
				$("#onePictd").append("<img src='../image/default_100x100.jpg' />");
			}else{
				var str='<a target="_blank" href="'+spk.onePic+'"><img title="点击查看原大小" src="'+spk.onePic+'"/></a>';
				$("#onePictd").append(str);
			}
			$("#zsl").html(spk.zsl);
			$("#ztsl").html(spk.ztsl);
			$("#splsdj").html(spk.splsdj.toFixed(2));
			$("#cgj").html(spk.cgj.toFixed(2));
			$("#spgg").html(spk.spgg);
			$("#clj").html(spk.clj.toFixed(2));
			$("#zbj").html(spk.zbj.toFixed(2));
			$("#zjj").html(spk.zjj.toFixed(2));
			$("#kxlmj").html(spk.kxlmj.toFixed(2));
			$("#zb").html(spk.zb);
			$("#zj").html(spk.zj);
			$("#kcl").html(spk.kcl);
			$("#yxq").html(spk.yxq);
			$("#ssfw").html(spk.ssfw);
			$("#pzwh").html(spk.pzwh);
			$("#cf").html(spk.cf);
			$("#xz").html(spk.xz);
			$("#gnzz").html(spk.gnzz);
			$("#yfyl").html(spk.yfyl);
			$("#blfy").html(spk.blfy);
			$("#jj").html(spk.jj);
			$("#zysx").html(spk.zysx);
			$("#ywxhzy").html(spk.ywxhzy);
			$("#zc").html(spk.zc);
			$("#bz").html(spk.bz);
			$("#zxbz").html(spk.zxbz);
			$("#xh").html(spk.xh);
			$("#homePageShow").html(spk.homePageShow);
			$("#homePageXhTime").html(spk.homePageXhTime);
			$("#goodsDetailsRight").html(spk.goodsDetailsRight);
			$("#goodsDetailsRightXh").html(spk.goodsDetailsRightXh);
			$("#scyjflb").html(spk.scyjflb.name);
			$("#scejflb").html(spk.scejflb.name);
			$("#djjs").html(spk.sptj.djjs);
			$("#xsjs").html(spk.sptj.xsjs);
			$("#sccj").html(spk.sccj.cjmc);
			$("#spjxb").html(spk.spjxb.name);
			$("#zylxb").html(spk.zylxb.name);
			$("#cflxb").html(spk.cflxb.name);
			$("#yblxb").html(spk.yblxb.name);
		},"json");
	});
</script>
</head>
<body class="backBody">
<table class="tableBack table table-striped">
	<tbody>
		<tr>
			<th>名称：</th>
			<td><span id="spmc"></span></td>
			<th>厂家商品代码：</th>
			<td><span id="spdm"></span></td>
		</tr>
		<tr>
			<th>内部商品代码：</th>
			<td><span id="nbspdm"></span></td>
			<th>商品规格：</th>
			<td><span id="spgg"></span></td>
		</tr>
		<tr>
			<th>一级分类：</th>
			<td><span id="scyjflb"></span></td>
			<th>二级分类：</th>
			<td><span id="scejflb"></span></td>
		</tr>
		<tr>
			<th>点击次数：</th>
			<td><span id="djjs"></span></td>
			<th>销售数量：</th>
			<td><span id="xsjs"></span></td>
		</tr>
		<tr>
			<th>生产厂家：</th>
			<td><span id="sccj"></span></td>
			<th>商品剂型：</th>
			<td><span id="spjxb"></span></td>
		</tr>
		<tr>
			<th>中药类型：</th>
			<td><span id="zylxb"></span></td>
			<th>处方类型：</th>
			<td><span id="cflxb"></span></td>
		</tr>
		<tr>
			<th>医保类型：</th>
			<td><span id="yblxb"></span></td>
			<th>单位：</th>
			<td><span id="dw"></span></td>
		</tr>
		<tr>
			<th>800px*800px：</th>
			<td id="800x800td" ></td>
			<th>特殊图片：</th>
			<td id="onePictd" ></td>
		</tr>
		<tr>
			<th>总数量：</th>
			<td><span id="zsl"></span></td>
			<th>再提数量：</th>
			<td><span id="ztsl"></span></td>
		</tr>
		<tr>
			<th>商品零售单价：</th>
			<td><span id="splsdj"></span></td>
			<th>采购价：</th>
			<td><span id="cgj"></span></td>
		</tr>
		<tr>
			<th>拆零价：</th>
			<td><span id="clj"></span></td>
			<th>中包价：</th>
			<td><span id="zbj"></span></td>
		</tr>
		<tr>
			<th>整件价：</th>
			<td><span id="zjj"></span></td>
			<th>控销联盟价：</th>
			<td><span id="kxlmj"></span></td>
		</tr>
		<tr>
			<th>中包：</th>
			<td><span id="zb"></span></td>
			<th>整件：</th>
			<td><span id="zj"></span></td>
		</tr>
		<tr>
			<th>是否可拆零：</th>
			<td><span id="kcl"></span></td>
			<th>有效期：</th>
			<td><span id="yxq"></span></td>
		</tr>
		<tr>
			<th>所属范围：</th>
			<td><span id="ssfw"></span></td>
			<th>批准文号：</th>
			<td><span id="pzwh"></span></td>
		</tr>
		<tr>
			<th>成分：</th>
			<td><span id="cf"></span></td>
			<th>性状：</th>
			<td><span id="xz"></span></td>
		</tr>
		<tr>
			<th>功能主治：</th>
			<td><span id="gnzz"></span></td>
			<th>用法用量：</th>
			<td><span id="yfyl"></span></td>
		</tr>
		<tr>
			<th>不良反应：</th>
			<td><span id="blfy"></span></td>
			<th>禁忌：</th>
			<td><span id="jj"></span></td>
		</tr>
		 <tr>
			<th>注意事项：</th>
			<td><span id="zysx"></span></td>
			<th>药物相互作用：</th>
			<td><span id="ywxhzy"></span></td>
		</tr> 
		<tr>
			<th>贮藏：</th>
			<td><span id="zc"></span></td>
			<th>包装：</th>
			<td><span id="bz"></span></td>
		</tr>
		<tr>
			<th>执行标准：</th>
			<td><span id="zxbz"></span></td>
			<th>列表排序：</th>
			<td><span id="xh"></span></td>
		</tr>
		<tr>
			<th>首页显示：</th>
			<td><span id="homePageShow"></span></td>
			<th>首页排序：</th>
			<td><span id="homePageXhTime"></span></td>
		</tr>
		<tr>
			<th>热销推荐：</th>
			<td><span id="goodsDetailsRight"></span></td>
			<th>排序：</th>
			<td><span id="goodsDetailsRightXh"></span></td>
		</tr>
	</tbody>
</table>
</body>
</html>