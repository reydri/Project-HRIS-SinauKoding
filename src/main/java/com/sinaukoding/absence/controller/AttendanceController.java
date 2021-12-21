package com.sinaukoding.absence.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinaukoding.absence.common.RestResult;
import com.sinaukoding.absence.common.StatusCode;
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

    @GetMapping
    public RestResult get(@RequestParam(value = "param", required = false) String param,
                          @RequestParam(value = "offset") int offset,
                          @RequestParam(value = "limit") int limit) throws JsonProcessingException {

        Attendance attendance = param != null ? new ObjectMapper().readValue(param, Attendance.class) : null;

        long rows = service.count(attendance);

        return new RestResult(rows > 0 ? service.find(attendance, offset, limit) : new ArrayList<>(), rows);
    }
}
