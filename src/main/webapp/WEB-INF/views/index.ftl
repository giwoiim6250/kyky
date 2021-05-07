<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="format-detection" content="telephone=no"/>
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no" />
<meta name="apple-touch-fullscreen" content="yes" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<title>福特全顺伟大的平凡车主故事感动征集</title>
<script src="/resources/js/public/mobile-base.js"></script>
<link href="/resources/css/lib/mobile-reset.css" rel="stylesheet" type="text/css"/>
<link href="/resources/css/components/common.css" rel="stylesheet" type="text/css"/>
<link href="/resources/css/lib/idangerous.swiper.css" rel="stylesheet" type="text/css"/>
<link href="/resources/css/lib/animate.min.css" rel="stylesheet" type="text/css"/>
<link href="/resources/css/pages/index.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<img src="/resources/images/public/share-img.jpg" width="0" height="0" style="position:absolute;"/>
	<div class="mp3-node" id="js_mp3">
		<img src="/resources/images/public/mp3.png" width="100%" alt="" id="js_mp3_img"/>
		<audio loop="" autoplay="" id="js_mp3_audio"><source src="/resources/mp3/Adagio-Soundtrack.mp3"></audio>
	</div>
	<div class="swiper-container">
		<div class="swiper-wrapper">
			<article class="swiper-slide wrapper1">
				<header class="logo"></header>
				<section class="text-title">
					<img class="rollIn animated" src="/resources/images/index/first-text-line-01.png">
					<img class="zoomIn animated" src="/resources/images/index/first-text-line-02.png">
					<img class="animated swing" src="/resources/images/index/first-text-line-03.png">
					<img class="fadeInDown animated" src="/resources/images/index/bg-line-01.png">
				</section>
			</article>
			<article class="swiper-slide wrapper2">
				<section class="text-title">
					<img class="" src="/resources/images/index/second-text-line-01.png">
					<img class="" src="/resources/images/index/second-text-line-02.png">
					<img class="" src="/resources/images/index/second-text-line-03.png">
					<img class="" src="/resources/images/index/second-text-line-04.png">
					<img class="" src="/resources/images/index/second-text-line-05.png">
					<img class="" src="/resources/images/index/bg-line-02.png">
				</section>
			</article>
			<article class="swiper-slide wrapper3">
				<section class="text-title">
					<img class="" src="/resources/images/index/third-text-line-01.png">
					<img class="" src="/resources/images/index/third-text-line-02.png">
					<img class="" src="/resources/images/index/third-text-line-03.png">
					<img class="" src="/resources/images/index/bg-line-03.png">
				</section>
			</article>
			<article class="swiper-slide wrapper4">
				<section class="text-title">
					<img class="" src="/resources/images/index/four-text-line-01.png">
					<img class="" src="/resources/images/index/four-text-line-02.png">
					<img class="" src="/resources/images/index/four-text-line-03.png">
					<img class="" src="/resources/images/index/bg-line-04.png">
				</section>
			</article>
			<article class="swiper-slide wrapper5">
				<header class="logo"></header>
				<section class="text-title">
                    <!--<img class="" src="/resources/images/index/gift-cd.png">
					<img class="" src="/resources/images/index/gift-txt1.png">
					<img class="" src="/resources/images/index/gift-txt2.png">
					<img class="" src="/resources/images/index/gift.png">
					<img class="" src="/resources/images/index/gift-line.png">-->
					<img class="" src="/resources/images/index/gift1-img2.png?22">
					<img class="" src="/resources/images/index/gift1-img1.png">

				</section>
			</article>
			<article class="swiper-slide wrapper6">
				<header class="logo"></header>
				<section class="text-title">
					<img class="" src="/resources/images/index/five-text-line-01.png">
					<img class="" src="/resources/images/index/five-text-line-02.png?22">
					<img class="" src="/resources/images/index/bg-line-05.png">
				</section>
				<ul class="menu-list">
					<li><a href="/rule.htm?infoType=2" id="js_go">我要参加</a></li>
					<!--<li><a href="/rule.htm?infoType=1">经销商参加</a></li>-->
					<li><a href="/list.htm">查看点赞</a></li>
					<li><a href="/votes.htm">获奖榜</a></li>
				</ul>
			</article>
		</div>
	</div>
	<img class="arrow fadeInDown animated infinite" src="/resources/images/index/arrow-down.png">

