<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/common.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <script src="${ctx}/static/verSelector/verSelect.2.0.js"></script>
    <title></title>
    <style>
        .disabled {
            pointer-events: none;
            color: grey;
            cursor: url("${ctx}/static/img/disabled.ico"),default;
        }
    </style>
</head>
<body>
<article class="page-container">
    <form id="form-member-add">
        <div id="student-type" class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">补考对象：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <div class="check-box">
                    <input type="checkbox" id="students" value="1" name="bkdx">
                    <label for="students">在校生</label>
                </div>
                <div class="check-box">
                    <input type="checkbox" checked id="graduate" value="2" name="bkdx">
                    <label for="graduate">结业生</label>
                </div>
            </div>
        </div>
        <div id="makeup-grade" class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">补考年级：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <div id="grade" class=""></div>
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">本学期：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <span class="select-box radius">
                  <select class="select" size="1" name="zxjxjhh" id="term">
                    <option value="" selected>请选择学期</option>
                  </select>
                </span>
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">上学期：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <span class="select-box radius">
                  <select class="select" size="1" name="sxqzxjxjhh" id="prev-term">
                    <option value="" selected>请选择学期</option>
                  </select>
                </span>
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">补考分数：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" id="makeup-score" placeholder="请输入补考分数" class="input-text radius">
            </div>
        </div>
        <div id="makeup-type" class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">补考类型：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <div class="radio-box">
                    <input type="radio" id="studentsMK" value="1" checked name="bklx">
                    <label for="studentsMK">结业生补考</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="graduateMK" value="2" name="bklx">
                    <label for="graduateMK">在校生补考</label>
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-7 col-sm-7 col-xs-offset-5 col-sm-offset-5 mt-10">
                <input type="button" id="submit" class="btn btn-primary radius" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>
</body>
<script type="text/javascript" src="${ctx}/static/js/EducationalSystemJs/bktj.js"></script>
</html>
