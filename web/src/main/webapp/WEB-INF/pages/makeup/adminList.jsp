<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>补考报名</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 补考条件管理 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c" style="border: 1px solid; border-radius: 10px;box-sizing: border-box; padding: 10px;background-color: #F5FAFE;">
        <form action="/makeup/list" method="post">
            <input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}">
            <input type="hidden" id="pn" name="pageNumber" value="${page.pageNum}">
            <div class="row cl">
                <label class="col-xs-1 col-sm-1 f-16 text-r">学期：</label>
                <div class="formControls col-xs-2 col-sm-2">
                   <span class="select-box radius">
                      <select class="select" size="1" name="zxjxjhh">
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
                <label class="col-xs-1 col-sm-1 f-16 text-r">学分：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入学分" value="${param.xf}" name="xf" class="input-text radius">
                </div>
            </div>
            <div class="row cl mt-10">
                <label class="col-xs-1 col-sm-1 f-16 text-r">学号：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入考试类型" value="${param.xh}" name="xh" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">姓名：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入考试类型" value="${param.xm}" name="xm" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">最高成绩：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入考试类型" value="${param.maxScore}" name="maxScore" class="input-text radius">
                </div>
                <div class="col-xs-1 col-sm-1">
                    <button type="submit" class="btn btn-success radius" style="width: 100px"><i class="Hui-iconfont">&#xe665;</i> 搜课程</button>
                </div>
            </div>
        </form>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <input class="input-text upload-url radius" placeholder="请输入学号，增加补考课程" type="text" name="add" id="add">
            <a href="javascript:;" onclick="addExtra()" class="btn btn-success radius"><i class="Hui-iconfont f-18">&#xe6dc;</i> 新增</a>
            <a href="javascript:;" onclick="inPay()" class="btn btn-success radius"><i class="Hui-iconfont f-18">&#xe6dc;</i> 缴费</a>
            <a href="javascript:;" onclick="outPay()" class="btn btn-danger radius"><i class="Hui-iconfont f-18">&#xe6de;</i> 取消缴费</a>
            <a href="javascript:;" onclick="window.open('/makeup/export');" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe644;</i> 导出</a>
            <input class="input-text upload-url radius" placeholder="请输入学号，打印追考证" type="text" name="print" id="print">
            <a href="javascript:;" onclick="printCard()" class="btn btn-danger radius"><i class="Hui-iconfont f-18">&#xe6de;</i> 打印准考证</a>
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
                <th>课程号</th>
                <th>课程名</th>
                <th>学分</th>
                <th>最高成绩</th>
                <th>是否报名</th>
                <th>是否缴费</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="courseMk">
                <tr class="text-c">
                    <td>
                        <input type="checkbox" value="${courseMk.id}" name="ids">
                    </td>
                    <td>${courseMk.ZXJXJHM}</td>
                    <td>${courseMk.xh}</td>
                    <td>${courseMk.xm}</td>
                    <td>${courseMk.kch}</td>
                    <td>${courseMk.kcm}</td>
                    <td>${courseMk.xf}</td>
                    <td>${courseMk.maxScore}</td>
                    <td>
                        <c:if test="${courseMk.ifMakeUp == 1}"><span style="color: forestgreen">已报名</span></c:if>
                        <c:if test="${courseMk.ifMakeUp == 0}"><span style="color: red">未报名</span></c:if>
                    </td>
                    <td>
                        <c:if test="${courseMk.ifPay == 1}"><span style="color: forestgreen">已缴费</span></c:if>
                        <c:if test="${courseMk.ifPay == 0}"><span style="color: red">未缴费</span></c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div><%@include file="../common/page.jsp"%></div>
    </div>
</div>
<script type="text/javascript">
    //缴费
    function inPay() {
        var ids = getIds();

        layer.confirm('确认要报考吗？',function(){
            $.ajax({
                type: 'POST',
                url: '/makeup/inpay',
                data : {ids:ids},
                success: function(data){
                    succMsg(data.msg);
                    setTimeout(function () {
                        refresh();
                    },1000)
                },
                error:function(data) {
                    errMsg(data.msg);
                },
            });
        });
    }
    // 取消缴费
    function outPay() {
        var ids = getIds();

        layer.confirm('确认要取消报考吗？',function(){
            $.ajax({
                type: 'POST',
                url: '/makeup/outpay',
                data : {ids:ids},
                success: function(data){
                    succMsg(data.msg);
                    setTimeout(function () {
                        refresh();
                    },1000)
                },
                error:function(data) {
                    errMsg(data.msg);
                },
            });
        });
    }

    // 打印准考证
    function printCard() {
        var xh = $('#print').val();
        if(ifIsNull(xh,"") == "") {
            msg("请输入学号",{icon:3,time:1000})
            return false;
        }else {
            window.open('/makeup/print?xh=' + xh);
        }
    }

    function addExtra() {
        var xh = $('#add').val();
        if(ifIsNull(xh,"") == "") {
            msg("请输入学号",{icon:3,time:1000})
            return false;
        }else {
            add('新增补考数据','/makeup/edit?xh='+xh,'','600')
        }
    }
</script>
</body>
</html>
