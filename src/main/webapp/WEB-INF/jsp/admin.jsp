<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List;"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>POSP管理控制台</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META HTTP-EQUIV="pragma" CONTENT="no-cache"><META HTTP-EQUIV="expires" CONTENT="0">
    <link href="<%=basePath%>css/mstyle.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>css/jquery_ui.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>css/motalDiv.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=basePath%>js/admin.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery_ui.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/motalDiv.js"></script> 
    <script type="text/javascript">
        $(document).ready(function(){
            $("#tabs").tabs();
            $("a.menu").click(function() {
                $(".subMenu").not($(this).parent().next(".subMenu")).slideUp("fast");
                $(this).parent().next(".subMenu").slideToggle("fast");
            });
            $("a.menu2").click(function() {
            	$(".subMenu2").not($(this).parent().next(".subMenu2")).hide();
                $(this).parent().next(".subMenu2").slideToggle("fast");
            });
            /*
            $(".subMenu a").click(function() {
                $(".subMenu a").attr("style","background-color:#fff");
                $(this).attr("style","background-color:#dddfee");
            });*/
            $("#header").click(function(){window.location.href='/AutoData/'});
            ;
        });
        
    </script>
    </head>
    <body>
        <div id="box">
            <div id="header"></div>
            <div id="tabs">
<ul>
    <li style=""><a href="#tabs-ADMSYS" >系统管理</a></li>
    <li style=""><a href="#tabs-ADMTEM" >终端管理</a></li>
    <li style=""><a href="#tabs-ADMMER" >商户管理</a></li>
    <li style=""><a href="#tabs-QRYAPP" >交易查询</a></li>
    <li style=""><a href="#tabs-ADMAPP" >应用程序管理</a></li>
    <li style=""><a href="#tabs-ADMREP" >报表管理</a></li>
    <li style=""><a href="#tabs-REMPAY" >远程支付</a></li>
    <li style=""><a href="#tabs-AUTEXT" >数据自动提取</a></li>
    <li style=""><a href="#tabs-GETTEXT" >新数据自动提取</a></li>
    <li style="float:right"><a href="#tabs-QUIT" onclick="javascipt:window.location.href='/CMPOSPConsole/cmt/ADMLOGIN02.go';">退出系统</a></li>
</ul>
<!-- <div id="tabs-ADMSYS">
    <ul class="menuUl">
    <li><a class="menu" href="javascript:void(0)">用户管理</a></li>
    <li class="subMenu">
        <ul>
    <li><a href="/CMPOSPConsole/page/ftl/opr/ADMOPR9005.do" target="ADMSYS">添加用户</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/opr/ADMOPR9001.do" target="ADMSYS">修改密码</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMOPR9002" target="ADMSYS">查询用户</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMOPR9003" target="ADMSYS">审批用户</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMOPR9004" target="ADMSYS">用户信息维护</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMLOG9001" target="ADMSYS">操作员日志查询</a></li>
        </ul>
    </li>
    <li><a class="menu" href="javascript:void(0)">权限管理</a></li>
    <li class="subMenu">
        <ul>
    <li><a href="/CMPOSPConsole/page/ftl/txn/ADMTXN9001.do" target="ADMSYS">添加角色</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMTXN9002" target="ADMSYS">角色信息维护</a></li>
        </ul>
    </li>
    </ul>
    <div class="divRight">
        <iframe id="ADMSYS" name="ADMSYS" class="txnIframe" frameBorder="0" src="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMOPR9002">
        </iframe>
        <script type="text/javascript">
        $('#ADMSYS').load(function(){
            resizePage($(this));
        }); 
        </script>
    </div>
