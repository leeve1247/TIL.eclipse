package kr.or.connect.diexam01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/*
 * annotation ? 주석이긴 한데, spring framework 는 이 configuration을 활용해서 IoC와 DI를 적용함
 * 알아서 객체 넣어주고 기타등등승을 관리해주니 개발자는 매우 편해진다.
 */
public class ApplicationConfig {
	@Bean
	public Car car(Engine e) {
		Car c = new Car();
		c.setEngine(e);
		return c;
	}
	
	@Bean
	public Engine engine() {
		return new Engine();
	}
}
