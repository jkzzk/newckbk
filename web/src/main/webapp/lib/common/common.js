/*
* 判断是手机登录还是电脑登录
*
* */
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

/**
 * 错误提示
 * @param msg
 */
function errMsg(msg){
    layer.msg(msg,{icon:2,time:1000});
}

/**
 * 提示信息
 * @param msg
 * @param option
 */
function msg(msg,option) {
    layer.msg(msg,option);
}

/**
 * 成功提示
 * @param msg
 */
function succMsg(msg) {
    layer.msg(msg,{icon:1,time:1000});
}

function refresh() {
    location.replace(location.href);
}

/**
 * 添加
 */
function add(title,url,w,h){
    layer_show(title,url,w,h);
}

/**
 * 编辑
 */
function edit(title,url,w,h){
    var id = '';
    var count = 0;
    $.each($('input:checkbox:checked'),function(){
        if($(this).val() != '') {
            id += $(this).val() + ',';
            count++;
        }
    });
    id = id.substring(0,id.length-1);
    if(id == '' || count>1) {
        errMsg("请选择一条数据编辑！");
        return;
    }
    layer_show(title,url+"?id="+id,w,h);
}

/**
 * 删除
 */
function del(id,url){
    layer.confirm('确认要删除吗？',function(){
        $.ajax({
            type: 'POST',
            url: url,
            data: {ids:id},
            success: function(data){
                succMsg(data.msg);
                setTimeout(function () {
                    refresh();
                },1000)
            },
            error:function(data) {
                errMsg(data.msg);
            },
        });
    });
}

/**
 * 清除
 */
function clearData(url){
    // console.log(url);
    layer.confirm('确认要清除吗？',function(){
        $.ajax({
            type: 'POST',
            url: url,
            success: function(data){
                succMsg(data.msg);
                setTimeout(function () {
                    refresh();
                },1000)
            },
            error:function(data) {
                errMsg(data.msg);
            },
        });
    });
}

/**
 * 批量删除
 */
function datadel(url) {
    var ids = '';
    $.each($('input:checkbox:checked'),function(){
        if($(this).val() != '') {
            ids += $(this).val() + ',';
        }
    });
    ids = ids.substring(0,ids.length-1);
    if(ids.length > 0) {
        del(ids,url);
    }else {
        layer.msg("请选择要删除的数据！",{icon:3,time:2000});
    }
}

function getIds() {
    var ids = '';
    $.each($('input:checkbox:checked'),function(){
        if($(this).val() != '') {
            ids += $(this).val() + ',';
        }
    });
    ids = ids.substring(0,ids.length-1);
    if(ids.length > 0) {
        return  ids;
    }else{
        return "";
    }
}

function getRowData() {
    $.each($('input:checkbox:checked'),function(){
        if($(this).val() != '') {
            console.log($(this).parentNode);
        }
    });
}


/**
 * 启用禁用
 * flag 0代表 启用 1代表 禁用
 * @param flag
 * @param id
 * @param msg
 * @param url
 */
function enableAndDisable(flag,msg,url) {
    var id = '';
    $.each($('input:checkbox:checked'),function(){
        if($(this).val() != '') {
            id += $(this).val() + ',';
        }
    });
    id = id.substring(0,id.length-1);
    if(id == '' || id == null || id.length >1) {
        errMsg("请选择一条数据编辑！");
        return;
    }
    layer.confirm(msg, function () {
        $.ajax({
            url:url,
            data:{id:id,num:flag},
            type:"POSt",
            success:function (data) {
                succMsg(data.msg);
                setTimeout(function () {
                    refresh();
                },1000)
            },
            error:function () {
                errMsg("网路异常");
            }
        });

    });
}

function checked(obj) {
    if($(obj).children('td:first-child').children('input').prop('checked')==true){
        $(obj).children('td:first-child').children('input').prop('checked',false);
    }else {
        $(obj).children('td:first-child').children('input').prop('checked',true);
    }
}

function download(url) {
    window.open(url);
}

function importFile(url,filename,dom) {
    var formData = new FormData();
    formData.append(filename,$(dom)[0].files[0]);
    $.ajax({
        url: url,
        type:'post',
        data: formData,
        contentType: false,
        processData: false,
        success:function(res){
            console.log(res.data);
            if(res.code == 1){
                succMsg("导入成功")
            }else {
                if(res.msg == "") {
                    errMsg("导入失败");
                }else {
                    errMsg(res.msg);
                }
            }
        },
        error : function (error) {
            errMsg("网络异常");
        }
    })
}

