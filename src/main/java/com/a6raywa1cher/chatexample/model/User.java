package com.a6raywa1cher.chatexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String username;

    private String password;
}
