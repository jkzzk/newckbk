<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common.jsp"%>
<html>
<head>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
    <title>手机登录</title>
    <link rel="stylesheet" href="${ctx}/static/mobile/css/login.css">
    <script type="text/javascript">
        if(!browserRedirect()) {
            alert("请用手机登录");
            window.open("${ctx}/");
        }
    </script>
</head>
<body>
    <div class="outer">
        <div class="logo">
            <img src="${ctx}/static/mobile/imgs/logo.png" alt="">
        </div>
        <div class="form">
            <div>
                <input class="username" type="text" name="username" id="user_name">
            </div>
            <div>
                <input class="password" type="password" name="password" id="user_password">
            </div>
            <div>
                <button class="btn" id="login_btn">登录</button>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        var outer = document.getElementsByClassName("outer");
        outer[0].style.height = document.body.clientHeight + "px";

        $('#login_btn').click(function () {
            $.ajax({
                type : "POST",
                url : "/mobile/login",
                data : {username : $('#user_name').val(),password : $('#user_password').val()},
                contentType: 'application/x-www-form-urlencoded',
                dataType: 'json',
                success :function(res) {
                    console.log("res",res);
                    if(res == null || res.code == null) {
                        hui.toast("请求失败！", 2000);
                    }
                    if(res.code == 1) {
                        hui.toast(res.msg, 2000);
                        setTimeout(function () {
                            location.href="/mobile/index";
                        },1000)
                    }else{
                        hui.toast(res.msg, 2000);
                    }
                },
                error : function (err) {
                    hui.toast(err, 2000);
                }
            });
        });
    </script>
</body>
</html>
