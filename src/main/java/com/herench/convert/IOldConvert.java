package com.herench.convert;

/**
 * com.herench.convert
 *
 * @author zhiwei
 * @create 2016-12-14 15:58.
 */
public interface IOldConvert {

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
     * 患者出入院信息
     *
     * @return
     */
    boolean inpinConvert(int day);


    /**
     * exam
     *
     * @return
     */
    boolean examConvert(int day);

    /**
     * 科室信息
     *
     * @return
     */
    boolean deptInfoConvert();

    /**
     * 收费代码
     *
     * @return
     */
    boolean chargeItemConvert();

    /**
     * 人员信息
     *
     * @return
     */
    boolean empInfoConvert();


}
