com.company.rssfiddle.js.menu = {
	setActiveMenu : function() {		
		var obj = $("#cssmenu a");
		for(cnt = 1; cnt <= obj.length;cnt++){
			if(pageId == $(obj[cnt]).text())
				$(obj).parent().addClass('active');
		}
	}

};

var menuObj = com.company.rssfiddle.js.menu;
