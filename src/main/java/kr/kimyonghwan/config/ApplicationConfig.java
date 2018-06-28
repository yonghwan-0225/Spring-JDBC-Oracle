package kr.kimyonghwan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages= {"kr.kimyonghwan.dao"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
