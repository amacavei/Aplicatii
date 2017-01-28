package com.dissertation.project.web.controller;

import com.dissertation.project.jdbc.usersDBMapping.UserDao;
import com.dissertation.project.jdbc.usersDBMapping.Users;
import io.swagger.annotations.Api;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "users management API")

public class UserController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody
    List<Users> userList(){
        logger.debug("get users list");
        return userDao.findAll();
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public @ResponseBody Users getUser(@PathVariable Long userId){
        logger.debug("get user");
        return userDao.findOne(userId);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public @ResponseBody Users saveUser(@RequestBody Users user){
        logger.debug("save user");
        userDao.save(user);
        return user;
    }
}
