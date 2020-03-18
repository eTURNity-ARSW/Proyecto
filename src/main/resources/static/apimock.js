var apimock=(function () {
    var mockdata =[] ;
    mockdata["sarahvieda"]=[
        {
            username :"sarahvieda",
            password : "1234"

        }
    ]
    mockdata["julianagarzon"]=[
        {
            username: "julianagarzon",
            password :"1234"
        }
    ]

    mockdata["juangarcia"]=[
        {
            username :"juangarcia",
            password: "1234"
        }
    ]

    var login =(function (username,password) {
        if(username==mockdata[username].username){

        } else {
            console.log("No está registrado");
        }

    })

    return{

        login:login


    }

})();