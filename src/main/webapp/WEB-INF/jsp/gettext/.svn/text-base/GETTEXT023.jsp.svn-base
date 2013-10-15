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
<html >
    <head>
    <title>电子券到期明细数据</title>
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
    <%-- <script type="text/javascript" src="<%=basePath%>js/validations.js"></script> --%>
    <script type="text/javascript">
    $(document).ready(function(){
        ;
    });
    </script>
    <script LANGUAGE="JAVASCRIPT">
	function confirm2(form) {
			return true;
		}
	</script>
    </head>
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
<body>
	
	<div id="mainIndex">
		<div id="mainTop">
			<div id="topLeft"></div>
			<div id="topCenter">用户使用电子券情况</div>
			<div id="topRight"></div>
		</div>
		<div id="mainBody">

			<!-- <FORM method="post" action="GETTEXT011" name="CommonForm" onsubmit="" target="_blank"> -->
				<div id="mainForm">
				<ul class="singleCol">
					<li class="title"><div class="line"></div></li>
					<li id="useFlag_li">
							<div class="hint">是否使用过电子券：</div>
							<div class="input" style="">
							<select id="useFlag" name="useFlag" class="singleSelect"
								style="width: 155px" onchange="" onfocus="showTip(this)"
								onkeydown="checkChange(this)" onblur="returnNormal(this)">
								<option value="">请选择使用情况......</option>
								<option value="01">使用过</option>
								<option value="02">没有使用过</option>
							</select>
						</div>
							<div class="info" style="">
								<div id="useFlag_m" class="hintMsg">请选择使用情况</div>
							</div>
						</li>
					<li>
						<div class="hint">备注：</div>
						<div id="info" class="hintMsg">
							<textarea rows="6" cols="60" readonly
								style="height: 111px; width: 588px; color: black; overflow-y: hidden; border: 0; resize: none;"
								disabled="disabled">1.用户使用过电子券信息明细是指从2011年9月1日开始到现在所有赠送过手机支付电子券的上海移动用户使用过且最后一次使用电子券情况，包括用户手机号码，最后一次使用时间、使用金额，是否有过转赠转让行为。2.用户没有使用过电子券信息明细是指2011年9月1日开始到现在所有赠送过手机支付电子券的上海移动用户没有使用过电子券的情况，包括用户号码，下发给用户总的电子券金额。3.其中，把积分兑换所兑换的电子券排除在外。</textarea>
						</div>
						<div></div>
					</li>

				</ul>
				<form id="downloadXLS" method="post" >
		<input type="hidden" id="filename" name="filename" value="${filename }" />
	</form>
					<div id="submitButton">
						<SCRIPT LANGUAGE="JAVASCRIPT">
							function confirm2(form) {
								if (validateForm(form)) {
									return true;
								}
								return false;
							}
						</SCRIPT>
					<input type="hidden" id="backUrl" name="backUrl" value="" /> 
					<input type="hidden" name="randomCode" id="randomCode" value="Dn4e1TEa" /> 
					<input id="submitImageButton" name="submitImageButton" type="image" src="<%=basePath%>/image/botton_submit.jpg"
						class="roundButton" /> 
					<input id="resetImageButton" name="resetImageButton" type="image" src="<%=basePath%>/image/botton_del.jpg" class="roundButton" /> 
					<input type="submit" name="download" id="download" value="下载" height="10" disabled />
				</div>
				</div>
				<!-- </FORM> -->
			<script type="text/javascript">
</script>
		</div>
	</div>
</body>
<script type='text/javascript'>
	var filename=null;
	$("#submitImageButton").click(function() {
		var useFlag = $("#useFlag").val();
		if(useFlag==""||useFlag==null){
			alert("请选择用户是否使用过电子券");
			return false;
		}
		//alert("起始时间为"+begDt+"  截至时间为"+endDt);
		parent.window.errorTipMotalDiv();
		$.ajax({
			url:"<%=basePath%>com/GETTEXT023.action",
			type:"post",
			data:{
				useFlag:useFlag,							
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
					alert($("#filename").val());
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
		$("#useFlag").val("");
		//$("#begDt").focus();
	});
	</script>
	<script type="text/javascript">
	$("#download").click(function() {
		//alert($("#filename").val());
		$("#downloadXLS").attr("action","<%=basePath%>com/download");
		$("#downloadXLS").submit();
		<%-- $("#downloadXLS").attr("action","<%=basePath%>com/deleteFile");
		$("#downloadXLS").submit(); --%>
	});
	</script>
</html>
