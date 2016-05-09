<div class="friends_blog">
		<form method="post" id="publishForm">
			<div class="send_weibo">
				<p><a class="tip_num"></a></p>
				<textarea name="content" class="emotion" rows="5" cols="58"></textarea>
				<input name="imgIdStr" type="hidden" />
				<div class="kind">
					<a href="javascript:void(0);" id="face">
						<span class="expression"></span><span class="expression_txt">表情</span>
					</a>
					<a href="javascript:void(0);" class="upload_img">
						<span class="upload_ico"></span><span class="upload_txt">图片</span>
					</a>
					<div class="upload_div">
						 <div id="zyupload" class="zyupload"></div>  
						<a href="javascript:void(0);" class="uploadDiv_close"><span></span></a>
					</div>
				</div>
				<div class="release">
					<input class="release_btn" type="submit" value="发布">
				</div>
				<!-- <input id="face" type="button" value="表情" /> -->
			</div>
		</form>
		<input id="currentUserId" type="hidden" value="${CURRENT_USER.objectid }">
		<div class="left_blog_list">
		<%-- <div class="blog_list">
			<div class="blog_content">
				<div class="head_info">
					<div class="head_left">
						<figure>
						<div>
							<img src="${ctx}/resources/images/default_icon.png" />
						</div>
						</figure>
					</div>
					<div class="head_right">
						<p class="webList_name">
							<b>易先生3729</b>
						</p>
						<p class="web_time">12月2日 09:01 来自 微博 weibo.com</p>
					</div>
					<div class="edit_lwBlog"><a href="javascript:void(0);"><span></span></a></div>
					<div class="editLw_div">
						<ul>
							<li><a href="javascript:void(0)">取消关注</a></li>
							<li><a href="javascript:void(0)">删除</a></li>
						</ul>
					</div>
				</div>
				<div class="web_info">关于“高晓松、梁宏达、崔永元”等名嘴谁的实力更强？</div>
				<div class="img_info">
					<img alt="微博" src="${ctx}/resources/images/index/weibo_img1.jpg">
					<img alt="微博" src="${ctx}/resources/images/index/weibo_img2.jpg">
					<img alt="微博" src="${ctx}/resources/images/index/weibo_img3.jpg">
					<img alt="微博" src="${ctx}/resources/images/index/weibo_img4.jpg">
				</div>
			</div>
			<div class='blog_operate'>
				<ul>
					<li><a href="javascript:void(0);">转发</a></li>
					<li><a href="javascript:void(0);">评论</a></li>
					<li><a href="javascript:void(0);">赞</a></li>
					<li><a href="javascript:void(0);">收藏</a></li>
				</ul>
			</div>
		</div> --%>
		</div>
		<div id="page" style="width:610px;margin:0 auto;"><div id="kkpager"></div></div>
	</div>
	<div class="person_info">
		<div class="head_img">
			<figure>
			<div>
				<c:choose> 
				<c:when test="${CURRENT_USER.headPortrait != null}">
					<a href="${ctx }/home/personalCenter.do"><img src="http://192.168.3.205:8888/${CURRENT_USER.headPortrait }" /></a>
				</c:when>
				<c:otherwise>
					<a href="${ctx }/home/personalCenter.do"><img src="${ctx }/resources/images/default_icon.png" /></a>
				</c:otherwise>
				</c:choose>
			</div>
		</figure>
		</div>
		<div class="web_name">${CURRENT_USER.nickName}</div>
		<div class="user_atten">
			<ul>
				<li><a href="javascript:void(0);"><strong id="atten_num"></strong><span class="atten_txt">关注</span></a></li>
				<li><a href="javascript:void(0);"><strong id="fans_num"></strong><span class="atten_txt">粉丝</span></a></li>
				<li><a href="javascript:void(0);"><strong id="lwBlog_num"></strong><span class="atten_txt">邻文</span></a></li>
			</ul>
		</div>
	</div>