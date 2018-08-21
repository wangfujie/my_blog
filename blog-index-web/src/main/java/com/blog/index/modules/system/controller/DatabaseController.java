package com.blog.index.modules.system.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.blog.common.enums.PoolCategoryEnum;
import com.blog.common.enums.PoolTypeEnum;
import com.blog.common.result.R;
import com.blog.index.config.database.DataSourceContextHolder;
import com.blog.index.config.database.DynamicDataSource;
import com.blog.index.modules.system.service.DatabaseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wangfujie
 * @date 2018-08-21 10:26
 * @description 动态数据源测试
 */
@RestController
@RequestMapping("/database")
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    /**
     * 动态切换数据源
     */
    @GetMapping("/dynamicDataSource" )
    @ApiOperation(value = "动态切换数据源", notes = "动态切换数据源" )
    public R dynamicDataSource(){
        List<Map<String, Object>> list = new ArrayList<>();
        switch (PoolCategoryEnum.getEnumByKey("1")){
            case RMDB:
                //关系型数据库
                //创建数据源
                DruidDataSource dynamic = createDynamicDataSource("dynamic-slave");
                //切换到动态数据源
                DataSourceContextHolder.setDBType("dynamic-slave");
                //检测数据源连通状态
                boolean result = checkDataPoolConnect(dynamic);
                if (result){
                    //查询
                    list = databaseService.testDataBaseQuery();
                }else {
                    return R.error("数据源连接失败！");
                }
                break;
            case NoSql:
            case Api:
            case FS:
            case MQ:
            case Crawler:
                return R.error("暂时不支持该类数据库的连接！");
            default:break;
        }
        //清除动态数据源
        DataSourceContextHolder.clearDBType();
        return R.fillListData(list);
    }

    /**
     * 检测数据源连接状态
     * @return
     */
    private boolean checkDataPoolConnect(DruidDataSource dynamic){
        boolean bool = false;
        Connection conn = null;
        try {
            Class.forName(dynamic.getDriverClassName());
            conn = DriverManager.getConnection(dynamic.getUrl(), dynamic.getUsername(), dynamic.getPassword());
            if (conn != null){
                bool = true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return bool;
    }

    /**
     * 配置创建动态数据源信息，通过关系型数据库连接表
     * @return
     */
    private DruidDataSource createDynamicDataSource(String dataSourceName){
        //创建动态数据源
        Map<Object, Object> dataSourceMap = DynamicDataSource.getInstance().getDataSourceMap();
        //配置动态数据源信息
        DruidDataSource dynamicDataSource = new DruidDataSource();
        switch (PoolTypeEnum.getEnumByKey("101")){
            case RMDB_Mysql:
                dynamicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
                dynamicDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/kettle_input?allowMultiQueries=true&serverTimezone=GMT%2B8");
                break;
            case RMDB_Oracle:
                dynamicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
                dynamicDataSource.setUrl("jdbc:oracle:thin:@//127.0.0.1:1521/orcl");
                break;
            case RMDB_SqlServer:
                dynamicDataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                dynamicDataSource.setUrl("jdbc:sqlserver://127.0.0.1:1433;databaseName=query_test");
                break;
            case RMDB_DB2:
                dynamicDataSource.setDriverClassName("com.ibm.db2.jcc.DB2Driver");
                dynamicDataSource.setUrl("jdbc:db2://127.0.0.1:50000/mydb");
                break;
            default:break;
        }
        dynamicDataSource.setUsername("root");
        dynamicDataSource.setPassword("wang123");
        //创建动态数据源
        dataSourceMap.put(dataSourceName, dynamicDataSource);
        DynamicDataSource.getInstance().setTargetDataSources(dataSourceMap);
        return dynamicDataSource;
    }
}
