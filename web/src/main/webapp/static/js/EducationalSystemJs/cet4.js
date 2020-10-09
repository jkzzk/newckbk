// 参数
let saveParam = {
    languageTjjl : {
        cet4 : '0',
        cet4PassScore : '',
        cet4LastExamTerm : '0',
        cet4MissingExam : '0',
        cet4PassedExam : '0',
        cet6 : '0',
        crt4 : '0',
        crt4PassScore : '',
        crt4LastExamTerm : '',
        crt4MissingExam : '0',
        crt4PassedExam : '0',
        russJoinCet4 : '0',
        russianKch : '',
        crt6 : '0',
        cjt4 : '0',
        cjt4PassScore : '',
        cjt4LastExamTerm : '',
        cjt4MissingExam : '0',
        cjt4PassedExam : '0',
        japaJoinCet4 : '0',
        japaneseKch : '',
        cjt6 : '0',
        cgt4 : '0',
        cgt4PassScore : '',
        cgt4LastExamTerm : '',
        cgt4MissingExam : '0',
        cgt4PassedExam : '0',
        germanJoinCet4 : '0',
        germanKch : '',
        cgt6 : '0',
        pretcoB : '0',
        pretcoPassScore : '',
        pretcoLastExamTerm : '',
        pretcoMissingExam : '0',
        pretcoPassedExam : '0'
    },
    languageTjjlStudent : {
        isFirstGrade : '0',
        isSecondGrade : '0',
        isThirdGrade : '0',
        isFoGrade : '0',
        isFifthGrade : '0',
        firstGrade : '',
        benkeType : '',
        isJuniorFirstGrade : '0',
        isJuniorSecondGrade : '0',
        isJuniorThirdGrade : '0',
        juniorFirstGrade : '',
        juniorType : '',
        specialXsm : ''
    },
    languageTjjlSpecial : {
        dataSource : '',
        englisthKch : '',
        englisthZxjxjhh : '',
        classaKxh : '',
        classbKxh : '',
        classcKxh : '',
        classA : '0',
        classB : '0',
        classC : '0',
        classaEnglish : '',
        classbEnglish : '',
        classcEnglish : '',
        englisthSecondKch : '',
        englisthSecondZxjxjhh : '',
        classaSecondKxh : '',
        classbSecondKxh : '',
        classcSecondKxh : '',
        classSecondA : '0',
        classSecondB : '0',
        classSecondC : '0',
        classaSecondEnglish : '',
        classbSecondEnglish : '',
        classcSecondEnglish : ''
    }
}

