package com.jy.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;

/**
 * 〈〉
 *
 * @author jianglei
 * @create 2018/6/13
 * @since 1.0.0
 */
@Configuration
public class DataSourceConfig {

    @Bean(name="master")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource firstDataSource(){
        return DataSourceBuilder.create().build();
    }


    @Bean(name="readsource")
    @ConfigurationProperties(prefix = "spring.datasource.readsource")
    public DataSource secondDataSource(){
        return DataSourceBuilder.create().build();
    }


    // 配置事务管理器
    @Bean("masterTransactionManager")
    public PlatformTransactionManager prodTransactionManager(@Qualifier("master") DataSource prodDataSource) {
        return new DataSourceTransactionManager(prodDataSource);
    }

    @Bean("readsourceTransactionManager")
    public PlatformTransactionManager devTransactionManager(@Qualifier("readsource") DataSource sitDataSource) {
        return new DataSourceTransactionManager(sitDataSource);
    }

}