package org.nerdizin.eztrial.web.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

	@RequestMapping(path = "/error")
	public Map<String, Object> handle(final HttpServletRequest request) {
		final Map<String, Object> map = new HashMap<>();
		map.put("status", request.getAttribute("javax.servlet.error.status_code"));
		map.put("reason", request.getAttribute("javax.servlet.error.message"));
		return map;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
