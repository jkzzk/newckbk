<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>资质名单管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 资质名单管理 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c" style="border: 1px solid; border-radius: 10px;box-sizing: border-box; padding: 10px;background-color: #F5FAFE;">
        <form action="/langExam/list" method="post">
            <input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}">
            <input type="hidden" id="pn" name="pageNumber" value="${page.pageNum}">
            <div class="row cl">
                <label class="col-xs-1 col-sm-1 f-16 text-r">学期：</label>
                <div class="formControls col-xs-2 col-sm-2">
                   <span class="select-box radius">
                      <select class="select" size="1" name="zxjxjhh" disabled>
                          <%--<option value="" <c:if test="${param.zxjxjhh == null}">selected</c:if>>请选择学期</option>
                          <c:forEach var="t" items="${term}" >
                              <option value="${t.zxjxjhh}" <c:if test="${param.zxjxjhh == t.zxjxjhh}">selected</c:if>>${t.zxjxjhm}</option>
                          </c:forEach>--%>
                      </select>
                    </span>
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">语种类型：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <span class="select-box radius">
                        <select class="select" size="1" name="type">
                            <option value="" <c:if test="${param.type == null}">selected</c:if>>请选择语种类型</option>
                            <option value="CET4" <c:if test="${param.type == 'CET4'}">selected</c:if>>CET4</option>
                            <option value="CET6" <c:if test="${param.type == 'CET6'}">selected</c:if>>CET6</option>
                            <option value="CRT4" <c:if test="${param.type == 'CRT4'}">selected</c:if>>CRT4</option>
                            <option value="CRT6" <c:if test="${param.type == 'CRT6'}">selected</c:if>>CRT6</option>
                            <option value="CJT4" <c:if test="${param.type == 'CJT4'}">selected</c:if>>CJT4</option>
                            <option value="CJT6" <c:if test="${param.type == 'CJT6'}">selected</c:if>>CJT6</option>
                            <option value="CGT4" <c:if test="${param.type == 'CGT4'}">selected</c:if>>CGT4</option>
                            <option value="CGT6" <c:if test="${param.type == 'CGT6'}">selected</c:if>>CGT6</option>
                            <option value="PORECT-B" <c:if test="${param.type == 'PORECT-B'}">selected</c:if>>PORECT-B</option>
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
            </div>
            <div class="row cl mt-10">
                <label class="col-xs-1 col-sm-1 f-16 text-r">身份证号：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入身份证号" value="${param.sfzh}" name="sfzh" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">学历：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <span class="select-box radius">
                        <select class="select" size="1" name="xl">
                            <option value="" <c:if test="${param.xl == null}">selected</c:if>>请选择学历</option>
                            <option value="10" <c:if test="${param.xl == '10'}">selected</c:if>>研究生</option>
                            <option value="20" <c:if test="${param.xl == '20'}">selected</c:if>>本科</option>
                            <option value="30" <c:if test="${param.xl == '30'}">selected</c:if>>专科</option>
                        </select>
                    </span>
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">学制：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <span class="select-box radius">
                        <select class="select" size="1" name="xz">
                            <option value="" <c:if test="${param.xz == null}">selected</c:if>>请选择学制</option>
                            <option value="3" <c:if test="${param.xz == '3'}">selected</c:if>>3年</option>
                            <option value="4" <c:if test="${param.xz == '4'}">selected</c:if>>4年</option>
                            <option value="5" <c:if test="${param.xz == '5'}">selected</c:if>>5年</option>
                        </select>
                    </span>
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">入学年份：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入入学年份" value="${param.rxnf}" name="rxnf" class="input-text radius">
                </div>
            </div>
            <div class="row cl mt-10">
                <label class="col-xs-1 col-sm-1 f-16 text-r">学院：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入学院名称" value="${param.xsm}" name="xsm" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">专业：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入专业名称" value="${param.zym}" name="zym" class="input-text radius">
                </div>
                <label class="col-xs-1 col-sm-1 f-16 text-r">班级：</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" placeholder="请输入班级名称" value="${param.bjh}" name="bjh" class="input-text radius">
                </div>
            </div>
            <div class="row cl">
                <div class="col-xs-1 col-sm-1">
                    <button type="submit" class="btn btn-success radius" style="width: 100px"><i class="Hui-iconfont">&#xe665;</i> 搜名单</button>
                </div>
            </div>
        </form>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="clearData('/langExam/clear')" class="btn btn-danger radius mt-10"><i class="Hui-iconfont f-18">&#xe60b;</i> 清除全部</a>
            <a href="javascript:;" onclick="datadel('/langExam/delete')" class="btn btn-danger radius mt-10"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
            <a href="javascript:;" onclick="add('新增资质名单','/langExam/edit','','600')" class="btn btn-primary radius mt-10"><i class="Hui-iconfont">&#xe600;</i> 新增</a>
            <a href="javascript:;" onclick="edit('修改资质名单','/langExam/edit','','600')" class="btn btn-warning radius mt-10"><i class="Hui-iconfont">&#xe60c;</i> 修改</a>
            <span class="select-box radius mt-10" style="width: 200px;">
                <select class="select" size="1" name="exportType" id="exportType">
                    <option value="" <c:if test="${param.type == null}">selected</c:if>>请选择导出语种类型</option>
                    <option value="CET4" <c:if test="${param.type == 'CET4'}">selected</c:if>>CET4</option>
                    <option value="CET6" <c:if test="${param.type == 'CET6'}">selected</c:if>>CET6</option>
                    <option value="CRT4" <c:if test="${param.type == 'CRT4'}">selected</c:if>>CRT4</option>
                    <option value="CRT6" <c:if test="${param.type == 'CRT6'}">selected</c:if>>CRT6</option>
                    <option value="CJT4" <c:if test="${param.type == 'CJT4'}">selected</c:if>>CJT4</option>
                    <option value="CJT6" <c:if test="${param.type == 'CJT6'}">selected</c:if>>CJT6</option>
                    <option value="CGT4" <c:if test="${param.type == 'CGT4'}">selected</c:if>>CGT4</option>
                    <option value="CGT6" <c:if test="${param.type == 'CGT6'}">selected</c:if>>CGT6</option>
                    <option value="PORECT-B" <c:if test="${param.type == 'PORECT-B'}">selected</c:if>>PORECT-B</option>
                </select>
            </span>
            <a href="javascript:;" onclick="exportLangExam()" class="btn btn-success radius  mt-10"><i class="Hui-iconfont">&#xe641;</i> 导出</a>
            <a href="javascript:;" onclick="generateLangExam(1)" class="btn btn-success-outline radius mt-10"><i class="Hui-iconfont">&#xe61f;</i> 生成CET4名单</a>
            <a href="javascript:;" onclick="generateLangExam(2)" class="btn btn-danger-outline radius mt-10"><i class="Hui-iconfont">&#xe61f;</i> 生成CET6名单</a>
            <a href="javascript:;" onclick="generateLangExam(3)" class="btn btn-success-outline radius mt-10"><i class="Hui-iconfont">&#xe61f;</i> 生成CRT4名单</a>
            <a href="javascript:;" onclick="generateLangExam(4)" class="btn btn-danger-outline radius mt-10"><i class="Hui-iconfont">&#xe61f;</i> 生成CRT6名单</a>
            <a href="javascript:;" onclick="generateLangExam(5)" class="btn btn-success-outline radius mt-10"><i class="Hui-iconfont">&#xe61f;</i> 生成CJT4名单</a>
            <a href="javascript:;" onclick="generateLangExam(6)" class="btn btn-danger-outline radius mt-10"><i class="Hui-iconfont">&#xe61f;</i> 生成CJT6名单</a>
            <a href="javascript:;" onclick="generateLangExam(7)" class="btn btn-success-outline radius mt-10"><i class="Hui-iconfont">&#xe61f;</i> 生成CGT4名单</a>
            <a href="javascript:;" onclick="generateLangExam(8)" class="btn btn-danger-outline radius mt-10"><i class="Hui-iconfont">&#xe61f;</i> 生成CGT6名单</a>
            <a href="javascript:;" onclick="generateLangExam(9)" class="btn btn-danger-outline radius mt-10"><i class="Hui-iconfont">&#xe61f;</i> 生成PORECT-B名单</a>
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
                <!--<th>学期</th>-->
                <th>语种类型</th>
                <th>校区代码</th>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>证件类型</th>
                <th>身份证号</th>
                <th>学历</th>
                <th>学制</th>
                <th>入学年份</th>
                <th>年级</th>
                <th>学院</th>
                <th>专业</th>
                <th>班级号</th>
                <th>学籍代码</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="langExam">
                <tr class="text-c">
                    <td>
                        <input type="checkbox" value="${langExam.id}" name="ids">
                    </td>
                    <td>${langExam.id}</td>
                    <!-- <td>${langExam.zxjxjhm}</td> -->
                    <td>${langExam.type}</td>
                    <td>${langExam.xxdm}</td>
                    <td>${langExam.xh}</td>
                    <td>${langExam.xm}</td>
                    <td>${langExam.xbName}</td>
                    <td>${langExam.zylbName}</td>
                    <td>${langExam.sfzh}</td>
                    <td>${langExam.xlName}</td>
                    <td>${langExam.xzName}</td>
                    <td>${langExam.rxnf}</td>
                    <td>${langExam.nj}</td>
                    <td>${langExam.xsm}</td>
                    <td>${langExam.zym}</td>
                    <td>${langExam.bjh}</td>
                    <td>${langExam.xjdm}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div><%@include file="../common/page.jsp"%></div>
    </div>
</div>

<!-- 等待 -->
<div id="loadingToast" style="display:none;">
    <div class="weui-mask_transparent"></div>
    <div class="weui-toast">
        <i class="weui-loading weui-icon_toast"></i>
        <p class="weui-toast__content">生成中</p>
    </div>
</div>

<script type="text/javascript">
    function generateLangExam(index) {
        $('#loadingToast').show();
        $.request({
            url : '/langExam/generateLangExam?type='+index,
            type : "POST",
            contentType: 'application/json;charset=UTF-8',
            dataType: 'json',
            success : function(result) {
                if(result.code == 1) {
                    succMsg(result.msg);
                }else {
                    errMsg(result.msg);
                }
                setTimeout(function () {
                    $('#loadingToast').hide();
                    $('#btn-refresh').click();
                },1000)
            },
            error:function (message) {
                $('#loadingToast').hide();
                console.log(message);
                errMsg("网络异常");
            }
        });
    }
    
    function exportLangExam() {
        let exportType = $("#exportType").val();
        window.open('/langExam/export?exportType='+exportType)
    }
</script>
</body>
</html>
