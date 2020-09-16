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
                html,body {
                    width: 100%;
                    height: 100%;
                    overflow: hidden;
                }
                .title-bkc {
                    background-color: #F5FAFE;
                }
                .custCenterBody{
                    width: 100%;
                    height: 40px;
                    box-sizing: border-box;
                    padding-left: 50px;
                    float: left;
                }
                .flow2Div{

                    height: 100%;
                }
                .flow2Divbutton1{
                    float: left;
                    background-color:#b7b7b7;
                    height: 40px;
                    width: 45%;
                    border-radius: 5px;
                    margin: 0 10px;

                    transition: 1s;
                }
                .flow2Divbutton1Line1{
                    width: 2px;
                    height: 20px;
                    -webkit-transform: skew(-30deg);
                    -ms-transform: skew(-30deg);
                    -moz-transform: skew(-30deg);
                    -o-transform: skew(-30deg);
                    background: #FFF;
                    margin: 20px 0 0 37px;
                    float: left;
                    position: absolute;

                }
                .flow2Divbutton1Line2{
                    width: 2px;
                    height: 20px;
                    -webkit-transform: skew(30deg);
                    -moz-transform: skew(30deg);
                    -ms-transform: skew(30deg);
                    -o-transform: skew(30deg);
                    background: #FFF;
                    margin: 0px 0 0 37px;
                    float: left;
                    position: absolute;

                }
                .flow2Divbutton1Span1{
                    float: left;
                    color: #fff;
                    font-size: 14px;
                    margin: 10px 0 0 46px;
                    font-family:Microsoft YaHei;
                }
                .flow2Divbutton1Span{
                    float: left;
                    margin: 0px 0 0 10px;
                    font-family: arial black;
                    font-size: 28px;
                    color: #fff;
                }
                .none {
                    display: none;
                }
                .tabHeight {
                    height: 170px;
                }
            </style>
        </head>
<body>
<article class="page-container">
    <form id="form-member-add">
        <input type="hidden" id="id" name="id" value="${xszzyxxb.id}">
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
        <div class="row cl mt-30">
            <div class="col-xs-12 col-sm-12">
                <div class='custCenterBody' id='custCenterBody'></div>
            </div>
        </div>
        <div id="step_1"  class="tabHeight">
            <div class="row cl mt-50" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
                <label class="col-xs-3 col-sm-3 f-16 text-r">学生手机号：</label>
                <div class="formControls col-xs-9 col-sm-9">
                    <input type="text" id="sjh" placeholder="请输入学生手机号" class="input-text radius" value="${xszzyxxb.sjh}">
                </div>
            </div>
            <div class="row cl mt-15" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
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
            <div class="row cl mt-15" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
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
        </div>
        <div id="step_2" class="tabHeight none">
            <div class="row cl mt-50" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
                <label class="col-xs-3 col-sm-3 f-16 text-r">拟申请学院：</label>
                <div class="formControls col-xs-9 col-sm-9">
                    <span class="select-box">
                        <select class="select" size="1" name="xsm" id="xsm" radius>
                            <option value="">请选择拟申请学院名称</option>
                            <c:forEach items="${xsms}" var="xsm">
                                <option value="${xsm}" <c:if test="${xszzyxxb.nzrxsm == xsm}">selected</c:if> >${xsm}</option>
                            </c:forEach>
                        </select>
                    </span>
                </div>
            </div>
            <div class="row cl mt-50" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
                <label class="col-xs-3 col-sm-3 f-16 text-r">拟申请专业：</label>
                <div class="formControls col-xs-9 col-sm-9">
                    <span class="select-box">
                        <select class="select" size="1" name="zym" id="zym" radius>
                            <option value="">请选择拟申请专业</option>
                            <c:forEach items="${zyms}" var="zym">
                                <option value="${zym}" <c:if test="${xszzyxxb.nzrzym == zym}">selected</c:if> >${zym}</option>
                            </c:forEach>
                        </select>
                    </span>
                </div>
            </div>
        </div>
        <div class="row cl mt-30">
            <div class="col-xs-1 col-sm-1 col-xs-offset-2 col-sm-offset-2">
                <input type="button" id="prev" class="btn btn-primary radius none" value="&nbsp;&nbsp;上一步&nbsp;&nbsp;">
            </div>
            <div class="col-xs-1 col-sm-1 col-xs-offset-2 col-sm-offset-2">
                <input type="button" id="submit" class="btn btn-primary radius none" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
            <div class="col-xs-1 col-sm-1 col-xs-offset-2 col-sm-offset-2">
                <input type="button" id="next" class="btn btn-primary radius" value="&nbsp;&nbsp;下一步&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>