</div>
<div id="tabs-ADMTEM">
    <ul class="menuUl">
    <li><a class="menu" href="javascript:void(0)">终端厂商管理</a></li>
    <li class="subMenu">
        <ul>
    <li><a href="/CMPOSPConsole/page/ftl/tbh/ADMTBH9001.do" target="ADMTEM">同步厂商文件处理</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMTBH9002" target="ADMTEM">查询厂商</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMTBH9003" target="ADMTEM">厂商信息维护</a></li>
        </ul>
    </li>
    <li><a class="menu" href="javascript:void(0)">终端型号管理</a></li>
    <li class="subMenu">
        <ul>
    <li><a href="/CMPOSPConsole/page/ftl/tmt/ADMTMT9001.do" target="ADMTEM">同步型号文件处理</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMTMT9002" target="ADMTEM">查询型号</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMTMT9003" target="ADMTEM">型号信息维护</a></li>
        </ul>
    </li>
    <li><a class="menu" href="javascript:void(0)">库存管理</a></li>
    <li class="subMenu">
        <ul>
    <li><a href="/CMPOSPConsole/page/ftl/sto/ADMSTO9001.do" target="ADMTEM">设备采购</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMSTO9004" target="ADMTEM">查询出入库信息</a></li>
        </ul>
    </li>
    <li><a class="menu" href="javascript:void(0)">终端管理</a></li>
    <li class="subMenu">
        <ul>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMTEM9003" target="ADMTEM">商户终端绑定</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMTEM9001" target="ADMTEM">终端注册</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/tem/ADMTEM9003.do" target="ADMTEM">终端初始化</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMTEM9004" target="ADMTEM">终端查询</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMTEM9005" target="ADMTEM">终端信息维护</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMTEM9006" target="ADMTEM">POS信息维护</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/tem/ADMTEM9007.do" target="ADMTEM">终端信息上传</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMTEM9019" target="ADMTEM">批量商户终端操作</a></li>
        </ul>
    </li>
    </ul>
    <div class="divRight">
        <iframe id="ADMTEM" name="ADMTEM" class="txnIframe" frameBorder="0" src="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMTEM9004">
        </iframe>
        <script type="text/javascript">
        $('#ADMTEM').load(function(){
            resizePage($(this));
        }); 
        </script>
    </div>
</div>
<div id="tabs-ADMAPP">
    <ul class="menuUl">
    <li><a class="menu" href="javascript:void(0)">应用程序管理</a></li>
    <li class="subMenu">
        <ul>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMAPP9002" target="ADMAPP">查询应用程序</a></li>
        </ul>
    </li>
    </ul>
    <div class="divRight">
        <iframe id="ADMAPP" name="ADMAPP" class="txnIframe" frameBorder="0" src="/CMPOSPConsole/page/ftl/app/ADMAPP9001.do">
        </iframe>
        <script type="text/javascript">
        $('#ADMAPP').load(function(){
            resizePage($(this));
        }); 
        </script>
    </div>
</div>
<div id="tabs-ADMREP">
    <ul class="menuUl">
    <li><a class="menu" href="javascript:void(0)">报表统计</a></li>
    <li class="subMenu">
        <ul>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMREP901S" target="ADMREP">终端活跃度查询</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMREP902S" target="ADMREP">终端活跃度统计</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMREP9003" target="ADMREP">终端批结算情况查询</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMREP904S" target="ADMREP">未正常签到POS终端告警</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMREP905S" target="ADMREP">非活跃POS终端告警</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMREP906S" target="ADMREP">长时间无结算操作告警</a></li>
        	
    <li><a href="/CMPOSPConsole/page/ftl/rpt/ADMREP9007.do" target="ADMREP">常规日报</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/rpt/ADMREP9008.do" target="ADMREP">用户活跃粘性分析报表</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/rpt/ADMREP9009.do" target="ADMREP">活跃频次分析报表</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/rpt/ADMREP9010.do" target="ADMREP">各商户用户群体分析</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/rpt/ADMREP9013.do" target="ADMREP">消费明细</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/rpt/ADMREP9014.do" target="ADMREP">商户对账报表</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/rpt/ADMREP9015.do" target="ADMREP">商户对账总表</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMREP911S" target="ADMREP">终端签到情况统计</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMREP912S" target="ADMREP">终端结算情况统计</a></li>
        </ul>
    </li>
    </ul>
    <div class="divRight">
        <iframe id="ADMREP" name="ADMREP" class="txnIframe" frameBorder="0" src="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMREP901S">
        </iframe>
        <script type="text/javascript">
        $('#ADMREP').load(function(){
            resizePage($(this));
        }); 
        </script>
    </div>
