
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

var bktjForm = {
    bkdx : '',
    zxnj : '',
    zxjxjhh : '',
    sxqzxjxjhh : '',
    bkfs : '',
    bklx : '',
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
                $('#term').html(options);
                $('#prev-term').html(options);
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

            $('#grade').addClass("disabled");
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

    if($('#students').prop('checked') == false && $('#graduate').prop('checked') == false) {
        msg('补考对象必选',option);
        return false;
    }
    if($('#students').prop('checked') && gradeChoose == '') {
        msg('补考年级必选',option);
        return false;
    }
    if($('#term').val() == '') {
        msg('本学期必选',option);
        return false;
    }
    if($('#prev-term').val() == '') {
        msg('上学期必选',option);
        return false;
    }
    if($('#makeup-score').val() == '') {
        msg('补考分数必填',option);
        return false;
    }

    return true;
}

function tidyData(){
    var gradeChoose = '';
    bktjForm.bkdx = [];
    if($('#students').prop('checked')) {
        bktjForm.bkdx.push($('#students').val());
        gradeChoose = grades.get_form_value('grade');
    }
    if($('#graduate').prop('checked')) {
        bktjForm.bkdx.push($('#graduate').val());
    }
    bktjForm.bkdx = bktjForm.bkdx.join();
    bktjForm.zxnj = gradeChoose;
    bktjForm.zxjxjhh = $('#term').val();
    bktjForm.sxqzxjxjhh = $('#prev-term').val();
    bktjForm.bkfs = $('#makeup-score').val();
    bktjForm.bklx = $('input[name="bklx"]:checked').val();
}

// 全局方法
$(function () {
    // 调用方法初始化学期下拉框
    getTermInfo();

    // 调用方法初始化年级下拉框
    getGradeInfo();

    $('#student-type input').iCheck({
        checkboxClass: 'icheckbox-blue',
    });

    $('#makeup-type input').iCheck({
        radioClass: 'iradio-blue',
    });
});

// 为在校生绑定check事件，以便打开选择年级
$('#students').on('ifChecked',function () {
    $('#grade').removeClass("disabled");
    $('.verjs-select').attr('style','background-color:rgba(0,0,0,0);');
})

// 为在校生绑定unchecked事件，以便关闭选择年级
$('#students').on('ifUnchecked',function () {
    $('#grade').addClass("disabled");
    $('.verjs-select').attr('style','background-color:rgba(0,0,0,.1);');
})

// 提交表单
$('#submit').click(function () {
    // 校验数据
    if(verifyData()) {
        // 整理数据
        tidyData();
        $.request({
            url : '/bktjjl/save',
            type : "POST",
            data : JSON.stringify(bktjForm),
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

