var activities = []
var activity = {
    name: "",
    description: "",
}
var inputName;
var inputDes;
var newActivity = false;
var newActivityDiv;
var addActivity;
var activityToDelete;

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
window.onload = function () {

    inputName = document.getElementById("name");
    inputDes = document.getElementById("description");
    newActivityDiv = document.getElementById("newActivity");
    addActivity = document.getElementById("addActivity");

    inputName.addEventListener("change", fillActivity);
    inputDes.addEventListener("change", fillActivity);
    newActivityDiv.addEventListener("click", addNewActivityDiv);
    addActivity.addEventListener("click", addActivityAction);
}

function printActivities() {
    act = document.getElementById("activities")
    activities.forEach(element => {
        div = document.createElement("div")
        div.append(element.name);
        act.append(div);
        btn = document.createElement("input")
        btn.type ="button";
        btn.value = "Delete"
        btn.id = "delete"+element.name
        act.append(btn);
        addListener(element.name);

    });
}
function addListener(element){
    document.getElementById("delete"+element).addEventListener("click", function(element){
        deleteActivity(element);
    });
}

function fillActivity() {
    activity.name = inputName.value;
    activity.description = inputDes.value;
}

function addNewActivityDiv(){
    if (newActivity == false){
        document.getElementById("activityInputs").style.display = "block";
        newActivity = true;
    }else{
        document.getElementById("activityInputs").style.display = "none";
        newActivity = false;
    }
}

function addActivityAction(){
    fetch('/api/addActivity', {
        credentials: 'include',
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
         },
         body: JSON.stringify(activity)
       }).then(function (response) {
         return response.json();
       }).then(function (json) {
         if(Object.keys(json).includes("correct")){
           console.log("activity correct")
           addNewActivityDiv();
         }
         if(Object.keys(json).includes("KO")){
            console.log("error")
        }

         console.log('parsed json', json)
       }).catch(function (ex) {
         console.log('parsing failed', ex)
         alert("error creating new user"+ ex);
         
       });
}

function deleteActivity(element){
    console.log("jj"+element.srcElement.value)
}