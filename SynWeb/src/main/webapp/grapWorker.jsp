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
	    <script type="text/javascript"> var path = "${path}"; </script>
	    <script type="text/javascript" src="${path}/js/libs/modernizr.min.js"></script>
	    <script type="text/javascript" src="${path}/js/jquery-2.1.3.js"></script>
	    <script type="text/javascript" src="${path}/js/content.js"></script>
	</head>
	
	<body>
		<%@ include file="/header.jsp"%>
		
		<div class="container clearfix">
		
		<%@ include file="/left.jsp"%> 
			
    		<!--/sidebar-->
    		<div class="main-wrap">
        		<div class="crumb-wrap">
            		<div class="crumb-list">
            			<i class="icon-font"></i>
           				<a href="#">首页</a>
           				<span class="crumb-step">&gt;</span>
           				<span class="crumb-name">抓取worker</span>
            		</div>
        		</div>
        		
        		<div class="result-wrap">
               		<div class="config-items">
                   		<div class="config-title">
                       		<h1><i class="icon-font">&#xe00a;</i>任务</h1>
                   		</div>
                   		<div class="result-content">
                       		<table width="100%" class="insert-tab">
                           		<tbody>
                           			<tr>
                               			<th width="15%">状态：</th>
                               			<td>
                               			<c:if test="${flag==false}">
			                            	<span id="workerStart"><a href="javascript:workerStartStop('${taskId}', '1')">[开启]</a></span>
			                            	<span id="workerStop" style="display: none"><a href="javascript:workerStartStop('${taskId}', '0')">[停止]</a></span>
			                            </c:if>
			                            <c:if test="${flag==true}">
			                            	<span id="workerStart" style="display: none"><a href="javascript:workerStartStop('${taskId}', '1')">[开启]</a></span>
			                            	<span id="workerStop"><a href="javascript:workerStartStop('${taskId}', '0')">[停止]</a></span>
			                            </c:if>
                               			</td>
                               			<th width="15%">配置：</th>
                                    	<td><input type="text" id="cronExpssion" name="cronExpssion" value="${cronExpssion}" size="60" name="cronExpssion" class="common-text"></td>
                           			</tr>
                           		</tbody>
                           	</table>
                   		</div>
               		</div>
        		</div>
    		</div>
    <!--/main-->
		</div>
	</body>
</html>