

apicli = (function() {

    return {
        getUsuarios: function(usuarios, callback) {
            jQuery.get({
                dataType: "json",
                url: "/users",
                success: function (data) {
                    callback(data)
                }
            });
        },

        login: function(usuario,password,,callback){
            jQuery.get({
                        dataType: "json",
                        url: "/login",
                        success: function (data) {
                            callback(data)
                        }
                    });

        },

        getUserByUsername: function(username,callback){
                jQuery.get({
                                    dataType: "json",
                                    url: "/users/" +username,
                                    success: function (data) {
                                        callback(data)
                                    }
                                });

            },

        getUserByTurnos: function(turnos,callback){
          jQuery.get({
                                            dataType: "json",
                                            url: "/users/" +turnos,
                                            success: function (data) {
                                                callback(data)
                                            }
                                        });

                    },

        }


        getTurnos: function( turnos, callback) {

            jQuery.get({
                dataType: "json",
                url: "/turnos",
                success: function (data) {
                    callback(data)
                }
            });

        },

       getTurnsByUser: function(username,callback){

         jQuery.get({
                       dataType: "json",
                       url: "/turnos/" +username,
                       success: function (data) {
                           callback(data)
                       }
                   });

       },

       getTurnsByDate :function(date,callback){
        jQuery.get({
                              dataType: "json",
                              url: "/turnos/" +date,
                              success: function (data) {
                                  callback(data)
                              }
                          });
       }

       getTurnsBySede: function(sede,callback){
            jQuery.get({
                                     dataType: "json",
                                     url: "/turnos/" +sede,
                                     success: function (data) {
                                         callback(data)
                                     }
                                 });
              }
       }

}})();
