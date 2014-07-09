//所有特定脚本:浏览器或者视窗
Modernizr.load([
    {//让IE8及以下支持支持media特性
    	test:Modernizr.mq('only all'),
    	nope:[_ctx+'/static/js/respond/respond.min.js',
    	      _ctx+'/static/js/respond/respond.matchmedia.addListener.min.js']
	}
    ,{//让IE9及以下支持填充文本
		test: Modernizr.input.placeholder,
		nope: [_ctx+'/static/js/jquery-placeholder/jquery.placeholder.css',
		       _ctx+'/static/js/jquery-placeholder/jquery.placeholder.js'],
		complete:function(){
			$(document).ready(function(){
				if(!Modernizr.input.placeholder){
					$('input, textarea').placeholder();
				}
			});
		}
	}
]);


