<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/view/inc/taglibs.jsp"%>
<%@ include file="/WEB-INF/view/inc/meta.jsp"%>
<%@ include file="/WEB-INF/view/inc/style.jsp"%>
<script src="${ctx}/resources/scripts/lib/html5.js"></script>
<link href="${ctx}/resources/css/base.css" rel="stylesheet" />
<link href="${ctx}/resources/css/index.css" rel="stylesheet" />
<title>众邻-首页</title>
</head>
<body>
	<div class="top">
		<span><img alt="LOGO" src="${ctx}/resources/images/zl_logo.png"></span>
		<div class="login-form">
			<div class="head-info">
				<label class="lbl-1"> </label> <label class="lbl-2"> </label> <label
					class="lbl-3"> </label>
			</div>
			<div class="clear"></div>
			<div class="avtar">
				<img src="${ctx}/resources/images/index/user_head.png" />
			</div>
			<form method="post" id="loginForm">
				<input type="text" name="loginName" class="account" placeholder="邮箱/会员账号/手机号">
				<div class="key">
					<input class="login_password" type="password" name="password" placeholder="请输入密码">
				</div>
			</form>
			<div id="forget_register">
				<a id="forget" href="${ctx}/user/forgot.do">忘记密码？</a>
				<div id="register">
					<span>还没有账号？</span><a href="${ctx}/user/register.do">立即注册</a>
				</div>
			</div>
			<div class="signin">
				<input id="loginBtn" type="submit" value="快捷登陆">
			</div>
		</div>
	</div>
	<div class="content">
		<div id="left_blog">
			<div id="left_blog_list">
				<%-- <div class="default_empty">暂无邻文展示，赶紧登陆去发表一条吧！</div>
				<div class="blog_list">
					<div class="blog_content">
						<div class="head_info">
							<div class="head_left">
								<figure>
								<div>
									<img src="${ctx}/resources/images/index/head.jpg" />
								</div>
								</figure>
							</div>
							<div class="head_right">
								<p class="web_name">
									<b>易先生3729</b>
								</p>
								<p class="web_time">12月2日 09:01 来自 微博 weibo.com</p>
							</div>
						</div>
						<div class="web_info">关于“高晓松、梁宏达、崔永元”等名嘴谁的实力更强？</div>
						<div class="img_info">
							<img alt="微博" src="${ctx}/resources/images/index/weibo_img1.jpg">
							<img alt="微博" src="${ctx}/resources/images/index/weibo_img2.jpg">
							<img alt="微博" src="${ctx}/resources/images/index/weibo_img3.jpg">
							<img alt="微博" src="${ctx}/resources/images/index/weibo_img4.jpg">
						</div>
					</div>
					<div class='blog_operate'>
						<ul>
							<li><a href="javascript:void(0);">收藏</a></li>
							<li><a href="javascript:void(0);">转发</a></li>
							<li><a href="javascript:void(0);">评论</a></li>
							<li><a href="javascript:void(0);">赞</a></li>
						</ul>
					</div>
				</div> --%>
			</div>
			<div class="page" style="width:610px;margin:0 auto;"><div id="kkpager"></div></div>
		</div>
		<div id="right_topic">
			<div id="topic_title">
				<p>
					<b>热门邻文<!-- 话题 --></b>
				</p>
			</div>
			<div class="topic_list">
				<!-- <div class="topic_content">
					<p class="topic_left">
						<a href="#">#我发起了一个投票 #</a>
					</p>
					<p class="payAttention">12月2日 12:00</p>
				</div> 
				<div class="defalut_topic">
					暂无热门邻文
				</div> -->
			</div>
		</div>
		<div id="right_find">
			<div id="topic_title">
				<p>
					<b>众邻-找人</b>
				</p>
			</div>
			<div class="finduser_list">
				<!-- <div class="topic_content">
					<p class="topic_left">
						<a href="#">#我发起了一个投票 #</a>
					</p>
					<p class="topic_time"><a href="javascript:void(0);">加关注</a></p>
				</div> -->
			</div>
		</div>
	</div>
	<div class="copy-rights">
		<p>
			Copyright &copy; 2015.Design source xiongwu All rights reserved.<a
				target="_blank" href="${ctx}/index.do">lingzhong</a>|<a href="javascript:void(0);" class="feedBack">意见反馈</a>
		</p>
	</div>
	<!-- 返回顶部 -->
	<a href="#" onclick="gotoTop();return false;" class="totop"></a>

<script src="${ctx}/resources/scripts/lib/jquery.sinaEmotion.js"></script>	
<script type="text/javascript">
	
	Util.Load('index').wait(function(){
		Index.IndexData.IndexDataLoad();
	});
</script>
</body>
</html>