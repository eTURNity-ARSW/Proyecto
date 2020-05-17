/*var appcontroller= (function(){

    var stompClient=null;

    var connectAndSuscribe=function(){
        console.info('Connecting to Eturnity...');
        var socket = new SockJS('/et');
        stompClient = Stomp.over(socket);
        stompClient.connect({},function(frame){
            console.log('Connected: '+frame);
            stompClient.suscribe("/topic/turnos")
        })
    }








}*/
