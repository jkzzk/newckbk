<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>辅修专业信息管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 辅修专业信息管理 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c" style="border: 1px solid; border-radius: 10px;box-sizing: border-box; padding: 10px;background-color: #F5FAFE;">
        <form action="/zyfxxxb/list" method="post">
            <input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}">
            <input type="hidden" id="pn" name="pageNumber" value="${page.pageNum}">
            <div class="row cl mt-10">
                <label class="col-xs-1 col-sm-1 f-16 text-r">学院名称：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入学院名称" value="${param.xsm}" name="xsm" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">专业名称：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入专业名称" value="${param.zym}" name="zym" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">学科分类：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入学科分类" value="${param.xkfl}" name="xkfl" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">录取批次：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入录取批次" value="${param.lqpc}" name="lqpc" class="input-text radius">
                </div>
            </div>
            <div class="row cl">
                <div class="col-xs-1 col-sm-1">
                    <button type="submit" class="btn btn-success radius" style="width: 130px"><i class="Hui-iconfont">&#xe665;</i> 搜辅修专业</button>
                </div>
            </div>
        </form>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="datadel('/zyfxxxb/del')" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
            <a href="javascript:;" onclick="add('新增补考课程','/zyfxxxb/edit','','400')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 新增</a>
            <a href="javascript:;" onclick="edit('修改补考课程','/zyfxxxb/edit','','400')" class="btn btn-warning radius"><i class="Hui-iconfont">&#xe60c;</i> 修改</a>
            <a href="javascript:;" onclick="window.open('/zyfxxxb/download')" class="btn btn-success radius"><i class="Hui-iconfont">&#xe641;</i> 下载导入模板</a>
            <span class="btn-upload form-group">
              <input class="input-text upload-url radius" type="text" name="uploadfile-1" id="uploadfile-1" readonly>
              <a href="javascript:;" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe725;</i> 浏览文件</a>
              <input type="file" multiple name="file" id="file" class="input-file">
            </span>
            <a href="javascript:;" onclick="importFile('/zyfxxxb/import','file','#file')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe642;</i> 导入</a>
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
                <th>学院名称</th>
                <th>专业名称</th>
                <th>学科分类</th>
                <th>录取批次代码</th>
                <th>录取批次名称</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="zyfxxxb">
                <tr class="text-c">
                    <td>
                        <input type="checkbox" value="${zyfxxxb.id}" name="ids">
                    </td>
                    <td>${zyfxxxb.id}</td>
                    <td>${zyfxxxb.xsm}</td>
                    <td>${zyfxxxb.zym}</td>
                    <td>${zyfxxxb.xkfl}</td>
                    <td>${zyfxxxb.lqdm}</td>
                    <td>${zyfxxxb.lqpc}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div><%@include file="../common/page.jsp"%></div>
    </div>
</div>
<script type="text/javascript">

</script>
</body>
</html>
