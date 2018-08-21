package com.blog.index.modules.system.service.impl;

import com.blog.index.modules.system.mapper.DatabaseMapper;
import com.blog.index.modules.system.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * @author wangfujie
 * @date 2018-08-21 10:52
 * @description 动态数据源测试
 */
@Service
public class DatabaseServiceImpl implements DatabaseService {

    @Autowired
    private DatabaseMapper databaseMapper;

    /**
     * 测试动态查询
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> testDataBaseQuery() {
        return databaseMapper.testQuery();
    }
}