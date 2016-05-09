/**
 * 创建一个具有指定原型的对象
 */
var derive = Object.create ? Object.create : function() { 
	var T = function() {}; 
	return function(obj) { 
		T.prototype = obj; 
		return new T;
	};
}();

/**
 * 判断IE浏览器及版本
 */
var isIE = function(ver){
    var b = document.createElement('b')
    b.innerHTML = '<!--[if IE ' + ver + ']><i></i><![endif]-->'
    return b.getElementsByTagName('i').length === 1;
//    var myNav = navigator.userAgent.toLowerCase();
//    return (myNav.indexOf('msie') != -1) ? parseInt(myNav.split('msie')[1]) : false;
}

//IE下支持placeholder标签
$(function() {
	if (!placeholderSupport()) {   // 判断浏览器是否支持 placeholder
	    $('[placeholder]').focus(function() {
	        var input = $(this);
	        if (input.val() == input.attr('placeholder')) {
	            input.val('');
	            input.removeClass('placeholder');
	        }
	    }).blur(function() {
	        var input = $(this);
	        if (input.val() == '' || input.val() == input.attr('placeholder')) {
	            input.addClass('placeholder');
	            input.val(input.attr('placeholder'));
	        }
	    }).blur();
	};
})
function placeholderSupport() {
	return 'placeholder' in document.createElement('input')
			|| 'placeholder' in document.createElement('textarea');
}


/**
 * 转换JSON字符到对象
 */
function convert(json){
	var data = json;
	if(typeof(data) == "string" && 
		(data.indexOf('{') == 0 || data.indexOf('[') == 0)){
		data = eval('(' + data + ')');
		if(data.edattribute){
			var edattr = eval('(' + data.edattribute + ')');
			$.extend(data, edattr);
		}
	}
	return data;
}

/**
 * 时间对象的格式化
 * @param format 格式化
 * @return 格式化后的字符串
 */
Date.prototype.format = function(format) {
	var o = {
		"M+" : this.getMonth() + 1, // month
		"d+" : this.getDate(), // day
		"h+" : this.getHours(), // hour
		"m+" : this.getMinutes(), // minute
		"s+" : this.getSeconds(), // second
		"q+" : Math.floor((this.getMonth() + 3) / 3), // quarter
		"S" : this.getMilliseconds()
	};

	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}

	for (var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
};

/**
 * 在日期上添加天数
 * @param days 数字
 * @return 新日期
 */
Date.prototype.addDays = function (days) {
    var nd = new Date(this);
    nd.setDate(nd.getDate() + days);
    return nd;
};

/**
 * 在日期上添加小时
 * @param days 数字
 * @return 新日期
 */
Date.prototype.addHours = function (hours) {
    var nd = new Date(this);
    nd.setHours(nd.getHours() + parseInt(hours));
    return nd;
};

