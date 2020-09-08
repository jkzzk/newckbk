<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>辅修报名</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 辅修报名管理 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c" style="border: 1px solid; border-radius: 10px;box-sizing: border-box; padding: 10px;background-color: #F5FAFE;">
        <form action="/zyfxb/list" method="post">
            <input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}">
            <input type="hidden" id="pn" name="pageNumber" value="${page.pageNum}">
            <div class="row cl">
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
                <label class="col-xs-1 col-sm-1 f-16 text-r">学号：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入学号" value="${param.xh}" name="xh" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">姓名：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入姓名" value="${param.xm}" name="xm" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">学院：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入学院" value="${param.xsm}" name="xsm" class="input-text radius">
                </div>
            </div>
            <div class="row cl mt-10">
                <label class="col-xs-1 col-sm-1 f-16 text-r">专业：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入专业" value="${param.zym}" name="zym" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">班级：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入班级" value="${param.bjh}" name="bjh" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">拟辅修学院：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入拟辅修学院" value="${param.nfxxsm}" name="nfxxsm" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">拟辅修专业：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入拟辅修专业" value="${param.nfxzym}" name="nfxzym" class="input-text radius">
                </div>
            </div>
            <div class="row cl mt-10">
                <label class="col-xs-1 col-sm-1 f-16 text-r">联系电话：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入联系电话" value="${param.lxdh}" name="lxdh" class="input-text radius">
                </div>
                <div class="col-xs-1 col-sm-1">
                    <button type="submit" class="btn btn-success radius" style="width: 100px"><i class="Hui-iconfont">&#xe665;</i> 搜学生</button>
                </div>
            </div>
        </form>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="datadel('/zyfxb/delete')" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
            <a href="javascript:;" onclick="add('新增辅修专业','/zyfxb/edit','','600')" class="btn btn-success radius"><i class="Hui-iconfont f-18">&#xe600;</i> 新增</a>
            <a href="javascript:;" onclick="window.open('/zyfxb/export');" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe644;</i> 导出</a>
        </span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th>
                    <input type="checkbox" name="ids" value="">
                </th>
                <th>学期</th>
                <th>学号</th>
                <th>姓名</th>
                <th>当前学院</th>
                <th>当前专业</th>
                <th>当前班级</th>
                <th>拟辅修学院</th>
                <th>拟辅修专业</th>
                <th>联系电话</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="zyfxb">
                <tr class="text-c">
                    <td>
                        <input type="checkbox" value="${zyfxb.xh}" name="ids">
                    </td>
                    <td>${zyfxb.zxjxjhm}</td>
                    <td>${zyfxb.xh}</td>
                    <td>${zyfxb.xm}</td>
                    <td>${zyfxb.xsm}</td>
                    <td>${zyfxb.zym}</td>
                    <td>${zyfxb.bjh}</td>
                    <td>${zyfxb.nfxxsm}</td>
                    <td>${zyfxb.nfxzym}</td>
                    <td>${zyfxb.lxdh}</td>
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
