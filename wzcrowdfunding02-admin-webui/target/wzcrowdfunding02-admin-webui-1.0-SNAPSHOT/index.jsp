<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
    <script type="text/javascript" src="jquery/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
           $("#btn1").click(function () {
               var array = [1,2,3,4];
               console.log(array.length);
               var requestBody = JSON.stringify(array);
               console.log(requestBody.length);
               $.ajax({
                   "url":"send/array",                //请求资源的地址
                   "type":"post",                     //请求方式
                   "data":requestBody,
                   "contentType":"application/json;charset=UTF-8",
                   "dataType":"text",                 //如何对待服务器返回的数据
                   "success":function (response) {//服务器端处理请求成功后调用的回调函数
                       alert(response);
                   },                                 //服务器端响应体数据
                   "error":function (response) {
                       alert(response);
                   }
               });
           });
        });

        $(function () {
            $("#btn2").click(function () {
                var admin = {
                    "id":null,
                    "loginAcct":"小花",
                    "userPswd":"345678",
                    "userName":"阎惜娇",
                    "email":"xiaohua@qq.com"
                };
                var requestBody = JSON.stringify(admin);
                $.ajax({
                    "url":"test/json",                //请求资源的地址
                    "type":"post",                     //请求方式
                    "data":requestBody,
                    "contentType":"application/json;charset=UTF-8",
                    "dataType":"json",                 //如何对待服务器返回的数据
                    "success":function (response) {//服务器端处理请求成功后调用的回调函数
                        console.log(response);
                    },                                 //服务器端响应体数据
                    "error":function (response) {
                        console.log(response);
                    }
                })
            })
        })
    </script>
</head>
<body>
    <a href="test/ssm">测试SSM整合</a>
<br/>
    <button id="btn1">Send[5,8,12]</button>
    <button id="btn2">json</button>
</body>
</html>
