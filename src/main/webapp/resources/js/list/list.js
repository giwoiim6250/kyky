;(function($,window) {

	var listPage = {

		init:function(){
			
			var searchBtn = $('#js_search_btn'),
				searchInput = $('#js_search');
			
			searchBtn.on('click',function(){
				var key = searchInput.val();
				document.location.href = "/list.htm?content=" + key;
			});
			
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
			        		 _this.find(".js_praise").text(data);
			        	 }
			         },
			         error: function(){
			        }
	      		});
				
			});
			
			//分页
			var options= {
				//loading selector
				loadNode:".load-more",
				//ajax url 例如： a.html?cur={#PAGENUM}
				url: '/list/more.htm?current={#PAGENUM}&content=' + searchContent + "&type="+sortType,
				//总页数
				totalPage: pageCount*1,
				//当前页码
				curPage: 1,
				//滚动到的距离（离底部）
				bottom: 0,
				//回调函数
				beforeSendCallback:function(){
					/*$(".loading").show();
					$(".load-more").hide();*/
				},
				successCallback:function(data){
					/*$(".loading").hide();
					$(".load-more").show();*/
					$("#js_list_cont").append(data);
				}
			};


			ECar.scrollLoad(options);

		}

	};

	listPage.init();

})(Zepto,window);