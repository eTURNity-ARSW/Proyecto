apiclient=(function(){
return {
        getTurnByUser:function(callback) {
            jQuery.get({
                dataType: "json",
                url:"/turno/turnos/julianagarzon",
                success :function(data)
                {callback(data)
                }
            });
        }
        }
})();