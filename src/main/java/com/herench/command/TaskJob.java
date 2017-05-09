package com.herench.command;

import com.herench.convert.Convert;
import com.herench.convert.IOldConvert;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import java.util.Calendar;

/**
 * com.herench.command
 *
 * @author zhiwei
 * @create 2017-05-03 13:51.
 * @github {@https://github.com/loveqianqian}
 */
@Component("taskJob")
public class TaskJob {

    @Autowired
    private IOldConvert convert;

    @Autowired
    private Convert commonConvert;

    private Logger logger = Logger.getLogger(this.getClass());

    public void jobFirst() {
        Calendar calendar = Calendar.getInstance();
        int preMonth = calendar.get(Calendar.MONTH) - 1;
        calendar.set(Calendar.MONTH, preMonth);
        int actualMaximum = calendar.getActualMaximum(Calendar.DATE) + 2;
        logger.info("开始时间: " + actualMaximum);

        for (int count = actualMaximum; count > 2; count--) {
            logger.info("手术登记表提取开始");
            if (!convert.ssmxConvert(count)) {
                logger.info("手术登记表提取失败");
            } else {
                logger.info("手术登记表提取成功");
            }
            logger.info("检查报告信息提取开始");
            if (!convert.examConvert(count)) {
                logger.info("检查报告信息提取失败");
            } else {
                logger.info("检查报告信息提取成功");
            }
            logger.info("住院明细账提取开始");
            if (!convert.zymxConvert(count)) {
                logger.info("住院明细账提取失败");
            } else {
                logger.info("住院明细账提取成功");
            }
            logger.info("物资领用明细账提取开始");
            if (!convert.wzDetialConvert(count)) {
                logger.info("物资领用明细账提取失败");
            } else {
                logger.info("物资领用明细账提取成功");
            }
            logger.info("门诊明细账提取开始");
            if (!convert.mzmxConvert(count)) {
                logger.info("门诊明细账提取失败");
            } else {
                logger.info("门诊明细账提取成功");
            }
            logger.info("患者出入院信息提取开始");
            if (!convert.inpinConvert(count)) {
                logger.info("患者出入院信息提取失败");
            } else {
                logger.info("患者出入院信息提取成功");
            }
            logger.info("物资字典表提取开始");
            if (!commonConvert.wzItemConvert()) {
                logger.info("物资字典表提取失败");
            } else {
                logger.info("物资字典表提取成功");
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
            logger.info("医嘱信息提取开始");
            if (!commonConvert.orderConvert()) {
                logger.info("医嘱信息提取失败");
            } else {
                logger.info("医嘱信息提取成功");
            }
        }
        logger.info("结束时间: " + 2);
    }
}
