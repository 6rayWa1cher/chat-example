package com.a6raywa1cher.chatexample.service.impl;

import com.a6raywa1cher.chatexample.model.User;
import com.a6raywa1cher.chatexample.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final List<User> userList;

    public UserServiceImpl() {
        this.userList = List.of(
                new User("cat", "1"),
                new User("dog", "2"),
                new User("rat", "3")
        );
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userList.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }
}
