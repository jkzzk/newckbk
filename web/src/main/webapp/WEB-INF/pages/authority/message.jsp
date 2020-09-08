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
    <style type="text/css">
        html,body {
            height: 100%;
            overflow: hidden;
        }
        .message-container {
            position: absolute;
            left: 0;
            right: 0;
            top: 0;
            bottom: 0;
            margin: auto;
            width: 50%;
            height: 200px;
        }
        .panel-body span {
            display: inline-block;

            width: 100%;

            color: orange;
            font-size: 20px;
            font-weight: bold;

            text-align: center;
        }
    </style>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 补考条件管理 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="message-container">
        <div class="panel panel-warning">
            <div class="panel-header">信息</div>
            <div class="panel-body">
                <span>${msg}</span>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
</script>
</body>
</html>
