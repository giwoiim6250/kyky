
;(function(){

	var mp3Audio = $('#js_mp3_audio'),
		mp3Img = $('#js_mp3_img');

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
    }

	$('#js_mp3').on('click',function(){
		var _type =mp3Audio[0].autoplay;
		if(!_type){
			mp3Audio[0].autoplay = true;
			mp3Audio[0].play();
			mp3Img.attr('src','/resources/images/public/mp3.png');
		} else {
			mp3Audio[0].autoplay = false;
			mp3Audio[0].pause();
			mp3Img.attr('src','/resources/images/public/mp3-dis.png');
		}
	});

	$('#js_btn_return').on('click',function(){
		var pageType = _getCookie('pagetype');
		if(pageType == 'dealer'){
			window.location.href = "/dealer/index.htm?step=5";
		} else {
			window.location.href = "/index.htm?step=5";
		}
	});

	$('#js_btn_goback').on('click',function(){
		window.history.go(-1);
	});

	//Cookie Common Class
	function _getCookie(key) {
	    var result = document.cookie.match(new RegExp("(^| )" + key + "=([^;]*)"));
	    return result != null ? decodeURIComponent(result[2]) : null;
	}
	function _setCookie(key, value, expireDay) {
	    if (expireDay) {
	        var date = new Date();
	        date.setTime(date.getTime() + expireDay * 24 * 3600 * 1000);
	        document.cookie = key + "=" + encodeURIComponent(value) + ";path=/;expires=" + date.toGMTString();
	    } else {
	        document.cookie = key + "=" + encodeURIComponent(value) + ";path=/";
	    }
	}

	function openPop(_id){
		$('#'+_id).show();
	}

	$('.js_pop_close').on('click',function(){
		$('.js_pop_continer').hide();
	});

	window.getCookie = _getCookie;
	window.setCookie = _setCookie;
	window.openPop = openPop;
})();



