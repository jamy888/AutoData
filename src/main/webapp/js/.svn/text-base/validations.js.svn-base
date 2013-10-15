var fieldRules = new Array();
var errMsgs = new Array();
//校验表单
function validateForm(){
    var pass = true;
	$("form input,select").each(function(){
		if(fieldRules[$(this).attr("name")] != null){
			if (!validateFormField($(this), fieldRules[$(this).attr("name")])){
                pass = false;
            }
		}
	});
    return pass;
}
//根据给定的正则表达式规则集对某一表单域的内容进行有效性检查
function validateFormField(fld, rule){
	var p = true;
	var errMsg = "";
	var t = fld.attr("type");
	var n = fld.attr("name");
	if(t =="radio" || t =="checkbox") {
		if($("input[name='"+n+"']:checked").val() == undefined){
			errMsg = errMsgs[n]?errMsgs[n][0]:"该项不符合要求！";
			p = false;
		}
	} else {
		$(rule).each(function(i){
			if(!lessThanMaxLen(fld)){
				errMsg = "该项长度不符合要求！";
				p = false;
			}else if (!checkMatch(fld.val(), this)){
				errMsg = errMsgs[n]?errMsgs[n][i]:"该项不符合要求！";
				p = false;
			}
		});
	}
	var fieldMessage = $("#"+n+"_m");
	if(fieldMessage.length!=0){
		if(!p){
			$("#"+n+"_m p").remove();
			$("<p>"+errMsg+"</p>").prependTo(fieldMessage);
			fieldMessage.attr("class","errorMsg");
		} else {
			$("#"+n+"_m p").remove();
			fieldMessage.attr("class","hintMsg");
		}
	}
	return p;
}
//检查给定的字符串是否满足给定的正则表达式条件
function checkMatch(str,pattern)
{
    if ((0 == str.length) && (pattern != ".+")){ //空串视为匹配成功，除非指定规则为isNotEmpty
        return true;
    }
	return new RegExp(pattern).test(str);
}

//判断文本框中字符的总字节数是否小于指定的maxlength
//注意：text控件的最大长度属性为maxLength，而textarea控件则为maxlength
function lessThanMaxLen(fld){
    if('text' != fld.attr("type") && 'textarea' != fld.attr("type")){
    	return true;
    }
    if (fld.attr("maxLength") == -1 ){
        return true;
    }
    if(jQuery.trim(fld.val())==""){
    	return false;
    }
    return calculate_byte(fld.val()) <= fld.attr("maxLength");
}
/***************JS方法判断字符串字节长度，英文1字节，UTF-8中文3字节****************/
function calculate_byte( sTargetStr ) {
    var sTmpStr, sTmpChar;
    var nOriginLen = 0;
    var nStrLength = 0;

    sTmpStr = new String(sTargetStr);
    nOriginLen = sTmpStr.length;

    for ( var i=0 ; i < nOriginLen ; i++ ) {
        sTmpChar = sTmpStr.charAt(i);
        if (escape(sTmpChar).length > 4) {
                nStrLength += 2;
        } else if (sTmpChar!='\r') {
                nStrLength ++;
        }
    }
    return nStrLength;
}
