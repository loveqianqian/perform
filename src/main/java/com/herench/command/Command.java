package com.herench.command;

import com.herench.convert.Convert;
import com.herench.convert.IOldConvert;
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
        Convert convert = applicationContext.getBean(Convert.class);
        IOldConvert oldConvert = applicationContext.getBean(IOldConvert.class);
//        CommandTimer timer = new CommandTimer(convert, 1L);
        OldTimer oldTimer = new OldTimer(oldConvert, convert);
//        timer.schedule(1);
        oldTimer.schedule();
    }

}
