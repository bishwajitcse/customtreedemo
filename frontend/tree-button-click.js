var clickCount = 0;
var timeout = 500;

window.addClickListener = function(component){
	if(component!=null){
		component.addEventListener("click",function(e){
			//console.log(e);
			clickCount++;
		      if (clickCount == 1) {
		        setTimeout(function(){
		          if(clickCount == 1) {
		        	  //fired when single click
		        	  component.$server.onItemClicked(false);
		          } else {
		        	  //fired when double click
		        	  component.$server.onItemClicked(true);
		          }
		          clickCount = 0;
		        }, timeout || 300);
		      }
		});
	}
}