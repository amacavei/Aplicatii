package com.dissertation.project.web.controller;

import com.dissertation.project.model.User;
import com.dissertation.project.dao.UserDao;
import com.dissertation.project.service.RoleService;
import com.dissertation.project.service.UserService;
import io.swagger.annotations.Api;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")

public class UserController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody
    List userList(){
        logger.debug("get users list");
        return userService.findAll();
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable String userId){
        logger.debug("get user");
        return userService.findById(userId);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public @ResponseBody User saveUser(@RequestBody User user){
        logger.debug("save user");
        userService.create(user);
        return user;
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
    public @ResponseBody User updateUser(@RequestBody User user, @PathVariable("userId") String userId){//@PathVariable("userId") Long userId, @RequestBody String email, @RequestBody String firstName, @RequestBody String phone) {
        User newUser = userService.findById(userId);
            newUser.setEmail(user.getEmail());
            newUser.setFirstName(user.getFirstName());
            newUser.setPhone(user.getPhone());
            newUser.setFamilyName(user.getFamilyName());
            userService.update(newUser);
            return newUser;
    }
}
