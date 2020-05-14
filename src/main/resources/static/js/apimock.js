var apiclient=apiclient;
var ciudad1=null;
var apimock=(function () {
     var _map=function(list){
         return mapping= list.map(function(turn){
            return { identifier: turn.identifier, tipo: turn.tipo, fecha: turn.fecha


                };
                }



         )}
     var table= function(){
         apiclient.getTurnByUser(createTable,localStorage.getItem('Actual'));
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


    var _map2 = function(lista){
        mapping1=lista.sedes.map(function(sede){
            ciudad1=sede.ciudad
            }
    )
        return mappeo =lista.turnos.map(function(turno){
               return {
                    ciudad:ciudad1, sede:turno.turnosedeid, identificador:turno.identifier, tipo:turno.tipo,
                    modulo:turno.modulo, usuario:turno.turnouserid, fecha:turno.fecha

               };

                })
    }


    var table2= function(){
        apiclient.getTurnByEntity(createTable2,localStorage.getItem('ActualEntity'));
        }

    var createTable2=function(turns) {
            console.info("En createTable")
            console.info(turns)
            console.info(turns.data)
                 turns=_map2(turns);
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
    var mockdata =[] ;
    mockdata["sarahvieda"] =
        {
            username :"sarahvieda",
            password : "1234"

        }

    mockdata["julianagarzon"] =
        {
            username: "julianagarzon",
            password :"1234"
        }


    mockdata["juangarcia"] =
        {
            username :"juangarcia",
            password: "1234"
        }


    function validate() {

        var username = document.getElementById("login").value;

        var password = document.getElementById("password").value;
        if (username === mockdata[username].username && password === mockdata[username].password) {
            alert("Login successfully");
            window.location = "home.html"; // Redirecting to other page.
            return false;
        } else {
            alert("Usted no se encuentra registrado ");
            window.location = "registro.html";

        }
    }

    function addEntity(){
    var empty=false;
    if(document.getElementById("nit").value === ''){
    empty=true;
    alert("Ingrese nit");
   }
    if(document.getElementById("nombre").value === ''){
       empty=true;
       alert("Ingrese nit");
      }
    if(document.getElementById("direccion").value === ''){
         empty=true;
         alert("Ingrese nit");
     }

    if(document.getElementById("ciudad").value === ''){
         empty=true;
         alert("Ingrese nit");
     }

    if(document.getElementById("telefono").value === ''){
         empty=true;
         alert("Ingrese nit");
     }

    if(!empty){
    axios.post('/entidades/entidadcre', {
    "1": {nit:document.getElementById("nit").value,
          nombre:document.getElementById("nombre").value,
          direccion:document.getElementById("direccion").value,
          ciudad:document.getElementById("ciudad").value,
          telefono:document.getElementById("telefono").value

    }})
       .then(function(input){
                   console.log(input.data);
                   var message =["Registro exitoso","entidad registado"];
                   var next ="entidadLogin.html";
                   alert(message[1]);
                   })
               }else{
                   alert("error");
               }
       }

    function addUser() {
    var empty=false;
    if(document.getElementById("nombre").value === ''){
        empty=true;
        alert= 'Ingrese su nombre'
        }

     if(document.getElementById("usuario").value === ''){
              empty=true;
              alert= 'Ingrese su usuario'
      }
     if(document.getElementById("password").value === ''){
              empty=true;
              alert= 'Ingrese su contraseña'
     }
     if(document.getElementById("cedula").value === ''){
            empty=true;
            alert= 'Ingrese su cedula'
            }
      if(document.getElementById("correo").value === ''){
             empty=true;
             alert= 'Ingrese su correo'
      }

      if(!empty){
        axios.post('/usuario/login/',{
        "1": {username:document.getElementById("usuario").value,
             nombre :document.getElementById("nombre").value,
             correo :document.getElementById("correo").value,
             documento: document.getElementById("cedula").value,
             contrasena:document.getElementById("password").value


             }
        })
            .then(function(input){
                console.log(input.data);
                var message =["Registro exitoso","usuario registado"];
                var next ="login.html";
                alert(message[1]);
                })
            }else{
                alert("error");
            }
    }
    function iniciarLocalStorageUser(username) {
        localStorage.setItem('Actual', username);

    }

     function iniciarLocalStorageEntity(nombre) {
            localStorage.setItem('ActualEntity', nombre);
        }

    function logIn(){
        var vacio=false;
        if(document.getElementById("login").value === ''){
        vacio=true;
        alert("no ingresó su usario");
        }
        if(document.getElementById("password").value === ''){
        vacio=true;
        alert("no ingresó su contraseña");

        }

        if(!vacio){
        axios.get('/usuario/users/' +document.getElementById("login").value)
            .then(function(input) {
                if(input.data["contrasena"]=== document.getElementById("password").value){
                iniciarLocalStorageUser(document.getElementById("login").value);
                location.href="home.html";
                } else{

                    alert("Incorrecto");
                    }


                })
            .catch(function(input){
            alert("Incorrecto")
            })
        }
    }
        function logInEntidad(){
            var vacio=false;
            if(document.getElementById("nit").value === ''){
            vacio=true;
            alert("no ingresó su nit");
            }
            if(document.getElementById("nombre").value === ''){
            vacio=true;
            alert("no ingresó su nombre");

            }

            if(!vacio){
            axios.get('/entidades/entidad/' +document.getElementById("nombre").value)
                .then(function(input) {

                    if(input.data["nit"]=== document.getElementById("nit").value){
                    iniciarLocalStorageEntity(document.getElementById("nombre").value);
                    location.href="turnoBanco.html";
                    } else{

                        alert("Incorrecto");
                        }


                    })
                .catch(function(input){
                alert("Incorrecto")
                })
            }
        }


    return{
        validate:validate,
        logIn:logIn,
        addUser:addUser,
        addEntity:addEntity ,
        logInEntidad:logInEntidad,
        table:table,
        createTable:createTable,
        table2:table2,
        createTable2:createTable2

        }



})();