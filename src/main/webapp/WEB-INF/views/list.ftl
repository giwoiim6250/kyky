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
<link href="/resources/css/pages/list.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<img src="/resources/images/public/share-img.jpg" width="0" height="0" style="position:absolute;"/>
	<div class="mp3-node" id="js_mp3">
		<img src="/resources/images/public/mp3.png" width="100%" alt="" id="js_mp3_img"/>
		<audio loop=""  id="js_mp3_audio"><source src="/resources/mp3/Adagio-Soundtrack.mp3"></audio>
	</div>
	<a href="javascript:;" class="btn-return" id="js_btn_return"></a>
	<div class="list-page">
		<div class="logo-box">
			<img src="/resources/images/public/logo.png" alt ="logo"/>
		</div>
		<div class="list-title">
			<a href="/list.htm?content=${searchContent}&type=1" class="order-btn">点赞排序</a>
			<a href="/list.htm?content=${searchContent}" class="order-btn">编号排序</a>
			<div class="search-box">
				<a class="search-btn" id="js_search_btn" href="javascript:;"><i></i></a>
				<div class="input-box">
					<input type="text" name="search" class="input-search" value="${searchContent}" id="js_search"/>
				</div>
			</div>
		</div>
		<ul class="list-cont clearfix" id="js_list_cont">
		<#include "/list-data.ftl" />
		</ul>
	</div>
	<div class="weixin-guide">
	    <img src="/resources/images/public/icon-share-img.png" width="90%"/>
	</div>
	<script>
	   var pageCount = "${pageCount}";
	   var searchContent = "${searchContent}";
	   var sortType = "${sortType}";
	</script>
    <script src="/resources/js/public/zepto.min.js"></script>
    <script src="/resources/js/public/scrollLoad.js"></script>
    <script src="/resources/js/public/dialogPrompt.js"></script>
    <script src="/resources/js/public/common.js"></script>
    <script src="/resources/js/list/list.js"></script>
</body>
</html>