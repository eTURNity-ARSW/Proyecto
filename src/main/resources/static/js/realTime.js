var stompClient = null;

function connect() {
    var socket = new SockJS('/et');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/turn', function (response) {
            console.log("----------------------------------------------------------------------------");
            console.log(response);
            console.log("----------------------------------------------------------------------------");
            showMessage(JSON.parse(response.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}

async function sendRequest(funcion,data) {
    console.log(funcion);
    console.log("Enviando solicitud...");
    await stompClient.send("/topic/turn", {}, JSON.stringify(data));
}

function showMessage(message) {
    console.log("Recibiendo Solicitud...");

    console.log('Mensaje guardado ');
    console.log(message);
    alert("Se ha creado un nuevo turno")
    apimock.table2();
}

$(function () {
    console.log(">>> Servidor Sincronizado...");
    $("form").on('submit', function (e) {
        console.log("Entre en el del FORM  En REALTIME");
        console.log(e);
        e.preventDefault();
    });
    console.log("Antes de Connect En REALTIME");
    connect();
    console.log("Despues de Connect En REALTIME");
    //$( "#connect" ).click(function() { connect(); });
    //$( "#disconnect" ).click(function() { disconnect(); });
    console.log("Antes del send En REALTIME");
    $("#send").click(function () { sendRequest("tabla prueba2 2"); });
    console.log("Despues del Send  En REALTIME");
});