</div>
<div id="tabs-ADMMER">
    <ul class="menuUl">
    <li><a class="menu" href="javascript:void(0)">商户管理</a></li>
    <li class="subMenu">
        <ul>
    <li><a href="/CMPOSPConsole/page/ftl/mer/ADMMER9001.do" target="ADMMER">同步商户文件处理</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMMER9002" target="ADMMER">查询同步信息</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMMER9003" target="ADMMER">查询商户</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMMER9004" target="ADMMER">商户信息维护</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/mer/ADMMER9005.do" target="ADMMER">POS补单录入</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMMER9007" target="ADMMER">POS补单管理</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMMER9008" target="ADMMER">POS补单审核</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMMER9009" target="ADMMER">POS补单发送</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMMER9010" target="ADMMER">POS补单查询</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMMER9011" target="ADMMER">POS补单同步</a></li>
        </ul>
    </li>
    <li><a class="menu" href="javascript:void(0)">门店管理</a></li>
    <li class="subMenu">
        <ul>
    <li><a href="/CMPOSPConsole/page/ftl/out/ADMOUT9001.do" target="ADMMER">门店信息录入</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMOUT9002" target="ADMMER">门店信息查询</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMOUT9003" target="ADMMER">门店信息管理</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMOUT90041" target="ADMMER">门店终端绑定信息管理</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/out/ADMOUT9005.do" target="ADMMER">商户门店导入</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMOUT90061" target="ADMMER">门店终端批量绑定</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/out/ADMOUT9007.do" target="ADMMER">门店终端绑定导入</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/out/ADMOUT9008.do" target="ADMMER">门店扩展信息录入</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMOUT9009" target="ADMMER">门店扩展信息查询</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMOUT9010" target="ADMMER">门店扩展信息维护</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/out/ADMOUT9011.do" target="ADMMER">营业厅编号批量导入</a></li>
        </ul>
    </li>
    </ul>
    <div class="divRight">
        <iframe id="ADMMER" name="ADMMER" class="txnIframe" frameBorder="0" src="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMMER9003">
        </iframe>
        <script type="text/javascript">
        $('#ADMMER').load(function(){
            resizePage($(this));
        }); 
        </script>
    </div>
</div>
<div id="tabs-QRYAPP">
    <ul class="menuUl">
    <li><a class="menu" href="javascript:void(0)">交易查询</a></li>
    <li class="subMenu">
        <ul>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMCQY9001" target="QRYAPP">交易查询</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMCQY905S" target="QRYAPP">积分明细查询</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMCQY906G" target="QRYAPP">积分商户统计</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMCQY907G" target="QRYAPP">积分用户统计</a></li>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMCQY908G" target="QRYAPP">交易成功率统计</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/cqy/ADMCQY9010.do" target="QRYAPP">积分兑换日报</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/cqy/ADMCQY9011.do" target="QRYAPP">手机支付用户</a></li>
        </ul>
    </li>
           <li><a class="menu" href="javascript:void(0)">历史交易</a></li>
    <li class="subMenu">
        <ul>

    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMHQY9002" target="QRYAPP">历史交易查询</a></li>
                </ul>
    </li>

    </ul>
    <div class="divRight">
        <iframe id="QRYAPP" name="QRYAPP" class="txnIframe" frameBorder="0" src="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMCQY9001">
        </iframe>
        <script type="text/javascript">
        $('#QRYAPP').load(function(){
            resizePage($(this));
        }); 
        </script>
    </div>
</div>
    
    远程支付
<div id="tabs-REMPAY">
    <ul class="menuUl">
    <li><a class="menu" href="javascript:void(0)">统计报表</a></li>
    <li class="subMenu">
        <ul>
    <li><a href="/CMPOSPConsole/page/ftl/recrpt/REMPAY9001.do" target="REMPAY">常规日报</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/recrpt/REMPAY9002.do" target="REMPAY">用户活跃粘性分析表</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/recrpt/REMPAY9003.do" target="REMPAY">远程支付用户习惯统计</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/recrpt/REMPAY9004.do" target="REMPAY">远程消费金额分布</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/recrpt/REMPAY9005.do" target="REMPAY">用户营销工具统计</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/recrpt/REMPAY9006.do" target="REMPAY">商户远程支付交易对账统计</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/recrpt/REMPAY9007.do" target="REMPAY">远程商户活跃度统计</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/recrpt/REMPAY9008.do" target="REMPAY">商户交易数据跟踪(日统计)</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/recrpt/REMPAY9009.do" target="REMPAY">商户交易数据跟踪(月统计)</a></li>
        </ul>
    </li>
    <li><a class="menu" href="javascript:void(0)">积分换红包统计报表</a></li>
    <li class="subMenu">
        <ul>
    <li><a href="/CMPOSPConsole/page/ftl/recrpt/REMPAY9010.do" target="REMPAY">红包统计总表(月统计)</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/recrpt/REMPAY9011.do" target="REMPAY">红包使用情况统计(月统计)</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/recrpt/REMPAY9012.do" target="REMPAY">用户使用习惯统计(月统计)</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/recrpt/REMPAY9013.do" target="REMPAY">对账报表(月统计)</a></li>
        	
        </ul>
    </li>
        
        
    <li><a class="menu" href="javascript:void(0)">监控管理</a></li>
    <li class="subMenu">
        <ul>
    <li><a href="/CMPOSPConsole/trans/CQBegin.go?CQId=ADMREP901S" target="REMPAY">交易数据查询</a></li>
        </ul>
    </li>
       
    </ul>
    <div class="divRight">
        <iframe id="REMPAY" name="REMPAY" class="txnIframe" frameBorder="0" src="/CMPOSPConsole/page/ftl/recrpt/REMPAY9005.do">
        </iframe>
        <script type="text/javascript">
        $('#REMPAY').load(function(){
            resizePage($(this));
        }); 
        </script>
    </div>
