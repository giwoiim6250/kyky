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
<link href="/resources/css/pages/form.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<img src="/resources/images/public/share-img.jpg" width="0" height="0" style="position:absolute;"/>
	<div class="mp3-node" id="js_mp3">
		<img src="/resources/images/public/mp3.png" width="100%" alt="" id="js_mp3_img"/>
		<audio loop=""  id="js_mp3_audio"><source src="/resources/mp3/Adagio-Soundtrack.mp3"></audio>
	</div>
	<a href="javascript:;" class="btn-return" id="js_btn_return"></a>
	<div class="info-edit-page owner-edit ">
		<div class="logo-box">
			<img src="/resources/images/public/logo.png" alt ="logo"/>
		</div>
		<div class="dealer-edit-cont">
			<div class="dealer-edit-cont-title">
				车主填写
			</div>
			<div class="dealer-edit-cont-info">
				<form method="post" target="_self" accept-charset="UTF-8" action="/buying/save.htm" id="js_form">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td class="edit-title">车主姓名</td>
							<td class="edit-cont">
								<input type="text" name="username" class="input-name" value="" id="js_name"/>
							</td>
							<td class="edit-alert">
								<div class="tip-error">
									填写错误
								</div>
							</td>
						</tr>
						<tr>
							<td class="edit-title">车主地址</td>
							<td class="edit-cont" id="js_select_address">
								<select name="addressProvince" class="select-province prov" id="js_province" mr="选择省">
									<option value="0">选择省</option>
								</select>
								<select name="addressCity" class="select-city city" id="js_city" mr="选择市">
									<option value="0">选择市</option>
								</select>
								<!--<input type="text" name="addressDistrict" class="input-address" value="" id="js_address"/>-->
							</td>
							<td class="edit-alert">
								<div class="tip-error">
									填写错误
								</div>
							</td>
						</tr>
						<tr>
							<td class="edit-title">性别</td>
							<td class="edit-cont td-sex">
								<label>
								    <input type="radio" name="sex" value="1" id="sex_0" checked="checked" />
								    <span>男</span>
								</label>
							  	<label>
								    <input type="radio" name="sex" value="2" id="sex_1" />
								    <span>女</span>
								</label>
							</td>
							<td class="edit-alert"></td>
						</tr>
						<tr>
							<td class="edit-title">拥有全顺数量</td>
							<td class="edit-cont pos-r">
								<input type="number" name="purchaseNum" class="input-transitnum" value="" id="js_transitnum"/>
								<div class="input-unit"></div>
							</td>
							<td class="edit-alert">
								<div class="tip-error">
									填写错误
								</div>
							</td>
						</tr>
						<tr>
							<td class="edit-title">出生日期</td>
							<td class="edit-cont">
								<input type="date" name="birthday" class="input-birthday" id="js_birthday" placeholder="1995/03/10" value="1995-03-10"/>
							</td>
							<td class="edit-alert">
								<div class="tip-error">
									填写错误
								</div>
							</td>
						</tr>
						<tr>
							<td class="edit-title">电话</td>
							<td class="edit-cont">
								<input type="text" name="telephone" class="input-tel" value="" id="js_tel" maxlength="11"/>
							</td>
							<td class="edit-alert">
								<div class="tip-error">
									填写错误
								</div>
							</td>
						</tr>
						<tr>
							<td class="edit-title">车型</td>
							<td class="edit-cont td-sex">
								<label>
								    <input type="radio" name="carModel" value="1" id="carmodel_0" checked="checked" />
								    <span>经典</span>
								</label>
							  	<label>
								    <input type="radio" name="carModel" value="2" id="carmodel_1" />
								    <span>新世代</span>
								</label>
							</td>
							<td class="edit-alert"></td>
						</tr>
						<tr>
							<td class="edit-title">里程</td>
							<td class="edit-cont pos-r">
								<input type="number" name="mileage" class="input-mileage" value="" id="js_mileage"/>
								<div class="input-unit">公里</div>
							</td>
							<td class="edit-alert">
								<div class="tip-error">
									填写错误
								</div>
							</td>
						</tr>
						<tr>
							<td class="edit-title">购买日期</td>
							<td class="edit-cont">
								<input type="date" name="buyDate" class="input-puydate" id="js_puydate" placeholder="1995/03/10" value="1995-03-10"/>
							</td>
							<td class="edit-alert">
								<div class="tip-error">
									填写错误
								</div>
							</td>
						</tr>
					</table>
					<input type="hidden" name="infoType" value="2"/>
				</form>
			</div>
			<div class="dealer-edit-cont-btn">
				<a href="javascript:;" class="btn-pub btn-confirm" id="js_submit">
					<span>确定</span>
				</a>
			</div>
		</div>
	</div>
	<script>
	var checkType = 'owner';
	</script>
    <script src="/resources/js/public/zepto.min.js"></script>
    <script src="/resources/js/form/cityselect.js"></script>
    <script src="/resources/js/public/common.js"></script>
    <script src="/resources/js/form/form.js"></script>
</body>
</html>