<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>分班成绩管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 分班成绩管理 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c" style="border: 1px solid; border-radius: 10px;box-sizing: border-box; padding: 10px;background-color: #F5FAFE;">
        <form action="/cetyyfbcj/list" method="post">
            <input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}">
            <input type="hidden" id="pn" name="pageNumber" value="${page.pageNum}">
            <div class="row cl" style="margin: 5px;">
                <label class="col-xs-1 col-sm-1 f-16 text-r">学期：</label>
                <div class="formControls col-xs-2 col-sm-2">
                   <span class="select-box radius">
                      <select class="select" size="1" name="zxjxjhh">
                          <option value="" <c:if test="${param.zxjxjhh == null}">selected</c:if>>请选择学期</option>
                          <c:forEach var="t" items="${term}" >
                              <option value="${t.zxjxjhh}" <c:if test="${param.zxjxjhh == t.zxjxjhh}">selected</c:if>>${t.zxjxjhm}</option>
                          </c:forEach>
                      </select>
                    </span>
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">课程号：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入课程号" value="${param.kch}" name="kch" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">课程名称：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入课程名称" value="${param.kcm}" name="kcm" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">课序号：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入课序号" value="${param.kxh}" name="kxh" class="input-text radius">
                </div>
            </div>
            <div class="row cl" style="margin: 5px;">
                <label class="col-xs-1 col-sm-1 f-16 text-r">学号：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入学号" value="${param.xh}" name="xh" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">姓名：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入姓名" value="${param.xm}" name="xm" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">班级号：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入班级号" value="${param.bjh}" name="bjh" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">分班等级：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入分班等级" value="${param.fbdj}" name="fbdj" class="input-text radius">
                </div>
            </div>
            <div class="row cl" style="margin: 5px;">
                <label class="col-xs-1 col-sm-1 f-16 text-r">最低等级成绩：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入最低等级" value="${param.djcjMin}" name="djcjMin" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">最高等级成绩：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入最高等级" value="${param.djcjMax}" name="djcjMax" class="input-text radius">
                </div>
            </div>
            <div class="row cl" style="margin: 5px;">
                <div class="col-xs-1 col-sm-1">
                    <button type="submit" class="btn btn-success radius" style="width: 120px"><i class="Hui-iconfont">&#xe665;</i> 搜分班成绩</button>
                </div>
            </div>
        </form>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="datadel('/cetyyfbcj/del')" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
            <a href="javascript:;" onclick="add('新增分班成绩','/cetyyfbcj/edit','','600')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 新增</a>
            <a href="javascript:;" onclick="edit('修改分班成绩','/cetyyfbcj/edit','','600')" class="btn btn-warning radius"><i class="Hui-iconfont">&#xe60c;</i> 修改</a>
            <a href="javascript:;" onclick="window.open('/cetyyfbcj/download')" class="btn btn-success radius"><i class="Hui-iconfont">&#xe641;</i> 下载导入模板</a>
            <span class="btn-upload form-group">
              <input class="input-text upload-url radius" type="text" name="uploadfile-1" id="uploadfile-1" readonly>
              <a href="javascript:;" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe725;</i> 浏览文件</a>
              <input type="file" multiple name="file" id="file" class="input-file">
            </span>
            <a href="javascript:;" onclick="importFile('/cetyyfbcj/import','file','#file')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe642;</i> 导入</a>
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
                <th>学期</th>
                <th>课程号</th>
                <th>课程名称</th>
                <th>课程序号</th>
                <th>学号</th>
                <th>姓名</th>
                <th>班级号</th>
                <th>分班等级</th>
                <th>等级成绩</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="cetStufbcj">
                <tr class="text-c">
                    <td>
                        <input type="checkbox" value="${cetStufbcj.id}" name="ids">
                    </td>
                    <td>${cetStufbcj.id}</td>
                    <td>${cetStufbcj.zxjxjhm}</td>
                    <td>${cetStufbcj.kch}</td>
                    <td>${cetStufbcj.kcmc}</td>
                    <td>${cetStufbcj.kxh}</td>
                    <td>${cetStufbcj.xh}</td>
                    <td>${cetStufbcj.xm}</td>
                    <td>${cetStufbcj.bjh}</td>
                    <td>${cetStufbcj.fbdj}</td>
                    <td>${cetStufbcj.djcj}</td>
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
