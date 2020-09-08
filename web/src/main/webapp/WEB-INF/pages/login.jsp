<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/common.jsp"%>

<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${ctx}/lib/html5shiv.js"></script>
    <script type="text/javascript" src="${ctx}/lib/respond.min.js"></script>
    <![endif]-->
    <link href="${ctx}/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="${ctx}/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>后台登录</title>

    <script language="JavaScript">

        if(browserRedirect()) {
            alert("请用电脑登录");
            window.open("${ctx}/mobile/");
        }

        if (window != top)
            top.location.href = location.href;
    </script>

    <style>
        html , body{width: 100%;height: 100%;}
        .loginWindow{position: relative;width: 100%;height: 100%;margin: 0;padding: 0;background: url("${ctx}/static/img/1.jpg") 0 0/100% 100% no-repeat;
            transition: 1s;
        }
        .loginWindow:after{
            content: "";
            position: absolute;
            left : 0;
            top : 0;
            width: 100%;
            height: 100%;
            background: inherit;
            /*filter: blur(5px);*/
            z-index: 2;
        }
        .loginCentreBox{
            position: absolute;
            top: 49%;right: 10%;
            width: 27%;height: auto;
            -webkit-transform: translate(0,-50%);
            -moz-transform: translate(0,-50%);
            -ms-transform: translate(0,-50%);
            -o-transform: translate(0,-50%);
            transform: translate(0,-50%);
            z-index:11;
            /*background-color: rgba(0,0,0,.5);*/
            /*box-shadow:  0 0 10px 6px rgba(0,0,0,.5);*/
        }
        .loginCentreTitle{
            width: 100%;
            height: auto;
            margin-bottom: 40px;
        }
        .loginCentreTitle > p{
            width: 100%;
            height: 24px;
            line-height: 24px;
            font-size: 24px;
            color: #317EF3;
        }
        .loginCentreTitle > span{
            line-height: 20px;
            font-size: 15px;
            color: white;
        }

        .loginCentrePart{
            position: relative;width: 100%;height: 50px;margin-bottom: 30px;border: 1px solid #e6e6e6;background-color: #fff;}
        .loginCentreI{float: left;width: 50px;height: 50px;text-align: center;line-height: 50px;}
        .loginCentreI i{font-size: 20px;color: #cbdae4;}
        .loginCentrePart input{display: block;float: left;width: calc( 100% - 50px );height: 100%;border: none;font-size: 16px;}

        .loginCentreHint{display: none;position: absolute;left: 0;top: 100%;width: 100%;height: 30px;line-height: 30px;font-size: 16px;color: red;}

        .loginCentreBut{width: 100%;height: 50px;margin: 0 auto;background: #4452d5;text-align: center;line-height: 50px;color: #fff;font-size: 20px;letter-spacing: 8px;}

    </style>
</head>
<body>

<div class="loginWindow">
    <div class="loginWindowCover">
        <div class="loginCentreBox">
            <div class="loginCentreTitle">
                <p>用户登录</p>
                <span>USER LOGIN</span>
            </div>
            <div class="loginCentrePart">
                <div class="loginCentreI"><i class="Hui-iconfont">&#xe60d;</i></div>
                <input id="name" name="username" type="text" placeholder="账户" class="" onblur="isName();" onkeyup="isName()">
                <div class="loginCentreHint" id="nameHint">登录名不能为空</div>
            </div>
            <div class="loginCentrePart">
                <div class="loginCentreI"><i class="Hui-iconfont">&#xe60e;</i></div>
                <input id="password" name="password" type="password" placeholder="密码" class="" onblur="isPwd()" onkeyup="isPwd()">
                <div class="loginCentreHint" id="passwordHint">密码不能为空</div>
            </div>
            <div class="loginCentreBut" onclick="submuit();">登录</div>
        </div>
    </div>
</div>
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
    function refresh(){
        $("#img").attr("src","/validateCode?id="+Math.random());
    }
    function isName(){
        if($("#name").val() == ""){
            $("#nameHint").show();
            $("#nameHint").parent().css('border','1px solid red');
            return false;
        }
        else{
            $("#nameHint").hide();
            $("#nameHint").parent().css('border','1px solid #e6e6e6');
            return true;
        }
    }
    function isPwd(){
        if($("#password").val() == ""){
            $("#passwordHint").show();
            $("#passwordHint").parent().css('border','1px solid red');
            return false;
        }
        else{
            $("#passwordHint").hide();
            $("#passwordHint").parent().css('border','1px solid #e6e6e6');
            return true;
        }
    }
    function submuit(){
        if(isName() && isPwd()){
            $.ajax({
                url:'/login',
                data:{
                    username:$("#name").val(),
                    password:$("#password").val(),
                    code:'',
                },
                type:"post",
                success:function(data){
                    console.log('login',data);
                    if(data.code == 0){
                        errMsg(data.msg)
                    }else if(data.code == 1){
                        succMsg(data.msg);
                        setTimeout(function () {
                            location.href="/index";
                        },1000)
                    }else{
                        errMsg(data.msg)
                    }
                },
                error:function (){
                    errMsg("网络异常");
                }
            })
        }
        return false;
    }
    //回车登陆
    $("body").keydown(function() {
        if (event.keyCode == "13") {//keyCode=13是回车键
            submuit();
        }
    });

    $(function() {
        let i = 0;
        setInterval(function () {
            i++;
            $(".loginWindow").attr("style","background-image:url('${ctx}/static/img/"+i+".jpg');")
            i = i  %  3;
        },4000);
    });
</script>
</body>
</html>
