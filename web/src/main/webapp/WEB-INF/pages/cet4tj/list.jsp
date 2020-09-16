<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>语种考试条件管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 语种考试条件管理 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="clearData('/cet4tj/clear')" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 清除记录</a>
            <a href="javascript:;" onclick="add('设置条件','/cet4tj/edit','1000','600')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe61d;</i> 设置语种考试条件</a>
        </span>
    </div>
    <div class="mt-20">
        <form action="/cet4tj/list" method="post">
        <input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}">
        <input type="hidden" id="pn" name="pageNumber" value="${page.pageNum}">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th>编号</th>
                <th>状态</th>
                <th>本学期</th>
                <th>上下学期</th>
                <th>大一年级</th>
                <th>上一次考试时间</th>
                <th>英语四级通过分数</th>
                <th>俄语四级通过分数</th>
                <th>日语四级通过分数</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="cet4">
            <tr class="text-c">
                <td class="bktjjlId">${cet4.id}</td>
                <td
                        <c:if test="${cet4.status == 0}">class="c-red"</c:if>
                        <c:if test="${cet4.status == 1}">class="c-green"</c:if>
                >${cet4.statusName}</td>
                <td>${cet4.zxjxjhm}</td>
                <td>${cet4.halfTermName}</td>
                <td>${cet4.firstGrade}</td>
                <td>${cet4.cet4PassScore}</td>
                <td>${cet4.crt4PassScore}</td>
                <td>${cet4.cjt4PassScore}</td>
                <td>${cet4.lastExamTerm}</td>
                <td>
                    <a href="javascript:;" class="getInfo btn btn-primary radius"><i class="Hui-iconfont">&#xe720;</i> &nbsp;&nbsp;查看详情</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        </form>
        <div><%@include file="../common/page.jsp"%></div>
    </div>
</div>

<script type="text/javascript">
    window.onload = function () {
        $('.getInfo').click(function (event) {
            var rowId = event.target.parentNode.parentNode.childNodes[1].innerText;
            layer_show('详情','/cet4tj/getInfo?id='+rowId,'1000','600');
        });
    }
</script>
</body>
</html>
