<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title></title>
</head>
<body>
<article class="page-container">
    <form id="form-member-add">
        <input type="hidden" id="old_bkkg" value="${kz.bkkg}">
        <input type="hidden" id="old_fxkg" value="${kz.fxkg}">
        <input type="hidden" id="old_zzykg" value="${kz.zzykg}">
        <input type="hidden" id="old_cetkg" value="${kz.cetkg}">
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <div class="col-xs-1 col-sm-1"></div>
            <label class="col-xs-2 col-sm-2 f-16 text-l">补考开关：</label>
            <div class="formControls col-xs-2 col-sm-2">
                <div id="bkkg" class="switch" data-on-label="开启" data-on="primary" data-off="danger" data-off-label="关闭">
                    <input type="checkbox" />
                </div>
            </div>
            <div class="col-xs-2 col-sm-2"></div>
            <label class="form-label col-xs-2 col-sm-2 f-16 text-l">辅修开关：</label>
            <div class="formControls col-xs-2 col-sm-2">
                <div id="fxkg" class="switch" data-on-label="开启" data-on="primary" data-off="danger" data-off-label="关闭">
                    <input type="checkbox" />
                </div>
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <div class="col-xs-1 col-sm-1"></div>
            <label class="form-label col-xs-2 col-sm-2 f-16 text-l">转专业开关：</label>
            <div class="formControls col-xs-2 col-sm-2">
                <div id="zzykg" class="switch" data-on-label="开启" data-on="primary" data-off="danger" data-off-label="关闭">
                    <input type="checkbox" />
                </div>
            </div>
            <div class="col-xs-2 col-sm-2"></div>
            <label class="form-label col-xs-2 col-sm-2 f-16 text-l">CET开关：</label>
            <div class="formControls col-xs-2 col-sm-2">
                <div id="cetkg" class="switch" data-on-label="开启" data-on="primary" data-off="danger" data-off-label="关闭">
                    <input type="checkbox" />
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-7 col-sm-7 col-xs-offset-5 col-sm-offset-5">
                <input type="button" id="submit" class="btn btn-primary radius" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>
</body>
<script type="text/javascript" src="${ctx}/static/js/EducationalSystemJs/kgkz.js"></script>
</html>
