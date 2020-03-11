var apimock = (function () {
    mockdata["sarah"]=[{"username":"sarah","password":"1234"}];

    return{
        getUser:function(username,password,callback){
        callback(
            mockdata[username,password]
            alert("entre");
          );
        }
    };
    }

})();