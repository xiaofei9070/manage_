<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="utf-8">
  <title>网站设置</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="statics/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="statics/css/admin.css" media="all">
</head>
<body>

  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md12">
        <div class="layui-card">
          <div class="layui-card-header">网站设置</div>
          <div class="layui-card-body" pad15>
            
            <div class="layui-form" wid100 lay-filter="">
            	<div class="layui-form-item">
				    <label class="layui-form-label">网站上线</label>
				    <div class="layui-input-block">
				      <input type="checkbox" checked="" name="open" lay-skin="switch" lay-filter="switchOnline" lay-text="上线|下线" data-off="unline_descript">
				    </div>
				  </div>
				  <div class="layui-form-item layui-form-text" id="unline_descript" style="display:none">
	                <label class="layui-form-label">下线描述</label>
	                <div class="layui-input-block">
	                  <textarea name="unline_descript" class="layui-textarea">通知</textarea>
	                </div>
	              </div>
              <div class="layui-form-item">
                <label class="layui-form-label">网站名称</label>
                <div class="layui-input-block">
                  <input type="text" name="sitename" value="layuiAdmin" class="layui-input">
                </div>
              </div>
              <div class="layui-form-item">
                <label class="layui-form-label">网站域名</label>
                <div class="layui-input-block">
                  <input type="text" name="domain" lay-verify="url" value="http://www.layui.com" class="layui-input">
                </div>
              </div>
              <div class="layui-form-item">
                <label class="layui-form-label">缓存时间</label>
                <div class="layui-input-inline" style="width: 80px;">
                  <input type="text" name="cache" lay-verify="number" value="0" class="layui-input">
                </div>
                <div class="layui-input-inline layui-input-company">分钟</div>
                <div class="layui-form-mid layui-word-aux">本地开发一般推荐设置为 0，线上环境建议设置为 10。</div>
              </div>
              
              <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">首页标题</label>
                <div class="layui-input-block">
                  <textarea name="title" class="layui-textarea">layuiAdmin 通用后台管理模板系统</textarea>
                </div>
              </div>
              <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">META关键词</label>
                <div class="layui-input-block">
                  <textarea name="keywords" class="layui-textarea" placeholder="多个关键词用英文状态 , 号分割"></textarea>
                </div>
              </div>
              <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">META描述</label>
                <div class="layui-input-block">
                  <textarea name="descript" class="layui-textarea"></textarea>
                </div>
              </div>
              <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">版权信息</label>
                <div class="layui-input-block">
                  <textarea name="copyright" class="layui-textarea">© 2018 layui.com MIT license</textarea>
                </div>
              </div>
              <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备案信息</label>
                <div class="layui-input-block">
                  <textarea name="beian" class="layui-textarea">© 2018 layui.com MIT license</textarea>
                </div>
              </div>
              <div class="layui-form-item">
                <div class="layui-input-block">
                  <button class="layui-btn" lay-submit lay-filter="set_website">确认保存</button>
                </div>
              </div>
            </div>
            
          </div>
        </div>
      </div>
    </div>
  </div>

  <script src="statics/layui/layui.js"></script>  
  <script>
  layui.config({
    base: 'statics/' //静态资源所在路径
  }).extend({
    set:'modules/set'
  }).use(['set']);
  </script>
</body>
</html>
</body>