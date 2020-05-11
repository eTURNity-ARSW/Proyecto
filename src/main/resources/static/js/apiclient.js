apiclient=(function(){
return {
        getTurnByUser:function(callback) {
            jQuery.get({
                dataType: "json",
                url:"/turno/turnos/julianagarzon"
                succes :function(data)
                {callback(data)
                }
            });
        }
        }
})();