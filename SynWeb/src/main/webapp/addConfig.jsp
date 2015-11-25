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
           				<span class="crumb-name">任务添加</span>
            		</div>
        		</div>
        		
        		<div class="result-wrap">
            		<form action="${path}/addConfig.do" method="post" id="myform" name="myform" onsubmit="return toVaildConfig()">
                		<div class="config-items">
                    		<div class="config-title">
                        		<h1><i class="icon-font">&#xe014;</i>调度配置   </h1>
                        		<c:if test="${flag == true}">
                        		<h1><font color="green">保存成功</font></h1>
                        		</c:if>
                    		</div>
                    		<div class="result-content">
                        		<table width="100%" class="insert-tab">
	                        		<tbody>
			                            <tr>
			                                <th width="15%"><i class="require-red">*</i>Cron 表达式：</th>
			                                <td><input type="text" id="cronExpression" value="${cfg.cronExpression}" size="50" name="cronExpression" class="common-text" maxlength="20"></td>
			                            	<th width="15%"><i class="require-red">*</i>最大执行次数：</th>
			                                <td><input type="text" id="maxTimes" value="${cfg.maxTimes}" size="2" name="maxTimes" class="common-text" maxlength="3"></td>
			                            	<th width="15%"><i class="require-red">*</i>抓取大于次数：</th>
			                                <td><input type="text" id="maxNum" value="${cfg.maxNum}" size="2" name="maxNum" class="common-text" maxlength="3"></td>
			                            </tr>
		                                <tr>
		                                    <th></th>
		                                    <td colspan="5">
		                                        <input type="hidden" value="${taskId}" name="taskId">
		                                        <input type="hidden" value="${taskType}" name="taskType">
		                                        <input type="submit" value="提交" class="btn btn-primary btn6 mr10">
		                                        <input type="button" value="返回" onclick="history.go(-1)" class="btn btn6">
		                                    </td>
		                                </tr>
		                        	</tbody>
                        		</table>
                    		</div>
                		</div>
           			</form>
        		</div>
    		</div>
    <!--/main-->
		</div>
	</body>
</html>