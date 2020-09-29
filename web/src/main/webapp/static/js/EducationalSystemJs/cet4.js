// 参数
let saveParam = {
    languageTjjl : {
        cet4 : '0',
        cet4PassScore : '',
        cet4LastExamTerm : '',
        cet4MissingExam : '',
        cet4PassedExam : '',
        cet6 : '',
        crt4 : '0',
        crt4PassScore : '',
        crt4LastExamTerm : '',
        crt4MissingExam : '',
        crt4PassedExam : '',
        russJoinCet4 : '',
        russianKch : '',
        crt6 : '',
        cjt4 : '0',
        cjt4PassScore : '',
        cjt4LastExamTerm : '',
        cjt4MissingExam : '',
        cjt4PassedExam : '',
        japaJoinCet4 : '',
        japaneseKch : '',
        cjt6 : '',
        cgt4 : '0',
        cgt4PassScore : '',
        cgt4LastExamTerm : '',
        cgt4MissingExam : '',
        cgt4PassedExam : '',
        germanJoinCet4 : '',
        germanKch : '',
        cgt6 : '',
        pretcoB : '0',
        pretcoPassScore : '',
        pretcoLastExamTerm : '',
        pretcoMissingExam : '',
        pretcoPassedExam : ''
    },
    languageTjjlStudent : {
        isFirstGrade : '',
        isSecondGrade : '',
        isThirdGrade : '',
        isFoGrade : '',
        isFifthGrade : '',
        firstGrade : '',
        benkeType : '',
        isJuniorFirstGrade : '',
        isJuniorSecondGrade : '',
        isJuniorThirdGrade : '',
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
        classA : '',
        classB : '',
        classC : '',
        classaEnglish : '',
        classbEnglish : '',
        classcEnglish : '',
        englisthSecondKch : '',
        englisthSecondZxjxjhh : '',
        classaSecondKxh : '',
        classbSecondKxh : '',
        classcSecondKxh : '',
        classSecondA : '',
        classSecondB : '',
        classSecondC : '',
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
// 整理保存参数数据
function cleanUpData(data) {

    let regExp_trim = /\s*/g;
    let regExp_comma = /，/g;

    saveParam.zxjxjhh = data.zxjxjhh;
    saveParam.firstGrade = data.firstGrade;
    saveParam.halfTerm = data.halfTerm;
    saveParam.lastExamTerm = data.lastExamTerm;
    saveParam.cet4PassScore = data.cet4PassScore;
    saveParam.crt4PassScore = data.crt4PassScore;
    saveParam.cjt4PassScore = data.cjt4PassScore;
    saveParam.firstIn = data.firstIn;

    saveParam.cet4Tytjjl.missingExam = data.missingExam;
    saveParam.cet4Tytjjl.passedExam = data.passedExam;
    saveParam.cet4Tytjjl.isJapanese = data.isJapanese;
    saveParam.cet4Tytjjl.isRussian = data.isRussian;
    saveParam.cet4Tytjjl.japaneseKch = data.japaneseKch.replace(regExp_trim,"").replace(regExp_comma,",");
    saveParam.cet4Tytjjl.russianKch = data.russianKch.replace(regExp_trim,"").replace(regExp_comma,",");
    saveParam.cet4Tytjjl.specialXsm = data.specialXsm.replace(regExp_trim,"").replace(regExp_comma,",");
    saveParam.cet4Tytjjl.cet3Score = data.cet3Score;

    if(data.halfTerm == "1") {
        saveParam.cet4FirstTerm.classaMin = data.classaMin;
        saveParam.cet4FirstTerm.classaMax = data.classaMax;
        saveParam.cet4FirstTerm.classbMin = data.classbMin;
        saveParam.cet4FirstTerm.classbMax = data.classbMax;
        saveParam.cet4FirstTerm.classcMin = data.classcMin;
        saveParam.cet4FirstTerm.classcMax = data.classcMax;

        saveParam.cet4SecondTerm = null;
    }else if(data.halfTerm == "2") {
        saveParam.cet4FirstTerm = null;

        saveParam.cet4SecondTerm.classaEnglishMin = data.classaEnglishMin;
        saveParam.cet4SecondTerm.classaEnglishMax = data.classaEnglishMax;
        saveParam.cet4SecondTerm.classbEnglishMin = data.classbEnglishMin;
        saveParam.cet4SecondTerm.classbEnglishMax = data.classbEnglishMax;
        saveParam.cet4SecondTerm.classcEnglishMin = data.classcEnglishMin;
        saveParam.cet4SecondTerm.classcEnglishMax = data.classcEnglishMax;
        saveParam.cet4SecondTerm.englisthKch = data.englisthKch;
        saveParam.cet4SecondTerm.englisthZxjxjhh = data.englisthZxjxjhh;
        saveParam.cet4SecondTerm.classaKxh = data.classaKxh.replace(regExp_trim,"").replace(regExp_comma,",");
        saveParam.cet4SecondTerm.classbKxh = data.classbKxh.replace(regExp_trim,"").replace(regExp_comma,",");
        saveParam.cet4SecondTerm.classcKxh = data.classcKxh.replace(regExp_trim,"").replace(regExp_comma,",");
    }
}
// 校验保存参数
function verifyData() {
    if(ifIsNull(saveParam.zxjxjhh) == '') {
        errMsg('请选择学期！');

        return false;
    }
    if(ifIsNull(saveParam.firstGrade) == '') {
        errMsg('请选择大一年级！');

        return false;
    }
    if(ifIsNull(saveParam.firstIn) == '') {
        errMsg('请选择大一是否考试！');

        return false;
    }
    if(ifIsNull(saveParam.halfTerm) == '') {
        errMsg('请选择上下学期！');

        return false;
    }
    if(ifIsNull(saveParam.lastExamTerm) == '') {
        errMsg('请填写上一次考试时间！');

        return false;
    }
    if(ifIsNull(saveParam.cet4PassScore) == '') {
        errMsg('请填写英语四级通过分数！');

        return false;
    }
    if(ifIsNull(saveParam.crt4PassScore) == '') {
        errMsg('请填写俄语四级通过分数！');

        return false;
    }
    if(ifIsNull(saveParam.cjt4PassScore) == '') {
        errMsg('请填写日语四级通过分数！');

        return false;
    }

    for (let cet4TytjjlKey in saveParam.cet4Tytjjl) {
        if(ifIsNull(saveParam.cet4Tytjjl[cet4TytjjlKey]) == '') {
            errMsg('通用条件不能为空！');

            return false;
        }
    }

    if(saveParam.halfTerm == 1) {
        for (let cet4FirstTermKey in saveParam.cet4FirstTerm) {
            if(ifIsNull(saveParam.cet4FirstTerm[cet4FirstTermKey]) == '') {
                errMsg('上学期条件不能为空！');

                return false;
            }
        }
    }else {
        for (let cet4SecondTermKey in saveParam.cet4SecondTerm) {
            if(ifIsNull(saveParam.cet4SecondTerm[cet4SecondTermKey]) == '') {
                errMsg('上学期条件不能为空！');

                return false;
            }
        }
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

    // 选择大一考试特殊条件
    $('#dataSource').click(function () {
        let dataSourceSelectValue = $('#dataSource').val();
        if(dataSourceSelectValue == 2) {
            $('#englisthKch').removeAttr("disabled");
            $('#classaKxh').removeAttr("disabled");
            $('#classbKxh').removeAttr("disabled");
            $('#classcKxh').removeAttr("disabled");
        }else {
            $('#englisthKch').attr("disabled",true);
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
    // 提交保存
    $('#saveCondition').click(function () {
        let serializeObject = $('#form-member-add').serializeObject();
        console.log("serializeObject",serializeObject);
/*        cleanUpData(serializeObject);
        if(verifyData()) {
            $.request({
                url : '/cet4tj/save',
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
        }*/
    });
});