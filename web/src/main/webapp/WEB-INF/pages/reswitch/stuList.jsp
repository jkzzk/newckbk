<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>学生转专业信息管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 学生转专业信息管理 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="datadel('/xszzyxxb/del')" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 删除</a>
            <a href="javascript:;" onclick="addReswitch()" class="btn btn-success radius"><i class="Hui-iconfont">&#xe600;</i> 添加</a>
            <a href="javascript:;" onclick="edit('修改拟申请转专业信息','/reswitch/edit','','550')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe6df;</i> 修改</a>
        </span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th>
                    <input type="checkbox" name="ids" value="">
                </th>
                <th>编号</th>
                <th>学生学号</th>
                <th>学生姓名</th>
                <th>当前年级</th>
                <th>当前班级</th>
                <th>当前学院名称</th>
                <th>当前专业名称</th>
                <th>生源类型</th>
                <th>录取批次</th>
                <th>拟申请学院名称</th>
                <th>拟申请专业名称</th>
                <th>手机号</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
                <c:if test="${xszzyxxb.id != null}">
                    <tr class="text-c">
                        <td>
                            <input type="checkbox" value="${xszzyxxb.id}" name="ids">
                        </td>
                        <td>${xszzyxxb.id}</td>
                        <td id="xh">${xszzyxxb.xh}</td>
                        <td>${xszzyxxb.xm}</td>
                        <td>${xszzyxxb.dqnj}</td>
                        <td>${xszzyxxb.bjh}</td>
                        <td>${xszzyxxb.currentXsm}</td>
                        <td>${xszzyxxb.currentZym}</td>
                        <td>${xszzyxxb.sylb}</td>
                        <td>${xszzyxxb.lqpc}</td>
                        <td>${xszzyxxb.nzrxsm}</td>
                        <td>${xszzyxxb.nzrzym}</td>
                        <td>${xszzyxxb.sjh}</td>
                        <td>
                            <button class="btn btn-primary radius" id="print"><i class="Hui-iconfont">&#xe652;</i> &nbsp;&nbsp;打印</button>
                        </td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript">
    function addReswitch() {
        $.request({
            url : "/reswitch/check",
            type : "POST",
            contentType: 'application/json;charset=UTF-8',
            dataType: 'json',
            success : function(res) {
                if(res.data) {
                    layer.alert("每个人只能申请一次！");
                }else {
                    add('添加拟申请转专业信息','/reswitch/edit','','550');
                }
            },
            error:function (message) {
                console.log(message);
                $('#loadingToast').fadeOut(100);
                errMsg("网络异常");
            }
        });
    }

    $("#print").click(function () {
        let xh = $("#xh").text();
        window.open("/reswitch/print?xh=" + xh);
    });

</script>
</body>
</html>

