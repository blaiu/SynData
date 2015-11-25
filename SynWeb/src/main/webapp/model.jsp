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
		            	<a href="${path}/toIndex.do">首页</a>
		            	<span class="crumb-step">&gt;</span>
		            	<span class="crumb-name">任务列表</span>
		            </div>
		        </div>
		        <div class="search-wrap">
		            <div class="search-content">
		                <form action="${path}/queryModel.do" method="post">
		                    <table class="search-tab">
		                        <tr>
		                            <th width="120">模块类型:</th>
		                            <td>
		                                <select name="modelType" id="modelType">
		                                    <option value="">全部</option>
		                                    <option value="1" <c:if test="${pageParam.modelType == 1}">selected="selected"</c:if>>入库</option>
		                                    <option value="2" <c:if test="${pageParam.modelType == 2}">selected="selected"</c:if>>在库</option>
		                                    <option value="3" <c:if test="${pageParam.modelType == 3}">selected="selected"</c:if>>出库</option>
		                                    
		                                </select>
		                            </td>
		                            <th width="70">关键字:</th>
		                            <td><input class="common-text" placeholder="关键字" name="keyWord" value="${pageParam.keyWord}" id="keyWord" type="text"></td>
		                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
		                        </tr>
		                    </table>
		                </form>
		            </div>
		        </div>
		        <div class="result-wrap">
		            <form name="myform" id="myform" method="post">
		                <div class="result-title">
		                    <div class="result-list">
		                        <a href="${path}/toAddModel.do"><i class="icon-font"></i>新增</a>
<!-- 		                        <a id="batchDel" href="#" onclick="removeAll()" ><i class="icon-font"></i>批量删除</a> -->
<!-- 		                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a> -->
		                    </div>
		                </div>
		                <div class="result-content">
		                    <table class="result-tab" width="100%">
		                        <tr>
<!-- 		                            <th class="tc" width="5%"><input class="allChoose" id="choose" name="" type="checkbox" onclick="chooseAll()"></th> -->
		                            <th>任务号</th>
		                            <th>任务名称</th>
		                            <th>任务类型</th>
		                            <th>模块</th>
		                            <th>模块类型</th>
		                            <th>状态</th>
		                            <th>操作</th>
		                        </tr>
		                        
		                        <c:forEach var="p" items="${pagination.list}">
		                        <tr>
<%-- 		                            <td class="tc"><input name="modelId" value="${p.id}" type="checkbox"></td> --%>
		                            <td>${p.taskId}</td>
		                            <td title="${p.taskName}">${p.taskName}</td>
		                            <td>
		                            	<c:if test="${p.taskType==1}">初始化</c:if>
		                            	<c:if test="${p.taskType==2}">定位</c:if>
		                            	<c:if test="${p.taskType==3}">任务分配</c:if>
		                            	<c:if test="${p.taskType==4}">拣货</c:if>
		                            	<c:if test="${p.taskType==5}">复核</c:if>
		                            	<c:if test="${p.taskType==6}">打包</c:if>
		                            	<c:if test="${p.taskType==7}">出库</c:if>
		                            </td>
		                            <td>${p.modelName}</td>
		                            <td>
			                            <c:if test="${p.modelType==1}">入库</c:if>
			                            <c:if test="${p.modelType==2}">在库</c:if>
			                            <c:if test="${p.modelType==3}">出库</c:if>
		                            </td>
		                            <td>
			                            <c:if test="${p.isStart==0}">
			                            	<span id="showStart${p.id}"><a href="javascript:startUp('${p.id}', '${p.taskId}', '1')">[开启]</a></span>
			                            	<span id="showStop${p.id}" style="display: none"><a href="javascript:startUp('${p.id}', '${p.taskId}', '0')">[停止]</a></span>
			                            </c:if>
			                            <c:if test="${p.isStart==1}">
			                            	<span id="showStart${p.id}" style="display: none"><a href="javascript:startUp('${p.id}', '${p.taskId}', '1')">[开启]</a></span>
			                            	<span id="showStop${p.id}"><a href="javascript:startUp('${p.id}', '${p.taskId}', '0')">[停止]</a></span>
			                            </c:if>
		                            </td>
		                            <td>
<!-- 		                                <a class="link-update" href="#">修改</a> -->
		                                <a class="link-update" href="${path}/toView.do?taskId=${p.taskId}">查看</a>
		                                <a class="link-update" href="${path}/toConfig.do?taskId=${p.taskId}&taskType=${p.taskType}">配置</a>
		                                <a class="link-del" href="#" onclick="removeModel('${p.taskId}')">删除</a>
		                            </td>
		                        </tr>
		                        </c:forEach>
		                        
		                    </table>
		                    <div class="list-page"> 
		                    	共${pagination.totalCount}条纪录，当前第${pagination.pageNo}页/共${pagination.totalPage}页，
		                    	每页显示${pagination.pageSize}条纪录
		                    	<c:if test="${pagination.pageNo > 1 && pagination.pageNo !=1 && pagination.pageNo != pagination.totalPage && pagination.totalPage > 1}">
		                    		<a href="${path}${pagination.url}&pageNo=${pagination.pageNo-1}">上一页</a>
		                    		<a href="${path}${pagination.url}&pageNo=${pagination.pageNo+1}">下一页</a>
		                    	</c:if>
		                    	<c:if test="${pagination.pageNo == 1 && pagination.totalPage > 1}">
		                    		<a href="${path}${pagination.url}&pageNo=${pagination.pageNo+1}">下一页</a>
		                    	</c:if>
		                    	<c:if test="${pagination.pageNo == pagination.totalPage && pagination.totalPage > 1}">
		                    		<a href="${path}${pagination.url}&pageNo=${pagination.pageNo-1}">上一页</a>
		                    	</c:if>
		                    </div>
		                </div>
		            </form>
		        </div>
    		</div>
    <!--/main-->
		</div>
	</body>
</html>