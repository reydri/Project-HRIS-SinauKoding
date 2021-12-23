package com.sinaukoding.absence.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinaukoding.absence.common.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sinaukoding.absence.common.RestResult;
import com.sinaukoding.absence.entity.User;
import com.sinaukoding.absence.service.UserService;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public RestResult get(@RequestParam(value = "param", required = false) String param,
                          @RequestParam(value = "offset") int offset,
                          @RequestParam(value = "limit") int limit) throws JsonProcessingException {

        User user = param != null ? new ObjectMapper().readValue(param, User.class) : null;
        Long rows = service.count(user);

        return new RestResult(rows > 0 ? service.find(user, offset, limit) : new ArrayList<>(), rows);
    }

    @PutMapping
    public RestResult update(@RequestBody User user){
        user = service.update(user);

        return new RestResult(user, user != null ? StatusCode.UPDATE_SUCCESS : StatusCode.UPDATE_FAILED);
    }
}
