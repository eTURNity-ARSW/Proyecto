apiClient= (function(){
    return {

        validarContra: function(username,callback){
            jQuery.ajax({
                url: "usuario/" + username ,
                success: function(result) {
                    callback(result);
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert("Usuario no encontrado");

                } ,
                async: true
            });
        }
    };
})();