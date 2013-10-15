<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=basePath%>css/mstyle.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>css/jquery_ui.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=basePath%>js/admin.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/rules.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery_ui.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/validations.js"></script>
</head>
<body class="loginBody">
<div style="z-index:1; position:absolute">
<table id="bgTable" cellpadding=0 cellspacing=0>
    <tr>
        <td colspan="3" class="denglu1"></td>
    </tr>
    <tr>
        <td class="denglu2"></td>
        <td class="denglu3"></td>
        <td class="denglu4"></td>
    </tr>
</table>
</div>
<div class="bgDiv" style="z-index:2; position:absolute">
    <div id="userLogin">
        <form name="commonForm" action="login.action" method ="post">
        <table class="loginTable">
            <tr>
                <td><input type="text" id="brhId" name="brhId" maxlength="10" class="inputBox" value="2090000000"></td>
            </tr>
            <tr>
                <td><input type="text" id="oprId" name="oprId" maxlength="8" class="inputBox"></td>
            </tr>
            <tr>
                <td><input type="password" id="oprPwd" name="oprPwd" maxlength="6" class="inputBox"><br />
                </td>
            </tr>
            <tr>
                <td>
                    <input id="login" name="login" type="submit" class="submitBt" value="">
                </td>
            </tr>
        </table>
        </form>
    </div>
</div>
<script type="text/javascript">
	$("#login").click(function(){
		if($("#oprId").val() == ""||$("#oprId").val() == null){
            jm("请输入登录柜员号！");
            return false;
        } else if($("#oprPwd").val() == ""||$("#oprPwd").val() == null){
            jm("请输入登录密码！");
            return false;
        } 
        return true;
	});
</script>
        <div id="dialog" title="操作提示" style="display:none;"></div>
    </body>
</html>