<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>补考条件管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 补考条件管理 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c" style="border: 1px solid; border-radius: 10px;box-sizing: border-box; padding: 10px;background-color: #F5FAFE;">
        <form action="/graduation/list" method="post">
            <input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}">
            <input type="hidden" id="pn" name="pageNumber" value="${page.pageNum}">
            <div class="row cl">
                <label class="col-xs-1 col-sm-1 f-16 text-r">性别：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <span class="select-box radius">
                      <select class="select" size="1" name="xb">
                        <option value="男" <c:if test="${param.xb eq '男'}">selected</c:if>>男</option>
                        <option value="女" <c:if test="${param.xb eq '女'}">selected</c:if>>女</option>
                      </select>
                    </span>
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">学生学号：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入学生学号" value="${param.xh}" name="xh" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">学生姓名：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入学生姓名" value="${param.xm}" name="xm" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">班级号：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入班级号" value="${param.bjh}" name="bjh" class="input-text radius">
                </div>
            </div>
            <div class="row cl mt-10">
                <label class="col-xs-1 col-sm-1 f-16 text-r">学院名称：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入学院名称" value="${param.xsm}" name="xsm" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">专业名称：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入专业名称" value="${param.zym}" name="zym" class="input-text radius">
                </div>
                <div class="col-xs-1 col-sm-1">
                    <button type="submit" class="btn btn-success radius" style="width: 130px"><i class="Hui-iconfont">&#xe665;</i> 搜结业学生</button>
                </div>
            </div>
        </form>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="datadel('/graduation/clear')" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
            <a href="javascript:;" onclick="add('设置条件','/graduation/edit','','200')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加</a>
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
                <th>学生姓名</th>
                <th>学生性别</th>
                <th>学生班级号</th>
                <th>学生学院名</th>
                <th>学生专业名</th>
                <th>学生入学年级</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="graduation">
                <tr class="text-c">
                    <td>
                        <input type="checkbox" value="${graduation.xh}" name="ids">
                    </td>
                    <td>${graduation.xh}</td>
                    <td>${graduation.xm}</td>
                    <td>${graduation.xb}</td>
                    <td>${graduation.bjh}</td>
                    <td>${graduation.xsm}</td>
                    <td>${graduation.zym}</td>
                    <td>${graduation.rxnj}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div><%@include file="../common/page.jsp"%></div>
    </div>
</div>
</body>
</html>
