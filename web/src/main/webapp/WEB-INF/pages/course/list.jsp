<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>重修管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 补考条件管理 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c" style="border: 1px solid; border-radius: 10px;box-sizing: border-box; padding: 10px;background-color: #F5FAFE;">
        <form action="/course/list" method="post">
            <input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}">
            <input type="hidden" id="pn" name="pageNumber" value="${page.pageNum}">
            <div class="row cl">
                <label class="col-xs-1 col-sm-1 f-16 text-r">是否为重修课程：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <span class="select-box radius">
                      <select class="select" size="1" name="ifRetake">
                        <option value="0" <c:if test="${param.ifRetake eq 0}">selected</c:if>>否</option>
                        <option value="1" <c:if test="${param.ifRetake eq 1}">selected</c:if>>是</option>
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
                <label class="col-xs-1 col-sm-1 f-16 text-r">课程序号：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入课程序号" value="${param.kxh}" name="kxh" class="input-text radius">
                </div>
            </div>
            <div class="row cl mt-10">
                <label class="col-xs-1 col-sm-1 f-16 text-r">教师号：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入教师号" value="${param.jsh}" name="jsh" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">教师姓名：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入教师姓名" value="${param.jsm}" name="jsm" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">学时：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入学时" value="${param.xs}" name="xs" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">学分：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入学分" value="${param.xf}" name="xf" class="input-text radius">
                </div>
            </div>
            <div class="row cl mt-10">
                <div class="col-xs-1 col-sm-1">
                    <button type="submit" class="btn btn-success radius" style="width: 100px"><i class="Hui-iconfont">&#xe665;</i> 搜课程</button>
                </div>
            </div>
        </form>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="setRetake()" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe66c;</i> 批量设置重修课程</a>
            <a href="javascript:;" onclick="reSetRetake()" class="btn btn-warning radius"><i class="Hui-iconfont">&#xe66b;</i> 批量设置补考课程</a>
        </span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th>
                    <input type="checkbox" name="ids" value="">
                </th>
                <th>是否为重修课程</th>
                <th>学期</th>
                <th>课程号</th>
                <th>课程名称</th>
                <th>课程序号</th>
                <th>教师号</th>
                <th>教师名称</th>
                <th>学时</th>
                <th>学分</th>
                <th>校区</th>
                <th>上课地点</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="course">
                <tr class="text-c">
                    <td>
                        <input type="checkbox" value="${course.kch}" name="ids">
                    </td>
                    <td>
                        <c:if test="${course.ifRetake eq 0}"><span style="color: green">否</span></c:if>
                        <c:if test="${course.ifRetake eq 1}"><span style="color: red">是</span></c:if>
                    </td>
                    <td>${course.zxjxjhm}</td>
                    <td>${course.kch}</td>
                    <td>${course.kcm}</td>
                    <td>${course.kxh}</td>
                    <td>${course.jsh}</td>
                    <td>${course.jsm}</td>
                    <td>${course.xs}</td>
                    <td>${course.xf}</td>
                    <td>${course.xqm}</td>
                    <td>${course.kkxsjc}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div><%@include file="../common/page.jsp"%></div>
    </div>
</div>
<script type="text/javascript">
    function setRetake() {
        var ids =  getIds();
        $.request({
            url : '/course/setRetake',
            type : "POST",
            data : JSON.stringify({kchs : ids,ifRetake : 1}),
            contentType: 'application/json;charset=UTF-8',
            dataType: 'json',
            success : function(result) {
                succMsg(result.msg);
                setTimeout(function () {
                    refresh();
                },1000)
            },
            error:function (message) {
                console.log(message);
                $('#loadingToast').fadeOut(100);
                errMsg("网络异常");
            }
        });
    }
    function reSetRetake() {
        var ids =  getIds();
        $.request({
            url : '/course/reSetRetake',
            type : "POST",
            data : JSON.stringify({kchs : ids}),
            contentType: 'application/json;charset=UTF-8',
            dataType: 'json',
            success : function(result) {
                succMsg(result.msg);
                setTimeout(function () {
                    refresh();
                },1000)
            },
            error:function (message) {
                console.log(message);
                $('#loadingToast').fadeOut(100);
                errMsg("网络异常");
            }
        });
    }
</script>
</body>
</html>