(function(win,$){
	var util = win.Util || {};

	// 时间格式化的工具函数
	util.date={
		/**
		 * 将14位数字字符串转成19位标准日期格式的字符串
		 * @param str 14位字符串
		 * @return 19位标准日期格式
		 */
		date14to19: function(str){
			if (str != undefined && str != "") {
				var st = str.substring(0, 4) + "年" + str.substring(4, 6) + "月"
						+ str.substring(6, 8) + "日 " + str.substring(8, 10) + ":"
						+ str.substring(10, 12) + ":" + str.substring(12, 14);
				return st;
			}
			return "";
		},
		/**
		 * 将14位数字字符串转成11位标准日期格式的字符串
		 * @param str 14位字符串
		 * @return 11位标准日期格式
		 */
		date14to11: function(str) {
			if (str != undefined && str != "") {
				var st = str.substring(0, 4) + "年" + str.substring(4, 6) + "月"
						+ str.substring(6, 8) + "日 ";
				return st;
			}
			return "";
		},
		/**
		 * 将19位标准日期格式的字符串转成14位数字字符串
		 * @param str 19位标准日期格式的字符串
		 * @return 14位数字字符串
		 */
		date19to14: function(str){
			var st = '';
			if (str != undefined && str != "") {
				st = str.replace(/\-/g,"").replace(/\:/g,"").replace(/\ /g,"");
			}
			return st;
		},
		/**
		 * 将14位数字字符串转日期格式
		 * @param str 14位字符串
		 * @return 日期
		 */
		dateFormat: function(str){
			if (str != undefined && str != "") {
				var st = str.substring(0, 4) + "/" + str.substring(4, 6) + "/"
						+ str.substring(6, 8) + " " + str.substring(8, 10) + ":"
						+ str.substring(10, 12) + ":" + str.substring(12, 14);
				return new Date(st);
			}
		},
		/**
		 * 日期14位数到17
		 * @param  str 14位日期字符串
		 * @return 日期字符串
		 */
		date14to17: function(str){
			if (str != undefined && str != "") {
				var st = str.substring(0, 4) + "-" + str.substring(4, 6) + "-"
						+ str.substring(6, 8) + " " + str.substring(8, 10) + ":"
						+ str.substring(10, 12) ;
				return st;
			}
			return "";
		},
		/**
		 * 日期8位数到10
		 * @param  str 8位日期字符串
		 * @return 日期字符串
		 */
		date8to10: function(str){
			if (str != undefined && str != "") {
				var st = str.substring(0, 4) + "-" + str.substring(4, 6) + "-"
						+ str.substring(6, 8);
				return st;
			}
			return "";
		},
		//
		/**
		 * 日期14位数到8
		 * @param  str 8位日期字符串
		 * @return 日期字符串
		 */
		date14to8: function(str){
			if (str != undefined && str != "") {
				var st = str.substring(0, 8);
				return st;
			}
			return "";
		},
		/** 
		 * 将14位字符串转为时间对象 [!]
		 * @param str 14位日期字符串
		 * @return 日期对象
		 */
		StringToDate: function(str){
			return new Date(Str.replace(/-/, "/"));
		},
		/**
		 * 计算讲个时间的天数差
		 * @param  d1 时间对象1
		 * @param  d2 时间对象2
		 * @return 天数
		 */
		dateDiff: function(d1, d2){
			var time = d2.getTime() - d1.getTime();
		    var days = parseInt(time / (1000 * 60 * 60 * 24));
		    return days;
		}
	};

	/**
	 * 顶部提示
	 * @class Tip
	 * @namespace Util
	 */
	util.Tip = (function(){
		function show(text, icon, _time){
			var maskWin = function () {
				var top = window,
				test = function (name) {
					try {
						var doc = window[name].document;	// 跨域|无权限
						doc.getElementsByTagName; 			// chrome 本地安全限制
					} catch (e) {
						return false;
					};
					
					return window[name].artDialog
					// 框架集无法显示第三方元素
					&& doc.getElementsByTagName('frameset').length === 0;
				};
				
				if (test('top')) {
					top = window.top;
				} else if (test('parent')) {
					top = window.parent;
				};
				
				return top;
			}();
			var $tip = maskWin.$('<div class="util-tip"><span><i></i>' + text + '</span></div>');
			var time = new Date().getTime();
			var _time = _time || 4000;
			if( maskWin.$('.util-tip:visible').length ){
				clearTimeout(window.timeOut);
			}
			maskWin.$('.util-tip').stop().remove();
			$tip.data('time', time).appendTo('body').fadeOut( _time ).find('span').addClass(icon);
			window.timeOut = setTimeout(function(){
				maskWin.$('.util-tip').remove();
			}, _time-1);
		}
		return {
			//成功提示
			success: function(text, time){
				show(text, 'success', time);
			},
			//警告提示
			warning: function(text, time){
				show(text, 'warning', time);
			},
			//错误提示
			error: function(text, time){
				show(text, 'error', time);
			}
		};
	})();
	
	/**
	 * 请求遮罩
	 */
	util.mask = (function(){
		function setMask(obj, ctn){
			var width = obj.outerWidth(),
				height = obj.outerHeight(),
				position = "absolute";
				
			//已存在遮罩
			var $loadingMask = obj.children("div.loadingMask");
			if($loadingMask.length > 0){
				$loadingMask.data("num", $loadingMask.data("num") + 1);
				return this;
			}	
			
			//不存在遮罩
			var maskStr = [
				'<div class="loadingMask">',
				'	<div class="mask"></div>',
				'	<div class="ctn">',
				'		<div><i></i><em>' + ctn + '</em></div>',
				'	</div>',
				'</div>'
			].join('');
			$loadingMask = $(maskStr).appendTo(obj.addClass("hasMask")).data("num", 1);
			var $loading = $loadingMask.find(".ctn");
			
			if (obj.is('body')) {
				width = "100%";
				height = "100%";
				if(!(/msie 6/i.test(navigator.userAgent))){
					position = "fixed";
				}
			}
			$loadingMask.css({
				position: position,
				width: width, 
				height: height
			});
			$loading.css({
				position: position
			});
			$loading.css({
				marginLeft: 0-$loading.width()/2,
				marginTop: 0-$loading.height()/2
			});
		}

		function clearMask(obj){
			var $loadingMask = obj.children(".loadingMask");
			var num = $loadingMask.data("num");
			if (num == undefined || num <= 1) {
				obj.removeClass("hasMask");
				$loadingMask.remove();
			} else {
				$loadingMask.data("num", num - 1);
			}
		}
		
		return {
			/**
			 * 设置遮罩
			 * @param Object opt 遮罩配置项
			 */
			set: function(opt){
				var opt = opt && (typeof opt === "object")? opt : {
						dom: $('body'),
						ctn: "正在加载…"
					},
					$this = opt.dom || $('body'),
					ctn = opt.ctn || "正在加载…";
				setMask($this, ctn);
			},
			/**
			 * 清除遮罩
			 * @param Obj 删除制定Dom对象的遮罩
			 */
			clear: function(dom){
				var $this = (typeof dom === "object") ? dom : $('body');
				clearMask($this);
			}			
		}
	})();

	
	/**
	 * 数据加载
	 * 直接调用jquery的ajax请求
	 * @class Ajax
	 * @namespace Util
	 */
	util.Ajax = {
		baseSet:{
			beforeSend :function(){
				Util.mask.set();
			},
			complete : function(){
				Util.mask.clear();
			},
			error : function(){
				Util.Tip.warning(Message.get('LOAD_ERROR'));
			}
		},
		//POST发送数据
		post: function (url, data, callback, type) {
			var opt = $.extend(this.baseSet, {
				type: 'POST',
				dataType: type || 'json',
				url: CONTEXTPATH + url, 
				data: data,
				success: function(data, textStatus, jqXHR){
					if( data.returnFlag != undefined && data.returnFlag == false ){
						Util.Tip.warning(Message.get(data.data||'LOAD_ERROR'));
						return ;
					}
					callback && callback(data);
				}
			});
			
			$.ajax(opt);
		},
		
		//GET请求数据
		get: function (url, data, callback, type) {
			var opt = $.extend(this.baseSet, {
				type:'GET',
				dataType:type || 'json',
				url: CONTEXTPATH + url, 
				data: data,
				success: function(data, textStatus, jqXHR){
					if( data.returnFlag != undefined && data.returnFlag == false ){
						Util.Tip.warning(Message.get( data.data || 'LOAD_ERROR' ));
						return ;
					}
					callback && callback(data);
				}
			});
			
			$.ajax(opt);
		}
	};
	win.Util = util;
})(window,jQuery);

