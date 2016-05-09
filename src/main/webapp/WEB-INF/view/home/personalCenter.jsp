<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/inc/header.jsp"%>
<link href="${ctx}/resources/css/home/personalCenter.css" rel="stylesheet" />
<link href="${ctx}/resources/css/lib/style.css" rel="stylesheet" />

<div class="personal_cover">
	<div class="pf_photo">
		<figure>
			<div>
				<a href="javascript:void(0);" class="head_photos">
					<%-- <c:choose>
						<c:when test="${CURRENT_USER.headPortrait != null }">
							<img src="http://192.168.3.205:8888/${CURRENT_USER.headPortrait}" />
						</c:when>
						<c:otherwise>
							<img src="${ctx}/resources/images/default_icon.png" />
						</c:otherwise>
					</c:choose> --%>
				</a>
			</div>
		</figure>
	</div>
	<div class="pf_username">
		<span><%-- ${CURRENT_USER.nickName } --%></span>
	</div>
	<div class="pf_gxqm">
		<span><%-- ${CURRENT_USER.gxqm } --%></span>
	</div>
</div>
<div class="personal_menu">
	<span><a href="javascript:void();">我的主页</a></span>
</div>

<div class="personal_material">
	<div class="personal_left">
		<div class="personal_atten">
			<ul>
				<li><a href="javascript:void(0);"><strong id="atten_num"></strong><span class="atten_txt">关注</span></a></li>
				<li><a href="javascript:void(0);"><strong id="fans_num"></strong><span class="atten_txt">粉丝</span></a></li>
				<li><a href="javascript:void(0);"><strong id="lwBlog_num"></strong><span class="atten_txt">邻文</span></a></li>
			</ul>
		</div>
	</div>
	<div class="personal_right">
		<div class="basic_title">
			<div class="basic_tip">
				<span>基本信息</span><hr /><a href="javascript:void();">编辑</a>	
			</div>
			<div class="personal_basic">
				<div class="basic_name"><span>登陆名</span></div><div class="basic_content" id="loginName"><%-- ${CURRENT_USER.loginName } --%></div>
			</div>
			<div class="personal_basic">
				<div class="basic_name"><span>昵  称</span></div><div class="basic_content" id="nickName"><%-- ${CURRENT_USER.nickName } --%></div>
			</div>
			<div class="personal_basic">
				<div class="basic_name"><span>真实姓名</span></div><div class="basic_content" id="realName"><%-- ${CURRENT_USER.realName } --%></div>
			</div>
			<div class="personal_basic">
				<div class="basic_name"><span>所在地</span></div><div class="basic_content" id="szd"><%-- ${CURRENT_USER.szdProvince } ${CURRENT_USER.szdCity } --%></div>
			</div>
			<div class="personal_basic">
				<div class="basic_name"><span>性  别</span></div><div class="basic_content" id="gender">
				<%-- <c:choose>
					<c:when test="${CURRENT_USER.gender == 0}">男</c:when>
					<c:otherwise>女</c:otherwise>
				</c:choose> --%>
				</div>
			</div>
			<div class="personal_basic">
				<div class="basic_name"><span>性取向</span></div><div class="basic_content">异性恋</div>
			</div>
			<div class="personal_basic">
				<div class="basic_name"><span>感情状况</span></div><div class="basic_content">单身</div>
			</div>
			<div class="personal_basic">
				<div class="basic_name"><span>生日</span></div><div class="basic_content">1993-07-21</div>
			</div>
			<div class="personal_basic">
				<div class="basic_name"><span>血型</span></div><div class="basic_content">O</div>
			</div>
			<div class="personal_basic">
				<div class="basic_name"><span>个性签名</span></div><div class="basic_content" id="gxqm"><%-- ${CURRENT_USER.gxqm } --%></div>
			</div>
		</div>
		<div class="contact_title">
			<div class="basic_tip">
				<span>联系信息</span><hr /><a href="javascript:void();">编辑</a>
			</div>
			<div class="personal_basic">
				<div class="basic_name"><span>邮箱</span></div><div class="basic_content" id="email"><%-- ${CURRENT_USER.email } --%></div>
			</div>
			<div class="personal_basic">
				<div class="basic_name"><span>QQ</span></div><div class="basic_content" id="qq"><%-- ${CURRENT_USER.qq } --%></div>
			</div>
			<div class="personal_basic">
				<div class="basic_name"><span>手机号</span></div><div class="basic_content" id="mobilePhone"><%-- ${CURRENT_USER.mobilePhone } --%></div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	
	Util.Load('personalCenter').wait(function(){
		PersonalCenter.PersonalCenterIndex.PersonalCenterLoad();
	});
</script>
<%@ include file="/WEB-INF/view/inc/footer.jsp"%>