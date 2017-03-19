var mysql = require("mysql");

function REST_ROUTER(router, connection, md5) {
  var self = this;
  self.handleRoutes(router, connection, md5);
}

REST_ROUTER.prototype.handleRoutes = function(router, connection, md5) {
  router.post("/users", function(req, res) {
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
    connection.query(query, function(err, rows) {
      if (err) {
        res.json({
          "Error": true,
          "Message": "Error executing MySQL query"
        });
      } else {
        res.json({
          "Error": false,
          "Message": "Success",
          "Users": rows
        });
      }
    });
  });

  router.get("/users/:id", function(req, res) {
    var query = "SELECT * FROM ?? WHERE ??=?";
    var table = ["users", "id", req.params.id];
    query = mysql.format(query, table);
    connection.query(query, function(err, rows) {
      if (err) {
        res.json({
          "Error": true,
          "Message": "Error executing MySQL query"
        });
      } else {
        res.json({
          "Error": false,
          "Message": "Success",
          "Users": rows
        });
      }
    });
  });
}

// application ------------------------------------------------------------

module.exports = REST_ROUTER;
