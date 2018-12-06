<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
$(function(){
	var total=0;
	var param={"page":1,"size":10 };
	findList(param);
});

/* 通用膜版 */
function findList(param){
	
	$.post("/fileOpre/list.do",param,function(result){
		total=result.total;
		var str="";
		var list=result.rows;
		$.each(list, function(idx, obj) {
		    str+="<tr>"
		    	+"<th>"+(idx+1)+"</th>"
		    	+"<td>"+obj.name+"</td>"
				+"<td><div class='btn-group' role='group' aria-label='...'><a role='button' class='btn btn-primary btn-xs' href='"+obj.path+"'>下载</a><button style='display:none;' onclick='deleteFile("+obj.id+")' type='button' class='btn btn-danger btn-xs fileDeleteAnniu'>删除</button></div></td>"
				+"</tr>";
		});
		$(".spTbody").html(str);
		if(result.guanliyuan){
			$(".fileDeleteAnniu").show();
			
		}
		fenye(param,total);
	},"json");
}

function fenye(param,total){
	var pageCode=$('#fenyeUl');
	pageCode.empty();
	if(total==0){
		return;
	}
	var pageSize=param.size;//每页显示商品数量
	var totalPage=total%pageSize==0?total/pageSize: Math.floor(total/pageSize)+1;//总页数
	var currentPage=param.page;//当前页数
	var cs=param;
	cs.page=1;
	pageCode.append("<li><a href='javascript:;' onclick=findList("+JSON.stringify(cs)+")>首页</a></li>");
	if(currentPage>1){
		param.page=currentPage-1;
		pageCode.append("<li><a href='javascript:;' onclick=findList("+JSON.stringify(param)+")>上一页</a></li>");			
	} 						
	for(var i=currentPage-4;i<=currentPage+4;i++){
		if(i<1||i>totalPage){
			continue;
		}
		if(i==currentPage){
			pageCode.append("<li class='active'><a>" + i
					+ "</a></li>");	
		}else{
			param.page=i;
			pageCode.append("<li><a href='javascript:;' onclick=findList("+JSON.stringify(param)+") >"+i+"</a></li>");	
		}
	}
	if(currentPage<totalPage){  
		param.page=currentPage+1;
		pageCode.append("<li><a href='javascript:;' onclick=findList("+JSON.stringify(param)+")>下一页</a></li>");		
	}	
	cs.page=totalPage;
	pageCode.append("<li><a href='javascript:;' onclick=findList("+JSON.stringify(cs)+")>尾页</a></li>");
}

function downloadSearch(){
	var searchName= $("#searchIn").val();
	var param={"page":1,"size":10,"searchName":searchName };
	findList(param);
}

function deleteFile(id){
	if(confirm("确定要删除吗？")){
		$.post("/fileOpre/delete.do",{"id":id},function(result){
			if(result.state){
				var param={"page":1,"size":10 };
				findList(param);
				alert(result.msg);
			}else{
				alert("删除失败");
			}
		},"json");
	}
}

</script>
<div style="border: 1px solid #ddd;margin-top: 10px;">
	<div class="input-group downloadSearch">
      <input type="text" onkeydown="if(event.keyCode==13) downloadSearch()" class="form-control" id="searchIn" placeholder="名称">
      <span class="input-group-btn">
        <button class="btn btn-primary" type="button" onclick="downloadSearch()" style="width: 100px;">搜索</button>
      </span>
    </div>
	<table class="table table-hover table-striped table-condensed" >
		<thead>
			<tr>
				<th>序号</th>
				<th>名称</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody class="spTbody">
		</tbody>
	</table>
	<nav aria-label="Page navigation" style="text-align: center;">
	  <ul class="pagination" id="fenyeUl"></ul>
	</nav>
</div>


