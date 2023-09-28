package com.togather.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = ToGatherApiApplication.class)
@TestPropertySource(locations="classpath:test.properties")
public class ToGatherApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
