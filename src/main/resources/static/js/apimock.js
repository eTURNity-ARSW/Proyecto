var apiclient = apiclient;
var apimock = (function () {
    var _map = function (turns) {
        return mapping = turns.map(function (turn) {
            return {
                nSede:turn.sede.nombre, nEntidad:turn.entidad.nombre,
                ciudad:turn.sede.ciudad,identifier:turn.identifier, turno:turn.id, tipo:turn.tipo,
                modulo:turn.modulo, fecha:turn.fecha, activo:turn.valido
            }
        }
        )
    }
    var table = function () {
        apiclient.getTurnByUser(createTable, localStorage.getItem('Actual'));
    }

    var _mapEntidad=function(entities) {
          return { eNombre:entities.nombre
                    }
    }


    var entityMenu=function(entities){
           entities=_mapEntidad(entities);

           }
    var createTable = function (turns) {
        turns = _map(turns);
        $("#table > tbody").empty();
        turns.map(function (c) {
            var idturno = '"' + String(c.identifier) + '"';
            $("#table > tbody").append(
                    "<tr> <td>" +
                    c.nEntidad +
                    "</td>" +
                    "<td>" +
                    c.ciudad +
                    "</td> " +
                    "<td>" +
                    c.nSede +
                    "</td> " +
                    "<td>" +
                    c.turno +
                    "</td> " +
                    "<td>" +
                    c.tipo +
                    "</td> " +
                    "<td>" +
                    c.modulo +
                    "</td> " +
                    "<td>" +
                    c.fecha +
                    "</td> " +
                    "<td>" +
                    c.activo +
                    "</td> " +
                     "<td ><button onclick='apimock.deleteTurn("+ idturno +")'>cancelar </button></td>"
                     +
                    "</tr>"

                    )
        });
    }

    var deleteTurn= function(idturn){

        console.log(idturn);
        axios.delete('/turno/turnodeleted/'+ localStorage.getItem('Actual') + '/' + idturn);
        }



    var _map2 = function (entidad) {
        var ciudad1 = null;
        var nombre1 = null;
        return mappeo = entidad.sedes.map(function (sede) {
            ciudad1 = sede.ciudad
            nombre1 = sede.nombre
            return sede.turnos.map(function (turno) {
                return {
                    id: turno.identifier, ciudad: ciudad1, nombre: nombre1, sede: turno.turnosedeid, identificador: turno.id, tipo: turno.tipo,
                    modulo: turno.modulo, usuario: turno.turnouserid, fecha: turno.fecha
                }
            })
        })
    }

    var table2 = function () {
        apiclient.getTurnByEntity(createTable2, localStorage.getItem('ActualEntity'));

    }
    var createTable2 = function (turns) {
        turns = _map2(turns);
        $("#table > tbody").empty();
        turns.map(function (turno) {
            turno.map(function (c) {
            var idturno = '"' + String(c.id) + '"';
            var user = '"' + String(c.usuario) + '"';
                $("#table > tbody").append(
                        "<tr> <td>" +
                        c.ciudad +
                        "</td>" +
                        "<td>" +
                        c.nombre +
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
                         user +
                        "</td> " +
                        "<td>" +
                        c.fecha +
                        "</td> " +
                        "<td ><button onclick='apimock.deleteTurnEntity(" + user +','+ idturno + ")'>cancelar </button></td>" +
                        "</tr>"
                        )
            })
        });

    }

    var deleteTurnEntity=function(username,idturn){
    console.log('/turno/turnodeleted/'+ username + '/' + idturn);
    axios.delete('/turno/turnodeleted/'+ username + '/' + idturn);
    }

    var loadSelect = function () {
        console.log(localStorage.getItem('Actual'));
        document.getElementById("cCiudad").disabled = true;
        document.getElementById("cSede").disabled = true;
        console.log("Entre")
        apiclient.getAllEntity(loadSelectEntity);
        //apiclient.getTurnByEntity(createTable2, localStorage.getItem('ActualEntity'));
    }
        var _map3=function(misede){
            return mapsede=misede.map(function(lasede){
                return{
                    identificador: lasede.identificador, nombre:lasede.nombre, ciudad:lasede.ciudad,
                    direccion:lasede.direccion, horario:lasede.horario
                    }

                     })

            }


        var createTable3 = function (lassedes) {
                lassedes = _map3(lassedes);
                $("#table > tbody").empty();
                lassedes.map(function (c) {
                    $("#table > tbody").append(
                            "<tr> <td>" +
                            c.identificador +
                            "</td>" +
                            "<td>" +
                            c.nombre +
                            "</td> " +
                            "<td>" +
                            c.ciudad +
                            "</td> " +
                            "<td>" +
                            c.direccion +
                            "</td> " +
                            "<td>" +
                            c.horario +
                            "</td> " +

                            "</tr>"
                            )
                });
            }
        var table3 =function(){
            apiclient.getSedesByEntity(createTable3,localStorage.getItem('ActualEntity'));
            }

    var _mapE = function (entities) {
        return mapping = entities.map(function (entity) {
            return {
                nombre: entity.nombre
            }
        }
        )
    }

    var loadSelectEntity = function (entities) {
        entities = _mapE(entities);
        $("#cEntidad").empty();
        entities.map(function (c) {
            $("#cEntidad").append(new Option(c.nombre, entities.indexOf(c)));
        });
    }

    var loadCiudad = function () {
        document.getElementById("cCiudad").disabled = false;
        apiclient.getTurnByEntity(loadSelectCity,$("#cEntidad :selected").text());
    }

    var loadSelectCity = function (entities) {
        cities = _mapC(entities);
        $("#cCiudad").empty();
        cities.map(function (c) {
            $("#cCiudad").append(new Option(c.nombre, cities.indexOf(c)));
        });
    }

    var _mapC = function (city) {
        return mapping = city.sedes.map(function (sedes) {
            return {
                nombre: sedes.ciudad
            }
        }
        )
    }

    var loadSede = function () {
        document.getElementById("cSede").disabled = false;
        console.log("EntreACargarLaSede")
        apiclient.getAllSedesByEntityAndCity(loadSelectSedes,$("#cEntidad :selected").text(),$("#cCiudad :selected").text());
    }

    var loadSelectSedes = function (sedes) {
        sedes = _mapS(sedes);
        $("#cSede").empty();
        sedes.map(function (c) {
            $("#cSede").append(new Option(c.nombre, cities.indexOf(c)));
        });
    }

    var _mapS = function (sedes) {
        return mapping = sedes.map(function (sede) {
            return {
                nombre: sede.nombre
            }
        }
        )
    }

    var mockdata = [];
    mockdata["sarahvieda"] =
            {
                username: "sarahvieda",
                password: "1234"

            }

    mockdata["julianagarzon"] =
            {
                username: "julianagarzon",
                password: "1234"
            }


    mockdata["juangarcia"] =
            {
                username: "juangarcia",
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

    function addEntity() {
        var empty = false;
        if (document.getElementById("nit").value === '') {
            empty = true;
            alert("Ingrese nit");
        }
        if (document.getElementById("nombre").value === '') {
            empty = true;
            alert("Ingrese nit");
        }
        if (document.getElementById("direccion").value === '') {
            empty = true;
            alert("Ingrese nit");
        }

        if (document.getElementById("ciudad").value === '') {
            empty = true;
            alert("Ingrese nit");
        }

        if (document.getElementById("telefono").value === '') {
            empty = true;
            alert("Ingrese nit");
        }

        if (!empty) {
            axios.post('/entidades/entidadcre', {
                "1": {nit: document.getElementById("nit").value,
                    nombre: document.getElementById("nombre").value,
                    direccion: document.getElementById("direccion").value,
                    ciudad: document.getElementById("ciudad").value,
                    telefono: document.getElementById("telefono").value

                }})
                    .then(function (input) {
                        console.log(input.data);
                        var message = ["Registro exitoso", "entidad registado"];
                        var next = "entidadLogin.html";
                        alert(message[1]);
                    })
        } else {
            alert("error");
        }
    }
        function addSede() {
            var empty = false;

            if (document.getElementById("nombre").value === '') {
                empty = true;
                alert("Ingrese nombre de la sede");
            }
            if (document.getElementById("ciudad").value === '') {
                empty = true;
                alert("Ingrese la ciudad");
            }
            if (document.getElementById("direccion").value === '') {
                empty = true;
                alert("Ingrese la direccion");
            }

            if (document.getElementById("horario").value === '') {
                empty = true;
                alert("Ingrese el horario");
            }

            if (document.getElementById("nit").value === '') {
                empty = true;
                alert("Ingrese el nit de la entidad");
            }

            if (!empty) {
                axios.post('/sede', {
                    "1": {
                         ciudad: document.getElementById("ciudad").value,
                         direccion: document.getElementById("direccion").value,
                         horario: document.getElementById("horario").value,
                         entidad: document.getElementById("nit").value,
                         nombre: document.getElementById("nombre").value



                    }})
                        .then(function (input) {
                            console.log(input.data);
                            var message = ["Registro exitoso", "entidad registado"];
                            var next = "entidadLogin.html";
                            alert(message[1]);
                        })
            } else {
                alert("error");
            }
        }
    function addUser() {
        var empty = false;
        if (document.getElementById("nombre").value === '') {
            empty = true;
            alert = 'Ingrese su nombre'
        }

        if (document.getElementById("usuario").value === '') {
            empty = true;
            alert = 'Ingrese su usuario'
        }
        if (document.getElementById("password").value === '') {
            empty = true;
            alert = 'Ingrese su contraseña'
        }
        if (document.getElementById("cedula").value === '') {
            empty = true;
            alert = 'Ingrese su cedula'
        }
        if (document.getElementById("correo").value === '') {
            empty = true;
            alert = 'Ingrese su correo'
        }

        if (!empty) {
            axios.post('/usuario/login/', {
                "1": {username: document.getElementById("usuario").value,
                    nombre: document.getElementById("nombre").value,
                    correo: document.getElementById("correo").value,
                    documento: document.getElementById("cedula").value,
                    contrasena: document.getElementById("password").value


                }
            })
                    .then(function (input) {
                        console.log(input.data);
                        var message = ["Registro exitoso", "usuario registado"];
                        var next = "login.html";
                        alert(message[1]);
                    })
        } else {
            alert("error");
        }
    }

    async function addTurn() {
        var empty = false;
        if (document.getElementById("cEntidad").value === '') {
            empty = true;
            alert = 'Ingrese la entidad'
        }
        if (document.getElementById("cCiudad").value === '') {
            empty = true;
            alert = 'Ingrese la ciudad'
        }
        if (document.getElementById("cSede").value === '') {
            empty = true;
            alert = 'Ingrese la sede'
        }
        if (document.getElementById("cTipo").value === '') {
            empty = true;
            alert = 'Ingrese el tipo'
        }
        console.log(document.getElementById("date").value)
        if (!empty) {
            var response = await axios.get('/sede/'+ $("#cEntidad :selected").text() + '/' + $("#cCiudad :selected").text() + '/' + $("#cSede :selected").text() )
            console.log(localStorage.getItem('Actual'))
            axios.post('/turno/turnocre/', {
                "1": {tipo: $("#cTipo :selected").text(),
                    fecha: document.getElementById("date").value,
                    turnouserid: localStorage.getItem('Actual'),
                    turnosedeid: response.data.identificador
                }
            })
                    .then(function (input) {
                        console.log(input.data);
                        var message = ["Registro exitoso", "turno registado"];
                        var next = "login.html";
                        alert(message[1]);
                    })
            console.log($("#cTipo :selected").text());
            console.log(document.getElementById("date").value);
            console.log(localStorage.getItem('Actual'));
            console.log(response.data.identificador);
            var turnoWebSocket = new TurnoWs($("#cTipo :selected").text(),document.getElementById("date").value,localStorage.getItem('Actual'),response.data.identificador);
            console.log(turnoWebSocket);
            sendRequest("newTurn",turnoWebSocket);

        } else {
            alert("error");
        }
    }
    function iniciarLocalStorageUser(username) {
        localStorage.setItem('Actual', username);

    }

    function iniciarLocalStorageEntity(nombre) {
        localStorage.setItem('ActualEntity', nombre);
    }

    function cerrarSesion(){
        localStorage.clear();
    }



    function logIn() {
        var vacio = false;
        if (document.getElementById("login").value === '') {
            vacio = true;
            alert("no ingresó su usario");
        }
        if (document.getElementById("password").value === '') {
            vacio = true;
            alert("no ingresó su contraseña");

        }

        if (!vacio) {
            axios.get('/usuario/users/' + document.getElementById("login").value)
                    .then(function (input) {
                        if (input.data["contrasena"] === document.getElementById("password").value) {
                            iniciarLocalStorageUser(document.getElementById("login").value);
                            console.log(localStorage.getItem('Actual'));
                            location.href = "home.html";
                        } else {

                            alert("Incorrecto");
                        }


                    })
                    .catch(function (input) {
                        alert("Incorrecto")
                    })
        }
    }
    function logInEntidad() {
        var vacio = false;
        if (document.getElementById("nit").value === '') {
            vacio = true;
            alert("no ingresó su nit");
        }
        if (document.getElementById("nombre").value === '') {
            vacio = true;
            alert("no ingresó su nombre");

        }

        if (!vacio) {
            axios.get('/entidades/entidad/' + document.getElementById("nombre").value)
                    .then(function (input) {

                        if (input.data["nit"] === document.getElementById("nit").value) {
                            iniciarLocalStorageEntity(document.getElementById("nombre").value);
                            location.href = "homeBanco.html";
                        } else {

                            alert("Incorrecto");
                        }


                    })
                    .catch(function (input) {
                        alert("Incorrecto")
                    })
        }
    }
    class TurnoWs{
        constructor(tipo, fecha,  turnouserid, turnosedeid){
            this.tipo = tipo;
            this. fecha = fecha;
            this. turnouserid = turnouserid;
            this.turnosedeid = turnosedeid;
        }
    }
    return{
        validate: validate,
        logIn: logIn,
        addUser: addUser,
        addEntity: addEntity,
        addSede:addSede,
        logInEntidad:logInEntidad,
        table: table,
        createTable: createTable,
        table2: table2,
        createTable2: createTable2,
        loadSelect: loadSelect,
        loadCiudad: loadCiudad,
        loadSede: loadSede,
        addTurn: addTurn,
        table3:table3,
        createTable3:createTable3,
        deleteTurn:deleteTurn,
        cerrarSesion:cerrarSesion,
        deleteTurnEntity:deleteTurnEntity
    }



})();