<script src="/resources/js/public/zepto.min.js"></script>
<script src="/resources/js/public/idangerous.swiper.min.js"></script>
<script src="/resources/js/public/common.js"></script>
<script type="text/javascript">

	var hrefUrl = decodeURIComponent(window.location.href),
	 	testReg = /(step=)\d+/,
                        goReg = /transit\.jinznet\.com\/dealer/,
                        stepText = 0;

	var stepHave = testReg.test(hrefUrl),
                  goHave = goReg.test(hrefUrl);

	if(stepHave){
		stepText = (hrefUrl.match(testReg))[0].replace('step=','')*1;
	}

    if(goHave){
            $('#js_go').attr('href','/rule.htm?infoType=1');
            setCookie('pagetype','dealer');
    } else {
            $('#js_go').attr('href','/rule.htm?infoType=2');
            setCookie('pagetype','owner');
    }

    var timer;
	var mySwiper = new Swiper('.swiper-container',{
	mode: 'vertical',
	loop: false,
	initialSlide : stepText ,
	onInit: function(){
		if(stepText = 5){
			var arrImg = $(".wrapper"+(stepText+1)).find('img').not('.arrow');
			$('.arrow').hide();
	       	arrImg.eq(0).addClass('animated fadeInDown');
	       	arrImg.eq(2).addClass('animated fadeInUp');
	       	setTimeout(function(){
	           arrImg.eq(1).addClass('animated swing');
	       	}, 600)
		}
	},
	onTouchMove: function(swiper){
			$('.arrow').hide();
		 },
	onTouchEnd: function(swiper){
		$('.arrow').show().attr({'src':'/resources/images/index/arrow-down.png','class':'arrow fadeInDown animated infinite'})
		var slideIndex = swiper.activeLoopIndex+1;
	             var arrImg = $(".wrapper"+slideIndex).find('img').not('.arrow');
                        	arrImg.attr("class","");
                        	if(timer) clearTimeout(timer);
                        	timer = setTimeout(function(){
                    	switch(slideIndex){
                                  case 1:
                                               arrImg.eq(0).addClass('rollIn animated');
                                               arrImg.eq(1).addClass('zoomIn animated');
                                               arrImg.eq(3).addClass('animated fadeInDown');
                                               setTimeout(function(){
                                                   arrImg.eq(2).addClass('animated swing');
                                               }, 600);
                                               break;
                                  case 2:
                                               arrImg.eq(0).addClass('animated fadeInLeft');
                                               arrImg.eq(1).addClass('animated fadeInRight');
                                               arrImg.eq(2).addClass('animated lightSpeedIn');
                                               arrImg.eq(3).addClass('animated zoomIn');
                                               arrImg.eq(4).addClass('animated rotateInUpLeft');
                                               arrImg.eq(5).addClass('animated fadeInRight');
                                               break;
                                  case 3:
		                                      arrImg.eq(0).addClass('animated fadeInLeft');
		                                      arrImg.eq(1).addClass('animated fadeInRight');
		                                      arrImg.eq(2).addClass('animated lightSpeedIn');
		                                      arrImg.eq(3).addClass('animated fadeInLeft');
		                                      break;
                                  case 4:
                                               arrImg.eq(0).addClass('animated fadeInRight');
                                               arrImg.eq(1).addClass('animated fadeInLeft');
                                               arrImg.eq(2).addClass('animated lightSpeedIn');
                                               arrImg.eq(3).addClass('animated fadeInRight');
                                               break;
                                  case 5:
												arrImg.eq(0).addClass('animated fadeInUp');
												arrImg.eq(1).addClass('animated fadeInDown');
												break;
                                  case 6:
                                  			$('.arrow').hide();
                                               arrImg.eq(0).addClass('animated fadeInDown');
                                               arrImg.eq(2).addClass('animated fadeInUp');
                                               setTimeout(function(){
                                                   arrImg.eq(1).addClass('animated swing');
                                               }, 600)
                                               break;
                                    }

                            },100);

						}
	});
</script>
</body>
</html>