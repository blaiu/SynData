
function removeAll () {
	var ids = "";
	$("input[name^='modelId']").each(function(i, o) {
	    if($(o).prop("checked")) {
	    	if ("" == ids) {
	    		ids = $(o).val();
	    	} else {
	    		ids = ids + "," + $(o).val();
	    	}
	    }
	});
	$.ajax({ url: path+"/removeModel.do?ids="+ids})
		.success(function() { 
			alert("删除成功");
			location.reload();
		})
		.error(function() { 
			alert("删除失败"); 
		})
		.complete(function() {
		});
}

function removeModel (id) {
	$.ajax({ url: path+"/removeModel.do?taskId="+id})
		.success(function() { 
			alert("删除成功");
			location.reload();
		})
		.error(function() { 
			alert("删除失败"); 
		})
		.complete(function() {
		});
}

function chooseAll () {
	if($("#choose").prop("checked")) {
		$("input[name^='modelId']").each(function(i, o) {
		    $(o).prop('checked', true);
		});
	} else {
		$("input[name^='modelId']").each(function(i, o) {
			$(o).prop('checked', false);
		});
	}
}

function startUp(id, taskId, isStart) {
	$.ajax({ url: path+"/startStop.do?id=" + id + "&taskId=" + taskId + "&isStart=" + isStart})
	.success(function(flag) { 
		if("true" == flag) {
			if ("1" == isStart) {
				$("#showStart"+id).hide();
				$("#showStop"+id).show();
			}
			if ("0" == isStart) {
				$("#showStart"+id).show();
				$("#showStop"+id).hide();
			}
		} else {
			alert("操作失败");
		}
	})
	.error(function(flag) { 
	})
	.complete(function(flag) {
	});
}

function workerStartStop(taskId, isStart) {
	var cronExpression = $("#cronExpssion").val();
	$.ajax({ url: path+"/grapWorkerStartStop.do?taskId=" + taskId + "&isStart=" + isStart + "&cronExpression=" + cronExpression})
	.success(function(flag) { 
		if("true" == flag) {
			if ("1" == isStart) {
				$("#workerStart").hide();
				$("#workerStop").show();
			}
			if ("0" == isStart) {
				$("#workerStart").show();
				$("#workerStop").hide();
			}
		} else {
			alert("操作失败");
		}
	})
	.error(function(flag) { 
	})
	.complete(function(flag) {
	});
}

function toVaildModel() {
	var modelName = $("#modelName").val().trim();
	var taskName = $("#taskName").val().trim();
	var taskDesc = $("#taskDesc").val().trim();
	var tokenQueryKey = $("#tokenQueryKey").val().trim();
	var tokenModifyKey = $("#tokenModifyKey").val().trim();
	var tokenCallCode = $("#tokenCallCode").val().trim();
	var tokenUuid = $("#tokenUuid").val().trim();
	var address = $("#address").val().trim();
	if ("" == modelName || "" == taskName || "" == taskDesc || "" == tokenQueryKey
		|| "" == tokenModifyKey || "" == tokenCallCode || address == "") {
		alert("请检查输入资料的完整性");
		return false;
	}
	return true;
}

function toVaildConfig() {
	var cronExpression = $("#cronExpression").val().trim();
	var maxTimes = $("#maxTimes").val().trim();
	var maxNum = $("#maxNum").val().trim();
	if ("" == cronExpression || "" == maxTimes || "" == maxNum) {
		alert("请检查输入资料的完整性");
		return false;
	}
	return true;
}