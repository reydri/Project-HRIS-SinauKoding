package com.sinaukoding.absence.controller;

import com.sinaukoding.absence.common.RestResult;
import com.sinaukoding.absence.entity.User;
import com.sinaukoding.absence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@PreAuthorize("permitAll()")
public class AuthController extends BaseController {

    @Autowired
    private UserService service;

    @PostMapping(value = "do-login")
    public RestResult doLogin(@RequestBody User user){
        return service.login(user);
    }

    @PostMapping(value = "do-register")
    public RestResult register(@RequestBody User param){
        return new RestResult(service.register(param, User.Role.ROLE_USER));
    }
}