/**
 * 二次封装jquery Ajax函数
 * @author 闫慧彬
 * @param options ajax参数
 */
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
/**
 * 输入 关键字 key 取得 url 中的相应 值，不输入关键字取得所有值。
 * @author 闫慧彬
 * @param key 关键字
 * @returns {*}
 */
function urlToData(key){
    var dataObj = {};
    var url = location.href;
    if(url.indexOf("?") == (-1)){
        return false;
    }
    var arr1 = url.split('?');
    var arr2 =  arr1[1].split('&');
    if(!arr2){
        return arr1.split('=')[1];
    }
    for(var i = 0; i < arr2.length; i++){
        var arr3 = arr2[i].split('=');
        dataObj[arr3[0]] = arr3[1];
    }
    if(key){
        return dataObj[key];
    }else {
        return dataObj;
    }
}

/**
 * 判断是否有值, 空值返回传入的字符串；
 * @author 闫慧彬
 * @param data 要判断的值
 * @param str 返回的字符串，为空则返回“”
 * @returns {*}
 */
function ifIsNull(data, str){
    if (data == null || data == undefined  || (data != 0 && data == "") || data == "null" || data == "false"|| data == "undefined" || data.length <= 0){
        if(str){
            return str;
        }
        else{
            return "";
        }
    }
    else
        return data;
}

/*
*   保存jsTree原始数据，去重连接
* */
function concatNoRepeat(mainArr,concatArray) {

    if(!Array.isArray(mainArr) || !Array.isArray(concatArray)) {
        return [];
    }

    for(let i = 0; i < mainArr.length; i++) {
        for(let j = 0; j < concatArray.length; j++) {
            if(mainArr[i].text == concatArray[j].text) {
                concatArray.splice(j,1);
                break;
            }
        }
    }

    return mainArr.concat(concatArray);
}

function get_unCheckNodes(checkNodes,allNodes) {

    if(!Array.isArray(checkNodes) || !Array.isArray(allNodes)) {
        return [];
    }

    for(let i = 0; i < checkNodes.length; i++){
        for(let j = 0; j < allNodes.length; j++) {
            if (allNodes[j].text == checkNodes[i].text) {
                allNodes.splice(j,1);
                break;
            }
        }
    }

    return allNodes;
}

function get_checkStruct(checkNodes) {
    if(!Array.isArray(checkNodes)) {
        return [];
    }

    let gradeNodes = [];

    for(let i = 0; i < checkNodes.length; i++){
        if(checkNodes[i].original.level == '0') {
            let gradeNode = {};
            gradeNode.grade = checkNodes[i].text;
            gradeNode.children = checkNodes[i].children_d;
            gradeNode.academy = [];
            gradeNode.major = [];
            gradeNode.classes = [];
            gradeNodes.push(gradeNode);
        }
    }

    for (let i = 0; i < checkNodes.length; i++) {
        for(let j = 0; j < gradeNodes.length; j++) {
            if(gradeNodes[j].children.indexOf(checkNodes[i].id) != -1) {
                if(checkNodes[i].original.level == '1') {
                    gradeNodes[j].academy.push("'" + checkNodes[i].text + "'");
                }else if(checkNodes[i].original.level == '2') {
                    gradeNodes[j].major.push("'" + checkNodes[i].text + "'");
                }else if(checkNodes[i].original.level == '3') {
                    gradeNodes[j].classes.push("'" + checkNodes[i].text + "'");
                }
            }
        }
    }

    for(let i = 0; i < gradeNodes.length; i++) {
        delete gradeNodes[i].children;
        gradeNodes[i].academy = gradeNodes[i].academy.join(",");
        gradeNodes[i].major = gradeNodes[i].major.join(",");
        gradeNodes[i].classes = gradeNodes[i].classes.join(",");
    }

    return gradeNodes;
}
/**
 * 时间格式化
 * 作者：闫慧彬
 * 用法：Date类型.Format(格式)
 * 例子：(new Date()).Format("yyyy年MM月dd日 hh:mm:ss")
 * 返回：2018年01月01日 00:00:00
 * */
Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}



