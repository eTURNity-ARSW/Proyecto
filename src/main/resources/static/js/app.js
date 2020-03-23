var app =(function () {
    var _username;

    var login = function (username) {
        if (username == null || username == "") {
            alert("invalid");
        } else {
            apimock.login(username,null);

        }

    }
    return {
      login:login
    };
})();
