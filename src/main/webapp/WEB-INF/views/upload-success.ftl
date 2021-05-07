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
<link href="/resources/css/pages/upload.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<img src="/resources/images/public/share-img.jpg" width="0" height="0" style="position:absolute;"/>
	<div class="mp3-node" id="js_mp3">
		<img src="/resources/images/public/mp3.png" width="100%" alt="" id="js_mp3_img"/>
		<audio loop=""  id="js_mp3_audio"><source src="/resources/mp3/Adagio-Soundtrack.mp3"></audio>
	</div>
	<a href="javascript:;" class="btn-return" id="js_btn_goback"></a>
	<div class="upload-success-page">
		<div class="logo-box">
			<img src="/resources/images/public/logo.png" alt ="logo"/>
		</div>
		<div class="success-img-show">
		<div style="overflow:hidden">
			<img src="${info.picture}" alt=""/>
		</div>
		</div>
		<div class="success-show-text">
			<span class="success-show-text-title">
				<span>上传成功</span>
			</span>
		</div>
		<div class="upload-btn-box">
			<a href="/detail/${info.id}.htm" class="upload-btn" id="js_submit">
				<span>点击查看</span>
			</a>
		</div>
	</div>
	<script src="/resources/js/public/common.js"></script>
</body>
</html>