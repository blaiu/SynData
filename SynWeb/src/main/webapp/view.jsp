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
            			<i class="icon-font"></i>
           				<a href="#">首页</a>
           				<span class="crumb-step">&gt;</span>
           				<span class="crumb-name">任务浏览</span>
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
                                			<th width="15%">模块名称：</th>
                                			<td>${model.modelName}</td>
                                			<th width="15%">模块类型：</th>
                                			<td>
                                				<c:if test="${model.modelType == 1}">入库</c:if>
                                				<c:if test="${model.modelType == 2}">在库</c:if>
                                				<c:if test="${model.modelType == 3}">出库</c:if>
                                			</td>
                            			</tr>
                                		<tr>
                                    		<th>任务名称：</th>
                                    		<td>${model.taskName}</td>
                                    		<th>任务类型：</th>
                                    		<td>
                                				未知任务类型
                                			</td>
                                		</tr>
                                		<tr>
                                    		<th>任务描述：</th>
                                    		<td colspan="3">${model.taskDesc}</td>
                                		</tr>
                                		<tr>
                                    		<th>查询BizKey：</th>
                                    		<td>${model.tokenQueryKey}</td>
                                    		<th>回调BizKey：</th>
                                    		<td>${model.tokenModifyKey}</td>
                                		</tr>
                                		<tr>
                                    		<th>CallCode：</th>
                                    		<td>${model.tokenCallCode}</td>
                                    		<th>UUID：</th>
                                    		<td>${model.tokenUuid}</td>
                                		</tr>
                                		<tr>
                                    		<th>调用地址：</th>
                                    		<td colspan="3">${model.address}</td>
                                		</tr>
                            		</tbody>
                            	</table>
                    		</div>
                		</div>
                		<div class="config-items">
                    		<div class="config-title">
                        		<h1><i class="icon-font">&#xe014;</i>调度配置</h1>
                    		</div>
                    		<div class="result-content">
                        		<table width="100%" class="insert-tab">
	                        		<tbody>
			                            <tr>
			                                <th width="15%">Cron 表达式：</th>
			                                <td>${cfg.cronExpression}</td>
			                                <th width="15%">最大执行次数：</th>
			                                <td>${cfg.maxTimes}</td>
			                                <th width="15%">抓取大于次数：</th>
			                                <td>${cfg.maxNum}</td>
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