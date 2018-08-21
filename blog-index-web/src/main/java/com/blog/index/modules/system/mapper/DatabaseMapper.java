package com.blog.index.modules.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

/**
 * @author wangfujie
 * @date 2018-08-21 10:55
 * @description 动态数据源测试
 */
@Mapper
public interface DatabaseMapper {

    /**
     * 测试查询
     * @return
     */
    List<Map<String, Object>> testQuery();
}
