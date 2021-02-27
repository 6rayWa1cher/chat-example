package com.a6raywa1cher.chatexample.service;

import com.a6raywa1cher.chatexample.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getByUsername(String username);
}
