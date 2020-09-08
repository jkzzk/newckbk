<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common.jsp"%>
<html>
<head>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
    <title>首页</title>
    <style type="text/css">
        .module {
            height:80px;
            text-align:center;
            color:#FFF;
            line-height:80px;
            font-size:22px;
            margin:5px;
        }
        .module a{
            color:#FFF;
            line-height:80px;
            font-size:22px;
        }
        .bgOrange {
            background-color: orange;
        }
        .bgGreen {
            background-color: #1BC5BB;
        }
        .bgRed {
            background-color: #EE4B47;
        }
        .bgBule {
            background-color: #3388FF;
        }
    </style>
</head>
<body>
    <header class="hui-header">
        <h1>内蒙古科技大学考务系统</h1>
    </header>
    <div class="hui-wrap">
        <div>
            <div class="module bgOrange">
                <a href="">补考报名</a>
            </div>
            <div class="module bgBule">
                <a href="">补考报名结果</a>
            </div>
            <div class="module bgGreen">
                <a href="/mobile/reswitch">转专业报名</a>
            </div>
            <div class="module bgBule">
                <a href="">转专业报名结果</a>
            </div>
            <div class="module bgRed">
                <a href="">个人中心</a>
            </div>
        </div>
    </div>
</body>
</html>
