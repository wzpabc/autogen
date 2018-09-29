package com.tupperware.auto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeController {
	@ApiIgnore
	@RequestMapping(value = "/swagger")
	public void index(HttpServletResponse response) throws IOException {
		System.out.println("swagger-ui.html");
		response.sendRedirect("swagger-ui.html");
		// return "redirect:/api/swagger-ui.html";
	}
}