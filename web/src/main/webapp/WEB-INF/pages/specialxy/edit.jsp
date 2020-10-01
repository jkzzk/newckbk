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
        <input type="hidden" id="specialxyId" name="id" value="${specialxy.id}">
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">特殊学院名称：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <input type="text" id="xyName" placeholder="学院名称" class="input-text radius" value="${specialxy.xyName}">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">是否启用：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <span class="select-box radius">
                  <select class="select" size="1" name="isEnable" id="isEnable">
                    <option value= "-1" <c:if test="${specialxy == null}">selected</c:if>>请选择是否启用</option>
                    <option value="1" <c:if test="${specialxy.isEnable == 1}">selected</c:if>>启用</option>
                    <option value="0" <c:if test="${specialxy.isEnable == 0}">selected</c:if>>禁用</option>
                  </select>
                </span>
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
    var specialXy = {
        id : "",
        xyName: "",
        isEnable: "",
    }
    $('#submit').click(function () {
        specialXy.id = $('#specialxyId').val();
        specialXy.xyName = $('#xyName').val();
        specialXy.isEnable = $('#isEnable').val();
        if(specialXy.isEnable == -1) {
            errMsg("请选择是否启用");
            return;
        }
        $.request({
            url : '/specialxy/save',
            type : "POST",
            data : JSON.stringify(specialXy),
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
