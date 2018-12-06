<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
$(function(){
	list({});
});
function Search(){
	var searchIn=$("#searchIn").val();
	var param={"searchName":searchIn};
	list(param);
}

function list(param){
	$.post("/historyGoods/list.do",param,function(result){
		var hgList=result.hgList;
		var str='';
		for(var i in hgList){
			str+='<tr class="qxsh_tr">'
			+'<th>'+(parseInt(i)+1)+'</th>'	
			+'<td><a class="shouc_a" target="_blank" href="/goodsDetails.html?id='+hgList[i].id+'">'+hgList[i].spmc+'</a></td>'
			+'<td>'+hgList[i].spdm+'</td>'
			+'<td>'+hgList[i].sccj1+'</td>'
			+'<td>'+hgList[i].buyNum+hgList[i].dw+'</td>'
			+'</tr>';
		}
		$('.historyGoodsBody').html(str);
	},"json");
}
</script> 
<div class="margin_top10">
	<div class="input-group" style="margin: 20px auto;width: 400px;">
      <input type="text" onkeydown="if(event.keyCode==13) Search()" class="form-control" id="searchIn" placeholder="名称">
      <span class="input-group-btn">
        <button class="btn btn-primary" type="button" onclick="Search()" style="width: 100px;">搜索</button>
      </span>
    </div>
	<table class="table table-hover table-striped ddtable" >
		<thead>
			<tr>
				<th>序号</th>
				<th>商品名称</th>
				<th>商品代码</th>
				<th>生产厂家</th>
				<th>总购买数量</th>
			</tr>
		</thead>
		<tbody class="historyGoodsBody">
		</tbody>
	</table>
</div>
