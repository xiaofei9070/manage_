<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="statics/layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>  
 
<table class="layui-table" lay-data="{height: 'full-200', cellMinWidth: 80,method:'POST', page: true, limit:30, url:'admin/userList'}">
  <thead>
    <tr>
      <th lay-data="{type:'checkbox'}">ID</th>
      <th lay-data="{field:'id', width:100, sort: true}">ID</th>
      <th lay-data="{field:'username', width:100}">用户名</th>
      <th lay-data="{field:'sex', width:100, sort: true}">性别</th>
      <th lay-data="{field:'sign', minWidth: 150}">签名</th>
      <th lay-data="{field:'experience', sort: true, align: 'right'}">积分</th>
      <th lay-data="{field:'score', sort: true, minWidth: 100, align: 'right'}">评分</th>
    </tr>
  </thead>
</table> 
               
          
<script src="statics/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use('table', function(){
  var table = layui.table;
  
  
});
</script>

</body>
</html>