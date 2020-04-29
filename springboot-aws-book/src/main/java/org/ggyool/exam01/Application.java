package org.ggyool.exam01;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing // JPA Auditing 활성화
// 스프링 부트 자동 설정, bean 읽기와 생성 자동 설정
// 이 클래스는 프로젝트의 최상단에 위치해야 함
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 내장 was 실행
        SpringApplication.run(Application.class, args);
    }
}
