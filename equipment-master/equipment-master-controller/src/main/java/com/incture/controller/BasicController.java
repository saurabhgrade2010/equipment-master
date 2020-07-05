package com.incture.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.incture.services.BasicService;
import com.incture.entities.BasicData;


@RestController
@RequestMapping("basic")
public class BasicController {
	
	@RequestMapping("/hello")
	public String hello()
	{
		return "Hello Saurabh Rajput";
	}

	
}
