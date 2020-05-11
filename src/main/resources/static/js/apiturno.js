var apiclient=apiclient;
var apiturno=(function () {

    var _map=function(list){
     return mapping= list.map(function(turn){
        return { identifier: turn.identifier, tipo: turn.tipo, fecha: turn.fecha


            };
            }



     )}

     var table= function(){
     apiclient.getTurnByUser(createTable);
     }

     var createTable = function(turns){
      turns=_map(turns);
       $("#table > tbody").empty();
       turns.map(function(c){
     $("#table > tbody").append(
                     "<tr> <td>" +

                     c.identifier+
                     "</td>" +
                     "<td>" +
                     c.tipo +
                     "</td> " +
                     "<td>" +
                     c.fecha +
                     "</td> " +

                     "</tr>"
                 )
             });


         }

    return{

        table:table,
        createTable:createTable

        }



})();