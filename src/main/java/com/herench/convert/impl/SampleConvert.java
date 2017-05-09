package com.herench.convert.impl;

import com.herench.convert.Convert;
import com.herench.dao.his.HisDao;
import com.herench.dao.perform.PerformDao;
import com.herench.utils.TransUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * com.herench.convert.impl
 *
 * @author zhiwei
 * @create 2016-12-14 16:03.
 */
@Component("convert")
@Transactional(readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class SampleConvert implements Convert {

    @Autowired
    private HisDao hisDao;

    @Autowired
    private PerformDao performDao;

    @Autowired
    private TransUtils transUtils;

    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * 住院明细
     *
     * @return
     */
    @Override
    public boolean zymxConvert(int day) {
        try {
            List<Map<String, Object>> zymx = hisDao.zymx(day);
            for (Map<String, Object> map : zymx) {
                for (String key : map.keySet()) {
                    map.put(key, transUtils.toTrans(map.get(key)));
                }
                performDao.zymx(map);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return false;
        }
    }

    /**
     * 门诊明细
     *
     * @return
     */
    @Override
    public boolean mzmxConvert(int day) {
        try {
            List<Map<String, Object>> mzmx = hisDao.mzmx(day);
            for (Map<String, Object> map : mzmx) {
                for (String key : map.keySet()) {
                    map.put(key, transUtils.toTrans(map.get(key)));
                }
                try {
                    performDao.mzmx(map);
                } catch (Exception inE) {
                    inE.printStackTrace();
                    logger.info(inE.getMessage());
                    logger.info("mzmx_drug error message start");
                    for (String key : map.keySet()) {
                        logger.info("error message: " + key + " : " + map.get(key));
                    }
                    logger.info("mzmx_drug error message end");
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return false;
        }
    }

    /**
     * 物资明细
     *
     * @return
     */
    @Override
    public boolean wzItemConvert() {
        try {
            List<Map<String, Object>> wzItem = hisDao.wzItem();
            performDao.deleteWzItem();
            for (Map<String, Object> map : wzItem) {
                for (String key : map.keySet()) {
                    map.put(key, transUtils.toTrans(map.get(key)));
                }
                performDao.wzItem(map);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return false;
        }
    }

    /**
     * 收费代码
     *
     * @return
     */
    @Override
    public boolean chargeItemConvert() {
        try {
            List<Map<String, Object>> chargeItem = hisDao.chargeItem();
            performDao.deleteChargeItem();
            for (Map<String, Object> map : chargeItem) {
                for (String key : map.keySet()) {
                    map.put(key, transUtils.toTrans(map.get(key)));
                }
                performDao.chargeItem(map);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return false;
        }
    }

    /**
     * 物资领用明细
     *
     * @return
     */
    @Override
    public boolean wzDetialConvert(int day) {
        try {
            List<Map<String, Object>> zymx = hisDao.wzDetial(day);
            for (Map<String, Object> map : zymx) {
                for (String key : map.keySet()) {
                    map.put(key, transUtils.toTrans(map.get(key)));
                }
                performDao.wzDetial(map);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return false;
        }
    }

    /**
     * 手术登记
     *
     * @return
     */
    @Override
    public boolean ssmxConvert(int day) {
        try {
            List<Map<String, Object>> zy = hisDao.ssmxZy(day);
            List<Map<String, Object>> mz = hisDao.ssmxMz(day);
            List<Map<String, Object>> total = new ArrayList<Map<String, Object>>();
            total.addAll(zy);
            total.addAll(mz);
            for (Map<String, Object> map : total) {
                for (String key : map.keySet()) {
                    map.put(key, transUtils.toTrans(map.get(key)));
                }
                performDao.ssmx(map);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return false;
        }
    }

    /**
     * 科室信息
     *
     * @return
     */
    @Override
    public boolean deptInfoConvert() {
        try {
            List<Map<String, Object>> deptInfo = hisDao.deptInfo();
            performDao.deleteDeptInfo();
            for (Map<String, Object> map : deptInfo) {
                for (String key : map.keySet()) {
                    map.put(key, transUtils.toTrans(map.get(key)));
                }
                performDao.deptInfo(map);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return false;
        }
    }

    /**
     * 人员信息
     *
     * @return
     */
    @Override
    public boolean empInfoConvert() {
        try {
//            Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
            List<Map<String, Object>> empInfo = hisDao.empInfo();
            performDao.deleteEmpInfo();
            for (Map<String, Object> map : empInfo) {
//                String dept_code = String.valueOf(transUtils.toTrans(map.get("DEPT_CODE")));
//                Matcher matcher = p.matcher(dept_code);
//                if (!matcher.find()) {
                for (String key : map.keySet()) {
                    map.put(key, transUtils.toTrans(map.get(key)));
                }
                performDao.empInfo(map);
//                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return false;
        }
    }

    /**
     * 患者出入院信息
     *
     * @return
     */
    @Override
    public boolean inpinConvert(int day) {
        try {
            List<Map<String, Object>> inpin = hisDao.inpin(day);
            for (Map<String, Object> map : inpin) {
                for (String key : map.keySet()) {
                    map.put(key, transUtils.toTrans(map.get(key)));
                }
                performDao.inpin(map);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return false;
        }
    }

    /**
     * exam
     *
     * @return
     */
    @Override
    public boolean examConvert(int day) {
        try {
            List<Map<String, Object>> zy = hisDao.examZy(day);
            List<Map<String, Object>> mz = hisDao.examMz(day);
            List<Map<String, Object>> total = new ArrayList<Map<String, Object>>();
            total.addAll(zy);
            total.addAll(mz);
            for (Map<String, Object> map : total) {
                for (String key : map.keySet()) {
                    map.put(key, transUtils.toTrans(map.get(key)));
                }
                performDao.exam(map);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return false;
        }
    }

    /**
     * 医嘱信息
     *
     * @return
     */
    @Override
    public boolean orderConvert() {
        try {
            List<Map<String, Object>> orderInfo = hisDao.order();
            for (Map<String, Object> map : orderInfo) {
                for (String key : map.keySet()) {
                    map.put(key, transUtils.toTrans(map.get(key)));
                }
                performDao.order(map);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return false;
        }
    }
}
