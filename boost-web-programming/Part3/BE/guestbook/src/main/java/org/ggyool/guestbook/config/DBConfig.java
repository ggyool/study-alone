package org.ggyool.guestbook.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
// transaction 처리를 위한 어노테이션
@EnableTransactionManagement
// 사용자의 처리
public class DBConfig implements TransactionManagementConfigurer{
	
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
	
	@Override
	public TransactionManager annotationDrivenTransactionManager() {
		return null;
	}
	
	@Bean
	public PlatformTransactionManager transactionManger() {
		return new DataSourceTransactionManager(dataSource());
	}

		
}
