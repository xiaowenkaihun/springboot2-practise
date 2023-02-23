package com.itwen;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/17 16:07
 * 文件描述：
 */
public class TimerTaskAPP {
    public static void main(String[] args) {
        Timer timer  = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer task run...");
            }
        };
        timer.schedule(task, 0, 2000);
    }
}
