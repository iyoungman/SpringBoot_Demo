package com.youngman.mybatisdemo.account;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Created by YoungMan on 2019-12-11.
 */

@Configuration
public class MyBatisConfig {

	private static final String TYPE_ALIASES_PACKAGE = "com.youngman.mybatisdemo.account";

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource datasource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(datasource);
		sqlSessionFactory.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);

		//쿼리 작성 xml 위치 설정
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*.xml"));
		return sqlSessionFactory.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}

