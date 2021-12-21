package com.sinaukoding.absence.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinaukoding.absence.entity.Division;
import com.sinaukoding.absence.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("divisions")
@PreAuthorize("permitAll()")
public class DivisionController extends BaseController {

    @Autowired
    private DivisionService service;
}