// 获取所有学期
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
                $('#examTerm').html(options);
                $('#examSecondTerm').html(options);
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
// 获取所有年级
function getGradeInfo() {
    $.request({
        url : '/grade/getAllGrade',
        type : "POST",
        contentType: 'application/json;charset=UTF-8',
        dataType: 'json',
        success : function(result) {
            var res_data = result.data;
            if(Array.isArray(res_data)) {
                var options = "<option value='' selected>请选择大一年级</option>";
                for(var i = 0; i < res_data.length; i++) {
                    options += "<option value='"+ res_data[i].njmc +"'>"+ res_data[i].njmc +"</option>";
                }
                $('#firstGrade').html(options);
                $('#juniorFirstGrade').html(options);
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
// 获取所有特殊学院
function getSpecialXy() {
    $.request({
        url : '/specialxy/getAll',
        type : "POST",
        contentType: 'application/json;charset=UTF-8',
        dataType: 'json',
        success : function(result) {
            var res_data = result.data;
            if(Array.isArray(res_data) && res_data.length != 0) {
                var options = "";
                for(var i = 0; i < res_data.length; i++) {
                    options += '<div class="formControls col-xs-1 col-sm-1 mt-10">\n' +
                        '<input type="checkbox" class="check-box" value="\'' + res_data[i].xyName + '\'" name="specialXsm">\n' +
                        '<label>' + res_data[i].xyName + '</label>\n' +
                        '</div>';
                }
                $('#specialxyContent').append(options);
            }
        },
        error:function (message) {
            console.log(message);
            errMsg("网络异常");
        }
    });
}
// 获取所有本科学生类别
function getXsType(index) {
    $.request({
        url : '/xstype/getAll?typeAttr='+index,
        type : "POST",
        contentType: 'application/json;charset=UTF-8',
        dataType: 'json',
        success : function(result) {
            let _typeName = "";
            if(index == 1) {
                _typeName = "benkeType";
            }else {
                _typeName = "juniorType";
            }
            var res_data = result.data;
            if(Array.isArray(res_data) && res_data.length != 0) {
                var options = "";
                for(var i = 0; i < res_data.length; i++) {
                    options += '<div class="formControls col-xs-1 col-sm-1 mt-10">\n' +
                        '<input type="checkbox" class="check-box" name="' + _typeName + '" value="'+ res_data[i].typeId +'" checked>\n' +
                        '<label >' + res_data[i].typeName + '</label>\n' +
                        '</div>'
                }
                if(index == 1) {
                    $('#benkeTypeContent').append(options);
                }else {
                    $('#juniorTypeContent').append(options);
                }
            }else {
                $('#specialxyTab').attr("style","display:none;")
            }
        },
        error:function (message) {
            console.log(message);
            errMsg("网络异常");
        }
    });
}
// 整理保存参数数据
function cleanUpData(data) {

    let regExp_trim = /\s*/g;
    let regExp_comma = /，/g;

    // 将表单数据整理成后台所需格式数据(变形拷贝)
    for(let propName in data) {
        if(saveParam.languageTjjl.hasOwnProperty(propName)) {
            saveParam.languageTjjl[propName] = data[propName];
        }else if(saveParam.languageTjjlSpecial.hasOwnProperty(propName)) {
            saveParam.languageTjjlSpecial[propName] = data[propName];
        }else if(saveParam.languageTjjlStudent.hasOwnProperty(propName)) {
            saveParam.languageTjjlStudent[propName] = data[propName];
        }
    }

    // 将输入逗号分隔的字符串，统一替换为英文逗号
    saveParam.languageTjjl.japaneseKch = saveParam.languageTjjl.japaneseKch.replace(regExp_trim,"").replace(regExp_comma,",");
    saveParam.languageTjjl.russianKch = saveParam.languageTjjl.russianKch.replace(regExp_trim,"").replace(regExp_comma,",");
    saveParam.languageTjjl.germanKch = saveParam.languageTjjl.germanKch.replace(regExp_trim,"").replace(regExp_comma,",");
    saveParam.languageTjjlSpecial.classaKxh = saveParam.languageTjjlSpecial.classaKxh.replace(regExp_trim,"").replace(regExp_comma,",");
    saveParam.languageTjjlSpecial.classbKxh = saveParam.languageTjjlSpecial.classbKxh.replace(regExp_trim,"").replace(regExp_comma,",");
    saveParam.languageTjjlSpecial.classcKxh = saveParam.languageTjjlSpecial.classcKxh.replace(regExp_trim,"").replace(regExp_comma,",");
    saveParam.languageTjjlSpecial.classaSecondKxh = saveParam.languageTjjlSpecial.classaSecondKxh.replace(regExp_trim,"").replace(regExp_comma,",");
    saveParam.languageTjjlSpecial.classbSecondKxh = saveParam.languageTjjlSpecial.classbSecondKxh.replace(regExp_trim,"").replace(regExp_comma,",");
    saveParam.languageTjjlSpecial.classcSecondKxh = saveParam.languageTjjlSpecial.classcSecondKxh.replace(regExp_trim,"").replace(regExp_comma,",");
    // 将输入为数组形式的值，统一改为由逗号分隔的字符串
    if(ifIsNull(saveParam.languageTjjlStudent.specialXsm) != '' && Array.isArray(saveParam.languageTjjlStudent.specialXsm)) {
        saveParam.languageTjjlStudent.specialXsm = saveParam.languageTjjlStudent.specialXsm.join(",");
    }
    if(ifIsNull(saveParam.languageTjjlStudent.benkeType) != '' && Array.isArray(saveParam.languageTjjlStudent.benkeType)) {
        saveParam.languageTjjlStudent.benkeType = saveParam.languageTjjlStudent.benkeType.join(",");
    }
    if(ifIsNull(saveParam.languageTjjlStudent.juniorType) != '' && Array.isArray(saveParam.languageTjjlStudent.juniorType)) {
        saveParam.languageTjjlStudent.juniorType = saveParam.languageTjjlStudent.juniorType.join(",");
    }
}
// 校验保存参数
function verifyData() {

    if(ifIsNull(saveParam.languageTjjl.japaneseKch) == '') {
        errMsg("日语课程号为空！");
        return false;
    }
    if(ifIsNull(saveParam.languageTjjl.russianKch) == '') {
        errMsg("俄语课程号为空！");
        return false;
    }
    if(ifIsNull(saveParam.languageTjjl.germanKch) == '') {
        errMsg("德语课程号为空！");
        return false;
    }

    return true;
}

$(function () {

    // 折叠控件渲染
    $('dl#my-foldpanel').foldpanel({
        init:false,     	 //是否开启初始化功能,默认关闭
        init_index: 0, // 传的数字代表初始化展开的索引，0就是第一个
        time: 400, // panel展开动画时间, 默认为 100ms
        dbclose: true // 在此点击关闭, 默认为 true
    });

    // 勾选cet4复选框事件
    $('#cet4').click(function () {
        let isCet4CheckBoxChecked = $('#cet4').is(':checked');
        if(isCet4CheckBoxChecked) {
            $('#cet4PassScore').removeAttr('disabled');
            $('#cet4LastExamTerm').removeAttr('disabled');
            $('#cet4MissingExam').removeAttr('disabled');
            $('#cet4PassedExam').removeAttr('disabled');
            $('#russJoinCet4').removeAttr('disabled');
            $('#japaJoinCet4').removeAttr('disabled');
            $('#germanJoinCet4').removeAttr('disabled');
        }else {
            $('#cet4PassScore').attr('disabled',true);
            $('#cet4LastExamTerm').attr('disabled',true);
            $('#cet4MissingExam').attr('disabled',true);
            $('#cet4PassedExam').attr('disabled',true);
            $('#russJoinCet4').attr('disabled',true);
            $('#japaJoinCet4').attr('disabled',true);
            $('#germanJoinCet4').attr('disabled',true);
        }
    });

    // 勾选crt4复选框事件
    $('#crt4').click(function () {
        let isCrt4CheckBoxChecked = $('#crt4').is(':checked');
        if(isCrt4CheckBoxChecked) {
            $('#crt4PassScore').removeAttr('disabled');
            $('#crt4LastExamTerm').removeAttr('disabled');
            $('#crt4MissingExam').removeAttr('disabled');
            $('#crt4PassedExam').removeAttr('disabled');
        }else {
            $('#crt4PassScore').attr('disabled',true);
            $('#crt4LastExamTerm').attr('disabled',true);
            $('#crt4MissingExam').attr('disabled',true);
            $('#crt4PassedExam').attr('disabled',true);
        }
    });

    // 勾选cjt4复选框事件
    $('#cjt4').click(function () {
        let isCjt4CheckBoxChecked = $('#cjt4').is(':checked');
        if(isCjt4CheckBoxChecked) {
            $('#cjt4PassScore').removeAttr('disabled');
            $('#cjt4LastExamTerm').removeAttr('disabled');
            $('#cjt4MissingExam').removeAttr('disabled');
            $('#cjt4PassedExam').removeAttr('disabled');
        }else {
            $('#cjt4PassScore').attr('disabled',true);
            $('#cjt4LastExamTerm').attr('disabled',true);
            $('#cjt4MissingExam').attr('disabled',true);
            $('#cjt4PassedExam').attr('disabled',true);
        }
    });

    // 勾选cgt4复选框事件
    $('#cgt4').click(function () {
        let isCgt4CheckBoxChecked = $('#cgt4').is(':checked');
        if(isCgt4CheckBoxChecked) {
            $('#cgt4PassScore').removeAttr('disabled');
            $('#cgt4LastExamTerm').removeAttr('disabled');
            $('#cgt4MissingExam').removeAttr('disabled');
            $('#cgt4PassedExam').removeAttr('disabled');
        }else {
            $('#cgt4PassScore').attr('disabled',true);
            $('#cgt4LastExamTerm').attr('disabled',true);
            $('#cgt4MissingExam').attr('disabled',true);
            $('#cgt4PassedExam').attr('disabled',true);
        }
    });

    // 勾选pretco-b复选框事件
    $('#pretco-b').click(function () {
        let isPretcoBCheckBoxChecked = $('#pretco-b').is(':checked');
        if(isPretcoBCheckBoxChecked) {
            $('#pretcoPassScore').removeAttr('disabled');
            $('#pretcoLastExamTerm').removeAttr('disabled');
            $('#pretcoMissingExam').removeAttr('disabled');
            $('#pretcoPassedExam').removeAttr('disabled');
        }else {
            $('#pretcoPassScore').attr('disabled',true);
            $('#pretcoLastExamTerm').attr('disabled',true);
            $('#pretcoMissingExam').attr('disabled',true);
            $('#pretcoPassedExam').attr('disabled',true);
        }
    });

    // 勾选大一是否参加考试，动态显示大一特殊条件
    $('#isFirstGrade').click(function () {
        let isFirstGradeChecked = $('#isFirstGrade').is(':checked');
        // console.log("isFirstGradeChecked",isFirstGradeChecked);
        if(!isFirstGradeChecked) {
            $('#firstGradeSpecial').attr("style","display:none;");
        }else {
            $('#firstGradeSpecial').attr("style","");
        }
    });

    // 勾选大二是否参加考试，动态显示大二特殊条件
    $('#isSecondGrade').click(function () {
        let isSecondGradeChecked = $('#isSecondGrade').is(':checked');
        if(!isSecondGradeChecked) {
            $('#secondGradeSpecial').attr("style","display:none;");
        }else {
            $('#secondGradeSpecial').attr("style","");
        }
    });

    // 选择大一考试筛选数据源
    $('#dataSource').click(function () {
        let dataSourceSelectValue = $('#dataSource').val();
        if(dataSourceSelectValue == 2) {
            $('#englisthKch').removeAttr("disabled");
            $('#examTerm').removeAttr("disabled");
            $('#classaKxh').removeAttr("disabled");
            $('#classbKxh').removeAttr("disabled");
            $('#classcKxh').removeAttr("disabled");
        }else {
            $('#englisthKch').attr("disabled",true);
            $('#examTerm').attr("disabled",true);
            $('#classaKxh').attr("disabled",true);
            $('#classbKxh').attr("disabled",true);
            $('#classcKxh').attr("disabled",true);
        }
    });

    // 选择A班学生,动态关闭打开A班成绩输入框
    $('#classA').click(function () {
        let isClassAChecked = $('#classA').is(':checked');
        if(isClassAChecked) {
            $('#classaEnglish').removeAttr("disabled");
        }else {
            $('#classaEnglish').attr("disabled",true);
        }
    });

    // 选择B班学生,动态关闭打开B班成绩输入框
    $('#classB').click(function () {
        let isClassBChecked = $('#classB').is(':checked');
        if(isClassBChecked) {
            $('#classbEnglish').removeAttr("disabled");
        }else {
            $('#classbEnglish').attr("disabled",true);
        }
    });

    // 选择C班学生,动态关闭打开C班成绩输入框
    $('#classC').click(function () {
        let isClassCChecked = $('#classC').is(':checked');
        if(isClassCChecked) {
            $('#classcEnglish').removeAttr("disabled");
        }else {
            $('#classcEnglish').attr("disabled",true);
        }
    });

    // 选择大二A班学生,动态关闭打开大二A班成绩输入框
    $('#classSecondA').click(function () {
        let isClassASecondChecked = $('#classA').is(':checked');
        if(isClassASecondChecked) {
            $('#classaSecondEnglish').removeAttr("disabled");
        }else {
            $('#classaSecondEnglish').attr("disabled",true);
        }
    });

    // 选择大二B班学生,动态关闭打开大二B班成绩输入框
    $('#classSecondB').click(function () {
        let isClassBSecondChecked = $('#classSecondB').is(':checked');
        if(isClassBSecondChecked) {
            $('#classbSecondEnglish').removeAttr("disabled");
        }else {
            $('#classbSecondEnglish').attr("disabled",true);
        }
    });

    // 选择大二C班学生,动态关闭打开大二C班成绩输入框
    $('#classSecondC').click(function () {
        let isClassCSecondChecked = $('#classSecondC').is(':checked');
        if(isClassCSecondChecked) {
            $('#classcSecondEnglish').removeAttr("disabled");
        }else {
            $('#classcSecondEnglish').attr("disabled",true);
        }
    });


    // 获取所有学期
    getTermInfo();
    // 获取所有年级
    getGradeInfo();
    // 获取所有特殊学院
    getSpecialXy();
    // 获取本科学生类别数据
    getXsType(1);
    getXsType(2);
    // 提交保存
    $('#saveCondition').click(function () {
        let serializeObject = $('#form-member-add').serializeObject();
        cleanUpData(serializeObject);
        if(verifyData()) {
            console.log("saveParam",saveParam);
            $.request({
                url : '/languageTj/save',
                type : "POST",
                data : JSON.stringify(saveParam),
                contentType: 'application/json;charset=UTF-8',
                dataType: 'json',
                success : function(result) {
                    if(result.code == 1) {
                        succMsg(result.msg);
                    }else {
                        errMsg("操作失败！")
                    }
                    setTimeout(function () {
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.$('#btn-refresh').click();
                        parent.layer.close(index);
                    },1000);
                },
                error:function (message) {
                    console.log(message);
                    errMsg("网络异常");
                }
            });
        }
    });
});