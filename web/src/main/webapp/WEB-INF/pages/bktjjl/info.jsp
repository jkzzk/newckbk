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
        <div id="student-type" class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">补考对象：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <div class="check-box">
                    <c:if test="${bktj.bkdx == '1' || bktj.bkdx == '1,2'}">
                        <input type="checkbox" id="students" disabled checked value="1" name="bkdx">
                        <label for="students">在校生</label>
                    </c:if>
                    <c:if test="${bktj.bkdx == '2'}">
                        <input type="checkbox" id="students" disabled value="1" name="bkdx">
                        <label for="students">在校生</label>
                    </c:if>
                </div>
                <div class="check-box">
                    <c:if test="${bktj.bkdx == '1'}">
                        <input type="checkbox" id="graduate" disabled  value="2" name="bkdx">
                        <label for="graduate">结业生</label>
                    </c:if>
                    <c:if test="${bktj.bkdx == '2' || bktj.bkdx == '1,2'}">
                        <input type="checkbox" checked id="graduate" disabled checked  value="2" name="bkdx">
                        <label for="graduate">结业生</label>
                    </c:if>
                </div>
            </div>
        </div>
        <c:if test="${bktj.bkdx ne '2'}">
            <div id="makeup-grade" class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
                <label class="col-xs-2 col-sm-2 f-16 text-r">补考年级：</label>
                <div class="formControls col-xs-10 col-sm-10">
                    <div style="font-size: 16px;font-width: bold;color: orange">${bktj.zxnj}</div>
                </div>
            </div>
        </c:if>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">本学期：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <span class="select-box radius">
                  <select class="select" disabled size="1" name="zxjxjhh" id="term">
                    <option value="" selected>${bktj.zxjxjhm}</option>
                  </select>
                </span>
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">上学期：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <span class="select-box radius">
                  <select class="select" size="1" disabled name="sxqzxjxjhh" id="prev-term">
                    <option value="" selected>${bktj.sxqzxjxjhh}</option>
                  </select>
                </span>
            </div>
        </div>
        <div class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">补考分数：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <input type="text" id="makeup-score" value="${bktj.bkfs}" disabled placeholder="请输入补考分数" class="input-text radius">
            </div>
        </div>
        <div id="makeup-type" class="row cl" style="border-bottom: 1px solid #ddd;padding-bottom: 10px;margin-bottom: 10px;">
            <label class="col-xs-2 col-sm-2 f-16 text-r">补考类型：</label>
            <div class="formControls col-xs-10 col-sm-10">
                <div class="radio-box">
                    <c:if test="${bktj.bklx == '1'}">
                        <input type="radio" id="studentsMK" disabled checked  value="1" checked name="bklx">
                        <label for="studentsMK">结业生补考</label>
                    </c:if>
                    <c:if test="${bktj.bklx == '2'}">
                        <input type="radio" id="studentsMK" disabled value="1" checked name="bklx">
                        <label for="studentsMK">结业生补考</label>
                    </c:if>
                </div>
                <div class="radio-box">
                    <c:if test="${bktj.bklx == '2'}">
                        <input type="radio" id="graduateMK" disabled checked value="2" name="bklx">
                        <label for="graduateMK">在校生补考</label>
                    </c:if>
                    <c:if test="${bktj.bklx == '1'}">
                        <input type="radio" id="graduateMK" disabled value="2" name="bklx">
                        <label for="graduateMK">在校生补考</label>
                    </c:if>
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-7 col-sm-7 col-xs-offset-5 col-sm-offset-5 mt-10">
                <input type="button" id="back" class="btn btn-primary radius" value="&nbsp;&nbsp;返回&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>
<script type="text/javascript">
    $(function() {
        $('#student-type input').iCheck({
            checkboxClass: 'icheckbox-blue',
        });

        $('#makeup-type input').iCheck({
            radioClass: 'iradio-blue',
        });
    });
</script>
</body>
</html>