(function($){
	// tab的切换
	$.fn.tabToggle = function(callback) {
		return this.each(function() {
			var $this = $(this);
			var $tit = $this.children(".tab_tit");
			var $ctn = $this.children(".tab_ctn");
			$tit.children(".item").each(function(i) {
				$(this).click(function() {
					$ctn.children("div.item").eq(i).show().siblings("div.item").hide();
					$(this).addClass("select")
						.siblings(".item").removeClass("select");
				});
			});
			if(callback){
				callback && callback.call($tit);
			}else{
				$tit.children(".item").eq(0).click();
			}
		});
	};

	//输入框默认提示
	$.fn.tip = function(options){
		options = options || {};
		return this.each(function(){
			var $input = $(this), text = $input.data("tip");
			var $tip = $('<span class="wrap_tip fix"><div class="ctrl_tip" title="' + text + '">' + text + '</div></span>');
			$input.prev(".wrap_tip").remove();
			$tip.insertBefore($input).hide()
				.children(".ctrl_tip").css({
					width: $input.width()
				}).click(function(){
					$input.focus();
				});
			setTimeout(function(){render();}, 0);
			if (!$input.val()) $tip.show();
	        $input.focus(function () {
	        	$tip.hide();
	        	render();
	        }).blur(function () {
	        	if (!$input.val()) {
	        		$tip.show();
	            }
	        });
	        
	        function render(){
	        	setTimeout(function(){
		        	$tip.children(".ctrl_tip").css({
						width: $input.width(),
						lineHeight:$input.height()+'px',
						fontSize: $input.css('fontSize'),
						paddingTop:$input.css('paddingTop')
					});
	        	});
	        }
	        
	        $(window).resize(function(){
	        	render();
	        });
		});
	};
	
	//输入限制
	$.fn.limited = function(opts) {
		return this.each(function() {
			var $input = $(this);
			
			switch(opts.type){
			case 'int':
				$input.keyup(function(){
					var val = $(this).val();
					val = val.replace(/\D/g,'');
					if(val){
						val = parseInt(val);
						if(opts.min){
							if(val < opts.min) val = opts.min;
						}
						if(opts.max){
							if(val > opts.max) val = opts.max;
						}
					}
					$(this).val(val);
				});
				$input[0].onafterpaste = function(){
					var val = this.value;
					val = val.replace(/\D/g,'');
					if(val){
						val = parseInt(val);
						if(opts.min){
							if(val < opts.min) val = opts.min;
						}
						if(opts.max){
							if(val > opts.max) val = opts.max;
						}
					}
					this.value = val;
				};
			}
		});
	};

	//序列化JSON
	$.fn.serializeJson = function(){  
        var serializeObj = {};  
        var array = this.serializeArray();  
        $(array).each(function(){  
        	var value = this.value;
            if(serializeObj[this.name]){  
                if($.isArray(serializeObj[this.name])){  
                    serializeObj[this.name].push(value);  
                }else{  
                    serializeObj[this.name]=[serializeObj[this.name],value];  
                }  
            }else{  
                serializeObj[this.name]=value;   
            }  
        });  
        return serializeObj;  
    };
    
    //密码强度计算
    $.fn.pwdStrength = function(domObj){
    	//密码强度判断函数
    	//判断输入密码的类型    
    	function CharMode(iN){    
    	    if (iN>=48 && iN <=57) //数字    
    	        return 1;    
    	    if (iN>=65 && iN <=90) //大写    
    	        return 2;    
    	    if (iN>=97 && iN <=122) //小写    
    	        return 4;    
    	    else    
    	        return 8;     
    	}  
    	//计算密码模式    
    	function bitTotal(num){    
    	    var modes=0;    
    	    for (i=0;i<4;i++){    
    	        if (num & 1) modes++;    
    	        num>>>=1;    
    	    }  
    	    return modes;    
    	}  
    	//返回强度级别    
    	function checkStrong(sPW){    
    	    if (sPW.length<6)    
    	        return 0; //密码太短，不检测级别  
    	    var Modes=0;    
    	    for (i=0;i<sPW.length;i++){    
    	        //密码模式    
    	        Modes|=CharMode(sPW.charCodeAt(i));    
    	    }  
    	    return bitTotal(Modes);    
    	}  
    	var levl = 'default',
    		pwd = domObj.val();
    	if (pwd){    
            var _level=checkStrong(pwd);    
            switch(_level) {    
	            case 0:    
	            	levl = 'low'; 
	                break;  
	            case 1:    
	            	levl = 'middle';  
	                break;    
	            case 2:    
	            	levl = 'high';    
	                break;    
	            default:    
	            	levl = 'default';    
	        }
    	}
        return levl;
    };
    
})(jQuery);

