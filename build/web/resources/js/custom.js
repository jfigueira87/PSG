var initalDateSelect = true;
var cal=0;
function onDateSelect() {
   
   if(initalDateSelect) {
       myDate = cal.getDate();   
       cal.setDate(myDate);
       initalDateSelect = false;
   }

 }