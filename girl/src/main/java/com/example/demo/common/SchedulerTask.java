package com.example.demo.common;

import java.util.Date;

import org.apache.http.client.utils.DateUtils;
import org.springframework.scheduling.annotation.Scheduled;


//@Component
public class SchedulerTask {

	private int count=0;

    @Scheduled(cron="*/50 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task runing  "+(DateUtils.formatDate(new Date())));
    }
	
}
