package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam03 {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
//		Car car = (Car) ac.getBean("c");
		Car car = (Car) ac.getBean(Car.class); //싱글턴 패턴이라 가능한 짓이다.
		car.run();
//		DI의 장점 : 굳이 engine을 알지 않아도, Car에 연계된 Engine 클래스를 활용할 수 있다. 
	}

}
