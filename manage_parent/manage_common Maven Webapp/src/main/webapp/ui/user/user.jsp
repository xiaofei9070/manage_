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
 
 <script type="text/html" id="switchNormal">
  <input type="checkbox" name="status" value="{{d.status}}" lay-skin="switch" lay-text="正常|禁用" lay-filter="status" {{ d.status == 1 ? 'checked' : '' }}>
</script>
 
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<div class="layui-con" style="margin:10px;">
	<div class="layui-btn-group">
    <button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe654;</i></button>
    <button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe642;</i></button>
    <button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe640;</i></button>
    <button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe669;</i></button>
  </div> 
    <table class="layui-hide" id="test" lay-filter="demo"></table> 
</div>          
          
<script src="statics/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use('table', function(){
  var table = layui.table;
  table.render({
	    elem: '#test'
	    ,height:'full-100'
	    ,cellMinWidth: 80
	    ,method:'POST'
	    ,url: 'admin/userList' //数据接口
	    ,page: true //开启分页
	    ,limit:30
	    ,cols: [[ //表头
	      {field: 'id', title: '编号', width:80, sort: true, fixed: 'left'}
	      ,{field: 'name', title: '用户名', width:80}
	      ,{field: 'email', title: '邮箱', width: 170}
	      ,{field: 'phone', title: '手机', width: 80, sort: true}
	      ,{field:'status', title:'状态', width:90, templet: '#switchNormal', unresize: true}
	      ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
	    ]]
	  });
	  table.on('tool(demo)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
		    var data = obj.data //获得当前行数据
		    ,layEvent = obj.event; //获得 lay-event 对应的值
		    if(layEvent === 'detail'){
		      layer.msg('查看操作');
		      console.log(data)
		    } else if(layEvent === 'del'){
		      layer.confirm('真的删除行么', function(index){
		        obj.del(); //删除对应行（tr）的DOM结构
		        layer.close(index);
		        //向服务端发送删除指令
		      });
		    } else if(layEvent === 'edit'){
		      layer.msg('编辑操作');
		    }
	  });
	});
</script>

</body>
</html>