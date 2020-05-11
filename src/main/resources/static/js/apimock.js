var apimock=(function () {
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
            localStorage.setItem('Actual', nombre);
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
                    location.href="menuEntidad.html";
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
        logInEntidad:logInEntidad

        }



})();