<!-- 等待 -->
<div id="loadingToast" style="display:none;">
    <div class="weui-mask_transparent"></div>
    <div class="weui-toast">
        <i class="weui-loading weui-icon_toast"></i>
        <p class="weui-toast__content">生成中</p>
    </div>
</div>

</body>
<script type="text/javascript">

    window.onload = function() {
        var custCenterBody=$('#custCenterBody').empty();
        var flow2Div=$('<div class=\'flow2Div\' id=\'flow2Div\'></div>').appendTo(custCenterBody);
        var data=[{quesName:'步骤一'},{quesName:'步骤二'}];
        $.each(data, function(i, u) {
            var flow2Divbutton1=$('<div class=\'flow2Divbutton1\' id=\'list'+(i+1)+'\'></div>')
                .append($('<div class=\'flow2Divbutton1Line1\'></div>'))
                .append($('<div class=\'flow2Divbutton1Line2\'></div>'))
                .append($('<span class=\'flow2Divbutton1Span\'>'+(i+1)+'</span>'))
                .append($('<span class=\'flow2Divbutton1Span1\'  id=\'flow2Divbutton1Span1id\'>'+u.quesName+'</span>'))
                .appendTo(flow2Div);
        });
        changeColor(1);
    }
    //步骤条变色
    function changeColor(i) {
        $(".flow2Divbutton1").attr('style', 'background-color:#b7b7b7');
        $("#list"+i).attr('style', 'background-color:#e50211');
    }

    $('#next').click(function () {
        let option = {icon:3,time:2000};
        if($('#sylb').val() == '') {
            msg("请先选择生源类别",option);
            return ;
        }
        if($('#lqpc').val() == '') {
            msg("请先选择录取批次",option);
            return ;
        }
        $("#step_2").removeClass("hui-fadeoutR");
        changeColor(2);
        $("#step_1").addClass("hui-fadeoutL");
        setTimeout(function () {
            $("#step_1").addClass("none");
            $("#step_2").addClass("tabHeight hui-fadeinR");
            $("#step_2").removeClass("none");
            $('#next').removeClass("hui-fadein");
            $('#next').addClass("hui-fadeout");
            $('#prev').removeClass("hui-fadeout");
            $('#prev').removeClass("none");
            $('#prev').addClass("hui-fadein");
            $('#submit').removeClass("hui-fadeout");
            $('#submit').removeClass("none");
            $('#submit').addClass("hui-fadein");
        },500);
    });

    $('#prev').click(function () {
        $("#step_1").removeClass("hui-fadeoutL");
        changeColor(1);
        $("#step_2").addClass("hui-fadeoutR");
        setTimeout(function () {
            $("#step_2").addClass("none");
            $("#step_1").addClass("tabHeight hui-fadeinL")
            $("#step_1").removeClass("none");
            $('#next').removeClass("hui-fadeout");
            $('#next').addClass("hui-fadein");
            $('#prev').addClass("hui-fadeout");
            // $('#prev').addClass("none");
            $('#submit').removeClass("hui-fadein");
            $('#submit').addClass("hui-fadeout");
            // $('#submit').addClass("none");
        },500);
    });

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
            $('#loadingToast').show();
            $.request({
                url : '/xszzyxxb/save',
                type : "POST",
                data : JSON.stringify(xszzyxxb),
                contentType: 'application/json;charset=UTF-8',
                dataType: 'json',
                success : function(result) {
                    succMsg(result.msg);
                    setTimeout(function () {
                        $('#loadingToast').hide();
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.$('#btn-refresh').click();
                        parent.layer.close(index);
                    },1000)
                },
                error:function (message) {
                    $('#loadingToast').hide();
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
</title>
</head>
<body>

</body>
</html>
