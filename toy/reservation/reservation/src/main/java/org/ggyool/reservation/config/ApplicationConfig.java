package org.ggyool.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages= {"org.ggyool.reservation.dao", "org.ggyool.reservation.service", "org.ggyoo.reservation.dto"})
@Import(DBConfig.class)
public class ApplicationConfig {

}
