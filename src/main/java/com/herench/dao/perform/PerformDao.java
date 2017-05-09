package com.herench.dao.perform;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * com.herench.dao.perform
 *
 * @author zhiwei
 * @create 2016-12-14 15:55.
 */
@Component
public interface PerformDao {

    void zymx(Map<String, Object> params);

    void mzmx(Map<String, Object> params);

    void deleteWzItem();

    void wzItem(Map<String, Object> params);

    void deleteChargeItem();

    void chargeItem(Map<String, Object> params);

    void wzDetial(Map<String, Object> params);

    void ssmx(Map<String, Object> params);

    void deleteDeptInfo();

    void deptInfo(Map<String, Object> params);

    void deleteEmpInfo();

    void empInfo(Map<String, Object> params);

    void inpin(Map<String, Object> params);

    void exam(Map<String, Object> params);

    void order(Map<String, Object> params);

}
