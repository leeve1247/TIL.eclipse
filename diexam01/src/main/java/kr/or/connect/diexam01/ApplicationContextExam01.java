package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		//src 폴더에 생성한 xml 파일은 자동으로 classpath에 등록이 된다.
		//ClassPathXmlApplicationContex 실행할 때, xml파일에 선언된 객체를 모두 메모리에 올려놓는다. (여기서는 userBean 하나)
		System.out.println("초기화 완료.");
		
		UserBean userBean = (UserBean)ac.getBean("userBean");
		userBean.setName("kim");
		System.out.println(userBean.getName());
		
		UserBean userBean2 = (UserBean)ac.getBean("userBean");
		//겟빈을 계속해도 계속 만드는게 아니라, 싱글턴 패턴이라 있는 걸 그대로 쓰게 된다.
		if(userBean == userBean2) {
			System.out.println("같은 인스턴스이다.");
			
		//IOC 제어의 역전, 싱글턴으로 객체를 대신 생성하고, 싱글턴으로 관리해주는 기능
		}
	}
}