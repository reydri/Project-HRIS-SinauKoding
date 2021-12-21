package com.sinaukoding.absence.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinaukoding.absence.entity.Attendance;
import com.sinaukoding.absence.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("attendances")
@PreAuthorize("permitAll()")
public class AttendanceController extends BaseController {

    @Autowired
    private AttendanceService service;
}
