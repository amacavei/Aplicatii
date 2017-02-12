package com.dissertation.project.web.controller;

import com.dissertation.project.model.User;
import com.dissertation.project.dao.UserDao;
import com.dissertation.project.security.SecurityUtils;
import com.dissertation.project.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(description = "Users management API")
public class SecurityController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/security/account", method = RequestMethod.GET)
    public @ResponseBody
    User getUserAccount(){
        User user = userService.findByLogin(SecurityUtils.getCurrentLogin());
        user.setPassword(null);
        return user;
    }
}