</div>
    
    数据自动提取
<div id="tabs-AUTEXT">
    <ul class="menuUl">
    <li><a class="menu" href="javascript:void(0)">数据自动提取</a></li>
    <li class="subMenu">
        <ul>
    <li><a href="/CMPOSPConsole/page/ftl/autext/AUTEXT9001.do" target="AUTEXT">全量用户、活跃用户数据</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/autext/AUTEXT9002.do" target="AUTEXT">电子券到期用户明细</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/autext/AUTEXT9003.do" target="AUTEXT">消费、缴话费满额数据</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/autext/AUTEXT9004.do" target="AUTEXT">商户满额消费用户数据</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/autext/AUTEXT9005.do" target="AUTEXT">营销活动发券额、消费额</a></li>
    <li><a href="/CMPOSPConsole/page/ftl/autext/AUTEXT9006.do" target="AUTEXT">电子券消费渠道明细数据</a></li>
	           <li><a href="/CMPOSPConsole/page/ftl/autext/AUTEXT9001.do" target="AUTEXT">手机支付活跃用户使用情况明细</a></li>

        </ul>
    </li>
    </ul>
    <div class="divRight">
        <iframe id="AUTEXT" name="AUTEXT" class="txnIframe" frameBorder="0" src="/CMPOSPConsole/page/ftl/autext/AUTEXT9001.do">
        </iframe>
        <script type="text/javascript">
        $('#AUTEXT').load(function(){
            resizePage($(this));
        }); 
        </script>
    </div>
</div> -->
    <!--新数据自动提取-->
