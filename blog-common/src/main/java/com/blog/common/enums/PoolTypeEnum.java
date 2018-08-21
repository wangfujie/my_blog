package com.blog.common.enums;

import java.util.*;

/**
 * @author wangfujie
 * @date 2018-08-21 10:30
 * @description 连接池小类枚举类
 */
public enum PoolTypeEnum {

    RMDB_Mysql("101","Mysql","1"),
    RMDB_Oracle("102","Oracle","1"),
    RMDB_SqlServer("103","SqlServer","1"),
    RMDB_DB2("104","DB2","1"),
    NoSql_MongoDB("201","MongoDB","2"),
    NoSql_HBase("202","HBase","2"),
    Api_HTTP("301","HTTP","3"),
    Api_WSDL("302","WSDL","3"),
    Api_REST("303","REST","3"),
    Api_HTTPS("304","HTTPS","3"),
    FS_FTP("401","FTP","4"),
    FS_SFTP("402","SFTP","4"),
    FS_Local("403","本地磁盘","4"),
    FS_Share("404","共享文件夹","4"),
    DFS_HDFS("501","HDFS","5"),
    MQ_Kafka("601","Kafka","6"),
    MQ_RabbitMQ("602","RabbitMQ","6"),
    MQ_ActiveMQ("603","ActiveMQ","6"),
    Crawler_MongoDB("701","MongoDB","7");

    /**
     * 主键
     */
    private final String key;

    /**
     * 描述
     */
    private final String desc;

    /**
     * 父类主键
     */
    private final String pKey;

    PoolTypeEnum(final String key, final String desc,final String pKey) {
        this.key = key;
        this.desc = desc;
        this.pKey = pKey;
    }

    public String getKey() {
        return this.key;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getPKey() {
        return this.pKey;
    }

    /**
     * 获取枚举类型列表（转为List<Map>形式）
     * @return
     */
    public static List<Map<String,Object>> getEnumList(){
        List<Map<String,Object>> resultList = new ArrayList<>();
        for(PoolTypeEnum item : PoolTypeEnum.values()){
            Map<String,Object> map = new HashMap<>();
            map.put("id",item.getKey());
            map.put("text",item.getDesc());
            resultList.add(map);
        }
        return resultList;
    }

    /**
     * 通过父类主键过滤枚举类型列表（转为List<Map>形式）
     * @return
     */
    public static List<Map<String,Object>> getEnumListByPKey(String pid){
        List<Map<String,Object>> resultList = new ArrayList<>();
        for(PoolTypeEnum item : PoolTypeEnum.values()){
            if(Objects.equals(pid,item.getPKey())) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", item.getKey());
                map.put("text", item.getDesc());
                resultList.add(map);
            }
        }
        return resultList;
    }

    /**
     * 根据key获取枚举
     * @param key
     * @return
     */
    public static PoolTypeEnum getEnumByKey(String key){
        for(PoolTypeEnum item : PoolTypeEnum.values()){
            if(item.getKey().equals(key)){
                return item;
            }
        }
        return null;
    }

    /**
     * 根据key获取描述
     * @param key
     * @return
     */
    public static String getDescByKey(String key){
        for(PoolTypeEnum item : PoolTypeEnum.values()){
            if(item.getKey().equals(key)){
                return item.getDesc();
            }
        }
        return null;
    }
}
