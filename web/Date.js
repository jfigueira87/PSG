var initalDateSelect = true;

function onDateSelect() {

  if(initalDateSelect) {
      myDate = cal.getDate();   
      cal.setDate(myDate);
      initalDateSelect = false;
  }

}