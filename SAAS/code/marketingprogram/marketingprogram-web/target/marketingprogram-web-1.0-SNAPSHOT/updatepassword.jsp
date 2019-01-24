<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        <div class="col-sm-9 col-md-10 main" align="center" >
            <form action="/usermanage/updatepassword?qiYeId=1"  method="post" class="form-horizontal" class="smart-form client-form">
                <fieldset>
                    <div id="legend" class="">
                        <br>
                        <br>
                    <div class="control-group">
                        <!-- Text input-->

                        <div class="controls">
                            <label class="control-label" style="font-size: 20px" >原密码</label>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="password" placeholder="请输入原始密码" class="input-xlarge">
                            <p class="help-block"></p>
                            <p class="help-block"></p>
                        </div>
                    </div>

                        <br>
                        <br>
                    <div class="control-group">
                        <!-- Text input-->

                        <div class="controls">
                            <label class="control-label" style="font-size: 20px" >新密码</label>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="password" name="newPassword" placeholder="请输入新密码" class="input-xlarge">
                            <p class="help-block"></p>
                            <p class="help-block"></p>
                        </div>
                    </div>

                        <br>
                        <br>
                    <div class="control-group">
                        <!-- Text input-->

                        <div class="controls">
                            <label class="control-label" style="font-size: 20px" >确认新密码</label>

                            <input type="password" placeholder="再次输入新密码" class="input-xlarge">
                            <p class="help-block"></p>
                            <p class="help-block"></p>
                        </div>
                    </div>
                        <br>
                        <br>
                    <div class="control-group">
                        <!-- Button -->
                        <div class="controls">
                            <button type="submit" class="btn btn-success" >确认修改</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="/usermanage/customerhistory?page=1&qiYeId=1">
                                <input type="button" class="btn btn-success" value="返回主界面"></input>
                            </a>
                        </div>
                    </div>
                    </div>
                </fieldset>
            </form>

        </div>

    </div>
</div>

<!-- script references -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/scripts.js"></script>
</body>
</html>