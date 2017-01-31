package com.dissertation.project.web.controller;

import com.dissertation.project.jdbc.tokenDBMapping.TokenDao;
import com.dissertation.project.jdbc.tokenDBMapping.Tokens;
import com.dissertation.project.jdbc.usersDBMapping.Users;
import com.dissertation.project.jdbc.usersDBMapping.UsersDao;
import com.dissertation.project.security.SecurityUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(description = "Users management API")
public class SecurityController {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private TokenDao tokenDao;

    @RequestMapping(value = "/security/account", method = RequestMethod.GET)
    public @ResponseBody
    Users getUserAccount(){
        Users users = usersDao.findByLogin(SecurityUtils.getCurrentLogin());
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