<div id="tabs-GETTEXT">
    <ul class="menuUl">
    <li><a class="menu" href="javascript:void(0)">电子券相关</a></li>
    <li class="subMenu">
        <ul>
    	<li><a href="javascript:void(0)" class="menu2" >交易记录类</a></li>
    	<li class="subMenu2" style="display:none;">
    		<ul>
	    	<li><a href="cmt/GETTEXT011.action" target="GETTEXT">电子券消费数据</a></li>
	    	<li><a href="cmt/GETTEXT012.action" target="GETTEXT">消费电子券前列的商户数据</a></li>
    		</ul>
    	</li>
    	<li><a href="javascript:void(0)" class="menu2" >使用状态类</a></li>
    	<li class="subMenu2" style="display:none;">
    		<ul>
    		<li><a href="cmt/GETTEXT021.action" target="GETTEXT">电子券到期明细数据</a></li>
    		<li><a href="cmt/GETTEXT022.action" target="GETTEXT">活动下发电子券使用明细</a></li>
    		<li><a href="cmt/GETTEXT023.action" target="GETTEXT">用户电子券情况</a></li>
    		</ul>
    	</li>
    	<li><a href="javascript:void(0)" class="menu2" >用户拥有电子券类</a></li>
    	<li class="subMenu2" style="display:none;">
    		<ul>
    		<li><a href="cmt/GETTEXT031.action" target="GETTEXT">用户电子券详情信息</a></li>
    		</ul>
    	</li>
    	<li><a href="javascript:void(0)" class="menu2" >电子券总金额类</a></li>
    	<li class="subMenu2" style="display:none;">
    		<ul>
    		<li><a href="cmt/GETTEXT041.action" target="GETTEXT">存量电子券金额</a></li>
    		<li><a href="cmt/GETTEXT042.action" target="GETTEXT">发放/使用电子券总金额</a></li>
    		</ul>
    	</li>
    	<!-- 
    	<li><a href="javascript:void(0)" class="menu2">电子券到期明细数据</a></li>
    	<li class="subMenu2" style="display:none;">
    		<ul>
    		<li><a href="cmt/GETTEXT021.action" target="GETTEXT">电子券到期明细数据</a></li>
    		</ul>
    	</li> -->
        </ul>
        <!-- 
        <ul>
    		<li><a href="cmt/GETTEXT012.action" target="GETTEXT">消费电子券前列的商户数据</a></li>
        </ul>
        <ul>
    		<li><a href="cmt/GETTEXT021.action" target="GETTEXT">电子券到期明细数据</a></li>
        </ul> -->
    </li>
    <li><a class="menu" href="javascript:void(0)">支付账户相关</a></li>
    <li class="subMenu">
        <ul>
        <li><a href="javascript:void(0)" class="menu2" >交易记录类</a></li>
    	<li class="subMenu2" style="display:none;">
    		<ul>
	    	<li><a href="cmt/GETTEXT111.action" target="GETTEXT">生活(公共事业)缴费</a></li>
    		</ul>
    		<ul>
	    	<li><a href="cmt/GETTEXT112.action" target="GETTEXT">主账户远程消费记录</a></li>
    		</ul>
    		<ul>
	    	<li><a href="cmt/GETTEXT113.action" target="GETTEXT">购买某商户商品记录</a></li>
    		</ul>
    		<ul>
	    	<li><a href="cmt/GETTEXT114.action" target="GETTEXT">缴话费记录</a></li>
    		</ul>
    		<ul>
	    	<li><a href="cmt/GETTEXT115.action" target="GETTEXT">手机支付历史交易记录</a></li>
    		</ul>
    	</li>
    	<li><a href="javascript:void(0)" class="menu2" >用户使用类</a></li>	
    	<li class="subMenu2" style="display:none;">
    		<ul>
	    	<li><a href="cmt/GETTEXT121.action" target="GETTEXT">手机支付用户活跃数据</a></li>
    		</ul>
    		<ul>
	    	<li><a href="cmt/GETTEXT122.action" target="GETTEXT">快捷/手机支付/手机钱包</a></li>
    		</ul>
    		<ul>
	    	<li><a href="cmt/GETTEXT123.action" target="GETTEXT">手机支付帐户使用用户</a></li>
    		</ul>
    	</li>
    	<li><a href="javascript:void(0)" class="menu2" >账户金额类</a></li>	
    	<li class="subMenu2" style="display:none;">
    		<ul>
	    	<li><a href="cmt/GETTEXT131.action" target="GETTEXT">电子现金账户总充值金额</a></li>
    		</ul>
    	</li>
        </ul>
    </li>
    <li><a class="menu" href="javascript:void(0)">其他</a></li>
    <li class="subMenu">
        <ul>
    		
        </ul>
    </li>
    </ul>
    <div class="divRight">
        <iframe id="GETTEXT" name="GETTEXT" class="txnIframe" frameBorder="0" src="cmt/GETTEXT011.action">
        </iframe>
        <script type="text/javascript">
        $('#GETTEXT').load(function(){
            resizePage($(this));
        }); 
        </script>
    </div>
</div>
            </div>
        </div>
 <div id = "errorTipMotalDiv" style="z-index:99999;display:none;zoom:1;margin:0 auto;">
   <img src="<%=basePath%>image/bindYinYing.jpg" style="width:300px;"/>
   <a class='closeA' style="margin-top:0px;margin-right:13px;display:none;"><img src="<%=basePath%>image/motalClose.jpg"/></a>
   <div class="tipContent" id="errorTipContent">正在生成数据，请稍后......</div>
</div>
<script>
function errorTipMotalDiv(){
 	window.scrollTo(0,0);
	$("#errorTipMotalDiv").motalDiv({
		alertTabTop:"250px",
		opacity:30
	}); 
}
function closeBindDiv(){
  $("#errorTipMotalDiv a.closeA").click();
}
</script>      
    </body>
</html>