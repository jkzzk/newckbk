<%--
  Created by IntelliJ IDEA.
  User: jkzzk
  Date: 2017/8/22
  Time: 15:44
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
    <title>菜单列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 菜单管理 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c">
        <form action="/menu/list" method="post">
            <input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}">
            <input type="hidden" id="pn" name="pageNumber" value="${page.pageNum}">
            <input type="text" class="input-text" style="width:250px" placeholder="输入菜单名" id="menuName" name="menuName" value="${params.menuName}">
            <button type="submit" class="btn btn-success radius"><i class="Hui-iconfont">&#xe665;</i> 搜菜单</button>
        </form>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <shiro:hasPermission name="menu-del"><a href="javascript:;" onclick="datadel('/menu/del')" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a></shiro:hasPermission>
            <shiro:hasPermission name="menu-add"><a href="javascript:;" onclick="add('添加菜单','/menu/edit','','510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加</a></shiro:hasPermission>
            <shiro:hasPermission name="menu-edit"><a href="javascript:;" onclick="edit('编辑菜单','/menu/edit','','510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe6df;</i> 编辑</a></shiro:hasPermission>
        </span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th><input type="checkbox" name="ids" value=""></th>
                <th>ID</th>
                <th>菜单</th>
                <th>menu_url</th>
                <th>创建时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="m">
                <tr class="text-c" onclick="checked(this)">
                    <td><input type="checkbox" value="${m.id}" name="ids"></td>
                    <td>${m.id}</td>
                    <td>${m.menuName}</td>
                    <td>${m.menuUrl}</td>
                    <td><fmt:formatDate value="${m.createTime}" type="date"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div><%@include file="../common/page.jsp"%></div>
    </div>
</div>
</body>

</html>
