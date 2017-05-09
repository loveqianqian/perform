package com.herench.convert.impl;

import com.herench.convert.IOldConvert;
import com.herench.dao.his.OldHisDao;
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

/**
 * com.herench.convert.impl
 *
 * @author zhiwei
 * @create 2016-12-14 16:03.
 */
@Component("oldConvert")
@Transactional(readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class OldConvert implements IOldConvert {

    @Autowired
    private OldHisDao oldHisDao;

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
            List<Map<String, Object>> zymx = oldHisDao.zymx(day);
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
            List<Map<String, Object>> mzmx = oldHisDao.mzmx(day);
            for (Map<String, Object> map : mzmx) {
                for (String key : map.keySet()) {
                    map.put(key, transUtils.toTrans(map.get(key)));
                }
                performDao.mzmx(map);
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
            List<Map<String, Object>> zymx = oldHisDao.wzDetial(day);
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
            List<Map<String, Object>> zy = oldHisDao.ssmxZy(day);
            List<Map<String, Object>> mz = oldHisDao.ssmxMz(day);
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
     * 患者出入院信息
     *
     * @return
     */
    @Override
    public boolean inpinConvert(int day) {
        try {
            List<Map<String, Object>> inpin = oldHisDao.inpin(day);
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
            List<Map<String, Object>> zy = oldHisDao.examZy(day);
            List<Map<String, Object>> mz = oldHisDao.examMz(day);
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
     * 科室信息
     *
     * @return
     */
    @Override
    public boolean deptInfoConvert() {
        try {
            List<Map<String, Object>> deptInfo = oldHisDao.deptInfo();
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
     * 收费代码
     *
     * @return
     */
    @Override
    public boolean chargeItemConvert() {
        try {
            List<Map<String, Object>> chargeItem = oldHisDao.chargeItem();
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
     * 人员信息
     *
     * @return
     */
    @Override
    public boolean empInfoConvert() {
        try {
//            Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
            List<Map<String, Object>> empInfo = oldHisDao.empInfo();
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


}
