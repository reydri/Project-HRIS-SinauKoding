package com.sinaukoding.absence.controller;

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
}
