package com.herench.command;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * com.herench.command
 *
 * @author zhiwei
 * @create 2016-12-14 16:13.
 */
public class Command {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        CommandTimer timer = new CommandTimer(convert, 1L);
//        OldTimer oldTimer = new OldTimer(oldConvert, convert);
//        timer.schedule(1);
//        oldTimer.schedule();
    }

}
