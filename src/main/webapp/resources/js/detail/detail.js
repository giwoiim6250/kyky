;(function($,window) {

	//点赞
	$('.js_praise_btn').on('click',function(){
		var _this = $(this);
		var infoId = _this.attr('info_id');
		$.ajax({
	         type: "POST",
	         url: '/praise.htm',
	         data:{
	        	id:infoId
	         },
	         dataType: "JSON",
	         success: function(data){
				 if(data === "-1" || data == -1){
					ECar.dialogPrompt({text:'您一天只能点一次赞哦！<br/>请24小时之后再来',clickClose:true});
				 }else{
					 $("#js_praise").text(data);
				 }
			 },
	         error: function(){
	        }
  		});
		
	});

	var showBig = $('#js_showBig');
	$('#js_bigEvent').on('click',function(){
		showBig.show();
	});
	showBig.on('click',function(){
		showBig.hide();
	});
	
	//分享
	var weChat = /MicroMessenger/i.test(navigator.userAgent.toLowerCase());
	if(weChat){
		
		var guideNode = $(".weixin-guide");
        $('.btn-share').on("click", function(){
        	guideNode.show();
        });
        guideNode.on("click", function(){
        	guideNode.hide();
        })
	}
		
})(Zepto,window);