

apicli = (function() {

    return {
        getUsuarios: function(author, callback) {
            jQuery.get({
                dataType: "json",
                url: "/usuarios",
                success: function (data) {
                    callback(data)
                }
            });
        },
        getTurnos: function( turnos, callback) {

            jQuery.get({
                dataType: "json",
                url: "/turnos",
                success: function (data) {
                    callback(data)
                }
            });

        },
        getEntidades: function( entidad, callback) {

            jQuery.get({
                dataType: "json",
                url: "/entidades",
                success: function (data) {
                    callback(data)
                }
            });

    }
}})();
