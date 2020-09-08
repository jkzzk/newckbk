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
        <input type="hidden" id="majorId" name="id" value="${major.id}">
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">学院名称：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <input type="text" id="xsm" placeholder="学院名称" class="input-text radius" value="${major.xsm}">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">专业名称：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <input type="text" id="zym" placeholder="专业名称" class="input-text radius" value="${major.zym}">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">考生类别：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <input type="text" id="xkfl" placeholder="考生类别" class="input-text radius" value="${major.xkfl}">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">录取批次代码：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <input type="text" id="lqdm" placeholder="录取批次代码" class="input-text radius" value="${major.lqdm}">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">录取批次：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <input type="text" id="lqpc" placeholder="录取批次" class="input-text radius" value="${major.lqpc}">
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
    var zyxxb = {
        id : "",
        xsm : "",
        zym : "",
        xkfl : "",
        lqdm : "",
        lqpc : "",
    }
    $('#submit').click(function () {
        zyxxb.id = $('#majorId').val();
        zyxxb.xsm = $('#xsm').val();
        zyxxb.zym = $('#zym').val();
        zyxxb.xkfl = $('#xkfl').val();
        zyxxb.lqdm = $('#lqdm').val();
        zyxxb.lqpc = $('#lqpc').val();
        $.request({
            url : '/zyxxb/save',
            type : "POST",
            data : JSON.stringify(zyxxb),
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
    });
</script>
</html>
