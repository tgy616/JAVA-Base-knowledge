package com.tgy.knowledge;

import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

/**
 * 盘点实现定时任务的那些方案
 *
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-10-26 09:47
 **/

public class TimerTest {
    private static org.slf4j.Logger logger=LoggerFactory.getLogger(TimerTest.class);
    public static void main(String[] args) {
        logger.info("start");
        Timer timer =new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                logger.info("tesy");
            }
        },5000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                logger.info("test");
            }
        },3000);
    }
}
