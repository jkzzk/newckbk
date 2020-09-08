<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/common.jsp"%>
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
<nav class="breadcrumb"> <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <form id="form-member-add">
        <div class="row cl mt-20" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-3 col-sm-3 f-16 text-r">联系电话：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <input type="text" placeholder="请填写联系电话" name="lxdh" id="lxdh" value="${zyfxb.lxdh}" class="input-text radius size-M">
                <input type="hidden"  name="xh" id="xh" value="${zyfxb.xh}" class="input-text radius size-M">
            </div>
        </div>
        <div class="row cl mt-20">
            <table class="table table-border table-bordered table-hover table-bg table-sort">
                <thead>
                <tr class="text-c">
                    <th> </th>
                    <th>编号</th>
                    <th>学院名称</th>
                    <th>专业名称</th>
                    <th>学科分类</th>
                    <th>录取批次代码</th>
                    <th>录取批次名称</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${zyfxxxb}" var="zyfxx">
                    <tr class="text-c">
                        <td>
                            <input type="radio" value="${zyfxx.id}" name="ids">
                        </td>
                        <td>${zyfxx.id}</td>
                        <td>${zyfxx.xsm}</td>
                        <td>${zyfxx.zym}</td>
                        <td>${zyfxx.xkfl}</td>
                        <td>${zyfxx.lqdm}</td>
                        <td>${zyfxx.lqpc}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row cl">
            <div class="col-xs-7 col-sm-7 col-xs-offset-5 col-sm-offset-5 mt-10">
                <input type="button" id="submit" class="btn btn-primary radius" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</div>
<script type="text/javascript">
    let zyfxbForm = {
        xh : '',
        lxdh : '',
        zyfxxxbId : '',
    }

    $('#submit').click(function () {

        let xh = $('#xh').val();
        let lxdh = $('#lxdh').val();

        if(ifIsNull(lxdh) == '') {
            errMsg("请填写联系电话!");

            return ;
        }

        zyfxbForm.xh = xh;
        zyfxbForm.lxdh = lxdh;
        zyfxbForm.zyfxxxbId = $('input[name="ids"]:checked').val();

        if(ifIsNull(zyfxbForm.zyfxxxbId) == '') {
            errMsg("请选择辅修专业!");

            return ;
        }

        $.request({
            url : '/zyfxb/exsit',
            type : "POST",
            contentType: 'application/json;charset=UTF-8',
            dataType: 'json',
            success : function(result) {
                if(result.data == 1) {
                    errMsg("不能重复报名！")
                }else {
                    $.request({
                        url : '/zyfxb/studentSave',
                        type : "POST",
                        data : JSON.stringify(zyfxbForm),
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
                }
            },
            error:function (message) {
                console.log(message);
                errMsg("网络异常");
            }
        });


    });
</script>
</body>
</html>
