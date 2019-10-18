package kr.co.itcen.jblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"kr.co.itcen.jblog.service", "kr.co.itcen.jblog.repository", "kr.co.itcen.jblog.aspect"})
@Import({})	//DB설정 클래스와, Mybatis설정 클래스를 주입해주는 기능 
public class AppConfig {

}
