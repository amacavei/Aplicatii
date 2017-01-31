package com.dissertation.project.security;

import com.dissertation.project.jdbc.rolesDBMapping.Roles;
import com.dissertation.project.jdbc.usersDBMapping.UsersDao;
import com.dissertation.project.jdbc.usersDBMapping.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Authenticate a user from the database.
 */
@Service
@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    @Autowired
    private UsersDao userRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating {}", login);

        Users user = userRepo.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User " + login + " was not found in the database");
        } else if (!user.getEnabled()) {
            throw new UserNotEnabledException("User " + login + " was not enabled");
        }

        Collection<GrantedAuthority> grantedRoles = new ArrayList<GrantedAuthority>();
        for (Roles role : user.getRoles()) {
            GrantedAuthority grantedRole = new SimpleGrantedAuthority(role.getName());
            grantedRoles.add(grantedRole);
        }

        return new org.springframework.security.core.userdetails.User(login, user.getPassword(),
                grantedRoles);
    }
}
