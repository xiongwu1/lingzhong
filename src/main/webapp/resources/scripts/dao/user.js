(function(_) {
	var _Dao = _.Dao || {};
	
	_Dao.User = { 
		sendMail: function (email) {
			return Util.Ajax.post('/register/dynamicpassword.do',{email:email},'text');
		},
		clearDyode: function () {
			return Util.Ajax.post('/sendMail/cleardynamicpassword.do');
		},
		forgotSendMail: function (email) {
			return Util.Ajax.post('/forgot/dynamicpassword.do',{email:email},'text');
		},
	};
	_.Dao = _Dao;
})(window || {});