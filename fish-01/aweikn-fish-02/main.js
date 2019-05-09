fish.View.configure({manage: true});

require(['modules/main/views/IndexView'], function(IndexView){
	new IndexView().render();
})