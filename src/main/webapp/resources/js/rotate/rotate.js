;
(function($, window) {
	var rotateText = [
		'<div class="prize-title prize-success fb">很遗憾没有中奖</div><div class="prize-info prize-error">请再接再厉，下次就能中奖啦</div> ',
		'<div class="prize-title prize-error fb">恭喜您！</div><div class="prize-info prize-error fb f60">下次中奖概率提高</div>',
		'<div class="prize-title prize-success fb">恭喜您！</div><div class="prize-info prize-success fb">您获得了<span class="f60 prize-error">200元京东卡！</span></div>',
		'<div class="prize-title prize-success fb">恭喜您！</div><div class="prize-info prize-success fb">您获得了<span class="f60 prize-error">100元京东卡！</span></div>',
	]
	var gamePage = {

		init: function() {
			//To avoid repetition and click on the draw button tags
			var bRotate = false;

			//According to the "item" variable function to be executed by the callback
			var rotateFn = function(awards, angles) {
				bRotate = !bRotate;
				$('#js_rotate_pointer').stopRotate();
				$('#js_rotate_pointer').rotate({
					angle: 0,
					animateTo: angles + 1800,
					duration: 8000,
					callback: function() {
						openPop('pop-prize');
						bRotate = !bRotate;
					}
				});
			};

			//According to the background return values corresponding callback bounced
			var rotateFun = function(item) {
				if (bRotate) return;

				var item = rnd(0, 7), //Real environment need to change this function to "AJAX" to obtain the value of "item"
					_index;

				if (item == 0) {
					_index = 7;
				} else {
					_index = item - 1;
				}
				var popText = $(".js_rotate_node").eq(_index).attr('data-pop');
				switch (item) {
					case 2:
						$('.js-rotate-text').html(rotateText[2]);
						rotateFn(338.5, 22.5);
						break;
					case 3:
						$('.js-rotate-text').html(rotateText[0]);
						rotateFn(23.5, 67.5);
						break;
					case 4:
						$('.js-rotate-text').html(rotateText[1]);
						rotateFn(68.5, 112.5);
						break;
					case 5:
						$('.js-rotate-text').html(rotateText[3]);
						rotateFn(113.5, 157.5);
						break;
					case 6:
						$('.js-rotate-text').html(rotateText[2]);
						rotateFn(158.5, 202.5);
						break;
					case 7:
						$('.js-rotate-text').html(rotateText[0]);
						rotateFn(203.5, 247.5);
						break;
					case 0:
						$('.js-rotate-text').html(rotateText[1]);
						rotateFn(248.5, 292.5);
						break;
					case 1:
						$('.js-rotate-text').html(rotateText[3]);
						rotateFn(293.5, 337.5);
						break;
				}
			}

			//Test with random integer return 1-6
			var rnd = function(n, m) {
				return Math.floor(Math.random() * (m - n + 1) + n)
			};

			//Click on the draw button to perform the function
			$('#js_rotate_btn').click(function() {
				var item = rnd(1, 6);
				// $.ajax({
				// 	type: "POST",
				// 	url: '/praise.htm',
				// 	data: {
				// 		id: infoId
				// 	},
				// 	dataType: "JSON",
				// 	success: function(data) {
				// 		if (data === "-1" || data == -1) {
				// 			ECar.dialogPrompt({
				// 				text: '您一天只能点一次赞哦！<br/>请24小时之后再来',
				// 				clickClose: true
				// 			});
				// 		} else {
				// 			$("#js_praise").text(data);
				// 		}
				// 	},
				// 	error: function() {}
				// });
				rotateFun(item);
			});

		}

	};


	gamePage.run = {
		loadLotteryDate: function() {
			gamePage.dev.getLotteryData(function(data) {
				if (data.status == 1) {
					$.each(data.info, function(index, item) {
						var popKey = "pop-the" + item.type + "ndprize";
						if (item.type == 1) popKey = "pop-firstprize";
						if (item.type == 0) popKey = "pop-losingprize";
						if (item.type == 2) popKey = "pop-the2ndprize";
						if (item.type == 3) popKey = "pop-the3ndprize";
						if (item.type == 4) popKey = "pop-the4ndprize";
						if (item.type == 5) popKey = "pop-the5ndprize";
						$(".js_rotate_node").eq(index).attr("data-code", item.code).attr("data-pop", popKey).html(item.text);
					});
					gamePage.init();
				} else {
					alert(data.message);
					//openPop();
				}
			});
		}
	};
	gamePage.dev = {
		getLotteryData: function(callback) {
			//code：lottery id
			//text：lottery des
			//type: Dialog box is displayed.
			var data = [{
				code: 1,
				type: 1,
				text: "一等奖"
			}, {
				code: "a",
				type: 2,
				text: "二等奖"
			}, {
				code: 3,
				type: 3,
				text: "三等奖"
			}, {
				code: 4,
				type: 4,
				text: "四等奖"
			}, {
				code: 5,
				type: 5,
				text: "五等奖"
			}, {
				code: 0,
				type: 0,
				text: "谢谢"
			}];
			try {
				getLotteryData(callback);
			} catch (e) {
				callback({
					status: 1,
					message: "",
					info: data
				});
			}
		},
		getLotteryResult: function(callback) {
			try {
				getLotteryResult(callback);
			} catch (e) {
				callback({
					status: 1,
					message: "",
					lotteryId: "a"
				})
			}
		}
	};
	gamePage.run.loadLotteryDate();

	//gamePage.init();

})($, window);