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
    <style type="text/css">
        .title-bkc {
            background-color: #F5FAFE;
        }
    </style>
</head>
<body>
<article class="page-container">
    <form id="form-member-add">
        <input type="hidden" id="id" name="id" value="${xszzyxxb.id}">
        <div <c:if test="${xszzyxxb.id == null}">style="display: none;"</c:if>>
            <div class="row cl mt-30" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
                <label class="col-xs-2 col-sm-2 f-10 text-r title-bkc radius">学生学号：</label>
                <div class="col-xs-2 col-sm-2 f-10 text-l">${xszzyxxb.xh}</div>
                <label class="col-xs-2 col-sm-2 f-10 text-r title-bkc radius">学生姓名：</label>
                <div class="col-xs-2 col-sm-2 f-10 text-l ">${xszzyxxb.xm}</div>
                <label class="col-xs-2 col-sm-2 f-10 text-r title-bkc radius">学生班级：</label>
                <div class="col-xs-2 col-sm-2 f-10 text-l">${xszzyxxb.bjh}</div>
            </div>
            <div class="row cl mt-10" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
                <label class="col-xs-2 col-sm-2 f-10 text-r title-bkc radius">当前学生年级：</label>
                <div class="col-xs-2 col-sm-2 f-10 text-l">${xszzyxxb.dqnj}</div>
                <label class="col-xs-2 col-sm-2 f-10 text-r title-bkc radius">当前学生学院：</label>
                <div class="col-xs-2 col-sm-2 f-10 text-l">${xszzyxxb.currentXsm}</div>
                <label class="col-xs-2 col-sm-2 f-10 text-r title-bkc radius">当前学生专业：</label>
                <div class="col-xs-2 col-sm-2 f-10 text-l">${xszzyxxb.currentZym}</div>
            </div>
        </div>
        <div <c:if test="${xszzyxxb.id != null}">style="display: none;"</c:if>>
            <div class="row cl mt-10" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
                <label class="col-xs-3 col-sm-3 f-16 text-r">学生学号：</label>
                <div class="formControls col-xs-9 col-sm-9">
                    <input type="text" id="xh" placeholder="请输入学生学号" class="input-text radius" value="">
                </div>
            </div>
        </div>
        <div class="row cl mt-10" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">学生手机号：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <input type="text" id="sjh" placeholder="请输入学生手机号" class="input-text radius" value="${xszzyxxb.sjh}">
            </div>
        </div>
        <div class="row cl mt-10" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">生源类别：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <span class="select-box">
                  <select class="select" size="1" name="sylb" id="sylb" radius>
                    <option value="" <c:if test="${xszzyxxb.sylb == null}">selected</c:if>>请选择生源类别</option>
                    <option value="理工" <c:if test="${xszzyxxb.sylb == '理工'}">selected</c:if> >理工</option>
                    <option value="文史" <c:if test="${xszzyxxb.sylb == '文史'}">selected</c:if> >文史</option>
                    <option value="艺术类" <c:if test="${xszzyxxb.sylb == '艺术类'}">selected</c:if> >艺术类</option>
                    <option value="体育" <c:if test="${xszzyxxb.sylb == '体育'}">selected</c:if> >体育</option>
                  </select>
                </span>
            </div>
        </div>
        <div class="row cl mt-10" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">录取批次：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <span class="select-box">
                  <select class="select" size="1" name="lqpc" id="lqpc" radius>
                    <option value="" <c:if test="${xszzyxxb.lqpc == null}">selected</c:if>>请选择录取批次</option>
                    <option value="一本" <c:if test="${xszzyxxb.lqpc == '一本'}">selected</c:if>>一本</option>
                    <option value="二本" <c:if test="${xszzyxxb.lqpc == '二本'}">selected</c:if>>二本</option>
                  </select>
                </span>
            </div>
        </div>
        <div class="row cl mt-10" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">拟申请学院：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <span class="select-box">
                    <c:if test="${xszzyxxb.nzrxsm == null}">
                        <select class="select" size="1" name="xsm" id="xsm" radius>
                            <option value="" selected>请选择拟申请学院名称</option>
                        </select>
                    </c:if>
                    <c:if test="${xszzyxxb.nzrxsm != null}">
                        <select class="select" size="1" name="xsm" id="xsm" radius>
                            <option value="">请选择拟申请学院名称</option>
                            <c:forEach items="${xsms}" var="xsm">
                                <option value="${xsm}" <c:if test="${xszzyxxb.nzrxsm == xsm}">selected</c:if> >${xsm}</option>
                            </c:forEach>
                        </select>
                    </c:if>
                </span>
            </div>
        </div>
        <div class="row cl mt-10" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">拟申请专业：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <span class="select-box">
                    <c:if test="${xszzyxxb.nzrzym == null}">
                        <select class="select" size="1" name="zym" id="zym" radius>
                            <option value="" selected>请选择拟申请专业</option>
                        </select>
                    </c:if>
                    <c:if test="${xszzyxxb.nzrzym != null}">
                        <select class="select" size="1" name="zym" id="zym" radius>
                            <option value="">请选择拟申请专业</option>
                            <c:forEach items="${zyms}" var="zym">
                                <option value="${zym}" <c:if test="${xszzyxxb.nzrzym == zym}">selected</c:if> >${zym}</option>
                            </c:forEach>
                        </select>
                    </c:if>
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
    var xszzyxxb = {
        id : "",
        xh : "",
        nzrxsm : "",
        nzrzym : "",
        sylb : "",
        lqpc : "",
        sjh : "",
    }
    $('#sylb').change(function () {
        let optionStr = "<option value='' selected>请选择拟申请学院名称</option>";
        $.request({
            type : "POST",
            url : "/zyxxb/getAllXsm",
            data : JSON.stringify({xkfl:$('#sylb').val()}),
            contentType: 'application/json;charset=UTF-8',
            dataType: 'json',
            success : function(res) {
                if(res.code == 1) {
                    let _data = res.data;
                    $('#xsm').empty();
                    for(let i = 0; i < res.data.length; i++) {
                        optionStr += "<option value='"+ _data[i] +"'>"+ _data[i] /*+"-"+ _data[i].lqpc*/ +"</option>"
                    }
                    $('#xsm').append(optionStr);
                }
            },
            error:function (message) {
                console.log(message);
                $('#loadingToast').fadeOut(100);
                errMsg("网络异常");
            }
        })
    });
    // 不需要根据录取批次来进行筛选 2020年5月21日20:26:54
