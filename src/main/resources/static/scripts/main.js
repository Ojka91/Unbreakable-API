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
    errorCreatingUser: false,


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


     getLastView(lastView){
        this.lastView = lastView;
     },

     back(){
       this.view = this.lastView;
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
            console.log('parsed json', json)
            app.getUsers();
          }).catch(function (ex) {
            console.log('parsing failed', ex)
            alert("error creating new user"+ ex);
            
          });
          this.view="profile";
        }else{
          this.errorCreatingUser = true;
        }
     }


  }

})