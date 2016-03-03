/*@author ldc4*/

//显示同学寄语的标志量
var classwordsFlag = false;
//$("#class_new").fadeOut("slow");
$("#class_new").fadeIn("slow");
//淡入淡出同学寄语
var showClassWords = function(){
	if(classwordsFlag){
		$("#classword_li").show();
		//$("#class_new").fadeIn("slow");
		//$("#class_new").margin-top = 320;
		//document.getElementById("class_new").style.top = 320;
		//document.getElementById("test1").style.top = a;
		$("#class_words").fadeOut("slow");
		//$("#zhuye").fadeIn("slow");
		$("body").css("background-color","rgb(35,35,35)");
		classwordsFlag = false;
	}else{
		$("#classword_li").hide();
		//$("#class_new").fadeOut("slow");
		//$("#class_new").margin-top = 320;
		//document.getElementById("class_new").style.top = 320;
		$("#class_words").fadeIn("slow");
		//$("#zhuye").fadeOut("slow");
		$("body").css("background-color","#092756");
		classwordsFlag = true;
	}
};
