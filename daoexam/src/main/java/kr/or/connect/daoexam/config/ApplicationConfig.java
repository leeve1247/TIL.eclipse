package kr.or.connect.daoexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"kr.or.connect.daoexm.dao"})
//"kr.or.connect.daoexm.dao"에 있는 녀석들을 @Bean으로 등록해준 것과 동일한 역할을 수행해준다.
//basePackages 를 사용할 경우, ComponentScan를 여러개 할 수 있다아
@Import({DBConfig.class})
//@Import 설정파일을 여러개로 나눠서 관리할 수 있다.
public class ApplicationConfig {

}
