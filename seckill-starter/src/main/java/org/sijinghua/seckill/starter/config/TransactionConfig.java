package org.sijinghua.seckill.starter.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Date: 2023/5/16
 * @Author: Jonah Si
 * @Description: 事务管理配置类
 */
@Configuration
@MapperScan(value = "org.sijinghua.seckill.infrastructure.mapper")
@ComponentScan(value = "org.sijinghua.seckill")
@PropertySource(value = {"classpath:properties/jdbc.properties", "classpath:properties/mybatis.properties"})
@Import({JdbcConfig.class, MybatisConfig.class, RedisConfig.class})
@EnableTransactionManagement(proxyTargetClass = true)
public class TransactionConfig {
    @Bean
    public TransactionManager transactionManager(DruidDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
