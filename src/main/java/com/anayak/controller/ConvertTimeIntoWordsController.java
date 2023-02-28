package com.anayak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anayak.service.ConvertTimeIntoWordsService;

/**
 * 
 * @author arjun
 *
 */
@RestController
public class ConvertTimeIntoWordsController {

	@Autowired
	private ConvertTimeIntoWordsService convertTimeIntoWordsService;

	@RequestMapping("/")
	public String getIndex() {
		return "<h1>Welocme to  Convert Time Into Words Demo</h1> \n <hr>  <a href='http://localhost:8080/convetTimeToWords/08:34'>Click to Convert time 08:34</a> <br>  <a href='http://localhost:8080/convetTimeToWords/12:00'>Click to Convert time 12:00</a> <br> <a href='http://localhost:8080/convetTimeToWords/24:00'>Click to Convert time 24:00</a>";
	}

	@GetMapping(value = "/convetTimeToWords/{time}")
	public String convert(@PathVariable("time") String time) {
 		return convertTimeIntoWordsService.convert(time);
	}

}
