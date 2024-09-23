package com.example.multiple.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author brotherming
 * @createTime 2024年07月27日 16:07:00
 */
@Configuration
@MapperScan(basePackages = {"com.example.multiple.mapper.order"}, sqlSessionTemplateRef = "orderSqlSessionTemplate")
public class OrderDBConfig {

    @Autowired
    private OrderProperties orderProperties;

    @Bean
    //@ConfigurationProperties(prefix = "spring.datasource.order")
    public DataSource orderDataSource() {
        //return DataSourceBuilder.create().build();

        // XA 数据源
        MysqlXADataSource xaDataSource = new MysqlXADataSource();
        xaDataSource.setUrl(orderProperties.getJdbcUrl());
        xaDataSource.setUser(orderProperties.getUsername());
        xaDataSource.setPassword(orderProperties.getPassword());

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(xaDataSource);
        atomikosDataSourceBean.setUniqueResourceName("orderDataSource");
        atomikosDataSourceBean.setMaxPoolSize(30);
        atomikosDataSourceBean.setMinPoolSize(5);

        return atomikosDataSourceBean;
    }


    @Bean
    public SqlSessionFactory orderSqlSessionFactory(DataSource orderDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(orderDataSource);
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate orderSqlSessionTemplate(SqlSessionFactory orderSqlSessionFactory) {
        return new SqlSessionTemplate(orderSqlSessionFactory);
    }
}
