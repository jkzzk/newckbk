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
        <input type="hidden" value="${cetStufbcj.id}" name="id">
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">学期：</label>
            <div class="formControls col-xs-10 col-sm-10">
               <span class="select-box">
                  <select class="select" size="1" name="zxjxjhh">
                      <option value="" <c:if test="${cetStufbcj.id == null}">selected</c:if>>请选择学期</option>
                      <c:forEach var="t" items="${term}" >
                          <option value="${t.zxjxjhh}" <c:if test="${cetStufbcj.zxjxjhh == t.zxjxjhh}">selected</c:if>>${t.zxjxjhm}</option>
                      </c:forEach>
                  </select>
                </span>
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">课程号：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写课程号" name="kch" value="${cetStufbcj.kch}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">课程名称：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写课程名称" name="kcmc" value="${cetStufbcj.kcmc}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">课序号：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写课序号" name="kxh" value="${cetStufbcj.kxh}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">学号：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写学号" name="xh" value="${cetStufbcj.xh}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">姓名：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写姓名" name="xm" value="${cetStufbcj.xm}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">班级号：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写班级号" name="bjh" value="${cetStufbcj.bjh}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">分班等级：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写分班等级" name="fbdj" value="${cetStufbcj.fbdj}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">等级成绩：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写等级成绩" name="djcj" value="${cetStufbcj.djcj}" class="input-text radius size-M">
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
            if(ifIsNull(data[pro]) == '' && pro != "id") {
                errMsg("有字段为空！");
                return ;
            }
        }
        $.request({
            url : '/cetyyfbcj/save',
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
