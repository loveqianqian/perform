package com.herench.dao.his;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * com.herench.dao.his
 *
 * @author zhiwei
 * @create 2016-12-14 15:55.
 */
@Component("hisDao")
public interface HisDao {

    List<Map<String, Object>> zymx(@Param(value = "day") Integer day);

    List<Map<String, Object>> mzmx(@Param(value = "day") Integer day);

    List<Map<String, Object>> mzmx_drug(@Param(value = "day") Integer day);

    List<Map<String, Object>> mzmx_not_drug(@Param(value = "day") Integer day);

    List<Map<String, Object>> wzItem();

    List<Map<String, Object>> chargeItem();

    List<Map<String, Object>> wzDetial(@Param(value = "day") Integer day);

    List<Map<String, Object>> ssmxZy(@Param(value = "day") Integer day);

    List<Map<String, Object>> ssmxMz(@Param(value = "day") Integer day);

    List<Map<String, Object>> deptInfo();

    List<Map<String, Object>> empInfo();

    List<Map<String, Object>> inpin(@Param(value = "day") Integer day);

    List<Map<String, Object>> examMz(@Param(value = "day") Integer day);

    List<Map<String, Object>> examZy(@Param(value = "day") Integer day);
}
