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
        getTurnByEntity:function(callback){
            jQuery.get({
                dataType: "json",
                url: "/entidades/entidad/Bancolombia" ,
                success:function(data){
                callback(data)}
            });
            }
        }
})();