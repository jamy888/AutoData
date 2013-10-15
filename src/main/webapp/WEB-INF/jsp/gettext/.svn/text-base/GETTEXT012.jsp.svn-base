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
    <title>纯电子券消费数据</title>
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
    <script LANGUAGE="JAVASCRIPT">
	function confirm2(form) {
			return true;
		}
	</script>
    </head>
    <body>
    <div id="mainIndex">
        <div id="mainTop"><div id="topLeft"></div><div id="topCenter">消费电子券前列的商户数据</div><div id="topRight"></div></div>
        <div id="mainBody">
        <form id="downloadXLS" method="post" >
			<input type="hidden" id="filename" name="filename" value="${filename }" />
		</form>
			<!-- <FORM id="CommonForm" name='CommonForm' target='_self'> -->
				<div id="mainForm">
					<ul class="singleCol">
						<li class="title"><div class="line"></div></li>
						<li id="begDt_li">
							<div class="hint">交易开始日期：</div>
							<div class="input" style="">
								<input id="begDt" name="begDt" type="text" onfocus="showTip(this)" onkeydown="checkChange(this)"
									onblur="returnNormal(this)" class="formBox" value="" size="" maxlength="8" />
							</div>
							<div class="info" style="">
								<div id="begDt_m" class="hintMsg">请输入交易开始日期</div>
							</div>
						</li>
						<li id="endDt_li">
							<div class="hint">交易结束日期：</div>
							<div class="input" style="">
								<input id="endDt" name="endDt" type="text" onfocus="showTip(this)" onkeydown="checkChange(this)"
									onblur="returnNormal(this)" class="formBox" value="" size="" maxlength="8" />
							</div>
							<div class="info" style="">
								<div id="endDt_m" class="hintMsg">请输入交易结束日期</div>
							</div>
						</li>
						<li id="roeNum_li">
							<!-- <div class="hint">提取的商户数：</div>
							<div class="input" style="">
								<input id="rowNum" name="rowNum" type="text" onfocus="showTip(this)" onkeydown="checkChange(this)"
									onblur="returnNormal(this)" class="formBox" value="" size="" maxlength="" />
							</div> -->
							<div class="hint">提取的商户数：</div>
							<div class="input" style="">
							<select id="rowNum" name="rowNum" class="singleSelect"
								style="width: 155px" onchange="" onfocus="showTip(this)"
								onkeydown="checkChange(this)" onblur="returnNormal(this)">
								<option value="">请选择提取商户数......</option>
								<option value="5">5</option>
								<option value="10">10</option>
								<option value="15">15</option>
								<option value="20">20</option>
								<option value="25">25</option>
								<option value="30">30</option>
								<option value="35">35</option>
								<option value="40">40</option>
								<option value="45">45</option>
								<option value="50">50</option>
							</select>
						</div>
							<div class="info" style="">
								<div id="rowNum_m" class="hintMsg">请输入需要提取的商户数</div>
							</div>
						</li>
						<li>
							<div class="hint">备注：</div>
							<div id="info" class="hintMsg">
								提取消费电子券金额前列的消费数据，包括商户编号，商户名，期间电子券消费总金额，现金消费总金额。
								输入时间格式为YYYYMMDD<br />
							</div>
						</li>
					</ul>
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
					<input id="submitImageButton" name="submitImageButton" type="image" src="<%=basePath%>/image/botton_submit.jpg" class="roundButton" /> 
					<input id="resetImageButton" name="resetImageButton" type="image" src="<%=basePath%>/image/botton_del.jpg" class="roundButton" /> 
					<input type="submit" name="download" id="download" value="下载" height="10" disabled />
					</div>
				</div>
			<!-- </FORM> -->
        </div>
    </div>
    <div id="dialog" title="操作提示" style="display:none;"></div>
<script type='text/javascript'>
	var filename=null;
	$("#submitImageButton").click(function() {
		var begDt = $("#begDt").val();
		var endDt = $("#endDt").val();
		var rowNum =$("#rowNum").val();
		if(begDt==""||begDt==null||endDt==""||endDt==null||rowNum==""||rowNum==null){
			alert("输入有空值,请检查您的输入值!!");
			return false;
		}
		//alert("起始时间为"+begDt+"  截至时间为"+endDt);
		parent.window.errorTipMotalDiv();
		$.ajax({
			/* url:"<%=basePath%>cmt/GETTEXT011", */
			url:"<%=basePath%>com/GETTEXT012",
			type:"post",
			data:{
				begDt:begDt,
				endDt:endDt,
				rowNum:rowNum
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
		$("#begDt").val("");
		$("#endDt").val("");
		$("#rowNum").val("");
		$("#begDt").focus();
	});
	</script>
	<script type="text/javascript">
	$("#download").click(function() {
		//alert($("#filename").val());
		$("#downloadXLS").attr("action","<%=basePath%>com/download");
		$("#downloadXLS").submit();
		$("#downloadXLS").attr("action","<%=basePath%>com/deleteFile");
		$("#downloadXLS").submit();
	});
	</script>
    </body>
</html>