var entidades=(function(){
    
    var mostrarEditar=function(){
        entidades.getEntidad(imprimirEntidades,id,"todo");
        estado="Admin";
    }

    var imprimirEntidades=function(entidad,id){
        $("#editarEntidades div").remove();

        entidad.map(function(entidad){
            var nit = "<input class=\"inputtype\" id=\"nit\" type=\"text\" placeholder=\""+entidad.nit+"\"/>";
            var nombre = "<input class=\"inputtype\" id=\"nom\" type=\"text\" placeholder=\""+entidad.nombre+"\"/>";
            var direccion = "<input class=\"inputtype\" id=\"dir\" type=\"text\" placeholder=\""+entidad.direccion+"\"/>";
            var ciudad = "<input class=\"inputtype\" id=\"ciudad\" type=\"text\" placeholder=\""+entidad.ciudad+"\"/>";
            var telefono = "<input class=\"inputtype\" id=\"tel\" type=\"text\" placeholder=\""+entidad.telefono+"\"/>";
            var conte = "<div class=\"wrapper\">"+nit+bot+nombre+direccion+ciudad+telefono+bot+"</div>";
            var bot = "<a href=\"home.html\"</a></div>";
            $("#editarEntidades").append(conte)
        })
    
}
    return{
        mostrarEditar:mostrarEditar,
        imprimirEntidades:imprimirEntidades
    };

})();

