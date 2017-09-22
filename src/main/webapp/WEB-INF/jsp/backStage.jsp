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
    <title>后台管理界面</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>layui/css/layui.css">
    <script type="text/javascript" src="<%=basePath%>layui/layui.js"></script>
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">校园狸后台管理</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item layui-this"><a href="">发表新闻</a></li>
            <li class="layui-nav-item"><a href="<%=basePath%>userContro.html">用户管理</a></li>
            <li class="layui-nav-item"><a href="<%=basePath%>inviContro.html">帖子管理</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
            </li>
        </ul>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">所有商品</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="javascript:;">列表三</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">云市场</a></li>
                <li class="layui-nav-item"><a href="">发布商品</a></li>
            </ul>
        </div>
    </div>


    <div class="layui-body">
        <div class="layui-form-item" style="margin-top: 20px; ">
            <div class="layui-input-inline input-custom-width">
                <input type="text" name="title" lay-verify="required" placeholder="请输入一个标题" autocomplete="off"
                       class="layui-input title">
            </div>
        </div>

        <textarea class="layui-textarea" id="LAY_demo1" style="display: none">
            请输入你的文章
        </textarea>

        <div class="site-demo-button" style="margin-top: 20px;">
            <button class="layui-btn site-demo-layedit submit" data-type="content">提交</button>
        </div>
    </div>

    <%--footer开始--%>
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
    <%--footer结束--%>


</div>
<script>
    layui.use(['layedit', 'jquery','layer','element','upload'], function () {
        var layedit = layui.layedit
            , $ = layui.jquery
            ,layer=layui.layer
            ,upload = layui.upload;
        var imgName;
        //配置图片上传接口
        layedit.set({
            height: 800,
            uploadImage: {
                url: '<%=basePath%>upload.html' //接口url
            }
        });


        //构建一个默认的编辑器
        var index = layedit.build('LAY_demo1');
//            提交用户编辑的文章
        $('.submit').click(function () {

            if($('.title').val().trim().length=0){
                layer.msg("请先输入标题!",{icon:2,anim:6,time:2000});
                return;
            }
            //提交文章到后台
            $.post('<%=basePath%>saveArticle.html',{
                title:$('.title').val(),
                content:layedit.getContent(index)
            },function (data) {
                if(data.code==1){
                    layer.msg("保存文章成功",{icon:1,anim:6,time:2000},function () {
                        location.reload();
                    });
                }else {
                    layer.msg(data.msg,{icon:2,anim:6,time:2000});
                }
            })
        });

    });


</script>
</body>


</html>
