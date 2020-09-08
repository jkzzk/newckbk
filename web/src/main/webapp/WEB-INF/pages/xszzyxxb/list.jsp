<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>学生转专业信息管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 学生转专业信息管理 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c" style="border: 1px solid; border-radius: 10px;box-sizing: border-box; padding: 10px;background-color: #F5FAFE;">
        <form id="search-form" action="/xszzyxxb/list" method="post">
            <input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}">
            <input type="hidden" id="pn" name="pageNumber" value="${page.pageNum}">
            <div class="row cl mt-10">
                <label class="col-xs-1 col-sm-1 f-16 text-r">学号：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入学号" value="${param.xh}" id="xh" name="xh" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">姓名：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入姓名" value="${param.xm}" id="xm" name="xm" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">当前年级：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入当前年级" value="${param.dqnj}" id="dqnj" name="dqnj" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">班级名称：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入班级名称" value="${param.bjh}" id="bjh"  name="bjh" class="input-text radius">
                </div>
            </div>
            <div class="row cl mt-10">
                <label class="col-xs-1 col-sm-1 f-16 text-r">生源类别：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入生源类别" value="${param.sylb}" id="sylb" name="sylb" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">录取批次：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入录取批次" value="${param.lqpc}" id="lqpc" name="lqpc" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">当前学院名称：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入当前学院名称" value="${param.currentXsm}" id="currentXsm" name="currentXsm" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">当前专业名称：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入当前专业名称" value="${param.currentZym}" id="currentZym" name="currentZym" class="input-text radius">
                </div>
            </div>
            <div class="row cl mt-10">
                <label class="col-xs-1 col-sm-1 f-16 text-r">拟申请学院名称：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入拟申请学院名称" value="${param.nzrxsm}" id="nzrxsm" name="nzrxsm" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">拟申请专业名称：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入拟申请专业名称" value="${param.nzrzym}" id="nzrzym" name="nzrzym" class="input-text radius">
                </div>
                <div class="col-xs-1 col-sm-1">
                    <button type="submit" class="btn btn-success radius" style="width: 200px"><i class="Hui-iconfont">&#xe665;</i> 搜学生转专业信息</button>
                </div>
            </div>
        </form>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="datadel('/xszzyxxb/del')" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
            <a href="javascript:;" onclick="add('添加拟申请转专业信息','/xszzyxxb/edit','','450')" class="btn btn-success radius"><i class="Hui-iconfont">&#xe600;</i> 添加</a>
            <a href="javascript:;" onclick="edit('修改拟申请转专业信息','/xszzyxxb/edit','','520')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe6df;</i> 修改</a>
            <a href="javascript:;" onclick="exportInfo()" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe644;</i> 导出</a>
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
                <th>学生学号</th>
                <th>学生姓名</th>
                <th>当前年级</th>
                <th>当前班级</th>
                <th>当前学院名称</th>
                <th>当前专业名称</th>
                <th>生源类型</th>
                <th>录取批次</th>
                <th>拟申请学院名称</th>
                <th>拟申请专业名称</th>
                <th>手机号</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="xszzyxx">
                <tr class="text-c">
                    <td>
                        <input type="checkbox" value="${xszzyxx.id}" name="ids">
                    </td>
                    <td>${xszzyxx.id}</td>
                    <td>${xszzyxx.xh}</td>
                    <td>${xszzyxx.xm}</td>
                    <td>${xszzyxx.dqnj}</td>
                    <td>${xszzyxx.bjh}</td>
                    <td>${xszzyxx.currentXsm}</td>
                    <td>${xszzyxx.currentZym}</td>
                    <td>${xszzyxx.sylb}</td>
                    <td>${xszzyxx.lqpc}</td>
                    <td>${xszzyxx.nzrxsm}</td>
                    <td>${xszzyxx.nzrzym}</td>
                    <td>${xszzyxx.sjh}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div><%@include file="../common/page.jsp"%></div>
    </div>
</div>
<script type="text/javascript">

    var searchInfoParam = {
        xh : "",
        xm : "",
        dqnj : "",
        bjh : "",
        sylb : "",
        lqpc : "",
        currentXsm : "",
        currentZym : "",
        nzrxsm : "",
        nzrzym : "",

    }

    function exportInfo() {
        var paramStr = getParam();
        window.open("${ctx}/xszzyxxb/exportXszzyxx" + paramStr)
    }

    function getParam() {
        searchInfoParam.xh = $('#xh').val();
        searchInfoParam.xm = $('#xm').val();
        searchInfoParam.dqnj = $('#dqnj').val();
        searchInfoParam.bjh = $('#bjh').val();
        searchInfoParam.sylb = $('#sylb').val();
        searchInfoParam.lqpc = $('#lqpc').val();
        searchInfoParam.currentXsm = $('#currentXsm').val();
        searchInfoParam.currentZym = $('#currentZym').val();
        searchInfoParam.nzrxsm = $('#nzrxsm').val();
        searchInfoParam.nzrzym = $('#nzrzym').val();

        let searchInfoParamStr = "?"

        $.each(searchInfoParam, function(key, value){
            if(value != "") {
                searchInfoParamStr += key;
                searchInfoParamStr += "=";
                searchInfoParamStr += value;
                searchInfoParamStr += "&";
            }
        });

        return searchInfoParamStr.substr(0,searchInfoParamStr.length-1);
    }
</script>
</body>
</html>
