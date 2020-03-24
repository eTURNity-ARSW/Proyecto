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

    function add() {
        var username = document.getElementById("usuario").value;

        var password = document.getElementById("password").value;

        mockdata=mockdata[username];
        mockdata.push({username,password});


    }
    return{
        validate:validate,
        add:add

        }



})();