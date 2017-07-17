$(function() {
	var total = 0;
	var totalPay = 0;
	var content = "";
	var length = 0;
	var orderData = {};
	var time = "";
	var no = "";
	var status = 0;
	var money = 0;
	var deleteData = {};

	$(document).on("pageinit", "#indexPage", function() {
		$.ajax({
			type: "post",
			url: "queryDessert.spring?t=" + new Date().getTime(),
			success: function(data) {
				var jArray = JSON.parse(data);

				$.each(jArray, function(index, item) {
					if(!(index % 3)) {

						$('#ul_1').append("<li><img src='" + item.picurl + "' /><h3>" + item.name + " </h3><h4> ¥" + item.price + "/份<span class='span1'><input value='-' type='button' class='decrease' id='decrease_" + item.id + "' /><input value='0' type='text' class='mValue' id='" + item.id + "' readonly /><input value='+' type='button' class='increase' id='increase_" + item.id + "' /></span> </h4></li > ");
					}
					if(index % 3 == 1) {

						$('#ul_2').append("<li><img src='" + item.picurl + "' /><h3>" + item.name + " </h3><h4> ¥" + item.price + "/份<span class='span1'><input value='-' type='button' class='decrease' id='decrease_" + item.id + "' /><input value='0' type='text' class='mValue' id='" + item.id + "' readonly /><input value='+' type='button' class='increase' id='increase_" + item.id + "' /></span> </h4></li > ");
					}
					if(index % 3 == 2) {

						$('#ul_3').append("<li><img src='" + item.picurl + "' /><h3>" + item.name + " </h3><h4> ¥" + item.price + "/份<span class='span1'><input value='-' type='button' class='decrease' id='decrease_" + item.id + "' /><input value='0' type='text' class='mValue' id='" + item.id + "' readonly /><input value='+' type='button' class='increase' id='increase_" + item.id + "' /></span> </h4></li > ");
					}

					$('ul').on("click", "#increase_" + item.id, function() {
						var mData = {};
						$('#' + item.id).val(parseInt($('#' + item.id).val()) + 1);
						total++;
						$('#topspan').text(total);
						mData = {
							"id": item.id
						};
						$.ajax({
							type: "post",
							contentType: "application/json",
							data: JSON.stringify(mData),
							url: "queryNameAndPrice.spring?t=" + new Date().getTime(),
							success: function(data) {

								var jObj = JSON.parse(data);
								$('#payList').append("<li id='li" + item.id + $('#' + item.id).val() + "'><span class='spanName'>" + jObj.name + "</span><span>¥</span><span class='spanPrice'>" + jObj.price + "</span></li>");
								$('#payList').listview().listview("refresh");
							}
						});
					});
					$('ul').on("click", "#decrease_" + item.id, function() {
						if(parseInt($('#' + item.id).val()) > 0) {
							$("#li" + item.id + $('#' + item.id).val()).remove();
							$('#payList').listview("refresh");
							$('#' + item.id).val(parseInt($('#' + item.id).val()) - 1);
							total--;
							$('#topspan').text(total);
						} else
							$('#' + item.id).val(0);
					});
				});
			}
		});
	});
	$('#orderList').click(function() {
		totalPay = 0;
		$('#payList li').each(function(index) {
			totalPay += parseInt($(this).find("span[class='spanPrice']").text());
			length = $('#payList').find('li').length;
			if(index != (length - 1))
				content += ($(this).find("span[class='spanName']").text() + "|");
			else
				content += ($(this).find("span[class='spanName']").text());
		});
		$('#totalPay').text(totalPay);
	});

	function formatTime(time) {
		var datetime = new Date();
		datetime.setTime(time);
		var year = datetime.getFullYear();
		var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
		var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
		var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
		var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
		var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
		return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
	}

	$('#pOrder').click(function() {
		if($('#payList').find('li').length > 0) {
			time = formatTime(new Date());
			money = parseFloat($('#totalPay').text());
			no = new Date().getTime();
			orderData = {
				"time": time,
				"money": money,
				"content": content,
				"status": status,
				"no": no
			};
			$.ajax({
				type: "post",
				contentType: "application/json",
				url: "insertOrder.spring?t=" + new Date().getTime(),
				data: JSON.stringify(orderData),
				success: function(data) {
					if(data == "success") {
						$('#no').text(no);
						$('#money').text(money);
						window.location.href = "#orderPage";
					} else
						alert(data);
				}

			});
		} else {
			setTimeout(function() {
				$("#myPopup").popup("open");
			}, 0);
		}

	});

	$('#cancelOrder').click(function() {
		no = $('#no').text();
		deleteData = {
			"no": no
		};
		$.ajax({
			type: "post",
			contentType: "application/json",
			url: "deleteOrder.spring?t=" + new Date().getTime(),
			data: JSON.stringify(deleteData),
			success: function(data) {
				window.location.href = "#indexPage";
				window.location.reload();
			}
		});

	});
})