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
        <input type="hidden" value="${course.id}" name="id">
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">学期：</label>
            <div class="formControls col-xs-10 col-sm-10">
               <span class="select-box">
                  <select class="select" size="1" name="jxjhh">
                      <option value="" <c:if test="${course.id == null}">selected</c:if>>请选择学期</option>
                      <c:forEach var="t" items="${term}" >
                          <option value="${t.zxjxjhh}" <c:if test="${course.jxjhh == t.zxjxjhh}">selected</c:if>>${t.zxjxjhm}</option>
                      </c:forEach>
                  </select>
                </span>
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">学院名称：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写学院名称" name="xsm" value="${course.xsm}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">课程号：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写课程号" name="kch" value="${course.kch}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">课程名称：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写课程名称" name="kcm" value="${course.kcm}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">课程属性：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写课程属性" name="kcsx" value="${course.kcsx}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">学时：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写学时" name="xs" value="${course.xs}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">学分：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写学分" name="xf" value="${course.xf}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">考试类型：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" placeholder="请填写考试类型" name="kslx" value="${course.kslx}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">是否补考：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <span class="select-box">
                  <select class="select" size="1" name="sfzzbk">
                      <option value="是" <c:if test="${course.sfzzbk == '是'}">selected</c:if>>是</option>
                      <option value="否" <c:if test="${course.sfzzbk == '否'}">selected</c:if>>否</option>
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
    $('#submit').click(function () {
        var data = $("#form-member-add").serializeObject();
/*        for(let pro in data) {
            if(data[pro] == null || data[pro] == "") {
                errMsg("有字段为空！");
                return ;
            }
        }*/
        $.request({
            url : '/bkkcxxb/save',
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
