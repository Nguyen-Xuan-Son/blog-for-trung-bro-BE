package com.utils.schedules;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.Date;

@Configuration
@EnableScheduling
public class Session {

    @Scheduled(fixedDelay = 10000)
    public void checkSession()  throws InternalError {
        System.out.println("Task1 - " + new Date());
    }

}
