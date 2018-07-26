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
	<script type="text/javascript" src="<%=basePath %>static/js/jsonHandler.js"></script>
</head>
<body>
	<div id="win">
		<center style="padding-top: 30px;">
			<form id="from_login">
				<p>用户名：<input type="text" name="username" placeholder="用户名"/></p>
				<p>密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" placeholder="密码"/></p>
				<p>
					<a id="btn_login_ok" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="width: 70px;">登录</a>  
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a id="btn_login_cancel" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" style="width: 70px;">取消</a>  
				</p>
			</form>
		</center>
	</div>
	<script type="text/javascript">
		//$(function(){})当页面加载完之后再执行
		$(function(){
			$('#win').window({    
			    width:300,    
			    height:200,    
			    modal:true,
			    title:'登录',
			    resizable:false,
			    draggable:false,
			    collapsible:false,
			    minimizable:false,
			    maximizable:false,
			    closable:false,
			    iconCls:'icon-login'
			}); 
			
			//点击登录按钮
			$("#btn_login_ok").click(function(){
				$.ajax({
					url:'<%=basePath %>login/doLogin.do',
					type:'post',
					dataType:"json",
					data:{
						'username':$("input[name=username]").val(),
						'password':$("input[name=password]").val()
					},
					//不使用contentType: “application/json”则data可以是对象;使用contentType: “application/json”则data只能是json字符串
					//contentType:"application/json",
					success:function(result){
						if(result){
							//重定向
							window.location.href='<%=basePath %>pages/admin/main.jsp';
						}
						else{
							$.messager.alert('提示','登录失败，用户名或密码错误!');    
						}
				    }
				});
			});
		});
		
	</script>
</body>
</html>