<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>叩丁狼客户关系管理系统-登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/Ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/adminlte/css/AdminLTE.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/adminlte/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/adminlte/css/fonts.googleapis.com.css">

    <script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/adminlte/js/adminlte.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/twbsPagination/jquery.twbsPagination.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/messager/jquery.bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/system/commonAll.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/plugins/iCheck/square/blue.css">
    <script src="${pageContext.request.contextPath}/js/plugins/iCheck/icheck.js"></script>
    <script>
        function changeLoginCode(imageEl) {
            imageEl.src = "/randomCode?" + new Date().getTime();
        }
    </script>
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="#"><b>登 录</b></a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg" style="color: red">${requestScope.error}</p>

        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="请输入账号" name="username"
                       value="${cookie.username.value}">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="请输入密码" name="password">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>

            <div class="row">
                <div class="col-xs-8">
                    <input type="text" class="form-control" placeholder="请输入验证码" name="randomCode">
                </div>
                <div class="col-xs-4">
                    <img alt="验证码" style="cursor:pointer;" onclick="changeLoginCode(this)"
                         src="${pageContext.request.contextPath}/randomCode">
                </div>
            </div>

            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox" name="rememberMe"
                                   value="true" ${cookie.username.value==null?"":"checked"}> 记住我
                        </label>
                    </div>
                </div>
                <div class="col-xs-4">
                    <input type="submit" class="btn btn-primary btn-block btn-flat submitBtn" value="登录">
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' /* optional */
        });
    });
</script>
</body>
</html>
