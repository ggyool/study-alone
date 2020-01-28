package org.ggyool.daoexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan(basePackages = {"org.ggyool.daoexam.dao"})
// 설정 파일을 여러파일에 나눌 수 있다. 
// (db 연결관련한 것은 따로 뺴고싶은 상황)
@Import({DBConfig.class})
public class ApplicationConfig {

}
