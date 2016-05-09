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
<link href="${ctx}/resources/css/user/forgot.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/resources/scripts/lib/prefixfree.min.js"></script>

<title>众邻-忘记密码</title>
</head>
<body>
	   <!-- TAB TEMPLATE -->
<svg id="tab-left" style="fill: transpartent; stroke: none; position: absolute; margin-left: -200%;" >

  <polygon id="tab-shape-left" class="tab-shape tab-shape-left" points="900,30 0,30 10,0 900,0" />
  <polygon id="tab-shape-right" class="tab-shape tab-shape-right" points="20,30 0,30 0,0" />
  <rect id="square" width="24" height="23" fill="rgba(255,255,255,.85)" stroke="none" stroke-width="0" />
  <g id="icon-contact">
  <g id="bg">
  <rect opacity="0.3" fill="#8E25EE" width="24" height="16"/>
  </g>
  <g id="outer">
  <path opacity="0.85" fill="#FFFFFF" d="M0,0v16h24V0H0z M21,14H3V3.25L12,10l9-6.75V14z M5.333,2h13.333L12,7L5.333,2z"/>
  </g>
  </g>
  <g id="icon-home" width="24" height="23">
  <g id="inner">
  <g>
  <polyline opacity="0.6" fill="#0095B3" points="15,13 9,13 9,22 3,22 3,12 12,1 21,11.995 21,22 15,22 		"/>
  </g>
  </g>
  <g id="outer">
  <path opacity="0.95" fill="#FFFFFF" d="M12,0L0,14h2v9h8v-9h4v9h8v-9h2L12,0z M20,22h-4v-9H8v9H4V11.993L12,2l8,9.986V22z"/>
  </g>
  </g>
  <g id="icon-about" width="24" height="23">
  <!--	<rect x="-2" y="-1" display="inline" fill="#173EAD" width="28" height="26"/> -->
  <g id="inner">
  <polygon opacity="0.85" fill="#1782CF" points="1,22 6,19 9,17 6,9 8,3 12,1 16,3 18,9 14,17 16,19 20,20 23,22 	"/>
  </g>
  <g id="outer">
  <path opacity="0.95" fill="#FFFFFF" d="M20.485,19.603c-1.067-0.444-2.335-0.817-3.741-1.083c-0.877-0.387-1.494-1.249-1.494-2.27 c0-0.436,0.125-0.837,0.322-1.192c1.54-1.464,2.536-3.751,2.536-6.33c0-4.419-2.911-8-6.5-8c-3.59,0-6.5,3.581-6.5,8 c0,2.609,1.02,4.921,2.592,6.381C7.881,15.453,8,15.834,8,16.25c0,1.21-0.859,2.218-2,2.449v0.04
  c-0.908,0.215-1.748,0.476-2.485,0.782C1.343,20.427,0,21.619,0,23h24C24,21.619,22.656,20.508,20.485,19.603z M4.062,21H4 c0.042-0.625,1.317-0.796,4.007-1.395c2.402-1.048,2.618-4.022,1.001-5.564C7.854,13.088,7,11.443,7,9c0-4.188,2.542-7.041,5-7 c2.458,0.041,4,2.812,4,7c0,2.678-0.89,4.404-2.078,5.304c-1.63,2.196-0.61,4.23,2.006,5.313C18.665,20.239,20,20.625,20,21H4.062z "/>
  </g>
  </g>
  <g id="icon-lab" width="24" height="23">
  <g id="outer">
  <polygon opacity="0.95" fill="#FFFFFF" points="21.999,22 2,22 8,10 2,1 10,1 10,3 7,3 11,10 6,20 18,20 13,10 17,3 14,3 14,1 22,1 16,10 	"/>
  </g>
  <g id="inner">
  <polygon opacity="0.6" fill="#4768EB" points="6,20 11,10 7,3 10,3 10,1 14,1 14,3 17,3 13,10 18,20 	"/>
  </g>
  </g>

</svg>

<div class="container">

  <nav role="navigation" class="main-navigation">
    <ul>
      <li class="tab-1 active" data-bg-color="hsl(190, 100%, 35%)">
      <a href="#home">
        <span>手机找回</span>
        <svg class="tab-left">
          <use xlink:href="#tab-shape-left"></use>
        </svg>
        <svg class="icon icon-home">
          <use xlink:href="#icon-home"></use>
        </svg>
        <svg class="tab-right">
          <use xlink:href="#tab-shape-right"></use>
        </svg>
      </a>
      </li>
      
      <li class="tab-2" data-bg-color="hsl(255,80%,65%)">
      <a href="#contact">
        <span>邮箱找回</span>
        <svg class="tab-left">
          <use xlink:href="#tab-shape-left"></use>
        </svg>
        <svg class="icon icon-contact">
          <use xlink:href="#icon-contact"></use>
        </svg>
        <svg class="tab-right">
          <use xlink:href="#tab-shape-right"></use>
        </svg>
      </a>
      </li>
    </ul>
  </nav>

  <div class="main-content">
    <article class="article">
		<div id="findpw_tel" class="findpw_way">
			<form action="#" method="post">
				<!-- <div>
					<span>手机号：</span><input type="text" placeholder="请输入注册时填写的手机号" />
				</div>
				<br />
				<div>
					<span>手机验证码：</span><input type="text" placeholder="请填写手机验证码" />
				</div> -->
				<span style="color: red;">由于短信服务器收费问题，目前仅支持邮箱找回密码，如有给您带来不便，敬请谅解！-----众邻项目研发团队</span>
			</form>
		</div>
		<div id="findpw_email" class="findpw_way" style="display:none;">
			<form action="#" method="post" class="findemail_one">
				<div class="email_code">
					<span>邮箱：</span><input type="text" name="forgotEmail" placeholder="请输入注册时填写的邮箱" />
					<div class="normal-btn abf-btn" id="forgot-email-code">获取邮箱验证码</div>
				</div>
				<br />
				<div>
					<span>邮箱验证码：</span><input type="text" name="ForgotEmailValidateCode" placeholder="请填写邮箱验证码" />
				</div>
			</form>
			<form action="#" method="post" class="findemail_second">
				<div class="email_code">
					<span>新登录密码</span><input name="updatePwd" type="password" placeholder="请填写新的登陆密码"/>
				</div>
				<br />
				<div>
				<span>确认新登录密码</span><input name="repeatUpdatePwd" type="password" placeholder="请填写重复密码"/>
				</div>
			</form>
		</div>
		<a href="javascript:void(0);" class="findpw_sub">下一步</a>
		<a href="javascript:void(0);" class="updatepw_sub">提交</a>
    </article>
  </div> 

</div><!-- /.container -->
	<script type="text/javascript" src="${ctx}/resources/scripts/lib/jquery.easing.min.js"></script>
	<script type="text/javascript" src="${ctx}/resources/scripts/lib/html5.js"></script>
	<script>
		Util.Load('user').wait(function(){
			User.Forgot.UserForgotRender();
		});
	</script>

</body>
</html>