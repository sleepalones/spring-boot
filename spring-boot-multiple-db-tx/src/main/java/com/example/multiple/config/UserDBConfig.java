package com.example.multiple.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author brotherming
 * @createTime 2024年07月27日 16:07:00
 */
@Configuration
@MapperScan(basePackages = {"com.example.multiple.mapper.user"}, sqlSessionTemplateRef = "userSqlSessionTemplate")
public class UserDBConfig {

    @Autowired
    private UserProperties userProperties;

    @Bean
    public DataSource userDataSource() {
        //return DataSourceBuilder.create().build();

        // XA 数据源
        MysqlXADataSource xaDataSource = new MysqlXADataSource();
        xaDataSource.setUrl(userProperties.getJdbcUrl());
        xaDataSource.setUser(userProperties.getUsername());
        xaDataSource.setPassword(userProperties.getPassword());

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(xaDataSource);
        atomikosDataSourceBean.setUniqueResourceName("userDataSource");
        atomikosDataSourceBean.setMaxPoolSize(30);
        atomikosDataSourceBean.setMinPoolSize(5);

        return atomikosDataSourceBean;
    }

    @Bean
    public SqlSessionFactory userSqlSessionFactory(DataSource userDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(userDataSource);
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate userSqlSessionTemplate(SqlSessionFactory userSqlSessionFactory) {
        return new SqlSessionTemplate(userSqlSessionFactory);
    }
}
