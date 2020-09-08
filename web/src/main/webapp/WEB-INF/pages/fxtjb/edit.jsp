<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <script src="${ctx}/static/verSelector/verSelect.2.0.js"></script>
    <title></title>
    <style>
        .disabled {
            pointer-events: none;
            color: grey;
            cursor: url("${ctx}/static/img/disabled.ico"),default;
        }
    </style>
</head>
<body>
<article class="page-container">
    <form id="form-member-add">
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">本学期：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <span class="select-box radius">
                  <select class="select" size="1" name="zxjxjhh" id="term">
                    <option value="" selected>请选择学期</option>
                  </select>
                </span>
            </div>
        </div>
        <div id="makeup-grade" class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">补考年级：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <div id="grade" class=""></div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-7 col-sm-7 col-xs-offset-5 col-sm-offset-5 mt-10">
                <input type="button" id="submit" class="btn btn-primary radius" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>
</body>
<script type="text/javascript">

    let verSelectorOption = {
        elem : "#grade",
        data : [],
        body_height : 200,
        checkbox: true,
        placeholder : "请选择年级",
        search_text : "请输入所有年级",
        empty_search : "没有您想要的信息"
    };

    let fxtjForm = {
        zxjxjhh : '',
        grade : '',
        status : 1
    }

    $(function () {
        getTermInfo();

        getGradeInfo();
    });

    // 提交表单
    $('#submit').click(function () {
        // 校验数据
        if(verifyData()) {
            // 整理数据
            tidyData();
            $.request({
                url : '/fxtjb/save',
                type : "POST",
                data : JSON.stringify(fxtjForm),
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
            msg('补考年级必选',option);
            return false;
        }
        if($('#term').val() == '') {
            msg('本学期必选',option);
            return false;
        }

        return true;
    }

    function tidyData(){
        var gradeChoose = '';
        gradeChoose = grades.get_form_value('grade');
        fxtjForm.zxjxjhh = $('#term').val();
        fxtjForm.grade = gradeChoose;
    }
</script>
</html>
