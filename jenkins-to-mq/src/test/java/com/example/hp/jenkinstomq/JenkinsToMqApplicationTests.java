package com.example.hp.jenkinstomq;

import com.example.hp.jenkinstomq.service.impl.JenkinsInfoAcquireServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JenkinsToMqApplicationTests {

	@Autowired
	private JenkinsInfoAcquireServiceImpl jenkinsInfoAcquireService;

	@Test
	void contextLoads() {
	}

	@Test
	void testGetSystemInfo(){
		jenkinsInfoAcquireService.getSystemInfo();
	}

}
