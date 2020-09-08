<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>教务控制管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 教务控制管理 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="clearData('/jwkzxxjl/clear')" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 清除记录</a>
            <a href="javascript:;" onclick="add('重置开关','/jwkzxxjl/setPage','','220')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe61d;</i> 设置</a>
        </span>
    </div>
    <div class="mt-20">
        <form action="/jwkzxxjl/list" method="post">
        <input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}">
        <input type="hidden" id="pn" name="pageNumber" value="${page.pageNum}">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th>编号</th>
                <th>状态</th>
                <th>补考开关</th>
                <th>辅修开关</th>
                <th>转专业开关</th>
                <th>四六级开关</th>
                <th>创建时间</th>
                <th>创建人</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="jwkg">
            <tr class="text-c">
                <td>${jwkg.id}</td>
                <td
                        <c:if test="${jwkg.status == 0}">class="c-red"</c:if>
                        <c:if test="${jwkg.status == 1}">class="c-green"</c:if>
                >${jwkg.statusName}</td>
                <td>${jwkg.bkkgmc}</td>
                <td>${jwkg.fxkgmc}</td>
                <td>${jwkg.zzykgmc}</td>
                <td>${jwkg.cetkgmc}</td>
                <td>${jwkg.createTimeStr}</td>
                <td>${jwkg.createUserName}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        </form>
        <div><%@include file="../common/page.jsp"%></div>
    </div>
</div>
</body>
</html>
