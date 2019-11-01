var app = new Vue({
  el: '#app',
  data: {
    view: 'main',
    disciplines: [],
    lastView:"menu",
    userData:{
      username: "",
      password:"",
    },
    loginData:{
      userName: "",
      password: "",
    },
    users:[],
    creatingUserInfoOk: null,
    creatingUserInfoKo: null,
    updateUserInfoOK:null,
    updateUserInfoKo:null,
    deleteUserInfoOK: null,
    deleteUserInfoKO:null,
    elements:[],
    routine:[],
    userDataDelete:{
      username:"",
      password:"",
    },
  },

  methods: {
    changeView: function (view) {
      this.view = 'loading'

      if (view == "disciplines") {
        fetch('/api/disciplines', {
            mode: 'no-cors'
          })
          .then((res) => res.json())
          .then((json) => {
            this.disciplines = json;
            this.view = view;
          })
          .catch((err) => {
            console.log(err);

          })
      }
      if (view == "elements") {
        fetch('/api/elements', {
            mode: 'no-cors'
          })
          .then((res) => res.json())
          .then((json) => {
            this.elements = json;
            this.view = view;
          })
          .catch((err) => {
            console.log(err);

          })
      }

      if (view == "profile") {
        fetch('/api/users', {
            mode: 'no-cors'
          })
          .then((res) => res.json())
          .then((json) => {
            this.users = json;
            this.view = view;
          })
          .catch((err) => {
            console.log(err);

          })
      }

      if(view == "map"){
        this.view = view;
        var markerMiracle = [1.260306,41.1142773];
        var markerArrabassada = [1.2728268, 41.118371]
        var markerFrancoli = [1.2323168, 41.127014]

        var divMiracle = document.createElement('div');
        var divArrabassada = document.createElement('div');
        var divFrancoli = document.createElement('div');


        divMiracle.id = 'marker'; 
        divArrabassada.id='marker';
        divFrancoli.id = 'marker';
      

        mapboxgl.accessToken = 'pk.eyJ1Ijoib2prYTkxIiwiYSI6ImNrMTNuMnpwaDBhOTUzY3Fqd2x1czN2MngifQ.JptQgBADc6-MntgYZ3woDA',
        map = new mapboxgl.Map({
          container: 'map',
          style: 'mapbox://styles/mapbox/streets-v11',
          center: [1.2467413,41.119028],
          zoom: 11
        })

        var popup = new mapboxgl.Popup({ offset: 25 })  
        .setText('Construction on the Washington Monument began in 1848.');

        var popito = new mapboxgl.Popup({ offset: 25 })  
        .setText('popupdos');

        new mapboxgl.Marker(divMiracle)
        .setLngLat(markerMiracle)
        .setPopup(popup) // sets a popup on this marker
        .addTo(map);

        new mapboxgl.Marker(divArrabassada)
        .setLngLat(markerArrabassada)
        .setPopup(popito) // sets a popup on this marker
        .addTo(map);

        new mapboxgl.Marker(divFrancoli)
        .setLngLat(markerFrancoli)
        .setPopup(popito) // sets a popup on this marker
        .addTo(map);
      }

      
      

      else{
        this.view=view;
      }

    },

    deleteProfile(){
      this.userDataDelete.username = this.users.name;
      pwd = document.getElementById("passwordDelete").value;
      this.userDataDelete.password = pwd;

      fetch('/api/deleteUser', {
        credentials: 'include',
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
         },
         body: JSON.stringify(app.userDataDelete)
       }).then(function (response) {
         return response.json();
       }).then(function (json) {
         if(Object.keys(json).includes("correct")){
           app.deleteUserInfoOK = json.correct;
         }
         if(Object.keys(json).includes("error")){
           app.deleteUserInfoKO = json.error;
         }

         app.creatingUserMessageTimer();
         app.getUsers();
         app.view='profile';

         console.log('parsed json', json)
       }).catch(function (ex) {
         console.log('parsing failed', ex)
         alert("error creating new user"+ ex);
         
       });
        },

    generateRoutine(lvl, view){
      this.view = 'loading'
      if(lvl == 'beginner'){
        fetch('/api/getRoutine/calisthenics/all/1,2', {
            mode: 'no-cors'
          })
          .then((res) => res.json())
          .then((json) => {
            this.routine = json;
            this.view = view;
          })
          .catch((err) => {
            console.log(err);

          })
      }

      if(lvl == 'advanced'){
        fetch('/api/getRoutine/calisthenics/all/3,4,5', {
            mode: 'no-cors'
          })
          .then((res) => res.json())
          .then((json) => {
            this.routine = json;
            this.view = view;
          })
          .catch((err) => {
            console.log(err);

          })
      }

      if(lvl == 'master'){
        fetch('/api/getRoutine/calisthenics/all/5,6', {
            mode: 'no-cors'
          })
          .then((res) => res.json())
          .then((json) => {
            this.routine = json;
            this.view = view;
          })
          .catch((err) => {
            console.log(err);

          })
      }

    },


     back(){
       if(this.view == 'personalProfile'){
         app.changeView("profile");
       }else if(this.view == 'routine'){
          app.changeView("routines")
      }else{
         this.view = 'menu';
        }
      },


     getUsers(){
      fetch('/api/users', {
        mode: 'no-cors'
      })
      .then((res) => res.json())
      .then((json) => {
        this.users = json;
      
      })
      .catch((err) => {
        console.log(err);

      })
     },

     createUser(){
       uname = document.getElementById("userName")
       pwd = document.getElementById("password")

       if(uname.value != null && pwd.value != null){
        
         this.view="loading"
         this.userData.username = uname.value
         this.userData.password = pwd.value
       
        
         fetch('/api/users', {
           credentials: 'include',
           method: 'POST',
           headers: {
             'Content-Type': 'application/json'
            },
            body: JSON.stringify(app.userData)
          }).then(function (response) {
            return response.json();
          }).then(function (json) {
            uname.value="";
            pwd.value="";
            if(Object.keys(json).includes("correct")){
              app.creatingUserInfoOk = json.correct;
            }
            if(Object.keys(json).includes("error")){
              app.creatingUserInfoKo = json.error;
            }

            app.creatingUserMessageTimer();
            app.getUsers();
            console.log('parsed json', json)
          }).catch(function (ex) {
            console.log('parsing failed', ex)
            alert("error creating new user"+ ex);
            
          });
          this.view="profile";
         
        }
        
     },

     creatingUserMessageTimer(){
      setTimeout(
        function() {
          app.creatingUserInfoOk=null;
          app.creatingUserInfoKo=null;
          app.updateUserInfoKo=null;
          app.updateUserInfoOK=null;
          app.deleteUserInfoKO=null;
          app.deleteUserInfoOK=null;
        }, 5000);
     },

     updateProfile(){
        pshup = document.getElementById("pshup").value;
        pllup = document.getElementById("pllup").value;
        hh = document.getElementById("hh").value;
        hp = document.getElementById("hp").value;
        fl = document.getElementById("fl").value;
        bl = document.getElementById("bl").value;
        pwd = document.getElementById("password").value;

        fetch('/api/users/'+app.users.name+'?pushUp='+pshup+'&pullUp='+pllup+'&hsHold='+hh+'&hsPushUp='+hp+
        '&frontLever='+fl+'&backLever='+bl+'&password='+pwd, {
          credentials: 'include',
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
           },
         }).then(function (response) {
           return response.json();
         }).then(function (json) {
          console.log('parsed json', json)
          pshup.value = "";

           if(Object.keys(json).includes("correct")){
             app.updateUserInfoOK = json.correct;
             app.changeView('profile');
           }else{
             app.updateUserInfoKo = json.ko;

           }
           app.creatingUserMessageTimer();
          }).catch(function (ex) {
            console.log('parsing failed', ex)
            
          });
         

      },

     personalProfileIn(userName){
      this.view="loading"

      
        fetch('/api/users/'+userName, {
          mode: 'no-cors'
        })
        .then((res) => res.json())
        .then((json) => {
          this.users = json;
          this.view = "personalProfile"

        })
        .catch((err) => {
          console.log(err);
  
        })
       },

       getBody(json) {
        var body = [];
        for (var key in json) {
            var encKey = encodeURIComponent(key);
            var encVal = encodeURIComponent(json[key]);
            body.push(encKey + "=" + encVal);
        }
        return body.join("&");
    },
    

       login(){
     
        this.loginData.userName = document.getElementById('userName').value;
        this.loginData.password = document.getElementById('password').value;
      fetch("/api/login", {
              credentials: 'include',
              headers: {
                  'Content-Type': 'application/x-www-form-urlencoded'
              },
              method: 'POST',
              body: this.getBody(this.loginData)
          })
          .then(function (data) {
              console.log('Request success: ', data);
              if (data.status == 200) {
  
              } else {
                  alert("error login in")
              }
  
          })
          .catch(function (error) {
              console.log('Request failure: ', error);
          });
       }
     

  },
  mounted: function() {

  
  }

  

})