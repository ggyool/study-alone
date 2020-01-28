package org.ggyool.daoexam.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
// 트랜잭션 처리를 위해 필요한 어노테이션
@EnableTransactionManagement
public class DBConfig {
	private String driverClassName = "com.mysql.jdbc.Driver";
	private String url = 
"jdbc:mysql://localhost:3306/connectdb?useSSL=true&verifyServerCertificate=false&"
+ "useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul";
	private String username = "connectuser";
	private String password = "connect123!@#";
		
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource(); 
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
}
