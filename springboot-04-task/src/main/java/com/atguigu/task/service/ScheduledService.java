package com.atguigu.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    /*
    * second, minute, hour, day of month, month, and day of week.
    * 0 * * * * MON-FRI
    * [0 0/5 14,18 * * ?]每天14点整, 和18点整, 每隔5分钟执行一次
    * [0 15 10 ? * 1-6]每个月的周一到周六10:15分执行一次
    * [0 0 2 ? * 6L]每个月的最后一个周六凌晨两点执行一次
    * [0 0 2 LW * ?]每个月的最后一个工作日凌晨狼点执行一次
    * [0 0 2-4 ? * 1#2]每个月的第二个周一凌晨两点到四点期间, 每个整点都执行一次
    * */
//    必须得提前开启定时任务功能
    @Scheduled(cron = "0 * * * * MON-SAT")
    public void hello(){
        System.out.println("hello....");

    }
}
