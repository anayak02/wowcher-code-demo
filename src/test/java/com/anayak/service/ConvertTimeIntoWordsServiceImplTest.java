package com.anayak.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConvertTimeIntoWordsServiceImplTest {

	@Autowired
	private ConvertTimeIntoWordsService convertTimeIntoWordsService;

	@Test
	void convert() {
		assertEquals(convertTimeIntoWordsService.convert("12:12"), "It's twelve twelve PM");
	}

}
