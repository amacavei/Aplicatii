var mysql = require("mysql");

function REST_ROUTER(router, connection, md5) {
  var self = this;
  self.handleRoutes(router, connection, md5);
}

REST_ROUTER.prototype.handleRoutes = function(router, connection, md5) {
  router.get("/users", function(req, res) {
    var query = "SELECT * FROM ??";
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
