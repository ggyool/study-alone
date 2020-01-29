package org.ggyool.guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages= {"org.ggyool.guestbook.dao", "org.ggyool.guestbook.service"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
