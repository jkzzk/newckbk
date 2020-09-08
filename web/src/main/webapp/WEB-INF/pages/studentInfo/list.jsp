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
    <div class="text-c">
        <form action="/studentInfo/list" method="post">
            <input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}">
            <input type="hidden" id="pn" name="pageNumber" value="${page.pageNum}">
            <select name="searchType" id="searchType" class="input-text" style="width:250px;">
                <option value="" <c:if test="${pageParams.searchType == ''}">selected="selected"</c:if>>请选择搜索类型</option>
                <option value="xh" <c:if test="${pageParams.searchType eq 'xh'}">selected="selected"</c:if>>学号</option>
                <option value="xm" <c:if test="${pageParams.searchType eq 'xm'}">selected="selected"</c:if>>姓名</option>
                <option value="xb" <c:if test="${pageParams.searchType eq 'xb'}">selected="selected"</c:if>>性别</option>
                <option value="sfzh" <c:if test="${pageParams.searchType eq 'sfzh'}">selected="selected"</c:if>>身份证号</option>
                <option value="xslbsm" <c:if test="${pageParams.searchType eq 'xslbsm'}">selected="selected"</c:if>>学生类别</option>
                <option value="xsm" <c:if test="${pageParams.searchType eq 'xsm'}">selected="selected"</c:if>>学院</option>
                <option value="zym" <c:if test="${pageParams.searchType eq 'zym'}">selected="selected"</c:if>>专业</option>
                <option value="bjh" <c:if test="${pageParams.searchType eq 'bjh'}">selected="selected"</c:if>>班级</option>
                <option value="rxnj" <c:if test="${pageParams.searchType eq 'rxnj'}">selected="selected"</c:if>>入学年级</option>
                <option value="dqnj" <c:if test="${pageParams.searchType eq 'dqnj'}">selected="selected"</c:if>>当前年级</option>
                <option value="sfyxj" <c:if test="${pageParams.searchType eq 'sfyxj'}">selected="selected"</c:if>>是否有学籍</option>
            </select>
            <input type="text" class="input-text" style="width:250px" placeholder="输入用查询内容" id="searchContent" name="${pageParams.searchType}" value="${pageParams.searchContent}">
            <button type="submit" class="btn btn-success radius"><i class="Hui-iconfont">&#xe665;</i> 搜学生</button>
        </form>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>身份证号</th>
                <th>学生类别</th>
                <th>学院</th>
                <th>专业</th>
                <th>班级</th>
                <th>入学年级</th>
                <th>当前年级</th>
                <th>是否有学籍</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="student">
            <tr class="text-c">
                <td>${student.xh}</td>
                <td>${student.xm}</td>
                <td>${student.xb}</td>
                <td>${student.sfzh}</td>
                <td>${student.xslbsm}</td>
                <td>${student.xsm}</td>
                <td>${student.zym}</td>
                <td>${student.bjh}</td>
                <td>${student.rxnj}</td>
                <td>${student.dqnj}</td>
                <td>${student.sfyxj}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <div><%@include file="../common/page.jsp"%></div>
    </div>
</div>
<script type="text/javascript" src="${ctx}/lib/common/search.js"></script>
</body>
</html>
