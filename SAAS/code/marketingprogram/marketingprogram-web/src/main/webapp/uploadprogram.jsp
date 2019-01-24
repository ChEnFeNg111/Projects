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
    <style>
        .input-file{
            display: inline;
        }
    </style>
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

            <div align="center">
                <form action="/usermanage/uploadmarketing?qiYeId=1" method="post" enctype="multipart/form-data" class="form-horizontal">
                    <fieldset>
                        <div id="legend" >
                            <legend >方案信息</legend>
                        </div>
                        <div class="control-group">
                            <!-- Text input-->

                            <div class="controls">
                                <label class="control-label" >方案名称</label>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="text" name="name" placeholder="请输入方案的名字" class="input-xlarge">
                                <p class="help-block"></p>
                                <p class="help-block"></p>
                            </div>
                        </div>

                       <%-- <div class="control-group">

                            <!-- Text input-->

                            <div class="controls">
                                <label class="control-label" >方案作者</label>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="text" name="author" placeholder="请输入作者的名字" class="input-xlarge">
                                <p class="help-block"></p>
                            </div>
                        </div>
--%>
                        <div class="control-group">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;
                            <label class="control-label">上传图片</label>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input style="display: inline" name="programImage" id="fileInput" type="file">
                            <p class="help-block"></p>

                        </div>

                        <div class="control-group">

                            <!-- Select Basic -->

                            <div class="controls">
                                <label class="control-label">行业类型</label>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp; &nbsp; &nbsp; &nbsp;
                                <select id="parent" onchange="findChild()" name="parentId" class="input-xlarge">

                                </select>
                                &nbsp;&nbsp;
                                <select id="child"  name="industryId" class="input-xlarge">

                                </select>
                            </div>
                            <p class="help-block"></p>

                        </div>


                        <div class="control-group">


                            <div class="controls" style="display: inline">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <label class="control-label">方案类型</label>
                                <!-- Inline Radios -->
                                <label class="radio inline" style="display: inline">
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
                                    <input type="checkbox" value="1" name="programClass">重要保持客户
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="checkbox" value="2" name="programClass">重要价值客户

                                    <p class="help-block"></p>

                                    <div>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;
                                        <input type="checkbox" value="3" name="programClass">重要发展客户
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" value="4" name="programClass">重要挽留客户
                                    </div>
                                    <p class="help-block"></p>

                                    <div>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" value="5" name="programClass">
                                        一般维持客户
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" value="6" name="programClass">
                                        有价值推广客户
                                    </div>
                                    <p class="help-block"></p>

                                    <div>
                                        &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" value="7" name="programClass">
                                        潜力客户
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;
                                        <input type="checkbox" value="8" name="programClass">
                                        &nbsp;&nbsp;&nbsp;流失客户
                                    </div>

                                </label>
                            </div>
                        </div>

                        <br>
                        <br>

                        <div class="control-group">

                            <!-- Text input-->

                            <div class="controls">
                                <label class="control-label" >方案售价</label>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="text" name="price" placeholder="请输入理想价格" class="input-xlarge">
                                <p class="help-block"></p>
                            </div>
                        </div>
                        <br>
                        <br>

                        <div class="control-group">
                            <!-- File Upload -->
                            <div class="controls">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;
                                <label class="control-label">上传附件</label>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input style="display: inline" name="programFile" type="file">
                            </div>
                        </div>
                        <br>
                        <br>

                        <div class="control-group">

                            <!-- Textarea -->
                            <label class="control-label">方案描述</label>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;
                            <div class="controls">
                                <div style="display: inline">
                                    <textarea  name="describtion" style="width: 300px;height: 300px;left: 1000px"> </textarea>
                                </div>
                            </div>
                        </div>


                        <br>
                        <br>
                        <br>
                        <br>

                        <div class="control-group">
                            <!-- Button -->
                            <div class="controls">
                                <button type="submit" class="btn btn-success"  onclick="checkform()">上传方案</button>
                                &nbsp;&nbsp;&nbsp;&nbsp;

                                <a href="/usermanage/customerhistory?page=1&qiYeId=1">
                                    <input type="button" class="btn btn-success" value="返回主界面"></input>
                                </a>
                            </div>
                        </div>
                    </fieldset>
                </form>

            </div>

        </div>
    </div>
</div>

<%-- ajax异步请求，两级联动下拉列表--%>

<script>
    function checkform() {
        var data1 = document.getElementById("name").value;
        var data2 = document.getElementById("programImage").value;
        var data3 = document.getElementById("parentId").value;
        var data4 = document.getElementById("industryId").value;
        var data5 = document.getElementById("programClass").value;
        var data6 = document.getElementById("price").value;
        var data7 = document.getElementById("programFile").value;
        var data8 = document.getElementById("describtion").value;

        console.log(data1);
        console.log(data2);
        console.log(data3);
        console.log(data4);
        console.log(data5);
        console.log(data6);
        console.log(data7);
        console.log(data8);
    }
    
    function findParent() {

        var xhr = new XMLHttpRequest();

        xhr.onload = function () {

            var list = JSON.parse(xhr.responseText);

            var parent = document.getElementById("parent");

            parent.innerHTML="";

            for (var i = 0; i < list.length; i++) {
                var option = document.createElement("option");
                option.value = list[i].industryId;
                option.innerText = list[i].industryName;

                parent.appendChild(option);
            }
            findChild();
        };
        xhr.open("get","/usermanage/findByParentId?parentId=0",true);
        xhr.send();
    }

    function findChild() {

        var id = document.getElementById("parent").value;

        var xhr = new XMLHttpRequest();
        xhr.onload = function () {
            var list = JSON.parse(xhr.responseText);
            var child = document.getElementById("child");
            //清空
            child.innerHTML = "";
            for (var i = 0; i < list.length; i++) {
                var option = document.createElement("option");
                option.value = list[i].industryId;
                option.innerText = list[i].industryName;
                child.appendChild(option);
            }
        };
        xhr.open("get","/usermanage/findByParentId?parentId="+id,true);
        xhr.send();
    }

    findParent();

</script>

<!-- script references -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/scripts.js"></script>
</body>
</html>