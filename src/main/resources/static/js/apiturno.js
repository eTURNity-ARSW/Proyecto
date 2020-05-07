var apicli =apicli;
var apiturno=( function () {

    var _countryName;


    var _map= function (list) {
        return mapping=list.map(function (turn) {
                return {
                   identifier: turn.identifier, tipo: turn.tipo,turnosedeid:turn.turnosedeid
                };
            }

        )

    }

    var table= function () {
        apicli.getAllTurns(createTable);

    }


    var createTable=function (turns) {
        turns=_map(turns);
        $("#table > tbody").empty();
        turns.map(function(t){

            $("#table > tbody").append(
                "<tr> <td>" +

                t.identifier +
                "</td>" +
                "<td>" +
                t.tipo +
                "</td> " +
                "<td>" +
                t.turnosedeid +
                "</td> "+
                "</tr>"
            );
        });


    };








    return{
        createTable:createTable,
        table:table

    }

})();