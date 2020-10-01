<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/common.jsp"%>
<html>
<head>
    <title>四六级条件设置</title>
    <link rel="stylesheet" href="${ctx}/static/flod/css/main.css">
    <style type="text/css">
        .title {
            font-weight: bold;
            color: deepskyblue;
        }
        .check-box {
            width: 20px;
            height: 20px;
        }
    </style>
</head>
<body>
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 语种考试条件设置 <a id="btn-refresh" onclick="refresh()" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="###" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <article class="page-container">
        <form id="form-member-add">
            <div class="cl pd-5 bg-1 bk-gray mt-20">
                <span class="l">
                    <a href="javascript:;" id="saveCondition" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe632;</i> 保存条件</a>
                </span>
            </div>
            <dl class="foldpanel mt-20" id="my-foldpanel">
                <dt>语言级别条件</dt>
                <dd>
                    <a>
                        <div class="row cl form-item">
                            <div class="col-xs-1 col-sm-1 text-c title">
                                <input type="checkbox" class="check-box" name="cet4" id="cet4" value="1">
                                <label for="cet4">CET4</label>
                            </div>
                            <div class="col-xs-11 col-sm-11">
                                <div class="row cl form-item">
                                    <label class="col-xs-1 col-sm-1 f-14 text-r">通过分数：</label>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="text" name="cet4PassScore" id="cet4PassScore" disabled placeholder="通过分数" class="input-text radius">
                                    </div>
                                    <label class="col-xs-1 col-sm-1 f-12 text-r">上次考试时间：</label>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="text" name="cet4LastExamTerm" id="cet4LastExamTerm" disabled placeholder="考试时间" class="input-text radius">
                                    </div>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="checkbox" class="check-box" value="1" checked name="cet4MissingExam" disabled id="cet4MissingExam">
                                        <label for="cet4MissingExam">缺考停考</label>
                                    </div>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="checkbox" class="check-box" value="1" name="cet4PassedExam" disabled id="cet4PassedExam">
                                        <label for="cet4PassedExam">通过刷考</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a>
                        <div class="row cl form-item">
                            <div class="col-xs-1 col-sm-1 text-c title">
                                <input type="checkbox" class="check-box" name="cet6" id="cet6" value="1">
                                <label for="cet6">CET6</label>
                            </div>
                        </div>
                    </a>
                    <a>
                        <div class="row cl form-item">
                            <div class="col-xs-1 col-sm-1 text-c title">
                                <input type="checkbox" class="check-box" name="crt4" id="crt4" value="1">
                                <label for="crt4">CRT4</label>
                            </div>
                            <div class="col-xs-11 col-sm-11">
                                <div class="row cl form-item">
                                    <label class="col-xs-1 col-sm-1 f-14 text-r">通过分数：</label>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="text" name="crt4PassScore" id="crt4PassScore" disabled placeholder="通过分数" class="input-text radius">
                                    </div>
                                    <label class="col-xs-1 col-sm-1 f-12 text-r">上次考试时间：</label>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="text" name="crt4LastExamTerm" id="crt4LastExamTerm" disabled placeholder="考试时间" class="input-text radius">
                                    </div>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="checkbox" class="check-box" value="1" checked name="crt4MissingExam" disabled id="crt4MissingExam">
                                        <label for="crt4MissingExam">缺考停考</label>
                                    </div>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="checkbox" class="check-box" value="1" name="crt4PassedExam" disabled id="crt4PassedExam">
                                        <label for="crt4PassedExam">通过刷考</label>
                                    </div>
                                    <div class="formControls col-xs-2 col-sm-2">
                                        <input type="checkbox" class="check-box" value="1" name="russJoinCet4" disabled id="russJoinCet4">
                                        <label for="russJoinCet4">参加CET4</label>
                                    </div>
                                </div>
                                <div class="row cl form-item mt-10">
                                    <label class="col-xs-1 col-sm-1 f-14 text-r">俄语课程号：</label>
                                    <div class="formControls col-xs-10 col-sm-10">
                                        <input type="text" name="russianKch" id="russianKch" placeholder="课程号" class="input-text radius">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a>
                        <div class="row cl form-item">
                            <div class="col-xs-1 col-sm-1 text-c title">
                                <input type="checkbox" class="check-box" name="crt6" id="crt6" value="1">
                                <label for="crt6">CRT6</label>
                            </div>
                        </div>
                    </a>
                    <a>
                        <div class="row cl form-item">
                            <div class="col-xs-1 col-sm-1 text-c title">
                                <input type="checkbox" class="check-box" name="cjt4" id="cjt4" value="1">
                                <label for="cjt4">CJT4</label>
                            </div>
                            <div class="col-xs-11 col-sm-11">
                                <div class="row cl form-item">
                                    <label class="col-xs-1 col-sm-1 f-14 text-r">通过分数：</label>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="text" name="cjt4PassScore" id="cjt4PassScore" disabled placeholder="通过分数" class="input-text radius">
                                    </div>
                                    <label class="col-xs-1 col-sm-1 f-12 text-r">上次考试时间：</label>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="text" name="cjt4LastExamTerm" id="cjt4LastExamTerm" disabled placeholder="考试时间" class="input-text radius">
                                    </div>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="checkbox" class="check-box" value="1" checked name="cjt4MissingExam" disabled id="cjt4MissingExam">
                                        <label for="cjt4MissingExam">缺考停考</label>
                                    </div>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="checkbox" class="check-box" value="1" name="cjt4PassedExam" disabled id="cjt4PassedExam">
                                        <label for="cjt4PassedExam">通过刷考</label>
                                    </div>
                                    <div class="formControls col-xs-2 col-sm-2">
                                        <input type="checkbox" class="check-box" value="1" name="japaJoinCet4" disabled id="japaJoinCet4">
                                        <label for="japaJoinCet4">参加CET4</label>
                                    </div>
                                </div>
                                <div class="row cl form-item mt-10">
                                    <label class="col-xs-1 col-sm-1 f-14 text-r">日语课程号：</label>
                                    <div class="formControls col-xs-10 col-sm-10">
                                        <input type="text" name="japaneseKch" id="japaneseKch" placeholder="课程号" class="input-text radius">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a>
                        <div class="row cl form-item">
                            <div class="col-xs-1 col-sm-1 text-c title">
                                <input type="checkbox" class="check-box" name="cjt6" id="cjt6" value="1">
                                <label for="cjt6">CJT6</label>
                            </div>
                        </div>
                    </a>
                    <a>
                        <div class="row cl form-item">
                            <div class="col-xs-1 col-sm-1 text-c title">
                                <input type="checkbox" class="check-box" name="cgt4" id="cgt4" value="1">
                                <label for="cgt4">CGT4</label>
                            </div>
                            <div class="col-xs-11 col-sm-11">
                                <div class="row cl form-item">
                                    <label class="col-xs-1 col-sm-1 f-14 text-r">通过分数：</label>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="text" name="cgt4PassScore" id="cgt4PassScore" disabled placeholder="通过分数" class="input-text radius">
                                    </div>
                                    <label class="col-xs-1 col-sm-1 f-12 text-r">上次考试时间：</label>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="text" name="cgt4LastExamTerm" id="cgt4LastExamTerm" disabled placeholder="考试时间" class="input-text radius">
                                    </div>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="checkbox" class="check-box" value="1" checked name="cgt4MissingExam" disabled id="cgt4MissingExam">
                                        <label for="cgt4MissingExam">缺考停考</label>
                                    </div>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="checkbox" class="check-box" value="1" disabled name="cgt4PassedExam" id="cgt4PassedExam">
                                        <label for="cgt4PassedExam">通过刷考</label>
                                    </div>
                                    <div class="formControls col-xs-2 col-sm-2">
                                        <input type="checkbox" class="check-box" value="1" disabled name="germanJoinCet4" id="germanJoinCet4">
                                        <label for="germanJoinCet4">参加CET4</label>
                                    </div>
                                </div>
                                <div class="row cl form-item mt-10">
                                    <label class="col-xs-1 col-sm-1 f-14 text-r">德语课程号：</label>
                                    <div class="formControls col-xs-10 col-sm-10">
                                        <input type="text" name="germanKch" id="germanKch" placeholder="课程号" class="input-text radius">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a>
                        <div class="row cl form-item">
                            <div class="col-xs-1 col-sm-1 text-c title">
                                <input type="checkbox" class="check-box" name="cgt6" id="cgt6" value="1">
                                <label for="cgt6">CGT6</label>
                            </div>
                        </div>
                    </a>
                    <a>
                        <div class="row cl form-item">
                            <div class="col-xs-1 col-sm-1 text-c title">
                                <input type="checkbox" class="check-box" name="pretcoB" id="pretco-b" value="1">
                                <label for="pretco-b">PRETCO-B</label>
                            </div>
                            <div class="col-xs-11 col-sm-11">
                                <div class="row cl form-item">
                                    <label class="col-xs-1 col-sm-1 f-14 text-r">通过分数：</label>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="text" name="pretcoPassScore" id="pretcoPassScore" disabled placeholder="通过分数" class="input-text radius">
                                    </div>
                                    <label class="col-xs-1 col-sm-1 f-12 text-r">上次考试时间：</label>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="text" name="pretcoLastExamTerm" id="pretcoLastExamTerm" disabled placeholder="考试时间" class="input-text radius">
                                    </div>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="checkbox" class="check-box" value="1" checked name="pretcoMissingExam" disabled id="pretcoMissingExam">
                                        <label for="pretcoMissingExam">缺考停考</label>
                                    </div>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="checkbox" class="check-box" value="1" name="pretcoPassedExam" disabled id="pretcoPassedExam">
                                        <label for="pretcoPassedExam">通过刷考</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </dd>
                <dt>报考学生条件</dt>
                <dd>
                    <a>
                        <div class="row cl form-item">
                            <div class="col-xs-1 col-sm-1 text-c title">本科学生年级</div>
                            <div class="col-xs-11 col-sm-11">
                                <div class="formControls col-xs-1 col-sm-1">
                                    <input type="checkbox" class="check-box" value="1" checked name="isFirstGrade" id="isFirstGrade">
                                    <label for="isFirstGrade">大一</label>
                                </div>
                                <div class="formControls col-xs-1 col-sm-1">
                                    <input type="checkbox" class="check-box" value="1" checked name="isSecondGrade" id="isSecondGrade">
                                    <label for="isSecondGrade">大二</label>
                                </div>
                                <div class="formControls col-xs-1 col-sm-1">
                                    <input type="checkbox" class="check-box" value="1" checked name="isThirdGrade" id="isThirdGrade">
                                    <label for="isThirdGrade">大三</label>
                                </div>
                                <div class="formControls col-xs-1 col-sm-1">
                                    <input type="checkbox" class="check-box" value="1" checked name="isFoGrade" id="isFoGrade">
                                    <label for="isFoGrade">大四</label>
                                </div>
                                <div class="formControls col-xs-1 col-sm-1">
                                    <input type="checkbox" class="check-box" value="1" checked name="isFifthGrade" id="isFifthGrade">
                                    <label for="isFifthGrade">大五</label>
                                </div>
                                <label class="col-xs-1 col-sm-1 f-14 text-r"><span style="color: red;">*</span> 大一年级：</label>
                                <div class="formControls col-xs-2 col-sm-2">
                                    <span class="select-box radius">
                                      <select class="select" size="1" name="firstGrade" id="firstGrade">
                                        <option value="" selected>请选择大一年级</option>
                                      </select>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a id="specialxyTab">
                        <div class="row cl form-item">
                            <div class="col-xs-1 col-sm-1 text-c title">特殊学院</div>
                            <div class="col-xs-11 col-sm-11" id="specialxyContent">
                                <!--<div class="formControls col-xs-1 col-sm-1 mt-10">
                                    <input type="checkbox" class="check-box" value="包铁道" name="specialXsm">
                                    <label for="isFirstGrade">包铁道</label>
                                </div>-->
                            </div>
                        </div>
                    </a>
                    <a>
                        <div class="row cl form-item">
                            <div class="col-xs-1 col-sm-1 text-c title">本科学生类别</div>
                            <div class="col-xs-11 col-sm-11" id="benkeTypeContent">
                                <!--<div class="formControls col-xs-1 col-sm-1 mt-10">
                                    <input type="checkbox" class="check-box" name="benkeType" value="3" checked>
                                    <label >本科</label>
                                </div>
                                <div class="formControls col-xs-1 col-sm-1">
                                    <input type="checkbox" class="check-box" name="benkeType" value="2" checked>
                                    <label >专升本</label>
                                </div>
                                <div class="formControls col-xs-1 col-sm-1">
                                    <input type="checkbox" class="check-box" name="benkeType" value="8" checked>
                                    <label >进修1</label>
                                </div>-->
                            </div>
                        </div>
                    </a>
                    <a>
                        <div class="row cl form-item">
                            <div class="col-xs-1 col-sm-1 text-c title">专科学生年级</div>
                            <div class="col-xs-11 col-sm-11">
                                <div class="formControls col-xs-1 col-sm-1">
                                    <input type="checkbox" class="check-box" value="1" checked name="isJuniorFirstGrade" id="isJuniorFirstGrade">
                                    <label for="cet4MissingExam">专一</label>
                                </div>
                                <div class="formControls col-xs-1 col-sm-1">
                                    <input type="checkbox" class="check-box" value="1" checked name="isJuniorSecondGrade" id="isJuniorSecondGrade">
                                    <label for="cet4MissingExam">专二</label>
                                </div>
                                <div class="formControls col-xs-1 col-sm-1">
                                    <input type="checkbox" class="check-box" value="1" checked name="isJuniorThirdGrade" id="isJuniorThirdGrade">
                                    <label for="cet4MissingExam">专三</label>
                                </div>
                                <label class="col-xs-1 col-sm-1 f-14 text-r"><span style="color: red;">*</span> 专一年级：</label>
                                <div class="formControls col-xs-2 col-sm-2">
                                   <span class="select-box radius">
                                      <select class="select" size="1" name="juniorFirstGrade" id="juniorFirstGrade">
                                        <option value="" selected>请选择大一年级</option>
                                      </select>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a>
                        <div class="row cl form-item">
                            <div class="col-xs-1 col-sm-1 text-c title">专科学生类别</div>
                            <div class="col-xs-11 col-sm-11" id="juniorTypeContent">
                                <!--div class="formControls col-xs-1 col-sm-1">
                                    <input type="checkbox" class="check-box" name="juniorType" value="5"  checked>
                                    <label>高职</label>
                                </div>-->
                            </div>
                        </div>
                    </a>
                </dd>
                <dt>特殊年级条件</dt>
                <dd>
                    <a id="firstGradeSpecial">
                        <div class="row cl form-item">
                            <div class="col-xs-1 col-sm-1 text-c title">大一</div>
                            <div class="col-xs-11 col-sm-11">
                                <div class="row cl form-item">
                                    <div class="formControls col-xs-2 col-sm-2">
                                        <span class="select-box radius">
                                          <select class="select" size="1" name="dataSource" id="dataSource">
                                            <option value="0" selected>请选择筛选数据源</option>
                                            <option value="1">分班成绩</option>
                                            <option value="2">大学英语(1)成绩</option>
                                          </select>
                                        </span>
                                    </div>
                                    <label class="col-xs-2 col-sm-2 text-r">大学英语(1)课程号：</label>
                                    <div class="formControls col-xs-2 col-sm-2">
                                        <input type="text" name="englisthKch" id="englisthKch" disabled placeholder="请输入课程号" class="input-text radius">
                                    </div>
                                    <label class="col-xs-2 col-sm-2 text-r">大学英语(1)筛选学期：</label>
                                    <div class="formControls col-xs-2 col-sm-2">
                                        <span class="select-box radius">
                                          <select class="select" size="1" disabled name="englisthZxjxjhh"  id="examTerm">
                                            <option value="" selected>请选择学期</option>
                                          </select>
                                        </span>
                                    </div>
                                </div>
                                <div class="row cl form-item mt-10">
                                    <label class="col-xs-2 col-sm-2 f-16 text-r">A班英语课序号(用逗号隔开)：</label>
                                    <div class="formControls col-xs-9 col-sm-9">
                                        <textarea disabled class="textarea radius" name="classaKxh" id="classaKxh" placeholder="请输入课程号"></textarea>
                                    </div>
                                </div>
                                <div class="row cl form-item mt-10">
                                    <label class="col-xs-2 col-sm-2 f-16 text-r">B班英语课序号(用逗号隔开)：</label>
                                    <div class="formControls col-xs-9 col-sm-9">
                                        <textarea disabled class="textarea radius" name="classbKxh" id="classbKxh" placeholder="请输入课程号"></textarea>
                                    </div>
                                </div>
                                <div class="row cl form-item mt-10">
                                    <label class="col-xs-2 col-sm-2 f-16 text-r">C班英语课序号(用逗号隔开)：</label>
                                    <div class="formControls col-xs-9 col-sm-9">
                                        <textarea disabled class="textarea radius" name="classcKxh" id="classcKxh" placeholder="请输入课程号"></textarea>
                                    </div>
                                </div>
                                <div class="row cl form-item mt-10">
                                    <label class="col-xs-1 col-sm-1 text-r">
                                        <input type="checkbox" value="1" class="check-box" name="classA" id="classA">
                                        A班成绩：
                                    </label>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="text" disabled name="classaEnglish" id="classaEnglish" placeholder="请输入成绩" class="input-text radius">
                                    </div>
                                    <label class="col-xs-1 col-sm-1 text-r">
                                        <input type="checkbox" value="1" class="check-box" name="classB" id="classB">
                                        B班成绩：
                                    </label>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="text" disabled name="classbEnglish" id="classbEnglish" placeholder="请输入成绩" class="input-text radius">
                                    </div>
                                    <label class="col-xs-1 col-sm-1 text-r">
                                        <input type="checkbox" value="1" class="check-box" name="classC" id="classC">
                                        C班成绩：
                                    </label>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="text" disabled name="classcEnglish" id="classcEnglish" placeholder="请输入成绩" class="input-text radius">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a id="secondGradeSpecial">
                        <div class="row cl form-item">
                            <div class="col-xs-1 col-sm-1 text-c title">大二</div>
                            <div class="col-xs-11 col-sm-11">
                                <div class="row cl form-item">
                                    <label class="col-xs-2 col-sm-2 text-r">大学英语(2)课序号：</label>
                                    <div class="formControls col-xs-2 col-sm-2">
                                        <input type="text" name="englisthSecondKch" id="englisthSecondKch" placeholder="请输入课程号" class="input-text radius">
                                    </div>
                                    <label class="col-xs-2 col-sm-2 text-r">大学英语(2)筛选学期：</label>
                                    <div class="formControls col-xs-2 col-sm-2">
                                        <span class="select-box radius">
                                          <select class="select" size="1" name="englisthSecondZxjxjhh" id="examSecondTerm">
                                            <option value="" selected>请选择学期</option>
                                          </select>
                                        </span>
                                    </div>
                                </div>
                                <div class="row cl form-item mt-10">
                                    <label class="col-xs-2 col-sm-2 f-16 text-r">A班英语课序号(用逗号隔开)：</label>
                                    <div class="formControls col-xs-9 col-sm-9">
                                        <textarea class="textarea radius" name="classaSecondKxh" id="classaSecondKxh" placeholder="请输入课程号"></textarea>
                                    </div>
                                </div>
                                <div class="row cl form-item mt-10">
                                    <label class="col-xs-2 col-sm-2 f-16 text-r">B班英语课序号(用逗号隔开)：</label>
                                    <div class="formControls col-xs-9 col-sm-9">
                                        <textarea class="textarea radius" name="classbSecondKxh" id="classbSecondKxh" placeholder="请输入课程号"></textarea>
                                    </div>
                                </div>
                                <div class="row cl form-item mt-10">
                                    <label class="col-xs-2 col-sm-2 f-16 text-r">C班英语课序号(用逗号隔开)：</label>
                                    <div class="formControls col-xs-9 col-sm-9">
                                        <textarea class="textarea radius" name="classcSecondKxh" id="classcSecondKxh" placeholder="请输入课程号"></textarea>
                                    </div>
                                </div>
                                <div class="row cl form-item mt-10">
                                    <label class="col-xs-1 col-sm-1 text-r">
                                        <input type="checkbox" value="1" class="check-box" name="classSecondA" id="classSecondA">
                                        A班成绩：
                                    </label>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="text" disabled name="classaSecondEnglish" id="classaSecondEnglish" placeholder="请输入成绩" class="input-text radius">
                                    </div>
                                    <label class="col-xs-1 col-sm-1 text-r">
                                        <input type="checkbox" value="1" class="check-box" name="classSecondB" id="classSecondB">
                                        B班成绩：
                                    </label>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="text" disabled name="classbSecondEnglish" id="classbSecondEnglish" placeholder="请输入成绩" class="input-text radius">
                                    </div>
                                    <label class="col-xs-1 col-sm-1 text-r">
                                        <input type="checkbox" value="1" class="check-box" name="classSecondC" id="classSecondC">
                                        C班成绩：
                                    </label>
                                    <div class="formControls col-xs-1 col-sm-1">
                                        <input type="text" disabled name="classcSecondEnglish" id="classcSecondEnglish" placeholder="请输入成绩" class="input-text radius">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </dd>
            </dl>
        </form>
    </article>
    <script type="text/javascript" src="${ctx}/static/flod/js/myFoldpanel.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/EducationalSystemJs/cet4.js"></script>
</body>
</html>
