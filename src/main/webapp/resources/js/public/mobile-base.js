/**
 * mobile-base 1.0
 * Mobile terminal font size calculation
 *
 * Copyright 2016, zhangweiming
 * http://www.surto.cn/
 *
 * Released on: August 1, 2016
 */

(function(){

	var rem;

	function w() {
		var r = document.documentElement;
		var a = r.getBoundingClientRect().width;
		a > 1080 && (a = 1080), rem = a/1080 *100 , r.style.fontSize = rem + "px"
	}

	var t;
	w(), window.addEventListener("resize", function() {
	  t && clearTimeout(t), t = setTimeout(w, 300)
	}, false);

})();