/**
 * 登录 统一入口
 */
function login(callback){
	window.tempcallback = callback;
	setTimeout(function(){
		window.loginDialog = $.dialog.open( CONTEXTPATH+'/transfer.jsp?sspt='+currentSspt, {
			title:'登录亳州市网上办事大厅',
			drag:false,
			lock:true,
			width:460,
			height:410,
			padding:'0 0',
			init: function () {
		    	var iframe = this.iframe.contentWindow;
		    	var top = art.dialog.top;// 引用顶层页面window对象
	    		//iframe.callback = callback;
		    }
		});
	},0);
}

/**
 * 退出 统一入口
 */
function logout(){
	setTimeout(function(){
		$.dialog({
			title:'提示',
			content:'确认退出？',
			width:220,
			hight:160,
			lock:true,
			drag:false,
			ok:function(){
				window.location.href = CONTEXTPATH+'/logout.do?sspt='+SSPT;
			},
			cancel:function(){
				clearSessionDynamicPassword();
			}
		});
	},0);
}
/**
 * 短信验证码清除
 * 短信验证超时关闭session中动态密码
 * @author bingye
 */
function clearSessionDynamicPassword(){
	$.ajax({
		type:"post",
		url:CONTEXTPATH+"/cleardynamicpassword.do"
	});
}
/**
 * a 标签打开新窗口 全屏
 * 
 * 主要是针对IE 
 * 
 */
