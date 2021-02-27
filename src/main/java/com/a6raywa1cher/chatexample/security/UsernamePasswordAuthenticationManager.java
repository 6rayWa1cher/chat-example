package com.a6raywa1cher.chatexample.security;

import com.a6raywa1cher.chatexample.model.User;
import com.a6raywa1cher.chatexample.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class UsernamePasswordAuthenticationManager implements AuthenticationManager {
    private final UserService userService;

    public UsernamePasswordAuthenticationManager(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        Optional<User> byUsername = userService.getByUsername((String) token.getPrincipal());
        if (byUsername.isEmpty()) {
            throw new BadCredentialsException("User not exists or incorrect password");
        }
        User user = byUsername.get();
        if (!user.getPassword().equals(token.getCredentials())) {
            throw new BadCredentialsException("User not exists or incorrect password");
        }
        return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), Set.of(
                new SimpleGrantedAuthority("ROLE_USER")
        ));
    }
}
