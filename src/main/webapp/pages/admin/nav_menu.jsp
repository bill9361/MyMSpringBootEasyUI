<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>菜单管理</title>
</head>
<body>
	<!-- 数据表格 -->
	<table id="menu_dg"></table>
	<!-- 添加菜单 -->
	<div id="menu_add">
		<center style="padding-top: 20px;">
			<form id="from_menu_add">
				<p>名称：<input type="text" name="name" placeholder="菜单名称" style="width: 180px"/></p>
				<p>状态：
					<select name="state" style="width: 185px">
						<option value="open">展开</option>
						<option value="closed" selected="selected">关闭</option>
					</select>
				</p>
				<p>图标：<input type="text" name="iconCls" placeholder="菜单图标" style="width: 180px"/></p>
				<p>链接：<input type="text" name="href" placeholder="菜单链接" style="width: 180px"/></p>
				<p>父级：
					<select name="parentId" style="width: 185px">
						<option value="0" selected="selected">无</option>
					</select>
				</p>
				<p>
					<!-- javascript:void(0)用户点击以后不会发生任何事 -->
					<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="width: 70px" id="btn_menu_add_ok">确定</a>
					&nbsp;&nbsp;&nbsp;
					<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" style="width: 70px" id="btn_menu_add_cancel">取消</a>
				</p>
			</form>
		</center>
	</div>  
	<script type="text/javascript">
		$('#menu_dg').datagrid({    
		    url:'<%=basePath %>navMenu/getNavMenu.do',    
		    //控制表头
		    columns:[[    
		        {checkbox:true},//复选框
		        {field:'id',title:'ID',width:260,align:'center'},    
		        {field:'text',title:'名称',width:150,align:'center',
		        	formatter: function(value,row,index){
		        		//如果是一级菜单，则显示红色
		        		if(row.parentId == "0"){
		        			return "<span style='color:red;'>"+value+"</span>";
		        		}
		        		else{
		        			return value;
		        		}
		        	}},    
		        {field:'state',title:'展开状态',width:100,align:'center',
		        	formatter: function(value,row,index){
		        		if(value == "open"){
		        			return "展开";
		        		}
		        		else if(value == "closed"){
		        			return "关闭";
		        		}
		        	}},    
		        {field:'iconCls',title:'图标',width:100,align:'center'},    
		        {field:'parentId',title:'父级Id',width:260,align:'center'},    
		        {field:'href',title:'链接',width:260,align:'center',
		        	formatter: function(value,row,index){
		        		if(value == null || value == "NULL" || typeof(value) == "undefined"){
		        			return "无链接";
		        		}
		        		else{
		        			return value;
		        		}
		        	}}    
		    ]],
		    pagination:true,  //分页
		    fit:true,  //将表格自适应父容器，表格会自动扩大到父容器最大范围，这样，分页空间就会被固定到最底部
		    toolbar: [{
				iconCls: 'icon-add',
				text:"添加菜单",
				handler: function(){
					//添加菜单窗口
					$('#menu_add').window({  
						title:'添加菜单',
						iconCls:'icon-add',
					    width:350,    
					    height:300,    
					    modal:true,
					    resizable:false,
					    collapsible:false
					});
				}
			},'-',{
				iconCls: 'icon-edit',
				text:"修改菜单",
				handler: function(){alert('修改菜单')}
			},'-',{
				iconCls: 'icon-remove',
				text:"删除菜单",
				handler: function(){alert('删除菜单')}
			}]
		}); 
		
		//点击添加菜单的确定按钮
		$("#btn_menu_add_ok").click(function(){
			var aa = $("#from_menu_add").serializeObject();
			alert(aa);
			<%-- $.ajax({
				url:'<%=basePath %>navMenu/addNavMenu.do',
				type:'post',
				data:$("#from_menu_add").serializeObject(),
				dataType:'json',
				contentType:'application/json',
				success:function(result){
					alert(result);
				}
			}); --%>
		});
		//点击添加菜单的取消按钮
		$("#btn_menu_add_cancel").click(function(){
			//关闭添加菜单窗口
			$('#menu_add').window('close',true);
		});
		 
	</script>
</body>
</html>