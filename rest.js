var mysql = require("mysql");

function REST_ROUTER(router, connection, md5) {
    var self = this;
    self.handleRoutes(router, connection, md5);
}

REST_ROUTER.prototype.handleRoutes = function (router, connection, md5) {
    router.post("/users", function (req, res) {
        var query;
        console.log(req.body);
        if (req.body.username && req.body.password) {
            query = "SELECT * FROM USERS WHERE login='" + req.body.username + "' AND password='" + req.body.password + "'";
        } else {
            query = "SELECT * FROM ??";
        }
        console.log(query);
        var table = ["users"];
        query = mysql.format(query, table);
        connection.query(query, function (err, rows) {
            if (err) {
                res.status(500).json({
                    "Error": true,
                    "Message": "Error executing MySQL query" + err
                });
            } else {
                res.status(200).json({
                    "Error": false,
                    "Message": "Success",
                    "Users": rows
                });
            }
        });
    });

    router.put("/users/:id", function (req, res) {
        var query = "UPDATE USERS SET first_name=?, family_name=?, login=?, password=?, e_mail=?, phone=?, language=?, enabled=?, isAdmin=? WHERE id=?";
        var table = [ req.body.first_name, req.body.family_name, req.body.login, req.body.password, req.body.e_mail, req.body.phone, req.body.language, req.body.enabled, req.body.isAdmin, parseInt(req.params.id)];
        query = mysql.format(query, table);
        console.log(query);
        connection.query(query, function (err, rows) {
            if (err) {
                res.status(500).json({
                    "Error": true,
                    "Message": "Error executing MySQL query" + err
                });
            } else {
                res.status(200).json({
                    "Error": false,
                    "Message": "Success",
                    "Users": rows
                });
            }
        });
    });

    router.put("/users", function (req, res) {
        var query = "insert into USERS (first_name, family_name, login, password, e_mail, phone, language, enabled, isAdmin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        var table = [ req.body.first_name, req.body.family_name, req.body.login, req.body.password, req.body.e_mail, req.body.phone, req.body.language, req.body.enabled, req.body.isAdmin, parseInt(req.params.id)];
        query = mysql.format(query, table);
        console.log(query);
        connection.query(query, function (err, rows) {
            if (err) {
                res.status(500).json({
                    "Error": true,
                    "Message": "Error executing MySQL query" + err
                });
            } else {
                res.status(200).json({
                    "Error": false,
                    "Message": "Success",
                    "Users": rows
                });
            }
        });
    });
};

// application ------------------------------------------------------------

module.exports = REST_ROUTER;
