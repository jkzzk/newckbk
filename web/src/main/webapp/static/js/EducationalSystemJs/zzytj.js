var verSelectorOption = {
    elem : "#grade",
    data : [],
    body_height : 200,
    checkbox: true,
    placeholder : "请选择年级",
    search_text : "请输入所有年级",
    empty_search : "没有您想要的信息"
};

var grades = {};

var zzytjForm = {
    zxjxjhh : '',
    grades : '',
    status : 1
};

function getTermInfo() {
    $.request({
        url : '/term/getAllTerm',
        type : "POST",
        contentType: 'application/json;charset=UTF-8',
        dataType: 'json',
        success : function(result) {
            var res_data = result.data;
            if(Array.isArray(res_data)) {
                var options = "<option value='' selected>请选择学期</option>";
                for(var i = 0; i < res_data.length; i++) {
                    options += "<option value='"+ res_data[i].zxjxjhh +"'>"+ res_data[i].zxjxjhm +"</option>";
                }
                $('#currentTerm').html(options);
            }else {
                console.log("/term/getAllTerm : 返回数据错误");
            }
        },
        error:function (message) {
            console.log(message);
            errMsg("网络异常");
        }
    });
}

function getGradeInfo() {
    $.request({
        url : '/grade/getAllGrade',
        type : "POST",
        contentType: 'application/json;charset=UTF-8',
        dataType: 'json',
        success : function(result) {
            var res_data = result.data;
            if(Array.isArray(res_data)) {
                var data = new Array();
                data.push();
                for(var i = 0; i < res_data.length; i++) {
                    var _obj = {
                        id : res_data[i].njmc,
                        name : res_data[i].njmc
                    }
                    data.push(_obj);
                }
                verSelectorOption.data = data;
            }else {
                console.log("/grade/getAllGrade : 返回数据错误");
            }

            grades = new verjs_select();

            grades.render(verSelectorOption);

            $('.verjs-select').attr('style','background-color:rgba(0,0,0,.1);');
        },
        error:function (message) {
            console.log(message);
            errMsg("网络异常");
        }
    });
}

function verifyData() {
    var option = {icon:3,time:2000};
    var gradeChoose = grades.get_form_value('grade');

    if(gradeChoose == '') {
        msg('转专业年级必选',option);
        return false;
    }
    if($('#currentTerm').val() == '') {
        msg('本学期必选',option);
        return false;
    }

    return true;
}

function tidyData(){
    var gradeChoose = grades.get_form_value('grade');

    zzytjForm.grades = gradeChoose;
    zzytjForm.zxjxjhh = $('#currentTerm').val();
}

// 全局方法
$(function () {
    // 调用方法初始化学期下拉框
    getTermInfo();

    // 调用方法初始化年级下拉框
    getGradeInfo();
});

// 提交表单
$('#submit').click(function () {
    // 校验数据
    if(verifyData()) {
        // 整理数据
        tidyData();
        $.request({
            url : '/zzytjjl/save',
            type : "POST",
            data : JSON.stringify(zzytjForm),
            contentType: 'application/json;charset=UTF-8',
            dataType: 'json',
            success : function(result) {
                succMsg(result.msg);
                setTimeout(function () {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.$('#btn-refresh').click();
                    parent.layer.close(index);
                },1000)
            },
            error:function (message) {
                console.log(message);
                errMsg("网络异常");
            }
        });
    }
});