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
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="inExam()" class="btn btn-success radius"><i class="Hui-iconfont f-18">&#xe6dc;</i> 报考</a>
        </span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th>
                    <input type="checkbox" name="ids" value="">
                </th>
                <th>是否报名</th>
                <th>学期</th>
                <th>课程号</th>
                <th>课序号</th>
                <th>课程名</th>
                <th>学分</th>
                <th>学时</th>
                <th>课程属性</th>
                <th>考察类型</th>
                <th>最高成绩</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${courseEx}" var="courseEx">
                <tr class="text-c">
                    <td>
                        <input type="checkbox" value="${courseEx.makupId}" name="ids">
                        <input type="hidden" value="${courseMk.ifMakeUp}" id="${courseMk.makupId}">
                    </td>
                    <td>${courseEx.ifMakeUpName}</td>
                    <td>${courseEx.jxjhh}</td>
                    <td>${courseEx.kch}</td>
                    <td>${courseEx.kxh}</td>
                    <td>${courseEx.kcm}</td>
                    <td>${courseEx.xf}</td>
                    <td>${courseEx.xs}</td>
                    <td>${courseEx.kcsxmc}</td>
                    <td>${courseEx.kslxmc}</td>
                    <td>${courseEx.kccj}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript">
    function inExam() {
        var ids = getIds();

        if(checkRepeat(ids,1,'不能重复报名')) {
            return ;
        }else {
            layer.confirm('确认要报考吗？',function(){
                $.ajax({
                    type: 'POST',
                    url: '/makeup/enter',
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
    }
    
    function checkRepeat(ids,compValue,message) {
        let split = ids.split(",");
        for(let i = 0; i < split.length; i++) {
            if($('#'+ split[i]).val() == compValue) {
                errMsg(message);
                return true;
            }
        }
    }
</script>
</body>
</html>
