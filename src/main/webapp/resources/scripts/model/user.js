(function(_) {
	
	var _Model = _.Model || {}
	
	_Model.User = {
		loginName : {
			require: true
		},	
		password : {
        	require: true
        },
        nickName : {
        	require: true
        },
        realName : {
        	require: true
        },
        szdProvince : {
        	require: true
        },
        szdCity : {
        	require: true
        },
        gender : {
        	require: true
        },
        email : {
        	require: true
        },
        mobilePhone : {
        	require: true
        },
        qq : {
        	require: true
        }
	};
	_.Model = _Model;
	
})(window || {});