<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title></title>
</head>
<body>
<article class="page-container">
    <form id="form-member-add">
        <input type="hidden" value="${langExam.id}" name="id">
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">学期：</label>
            <div class="formControls col-xs-10 col-sm-10">
               <span class="select-box">
                  <select class="select" size="1" name="zxjxjhh">
                      <option value="" <c:if test="${langExam.id == null}">selected</c:if>>请选择学期</option>
                      <c:forEach var="t" items="${term}" >
                          <option value="${t.zxjxjhh}" <c:if test="${langExam.zxjxjhh == t.zxjxjhh}">selected</c:if>>${t.zxjxjhm}</option>
                      </c:forEach>
                  </select>
                </span>
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">语种类型：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <span class="select-box radius">
                    <select class="select" size="1" name="type">
                        <option value="" <c:if test="${langExam.type == null}">selected</c:if>>请选择语种类型</option>
                        <option value="CET4" <c:if test="${langExam.type == 'CET4'}">selected</c:if>>CET4</option>
                        <option value="CET6" <c:if test="${langExam.type == 'CET6'}">selected</c:if>>CET6</option>
                        <option value="CRT4" <c:if test="${langExam.type == 'CRT4'}">selected</c:if>>CRT4</option>
                        <option value="CRT6" <c:if test="${langExam.type == 'CRT6'}">selected</c:if>>CRT6</option>
                        <option value="CJT4" <c:if test="${langExam.type == 'CJT4'}">selected</c:if>>CJT4</option>
                        <option value="CJT6" <c:if test="${langExam.type == 'CJT6'}">selected</c:if>>CJT6</option>
                    </select>
                </span>
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">校区代码：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写校区代码" name="xxdm" value="${langExam.xxdm}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">学号：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写学号" name="xh" value="${langExam.xh}" class="input-text radius size-M">
            </div>
        </div>        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">姓名：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写姓名" name="xm" value="${langExam.xm}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">性别：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <div class="radio-box">
                    <input type="radio" id="sex-male" value="1" checked name="xb">
                    <label for="sex-male">男</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="sex-female" value="2" name="xb">
                    <label for="sex-female">女</label>
                </div>
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">证件类型：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <span class="select-box radius">
                    <select class="select" size="1" name="zylb">
                        <option value="1" selected>身份证</option>
                    </select>
                </span>
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">证件号：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写证件号" name="sfzh" value="${langExam.sfzh}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">学历：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <span class="select-box radius">
                    <select class="select" size="1" name="xl">
                        <option value="" <c:if test="${langExam.xl == null}">selected</c:if>>请选择学历</option>
                        <option value="10" <c:if test="${langExam.xl == '10'}">selected</c:if>>研究生</option>
                        <option value="20" <c:if test="${langExam.xl == '20'}">selected</c:if>>本科</option>
                        <option value="30" <c:if test="${langExam.xl == '30'}">selected</c:if>>专科</option>
                    </select>
                </span>
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">学制：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <span class="select-box radius">
                    <select class="select" size="1" name="xz">
                        <option value="" <c:if test="${langExam.xz == null}">selected</c:if>>请选择学制</option>
                        <option value="3" <c:if test="${langExam.xz == '3'}">selected</c:if>>3年</option>
                        <option value="4" <c:if test="${langExam.xz == '4'}">selected</c:if>>4年</option>
                        <option value="5" <c:if test="${langExam.xz == '5'}">selected</c:if>>5年</option>
                    </select>
                </span>
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">入学年份：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写入学年份" name="rxnf" value="${langExam.rxnf}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">年级(年份后两位)：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写年级" name="nj" value="${langExam.nj}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">学院名称：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写学院名称" name="xsm" value="${langExam.xsm}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">专业名称：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写专业名称" name="zym" value="${langExam.zym}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">班级名称：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写班级名称" name="bjh" value="${langExam.bjh}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">学籍代码：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写学籍代码" name="xjdm" value="${langExam.xjdm}" class="input-text radius size-M">
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
    $('#submit').click(function () {
        var data = $("#form-member-add").serializeObject();
        for(let pro in data) {
            if(ifIsNull(data[pro]) == '' && pro != "id") {
                errMsg("有字段为空！");
                return ;
            }
        }
        $.request({
            url : '/langExam/save',
            type : "POST",
            data : JSON.stringify(data),
            contentType: 'application/json;charset=UTF-8',
            dataType: 'json',
            success : function(result) {
                if(result.code == 1) {
                    succMsg(result.msg);
                }else {
                    errMsg("保存失败！");
                }
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
    });
</script>
</html>
