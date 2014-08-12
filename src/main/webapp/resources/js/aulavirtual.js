var aulaVirtualController = {
	/* Attributes */
	/* Methods */	
	addFlashMessage: function(message) {
		var myParragraph = $('<p/>', { 'class': 'error center', html: message });
		var myDismiss = $('<a/>', { 'class': 'dismissFlash', href: 'javascript:void(0);', 
			html:  strings['label.dismiss']});
		$(myDismiss).click(function() {
			$(this).parent().remove();
		});
		$(myParragraph).append(myDismiss);
		$('#flashMessagesBox').html(myParragraph);
	}	
};
