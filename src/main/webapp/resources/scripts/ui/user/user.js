(function() {
	
	//启动任务
	var task=true;
	//计时总数
	var num=120;
	//当前秒数
	var count=num;
	//重置
	var reClick=true;
	//计时器
	var timer;

	var User = {
			_init : function() {
				window.User= User;
			},
			Register : {},
			Forgot : {}
		};
	
	//初始化
	User.Base = {
		Dict : {
			XB : (function() {
				return new Util.Dict();
			})()
		}
	};
	
	
	//注册
	User.Register = (function() {
		//页面加载
		function UserRegisterLoad() {
			
			//渲染页面
			$('body').mask().setMask();
			$.when(Dao.Dictionary.getDict('XB')).done(function(xb){
				User.Base.Dict.XB.Set(xb);
			}).then(function(){
				$('body').mask().clearMask();
				UserRegisterRender();
			}).fail(function(){
				$('body').mask().clearMask();
				window.parent.Util.warn('数据获取失败！');
			});
		};
		
		//渲染列表页面
		function UserRegisterRender(){
			
			//输入邮箱智能提示
			$(document).ready(function(){
				$('#email').autoMail({
					emails:['qq.com','foxmail.com','163.com','126.com','sina.com','sohu.com','yahoo.cn','gmail.com','hotmail.com']
				});
			});
			
			//隐藏第二步、第三步
			$(function() {
				$(".basic_info").hide();
				$(".information").hide();
			});
			
			//表单是否填写验证
			$('input[name="loginName"]').blur(function() {
				if($('input[name="loginName"]').val() == "") {
					Util.Tip.warning("登陆名不能为空！");
					return false;
				}
			});

			$('input[name="password"]').blur(function() {
				if($('input[name="password"]').val() == "") {
					Util.Tip.warning("密码不能为空！");
					return false;
				}
			});

			$('input[name="cpassword"]').blur(function() {
				if($('input[name="cpassword"]').val() == "") {
					Util.Tip.warning("重复密码不能为空！");
					return false;
				}
			});

			//验证密码强度
			$('input[name="password"]').passStrengthify({
				element:  $('.pwd-strength-show'),
			    levels: ['很弱', '弱', '中', '强'],//['Very weak', 'Very weak', 'Weak', 'Weak', 'Moderate', 'Good', 'Strong', 'Very strong']
			    colours:['gray', '#C00000','orange', 'green'],// ['gray', 'red', 'red', '#C00000', 'orange', '#0099FF', 'blue', 'green']
			    tests: [16, 48, 72],//[0, 8, 16, 32, 48, 64, 72]
			    labels: { // text for labels
			      passwordStrength : '',
			      tooShort: '很弱'
			    }
			});

			//判断2次密码是否一致
			$("input[name='cpassword']").blur(function(){
				if ($.trim($("input[name='password']").val()) != $.trim($("input[name='cpassword']").val())) {
					Util.Tip.warning("两次输入密码不匹配！");
					return false;
				}
			});

			$('input[name="nickName"]').blur(function() {
				if($('input[name="nickName"]').val() == "") {
					Util.Tip.warning("昵称不能为空！");
					return false;
				}
			});

			$('input[name="realName"]').blur(function() {
				if($('input[name="realName"]').val() == "") {
					Util.Tip.warning("真实姓名不能为空！");
					return false;
				}
			});

			$('input[name="szdProvince"]').blur(function() {
				if($('input[name="szdProvince"]').val() == "") {
					Util.Tip.warning("所在地-省不能为空！");
					return false;
				}
			});

			$('input[name="szdCity"]').blur(function() {
				if($('input[name="szdCity"]').val() == "") {
					Util.Tip.warning("所在地-市不能为空！");
					return false;
				}
			});

			$('input[name="gender"]').blur(function() {
				if($('input[name="gender"]').val() == "") {
					Util.Tip.warning("性别不能为空！");
					return false;
				}
			});

			$('input[name="email"]').blur(function() {
				if($('input[name="email"]').val() == "") {
					Util.Tip.warning("邮箱不能为空！");
					return false;
				}
			});
			
			$('input[name="emailValidateCode"]').blur(function() {
				if($('input[name="emailValidateCode"]').val() == "") {
					Util.Tip.warning("邮箱验证码不能为空！");
					return false;
				}
			});

			$('input[name="mobilePhone"]').blur(function() {
				if($('input[name="mobilePhone"]').val() == "") {
					Util.Tip.warning("手机号不能为空！");
					return false;
				}
			});

			$('input[name="qq"]').blur(function() {
				if($('input[name="qq"]').val() == "") {
					Util.Tip.warning("QQ不能为空！");
					return false;
				}
			});
			
			//jQuery time
			var current_fs, next_fs, previous_fs; //fieldsets
			var left, opacity, scale; //fieldset properties which we will animate
			var animating; //flag to prevent quick multi-click glitches

			$(".next").click(function(){
				//	验证登录名规则
				var $loginName = $('input[name="loginName"]');
				var $password = $('input[name="password"]');
				var $cpassword = $('input[name="cpassword"]');
				
				//表单验证
				if ($loginName.val() == "" || $password.val() == "" || $cpassword.val() == "") {
					Util.Tip.warning("请检查表单是否填写完整！");
					return false;
				}
				//数字和字母正则
				var loginNameReg = /^([a-zA-Z])[0-9a-zA-Z\-_\u4e00-\u9fa5]{3,19}$/;
				if($loginName && !loginNameReg.test($loginName.val())){
					Util.Tip.warning('登录帐号格式不正确！');
					$loginName.focus();
					return false;
				}
				//验证密码规则
				if($.trim($password.val()).length<6 || $.trim($password.val()).length > 20){
					Util.Tip.warning("密码长度必须是6到20位 ！");
				    $password.focus();
					return false;
				}
				//验证重复密码是否一致
				if($cpassword.val() != $password.val()) {
					Util.Tip.warning("重复密码不一致，请重新输入！");
					$cpassword.focus();
					return false;
				}
				
				if(animating) return false;
				animating = true;
				
				current_fs = $(this).parent();
				next_fs = $(this).parent().next();
				
				//activate next step on progressbar using the index of next_fs
				$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
				
				//show the next fieldset
				next_fs.show(); 
				//hide the current fieldset with style
				current_fs.animate({opacity: 0}, {
					step: function(now, mx) {
						//as the opacity of current_fs reduces to 0 - stored in "now"
						//1. scale current_fs down to 80%
						scale = 1 - (1 - now) * 0.2;
						//2. bring next_fs from the right(50%)
						left = (now * 50)+"%";
						//3. increase opacity of next_fs to 1 as it moves in
						opacity = 1 - now;
						current_fs.css({'transform': 'scale('+scale+')'});
						next_fs.css({'left': left, 'opacity': opacity});
					}, 
					duration: 800, 
					complete: function(){
						current_fs.hide();
						animating = false;
					}, 
					//this comes from the custom easing plugin
					easing: 'easeInOutBack'
				});
			});

			$(".second_next").click(function(){
				
				var $nickName = $('input[name="nickName"]');
				var $realName = $('input[name="realName"]');
				var $szdProvince = $('input[name="szdProvince"]');
				var $szdCity = $('input[name="szdCity"]');
				var $gender = $('input[name="gender"]');
				
				//表单验证
				if ($nickName.val() == "" || $realName.val() == "" || $szdProvince.val() == "" || $szdCity.val() == "" || $gender.val() == "") {
					Util.Tip.warning("请检查表单是否填写完整！");
					return false;
				}
				
				if(animating) return false;
				animating = true;
				
				current_fs = $(this).parent();
				next_fs = $(this).parent().next();
				
				//activate next step on progressbar using the index of next_fs
				$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
				
				//show the next fieldset
				next_fs.show(); 
				//hide the current fieldset with style
				current_fs.animate({opacity: 0}, {
					step: function(now, mx) {
						//as the opacity of current_fs reduces to 0 - stored in "now"
						//1. scale current_fs down to 80%
						scale = 1 - (1 - now) * 0.2;
						//2. bring next_fs from the right(50%)
						left = (now * 50)+"%";
						//3. increase opacity of next_fs to 1 as it moves in
						opacity = 1 - now;
						current_fs.css({'transform': 'scale('+scale+')'});
						next_fs.css({'left': left, 'opacity': opacity});
					}, 
					duration: 800, 
					complete: function(){
						current_fs.hide();
						animating = false;
					}, 
					//this comes from the custom easing plugin
					easing: 'easeInOutBack'
				});
			});

			$(".previous").click(function(){
				if(animating) return false;
				animating = true;
				
				current_fs = $(this).parent();
				previous_fs = $(this).parent().prev();
				
				//de-activate current step on progressbar
				$("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");
				
				//show the previous fieldset
				previous_fs.show(); 
				//hide the current fieldset with style
				current_fs.animate({opacity: 0}, {
					step: function(now, mx) {
						//as the opacity of current_fs reduces to 0 - stored in "now"
						//1. scale previous_fs from 80% to 100%
						scale = 0.8 + (1 - now) * 0.2;
						//2. take current_fs to the right(50%) - from 0%
						left = ((1-now) * 50)+"%";
						//3. increase opacity of previous_fs to 1 as it moves in
						opacity = 1 - now;
						current_fs.css({'left': left});
						previous_fs.css({'transform': 'scale('+scale+')', 'opacity': opacity});
					}, 
					duration: 800, 
					complete: function(){
						current_fs.hide();
						animating = false;
					}, 
					//this comes from the custom easing plugin
					easing: 'easeInOutBack'
				});
			});
			
			//发送邮箱验证口令
			$("#get-email-code").click(function(){
				
				var $email = $('input[name="email"]');
				var $emailCode = $("#get-email-code");
				
				//邮箱不能为空
				if($('input[name="email"]').val() == "") {
					Util.Tip.warning("邮箱不能为空！");
					$email.focus();
					return false;
				}
				//邮箱验证
				emailReg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
				if($email && !emailReg.test($email.val())){
					Util.Tip.warning('邮箱格式不正确！');
					$email.focus();
					return false;
				}
				
				if(reClick){
					$('body').mask().setMask();
					//此处发送邮箱验证口令ajax
					Dao.User.sendMail($email.val()).done(
					function(data) {
						var d=convert(data);
						if(!d.returnFlag){
							Util.Tip.warning("该邮箱已被注册！");
						}else{
							/*$("input[name='email']").attr("readonly",true);*/
							reClick = false;
							timer = setInterval(function(){
								countDown($emailCode);
							}, 1000);
						}
						$('body').mask().clearMask();
					}).fail(function() {
						$('body').mask().clearMask();
						Util.Tip.warning('数据加载失败！');
						});
				}
			});
			
			$(".submit").click(function(){
				
				var $email = $('input[name="email"]');
				var $emailValidateCode = $('input[name="emailValidateCode"]');
				var $mobilePhone = $('input[name="mobilePhone"]');
				var $qq = $('input[name="qq"]');
				
				if ($email.val() == "" || $emailValidateCode.val() == "" || $mobilePhone.val() == "" || $qq.val() == "") {
					Util.Tip.warning("请检查表单是否填写完整！");
					return false;
				}

				//邮箱验证
				emailReg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
				if($email && !emailReg.test($email.val())){
					Util.Tip.warning('邮箱格式不正确！');
					$email.focus();
					return false;
				}
				
				//手机号码格式验证
				phoneReg = /^\d{11}$/;
				if($mobilePhone && !phoneReg.test($mobilePhone.val())){
					Util.Tip.warning('手机号码格式不正确！');
					$mobilePhone.focus();
					return false;
				}
				Util.mask.set();
				//提交个人用户表单数据
				$.ajax({
					type : "POST",
					dataType:"json",
					url : CONTEXTPATH + "/user/registerSave.do",
					contentType: "application/x-www-form-urlencoded; charset=utf-8", 
					data : $('#userForm').serialize(),
					success : function(data) {
						if(data.data == "EMAIL_RANDOM_ERROR") {
							Util.Tip.warning('验证码不正确！');
							$emailValidateCode.focus();
							Util.mask.clear();
							return false;
						}else if(data.data == "LOGINNAME_NONUNIQUE") {
							Util.Tip.warning('该登陆名已被注册！');
							Util.mask.clear();
							return false;
						}else if(data.data == "PHONE_NONUNIQUE") {
							Util.Tip.warning('该手机号已被注册！');
							Util.mask.clear();
							return false;
						}else if(data.data == "EMAIL_NONUNIQUE") {
							Util.Tip.warning('该邮箱已被注册！');
							Util.mask.clear();
							return false;
						}else {
							Util.mask.clear();
							$.dialog({
				    			title:'提示',
				    			icon:'succeed',
				    			content:'注册成功，请尽快到个人中心完善个人信息。',
				    			drag:false,
				    			lock:true,
				    			close:function(){
				    				//屏蔽浏览器提示，直接关闭窗口
				    				window.open(CONTEXTPATH+"/index.do", "_self");
				    			}
				    		});
						}
					},
					error : function() {  
						Util.Tip.warning('注册失败，请检查表单填写是否有误！');
				    }  
				});
			})
			
			//下拉框加载数据字典
			$('#gender').comboBox({
                data : User.Base.Dict.XB.GetData(),
                multiple : false,
                emptyText: '请选择'
            });
		};
		return {
			UserRegisterLoad : UserRegisterLoad
		};
	})();
	
	//忘记密码
	User.Forgot = (function() {
		
		//渲染列表页面
		function UserForgotRender(){
			
			$(".tab-1").click(function() {
				$(".tab-2").removeClass("active");
				$(this).addClass("active");
				$(".main-content").css({
					"background": $(this).data("bg-color")
				})
				$("#findpw_tel").show();
				$("#findpw_email").hide();
				$('.findpw_sub').hide();
			});

			$(".tab-2").click(function() {
				$(".tab-1").removeClass("active");
				$(this).addClass("active");
				$(".main-content").css({
					"background": $(this).data("bg-color")
				});
				$("#findpw_email").show();
				$("#findpw_tel").hide();
				$('.findpw_sub').show();
			});
			
			//判断所填写的表单是否为空
			$('input[name="forgotEmail"]').blur(function() {
				if($('input[name="forgotEmail"]').val() == "") {
					Util.Tip.warning("邮箱不能为空！");
					return false;
				}
			});
			//判断所填写的表单是否为空
			$('input[name="ForgotEmailValidateCode"]').blur(function() {
				if($('input[name="ForgotEmailValidateCode"]').val() == "") {
					Util.Tip.warning("邮箱验证码不能为空！");
					return false;
				}
			});
			
			//定义邮箱和邮箱验证码
			var $email = $('input[name="forgotEmail"]');
			var $emailCode = $("#forgot-email-code");
			var $ForgotEmailValidateCode = $('input[name="ForgotEmailValidateCode"]');
			
			//发送邮箱验证口令
			$("#forgot-email-code").click(function(){
				
				//邮箱不能为空
				if($('input[name="forgotEmail"]').val() == "") {
					Util.Tip.warning("邮箱不能为空！");
					$email.focus();
					return false;
				}
				//邮箱验证
				emailReg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
				if($email && !emailReg.test($email.val())){
					Util.Tip.warning('邮箱格式不正确！');
					$email.focus();
					return false;
				}
				
				if(reClick){
					$('body').mask().setMask();
					//此处发送邮箱验证口令ajax
					Dao.User.forgotSendMail($email.val()).done(
					function(data) {
						var d=convert(data);
						if(d.returnFlag){
							$("input[name='email']").attr("readonly",true);
							reClick = false;
							timer = setInterval(function(){
								countDown($emailCode);
							}, 1000);
						}else{
							Util.Tip.warning("该邮箱不存在！");
						}
						$('body').mask().clearMask();
					}).fail(function() {
						$('body').mask().clearMask();
						window.Util.warn('数据加载失败！');
						});
				}
			});
			
			$('.findpw_sub').click(function() {
				//邮箱不能为空
				if($('input[name="forgotEmail"]').val() == "") {
					Util.Tip.warning("邮箱不能为空！");
					$email.focus();
					return false;
				}
				//邮箱验证
				emailReg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
				if($email && !emailReg.test($email.val())){
					Util.Tip.warning('邮箱格式不正确！');
					$email.focus();
					return false;
				}
				
				//邮箱验证码不能为空
				if($('input[name="ForgotEmailValidateCode"]').val() == "") {
					Util.Tip.warning("邮箱验证码不能为空！");
					$ForgotEmailValidateCode.focus();
					return false;
				}
				
				Util.mask.set();
				//提交个人用户表单数据
				$.ajax({
					type : "POST",
					dataType:"json",
					url : CONTEXTPATH + "/user/findPwd.do",
					contentType: "application/x-www-form-urlencoded; charset=utf-8", 
					data:{ForgotEmailValidateCode:$ForgotEmailValidateCode.val(),email:$email.val()},
					success : function(data) {
						if(data.data == "EMAIL_RANDOM_ERROR") {
							Util.Tip.warning('验证码不正确！');
							Util.mask.clear();
							$ForgotEmailValidateCode.focus();
							return false;
						}else {
							Util.mask.clear();
							//隐藏第一步，显示第二步新的登陆密码
							$('.findemail_one').hide();
							$('.findpw_sub').hide();
							$('.findemail_second').show();
							$('.updatepw_sub').show();
							
							//新登录密码不能为空
							$('input[name="updatePwd"]').blur(function() {
								if($('input[name="updatePwd"]').val() == "") {
									Util.Tip.warning("新登录密码不能为空！");
									return false;
								}
							});
							
							//确认新登录密码不能为空
							$('input[name="repeatUpdatePwd"]').blur(function() {
								if($('input[name="repeatUpdatePwd"]').val() == "") {
									Util.Tip.warning("确认新登录密码不能为空！");
									return false;
								}
							});
							
							$('.updatepw_sub').click(function() {
								
								var $updatePwd = $('input[name="updatePwd"]');
								var $repeatUpdatePwd = $('input[name="repeatUpdatePwd"]');
								
								if($updatePwd.val() == "") {
									Util.Tip.warning("新登录密码不能为空！");
									$updatePwd.focus();
									return false;
								}
								if($repeatUpdatePwd.val() == "") {
									Util.Tip.warning("确认新登录密码不能为空！");
									$repeatUpdatePwd.focus();
									return false;
								}
								
								if ($updatePwd.val() != $repeatUpdatePwd.val()) {
									Util.Tip.warning("两次输入的密码不一致！");
									return false;
								}
								
								Util.mask.set();
								//提交修改密码
								$.ajax({
									type : "POST",
									dataType:"json",
									url : CONTEXTPATH + "/user/updatePwd.do",
									contentType: "application/x-www-form-urlencoded; charset=utf-8", 
									data:{email:$('input[name="forgotEmail"]').val(),newPassword:$updatePwd.val()},
									success : function(data) {
										
										if(data.data=="FAILURE") {
											Util.mask.clear();
											Util.Tip.warning('修改密码失败，请检查!');
										}else {
											Util.mask.clear();
											$.dialog({
								    			title:'提示',
								    			icon:'succeed',
								    			content:'修改密码成功，请登陆。',
								    			drag:false,
								    			lock:true,
								    			close:function(){
								    				//屏蔽浏览器提示，直接关闭窗口
								    				window.open(CONTEXTPATH+"/index.do", "_self");
								    			}
								    		});
										}
									},
									error : function() {  
										Util.mask.clear();
										Util.Tip.warning('修改密码失败，请检查表单填写是否有误！');
								    }  
								});
								
								
							});
							
							/*$.dialog({
				    			title:'提示',
				    			icon:'succeed',
				    			content:'注册成功，请尽快到个人中心完善个人信息。',
				    			drag:false,
				    			lock:true,
				    			close:function(){
				    				//屏蔽浏览器提示，直接关闭窗口
				    				window.open(CONTEXTPATH+"/index.do", "_self");
				    			}
				    		});*/
						}
					},
					error : function() {  
						Util.Tip.warning('找回密码失败，请检查表单填写是否有误！');
						Util.mask.clear();
				    }  
				});
				
			});
			
		};
		return {
			UserForgotRender : UserForgotRender
		};
	})();
	
	/**
	 * 调用邮箱接口
	 */
	//倒计时
	function countDown ($emailCode){
		if(task){
			$emailCode.text((count--)+"秒").addClass('disable-btn');
			if(count<=0){
				Dao.User.clearDyode().done();
				task=false;
			}
		}else{
			count=num;
			reClick=true;
			task=true;
			clearInterval(timer);
			$emailCode.text("点击重新发送").removeClass('disable-btn');
		}
	}
	
	User._init();
})();