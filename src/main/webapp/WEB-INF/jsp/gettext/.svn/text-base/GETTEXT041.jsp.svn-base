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
    <title>用户电子券详细信息</title>
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
			<div id="topCenter">用户电子券详细信息</div>
			<div id="topRight"></div>
		</div>
		<div id="mainBody">

			<!-- <FORM method="post" action="GETTEXT011" name="CommonForm" onsubmit="" target="_blank"> -->
				<div id="mainForm">
				<ul class="singleCol">
					<li class="title"><div class="line"></div></li>
					<li id="mobile_li">
						<div class="hint">存量电子券总金额:<br>拥有电子券总人数:</div>
						<div id="hidden" class="input" style="display:none">
							<input id="cunliang" name="cunliang" type="text"
								onblur="returnNormal(this)"  value=""
								style="border: 0" >元 <input id="count" name="count"
								type="text" onblur="returnNormal(this)" class="formBox" value=""
								style="border: 0" >人
						</div>
						<input type="button" id="SumSave" name="SumSave" style="width:80px;height:30px ;align:middle" class="roundButton" value="查询" >
					</li>
					
					<li>
						<div class="hint">备注：</div>
						<div id="info" class="hintMsg">
							存量电子券金额是指截至目前为止上海发放且有效的电子券的总金额,拥有的人数是指拥有这些有效电子券的人数<br />
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
						class="roundButton" disabled/> 
					<input id="resetImageButton" name="resetImageButton" type="image" src="<%=basePath%>/image/botton_del.jpg" class="roundButton" disabled/> 
					<input type="submit" name="download" id="download" value="下载" height="10" class="roundButton" disabled />
				</div>
				</div>
				<!-- </FORM> -->
			<script type="text/javascript">
</script>
		</div>
	</div>
</body>
<script type='text/javascript'>
	$("#SumSave").click(function() {
		parent.window.errorTipMotalDiv();
		$.ajax({
			url:"<%=basePath%>com/GETTEXT041.action",
			type:"post",
			dataType:"json",
			success:function(data){
				if(data!="null"){
					var sumSave = data.sumSave;
					//alert(data.sumSave);
					parent.window.closeBindDiv();
					$("#cunliang").val(sumSave);
					$("#count").val(data.count);
					$("#hidden").show();
				}else{
					parent.window.closeBindDiv();
					alert("对不起,您所查询的数据为空!");
				}
				
			}
		});
		});
	</script>
</html>