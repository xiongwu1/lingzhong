//统一在此定义页面的提示语信息
var Message = (function(){

	var data = {
			"LOAD_ERROR":"数据加载失败！",
			"AUDIT_SUCCESS":"审核成功！",
			"AUDIT_FAILURE":"审核失败！",
			"AUDIT_YSH_PASS":"审核通过！ ",
			"AUDIT_YSH_NOPASS":"审核未通过！",
			"AUDIT_YSH":"用户已被审核！",
			"DELETE_SUCCESS":"删除成功！",
	        "DELETE_FAIL":"删除失败！",
	        "SAVE_FAIL": "保存失败！",
	        "SAVE_SUCCESS": "保存成功！",
	        "SYSCODE_NONUNIQUE": "系统编码已存在！",
	        "SYSCODE_DELETE_FAIL":"系统编码已绑定删除失败！",
	        "IMAGE_LARGE":"图片大小超过2M！",
	        "USERIMAGE_UPLOAD_SUCCESS":"用户图片上传成功！",
	        "USERIMAGE_UPLOAD_FAIL":"用户图片上传失败！",
	        "SFZH_NONUNIQUE":"身份证号已存在！",
	        "LOGINNAME_NONUNIQUE":"登录帐号已存在！",
	        "PHONE_NONUNIQUE":"手机号已注册！",
	        "REGISTER_SUCCESS":"注册成功！",
	        "REGISTER_FAIL":"注册失败！",
	        "ILLEGAL_USER":"用户登录失败！",
	        "PASSWORD_ERROR":"您的密码不正确！",
	        "USER_NOT_EXIST":"请确认您的账号是否正确！",
	        "DYN_PASSWORD_ERROR":"短信验证码不正确！",
	        "CLICK_RESEND":"点击重新发送",
	        "DY_NOT_NULL":"短信验证码不能为空！",
	        "SMS_SEND_ERROR":"信息发送失败，查无此账户！",
	        "PASSWORD_NOT_NULL":"请输入您的密码！",
	        "LOGINNAME_NOT_NULL":"请输入您的账号！",
	        "ERROR_PERSONAL_LOGINNAME_FORMAT":"个人用户名格式不正确！",
	        "ERROR_ENTERPRISE_LOGINNAME_FORMAT":"企业用户名格式不正确！",
	        "ERROR_AGENT_LOGINNAME_FORMAT":"代办点用户名格式不正确！",
	        "RANDOM_NOT_NULL":"验证码不能为空！",
	        "RANDOM_ERROR":"验证码不正确！",
	        "PASSWORD_TWICE_ERROR":"两次密码输入不一致！",
	        "REPASSWORD_NOT_NULL":"请确认新的密码！",
	        "PASSWORD_UPDATE_ERROR":"新密码修改失败！",
	        "RESETPASS_TO_INDEX":"新的密码修改成功，是否跳到首页！",
	        "SYSTEM_ERROR":"系统正在维护中，给您带来不便，稍后再试！",
	        "NOT_REGIST_PHONE":"请输入注册时的手机号！",
	        "SMS_ERROR":"短信发送失败！",
	        "PHONE_RANDOM_ERROR":"短信验证码不正确或已失效,请点击重新发送！",
	        "DO_NOT_LOGIN":"请您先登录！",
	        "CLOSE_CUR_WINDOW":"是否关闭当前窗口？",
	        "LOGIN_TIME_OUT":"对不起，密码错误次数过多，请5分钟后再尝试！",
	        "UN_SUPPORT_MATTER_NOW":"该事项暂不支持大厅在线申办",
	        "UN_SUPPORT_RESERVE_NOW":"该事项暂不支持大厅在线预约",
	        "EVALUATE_SUCCESS":"谢谢您的评价，感谢你对我们工作的支持！",
	        "EVALUATE_FAILURE":"对不起，评价失败，请稍后再试！",
	        "SMS_DUBREG":"该手机号码已注册！"
	};
	
    var confValue = {
    		okVal : "是",
			cancelVal : "否"
    };

    return { 
        get: function(key){
            return data[key] || '';
        },
        confValue:confValue
    };
})();