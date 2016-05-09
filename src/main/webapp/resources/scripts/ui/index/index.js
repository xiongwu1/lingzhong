(function() {
	
	var Index = {
		_init : function() {
			window.Index= Index;
		},
		IndexData : {}
	};
	
	//初始化
	Index.Base = {
	};
	
	Index.IndexData = (function() {
		//页面加载
		function IndexDataLoad() {
			//渲染页面
			$('body').mask().setMask();
			$.when().done(function(){
			}).then(function(){
				IndexDataRender();
				$('body').mask().clearMask();
			}).fail(function(){
				$('body').mask().clearMask();
				window.parent.Util.warn('数据获取失败！');
			});
		};
		
		//渲染列表页面
		function IndexDataRender(){
			
			//获取首页最新的邻文列表
			Util.mask.set();
			$.ajax({
				type : "POST",
				dataType:"json",
				url : CONTEXTPATH + "/NewlwBlogList.do",
				data : {},
				success : function(data) {
					
					var html = "";
					var fastdfsUrl = "http://192.168.1.110:8888/";
					
					if (data.rows.length > 0) {
						for(var i =0;i<data.rows.length;i++) {
							html += '<div class="blog_list">';
							html += '<div class="blog_content">';
							html += '<div class="head_info">';
							html += '<div class="head_left">';
							html += '<figure><div>';
							if (data.rows[i].headPortrait == '') {
								html += '<img src="'+ CONTEXTPATH + "/resources/images/default_icon.png" +'"/>';
							}else {
								html += '<img src="'+ fastdfsUrl + data.rows[i].headPortrait + '"/>';
							}
							html += '</div></figure>';
							html += '</div><div class="head_right">';
							html += '<p class="web_name"><b>'+ data.rows[i].nickName +'</b></p>';
							html += '<p class="web_time">' + Util.date.date14to19(data.rows[i].releaseTime) + '&nbsp;&nbsp;&nbsp;' + data.rows[i].releasePlace + '</p>';
							html += '</div></div>';
							html += '<div class="web_info">'+ AnalyticEmotion(data.rows[i].content) +'</div>';
							
							if(data.rows[i].zlImageList.length != 0) {
								//var pictureUrl = data.rows[i].pictureUrl.split(",");
								html += '<div class="img_info">';
								for(var j = 0; j < data.rows[i].zlImageList.length; j++) {
									html += '<img alt="邻文图片" src="'+ fastdfsUrl + data.rows[i].zlImageList[j].imageUrl +'">';
								}
								html += '</div>';
							}
							html += '</div>';
							html += '<div class="blog_operate">';
							html += '<ul><li><a href="javascript:void(0);">收藏</a></li><li><a href="javascript:void(0);">转发<span>'+ data.rows[i].forwardNum+'</span></a></li>';
							html += '<li><a href="javascript:void(0);">评论<span>'+ data.rows[i].commentNum +'</span></a></li><li><a href="javascript:void(0);">赞<span>'+ data.rows[i].likeNum +'</span></a></li></ul></div></div>';
						}
						//html += '<div class="page" style="width:610px;margin:0 auto;"><div id="kkpager"></div></div>';
					}else {
						html += '<div class="default_empty">暂无邻文展示，赶紧登陆去发表一条吧！</div>';
					}
					$("#left_blog_list").append(html);
					
					//分页展示
					function getParameter(name) { 
						var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
						var r = window.location.search.substr(1).match(reg); 
						if (r!=null) return unescape(r[2]); return null;
					}

					$(function(){
						var pageNo = getParameter('pno');
						if(!pageNo){
							pageNo = 1;
						}
						//生成分页
						//有些参数是可选的，比如lang，若不传有默认值
						kkpager.generPageHtml({
							pno : pageNo,
							//总页码
							total : Math.ceil(data.total/10),
							//总数据条数
							totalRecords : data.total,
							//链接前部
							hrefFormer : 'pager_test_orange_color',
							//链接尾部
							hrefLatter : '.html',
							getLink : function(n){
								return this.hrefFormer + this.hrefLatter + "?pno="+n;
							},lang: {
								firstPageText			: '首页',
								firstPageTipText		: '首页',
								lastPageText			: '尾页',
								lastPageTipText			: '尾页',
								prePageText				: '上一页',
								prePageTipText			: '上一页',
								nextPageText			: '下一页',
								nextPageTipText			: '下一页',
								totalPageBeforeText		: '共',
								totalPageAfterText		: '页',
								currPageBeforeText		: '当前第',
								currPageAfterText		: '页',
								totalInfoSplitStr		: '/',
								totalRecordsBeforeText	: '共',
								totalRecordsAfterText	: '条数据',
								gopageBeforeText		: '&nbsp;转到',
								gopageButtonOkText		: '确定',
								gopageAfterText			: '页',
								buttonTipBeforeText		: '第',
								buttonTipAfterText		: '页'
							},
							mode : 'click',//默认值是link，可选link或者click
							click : function(n){
								Util.mask.set();
								this.selectPage(n);
								$.ajax({
									type : "POST",
									dataType:"json",
									url : CONTEXTPATH + "/NewlwBlogList.do",
									data : {currentPageNo:n},
									success : function(data) {
										var html = "";
										var fastdfsUrl = "http://192.168.1.110:8888/";
										
										if (data.rows.length > 0) {
											for(var i =0;i<data.rows.length;i++) {
												html += '<div class="blog_list">';
												html += '<div class="blog_content">';
												html += '<div class="head_info">';
												html += '<div class="head_left">';
												html += '<figure><div>';
												if (data.rows[i].headPortrait == '') {
													html += '<img src="'+ CONTEXTPATH + "/resources/images/default_icon.png" +'"/>';
												}else {
													html += '<img src="'+ fastdfsUrl + data.rows[i].headPortrait + '"/>';
												}
												html += '</div></figure>';
												html += '</div><div class="head_right">';
												html += '<p class="web_name"><b>'+ data.rows[i].nickName +'</b></p>';
												html += '<p class="web_time">' + Util.date.date14to19(data.rows[i].releaseTime) + '&nbsp;&nbsp;&nbsp;' + data.rows[i].releasePlace + '</p>';
												html += '</div></div>';
												html += '<div class="web_info">'+ AnalyticEmotion(data.rows[i].content) +'</div>';
												
												if(data.rows[i].zlImageList.length != 0) {
													//var pictureUrl = data.rows[i].pictureUrl.split(",");
													html += '<div class="img_info">';
													for(var j = 0; j < data.rows[i].zlImageList.length; j++) {
														html += '<img alt="邻文图片" src="'+ fastdfsUrl + data.rows[i].zlImageList[j].imageUrl +'">';
													}
													html += '</div>';
												}
												html += '</div>';
												html += '<div class="blog_operate">';
												html += '<ul><li><a href="javascript:void(0);">收藏</a></li><li><a href="javascript:void(0);">转发<span>'+ data.rows[i].forwardNum+'</span></a></li>';
												html += '<li><a href="javascript:void(0);">评论<span>'+ data.rows[i].commentNum +'</span></a></li><li><a href="javascript:void(0);">赞<span>'+ data.rows[i].likeNum +'</span></a></li></ul></div></div>';
											}
											//html += '<div class="page" style="width:610px;margin:0 auto;"><div id="kkpager"></div></div>';
										}else {
											html += '<div class="default_empty">暂无邻文展示，赶紧登陆去发表一条吧！</div>';
										}
										$("#left_blog_list").html(html);
										Util.mask.clear();
									},error : function() {  
										Util.Tip.warning('获取数据失败！');
										Util.mask.clear();
								    }
								});
							}
						});
					});
					Util.mask.clear();
				},
				error : function() {  
					Util.Tip.warning('获取数据失败！');
					Util.mask.clear();
			    }
			});
			
			//获取TOP10邻文数据
			Util.mask.set();
			Dao.Index.hotLwBlog().done(
				function(data) {
					var html = "";
					if (data.length > 0) {
						for(var i=0; i<data.length;i++) {
							html += '<div class="topic_content"><p class="topic_left">';
							if (data[i].content.length >10) {
								html += '<a href="#">#'+ data[i].content.substring(0,10) +'...#</a></p>';
							}else {
								html += '<a href="#">#'+ data[i].content +'#</a></p>';
							}
							html +='<p class="topic_time">'+ Util.date.date14to11(data[i].releaseTime) +'</p></div>';
						}
					}else {
						html += '<div class="defalut_topic">暂无热门邻文</div>';
					}
					
					$(".topic_list").append(html);
					Util.mask.clear();
			}).fail(function() {
				Util.mask.clear();
				Util.Tip.warning('数据加载失败！');
			});
			
			//获取最活跃的TOP10用户
			Util.mask.set();
			Dao.Index.hotUser().done(
				function(data) {
					var html = "";
					if(data.length > 0) {
						for(var i=0; i<data.length;i++) {
							html += '<div class="topic_content"><p class="topic_left">';
							if (data[i].nickName.length >10) {
								html += '<a href="#">#'+ data[i].nickName.substring(0,10) +'...</a></p>';
							}else {
								html += '<a href="#">'+ data[i].nickName +'</a></p>';
							}
							if(data[i].isAttent == "true") {
								html +='<p class="payAttention"><a user-id='+data[i].objectid+' href="javascript:void(0);">取消关注</a></p></div>';
							}else {
								html +='<p class="payAttention"><a user-id='+data[i].objectid+' href="javascript:void(0);">加关注</a></p></div>';
							}
						}
					}else {
						html += '<div class="defalut_topic">暂无用户，快去注册一个吧！</div>';
					}
					$(".finduser_list").append(html);
					
					//加关注操作
					$('.payAttention a').each(function(e) {
						var $that = this;
						$($that).click(function(){
							//获取被关注者ID
							var attentUserId = $($that).attr('user-id');
							if(currentUser == "") {
								Util.Tip.warning('您未登陆，请登陆再操作！');
							}else {
								if($($that).html() == "加关注") {
									Dao.Index.payAttention(attentUserId).done(
										function(data) {
											if (data == "false") {
												Util.Tip.warning('您不能对自己加关注，请换个邻友试试！');
											}else if(data == "1") {
												Util.Tip.warning('关注失败，请重试尝试一下！');
											}else if(data.returnFlag = true){
												Util.Tip.success('加关注成功，快去关注他的动态吧！');
												$($that).html("取消关注");
											}
											Util.mask.clear();
									}).fail(function() {
										Util.mask.clear();
										Util.Tip.warning('数据加载失败！');
									});
								}else {
									Dao.Index.cancelAttention(attentUserId).done(
										function(data) {
											if(data.returnFlag = true){
												Util.Tip.success('取消关注成功！');
												$($that).html("加关注");
											}
											Util.mask.clear();
										}).fail(function() {
											Util.mask.clear();
											Util.Tip.warning('数据加载失败！');
									});
								}
							}
						});
					});
					Util.mask.clear();
			}).fail(function() {
				Util.mask.clear();
				window.Util.warn('数据加载失败！');
			});
			
			
			//登陆处理
			var $loginName = $('input[name="loginName"]');
			var $password = $('input[name="password"]');
			
			//表单是否填写验证
			$loginName.blur(function() {
				if($loginName.val() == "") {
					Util.Tip.warning("账号不能为空！");
					return false;
				}
			});
			$password.blur(function() {
				if($password.val() == "") {
					Util.Tip.warning("密码不能为空！");
					return false;
				}
			});
			
			$('.signin input').click(function() {
				//表单是否填写验证
				if($loginName.val() == "") {
					Util.Tip.warning("账号不能为空！");
					return false;
				}
				if($password.val() == "") {
					Util.Tip.warning("密码不能为空！");
					return false;
				}
				//验证密码规则
				if($.trim($password.val()).length<6 || $.trim($password.val()).length > 20){
					Util.Tip.warning("密码长度必须是6到20位 ！");
				    $password.focus();
					return false;
				}
				//验证登陆的是手机号、邮箱还是登陆名
				var emailReg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
				var phoneReg = /^\d{11}$/;
				if ($loginName && emailReg.test($loginName.val())) {
					$('.account').attr('name','email');
				}else if ($loginName && phoneReg.test($loginName.val())) {
					$('.account').attr('name','mobilePhone');
				}
				
				Util.mask.set();
				//提交个人用户表单数据
				$.ajax({
					type : "POST",
					dataType:"json",
					url : CONTEXTPATH + "/user/userLogin.do",
					data : $('#loginForm').serialize(),
					success : function(data) {
						if(data.data == "LOGINNAME_ERROR") {
							Util.Tip.warning('账号不存在！');
							$loginName.focus();
							Util.mask.clear();
							return false;
						}else if(data.data == "PASSWORD_ERROR") {
							Util.Tip.warning('密码不正确！');
							$password.focus();
							Util.mask.clear();
							return false;
						}else {
							Util.Tip.success("登陆成功！");
							Util.mask.clear();
				    		window.open(CONTEXTPATH+"/home/home.do", "_self");
						}
					},
					error : function() {  
						Util.Tip.warning('登陆失败，请检查表单填写是否有误！');
						Util.mask.clear();
				    }
				});
			});
			//登陆的enter键支持
			enterEvent();

			//意见反馈
			$(".feedBack").click(function() {
				 layer.open({
				 		title:['意见反馈','text-align:center;'],
                        type: 1,
                        area: ['500px', '360px'],
                        shadeClose: true, //点击遮罩关闭
                        content: '\<\div id="feedBackDiv" >'+
                        '<p>反馈内容：</p><textarea rows="5" cols="36" maxlength="100"></textarea><br />'+
                        '<p>联系方式：</p><input type="text" name="feedBackTel" id="feedBackTel" />'
                        +'\<\/div>',

                        shift: 1, //0-6的动画形式，-1不开启
                        btn:['提交','取消'],
                        yes: function(index, layero){

                        	var feedBackContent = $("#feedBackDiv textarea").val();
                        	var feedBackTel = $("input[name='feedBackTel']").val();
                        	if(feedBackContent == "") {
                        		Util.Tip.warning('反馈内容不能为空！');
                        		return false;
                        	}else if(feedBackTel =="") {
                        		Util.Tip.warning('联系方式不能为空！');
                        		return false;
                        	}
                        	$.ajax({
								type : "POST",
								dataType:"json",
								url : CONTEXTPATH + "/FeedBack.do",
								data : {feedBackContent:feedBackContent,feedBackTel:feedBackTel},
								success : function(data) {
									if(data.data == "SUCCESS") {
										layer.msg('您好，感谢您的反馈与建议，我们会尽快改善！', {
											  icon: 1,
											  time: 2000 //2秒关闭（如果不配置，默认是3秒）
											}, function(){
												window.open(CONTEXTPATH+"/home/home.do", "_self");
											});   
										
									}
								}
							});
                        },
                        cancel: function(index){
                        	layer.msg('您已取消反馈！');
                        },
                 });
			});
		}
		
		return {
			IndexDataLoad : IndexDataLoad
		};
	})();
	
	Index._init();
})();