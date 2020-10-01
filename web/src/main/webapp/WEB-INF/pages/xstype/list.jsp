<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>专业管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 专业管理 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="datadel('/xstype/del')" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
            <a href="javascript:;" onclick="add('添加学生类别','/xstype/edit','','300')" class="btn btn-success radius"><i class="Hui-iconfont">&#xe600;</i> 添加</a>
            <a href="javascript:;" onclick="edit('修改学生类别','/xstype/edit','','300')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe6df;</i> 修改</a>
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
                <th>类别所属级别</th>
                <th>学生类别代码</th>
                <th>学生类别名称</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="type">
                <tr class="text-c">
                    <td>
                        <input type="checkbox" value="${type.id}" name="ids">
                    </td>
                    <td>${type.id}</td>
                    <td>
                        <c:if test="${type.typeAttr == 1}">本科</c:if>
                        <c:if test="${type.typeAttr == 2}">专科</c:if>
                    </td>
                    <td>${type.typeId}</td>
                    <td>${type.typeName}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div><%@include file="../common/page.jsp"%></div>
    </div>
</div>
</body>
</html>
