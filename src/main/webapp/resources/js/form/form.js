;(function($,window) {

	var submitBtn = $('#js_submit');
	var formEle = $('#js_form'),
		nameEle = $('#js_name'), //姓名
		cityEle = $('#js_city'), //城市
		salesnameEle = $('#js_salesname'),	//业务员姓名
		salestelEle = $('#js_salestel'),	//业务员电话
		carnameEle = $('#js_carname'),	//推荐车主姓名
		cartelEle = $('#js_cartel'),	//推荐车主电话
		caridEle = $('#js_carid'),	//车辆代码
		puydateEle = $('#js_puydate'); // 车辆购买时间

	puydateEle.val(getNowFormatDate());

	/*获取当前日期*/
	function getNowFormatDate() {
	        var date = new Date();
	        var seperator1 = "-";
	        var year = date.getFullYear();
	        var month = date.getMonth() + 1;
	        var strDate = date.getDate();
	        if (month >= 1 && month <= 9) {
	            month = "0" + month;
	        }
	        if (strDate >= 0 && strDate <= 9) {
	            strDate = "0" + strDate;
	        }
	        var currentdate = year + seperator1 + month + seperator1 + strDate;
	        return currentdate;
	    }

	var formPage = {

		init:function(){


			var _self = this;

			formEle.find('input').on('focus',function(){
				$(this).parents('td').removeClass('edit-error');
			});

			formEle.find('select').on('focus',function(){
				$(this).parents('td').removeClass('edit-error');
			});

			formEle.find('input').on('blur',function(){
				_self.checkForm();
			});

			formEle.find('select').on('blur',function(){
				_self.checkForm();
			});

			submitBtn.on('click',function(){
				//验证表单
				var submitType = _self.checkForm();

				//提交表单
				if(submitType){
					formEle.submit();
				}

			});
			// var jsBase = "/resources/";
			var jsBase = "/";
			$("#js_select_address").citySelect({
				'url': jsBase + "js/form/city.js",
				nodata:"none",required:false
			});

			$("#js_select_store").citySelect({
				'url': jsBase + "js/form/store.js",
				nodata:"none",required:false
			});

		},
		checkForm:function(){
			var _self = this;

			var submitType = true;
			$('.edit-cont').removeClass('edit-error');

			//姓名
			if(!$.trim(nameEle.val()) || (!_self.isCName($.trim(nameEle.val())) && !_self.isEName($.trim(nameEle.val())))){
				nameEle.parents('td').addClass('edit-error');
				submitType = false;
			}

			//地址
			//if($.trim(cityEle.val()) == 0 || !$.trim(addressEle.val())){
			if($.trim(cityEle.val()) == 0){
				cityEle.parents('td').addClass('edit-error');
				submitType = false;
			}

			//经销上验证
			if(checkType == 'dealer'){

				//业务员姓名
				if(!$.trim(salesnameEle.val()) || (!_self.isCName($.trim(salesnameEle.val())) && !_self.isEName($.trim(salesnameEle.val())))){
					salesnameEle.parents('td').addClass('edit-error');
					submitType = false;
				}

				//业务员电话
				if(!$.trim(salestelEle.val()) || (!_self.isTel($.trim(salestelEle.val())) && !_self.isMobile($.trim(salestelEle.val())))){
					salestelEle.parents('td').addClass('edit-error');
					submitType = false;
				}

			}

			//推荐车主姓名
			if(!$.trim(carnameEle.val()) || (!_self.isCName($.trim(carnameEle.val())) && !_self.isEName($.trim(carnameEle.val())))){
				carnameEle.parents('td').addClass('edit-error');
				submitType = false;
			}

			//推荐车主电话
			if(!$.trim(cartelEle.val()) || (!_self.isTel($.trim(cartelEle.val())) && !_self.isMobile($.trim(cartelEle.val())))){
				cartelEle.parents('td').addClass('edit-error');
				submitType = false;
			}

			//推荐的车主车辆代码
			if(!$.trim(caridEle.val()) || (!_self.isVincode($.trim(caridEle.val())) )){
				caridEle.parents('td').addClass('edit-error');
				submitType = false;
			}

			return submitType;

		},
		isMobile: function(str) {
			return (new RegExp(/^1\d{10}$/).test($.trim(str)));
		},
		isEmail: function(str) {
			return (new RegExp(/^([_a-zA-Z\d\-\.])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/).test($.trim(str)));
		},
		isTel: function(str) {
			return (new RegExp(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/).test($.trim(str)));
		},
		isCName: function(str) {
			return (new RegExp(/^[\u4e00-\u9fa5]+$/).test($.trim(str)));
		},
		isEName: function(str) {
			return (new RegExp(/^[a-zA-Z]+$/).test($.trim(str)));
		},
		isVincode: function(str) {
			return (new RegExp(/^[a-zA-Z]{8}(\d|[a-zA-Z]){9}$/).test($.trim(str)));
		}
	};

	formPage.init();

})($,window);