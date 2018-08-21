package com.blog.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangfujie
 * @date 2018-08-21 10:42
 * @description 连接池类型枚举类
 */
public enum PoolCategoryEnum {

    RMDB("1","关系型数据库"),
    NoSql("2","非关系型数据库"),
    Api("3","api"),
    FS("4","普通文件系统"),
    DFS("5","分布式文件系统"),
    MQ("6","消息中间件"),
    Crawler("7","网络爬虫");

    /**
     * 主键
     */
    private final String key;

    /**
     * 描述
     */
    private final String desc;

    PoolCategoryEnum(final String key, final String desc) {
        this.key = key;
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getKey() {
        return this.key;
    }

    /**
     * 根据key获取描述
     * @param key
     * @return
     */
    public static String getDescByKey(String key){
        for(PoolCategoryEnum item : PoolCategoryEnum.values()){
            if(item.getKey().equals(key)){
                return item.getDesc();
            }
        }
        return null;
    }

    /**
     * 根据key获取枚举
     * @param key
     * @return
     */
    public static PoolCategoryEnum getEnumByKey(String key){
        for(PoolCategoryEnum item : PoolCategoryEnum.values()){
            if(item.getKey().equals(key)){
                return item;
            }
        }
        return null;
    }

    /**
     * 获取枚举类型列表（转为List<Map>形式）
     * @return
     */
    public static List<Map<String,Object>> getEnumList(){
        List<Map<String,Object>> resultList = new ArrayList<>();
        for(PoolCategoryEnum item : PoolCategoryEnum.values()){
            Map<String,Object> map = new HashMap<>();
            map.put("id",item.getKey());
            map.put("text",item.getDesc());
            resultList.add(map);
        }
        return resultList;
    }

    /**
     * 获取枚举类型筛选条件（转为List<Map>形式）
     * @return
     */
    public static List<Map<String,Object>> getConditionEnumList(){
        List<Map<String,Object>> resultList = new ArrayList<>();
        for(PoolCategoryEnum item : PoolCategoryEnum.values()){
            Map<String,Object> map = new HashMap<>();
            map.put("id",item.getKey());
            map.put("text",item.getDesc());
            map.put("children",PoolTypeEnum.getEnumListByPKey(item.getKey()));
            resultList.add(map);
        }
        return resultList;
    }
}
