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
    }


  },

  methods: {
    changeView: function (view) {
      this.view = 'loading'

      if (view == "disciplines") {
        fetch('http://localhost:8080/api/disciplines', {
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
        fetch('http://localhost:8080/api/elements', {
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
        fetch('http://localhost:8080/api/users', {
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
        fetch('http://localhost:8080/api/getRoutine/calisthenics/all/1,2', {
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
        fetch('http://localhost:8080/api/getRoutine/calisthenics/all/3,4,5', {
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
        fetch('http://localhost:8080/api/getRoutine/calisthenics/all/5,6', {
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
      fetch('http://localhost:8080/api/users', {
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

      
        fetch('http://localhost:8080/api/users/'+userName, {
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
    


  }

})