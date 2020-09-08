function browserRedirect() {
    var sUserAgent = navigator.userAgent.toLowerCase();
    console.log("sUserAgent",sUserAgent);
    var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
    var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
    var bIsMidp = sUserAgent.match(/midp/i) == "midp";
    var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
    var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
    var bIsAndroid = sUserAgent.match(/android/i) == "android";
    var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
    var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";

    if (!(bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM) ){
        return false;
    }else {
        return true;
    }
}

$.request = function (options) {
    var default_set = {
        type : "POST",
        data : {},
        contentType: 'application/json;charset=UTF-8',
        dataType: 'json',
        error:function (message) {
            console.log(message);
            $('#loadingToast').fadeOut(100);
            errMsg("网络异常");
        }
    };
    var init_set = $.extend({},default_set, options || {});
    $.ajax(init_set);
};