<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>后台</title>
	<!-- 导入EasyUI的资源文件 -->
	<link rel="stylesheet" type="text/css" href="<%=basePath %>static/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>static/js/easyui/themes/icon.css">
	<script type="text/javascript" src="<%=basePath %>static/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>static/js/easyui/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">   
    <div data-options="region:'north',title:'北',split:true" style="height:100px;"></div>   
    <div data-options="region:'south',title:'南',split:true" style="height:100px;"></div>   
    <div data-options="region:'west',title:'导航栏',split:true,iconCls:'icon-world'" style="width:180px;">
    	<ul id="tree_nav_menu" class="easyui-tree">
    	
    	</ul>
    </div>   
    <div data-options="region:'center',title:'中'" style="padding:5px;background:#eee;"></div>
    
    <script type="text/javascript">
    	$(function(){
    		$('#tree_nav_menu').tree({    
    		    url:'tree_data.json'   
    		});  
    	});
    </script>
</body>  
</html>