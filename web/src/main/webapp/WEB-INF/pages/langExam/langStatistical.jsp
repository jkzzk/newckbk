<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/bootstrapCommon.jsp"%>
<html>
<head>
    <title>统计报表</title>
    <link rel="stylesheet" href="${ctx}/static/flod/css/main.css">
    <style type="text/css">
        .radio-box {
            width: 20px;
            height: 20px;
        }
        .check-box {
            width: 20px;
            height: 20px;
        }
    </style>
</head>
<body>
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 语种考试统计报表 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <article class="page-container">
        <form id="form-member-add">
            <div class="cl pd-5 bg-1 bk-gray mt-20">
                    <span class="l">
                        <a href="javascript:;" id="statisticAndExport" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe632;</i> 统计并导出</a>
                    </span>
            </div>
            <dl class="foldpanel mt-20" id="my-foldpanel">
                <dt>统计基数</dt>
                <dd>
                    <a>
                        <div class="row cl form-item">
                            <div class="col-xs-2 col-sm-2 text-c">
                                <input type="checkbox" class="check-box" name="dataSource" id="registerData" value="1">
                                <label for="registerData">学籍人数</label>
                            </div>
                            <div class="col-xs-2 col-sm-2 text-c">
                                <input type="checkbox" class="check-box" name="dataSource" id="enterData" value="2">
                                <label for="enterData">报考人数</label>
                            </div>
                        </div>
                    </a>
                </dd>
                <dt>语言级别</dt>
                <dd>
                    <a>
                        <div class="row cl form-item">
                            <div class="col-xs-1 col-sm-1 text-c title">
                                <input type="checkbox" class="check-box" name="langType" id="cet4" value="'CET4'">
                                <label for="cet4">CET4</label>
                            </div>
                            <div class="col-xs-1 col-sm-1 text-c title">
                                <input type="checkbox" class="check-box" name="langType" id="cet6" value="'CET6'">
                                <label for="cet6">CET6</label>
                            </div>
                            <div class="col-xs-1 col-sm-1 text-c title">
                                <input type="checkbox" class="check-box" name="langType" id="cjt4" value="'CJT4'">
                                <label for="cjt4">CJT4</label>
                            </div>
                            <div class="col-xs-1 col-sm-1 text-c title">
                                <input type="checkbox" class="check-box" name="langType" id="cjt6" value="'CJT6'">
                                <label for="cjt6">CJT6</label>
                            </div>
                            <div class="col-xs-1 col-sm-1 text-c title">
                                <input type="checkbox" class="check-box" name="langType" id="crt4" value="'CRT4'">
                                <label for="crt4">CRT4</label>
                            </div>
                            <div class="col-xs-1 col-sm-1 text-c title">
                                <input type="checkbox" class="check-box" name="langType" id="crt6" value="'CRT6'">
                                <label for="crt6">CRT6</label>
                            </div>
                            <div class="col-xs-1 col-sm-1 text-c title">
                                <input type="checkbox" class="check-box" name="langType" id="cgt4" value="'CGT4'">
                                <label for="cgt4">CGT4</label>
                            </div>
                            <div class="col-xs-1 col-sm-1 text-c title">
                                <input type="checkbox" class="check-box" name="langType" id="cgt6" value="'CGT6'">
                                <label for="cgt6">CGT6</label>
                            </div>
                            <div class="col-xs-1 col-sm-1 text-c title">
                                <input type="checkbox" class="check-box" name="langType" id="pretcob" value="'PRETCO-B'">
                                <label for="pretcob">PRETCO-B</label>
                            </div>
                        </div>
                    </a>
                </dd>
                <dt>考试日期</dt>
                <dd>
                    <a>
                        <div class="row cl form-item" id="examDate">
                        <!--<div class="row cl form-item">
                            <div class="col-xs-1 col-sm-1 text-c title">
                                <input type="checkbox" class="check-box" name="examDate" value="'1902'">
                                <label >1902</label>
                            </div>
                        </div>-->
                        </div>
                    </a>
                </dd>
                <dt>统计信息</dt>
                <dd>
                    <a>
                        <div id="infoTree" style="width:100%;"></div>
                    </a>
                </dd>
            </dl>
        </form>
    </article>
    <!-- 等待 -->
    <div id="loadingToast" style="display:none;">
        <div class="weui-mask_transparent"></div>
        <div class="weui-toast">
            <i class="weui-loading weui-icon_toast"></i>
            <p class="weui-toast__content">统计中...</p>
        </div>
    </div>
    <script type="text/javascript" src="${ctx}/static/flod/js/myFoldpanel.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/EducationalSystemJs/langStatistical.js"></script>
</body>
</html>
