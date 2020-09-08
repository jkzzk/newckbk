<%--
  Created by IntelliJ IDEA.
  User: jkzzk
  Date: 2017/8/25
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>数字字典</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 字典管理 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c">
        <form action="/dict/list" method="post">
            <input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}">
            <input type="hidden" id="pn" name="pageNumber" value="${page.pageNum}">
            <input type="text" class="input-text" style="width:250px" placeholder="输入字段名" id="field" name="field" value="${params.field}">
            <input type="text" class="input-text" style="width:250px" placeholder="输入表名" id="table" name="table" value="${params.table}">
            <button type="submit" class="btn btn-success radius"><i class="Hui-iconfont">&#xe665;</i> 搜字典</button>
        </form>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <shiro:hasPermission name="dict-del"><a href="javascript:;" onclick="datadel('/dict/del')" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a></shiro:hasPermission>
            <shiro:hasPermission name="dict-add"><a href="javascript:;" onclick="add('添加字典','/dict/edit','','510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加</a></shiro:hasPermission>
            <shiro:hasPermission name="dict-edit"><a href="javascript:;" onclick="edit('编辑字典','/dict/edit','','510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe6df;</i> 编辑</a></shiro:hasPermission>
            <a style="text-decoration:none" onClick="enableAndDisable(1,'确定要禁用吗？','/dict/enable')"  class="btn btn-primary radius" href="javascript:;" title="禁用"><i class="Hui-iconfont">&#xe6de;</i>禁用</a>
            <a style="text-decoration:none" onClick="enableAndDisable(0,'确定要启用吗？','/dict/enable')"  class="btn btn-primary radius" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe603;</i>启用</a>
        </span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th><input type="checkbox" name="ids" value=""></th>
                <th>ID</th>
                <th>表名</th>
                <th>字段名</th>
                <th>字典类型名称</th>
                <th>字典名称</th>
                <th>字典值</th>
                <th>排序</th>
                <th>启/禁用</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${page.list}" var="d">
                <tr class="text-c"  onclick="checked(this)">
                    <td><input type="checkbox" value="${d.id}" name="ids"></td>
                    <td>${d.id}</td>
                    <td>${d.table}</td>
                    <td>${d.field}</td>
                    <td>${d.type}</td>
                    <td>${d.name}</td>
                    <td>${d.value}</td>
                    <td>${d.sort}</td>
                    <td>
                        <span style="color:green;"><c:if test="${d.status eq 0}">已启用</c:if></span>
                        <span style="color:red;"><c:if test="${d.status eq 1}">已禁用</c:if></span>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <div><%@include file="../common/page.jsp"%></div>
    </div>
</div>
</body>
</html>