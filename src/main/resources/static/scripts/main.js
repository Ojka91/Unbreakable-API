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
            this.disciplines = json;
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



     back(){
       this.view = 'menu';
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

        }, 5000);
     }


  }

})