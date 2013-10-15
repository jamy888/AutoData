<%@ page import="java.util.List;"%>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html xmlns="http://www.w3.org/1999/xhtml"> -->
<html>
    <head>
    <title>手机支付历史交易记录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <meta http-equiv="pragma" content="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate,text/html; charset=ISO-8859-1">
    <META HTTP-EQUIV="expires" CONTENT="0">
    <link href="<%=basePath%>css/mstyle.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>css/jquery_ui.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=basePath%>js/admin.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/rules.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery_ui.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/validations.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){
        ;
    });
    </script>
    </head>
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
<body>
	
	<div id="mainIndex">
		<div id="mainTop">
			<div id="topLeft"></div>
			<div id="topCenter">手机支付历史交易记录</div>
			<div id="topRight"></div>
		</div>
		<div id="mainBody">

				<div id="mainForm">
				<ul class="singleCol">
					<li class="title"><div class="line"></div></li>
					<li id="wallet_li">
						<div class="hint">是否已开通钱包账户：</div>
						<div class="input" style="">
							<select id="wallet" name="wallet" class="singleSelect"
								style="width: 155px" onchange="" onfocus="showTip(this)"
								onkeydown="checkChange(this)" onblur="returnNormal(this)">
								<option value="">请选择...</option>
								<option value="01">是</option>
								<option value="02">否</option>
								<option value="03">不限</option>
							</select>
						</div>
						<div class="info" style="">
							<div id="wallet_m" class="hintMsg">请选择是否已开通钱包账户</div>
						</div>
					</li>
					<li id="begDt_li">
						<div class="hint">交易起始日期：</div>
						<div class="input" style="">
							<input id="begDt" name="begDt" type="text"
								onfocus="showTip(this)" onkeydown="checkChange(this)"
								onblur="returnNormal(this)" class="formBox" value="" size=""
								maxlength="8" />
						</div>
						<div class="info" style="">
							<div id="begDt_m" class="hintMsg">请输入起始日期</div>
						</div>
					</li>
					<li id="endDt_li">
						<div class="hint">交易结束日期：</div>
						<div class="input" style="">
							<input id="endDt" name="endDt" type="text"
								onfocus="showTip(this)" onkeydown="checkChange(this)"
								onblur="returnNormal(this)" class="formBox" value="" size=""
								maxlength="8" />
						</div>
						<div class="info" style="">
							<div id="endDt_m" class="hintMsg">请输入结束日期</div>
						</div>
					</li>
					<li>
						<div class="hint">备注：</div>
						<div id="info" class="hintMsg">
							手机支付历史交易记录中用户必须开通手支付账户，提取字段包括手机号码，交易时间，交易金额，交易类型，注册时间。 
							输入时间格式为YYYYMMDD <br />
						</div>
						<div></div>
					</li>

				</ul>
				<form id="downloadXLS" method="post" >
		<input type="hidden" id="filename" name="filename" value="${filename }" />
		<input type="hidden" id="dir" name="dir" value="${dir }" />
	</form>
					<div id="submitButton">
					<input type="hidden" id="backUrl" name="backUrl" value="" /> 
					<input type="hidden" name="randomCode" id="randomCode" value="Dn4e1TEa" /> 
					<input id="submitImageButton" name="submitImageButton" type="image" src="<%=basePath%>/image/botton_submit.jpg"
						class="roundButton" /> 
					<input id="resetImageButton" name="resetImageButton" type="image" src="<%=basePath%>/image/botton_del.jpg" class="roundButton" /> 
					<input type="submit" name="download" id="download" value="下载" height="10" disabled />
				</div>
				</div>
		</div>
	</div>
</body>
<script type='text/javascript'>
	var filename=null;
	var dir=null;
	$("#submitImageButton").click(function() {
		var wallet = $("#wallet").val();
		var begDt = $("#begDt").val();
		var endDt = $("#endDt").val();
		if(wallet==""||wallet==null){
			alert("请选择是否已开通钱包账户！");
			return false;
		}
		if(begDt==""||begDt==null||endDt==""||endDt==null){
			alert("输入过期时间有空值,请检查您的输入值!!");
			return false;
		}
		//alert("起始时间为"+begDt+"  截至时间为"+endDt);
		parent.window.errorTipMotalDiv();
		$.ajax({
			url:"<%=basePath%>com/GETTEXT115.action",
			type:"post",
			data:{
				wallet:wallet,
				begDt:begDt,
				endDt:endDt							
			},
			dataType:"json",
			success:function(data){
				if(data.fileName!="null"){
					//alert(data.fileName);
					parent.window.closeBindDiv();
					alert("操作成功，可以点击下载您需要的文件了!");
					filename = data.fileName;
					$("#submitImageButton").attr("disabled","true");
					$("#filename").val(filename);
					//alert($("#filename").val());
					$("#download").removeAttr("disabled");
				}else{
					parent.window.closeBindDiv();
					alert("对不起,您所查询的数据为空!");
				}
				
			}
		});
		});
	</script>
	<script type="text/javascript">
	$("#resetImageButton").click(function(){
		$("#wallet").val("");
		$("#begDt").val("");
		$("#endDt").val("");
		//$("#begDt").focus();
	});
	</script>
	<script type="text/javascript">
	$("#download").click(function() {
		//alert($("#filename").val());
		$("#downloadXLS").attr("action","<%=basePath%>com/download");
		$("#downloadXLS").submit();<%-- 
		$("#downloadXLS").attr("action","<%=basePath%>com/deleteFile");
		$("#downloadXLS").submit(); --%>
	});
	</script>
</html>
