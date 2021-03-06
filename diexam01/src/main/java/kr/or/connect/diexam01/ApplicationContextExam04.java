package kr.or.connect.diexam01;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam04 {
	public static void main(String[] args) {
		ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig2.class);
		
		Car car = (Car) ac.getBean(Car.class); //싱글턴 패턴이라 가능한 짓이다.
		car.run(); 
		ac.close();
	}

}
