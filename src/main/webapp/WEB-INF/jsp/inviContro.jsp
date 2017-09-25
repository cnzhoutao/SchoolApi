<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: zt
  Date: 2017/9/22
  Time: 下午2:08
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
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>layui/css/layui.css">
    <script type="text/javascript" src="<%=basePath%>layui/layui.js"></script>
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">校园狸后台管理</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="<%=basePath%>index.html">发表新闻</a></li>
            <li class="layui-nav-item "><a href="<%=basePath%>userContro.html">用户管理</a></li>
            <li class="layui-nav-item layui-this"><a href="<%=basePath%>inviContro.html">帖子管理</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="<%=basePath%>img/huli.png" class="layui-nav-img">
                    admin
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

                <c:forEach items="${adminList}" var="stu">
                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;">${stu.userName}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>


    <div class="layui-body">
        <%--内容开始--%>

        <table class="layui-table">
            <colgroup>
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>标题</th>
                <th>发表用户</th>
                <th>类别</th>
                <th>发表时间</th>
                <th>点赞量</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="invi">
                <tr>
                    <td>${invi.title}</td>
                    <td>${invi.userName}</td>
                    <td>${invi.type}</td>
                    <td>
                        <fmt:formatDate value="${invi.creTime}" pattern="yyyy-MM-dd"/>
                    </td>
                    <td>
                        ${invi.likeNum}
                    </td>
                    <td>
                        <a class="layui-btn layui-btn-danger layui-btn-mini delete" flag="${invi.id}">
                            删除
                        </a>

                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>

        <%--内容结束--%>
    </div>

    <%--footer开始--%>
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 校园狸
    </div>
    <%--footer结束--%>


</div>
<script>
    layui.use(['jquery', 'layer', 'element'], function () {

        var
            $ = layui.jquery
            , layer = layui.layer;

        $('.delete').click(function () {

            $.post("<%=basePath%>deleteInvi.html",{inviId:this.getAttribute("flag")},function (data) {
                if(data.code==1){
                    layer.msg("删除成功",{icon:1,anim:6,time:500},function () {
                        location.reload();
                    });
                }else {
                    layer.msg('网络不佳，请稍后重试',{icon:2,anim:6,time:500});
                }

            });

        })

    });

</script>
</body>

</html>
