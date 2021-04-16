package kr.or.connect.diexam01;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam02 {
	public static void main(String[] args) {
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Car car = (Car) ac.getBean("c");
		car.run();
//		DI의 장점 : 굳이 engine을 알지 않아도, Car에 연계된 Engine 클래스를 활용할 수 있다. 
		ac.close();
	}

}
