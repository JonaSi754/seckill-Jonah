package org.sijinghua.seckill.starter.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @Date: 2023/5/16
 * @Author: Jonah Si
 * @Description: 读取MyBatis配置，并向IOC容器中注册
 */
public class MybatisConfig {
    @Value("${mybatis.scanPackages}")
    private String scanPackages;

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DruidDataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setTypeAliasesPackage(scanPackages);
        return sqlSessionFactory;
    }
}
