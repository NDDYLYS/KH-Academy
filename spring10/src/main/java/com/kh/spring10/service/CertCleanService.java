package com.kh.spring10.service;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CertCleanService {
	
	//@Scheduled(fixedDelay = 1000L)
	@Scheduled(cron="0 0 9-18 ? * MON-FRI")
	public void work() {
		System.out.println("일하는 중 : " + LocalDateTime.now());
	}
}
