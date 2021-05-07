 /**
 * dialogConfirm 1.0
 * UI - Popup dialog
 * 
 * Copyright 2016, zhangweiming
 * http://www.surto.cn/
 * 
 * Released on: August 1, 2016
 */

;(function($,ECar){
	
	if(ECar.dialogConfirm){
		return ECar.dialogConfirm;
	}
	
	var confirmFun;

    ECar.dialogConfirm = function(options){
    	
    	var settings = {
			title:null,
			cont:null,
			confirm:null,
			cancel:null,
			successFun:function(){},
			confirmFun:function(){},
			cancelFun:function(){},
			ele:$('#confirmPop'),
			mode:$('#confirmMode'),
			close:$('.confirmClose','#confirmPop'),
			confirmBtn:$('.confirmBtn','#confirmPop'),
			confirmText:'确定',
			cancelBtn:$('.confirmCancel','#confirmPop'),
			cancelText:'取消',
			contEle:$('.confirmCon','#confirmPop'),
			titleEle:$('.confirmTitle','#confirmPop'),
			footEle:$('.confirmFoot','#confirmPop')
		};
		
		config = $.extend({}, settings, options||{});
    	
    	if( confirmFun === undefined ){
    		confirmFun = new confirmPop(config);
    	} else {
    		confirmFun.init(config);
    	}
    	
    }
    
    function confirmPop(options) {
		
		this.cfg = options;
		
	    this.init();
	    
	}
	
    confirmPop.prototype = {
    	
    	constructor	:	confirmPop,
    	
    	init:function(options){
    		var _this = this,eleHtml = '';
    		this.cfg = $.extend({}, _this.cfg, options||{});
    		
    		if(this.cfg.cont == ''){
    			return false;
    		}
    		
    		this.createEle();
    		
    		this.editEle();
    		
    		this.addEvent();
    		
    	},
    	createEle:function(){
    		
    		//生成结构
    		if(this.cfg.ele.length>0){
    			return true;
    		}
    		
    		var _this = this,eleHtml = '';
    		
			eleHtml = '<div id="confirmPop" class="confirmPop"><div class="confirmTitle"></div><div class="confirmCon"></div><div class="confirmFoot"><a href="javascript:void(0)" class="confirmBtn con-buttom round-max">'+this.cfg.confirmText+'</a><a href="javascript:void(0)" class="confirmCancel con-buttom-disabled con-buttom round-max">'+this.cfg.cancelText+'</a></div><i class="confirmClose"></i></div><div class="confirmMode" id="confirmMode"></div>';
			$('body').append(eleHtml);
			
			this.cfg.ele = $('#confirmPop');
			this.cfg.height = $('#confirmPop').height();
			this.cfg.mode = $('#confirmMode');
			this.cfg.close = $('.confirmClose','#confirmPop');
			this.cfg.confirmBtn = $('.confirmBtn','#confirmPop');
			this.cfg.cancelBtn = $('.confirmCancel','#confirmPop');
			this.cfg.contEle = $('.confirmCon','#confirmPop');
			this.cfg.titleEle = $('.confirmTitle','#confirmPop');
			this.cfg.footEle = $('.confirmFoot','#confirmPop');
			
    	},
    	editEle:function(){
    		this.cfg.ele.css({'margin-top':-1*this.cfg.height+'px'});
    		this.cfg.titleEle.css({'display':'none'});
    		this.cfg.contEle.css({'display':'none'});
    		this.cfg.cancelBtn.hide();
    		this.cfg.confirmBtn.hide();
    		
    		if(this.cfg.title != null && this.cfg.title!=''){
    			this.cfg.titleEle.css({'display':'block'});
    			this.cfg.titleEle.html(this.cfg.title);
    		}
    		
    		if(this.cfg.cont != null && this.cfg.cont!=''){
    			this.cfg.contEle.css({'display':'block'});
    			this.cfg.contEle.html(this.cfg.cont);
    		}
    		
    		if((this.cfg.confirm != null && this.cfg.confirm!='') || (this.cfg.cancel != null && this.cfg.cancel!='')){
    			this.cfg.footEle.css({'display':'block'});
    			
    			if(this.cfg.cancel != null && this.cfg.cancel != ''){
    				this.cfg.cancelBtn.show();
    			}
    			
    			if(this.cfg.confirm != null && this.cfg.confirm != ''){
    				this.cfg.confirmBtn.show();
    			}
    			
    		}
    		
    		this.cfg.ele.css({'display':'block'});
    		this.cfg.mode.css({'display':'block'});
    	},
    	closePop:function(){
    		this.cfg.ele.css({'display':'none'});
    		this.cfg.mode.css({'display':'none'});
    	},
    	addEvent:function(){
    		var _this = this;
			this.cfg.confirmBtn.off("click");
    		this.cfg.cancelBtn.off("click");
    		this.cfg.mode.off("click");
    		this.cfg.close.off("click");
    		
    		this.cfg.successFun.apply(_this,[_this.cfg.ele]);
    		
			this.cfg.confirmBtn.on("click",function(){
    			_this.cfg.confirmFun.apply(_this,[_this.cfg.ele]);
    		});
    		
    		this.cfg.cancelBtn.on("click",function(){
    			_this.cfg.cancelFun.apply(_this,[_this.cfg.ele]);
    			_this.closePop();
    		});
    		
    		this.cfg.mode.on("click",function(){
    			_this.cfg.cancelFun.apply(_this,[_this.cfg.ele]);
    			_this.closePop();
    		});
    		
    		this.cfg.close.on("click",function(){
    			_this.cfg.cancelFun.apply(_this,[_this.cfg.ele]);
    			_this.closePop();
    		});
    		
    	}
    };
    
	
	return ECar.dialogConfirm;
	
})($,window.ECar||(window.ECar={}));