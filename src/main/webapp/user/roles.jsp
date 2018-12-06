<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<script src="${pageContext.request.contextPath}/bootstrap3/bootstrap3Tree/bootstrap-treeview.min.js"></script>
<script type="text/javascript">
	var roleName="";
	function modifyPermission(name){
		roleName=name;
		$.post("/userCenter/allPermissions.do",{name:name},function(result){
			var list= result.list;
			$('#tree').treeview({
				data: list,
				showCheckbox:true,
				highlightSelected:false,
				onNodeChecked:function(event,node){
					if(node.selectable==false){
						var nodes=node.nodes;
						for(var i in nodes){
							$('#tree').treeview('checkNode', [ nodes[i].nodeId, { silent:true } ]);
							nodes[i].state.checked=true;
						}
					}else{
						var paNode= $('#tree').treeview('getParent', node);
						$('#tree').treeview('checkNode', [ paNode.nodeId, { silent:true } ]);
					}
				},
				onNodeUnchecked:function(event,node){
					if(node.selectable==false){
						var nodes=node.nodes;
						for(var i in nodes){
							$('#tree').treeview('uncheckNode', [ nodes[i].nodeId, { silent:true} ]);
							nodes[i].state.checked=false;
						}
					}else{
						 var siblings = $('#tree').treeview('getSiblings', node.nodeId);
						 var flag=false;
						 for(var i in siblings){
							 if(siblings[i].state.checked==true){
								 flag=true;
							 }
						 }
						 if(flag==false){
							 var paNode= $('#tree').treeview('getParent', node);
							 $('#tree').treeview('uncheckNode', [ paNode.nodeId, { silent:true } ]);
						 }
					}
					
				}
			});
		},"json");
		$(".qxgl").css("display","block");
	}
	
	function ddsz(){
		var checkNodesArray=$('#tree').treeview('getChecked');
		var obj=[];
		for(var i in checkNodesArray){
			obj.push(checkNodesArray[i].id);
		}
		var str=obj.join(",");
		$.post("/rolePermission/selectPermission.do",{"str":str,"roleName":roleName},function(result){
			if(result.status){
				alert(result.msg);
			}else{
				alert(result.msg);
			}
			$(".qxgl").css("display","none");
		},"json");
	}
	
	function qxsz(){
		$(".qxgl").css("display","none");
	}
	
</script>
<style type="text/css">
	.treeview .list-group .list-group-item.node-checked{
		color: #337ab7;
	}
</style>
	<div style="border: 1px solid #ddd;margin-top: 10px;position: relative;">
		<table class="table table-hover table-striped " >
			<thead>
				<tr>
					<th>角色名称</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${rolesList }" var="roles">
				<tr>
					<td>${roles.name }</td>
					<td><button type="button" onclick="modifyPermission('${roles.name }')" class="btn btn-primary btn-sm">修改权限</button></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="qxgl"  >
			<div style="text-align: center;margin:10px">
				<button type="button" onclick="ddsz()" class="btn btn-primary">确定</button>&nbsp;
				<button type="button" onclick="qxsz()" class="btn btn-primary">取消</button>
			</div>
			<div id="tree"></div>
		</div>
	</div>
