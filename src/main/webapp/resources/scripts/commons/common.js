$(".logout").click(function() {
	$.ajax({
		type : "POST",
		dataType:"json",
		url : CONTEXTPATH + "/user/loginout.do",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		success : function(data) {
			Util.mask.set();
			var d=convert(data);
			if(d.data == "SUCCESS"){
				$('body').mask().clearMask();
				window.open(CONTEXTPATH+"/index.do", "_self");
			}else {
				$('body').mask().clearMask();
				Util.Tip.warning('退出失败，请重新尝试！');
			}
		},
		error : function() {  
			$('body').mask().clearMask();
			window.Util.warn('数据加载失败！');
	    }  
	});
});