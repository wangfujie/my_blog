package com.blog.index.modules.system.service;

import java.util.List;
import java.util.Map;

/**
 * @author wangfujie
 * @date 2018-08-21 10:52
 * @description 动态数据源测试
 */
public interface DatabaseService {

    /**
     * 测试动态查询
     * @return
     */
    List<Map<String, Object>> testDataBaseQuery();
}
