<script type="text/javascript">
$(".pageFormContent").scroll(function(){
		if(($("#content").offset().top-$(".dialog").offset().top) <= 34*2){
			$("#edui1_toolbarbox").css({"position":"fixed","top":parseInt($(".dialog").css("top"))+34*2+'px',width:"600px"});
		}else{$("#edui1_toolbarbox").css({"position":"absolute",width:"600px","top":"0","z-index":1100});
			var html = '<div style="height:55px"></div>';
			if($("#edui1_toolbarbox").prev().length==0){
				$("#edui1_toolbarbox").before(html);
			}
		}
		if(($("#content").parent().next().offset().top-$(".dialog").offset().top) <= 34*2){
			$("#edui1_toolbarbox").css({"position":"absolute",width:"600px","top":"0","z-index":1100});
			var html = '<div style="height:55px"></div>';
			if($("#edui1_toolbarbox").prev().length==0){
				$("#edui1_toolbarbox").before(html);
			}
		}
	});
</script>