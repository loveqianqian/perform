package com.herench.command;

import com.herench.convert.Convert;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * com.herench.command
 *
 * @author zhiwei
 * @create 2016-12-14 16:16.
 */
@Component
public class CommandTimer extends Timer {

    private Convert convert;

    private long time;

    public CommandTimer() {
    }

    public CommandTimer(Convert convert, long time) {
        this.convert = convert;
        this.time = time;
    }

    private Logger logger = Logger.getLogger(this.getClass());

    public static final long per = 1000 * 60 * 60 * 24;
    public static final long hours = 1000 * 60 * 60;

    public void schedule(final int day) {
        try {
            long perTime = time * per;
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    logger.info("检查报告信息提取开始");
                    if (!convert.examConvert(day)) {
                        logger.info("检查报告信息提取失败");
                    } else {
                        logger.info("检查报告信息提取成功");
                    }
                    logger.info("手术登记表提取开始");
                    if (!convert.ssmxConvert(day)) {
                        logger.info("手术登记表提取失败");
                    } else {
                        logger.info("手术登记表提取成功");
                    }
                    logger.info("科室信息提取开始");
                    if (!convert.deptInfoConvert()) {
                        logger.info("科室信息提取失败");
                    } else {
                        logger.info("科室信息提取成功");
                    }
                    logger.info("收费代码表提取开始");
                    if (!convert.chargeItemConvert()) {
                        logger.info("收费代码表提取失败");
                    } else {
                        logger.info("收费代码表提取成功");
                    }
                    logger.info("人员信息提取开始");
                    if (!convert.empInfoConvert()) {
                        logger.info("人员信息提取失败");
                    } else {
                        logger.info("人员信息提取成功");
                    }
                    logger.info("住院明细账提取开始");
                    if (!convert.zymxConvert(day)) {
                        logger.info("住院明细账提取失败");
                    } else {
                        logger.info("住院明细账提取成功");
                    }
                    logger.info("物资领用明细账提取开始");
                    if (!convert.wzDetialConvert(day)) {
                        logger.info("物资领用明细账提取失败");
                    } else {
                        logger.info("物资领用明细账提取成功");
                    }
                    logger.info("物资字典表提取开始");
                    if (!convert.wzItemConvert()) {
                        logger.info("物资字典表提取失败");
                    } else {
                        logger.info("物资字典表提取成功");
                    }
                    logger.info("门诊明细账提取开始");
                    if (!convert.mzmxConvert(day)) {
                        logger.info("门诊明细账提取失败");
                    } else {
                        logger.info("门诊明细账提取成功");
                    }
                    logger.info("患者出入院信息提取开始");
                    if (!convert.inpinConvert(day)) {
                        logger.info("患者出入院信息提取失败");
                    } else {
                        logger.info("患者出入院信息提取成功");
                    }
                }
            };
            schedule(timerTask, 2L * hours, perTime);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
    }
}
