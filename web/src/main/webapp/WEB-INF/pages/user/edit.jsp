<%--
  Created by IntelliJ IDEA.
  User: jkzzk
  Date: 2017/8/21
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
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
    <form action="/user/save" method="post" class="form form-horizontal" id="form-member-add">
        <input type="hidden" value="${user.id}" name="id">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${user.loginName}" <c:if test="${user.id > 0}">disabled</c:if> placeholder="" id="loginName" name="loginName">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>真实姓名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${user.realName}" placeholder="" id="realName" name="realName">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">用户类型：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <select name="roleIds" id="" class="input-text">
                    <option value="">请选择用户类型</option>
                    <c:forEach items="${roles}" var="r">
                        <option value="${r.id}" <c:if test="${r.id == user.roleIds}">selected</c:if>>${r.roleName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">备注：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <textarea name="remark" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" >${user.remark}</textarea>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>
</body>
<script type="text/javascript">
    $(function(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });

        $("#form-member-add").validate({
            rules:{
                loginName:{
                    required:true,
                    minlength:2,
                    maxlength:16,
                    remote: {
                        url: "/user/exist",
                        type: "post",
                        async:false,
                        dataType: "json",
                        data: {
                            loginName:function () {
                                return $("#loginName").val();
                            }
                        },
                        dataFilter: function (data) {
                            data = JSON.parse(data)
                            if(data.code == 2) {
                                return false;
                            }
                            return true;
                        }

                    }
                },
                realName:{
                    required:true,
                }
            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                $.ajax({
                    type: 'post',
                    url: '/user/save',
                    data: $(form).serializeArray(),
                    success:function (data) {
                        succMsg(data.msg);
                        setTimeout(function () {
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.$('#btn-refresh').click();
                            parent.layer.close(index);
                        },1000)
                    },
                    error:function (data) {
                        errMsg("网络异常");
                    }
                });

            }
        });
    });
</script>
</html>
