$(document).ready(function() {
	$(".submitform200").submit(function(event) {
		$.get($(event.target).attr("action"), $(event.target).serialize(), function(data) {
			var items = $(event.target).parent(".search").parent(".listproduct").children(".items").children("table").children("tbody");
			items.html("");
			$(data).each(function(i, item) {
				var row = $("<tr />");
				if (typeof item.name !== "undefined")
					row.append($("<td />").text(item.name));
				if (typeof item.description !== "undefined")
					row.append($("<td />").text(item.description));
				if (typeof item.count !== "undefined")
					row.append($("<td />").text(item.count));
				if (typeof item.tags !== "undefined")
					row.append($("<td />").text(item.tags));
				items.append(row)
			});
		});
		event.preventDefault();
	});
});