function openFullWindow(url){
	var wHeight = screen.height,
    	wWidth = screen.width ;
	if(isIE){
		window.open(url, 'newWin', 'fullscreen=yes, left=0px, top=0px, width='+ wWidth +',height='+ wHeight +', resizable=yes, scrollbars=yes, toolbar=yes, menubar=yes, location=yes' ); 
		return false;
	}
}

/**
 * 特定的form表单 快捷键支持
 * 
 * @param targetBtn 提交按钮的id
 * @param warp form表单对象 默认为全局的 input标签
 */
function bindEnterEvent(targetBtn, wrap){
	var $warp = wrap || $('body'),
		$targetBtn = targetBtn;//$('#'+targetBtnId);
	//支持enter键
	$warp.each(function(){
		var $that = $(this);
		$that.find("input[type='text'], input[type='password']").bind("keydown keypress", function (event) {
		    if (event.which === 13) {
		    	$that.find($targetBtn).trigger('click');
		        event.preventDefault();
		    }
		});
	});
}

//将字符串经过 html 转义得到适合在页面中显示的内容, 例如替换 < 为 &lt; 
function replaceEscapeCharacter(target){
    return target.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/"/g, "&quot;").replace(/'/g, "&#39;");     
}

//将字符串经过 解析成html的符号, 例如替换 &lt 为 <; 
function unEscapeCharacter(target){ 
	return target.replace(/&quot;/g, '"').replace(/&lt;/g, "<").replace(/&gt;/g, ">").replace(/&amp;/g, "&") //处理转义的中文和实体字符 
    .replace(/&#([\d]+);/g, function($0, $1) {
    	return String.fromCharCode(parseInt($1, 10)); 
    });   
}

//获取URL参数
(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", 'i');
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }
})(jQuery);

/**
 * 项目启动预设一些执行
 */
$(function(){
	$('.text_tip').tip();
	//防止用户backspace键页面后退
	$("input[readonly]").live("keydown",function(e){
		e.preventDefault();
	});
	//登陆
	$('#index_login').click(function(){
		login(function(){
			window.location.reload();
		});
	});
	
	//链接跳转  不要删掉
	/*$('.link').live('click', function(evt){
		var $that = $(this),
			$cur = $(evt.target),
			url = $that.attr('href');
		if(url.indexOf('javascript') == -1){
			openFullWindow($that.attr('href'));
		}
	});*/
	
	//IE 6下表格的hover效果
	if( (/msie 6/i.test(navigator.userAgent))){
		$('.table-list tbody').delegate('tr', 'hover', function(){
			var $that = $(this);
			$that.siblings().removeClass('ie6-hover');
			$that.toggleClass('ie6-hover');
		});
	}
});