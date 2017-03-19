var express = require("express");
var mysql = require("mysql");
var bodyParser = require("body-parser");
var md5 = require('MD5');
var rest = require("./REST.js");
var app = express();

function REST() {
  var self = this;
  self.connectMysql();
};

REST.prototype.connectMysql = function() {
  var self = this;
  var pool = mysql.createPool({
    connectionLimit: 100,
    host: 'localhost',
    user: 'root',
    password: 'root',
    database: 'mydb',
    debug: false
  });
  pool.getConnection(function(err, connection) {
    if (err) {
      self.stop(err);
    } else {
      self.configureExpress(connection);
    }
  });
}

REST.prototype.configureExpress = function(connection) {

  app.use('/components', express.static(__dirname + '/webapp/components'));
  app.use('/vendor', express.static(__dirname + '/webapp/vendor'));
  app.use('/bower_components', express.static(__dirname + '/bower_components'));
  app.use('/app.js', express.static(__dirname + '/webapp/app.js'));
  app.use('/constants.js', express.static(__dirname + '/webapp/constants.js'));

  app.all('/', function(req, res, next) {
    // Just send the index.html for other files to support HTML5Mode
    res.sendFile('/webapp/index.html', {
      root: __dirname
    });
  });
  var self = this;
  app.use(bodyParser.urlencoded({
    extended: true
  }));
  app.use(bodyParser.json());
  var router = express.Router();
  app.use('/api', router);
  var rest_router = new rest(router, connection, md5);
  self.startServer();
}

REST.prototype.startServer = function() {
  app.listen(3000, function() {
    console.log("All right ! I am alive at Port 3000.");
  });
}

REST.prototype.stop = function(err) {
  console.log("ISSUE WITH MYSQL n" + err);
  process.exit(1);
}

new REST();
