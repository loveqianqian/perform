package com.herench.convert;

/**
 * com.herench.convert
 *
 * @author zhiwei
 * @create 2016-12-14 15:58.
 */
public interface Convert {

    /**
     * 住院明细
     *
     * @return
     */
    boolean zymxConvert(int day);

    /**
     * 门诊明细
     *
     * @return
     */
    boolean mzmxConvert(int day);

    /**
     * 物资明细
     *
     * @return
     */
    boolean wzItemConvert();

    /**
     * 收费代码
     *
     * @return
     */
    boolean chargeItemConvert();

    /**
     * 物资领用明细
     *
     * @return
     */
    boolean wzDetialConvert(int day);

    /**
     * 手术登记
     *
     * @return
     */
    boolean ssmxConvert(int day);

    /**
     * 科室信息
     *
     * @return
     */
    boolean deptInfoConvert();

    /**
     * 人员信息
     *
     * @return
     */
    boolean empInfoConvert();

    /**
     * 患者出入院信息
     *
     * @return
     */
    boolean inpinConvert(int day);

    /**
     * exam
     *
     * @param day
     * @return
     */
    boolean examConvert(int day);
}
