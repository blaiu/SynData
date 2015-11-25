<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta http-equiv="pragma" content="no-cache"/> 
		<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>
		<title>后台管理</title>
	    <link rel="stylesheet" type="text/css" href="${path}/css/common.css"/>
	    <link rel="stylesheet" type="text/css" href="${path}/css/main.css"/>
	    <script type="text/javascript" src="${path}/js/libs/modernizr.min.js"></script>
	</head>
	
	<body>
		<%@ include file="/header.jsp"%>
		
		<div class="container clearfix">
		
			<%@ include file="/left.jsp"%> 
			
    		<!--/sidebar-->
    		<div class="main-wrap">
        		<div class="crumb-wrap">
            		<div class="crumb-list">
            			<i class="icon-font">&#xe06b;</i>
            			<span>欢迎使用。</span>
            		</div>
        		</div>
        		
        		<div class="result-wrap">
		            <div class="result-title">
		                <h1>系统基本信息</h1>
		            </div>
            		<div class="result-content">
                		<ul class="sys-info-list">
		                    <li>
		                        <label class="res-lab">操作系统</label><span class="res-info">${osName }</span>
		                    </li>
		                    <li>
		                        <label class="res-lab">运行环境</label><span class="res-info">${javaVendor }</span>
		                    </li>
		                    <li>
		                        <label class="res-lab">java版本</label><span class="res-info">${javaVersion }</span>
		                    </li>
		                    <li>
		                        <label class="res-lab">版本</label><span class="res-info">v-0.1</span>
		                    </li>
		                    <li>
		                        <label class="res-lab">上传附件限制</label><span class="res-info">2M</span>
		                    </li>
		                    <li>
		                        <label class="res-lab">北京时间</label><span class="res-info"><fmt:formatDate value="${date }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
		                    </li>
		                    <li>
		                        <label class="res-lab">服务器域名/IP</label><span class="res-info">localhost [ 127.0.0.1 ]</span>
		                    </li>
		                    <li>
		                        <label class="res-lab">Host</label><span class="res-info">127.0.0.1</span>
		                    </li>
                		</ul>
            		</div>
        		</div>
        		
        		<div class="result-wrap">
		            <div class="result-title">
		                <h1>使用帮助</h1>
		            </div>
		            <div class="result-content">
		                <ul class="sys-info-list">
<!-- 		                    <li> -->
<!-- 		                        <label class="res-lab">官方交流网站：</label><span class="res-info"><a href="http://www.mycodes.net/" target="_blank">源码之家</a></span> -->
<!-- 		                    </li> -->
<!-- 		                    <li> -->
<!-- 		                        <label class="res-lab">官方交流QQ群：</label><span class="res-info"><a class="qq-link" target="_blank" href="http://shang.qq.com/wpa/qunwpa?idkey=4ba39c297a33fa548de56a257f6128c7c9e3dd14473e4c86557d93f2197c33e8"><img border="0" src="http://pub.idqqimg.com/wpa/images/group.png" alt="JS-前端开发" title="JS-前端开发"></a> </span> -->
<!-- 		                    </li> -->
		                </ul>
		            </div>
        		</div>
    		</div>
    <!--/main-->
		</div>
	</body>
</html>