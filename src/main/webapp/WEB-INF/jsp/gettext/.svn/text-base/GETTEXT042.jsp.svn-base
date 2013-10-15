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
			<div id="topCenter">电子券到期明细数据</div>
			<div id="topRight"></div>
		</div>
		<div id="mainBody">

			<!-- <FORM method="post" action="GETTEXT011" name="CommonForm" onsubmit="" target="_blank"> -->
				<div id="mainForm">
				<ul class="singleCol">
					<li class="title"><div class="line"></div></li>
					<li id="getOrUse_li">
						<div class="hint">发放/使用电子券总金额：</div>
						<div class="input" style="">
							<select id="getOrUse" name="getOrUse" class="singleSelect"
								style="width: 155px" onchange="" onfocus="showTip(this)"
								onkeydown="checkChange(this)" onblur="returnNormal(this)">
								<option value="">请选择...</option>
								<option value="01">发放</option>
								<option value="02">使用</option>
							</select>
						</div>
						<div class="info" style="">
							<div id="getOrUse_m" class="hintMsg">请选择发放/使用电子券总金额</div>
						</div>
					</li>
					<li id="begDt_li">
						<div class="hint">发放/使用起始日期：</div>
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
						<div class="hint">发放/使用结束日期：</div>
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
							发放电子券总金额是指上海移动一段时间内发放总的电子券总金额，使用电子券总金额是指用户使用上海移动发放的总金额，字段均包括时间（月），总金额。输入时间格式为YYYYMMDD <br />
						</div>
						<div></div>
					</li>

				</ul>
				<form id="downloadXLS" method="post">
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
		var getOrUse = $("#getOrUse").val();
		var begDt = $("#begDt").val();
		var endDt = $("#endDt").val();
		if(getOrUse==""||getOrUse==null){
			alert("请选择发放/使用电子券总金额！");
			return false;
		}
		if(begDt==""||begDt==null||endDt==""||endDt==null){
			alert("输入过期时间有空值,请检查您的输入值!!");
			return false;
		}
		//alert("起始时间为"+begDt+"  截至时间为"+endDt);
		parent.window.errorTipMotalDiv();
		$.ajax({
			url:"<%=basePath%>com/GETTEXT042.action",
			type:"post",
			data:{
				getOrUse:getOrUse,
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
		$("#getOrUse").val("");
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
