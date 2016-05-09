(function (_) { 
	var _Dao = _.Dao || {};

	_Dao.Dictionary = { 
		
		//获取字典项
		getDict: function(lxjp){
			return Util.Ajax.get('/common/commboDict.do', {lxjp: lxjp});
		},
		
		//获取字典项
	    updateDict: function(){
			return Util.Ajax.get('/auth/updateCache.do');
		},
		
		//获取字典项
		getMultiDict: function(lxjps){
			return Util.Ajax.get('/common/getMultiCommboboxDict.do', {lxjps: lxjps});
		},
		
		//获取数据
		getSiteByParentId: function (parentId) {
			return Util.Ajax.post('/site/queryRegionsByPid.do', {parentId:parentId},'json');
		},
		
		//获取字典明细
		editData: function (dm, lxjp) {
			return Util.Ajax.post('/dictionary/detail.do', {dm:dm,lxjp:lxjp},'json');
		},
		
		//获取数据分页信息
		getPage: function (data) {
			return Util.Ajax.post('/dictionary/page.do', data,'json');
		},
		
		//保存字典信息
		saveData: function (data) {
			return Util.Ajax.post('/dictionary/save.do', data,'json');
		},
		
		//删除字典信息
		deleteData: function (dm, lxjp) {
			return Util.Ajax.post('/dictionary/delete.do', {dm:dm,lxjp:lxjp},'json');
		},
		
		//获取办事项
		getMatterList: function (ssptsx) {
			return Util.Ajax.post('/common/getMatterList.do', {ssptsx:ssptsx},'json');
		},
		
		getStatOrg: function () {
			return Util.Ajax.post('/base/loadStatTree.do', 'json');
		},
		
		updateFinancialInfo:function(){
			return Util.Ajax.post('/cacheManager/flushCacheByDate.do');
		}
		
	};
	
	_.Dao = _Dao;
})(window || {});