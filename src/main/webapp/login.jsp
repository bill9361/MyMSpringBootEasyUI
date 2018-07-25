<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登录</title>
	<!-- 导入EasyUI的资源文件 -->
	<link rel="stylesheet" type="text/css" href="<%=basePath %>static/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>static/js/easyui/themes/icon.css">
	<script type="text/javascript" src="<%=basePath %>static/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>static/js/easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<div id="win"></div>
	<script type="text/javascript">
		$('#win').window({    
		    width:300,    
		    height:200,    
		    modal:true,
		    title:'登录',
		    resizable:false,
		    draggable:false,
		    iconCls:'icon-login'
		}); 
	</script>
</body>
</html>