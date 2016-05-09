(function($){

	$.fn.silder = function(opts){

		//初始化配置参数
		opts = jQuery.extend({
			itemW : 92,
			itemH : 80,
			data : [], 
			itemClick : function(){},
			callback:function(){return false;}
		},opts||{});
		var $html = '<div class="silder-wrap">'+
			'<a href="javascript:;" class="silder-btn pre silder-btn-dis-p"></a>'+
			'<a href="javascript:;" class="silder-btn next"></a>'+
				'<div class="silder-inner"><!-- 每个面板的内容 --><!-- <div class="silder-item"></div> --></div>'+
			'</div>'+
			'<div class="silder-option"><!--<a class="current" href="javascript:;"></a> --></div>',
			$that = $(this);
			$that.html($html);
		var	data = opts.data,
			$innerWarp = $that.find('.silder-wrap'),
			$sildeBtn = $innerWarp.find('.silder-btn'),
			$inner = $that.find('.silder-inner'),
			$opt = $that.find('.silder-option'),
			panelType = opts.panelType;
		
		
		//不同的初始化
		if( panelType == 'bmfw'){
			opts.itemW = 230;
			opts.itemH = 30;
		}
		init();
		function init(){
			var _itemWidth= opts.itemW,
			_itemHeight = opts.itemH,
			_contentWidth=$inner.width(),//容器宽度
			_contentHeight = $inner.height(),//容器高度
			_itemShowNum=Math.floor(_contentWidth/_itemWidth),//每行显示个数
			_optionHeight = $opt.height(),
			_realRow = Math.floor(_contentHeight/_itemHeight),
			_realItemNum = _realRow*_itemShowNum || 1,
			_panelNum = Math.ceil(data.length/(_realItemNum));
			
			//根据数据计算需要多少个面板    content的框度/每个item的宽度 --除掉添加按钮
			var itemHtml='',dotHtml='';
			for(var i=0;i<_panelNum;i++){
				var _html='';
				for (var j=0;j<_realItemNum;j++) {
					var _obj=data[i*_realItemNum+j];
					if(_obj==undefined){
						continue ;
					}
					if(panelType == 'bmfw'){
						_html += '<a href="#sub_tab" class="entrance-item no-image" data-type="' +_obj.lxjp+ '-' +_obj.dm+ '"><p>'+ _obj.mc +'</p></a>';
					}else{
						_html += '<a href="#sub_tab" class="entrance-item" data-type="' +_obj.lxjp+ '-' +_obj.dm+ '">'+
						'<img src="'+CONTEXTPATH+'/resources/images/apps/'+_obj.lxjp+ '-' +_obj.dm+'.png" alt="'+_obj.mc +'" onError="this.onerror=null;this.src=\''+CONTEXTPATH+'/resources/images/apps/defalult.png\'"><p class="ell" title="'+ _obj.mc +'">'+ _obj.mc +'</p></a>';
					}
				}
				itemHtml+="<div class='silder-item' style='display:none;'>"+_html+"</div>";
				//点
				dotHtml+="<a href='javascript:void(null);' onFocus='this.blur();'></a>";
			}
			
			if(data.length == 0){
				itemHtml = '<p class="no-data">暂无数据可供展示</p>';
			}
			$inner.html(itemHtml).height( _realRow*_itemHeight + 10);
			$opt.html(dotHtml);
			addEvt();
		}

		function addEvt(){
			//翻页效果
			var silderAll=$inner.find('.silder-item'),
				silderBtnAll=$opt.find('a');

			silderBtnAll.click(function(){
				var _$that=$(this),_index=_$that.index();
				whichItemShow(_index);
			});

			//前后翻页
			$sildeBtn.click(function(){
				var _$that=$(this),
				_silderLen=$inner.find('.silder-item').length,
				_currentSilder=$inner.find('.silder-item').index($inner.find('.silder-item:visible')),
				_index=0;
				
				if(_$that.hasClass('silder-btn-dis')){
					return ;
				}

				if(_$that.hasClass('pre')){
					_currentSilder-=1;
				}else{
					_currentSilder+=1;
				}
				_index=(_currentSilder+_silderLen)%_silderLen;

				whichItemShow(_index);
			}).eq(1).click();
			
			//当个点击项
			$that.find('.entrance-item').click(function(){
				opts.itemClick.call(this);
			});
		}

		function whichItemShow(index){
			var silderAll=$inner.find('.silder-item'),
				silderBtnAll=$opt.find('a'),
				allLen = silderAll.length;
			
			if( allLen <= 1 ){
				$sildeBtn.hide();
			} else {
				$sildeBtn.show();
			}
		
			if( index == 0 ){
				$sildeBtn.first().addClass('silder-btn-dis-p silder-btn-dis');
			}else{
				$sildeBtn.first().removeClass('silder-btn-dis-p silder-btn-dis');
			}
			
			if( index == (allLen-1)){
				$sildeBtn.last().addClass('silder-btn-dis-n silder-btn-dis');
			}else{
				$sildeBtn.last().removeClass('silder-btn-dis-n silder-btn-dis');
			}
			
			silderAll.eq(index).show().siblings().hide();
			silderBtnAll.eq(index).addClass('current').siblings().removeClass('current');
		}
	}
})(jQuery);