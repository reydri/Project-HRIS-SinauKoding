package com.sinaukoding.absence.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinaukoding.absence.entity.Employee;
import com.sinaukoding.absence.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("employees")
@PreAuthorize("permitAll()")
public class EmployeeController extends BaseController {

    @Autowired
    private EmployeeService service;
}
