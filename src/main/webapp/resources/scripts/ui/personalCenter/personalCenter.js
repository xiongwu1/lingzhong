(function() {
	
	var PersonalCenter = {
			_init : function() {
				window.PersonalCenter= PersonalCenter;
			},
			PersonalCenterIndex : {}
		};
	
	//初始化
	PersonalCenter.Base = {
		Dict : {
			XB : (function() {
				return new Util.Dict();
			})()
		}
	};
	
	PersonalCenter.PersonalCenterIndex = (function() {
		
		//页面加载
		function PersonalCenterLoad() {

			//渲染页面
			$('body').mask().setMask();
			$.when(Dao.Dictionary.getDict('XB')).done(function(xb){
				PersonalCenter.Base.Dict.XB.Set(xb);
			}).then(function(){
				$('body').mask().clearMask();
				PersonalCenterRender();
			}).fail(function(){
				$('body').mask().clearMask();
				window.parent.Util.warn('数据获取失败！');
			});
		};
		
		//渲染列表页面
		function PersonalCenterRender(){
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
			//获取当前用户信息
			$.ajax({
				type : "POST",
				dataType:"json",
				url : CONTEXTPATH + "/user/getUserPerson.do",
				data : {},
				success : function(data) {
					if(data.headPortrait != "") {
						$('.head_photos').html('<img src="http://192.168.1.110:8888/'+ data.headPortrait +'" />');
					}else {
						$('.head_photos').html('<img src="'+ CONTEXTPATH +'/resources/images/default_icon.png" />');
					}
					$('.pf_username span').html(data.nickName);
					$('.pf_gxqm span').html(data.gxqm);
					$('#loginName').html(data.loginName);
					$('#nickName').html(data.nickName);
					$('#realName').html(data.realName);
					$('#szd').html(data.szdProvince + data.szdCity);
					if(data.gender == "0") {
						$('#gender').html("男");
					}else {
						$('#gender').html("女");
					}
					$('#gxqm').html(data.gxqm);
					$('#email').html(data.email);
					$('#qq').html(data.qq);
					$('#mobilePhone').html(data.mobilePhone);
					
					Util.mask.clear();
				},error : function() {  
					Util.Tip.warning('获取数据失败！');
					Util.mask.clear();
			    }
			});
			
			//更换头像
			//弹出一个页面层
			$('.head_photos').on('click', function(){
				
				var upload_head = '<div class="container"><div class="imageBox"><div class="thumbBox"></div>';
				upload_head += '<div class="spinner" style="display: none">Loading...</div></div><div class="action">';		
				upload_head += '<div class="new-contentarea tc"> <a href="javascript:void(0)" class="upload-img"><label for="upload-file">上传图像</label>';
				upload_head += '</a><input type="file" class="" name="upload-file" id="upload-file" /></div>';
				upload_head += '<input type="button" id="btnCrop"  class="Btnsty_peyton" value="裁切">';
				upload_head += '<input type="button" id="btnZoomIn" class="Btnsty_peyton" value="+"  >';
				upload_head += '<input type="button" id="btnZoomOut" class="Btnsty_peyton" value="-" >';
				upload_head += '</div><div class="cropped"></div></div>';
				upload_head += '<div><a href="javacript:void(0);" class="head_sub">确定</a></div>';
				
			    layer.open({
			    	title: ['上传头像', 'font-size:13px;'],
			        type: 1,
			        area: ['750px', '500px'],
			        shadeClose: false, //禁止点击遮罩关闭
			        scrollbar: false,//屏蔽浏览器出现滚动条
			        shift: 3, //0-6的动画形式，-1不开启
			        //content: '\<\div style="padding:20px;">自定义内容\<\/div>'
			        content:   ''+ upload_head +''
			    });
			    
			    var options =
				{
					thumbBox: '.thumbBox',
					spinner: '.spinner',
					imgSrc: CONTEXTPATH + '/resources/images/avatar.png'
				}
				var cropper = $('.imageBox').cropbox(options);
				$('#upload-file').on('change', function(){
					var reader = new FileReader();
					reader.onload = function(e) {
						options.imgSrc = e.target.result;
						cropper = $('.imageBox').cropbox(options);
					}
					reader.readAsDataURL(this.files[0]);
					this.files = [];
				})
				$('#btnCrop').on('click', function(){
					var img = cropper.getDataURL();
					$('.cropped').html('');
					$('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:30px;margin-top:4px;border-radius:30px;box-shadow:0px 0px 12px #7E7E7E;" ><p>30px*30px</p>');
					$('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:50px;margin-top:4px;border-radius:50px;box-shadow:0px 0px 12px #7E7E7E;"><p>50px*px</p>');
					$('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:100px;margin-top:4px;border-radius:100px;box-shadow:0px 0px 12px #7E7E7E;"><p>180px*180px</p>');
				})
				$('#btnZoomIn').on('click', function(){
					cropper.zoomIn();
				})
				$('#btnZoomOut').on('click', function(){
					cropper.zoomOut();
				})
				
				$('.head_sub').click(function() {
					Util.mask.set();
					$.ajax({
						type : "POST",
						dataType:"json",
						url : CONTEXTPATH + "/user/updateHead.do",
						data : {headPhotoUrl:cropper.getDataURL()},
						success : function(data) {
							if(data.data == "SUCCESS") {
								Util.Tip.success('更换头像成功！');
								window.open(CONTEXTPATH+"/home/personalCenter.do", "_self");
							}else {
								Util.Tip.warning('更换头像失败，请检查重试！');
							}
							Util.mask.clear();
						},error : function() {  
							Util.Tip.warning('获取数据失败！');
							Util.mask.clear();
					    }
					});
				});
			});
			
		};
		
		return {
			PersonalCenterLoad : PersonalCenterLoad
		};
	})();
	
	PersonalCenter._init();
})();