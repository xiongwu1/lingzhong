(function() {
	
	var Home = {
			_init : function() {
				window.Home= Home;
			},
			HomeIndex : {}
		};
	
	//初始化
	Home.Base = {
		Dict : {
			XB : (function() {
				return new Util.Dict();
			})()
		}
	};
	
	Home.HomeIndex = (function() {
		
		//页面加载
		function HomeIndexLoad() {

			//渲染页面
			$('body').mask().setMask();
			$.when(Dao.Dictionary.getDict('XB')).done(function(xb){
				Home.Base.Dict.XB.Set(xb);
			}).then(function(){
				$('body').mask().clearMask();
				HomeRender();
			}).fail(function(){
				$('body').mask().clearMask();
				window.parent.Util.warn('数据获取失败！');
			});
		};
		
		//渲染列表页面
		function HomeRender(){
			//设置一个定时器，为BUTTON点击事件用
			var timer=null;
			var number1=0;
			
			//文本框获得焦点和失去焦点时的事件
	/*		$('.emotion').focus(function(){
				$(this).css({'border':'1px solid #FA7D3C'});
				if($(this).val()==''){
					$(this).siblings('p').html('发言遵守“7条底线”，还可以输入<span>140</span>字').css({'color':'#999','cursor':'','float':'right','font-size':'12px','margin':'5px 5px 0 0'});
				}
			}).blur(function(){
				$(this).css({'border':''});
				if($(this).val()==''){
					$(this).css('background-color','white').siblings('p').html('<a href="#"></a>').css({'color':'blue','cursor':'pointer'});
				}
			});*/
			
			//文本输入时改变
			$('.emotion').keyup(function(){
				if(!$(this).val()==''){
					$('.release_btn').css({'background-color':'#FF8140'});
				}else{
					$('.release_btn').css({'background-color':'#FFC09F'});
					//$('.release_btn').attr("disabled", "true");
				}
				//Math函数向上取值
				/*var iNum=Math.ceil(getLength($(this).val())/2);
				if(iNum<=140){
					$('.send_weibo p span').html(140-iNum).css('color','#2EFC9D');
				}else{
					$('.send_weibo p span').html(iNum-140).css('color','red');
					$('button').addClass('dis');
				}*/
			});
			
			//处理输入的内容是文字还是字母的函数
			function getLength(str){
				return String(str).replace(/[^\x00-\xff]/g,'aa').length;
			};
			
			//上传图片下拉框
			$('.upload_img').click(function() {
				$('.upload_div').slideDown();
			});
			//收缩上传图片下拉框
			$('.uploadDiv_close').click(function() {
				$('.upload_div').slideUp();
			});
			//删除、取消关注邻文的鼠标触发和离开事件
			$(".edit_lwBlog a").mouseenter(function() {
				$('.editLw_div').slideDown();
			});
			$(".editLw_div").mouseleave(function() {
				$('.editLw_div').slideUp();
			});
			
			//绑定按钮事件，当文本框为空时点击背景色会闪动
			$('.release_btn').click(function(){
				
				//字数超出
				var iNum=Math.ceil(getLength($('.emotion').val())/2);
				if(iNum >140) {
					clearInterval(timer);
					timer=setInterval(function(){
						if(number1==4){
							clearInterval(timer);
							number1=0;
						}else{
							number1++;
						}
						if(number1%2){
							$('.emotion').css('background-color','#FFD9D9');
						}else{
							$('.emotion').css('background-color','');
						}
					},200);
					return false;
				}
				
				if ($('.emotion').val() == '') {
					clearInterval(timer);
					timer=setInterval(function(){
						if(number1==4){
							clearInterval(timer);
							number1=0;
						}else{
							number1++;
						}
						if(number1%2){
							$('.emotion').css('background-color','#FFD9D9');
						}else{
							$('.emotion').css('background-color','');
						}
					},200);
					return false;
				}else{
					Util.mask.set();
					//提交个人用户表单数据
					$.ajax({
						type : "POST",
						dataType:"json",
						url : CONTEXTPATH + "/lwBlog/publishLwBlog.do",
						contentType: "application/x-www-form-urlencoded; charset=utf-8", 
						data : $('#publishForm').serialize(),
						success : function(data) {
							if (data.data == "SUCCESS") {
								Util.mask.clear();
								Util.Tip.success('发布成功！');
								window.open(CONTEXTPATH+"/home/home.do", "_self");
							}
						},
						error : function() {  
							Util.Tip.warning('发布失败，请冷静思考一下！');
							Util.mask.clear();
					    }  
					});
					//$('.emotion').val('');
					//$(this).addClass('dis');
					//$('.emotion').blur();
				}
			});
			
			$(function(){
				// 初始化插件
				$("#zyupload").zyUpload({
					width            :   "650px",                 // 宽度
					height           :   "400px",                 // 宽度
					itemWidth        :   "140px",                 // 文件项的宽度
					itemHeight       :   "115px",                 // 文件项的高度
					url              :   CONTEXTPATH + "/attach/uploadImg.do",  // 上传文件的路径
					fileType         :   ["jpg","png","jpeg","gif"],// 上传文件的类型
					fileSize         :   51200000,                // 上传文件的大小
					multiple         :   true,                    // 是否可以多个文件上传
					dragDrop         :   true,                    // 是否可以拖动上传文件
					tailor           :   true,                    // 是否可以裁剪图片
					del              :   true,                    // 是否可以删除文件
					finishDel        :   false,  				  // 是否在上传文件完成后删除预览
					/* 外部获得的回调接口 */
					onSelect: function(selectFiles, allFiles){    // 选择文件的回调方法  selectFile:当前选中的文件  allFiles:还没上传的全部文件
						console.info("当前选择了以下图片：");
						console.info(selectFiles);
					},
					onDelete: function(file, files){              // 删除一个文件的回调方法 file:当前删除的文件  files:删除之后的文件
						console.info("当前删除了此图片：");
						console.info(file.name);
					},
					onSuccess: function(file, response){          // 文件上传成功的回调方法
						console.info("此图片上传成功：");
						console.info(file.name);
						console.info("此图片上传到服务器地址：");
						console.info(response);
						if(eval( "(" + response + ")" ).success == "false") {
							Util.Tip.warning("图片上传失败！");
						}
						//追加返回值imgIdStr
						var imgIdStr = $('input[name="imgIdStr"]');
						if (imgIdStr.val() != "") {
							imgIdStr.val(imgIdStr.val() + "," + eval( "(" + response + ")" ).imgIdStr);
						}else {
							imgIdStr.val(eval( "(" + response + ")" ).imgIdStr);
						}
						
						//追加返回值imgUrlStr
						var imgUrlStr = $('input[name="imgUrlStr"]');
						if (imgUrlStr.val() != "") {
							imgUrlStr.val(imgUrlStr.val() + "," + eval( "(" + response + ")" ).imgUrlStr);
						}else {
							imgUrlStr.val(eval( "(" + response + ")" ).imgUrlStr);
						}
						
					/*	$("#uploadInf").append("<p>上传成功，文件地址是：" + response + "</p>");*/
					},
					onFailure: function(file, response){          // 文件上传失败的回调方法
						Util.Tip.warning("图片上传失败！");
						console.info("此图片上传失败：");
						console.info(file.name);
					},
					onComplete: function(response){           	  // 上传完成的回调方法
						Util.Tip.success("上传完成！");
						console.info("图片上传完成");
						console.info(response);
					}
				});
			});
			
			//获取首页最新的邻文列表
			Util.mask.set();
			$.ajax({
				type : "POST",
				dataType:"json",
				url : CONTEXTPATH + "/home/MyFriendsNewLwList.do",
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
							html += '<p class="webList_name"><b>'+ data.rows[i].nickName +'</b></p>';
							html += '<p class="web_time">' + Util.date.date14to19(data.rows[i].releaseTime) + '&nbsp;&nbsp;&nbsp;' + data.rows[i].releasePlace + '</p>';
							html += '</div></div>';
							html += '<div class="web_info">'+ AnalyticEmotion(data.rows[i].content) +'</div>';
							
							if(data.rows[i].zlImageList.length != 0) {
								html += '<div class="img_info">';
								for(var j = 0; j < data.rows[i].zlImageList.length; j++) {
									html += '<img alt="邻文图片" src="'+ fastdfsUrl + data.rows[i].zlImageList[j].imageUrl +'">';
								}
								html += '</div>';
							}
							html += '</div>';
							html += '<div class="blog_operate">';
							html += '<ul><li><a href="javascript:void(0);">转发<span>'+ data.rows[i].forwardNum+'</span></a></li><li class="lw_comments"><a href="javascript:void(0);" lwBlog-id='+data.rows[i].objectid+'>评论<span>'+ data.rows[i].commentNum +'</span></a></li>';
							if(data.rows[i].isLike == "true") {
								html += '<li class="lw_like"><a style="color:#EE8E6F;" lwBlog-id='+data.rows[i].objectid+' href="javascript:void(0);"><em>已赞</em><span>'+ data.rows[i].likeNum +'</span></a></li>';
							}else {
								html += '<li class="lw_like"><a lwBlog-id='+data.rows[i].objectid+' href="javascript:void(0);"><em>赞</em><span>'+ data.rows[i].likeNum +'</span></a></li>';
							}
							
							if($("#currentUserId").val() == data.rows[i].userId) {
								html += '<li class="delete_collection"><a lwBlog-id='+data.rows[i].objectid+' href="javascript:void(0);">删除</a></li>';
							}else {
								if(data.rows[i].isCollection == "true") {
									html += '<li class="delete_collection"><a lwBlog-id='+data.rows[i].objectid+' href="javascript:void(0);">取消收藏</a></li>';
								}else {
									html += '<li class="delete_collection"><a lwBlog-id='+data.rows[i].objectid+' href="javascript:void(0);">收藏</a></li>';
								}
							}
							html += '</ul></div></div>';
						}
						//html += '<div id="page"></div>';
					}else {
						html += '<div class="default_empty">暂无邻文展示，去关注好友或者发一条？</div>';
					}
					$(".left_blog_list").append(html);
					
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
									url : CONTEXTPATH + "/home/MyFriendsNewLwList.do",
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
												html += '<p class="webList_name"><b>'+ data.rows[i].nickName +'</b></p>';
												html += '<p class="web_time">' + Util.date.date14to19(data.rows[i].releaseTime) + '&nbsp;&nbsp;&nbsp;' + data.rows[i].releasePlace + '</p>';
												html += '</div></div>';
												html += '<div class="web_info">'+ AnalyticEmotion(data.rows[i].content) +'</div>';
												
												if(data.rows[i].zlImageList.length != 0) {
													html += '<div class="img_info">';
													for(var j = 0; j < data.rows[i].zlImageList.length; j++) {
														html += '<img alt="邻文图片" src="'+ fastdfsUrl + data.rows[i].zlImageList[j].imageUrl +'">';
													}
													html += '</div>';
												}
												html += '</div>';
												html += '<div class="blog_operate">';
												html += '<ul><li><a href="javascript:void(0);">转发<span>'+ data.rows[i].forwardNum+'</span></a></li><li class="lw_comments"><a href="javascript:void(0);" lwBlog-id='+data.rows[i].objectid+'>评论<span>'+ data.rows[i].commentNum +'</span></a></li>';
												if(data.rows[i].isLike == "true") {
													html += '<li class="lw_like"><a style="color:#EE8E6F;" lwBlog-id='+data.rows[i].objectid+' href="javascript:void(0);"><em>已赞</em><span>'+ data.rows[i].likeNum +'</span></a></li>';
												}else {
													html += '<li class="lw_like"><a lwBlog-id='+data.rows[i].objectid+' href="javascript:void(0);"><em>赞</em><span>'+ data.rows[i].likeNum +'</span></a></li>';
												}
												
												if($("#currentUserId").val() == data.rows[i].userId) {
													html += '<li class="delete_collection"><a lwBlog-id='+data.rows[i].objectid+' href="javascript:void(0);">删除</a></li>';
												}else {
													if(data.rows[i].isCollection == "true") {
														html += '<li class="delete_collection"><a lwBlog-id='+data.rows[i].objectid+' href="javascript:void(0);">取消收藏</a></li>';
													}else {
														html += '<li class="delete_collection"><a lwBlog-id='+data.rows[i].objectid+' href="javascript:void(0);">收藏</a></li>';
													}
												}
												html += '</ul></div></div>';
											}
										}else {
											html += '<div class="default_empty">暂无邻文展示，去关注好友或者发一条？</div>';
										}
										$(".left_blog_list").html(html);
										
										//删除、收藏操作
										deleteCollection();
										//点赞操作
										lwLike();
										//评论操作
										lwComments();
										
										Util.mask.clear();
									},error : function() {  
										Util.Tip.warning('获取数据失败！');
										Util.mask.clear();
								    }
								});
							}
						});
					});
					//删除、收藏操作
					deleteCollection();
					//点赞操作
					lwLike();
					//评论操作
					lwComments();
					
					Util.mask.clear();
				},error : function() {  
					Util.Tip.warning('获取数据失败！');
					Util.mask.clear();
			    }
			});
			
			//获取统计信息
			Util.mask.set();
			$.ajax({
				type : "POST",
				dataType:"json",
				url : CONTEXTPATH + "/home/myCountInfo.do",
				data : {},
				success : function(data) {
					$("#atten_num").html(data.attentionNum);
					$("#fans_num").html(data.fansNum);
					$("#lwBlog_num").html(data.lwBlogNum);
					Util.mask.clear();
				},error : function() {  
					Util.Tip.warning('获取数据失败！');
					Util.mask.clear();
			    }
			});
			
			//删除、收藏操作
			function deleteCollection() {
				$('.delete_collection a').each(function(e) {
					var $that = this;
					$($that).click(function() {
						//邻文ID
						var lwBlogId = $($that).attr('lwBlog-id');
						if($($that).html() == "删除") {
							$.dialog.confirm('确定要删除这条邻文吗？', function () {
							    $.ajax({
									type : "POST",
									dataType:"json",
									url : CONTEXTPATH + "/lwBlog/deleteLwBlog.do",
									data : {lwBlogId:lwBlogId},
									success : function(data) {
										if(data.data == 'SUCCESS') {
											Util.Tip.success('删除成功！');
											window.open(CONTEXTPATH+"/home/home.do", "_self");
										}
									},error : function() {  
										Util.Tip.warning('获取数据失败！');
										Util.mask.clear();
								    }
								});
							}, function () {
							});
						}else if($($that).html() == "收藏"){
							$.ajax({
								type : "POST",
								dataType:"json",
								url : CONTEXTPATH + "/lwOperate/collectionLw.do",
								data : {lwBlogId:lwBlogId},
								success : function(data) {
									if(data.data == 'SUCCESS') {
										Util.Tip.success('收藏成功！');
										$($that).html("取消收藏")
									}
								},error : function() {  
									Util.Tip.warning('获取数据失败！');
									Util.mask.clear();
							    }
							});
						}else if($($that).html() == "取消收藏") {
							$.ajax({
								type : "POST",
								dataType:"json",
								url : CONTEXTPATH + "/lwOperate/cancelCollection.do",
								data : {lwBlogId:lwBlogId},
								success : function(data) {
									if(data.data == 'SUCCESS') {
										Util.Tip.success('已取消收藏！');
										$($that).html("收藏")
									}
								},error : function() {  
									Util.Tip.warning('获取数据失败！');
									Util.mask.clear();
							    }
							});
						}
					});
				});
			}
			
			//点赞操作
			function lwLike() {
				$('.lw_like a').each(function(e) {
					var $that = this;
					$($that).click(function() {
						//邻文ID
						var lwBlogId = $($that).attr('lwBlog-id');
						if($($that).find("em").html() == "赞") {
							$.ajax({
								type : "POST",
								dataType:"json",
								url : CONTEXTPATH + "/lwOperate/LwLike.do",
								data : {lwBlogId:lwBlogId},
								success : function(data) {
									if(data.data == 'SUCCESS') {
										var likeNum = parseInt($($that).find("span").html()) + 1;
										$($that).find("em").html("已赞");
										$($that).find("span").html(likeNum);
										$($that).css('color','#EE8E6F');
									}
								},error : function() {  
									Util.Tip.warning('获取数据失败！');
									Util.mask.clear();
							    }
							});
						}else if($($that).find("em").html() == "已赞"){
							$.ajax({
								type : "POST",
								dataType:"json",
								url : CONTEXTPATH + "/lwOperate/cancelLike.do",
								data : {lwBlogId:lwBlogId},
								success : function(data) {
									if(data.data == 'SUCCESS') {
										var likeNum = parseInt($($that).find("span").html()) - 1;
										$($that).find("em").html("赞");
										$($that).find("span").html(likeNum);
										$($that).css('color','#9F8FB3');
									}
								},error : function() {  
									Util.Tip.warning('获取数据失败！');
									Util.mask.clear();
							    }
							});
						}
					});
				});
			}
			
			//评论
			function lwComments() {
				$(".lw_comments a").each(function(e) {
					var $that = this;
					$($that).click(function() {
						//邻文ID
						var lwBlogId = $($that).attr('lwBlog-id');
						alert(lwBlogId);
						
						/*if($($that).find("em").html() == "赞") {
							$.ajax({
								type : "POST",
								dataType:"json",
								url : CONTEXTPATH + "/lwOperate/LwLike.do",
								data : {lwBlogId:lwBlogId},
								success : function(data) {
									if(data.data == 'SUCCESS') {
										var likeNum = parseInt($($that).find("span").html()) + 1;
										$($that).find("em").html("已赞");
										$($that).find("span").html(likeNum);
										$($that).css('color','#EE8E6F');
									}
								},error : function() {  
									Util.Tip.warning('获取数据失败！');
									Util.mask.clear();
							    }
							});
						}else if($($that).find("em").html() == "已赞"){
							$.ajax({
								type : "POST",
								dataType:"json",
								url : CONTEXTPATH + "/lwOperate/cancelLike.do",
								data : {lwBlogId:lwBlogId},
								success : function(data) {
									if(data.data == 'SUCCESS') {
										var likeNum = parseInt($($that).find("span").html()) - 1;
										$($that).find("em").html("赞");
										$($that).find("span").html(likeNum);
										$($that).css('color','#9F8FB3');
									}
								},error : function() {  
									Util.Tip.warning('获取数据失败！');
									Util.mask.clear();
							    }
							});
						}*/
					});
				});
			}
			
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
			
		};
		
		return {
			HomeIndexLoad : HomeIndexLoad
		};
	})();
	
	Home._init();
})();