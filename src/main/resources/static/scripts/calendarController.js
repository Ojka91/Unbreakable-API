var activities = []
var activity ={
    name: "",
    description: "",
}
var inputName;
var inputDes;

fetch('/api/getActivities', {
    mode: 'no-cors'
  })
  .then((res) => res.json())
  .then((json) => {
    this.activities = json;
    printActivities();
  })
  .catch((err) => {
    console.log(err);

  })
  window.onload = function(){

  inputName =  document.getElementById("name");
  inputDes = document.getElementById("description");
  inputName.addEventListener("change", fillActivity);
  inputDes.addEventListener("change", fillActivity);     
  }
  function printActivities(){
    act = document.getElementById("activities")
    activities.forEach(element => {
        div = document.createElement("div")
        div.append(element.name);
        act.append(div);
    });
  }

  function fillActivity(){
    activity.name = inputName.value;
    activity.description = inputDes.value;
  }



    