package com.dissertation.project.web.controller;

import com.dissertation.project.persist.entity.User;
import com.dissertation.project.persist.repo.UserRepo;
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
    private UserRepo userRepo;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody
    List<User> userList(){
        logger.debug("get users list");
        return userRepo.findAll();
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable Long userId){
        logger.debug("get user");
        return userRepo.findOne(userId);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public @ResponseBody User saveUser(@RequestBody User user){
        logger.debug("save user");
        userRepo.save(user);
        return user;
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
    public @ResponseBody User updateUser(@RequestBody User user, @PathVariable("userId") Long userId){//@PathVariable("userId") Long userId, @RequestBody String email, @RequestBody String firstName, @RequestBody String phone) {
        User newUser = userRepo.findOne(userId);
            newUser.setEmail(user.getEmail());
            newUser.setFirstName(user.getFirstName());
            newUser.setPhone(user.getPhone());
            userRepo.save(newUser);
            return newUser;
    }
}
