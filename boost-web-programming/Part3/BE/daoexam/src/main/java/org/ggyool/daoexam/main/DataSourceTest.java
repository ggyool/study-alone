package org.ggyool.daoexam.main;

import java.sql.Connection;

import javax.sql.DataSource;

import org.ggyool.daoexam.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DataSourceTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		DataSource ds = ac.getBean(DataSource.class); 
		Connection conn = null;
		try {
			conn = ds.getConnection();
			if(conn != null) {
				System.out.println("success");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try{
					conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
