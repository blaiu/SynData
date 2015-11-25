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
            		<form action="${path}/addModel.do" method="post" id="myform" name="myform" onsubmit="return toVaildModel()">
                		<div class="config-items">
                    		<div class="config-title">
                        		<h1><i class="icon-font">&#xe00a;</i>任务</h1>
                    		</div>
                    		<div class="result-content">
                        		<table width="100%" class="insert-tab">
                            		<tbody>
                            			<tr>
                                			<th width="15%"><i class="require-red">*</i>模块名称：</th>
                                			<td><input type="text" id="modelName" value="${modelName}" size="30" name="modelName" class="common-text" maxlength="20"></td>
                                			<th width="15%"><i class="require-red">*</i>模块类型：</th>
                                			<td>
                                				<select id="modelType" name="modelType" class="required">
                                					<option value="1" <c:if test="${modelType == 1}">selected="selected"</c:if>>入库</option>
                                					<option value="2" <c:if test="${modelType == 2}">selected="selected"</c:if>>在库</option>
                                					<option value="3" <c:if test="${modelType == 3}">selected="selected"</c:if>>出库</option>
                                				</select>
                                			</td>
                            			</tr>
                                		<tr>
                                    		<th><i class="require-red">*</i>任务名称：</th>
                                    		<td><input type="text" id="taskName" value="${taskName}" size="30" name="taskName" class="common-text" maxlength="20"></td>
                                    		<th><i class="require-red">*</i>任务类型：</th>
                                    		<td>
                                				<select id="taskType" name="taskType" class="required">
                                					<option value="1">初始化</option>
                                					<option value="2">定位</option>
                                					<option value="3">任务分配</option>
                                					<option value="4">拣货</option>
                                					<option value="5">复核</option>
                                					<option value="6">打包</option>
                                					<option value="7">出库</option>
                                				</select>
                                			</td>
                                		</tr>
                                		<tr>
                                    		<th><i class="require-red">*</i>任务描述：</th>
                                    		<td colspan="3"><input type="text" id="taskDesc" name="taskDesc" value="${taskDesc}" size="80" name="taskDesc" class="common-text"></td>
                                		</tr>
                                		<tr>
                                    		<th><i class="require-red">*</i>查询BizKey：</th>
                                    		<td><input type="text" id="tokenQueryKey" name="tokenQueryKey" value="${tokenQueryKey}" size="30" name="description" class="common-text"></td>
                                    		<th><i class="require-red">*</i>回调BizKey：</th>
                                    		<td><input type="text" id="tokenModifyKey" name="tokenModifyKey" value="${tokenModifyKey}" size="30" name="description" class="common-text"></td>
                                		</tr>
                                		<tr>
                                    		<th><i class="require-red">*</i>CallCode：</th>
                                    		<td><input type="text" id="tokenCallCode" name="tokenCallCode" value="${tokenQueryKey}" size="30" name="description" class="common-text"></td>
                                    		<th><i class="require-red">*</i>UUID：</th>
                                    		<td><input type="text" id="tokenUuid" name="tokenUuid" value="${tokenModifyKey}" size="30" name="description" class="common-text"></td>
                                		</tr>
                                		<tr>
                                    		<th><i class="require-red">*</i>调用地址：</th>
                                    		<td colspan="3"><input type="text" id="address" name="address" value="${address}" size="80" name="taskDesc" class="common-text"><font color="red"> (调用地址请勿加?wsdl)</font></td>
                                		</tr>
                                		<tr>
                                    		<th></th>
                                    		<td colspan="3">
                                        		<input type="submit" value="提交" class="btn btn-primary btn6 mr10">
                                        		<input type="button" value="返回" onclick="history.go(-1)" class="btn btn6">
                                    		</td>
                                		</tr>
                            		</tbody>
                            	</table>
                    		</div>
                		</div>
<!--                 		<div class="config-items"> -->
<!--                     		<div class="config-title"> -->
<!--                         		<h1><i class="icon-font">&#xe014;</i>调度配置</h1> -->
<!--                     		</div> -->
<!--                     		<div class="result-content"> -->
<!--                         		<table width="100%" class="insert-tab"> -->
<!-- 	                        		<tbody> -->
<!-- 			                            <tr> -->
<!-- 			                                <th width="15%"><i class="require-red">*</i>分钟：</th> -->
<%-- 			                                <td><input type="text" id="configMin" value="${configMin}" size="2" name="configMin" class="common-text" maxlength="2"> /min</td> --%>
<!-- 			                                <th width="15%"><i class="require-red">*</i>时钟：</th> -->
<%-- 			                                <td><input type="text" id="configHour" value="${configHour}" size="2" name="configHour" class="common-text" maxlength="2"> /hour</td> --%>
<!-- 			                            </tr> -->
<!-- 			                            <tr> -->
<!-- 			                                <th width="15%"><i class="require-red">*</i>月：</th> -->
<%-- 			                                <td><input type="text" id="configMonth" value="${configMonth}" size="2" name="configMonth" class="common-text" maxlength="2"> /month</td> --%>
<!-- 			                                <th width="15%"><i class="require-red">*</i>年：</th> -->
<%-- 			                                <td><input type="text" id="configYear" value="${configYear}" size="2" name="configYear" class="common-text" maxlength="2"> /year</td> --%>
<!-- 			                            </tr> -->
<!-- 			                            <tr> -->
<!-- 			                                <th width="15%"><i class="require-red">*</i>周：</th> -->
<%-- 			                                <td><input type="text" id="configWeek" value="${configWeek}" size="2" name="configWeek" class="common-text" maxlength="2"> /week</td> --%>
<!-- 			                                <th width="15%"><i class="require-red">*</i>最大执行次数：</th> -->
<%-- 			                                <td><input type="text" id="maxTimes" value="${maxTimes}" size="2" name="maxTimes" class="common-text" maxlength="2"></td> --%>
<!-- 			                            </tr> -->
<!-- 		                                <tr> -->
<!-- 		                                    <th></th> -->
<!-- 		                                    <td colspan="3"> -->
<!-- 		                                        <input type="hidden" value="siteConf.inc.php" name="file"> -->
<!-- 		                                        <input type="submit" value="提交" class="btn btn-primary btn6 mr10"> -->
<!-- 		                                        <input type="button" value="返回" onclick="history.go(-1)" class="btn btn6"> -->
<!-- 		                                    </td> -->
<!-- 		                                </tr> -->
<!-- 		                        	</tbody> -->
<!--                         		</table> -->
<!--                     		</div> -->
<!--                 		</div> -->
           			</form>
        		</div>
    		</div>
    <!--/main-->
		</div>
	</body>
</html>