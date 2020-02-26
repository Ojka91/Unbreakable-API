var activities = []
var activity = {
    name: "",
    description: "",
}
var calendar = {
    activityName: 'test',
    day: 05,
    month: 02,
    year: 2019,
}



var calendarInfo;

var inputName;
var inputDes;
var newActivity = false;
var newActivityDiv;
var addActivity;
var activityToDelete;
var date = {

}

function getCalendars(){
    fetch('/api/getCalendar', {
        mode: 'no-cors'
    })
    .then((res) => res.json())
    .then((json) => {
       calendar = json;
    })
    .catch((err) => {
        console.log(err);

    })
    return calendar;
}

fetch('/api/getActivities', {
        mode: 'no-cors'
    })
    .then((res) => res.json())
    .then((json) => {
        this.activities = json;
        printActivities();
        printActivitiesModal()

    })
    .catch((err) => {
        console.log(err);

    })
window.onload = function () {

    inputName = document.getElementById("name");
    inputDes = document.getElementById("description");
    newActivityDiv = document.getElementById("newActivity");
    addActivity = document.getElementById("addActivity");
    addCalendar = document.getElementById('addCalendar')

    inputName.addEventListener("change", fillActivity);
    inputDes.addEventListener("change", fillActivity);
    newActivityDiv.addEventListener("click", addNewActivityDiv);
    addActivity.addEventListener("click", addActivityAction);
    addCalendar.addEventListener('click', addCalendarAction)
}

function printActivities() {
    act = document.getElementById("activities")
    activities.forEach(element => {
        div = document.createElement("div")
        div.append(element.name);
        act.append(div);
        btn = document.createElement("input")
        btn.type = "button";
        btn.value = "Delete"
        btn.id = element.name
        act.append(btn);
        addListener(element.name);
    });
}

function printActivitiesModal(){
    act = document.getElementById("activitiesModal")
    activities.forEach(element => {
        cb = document.createElement("input");
        cb.setAttribute("type", "checkbox");
        cb.setAttribute("id", element.name)
        cb.setAttribute("value", element.name)
        div = document.createElement("div")
        div.append(cb, element.name);
        act.append(div);
    });
}


function addListener(element) {
    document.getElementById(element).addEventListener("click", function (element) {
        deleteActivity(element);
    });
}
function back(){
    window.location = window.location.origin
}

function fillActivity() {
    activity.name = inputName.value;
    activity.description = inputDes.value;
}

function addNewActivityDiv() {
    if (newActivity == false) {
        document.getElementById("activityInputs").style.display = "block";
        newActivity = true;
    } else {
        document.getElementById("activityInputs").style.display = "none";
        newActivity = false;
    }
}

function addActivityAction() {
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
        if (Object.keys(json).includes("correct")) {
            console.log("activity correct")
            addNewActivityDiv();
        }
        if (Object.keys(json).includes("KO")) {
            console.log("error")
        }

        console.log('parsed json', json)
    }).catch(function (ex) {
        console.log('parsing failed', ex)
        alert("error creating new user" + ex);

    });
}

function deleteActivity(element) {
    console.log("jj" + element.toElement.id)
    fetch('/api/deleteActivity', {
        credentials: 'include',
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: element.toElement.id
    }).then(function (response) {
        return response.json();
    }).then(function (json) {
        if (Object.keys(json).includes("correct")) {
            console.log("activity correct")
            printActivities()
        }
        if (Object.keys(json).includes("KO")) {
            console.log("error")
        }

        console.log('parsed json', json)
    }).catch(function (ex) {
        console.log('parsing failed', ex)

    });
}

function addCalendarAction() {
    fetch('/api/addCalendar?activityName='+ calendar.activityName + '&day=' + calendar.day + '&month='
        + calendar.month + '&year=' + calendar.year, {
        credentials: 'include',
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
    }).then(function (response) {
        return response.json();
    }).then(function (json) {
        if (Object.keys(json).includes("correct")) {
            console.log("activity correct")
            addNewActivityDiv();
            $('#calendar').fullCalendar('renderEvents', getCalendars())
        }
        if (Object.keys(json).includes("KO")) {
            console.log("error")
        }

        console.log('parsed json', json)
    }).catch(function (ex) {
        console.log('parsing failed', ex)
        alert("error creating new user" + ex);

    });
}
