package com.tupperware.auto.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController  {
    public final static Logger log = LoggerFactory.getLogger(LoginController.class);
    @ApiIgnore
    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String login() {
        return "admin/login";
    }
    @ApiIgnore
    @RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
    public String logout() {
        //clear session
        return "admin/login";
    }
    @ApiIgnore
    @RequestMapping(value = { "/index" }, method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response, Object handler) {

        request.setAttribute("ctx", request.getContextPath());
        return "admin/index";
    }


}