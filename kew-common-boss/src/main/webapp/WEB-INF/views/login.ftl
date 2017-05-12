<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>运营支持平台</title>
<#include "/common/resources.ftl"/>

    <link href="${css}/login/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="${css}/login/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />

    <link href="${css}/login/font-awesome.css" rel="stylesheet">

    <link href="${css}/login/style.css" rel="stylesheet" type="text/css">
    <link href="${css}/login/pages/signin.css" rel="stylesheet" type="text/css">
<style>

</style>

</head>
<body>

<div class="navbar navbar-fixed-top">

    <div class="navbar-inner">

        <div class="container">

            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>

            <a class="brand" href="javascript:void(0)">
                运营支持平台
            </a>

            <div class="nav-collapse">
                <ul class="nav pull-right">

                    <#--<li class="">-->
                        <#--<a href="signup.html" class="">-->
                            <#--Don't have an account?-->
                        <#--</a>-->

                    <#--</li>-->

                    <#--<li class="">-->
                        <#--<a href="index.html" class="">-->
                            <#--<i class="icon-chevron-left"></i>-->
                            <#--Back to Homepage-->
                        <#--</a>-->

                    <#--</li>-->
                </ul>

            </div><!--/.nav-collapse -->

        </div> <!-- /container -->

    </div> <!-- /navbar-inner -->

</div> <!-- /navbar -->



<div class="account-container">

    <div class="content clearfix">

        <form action="${ctx}/user/auth" method="post"  onkeydown="enterLogin(event)">

            <h1>用户登录</h1>

            <div class="login-fields">

                <#--<p>Please provide your details</p>-->

                <div class="field">
                    <input type="password" style="position: absolute;top:-999px;display: none;">
                    <label for="username">登录名</label>
                    <input type="text" id="username" name="username" value="${username}" placeholder="登录名" class="login username-field"  autocomplete="off" />
                </div> <!-- /field -->

                <div class="field">
                    <label for="password">密码:</label>
                    <input type="password" id="password" name="password" value="${password}" placeholder="密码" class="login password-field" autocomplete="off" />
                </div> <!-- /password -->
                    <div class="field">
                    <label for="password">验证码:</label>
                    <input type="text" style="width: 152px; float: left;" id="validateCode" name="validateCode" value="" placeholder="验证码" class="login" autocomplete="off" />
                    <img id="imgVcode"  src="${ctx}/image.action" width="70" height="40" onclick="document.getElementById('imgVcode').src = '${ctx}/image.action?'+(new Date()).getTime()" alt="看不清楚 ？点击换一张">
                </div> <!-- /validateCode -->

            </div> <!-- /login-fields -->

            <div class="login-actions">

				<span class="login-checkbox">
					<input id="Field" name="rememberMe" type="checkbox" class="field login-checkbox" value="${rememberMe}" tabindex="4" />
					<label class="choice" for="Field">记住我</label>
				</span>
                <span id="errormsg" class="errormsg_span">${message}</span>

                <button class="button btn btn-success btn-large" onclick="javascript:login();return false;">登录</button>

            </div> <!-- .actions -->



        </form>

    </div> <!-- /content -->

</div> <!-- /account-container -->





<script src="${js}/jquery-1.7.2.min.js"></script>
<script src="${js}/bootstrap.js"></script>

<script type="text/javascript">
    $(function () {

        jQuery.support.placeholder = false;
        test = document.createElement('input');
        if('placeholder' in test) jQuery.support.placeholder = true;

        if (!$.support.placeholder) {

            $('.field').find ('label').show ();

        }

    });

    function enterLogin(event) {
        if (event.keyCode == 13) {
            login();
        }
    }

    function login() {
        var flag = true;
        if(!$.trim($('#username').val())) {
            $('#errormsg').html('请输入用户名！');
            return false;
        }
        if(!$.trim($('#password').val())) {
            $('#errormsg').html('请输入密码！');
            return false;
        }
        if(!$.trim($('#validateCode').val())) {
            $('#errormsg').html('请输入验证码！');
            return false;
        }

        $('form').submit();
    }


</script>

</body>

</html>