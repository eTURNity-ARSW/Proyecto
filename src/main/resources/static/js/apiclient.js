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
        }
        }
})();