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

    return{
        login : function (username,callback) {
            callback(mockdata[username]);

        }
    }


})();