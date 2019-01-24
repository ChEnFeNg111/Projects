<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Dashboard with Off-canvas Sidebar</title>
    <meta name="generator" content="Bootply"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>


<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">用户中心</a>
        </div>
    </div>
</nav>


<div class="container-fluid">

    <div class="row row-offcanvas row-offcanvas-left">

        <div class="col-sm-3 col-md-2 sidebar-offcanvas" id="sidebar" role="navigation">

            <ul class="nav nav-sidebar">
                <li><a href="/uploadprogram.jsp">方案上传</a></li>
                <li><a href="/usermanage/customerhistory?page=1&qiYeId=1">购买记录</a></li>
                <li><a href="/usermanage/uploadhistory?page=1&qiYeId=1">上传记录</a></li>
                <li><a href="/updatepassword.jsp">修改密码</a></li>
            </ul>
        </div><!--/span-->

        <div class="col-sm-9 col-md-10 main">

            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>文案名称</th>
                        <th>文案属性</th>
                        <th>文案价格</th>
                        <th>审核状态</th>
                        <th>文案上传时间</th>
                        <th>文案下载量</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${p.list}" var="i">
                            <tr>
                                <td >${i.programName}</td>
                                <td>
                                    <c:forEach items="${i.list}" var="rfmclass">
                                        <span>${rfmclass}</span>
                                    </c:forEach>
                                </td>
                                <td>${i.price}</td>
                                <td>${i.checkStatus}</td>
                                <td>${i.publishTime}</td>
                                <td>${i.count}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div  style="align-content: right">
                      <span >
                            <a href="/usermanage/uploadhistory?page=${p.first}&qiYeId=1">首页</a>
                            <c:if test="${p.hasPre()}">
                                <a href="/usermanage/uploadhistory?page=${p.pre}&qiYeId=1" >上一页</a>
                            </c:if>
                        </span>

                        <c:forEach begin="${p.one}" end="${p.end}" var="i">
                            <span>
                                <c:if test="${p.isCurrent(i)}">
                                                   <span class="current"
                                                         style=" background-color: brown; color: white">
                                                           第${i}页
                                                   </span>
                                </c:if>

                                <c:if test="${!p.isCurrent(i)}">
                                                    <span class="paginate_button ">
                                                         <a href="/usermanage/uploadhistory?page=${i}&qiYeId=1">第${i}页</a>
                                                    </span>
                                </c:if>
                            </span>
                        </c:forEach>

                        <span>

                            <c:if test="${(p.hasNext())}">
                                <a href="/usermanage/uploadhistory?page=${p.next}&qiYeId=1">下一页</a>
                            </c:if>
                            <a href="/usermanage/uploadhistory??page=${p.last}&qiYeId=1">尾页</a>
                        </span>


                </div>
            </div>
            </div>
        </div>
    </div>
</div>

<!-- script references -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/scripts.js"></script>
</body>
</html>