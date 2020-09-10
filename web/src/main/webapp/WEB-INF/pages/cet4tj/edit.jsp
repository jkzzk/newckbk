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
        .form-item {
            border-bottom: 1px solid #ddd;
            padding-bottom: 10px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<article class="page-container">
    <form id="form-member-add">
        <div class="row cl form-item">
            <label class="col-xs-2 col-sm-2 f-16 text-r">本学期：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <span class="select-box radius">
                  <select class="select" size="1" name="zxjxjhh" id="currentTerm">
                    <option value="" selected>请选择学期</option>
                  </select>
                </span>
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-2 col-sm-2 f-16 text-r">大一年级：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <span class="select-box radius">
                  <select class="select" size="1" name="firstGrade" id="firstGrade">
                    <option value="" selected>请选择大一年级</option>
                  </select>
                </span>
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-2 col-sm-2 f-16 text-r">选择上下学期：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <div class="radio-box">
                    <input type="radio" id="term-f" value="1" checked name="halfTerm">
                    <label for="term-f">上半学期</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="term-s" value="2" name="halfTerm">
                    <label for="term-s">下半学期</label>
                </div>
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-4 col-sm-4 f-16 text-r">CET4上一次考试时间(例:1902)：</label>
            <div class="formControls col-xs-8 col-sm-8">
                <input type="text" name="lastExamTerm" id="lastExamTerm" placeholder="请输入考试时间" class="input-text radius">
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-4 col-sm-4 f-16 text-r">CET4通过分数：</label>
            <div class="formControls col-xs-8 col-sm-8">
                <input type="text" name="cet4PassScore" id="cet4PassScore" placeholder="请输入通过分数" class="input-text radius">
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-4 col-sm-4 f-16 text-r">CRT4通过分数：</label>
            <div class="formControls col-xs-8 col-sm-8">
                <input type="text" name="crt4PassScore" id="crt4PassScore" placeholder="请输入通过分数" class="input-text radius">
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-4 col-sm-4 f-16 text-r">CJT4通过分数：</label>
            <div class="formControls col-xs-8 col-sm-8">
                <input type="text" name="cjt4PassScore" id="cjt4PassScore" placeholder="请输入通过分数" class="input-text radius">
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-2 col-sm-2 f-16 text-r">缺考是否停考：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <div class="radio-box">
                    <input type="radio" id="stop-y" value="1" checked name="missingExam">
                    <label for="stop-y">是</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="stop-n" value="0" name="missingExam">
                    <label for="stop-n">否</label>
                </div>
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-2 col-sm-2 f-16 text-r">是否可以刷考：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <div class="radio-box">
                    <input type="radio" id="pass-y" value="1" checked name="passedExam">
                    <label for="pass-y">是</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="pass-n" value="0" name="passedExam">
                    <label for="pass-n">否</label>
                </div>
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-2 col-sm-2 f-16 text-r">学日语是否能考：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <div class="radio-box">
                    <input type="radio" id="japa-y" value="1" checked name="isJapanese">
                    <label for="japa-y">是</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="japa-n" value="0" name="isJapanese">
                    <label for="japa-n">否</label>
                </div>
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-3 col-sm-3 f-16 text-r">日语课程号(用逗号隔开)：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <input type="text" name="japaneseKch" id="japaneseKch" placeholder="请输入日语课程号" class="input-text radius">
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-2 col-sm-2 f-16 text-r">学俄语是否能考：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <div class="radio-box">
                    <input type="radio" id="russ-y" value="1" checked name="isRussian">
                    <label for="russ-y">是</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="russ-n" value="0" name="isRussian">
                    <label for="russ-n">否</label>
                </div>
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-3 col-sm-3 f-16 text-r">俄语课程号(用逗号隔开)：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <input type="text" name="russianKch" id="russianKch" placeholder="请输入俄语课程号" class="input-text radius">
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-3 col-sm-3 f-16 text-r">英语3级通过分数：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <input type="text" name="cet3Score" id="cet3Score" placeholder="请输入通过分数" class="input-text radius">
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-3 col-sm-3 f-16 text-r">不能参与考试的学院(使用逗号隔开)：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <input type="text" name="specialXsm" id="specialXsm" placeholder="请输入学院名称" class="input-text radius">
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-2 col-sm-2 f-16 text-r">A班最低成绩：</label>
            <div class="formControls col-xs-4 col-sm-4">
                <input type="text" name="classaMin" id="classaMin" placeholder="请输入最低成绩" class="input-text radius">
            </div>
            <label class="col-xs-2 col-sm-2 f-16 text-r">A班最高成绩：</label>
            <div class="formControls col-xs-4 col-sm-4">
                <input type="text" name="classaMax" id="classaMax" placeholder="请输入最高成绩" class="input-text radius">
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-2 col-sm-2 f-16 text-r">B班最低成绩：</label>
            <div class="formControls col-xs-4 col-sm-4">
                <input type="text" name="classbMin" id="classbMin" placeholder="请输入最低成绩" class="input-text radius">
            </div>
            <label class="col-xs-2 col-sm-2 f-16 text-r">B班最高成绩：</label>
            <div class="formControls col-xs-4 col-sm-4">
                <input type="text" name="classbMax" id="classbMax" placeholder="请输入最高成绩" class="input-text radius">
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-2 col-sm-2 f-16 text-r">C班最低成绩：</label>
            <div class="formControls col-xs-4 col-sm-4">
                <input type="text" name="classcMin" id="classcMin" placeholder="请输入最低成绩" class="input-text radius">
            </div>
            <label class="col-xs-2 col-sm-2 f-16 text-r">C班最高成绩：</label>
            <div class="formControls col-xs-4 col-sm-4">
                <input type="text" name="classcMax" id="classcMax" placeholder="请输入最高成绩" class="input-text radius">
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-3 col-sm-3 f-16 text-r">A班英语课程号(用逗号隔开)：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <textarea class="textarea radius" name="classaKxh" id="classaKxh" placeholder="请输入课程号"></textarea>
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-3 col-sm-3 f-16 text-r">B班英语课程号(用逗号隔开)：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <textarea class="textarea radius" name="classbKxh" id="classbKxh" placeholder="请输入课程号"></textarea>
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-3 col-sm-3 f-16 text-r">C班英语课程号(用逗号隔开)：</label>
            <div class="formControls col-xs-9 col-sm-9">
                <textarea class="textarea radius" name="classcKxh" id="classcKxh" placeholder="请输入课程号"></textarea>
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-3 col-sm-3 f-16 text-r">A班大英(1)最低成绩：</label>
            <div class="formControls col-xs-3 col-sm-3">
                <input type="text" name="classaEnglishMin" id="classaEnglishMin" placeholder="请输入最低成绩" class="input-text radius">
            </div>
            <label class="col-xs-3 col-sm-3 f-16 text-r">A班大英(1)最高成绩：</label>
            <div class="formControls col-xs-3 col-sm-3">
                <input type="text" name="classaEnglishMax" id="classaEnglishMax" placeholder="请输入最高成绩" class="input-text radius">
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-3 col-sm-3 f-16 text-r">B班大英(1)最低成绩：</label>
            <div class="formControls col-xs-3 col-sm-3">
                <input type="text" name="classbEnglishMin" id="classbEnglishMin" placeholder="请输入最低成绩" class="input-text radius">
            </div>
            <label class="col-xs-3 col-sm-3 f-16 text-r">B班大英(1)最高成绩：</label>
            <div class="formControls col-xs-3 col-sm-3">
                <input type="text" name="classbEnglishMax" id="classbEnglishMax" placeholder="请输入最高成绩" class="input-text radius">
            </div>
        </div>
        <div class="row cl form-item">
            <label class="col-xs-3 col-sm-3 f-16 text-r">C班大英(1)最低成绩：</label>
            <div class="formControls col-xs-3 col-sm-3">
                <input type="text" name="classcEnglishMin" id="classcEnglishMin" placeholder="请输入最低成绩" class="input-text radius">
            </div>
            <label class="col-xs-3 col-sm-3 f-16 text-r">C班大英(1)最高成绩：</label>
            <div class="formControls col-xs-3 col-sm-3">
                <input type="text" name="classcEnglishMax" id="classcEnglishMax" placeholder="请输入最高成绩" class="input-text radius">
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
<script type="text/javascript" src="${ctx}/static/js/EducationalSystemJs/cet4.js"></script>
</html>
