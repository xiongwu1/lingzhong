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
<script src="${ctx}/resources/scripts/lib/modernizr.js"></script>
<link href="${ctx}/resources/css/lib/screen.css" rel="stylesheet" />
<link href="${ctx}/resources/css/home/home.css" rel="stylesheet" />

<!-- 通过js里实现 -->
<title>${CURRENT_USER.nickName}的邻文</title>
</head>
<body>

<div class="home_top">
	<div class="logo">
		<span><img alt="LOGO" src="${ctx}/resources/images/zl_logo.png"></span>
	</div>
	<div class="search">
		<input type="text" placeholder="搜索热门邻文/邻友"/><a href="javascript:void(0);" title="搜索"><span></span></a>
	</div>
	<div class="personal_logo">
		<a href="${ctx }/home/home.do" title="首页">
			<span class="home_logo"></span><span class="home_title">首页</span>
		</a>
		<a href="${ctx }/home/personalCenter.do" title="个人中心">
			<span class="my_logo"></span><span class="my_title">${CURRENT_USER.nickName}</span>
		</a>
	</div>
	<div class="set_up">
		<fieldset class="radio-container">
			<a href="javascript:void(0);" title="设置">
					<span class="set_logo"></span>
			</a>
			<div class="radio-options">
				<ul>
					<li>
						<label><a href="${ctx }/home/personalCenter.do">个人中心</a></label>
					</li>
					<li>
						<label><a href="javascript:void(0);">修改密码</a></label>
					</li>
					<li>
						<label><a href="javascript:void(0);">我的好友</a></label>
					</li>
						<li>
							<label><a class="logout" href="javascript:void(0);">退出</a></label>
						</li>
				</ul>	
			</div>
		</fieldset>
	</div>
</div>