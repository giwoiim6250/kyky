;(function($,window) {

	var submitBtn = $('#js_submit');
	var formEle = $('#js_form'),
		nameEle = $('#js_name'), //姓名
		cityEle = $('#js_city'), //城市
		addressEle = $('#js_address'), //详细地址
		birthdayEle = $('#js_birthday'), //生日
		telEle = $('#js_tel'),	//电话
		transitnumEle = $('#js_transitnum'), //全顺数量
		mileageEle = $('#js_mileage'),	//里程
		puydateEle = $('#js_puydate'),	//购买日期
		s4Ele = $('#js_4S'),			//4s店
		salesnameEle = $('#js_salesname'),	//业务员姓名
		salestelEle = $('#js_salestel');	//业务员电话

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
				$(this).parents('tr').find('.tip-error').removeClass('show');
			});

			formEle.find('select').on('focus',function(){
				$(this).parents('tr').find('.tip-error').removeClass('show');
			});

			formEle.find('input').on('blur',function(){
				_self.checkForm();
			});

			formEle.find('select').on('blur',function(){
				_self.checkForm();
			});

			submitBtn.on('click',function(){
				var sexVal = $("input[name='sex']:checked").val();	//性别值
				var carmodelVal = $("input[name='carmodels']:checked").val(); //车型值

				//验证表单
				var submitType = _self.checkForm();

				//提交表单
				if(submitType){
					formEle.submit();
				}

			});

			$("#js_select_address").citySelect({
				'url':"/resources/js/form/city.js",
				nodata:"none",required:false
			});

			$("#js_select_store").citySelect({
				'url':"/resources/js/form/store.js",
				nodata:"none",required:false
			});

		},
		checkForm:function(){
			var _self = this;

			var submitType = true;
			$('.tip-error').removeClass('show');

			//姓名
			if(!$.trim(nameEle.val()) || (!_self.isCName($.trim(nameEle.val())) && !_self.isEName($.trim(nameEle.val())))){
				nameEle.parents('tr').find('.tip-error').addClass('show');
				submitType = false;
			}

			//地址
			//if($.trim(cityEle.val()) == 0 || !$.trim(addressEle.val())){
			if($.trim(cityEle.val()) == 0){
				cityEle.parents('tr').find('.tip-error').addClass('show');
				submitType = false;
			}

			//电话
			if(!$.trim(telEle.val()) || (!_self.isTel($.trim(telEle.val())) && !_self.isMobile($.trim(telEle.val())))){
				telEle.parents('tr').find('.tip-error').addClass('show');
				submitType = false;
			}

			//全顺数量
			if(!$.trim(transitnumEle.val()) || transitnumEle.val() < 0){
				transitnumEle.parents('tr').find('.tip-error').addClass('show');
				submitType = false;
			}

			//里程
			if(!$.trim(mileageEle.val()) || mileageEle.val() < 0){
				mileageEle.parents('tr').find('.tip-error').addClass('show');
				submitType = false;
			}

			//经销上验证
			if(checkType == 'dealer'){
				//4s店
				if($.trim(s4Ele.val()) == 0 || !$.trim(s4Ele.val())){
					s4Ele.parents('tr').find('.tip-error').addClass('show');
					submitType = false;
				}

				//业务员姓名
				if(!$.trim(salesnameEle.val()) || (!_self.isCName($.trim(salesnameEle.val())) && !_self.isEName($.trim(salesnameEle.val())))){
					salesnameEle.parents('tr').find('.tip-error').addClass('show');
					submitType = false;
				}

				//业务员电话
				if(!$.trim(salestelEle.val()) || (!_self.isTel($.trim(salestelEle.val())) && !_self.isMobile($.trim(salestelEle.val())))){
					salestelEle.parents('tr').find('.tip-error').addClass('show');
					submitType = false;
				}
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
		}

	};

	formPage.init();

})($,window);