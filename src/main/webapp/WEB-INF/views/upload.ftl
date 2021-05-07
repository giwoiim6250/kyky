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
<link href="/resources/css/components/webuploader.css" rel="stylesheet" type="text/css"/>
<link href="/resources/css/pages/upload.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <img src="/resources/images/public/share-img.jpg" width="0" height="0" style="position:absolute;"/>
    <div class="mp3-node" id="js_mp3">
        <img src="/resources/images/public/mp3.png" width="100%" alt="" id="js_mp3_img"/>
        <audio loop=""  id="js_mp3_audio"><source src="/resources/mp3/Adagio-Soundtrack.mp3"></audio>
    </div>
    <a href="javascript:;" class="btn-return" id="js_btn_goback"></a>
	<div class="upload-page" id = "uploader">
        <form method="post" target="_self" accept-charset="UTF-8" action="/buying/update/picture.htm" id="js_upload_form">
            <input type="hidden" name="id" value="${id}"/>
    		<div class="upload-img-box comment-uploader" id="filePicker">
    			<div class="webuploader-pick">+</div>
    		</div>
    		<div class="upload-img-box hide" id="fileShow">
    			<img src="/resources/images/upload/img.jpg" alt=""/>
    			<input type="hidden" name="picture" value="" id="js_imgurl"/>
    		</div>
    		<div class="upload-img-text">
    			注：照片必须为车主和全顺的合影
    		</div>
    		<div class="upload-info-text">
    			您与全顺的故事（请输入10 - 150字）
    		</div>
    		<textarea name="story" cols="" rows="" class="upload-story" maxlength="150" id="js_story"></textarea>
    		<div class="upload-btn-box">
    			<a href="javascript:;" class="upload-btn" id="js_submit">
    				<span>下一步</span>
    			</a>
    		</div>
		</form>
	</div>
    <script>
    var upload_imgurl = 'http://127.0.0.1/upload/submit.htm';
    </script>
    <script src="/resources/js/public/jquery_1_8_3.min.js"></script>
    <script src="/resources/js/public/dialogPrompt.js"></script>
    <script src="/resources/js/public/webuploader.html5only.min.js"></script>
    <script src="/resources/js/public/common.js"></script>
    <script src="/resources/js/upload/upload.js"></script>
</body>
</html>