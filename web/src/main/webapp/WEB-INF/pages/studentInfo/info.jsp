<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>学生信息管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 学生信息管理 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <tbody>
            <tr>
                <td>学号</td>
                <td>${student.xh}</td>
                <td>姓名</td>
                <td>${student.xm}</td>
                <td>性别</td>
                <td>${student.xb}</td>
                <td rowspan="3"><img src="${ctx}/studentInfo/showPhoto"></td>
            </tr>
            <tr>
                <td>学院</td>
                <td>${student.xsm}</td>
                <td>专业</td>
                <td>${student.zym}</td>
                <td>班级</td>
                <td>${student.bjh}</td>
            </tr>
            <tr>
                <td>学生类别</td>
                <td>${student.xslbsm}</td>
                <td>入学年级</td>
                <td>${student.rxnj}</td>
                <td>当前年级</td>
                <td>${student.dqnj}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
