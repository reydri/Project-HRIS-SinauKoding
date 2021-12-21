package com.sinaukoding.absence.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinaukoding.absence.entity.Company;
import com.sinaukoding.absence.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("companies")
@PreAuthorize("permitAll()")
public class CompanyController extends BaseController {

    @Autowired
    private CompanyService service;
}
