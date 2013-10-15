(function($){
	$.fn.motalDiv=function(options){
		var h = document.body.scrollHeight;
		var defaultVal={
			renderTo:"body",
			opacity:20,
			pIndex:99,
			alertTabTop:"150px",
			alertTabheight:"230px",
		    Bgheight:h
		};
		var obj = $.extend(defaultVal,options);
		if($(".wj_test1").length == 0){
			$("body").append("<div id='motalDiv' class='wj_test1'></div");
		}
		var motalDiv = $("#motalDiv");//父元素div
		motalDiv.css({"display":"none","z-index":obj.pIndex,"height":obj.Bgheight});//将父元素设置到最高层；
		if($(".wj_test2").length == 0){
			motalDiv.append("<div id = 'motalBgDiv' class='motalBg wj_test2'></div><table id='alertTab' class='alertTable'><tr><td id='alertTd'></td></tr></talbe>");
			$("#motalBgDiv").css({
				"height":obj.Bgheight
			});
		}
		var alertTab = $("#alertTab");
		alertTab.css({
				"top":obj.alertTabTop,
				"height":obj.alertTabheight
		});
		$("#alertTd").css({
			"text-align":"center",
			"width":"100%"
		});
		$("#alertTd").append($(this));
		this.addClass("alertTabDiv");
		this.show();
		var motalBgDiv = $("#motalBgDiv");
		motalBgDiv.css({
			"background":"black",
			"opacity":obj.opacity/100
		});
		var closeA = $("a.closeA");
		function closeDiv(){
			$("#alertTd").children().hide();
			$("body").append($("#alertTd").children());
			$("#alertTd").children().remove();
			motalDiv.remove();
		}
		closeA.unbind("click",closeDiv);
		closeA.bind("click",closeDiv);
		motalDiv.show();
	}
})(jQuery);