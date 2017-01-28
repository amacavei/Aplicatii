package com.dissertation.project.web.controller;

import com.dissertation.project.jdbc.tokenDBMapping.TokenDao;
import com.dissertation.project.jdbc.tokenDBMapping.Tokens;
import com.dissertation.project.jdbc.usersDBMapping.UserDao;
import com.dissertation.project.jdbc.usersDBMapping.Users;
import com.dissertation.project.security.SecurityUtils;
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
    private UserDao userDao;

    @Autowired
    private TokenDao tokenDao;

    @RequestMapping(value = "/security/account", method = RequestMethod.GET)
    public @ResponseBody
    Users getUserAccount(){
        Users users = userDao.findByLogin(SecurityUtils.getCurrentLogin());
        users.setPassword(null);
        return users;
    }

    @PreAuthorize("hasAuthority('admin')")
    @RequestMapping(value = "/security/tokens", method = RequestMethod.GET)
    public @ResponseBody
    List<Tokens> getTokens(){
        List<Tokens> tokens = tokenDao.findAll();
        for(Tokens t:tokens){
            t.setSeries(null);
            t.setValue(null);
        }
        return tokens;
    }
}
