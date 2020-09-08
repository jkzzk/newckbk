<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>补考课程管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 补考课程管理 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c" style="border: 1px solid; border-radius: 10px;box-sizing: border-box; padding: 10px;background-color: #F5FAFE;">
        <form action="/bkkcxxb/list" method="post">
            <input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}">
            <input type="hidden" id="pn" name="pageNumber" value="${page.pageNum}">
            <div class="row cl">
                <label class="col-xs-1 col-sm-1 f-16 text-r">是否为补考课程：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <span class="select-box radius">
                      <select class="select" size="1" name="sfzzbk">
                          <option value="" <c:if test="${param.sfzzbk == null}">selected</c:if>>请选择是否为补考</option>
                          <option value="是" <c:if test="${param.sfzzbk == '是'}">selected</c:if> >是</option>
                          <option value="否" <c:if test="${param.sfzzbk == '否'}">selected</c:if> >否</option>
                      </select>
                    </span>
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">学期：</label>
                <div class="formControls col-xs-2 col-sm-2">
                   <span class="select-box radius">
                      <select class="select" size="1" name="jxjhh">
                          <option value="" <c:if test="${param.jxjhh == null}">selected</c:if>>请选择学期</option>
                          <c:forEach var="t" items="${term}" >
                              <option value="${t.zxjxjhh}" <c:if test="${param.jxjhh == t.zxjxjhh}">selected</c:if>>${t.zxjxjhm}</option>
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
            </div>
            <div class="row cl mt-10">
                <label class="col-xs-1 col-sm-1 f-16 text-r">学院名称：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入学时" value="${param.xsm}" name="xsm" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">学时：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入学时" value="${param.xs}" name="xs" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">学分：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入学分" value="${param.xf}" name="xf" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">考试类型：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入考试类型" value="${param.kslx}" name="kslx" class="input-text radius">
                </div>
            </div>
            <div class="row cl">
                <div class="col-xs-1 col-sm-1">
                    <button type="submit" class="btn btn-success radius" style="width: 100px"><i class="Hui-iconfont">&#xe665;</i> 搜课程</button>
                </div>
            </div>
        </form>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="datadel('/bkkcxxb/delete')" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
            <a href="javascript:;" onclick="add('新增补考课程','/bkkcxxb/edit','','600')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 新增</a>
            <a href="javascript:;" onclick="edit('修改补考课程','/bkkcxxb/edit','','600')" class="btn btn-warning radius"><i class="Hui-iconfont">&#xe60c;</i> 修改</a>
            <a href="javascript:;" onclick="window.open('/bkkcxxb/download')" class="btn btn-success radius"><i class="Hui-iconfont">&#xe641;</i> 下载导入模板</a>
            <span class="btn-upload form-group">
              <input class="input-text upload-url radius" type="text" name="uploadfile-1" id="uploadfile-1" readonly>
              <a href="javascript:;" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe725;</i> 浏览文件</a>
              <input type="file" multiple name="file" id="file" class="input-file">
            </span>
            <a href="javascript:;" onclick="importFile('/bkkcxxb/import','file','#file')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe642;</i> 导入</a>
        </span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th>
                    <input type="checkbox" name="ids" value="">
                </th>
                <th>是否为补考课程</th>
                <th>学期</th>
                <th>学院名称</th>
                <th>课程号</th>
                <th>课程名称</th>
                <th>课程属性</th>
                <th>学时</th>
                <th>学分</th>
                <th>考试类型</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="course">
                <tr class="text-c">
                    <td>
                        <input type="checkbox" value="${course.id}" name="ids">
                    </td>
                    <td>${course.sfzzbk}</td>
                    <td>${course.zxjxjhm}</td>
                    <td>${course.xsm}</td>
                    <td>${course.kch}</td>
                    <td>${course.kcm}</td>
                    <td>${course.kcsx}</td>
                    <td>${course.xs}</td>
                    <td>${course.xf}</td>
                    <td>${course.kslx}</td>
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
