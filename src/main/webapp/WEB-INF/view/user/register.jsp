<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/view/inc/taglibs.jsp"%>
<%@ include file="/WEB-INF/view/inc/meta.jsp"%>
<%@ include file="/WEB-INF/view/inc/style.jsp"%>
<link href="${ctx}/resources/css/base.css" rel="stylesheet" />
<link href="${ctx}/resources/css/user/register.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/resources/scripts/lib/jquery.passstrength.js"></script>
<script type="text/javascript" src="${ctx}/resources/scripts/lib/autoMail.js"></script>

<style type="text/css">

</style>
<title>众邻-注册</title>
</head>
<body>
	<span class="logo_span"><img alt="LOGO" src="${ctx}/resources/images/zl_logo.png"></span>
	<form id="userForm" method="post">
		<!-- progressbar -->
		<ul id="progressbar">
			<li class="active">账户注册</li>
			<li>基本信息</li>
			<li>联系方式</li>
		</ul>
		<!-- fieldsets -->
		<fieldset>
			<h2 class="fs-title">创建你的账户</h2>
			<h3 class="fs-subtitle">这是第一步</h3>
			<input type="text" name="loginName" placeholder="请输入登陆名" /><span>*</span><br />
			<span>4-20位字符，支持英文、数字及"-"、"_"组合，并且必须以字母开头</span>
			<input type="password" name="password" placeholder="请输入密码" /><span>*</span><br />
			<span>6-20位任意字符</span>
			<div class="pwd-strength-show"></div>
			<input type="password" name="cpassword" placeholder="请再次输入密码" /><span>*</span>
			<input type="button" name="next" class="next action-button" value="下一步" />
		</fieldset>
		<fieldset class="basic_info">
			<h2 class="fs-title">基本信息</h2>
			<h3 class="fs-subtitle">你个人常用的基本信息</h3>
			<input type="text" name="nickName" placeholder="昵称" /><span>*</span>
			<input type="text" name="realName" placeholder="真实姓名" /><span>*</span>
			<input type="text" name="szdProvince" placeholder="所在地-省" /><span>*</span>
			<input type="text" name="szdCity" placeholder="所在地-市" /><span>*</span>
			<div class="form-control form-combobox">
				<span class="r"></span> <span class="l"></span><span class="c">
					<input type="text" id="gender" class="text" /><input
					type="hidden" name="gender" /><span>*</span>
				</span>
			</div>
			<input type="button" name="previous" class="previous action-button" value="上一步" />
			<input type="button" name="next" class="second_next action-button" value="下一步" />
		</fieldset>
		<fieldset class="information">
			<h2 class="fs-title">个人联系方式</h2>
			<h3 class="fs-subtitle">我们将会为你保存它</h3>
			<input id="email" type="text" name="email" placeholder="邮箱" />
			<input type="text" name="emailValidateCode" placeholder="邮箱验证码" style="width:50%;float: left;margin-left: 25px;" />
			<div class="normal-btn abf-btn" id="get-email-code">获取邮箱验证码</div>
			<input type="text" name="mobilePhone" placeholder="手机号" />
			<input type="text" name="qq" placeholder="QQ" />
			<input type="button" name="previous" class="previous action-button" value="上一步" />
			<input type="button" name="submit" class="submit action-button" value="提交" />
		</fieldset>
	</form>

	<script type="text/javascript" src="${ctx}/resources/scripts/lib/jquery.easing.min.js" ></script>
	<script type="text/javascript" src="${ctx}/resources/scripts/lib/html5.js"></script>
	<script>
		Util.Load('user').wait(function(){
			User.Register.UserRegisterLoad();
		});
	</script>
</body>
</html>