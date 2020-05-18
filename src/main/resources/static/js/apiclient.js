apiclient=(function(){
return {
        getTurnByUser:function(callback,username) {
            jQuery.get({
                dataType: "json",
                url:"/turno/turnos/" + username,
                success :function(data)
                {callback(data)
                }
            });
        },
        getAllEntity:function(callback){
            jQuery.get({
                dataType: "json",
                url: "/entidades/entities" ,
                success:function(data){
                callback(data)}
            });
        },
        getAllSedesByEntityAndCity:function(callback,entityName,city){
            jQuery.get({
                dataType: "json",
                url: "/sede/sedes/" + entityName + "/" + city,
                success:function(data){
                callback(data)}
            });
        },
          getSedesByEntity:function(callback,entityName){
                    jQuery.get({
                        dataType: "json",
                        url: "/sede/sedes/misedes/"+entityName ,
                        success:function(data){
                        callback(data)}
                    });
                },

        getTurnByEntity:function(callback,entityuser){
            jQuery.get({
                dataType: "json",
                url: "/entidades/entidad/"+entityuser ,
                success:function(data){
                callback(data)}
            });
        }
    }        
})();