<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>语种历史成绩管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 种历史成绩 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c" style="border: 1px solid; border-radius: 10px;box-sizing: border-box; padding: 10px;background-color: #F5FAFE;">
        <form action="/stuScore/list" method="post">
            <input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}">
            <input type="hidden" id="pn" name="pageNumber" value="${page.pageNum}">
            <div class="row cl">
                <label class="col-xs-1 col-sm-1 f-16 text-r">语种类别：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <span class="select-box radius">
                        <select class="select" size="1" name="ksYyjb">
                            <option value="" <c:if test="${param.ksYyjb == null}">selected</c:if>>请选择导出语种类型</option>
                            <option value="CET4" <c:if test="${param.ksYyjb == 'CET4'}">selected</c:if>>CET4</option>
                            <option value="CET6" <c:if test="${param.ksYyjb == 'CET6'}">selected</c:if>>CET6</option>
                            <option value="CRT4" <c:if test="${param.ksYyjb == 'CRT4'}">selected</c:if>>CRT4</option>
                            <option value="CRT6" <c:if test="${param.ksYyjb == 'CRT6'}">selected</c:if>>CRT6</option>
                            <option value="CJT4" <c:if test="${param.ksYyjb == 'CJT4'}">selected</c:if>>CJT4</option>
                            <option value="CJT6" <c:if test="${param.ksYyjb == 'CJT6'}">selected</c:if>>CJT6</option>
                            <option value="CGT4" <c:if test="${param.ksYyjb == 'CGT4'}">selected</c:if>>CGT4</option>
                            <option value="CGT6" <c:if test="${param.ksYyjb == 'CGT6'}">selected</c:if>>CGT6</option>
                        </select>
                    </span>
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">学号：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入学号" value="${param.ksXh}" name="ksXh" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">姓名：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入姓名" value="${param.ksXm}" name="ksXm" class="input-text radius">
                </div>
                <div class="col-xs-1 col-sm-1">
                    <button type="submit" class="btn btn-success radius" style="width: 120px"><i class="Hui-iconfont">&#xe665;</i> 搜成绩</button>
                </div>
            </div>
        </form>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <a href="javascript:;" onclick="window.open('/stuScore/download')" class="btn btn-success radius"><i class="Hui-iconfont">&#xe641;</i> 下载导入模板</a>
        <span class="l">
            <span class="btn-upload form-group">
              <input class="input-text upload-url radius" type="text" name="uploadfile-1" id="uploadfile-1" readonly>
              <a href="javascript:;" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe725;</i> 浏览文件</a>
              <input type="file" multiple name="file" id="file" class="input-file">
            </span>
        </span>
        <span class="l">
            <a href="javascript:;" onclick="importFile('/stuScore/import','file','#file')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe642;</i> 导入</a>
        </span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th>语种类别</th>
                <th>考试时间</th>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>身份证号</th>
                <th>年级</th>
                <th>所属学院</th>
                <th>所属专业</th>
                <th>所属班级</th>
                <th>总分</th>
                <th>缺考</th>
                <th>违纪</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="lang">
                <tr class="text-c">
                    <td>${lang.ksYyjb}</td>
                    <td>${lang.ksKssj}</td>
                    <td>${lang.ksXh}</td>
                    <td>${lang.ksXm}</td>
                    <td>${lang.ksXb}</td>
                    <td>${lang.ksSfzh}</td>
                    <td>${lang.ksNj}</td>
                    <td>${lang.ksXymc}</td>
                    <td>${lang.ksZymc}</td>
                    <td>${lang.ksBjmc}</td>
                    <td>${lang.ksZf}</td>
                    <td>${lang.ksQk}</td>
                    <td>${lang.ksWj}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div><%@include file="../common/page.jsp"%></div>
    </div>
</div>
</body>
</html>
