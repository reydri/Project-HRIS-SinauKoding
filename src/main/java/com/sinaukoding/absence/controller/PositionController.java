package com.sinaukoding.absence.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinaukoding.absence.entity.Position;
import com.sinaukoding.absence.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("positions")
@PreAuthorize("permitAll()")
public class PositionController extends BaseController {

    @Autowired
    private PositionService service;
}
