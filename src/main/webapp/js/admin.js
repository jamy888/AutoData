function showTip(obj) {
	if (document.getElementById(obj.id + "_m") != null) {
		if (document.getElementById(obj.id + "_m").className == "hintMsg") {
			document.getElementById(obj.id + "_m").className = "warningMsg";
		}
	} else if (document.getElementById(obj.name + "_m") != null) {
		if (document.getElementById(obj.name + "_m").className == "hintMsg") {
			document.getElementById(obj.name + "_m").className = "warningMsg";
		}
	}
}
function returnNormal(obj) {
	if (document.getElementById(obj.id + "_m") != null) {
		if (document.getElementById(obj.id + "_m").className == "warningMsg") {
			document.getElementById(obj.id + "_m").className = "hintMsg";
		}
	} else if (document.getElementById(obj.name + "_m") != null) {
		if (document.getElementById(obj.name + "_m").className == "warningMsg") {
			document.getElementById(obj.name + "_m").className = "hintMsg";
		}
	}
}
function checkChange(obj) {
	if (document.getElementById(obj.id + "_m") != null) {
		if (document.getElementById(obj.id + "_m").className != "errorMsg") {
			document.getElementById(obj.id + "_m").className = "warningMsg";
		}
	} else if (document.getElementById(obj.name + "_m") != null) {
		if (document.getElementById(obj.name + "_m").className == "errorMsg") {
			document.getElementById(obj.name + "_m").className = "warningMsg";
		}
	}
}
var jAlert = function(message,callback){
	$("#dialog").dialog({
		buttons: {
			"确定": function() {
				$(this).dialog('close');
			}
		}
	});
}
var jConfirm = function(message,myCallback){
	$("#dialog").dialog({
		buttons: {
	        "取消": function(){
	            $(this).dialog("close");
	            myCallback(false);
	        },
			"确定": function(){
	        	$(this).dialog("close");
	        	myCallback(true);
	        }
	    }
	});
}
var myCallback;
var jm = function(message,callback){
	if(callback){
		myCallback = callback;
		$("#dialog").html(message);
		$("#dialog").dialog('open');
		jConfirm(message,callback);
	}else{
		$("#dialog").html(message);
		$("#dialog").dialog('open');
		jAlert(message);
	}
}
function resizePage(iframe){
	var height = iframe.contents().find("#mainIndex").height();
	iframe.height(height > 550 ? height:550);
}