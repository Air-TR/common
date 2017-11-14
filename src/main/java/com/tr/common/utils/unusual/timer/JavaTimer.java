package com.tr.common.utils.unusual.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * java定时器的五种实现方式
 * 
 * @author taorun
 * @date 2017年9月14日 上午11:37:58
 *
 */

public class JavaTimer {
	
    public static void main(String[] args) {
//        timer1();
        timer2();
//        timer3();
//        timer4();
//        timer5();
    }
    
    /**
     * 第一种方法：设定指定任务task在指定延迟delay后执行一次。
     * schedule(TimerTask task, long delay)
     */
    public static void timer1() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("-------设定指定任务--------");
            }
        }, 2000); // 任务在2秒后开始执行，只执行一次
    }

    /**
     * 第二种方法：设定指定任务task在指定延迟delay后进行指定周期peroid的执行。
     * schedule(TimerTask task, long delay, long period)
     */
    public static void timer2() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("-------设定指定任务--------");
            }
        }, 5000, 1000); // 任务在5秒后开始每秒执行一次
    }

    /**
     * 第三种方法：设定指定任务task在指定延迟delay后进行指定周期peroid的执行。
     * scheduleAtFixedRate(TimerTask task, long delay, long period)
     */
    public static void timer3() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println("-------设定指定任务--------");
            }
        }, 5000, 1000); // 任务在5秒后开始每秒执行一次
    }
   
    /**
     * 第四种方法：设定指定任务task在指定的首次时间firstTime开始按照指定周期period开始执行。
     * Timer.scheduleAtFixedRate(TimerTask task, Date firstTime, long period)
     */
    public static void timer4() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12); // 控制时
        calendar.set(Calendar.MINUTE, 0);       // 控制分
        calendar.set(Calendar.SECOND, 0);       // 控制秒

        Date time = calendar.getTime();         // 得出执行任务的时间，此处为今天的 12:00:00

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println("-------设定指定任务--------");
            }
        }, time, 1000 * 60 * 60 * 24); // 任务在今天的 12:00:00（time）执行，往后每 1000*60*60*24（一天）毫秒执行一次，这里即每天的固定时间执行。
    }

    /**
     * 第五种方法：设定指定任务task在指定时间time执行。
     * schedule(TimerTask task, Date time)
     */
    public static void timer5() {
    		Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12); // 控制时
        calendar.set(Calendar.MINUTE, 0);       // 控制分
        calendar.set(Calendar.SECOND, 0);       // 控制秒
        Date time = calendar.getTime();         // 得出执行任务的时间，此处为今天的 12:00:00
        
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("-------设定指定任务--------");
            }
        }, time); // 任务在今天的 12:00:00（time）执行，只执行一次。
    }
    
}
