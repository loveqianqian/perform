package com.herench.command;

import com.herench.convert.Convert;
import com.herench.convert.IOldConvert;
import com.herench.utils.TimeUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

/**
 * com.herench.command
 *
 * @author zhiwei
 * @create 2016-12-14 16:16.
 */
@Component
public class OldTimer extends Timer {

    private IOldConvert convert;

    private Convert commonConvert;

    public OldTimer() {
    }

    public OldTimer(IOldConvert convert, Convert commonConvert) {
        this.convert = convert;
        this.commonConvert = commonConvert;
    }

    private Logger logger = Logger.getLogger(this.getClass());

    public void schedule() {
        try {
            final Timer timer = new Timer();

            TimerTask timerTask = new TimerTask() {

                private int count = TimeUtils.getRealGap("2016-8-1");//从后一天开始

                @Override
                public void run() {
                    logger.info("手术登记表提取开始");
                    if (!convert.ssmxConvert(count)) {
                        logger.info("手术登记表提取失败");
                    } else {
                        logger.info("手术登记表提取成功");
                    }
//                    logger.info("检查报告信息提取开始");
//                    if (!convert.examConvert(count)) {
//                        logger.info("检查报告信息提取失败");
//                    } else {
//                        logger.info("检查报告信息提取成功");
//                    }
//                    logger.info("住院明细账提取开始");
//                    if (!convert.zymxConvert(count)) {
//                        logger.info("住院明细账提取失败");
//                    } else {
//                        logger.info("住院明细账提取成功");
//                    }
//                    logger.info("物资领用明细账提取开始");
//                    if (!convert.wzDetialConvert(count)) {
//                        logger.info("物资领用明细账提取失败");
//                    } else {
//                        logger.info("物资领用明细账提取成功");
//                    }
//                    logger.info("门诊明细账提取开始");
//                    if (!convert.mzmxConvert(count)) {
//                        logger.info("门诊明细账提取失败");
//                    } else {
//                        logger.info("门诊明细账提取成功");
//                    }
//                    logger.info("患者出入院信息提取开始");
//                    if (!convert.inpinConvert(count)) {
//                        logger.info("患者出入院信息提取失败");
//                    } else {
//                        logger.info("患者出入院信息提取成功");
//                    }
//                    logger.info("物资字典表提取开始");
//                    if (!commonConvert.wzItemConvert()) {
//                        logger.info("物资字典表提取失败");
//                    } else {
//                        logger.info("物资字典表提取成功");
//                    }
//                    logger.info("科室信息提取开始");
//                    if (!convert.deptInfoConvert()) {
//                        logger.info("科室信息提取失败");
//                    } else {
//                        logger.info("科室信息提取成功");
//                    }
//                    logger.info("收费代码表提取开始");
//                    if (!convert.chargeItemConvert()) {
//                        logger.info("收费代码表提取失败");
//                    } else {
//                        logger.info("收费代码表提取成功");
//                    }
//                    logger.info("人员信息提取开始");
//                    if (!convert.empInfoConvert()) {
//                        logger.info("人员信息提取失败");
//                    } else {
//                        logger.info("人员信息提取成功");
//                    }
                    if (count == TimeUtils.getRealGap("2016-12-31")) {//到这天结束
                        logger.info("all have done!!!");
                        timer.cancel();
                    }
                    logger.info("count:" + count);
                    this.count--;
                }
            };
            timer.schedule(timerTask, TimeUtils.getDelay("2017-5-12 15:50:00"), 1000L * 25L);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        new OldTimer().schedule();
    }
}
