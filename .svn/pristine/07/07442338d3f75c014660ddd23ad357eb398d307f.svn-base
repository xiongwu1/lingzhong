(function(_) {
	var _Dao = _.Dao || {};
	
	_Dao.Index = { 
		hotLwBlog: function () {
			return Util.Ajax.post('/NewTenLwList.do');
		},
		hotUser: function () {
			return Util.Ajax.post('/MostActiveTenUser.do');
		},
		payAttention: function (attentUserId) {
			return Util.Ajax.post('/payAttention.do',{attentUserId:attentUserId},'text');
		},
		cancelAttention: function (attentUserId) {
			return Util.Ajax.post('/cancelAttention.do',{attentUserId:attentUserId},'text');
		}
	};
	_.Dao = _Dao;
})(window || {});