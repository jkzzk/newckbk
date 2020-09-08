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
        <input type="hidden" value="${zyfxxxb.id}" name="id">
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">学院名称：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <input type="text" placeholder="请填写学院名称" name="xsm" value="${zyfxxxb.xsm}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">专业名称：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <input type="text" placeholder="请填写专业名称" name="zym" value="${zyfxxxb.zym}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">学科分类：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <input type="text" placeholder="请填写学科分类" name="xkfl" value="${zyfxxxb.xkfl}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">录取批次代码：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <input type="text" placeholder="请填写录取批次代码" name="lqdm" value="${zyfxxxb.lqdm}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">录取批次名称：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <input type="text" placeholder="请填写录取批次代码" name="lqpc" value="${zyfxxxb.lqpc}" class="input-text radius size-M">
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
        console.log("data",data);
        for(let pro in data) {
            if(pro == "id") {
                continue ;
            }
            if(data[pro] == null || data[pro] == "") {
                errMsg("有字段为空！");
                return ;
            }
        }
        $.request({
            url : '/zyfxxxb/save',
            type : "POST",
            data : JSON.stringify(data),
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
