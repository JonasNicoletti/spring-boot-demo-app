package com.sjnao.springbootdemoapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.openapitools.api.UsersApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiImpl implements UsersApi {

    public ResponseEntity<List<String>> usersGet() {
        final List<String> users = new ArrayList<>();
        users.add("sjnao");
        return ResponseEntity.ok(users);

    }

}
