package kr.co.itcen.jblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import kr.co.itcen.jblog.app.DBConfig;
import kr.co.itcen.jblog.app.MyBatisConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"kr.co.itcen.jblog.service", "kr.co.itcen.jblog.repository", "kr.co.itcen.jblog.aspect"})
@Import({DBConfig.class, MyBatisConfig.class})	//DB설정 클래스와, Mybatis설정 클래스를 주입해주는 기능 
public class AppConfig {

}
