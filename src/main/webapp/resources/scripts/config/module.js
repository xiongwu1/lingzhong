(function(_) {
	var _Module = _.Module || {};

	// 字典
	_Module.Dictionary = (function() {
		var mod = 'dictionary';
		return {
			name : '获取字典项',
			dao : getDao(mod)
		};
	})();
	
	// 首页
	_Module.index = (function() {
		var mod = 'index';
		return {
			name : '首页',
			src : getSrc('index/' + mod),
			dao : getDao(mod),
			model : getModel(mod),
			dependency : [ _Module.Dictionary ]
		};
	})();

	// 注册用户
	_Module.user = (function() {
		var mod = 'user';
		return {
			name : '用户',
			src : getSrc('user/' + mod),
			dao : getDao(mod),
			model : getModel(mod),
			dependency : [ _Module.Dictionary ]
		};
	})();

	// 登陆后主页
	_Module.home = (function() {
		var mod = 'home';
		return {
			name : '登陆后主页',
			src : getSrc('home/' + mod),
			dao : getDao(mod),
			model : getModel(mod),
			dependency : [ _Module.Dictionary ]
		};
	})();
	
	//个人中心
	_Module.personalCenter = (function() {
		var mod = 'personalCenter';
		return {
			name : '个人中心',
			src : getSrc('personalCenter/' + mod),
			dao : getDao(mod),
			model : getModel(mod),
			dependency : [ _Module.Dictionary ]
		};
	})();

	/*---------------------------------------------------------------------------
	 * 定义js获取路径
	 *---------------------------------------------------------------------------*/
	function getDao(m) {
		return CONTEXTPATH + '/resources/scripts/dao/' + m + '.js';
	}
	
	function getModel(m) {
		return CONTEXTPATH + '/resources/scripts/model/' + m + '.js';
	}

	function getSrc(m) {
		return CONTEXTPATH + '/resources/scripts/ui/' + m + '.js';
	}

	_.Module = _Module;
})(window);