var apiclient=apiclient;
var ciudad1 = null;
var apiprueba=(function() {
    var _map = function(list){
        console.info("En _Map")
        console.info(list)
        console.info(list.sedes)
        console.info(list.sedes.turnos)
        console.info(list.turnos)
        mapping1= list.sedes.map(function(sede){
            ciudad1=sede.ciudad
            }
        )
           return mapping= list.turnos.map(function(turno){
             return {
                 ciudad:ciudad1, sede:turno.turnosedeid, identificador:turno.identifier, tipo:turno.tipo,
                 modulo:turno.modulo, usuario:turno.turnouserid, fecha:turno.fecha

             };
             }
           )


           }
     var table = function(){
        console.info("En Table")
        apiclient.getTurnByEntity(createTable);
     }

    var createTable=function(turns) {
        console.info("En createTable")
        console.info(turns)
        console.info(turns.data)
             turns=_map(turns);
             $("#table > tbody").empty();
             turns.map(function(c){
                console.info("QUE DIABLOS ES C")
                console.info(c)
                 $("#table > tbody").append(
                     "<tr> <td>" +

                     c.ciudad+
                     "</td>" +
                     "<td>" +
                     c.sede +
                     "</td> " +
                     "<td>" +
                     c.identificador +
                     "</td> " +
                     "<td>" +
                     c.tipo +
                     "</td> " +
                     "<td>" +
                     c.modulo +
                     "</td> " +
                     "<td>" +
                     c.usuario +
                     "</td> " +
                     "<td>" +
                     c.fecha +
                     "</td> " +

                     "</tr>"
                 )
             });


         }

       return{

       createTable:createTable,
       table:table

       }




    })();