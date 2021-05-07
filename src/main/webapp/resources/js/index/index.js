;(function($,window) {

	homePage = {

		init:function(){


			var bannerContainer = $('.js-banner-container'),
    			len = bannerContainer.find('.swiper-slide').length;

			if(len>1){
				var bannerSwiper = new Swiper('.js-banner-container', {
				    pagination: '.js-banner-pagination',
				    paginationClickable: true,
				    centeredSlides: true,
				 	onSlideChangeEnd: function(){
					}
				});
				bannerContainer.find('img').css('width',bannerSwiper.width);
			}else{
				$('.js-banner-pagination').hide();
			}

			var memberSwiper = new Swiper('.js-member-container', {
				nextButton: '.js-member-button-next',
				prevButton: '.js-member-button-prev',
				//loop:true,
				slidesPerView: 2,
				slidesPerGroup:2
			});

		}

	};

	homePage.init();

})(Zepto,window);