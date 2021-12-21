package com.sinaukoding.absence.controller;

import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("isFullyAuthenticated()")
public abstract class BaseController {
}
