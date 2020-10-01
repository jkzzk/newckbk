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
        <input type="hidden" id="xsTypeId" name="id" value="${xstype.id}">
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">学生类别所属级别：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <span class="select-box radius">
                  <select class="select" size="1" name="typeAttr" id="typeAttr">
                    <option value= "-1" <c:if test="${xstype == null}">selected</c:if>>请选择级别</option>
                    <option value="1" <c:if test="${xstype.typeAttr == 1}">selected</c:if>>本科</option>
                    <option value="2" <c:if test="${xstype.typeAttr == 2}">selected</c:if>>专科</option>
                  </select>
                </span>
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">学生类别代码：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <input type="text" id="typeId" placeholder="类别代码" class="input-text radius" value="${xstype.typeId}">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">学生类别名称：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <input type="text" id="typeName" placeholder="类别名称" class="input-text radius" value="${xstype.typeName}">
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
    var xstype = {
        id : "",
        typeId: "",
        typeName: "",
        typeAttr: "",
    }
    $('#submit').click(function () {
        xstype.id = $('#xsTypeId').val();
        xstype.typeId = $('#typeId').val();
        xstype.typeName = $('#typeName').val();
        xstype.typeAttr = $('#typeAttr').val();
        $.request({
            url : '/xstype/save',
            type : "POST",
            data : JSON.stringify(xstype),
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
