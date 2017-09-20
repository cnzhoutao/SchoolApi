<%--
  Created by IntelliJ IDEA.
  User: zt
  Date: 2017/9/20
  Time: 下午11:46
  To change this template use File | Settings | File Templates.
--%>

<%
    String imgPath = "http://graduate-zt.oss-cn-shanghai.aliyuncs.com/";
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台登录界面</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>layui/global.css">
    <script type="text/javascript" src="<%=basePath%>layui/layui.js"></script>
</head>
<body>

<div class="login_page">

    <h1>欢迎使用</h1>
    <%--登录表单--%>
    <form class="layui-form" style="text-align: center" method="post">
        <div class="layui-form-item">
            <div class="layui-input-inline input-custom-width">
                <input type="text" name="phoneNum" lay-verify="required" placeholder="手机号" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-inline input-custom-width">
                <input type="password" name="pwd" lay-verify="required" placeholder="密码" autocomplete="off"
                       class="layui-input">
            </div>
        </div>

        <%--<div class="layui-form-item">--%>
            <%--<div class="layui-input-inline input-custom-width">--%>
                <%--<input type="text" name="verifyCode" lay-verify="required" placeholder="验证码" autocomplete="off"--%>
                       <%--class="layui-input">--%>
                <%--<div class="captcha"><img src="" alt="captche" title='点击切换'--%>
                                          <%--onclick="this.src='<%=basePath%>login/loginCode.html?id='+Math.random();">--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="layui-form-item">
            <div class="layui-input-inline input-custom-width">
                <button class="layui-btn " lay-submit="" lay-filter="login">登陆</button>

                <button type="button" class="layui-btn layui-btn-warm reg">注册</button>
            </div>
        </div>
    </form>
</div>

<script type="text/javascript">
    var path = '<%=basePath%>';

    layui.use(['form', 'layer', 'jquery'], function () {
        var form = layui.form
            , layer = layui.layer
            , $ = layui.jquery;

        //监听提交,用户登录
        form.on('submit(login)', function (data) {

            loading = layer.load(2, {
                shade: [0.2, '#000'] //0.2透明度的白色背景
            });

            var param = data.field;
            $.post(path + 'loginCheck.html', param, function (data) {
                if (data.code == 1) {
                    layer.close(loading);
                    layer.msg("登录成功，马上为您跳转", {icon: 1, anim: 6, time: 2000}, function () {
                        location.href = path + 'index.html';
                    });
                } else {
                    layer.close(loading);
                    layer.msg(data.msg, {icon: 2, anim: 6, time: 2000});
                }
            });
            return false;
        });
    });
</script>

</body>
</html>
