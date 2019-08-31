var app = new Vue({
    el: '#app',
    data: {
      view: 'main',
           

    },

    methods: {
      changeView: function(view){
        this.view = view;
      }
    }
   
  })