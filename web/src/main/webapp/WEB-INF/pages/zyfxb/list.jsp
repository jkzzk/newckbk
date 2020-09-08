<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>辅修报名</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 学生辅修报名 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="datadel('/zyfxb/delete')" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
            <a href="javascript:;" onclick="add('新增辅修专业','/zyfxb/edit','','600')" class="btn btn-success radius"><i class="Hui-iconfont f-18">&#xe600;</i> 新增</a>
            <a href="javascript:;" onclick="edit('修改辅修专业','/zyfxb/edit','','600')" class="btn btn-success radius"><i class="Hui-iconfont f-18">&#xe6df;</i> 修改</a>
        </span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th>
                    <input type="checkbox" name="ids" value="">
                </th>
                <th>学号</th>
                <th>姓名</th>
                <th>当前学院</th>
                <th>当前专业</th>
                <th>当前班级</th>
                <th>拟辅修学院</th>
                <th>拟辅修专业</th>
                <th>联系电话</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${zyfxbST}" var="zyfxb">
                <tr class="text-c">
                    <td>
                        <input type="checkbox" value="${zyfxb.xh}" name="ids">
                    </td>
                    <td  id="xh">${zyfxb.xh}</td>
                    <td>${zyfxb.xm}</td>
                    <td>${zyfxb.xsm}</td>
                    <td>${zyfxb.zym}</td>
                    <td>${zyfxb.bjh}</td>
                    <td>${zyfxb.nfxxsm}</td>
                    <td>${zyfxb.nfxzym}</td>
                    <td>${zyfxb.lxdh}</td>
                    <td>
                        <button class="btn btn-primary radius" id="print"><i class="Hui-iconfont">&#xe652;</i> &nbsp;&nbsp;打印</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript">
    $("#print").click(function () {
        let xh = $("#xh").text();
        window.open("/zyfxb/print?xh=" + xh);
    });
</script>
</body>
</html>
