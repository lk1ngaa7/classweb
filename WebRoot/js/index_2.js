(function(){
  var show = document.getElementById("camera_show").getElementsByTagName("ul")[0];
  var num = show.getElementsByTagName("li").length;
  var ul_width = 190 * num;
  show.style.width = ul_width + "px";
  var number = 0;
    $("#turnleft").click(function(){
      if(number == 0){

      }else{
        $("#layout_ul").animate({
          left: '+=116px',
        });
        number--;
      }
    });
    $("#turnright").click(function(){
      if(number == num - 8){
    	  $("#layout_ul").animate({
              left: '0px'
          });
    	  number = 0;
      }else{
    	//alert(number+":"+num);
        $("#layout_ul").animate({
          left: '-=116px'
        });
        number++;
      }
    });
})();
