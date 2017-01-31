package com.dissertation.project.web.controller;

import com.dissertation.project.jdbc.usersDBMapping.UsersDao;
import com.dissertation.project.jdbc.usersDBMapping.Users;
import io.swagger.annotations.Api;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(description = "users management API")

public class UserController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UsersDao usersDao;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody
    List<Users> userList(){
        logger.debug("get users list");
        return usersDao.findAll();
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public @ResponseBody Users getUser(@PathVariable Long userId){
        logger.debug("get user");
        return usersDao.findOne(userId);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public @ResponseBody Users saveUser(@RequestBody Users user){
        logger.debug("save user");
        usersDao.save(user);
        return user;
    }
}
