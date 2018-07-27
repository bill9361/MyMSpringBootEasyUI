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
	<!-- 汉化 -->
	<script type="text/javascript" src="<%=basePath %>static/js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body class="easyui-layout">   
    <div data-options="region:'north',title:'北',split:true" style="height:100px;background:#ffffff;"></div>   
    <div data-options="region:'south',title:'南',split:true" style="height:100px;background:#ffffff;"></div>   
    <div data-options="region:'west',title:'导航菜单',split:true,iconCls:'icon-world'" style="width:180px;background:#ffffff;">
    	<ul id="tree_nav_menu" class="easyui-tree"></ul>
    </div>   
    <div data-options="region:'center',title:'中',noheader:true" style="padding:5px;background:#ffffff;">
    	<div id="center_tabs" class="easyui-tabs" style="width:500px;height:250px;" data-options="fit:true">   
		    <div title="首页" style="padding:20px;">   
		       	首页  
		    </div>   
		</div>  
    </div>
    
    <script type="text/javascript">
    	//导航菜单
    	$(function(){
    		$('#tree_nav_menu').tree({    
    		    url:'<%=basePath %>navMenu/getNavMenuByParentId.do',
    		    animate:true,
    		    lines:true,
    		 	//在用户点击的时候提示,node是EasyUI框架传过来的
    		    onClick: function(node){
    		    	if(node.href != null && node.href != 'NULL' && typeof(node.href) != "undefined"){
    		    		var isExists = $('#center_tabs').tabs('exists',node.text);
    		    		//如果选项卡还没创建，才创建
    		    		if(!isExists){
    		    			//动态添加选项卡
            		    	$('#center_tabs').tabs('add',{    
            		    	    title:node.text, 
            		    	    iconCls:node.iconCls,
            		    	    closable:true,
            		    	    href:'<%=basePath %>pages/'+node.href
            		    	});  
						}
    		    		//存在，则跳转至存在的选项卡
    		    		else{
    		    			$('#center_tabs').tabs('select',node.text);
    		    		}
    		    	}
    			}
    		});  
    	});
    </script>
</body>  
</html>