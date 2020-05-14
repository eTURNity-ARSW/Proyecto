var apiclient=apiclient;
var apiprueba=(function() {
    var _map = function(list){
           return mapping= list.map(function(turno){
             return {
                 nit:turno.nit, turnos:turno.turnos

             };
             }
           )


           }
     var table = function(){
     apiclient.getTurnByEntity(createTable);
     }

    var createTable=function(turns) {
             turns=_map(turns);
             $("#table > tbody").empty();
             turns.map(function(c){

                 $("#table2 > tbody").append(
                     "<tr> <td>" +

                     c.nit+
                     "</td>" +
                     "<td>" +
                     c.turnos +
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