/*    $('#lqpc').change(function () {
        let optionStr = "<option value='' selected>请选择拟申请学院名称</option>";
        $.request({
            type : "POST",
            url : "/zyxxb/getAll",
            data : JSON.stringify({xkfl:$('#sylb').val(),lqpc:$('#lqpc').val()}),
            contentType: 'application/json;charset=UTF-8',
            dataType: 'json',
            success : function(res) {
                if(res.code == 1) {
                    let _data = res.data;
                    $('#xsm').empty();
                    for(let i = 0; i < res.data.length; i++) {
                        optionStr += "<option value='"+ _data[i].xsm +"' selected>"+ _data[i].xsm +"-"+ _data[i].lqpc +"</option>"
                    }
                    $('#xsm').append(optionStr);
                }
            },
            error:function (message) {
                console.log(message);
                $('#loadingToast').fadeOut(100);
                errMsg("网络异常");
            }
        })
    });*/
    $('#xsm').change(function () {
        let optionStr = "<option value='' selected>请选择拟申请专业</option>";
        $.request({
            type : "POST",
            url : "/zyxxb/getAllZym",
            data : JSON.stringify({xkfl:$('#sylb').val(),xsm:$('#xsm').val()}),
            contentType: 'application/json;charset=UTF-8',
            dataType: 'json',
            success : function(res) {
                if(res.code == 1) {
                    let _data = res.data;
                    $('#zym').empty();
                    for(let i = 0; i < res.data.length; i++) {
                        optionStr += "<option value='"+ _data[i] +"'>"+ _data[i] +"</option>"
                    }
                    $('#zym').append(optionStr);
                }
            },
            error:function (message) {
                console.log(message);
                $('#loadingToast').fadeOut(100);
                errMsg("网络异常");
            }
        })
    });
    $('#submit').click(function () {
        if(checkData()) {
            disposalData();
            $.request({
                url : '/xszzyxxb/save',
                type : "POST",
                data : JSON.stringify(xszzyxxb),
                contentType: 'application/json;charset=UTF-8',
                dataType: 'json',
                success : function(result) {
                    if(result.code == 1) {
                        succMsg(result.msg);
                    }else {
                        errMsg(result.msg);
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
        }
    });

    function checkData() {
        let option = {icon:3,time:2000};
        if($('#id').val() == '') {
            if ($('#xh').val() == null || $('#xh').val() == '') {
                msg("学号为空！", option);
                return false;
            }
        }
        if($('#xsm').val() == null || $('#xsm').val() == '') {
            msg("拟申请学院为空！",option);
            return false;
        }
        if($('#zym').val() == null || $('#zym').val() == '') {
            msg("拟申请专业为空！",option);
            return false;
        }
        if($('#sylb').val() == null || $('#sylb').val() == '') {
            msg("生源类别为空！",option);
            return false;
        }
        if($('#lqpc').val() == null || $('#lqpc').val() == '') {
            msg("录取批次为空！",option);
            return false;
        }
        if($('#sjh').val() == null || $('#sjh').val() == '') {
            msg("手机号为空！",option);
            return false;
        }

        return true;
    }

    function disposalData() {
        xszzyxxb.id = $('#id').val();
        xszzyxxb.xh = $('#xh').val();
        xszzyxxb.sylb = $('#sylb').val();
        xszzyxxb.lqpc = $('#lqpc').val();
        xszzyxxb.nzrxsm = $('#xsm').val();
        xszzyxxb.nzrzym = $('#zym').val();
        xszzyxxb.sjh = $('#sjh').val();
    }
</script>
</html>
