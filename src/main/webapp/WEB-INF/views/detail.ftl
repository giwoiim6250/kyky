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
<link href="/resources/css/pages/works-detail.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<img src="/resources/images/public/share-img.jpg" width="0" height="0" style="position:absolute;"/>
	<div class="mp3-node" id="js_mp3">
		<img src="/resources/images/public/mp3.png" width="100%" alt="" id="js_mp3_img"/>
		<audio loop=""  id="js_mp3_audio"><source src="/resources/mp3/Adagio-Soundtrack.mp3"></audio>
	</div>
	<a href="javascript:;" class="btn-return" id="js_btn_return"></a>
	<article class="wrapper">
		<section class="content">
			<dl>
				<dt class="photo-show" id="js_bigEvent"><img src="${info.picture}"/></dt>
				<dd class="driver-info">${info.username}，${age}岁，${info.addressCity}人<br><br></dd>
				<dd class="btn-box">
					<i class="btn-heart js_praise_btn" info_id = "${info.id}"></i>
					<span class="num-zan js_praise_btn" info_id = "${info.id}" id="js_praise">${info.praiseNum}</span>
					<i class="btn-share"></i>
				</dd>
			</dl>
			<p class="driver-introduction">
				${info.story}
			</p>
            <div class="upload-btn-box">
                <a href="/list.htm" class="upload-btn">
                    <span>查看更多</span>
                </a>
            </div>
		</section>
	</article>
	<div class="weixin-guide">
        <img src="/resources/images/public/icon-share-img.png" width="90%"/>
    </div>
    <div class="show-bigimg" id="js_showBig">
		<div class="show-bigimg-div">
	    	<img src="${info.picture}"/>
	    </div>
    </div>
    <script src="/resources/js/public/zepto.min.js"></script>
    <script src="/resources/js/public/common.js"></script>
    <script src="/resources/js/public/dialogPrompt.js"></script>
    <script src="/resources/js/detail/detail.js"></script>
</body>
</html>