// 参数
let saveParam = {
    zxjxjhh : "",
    firstGrade: "",
    halfTerm: "",
    lastExamTerm: "",
    cet4PassScore: "",
    crt4PassScore: "",
    cjt4PassScore: "",
    firstIn : "",
    status : "1",
    cet4Tytjjl : {
        missingExam : "",
        passedExam : "",
        isJapanese: "",
        isRussian: "",
        japaneseKch: "",
        russianKch: "",
        specialXsm: "",
        cet3Score: "",
    },
    cet4FirstTerm: {
        classaMin: "",
        classaMax: "",
        classbMin: "",
        classbMax: "",
        classcMin: "",
        classcMax: "",
    },
    cet4SecondTerm : {
        classaEnglishMin: "",
        classaEnglishMax: "",
        classbEnglishMin: "",
        classbEnglishMax: "",
        classcEnglishMin: "",
        classcEnglishMax: "",
        classaKxh: "",
        classbKxh: "",
        classcKxh: "",
        englisthKch: "",
        englisthZxjxjhh: "",
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
    // 获取所有学期
    getTermInfo();
    // 获取所有年级
    getGradeInfo();
    // 提交保存
    $('#submit').click(function () {
        let serializeObject = $('#form-member-add').serializeObject();
        cleanUpData(serializeObject);
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
        }
    });
});