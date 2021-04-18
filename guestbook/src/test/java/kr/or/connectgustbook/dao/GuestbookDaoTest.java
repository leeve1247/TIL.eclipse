package kr.or.connectgustbook.dao;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.or.connect.guestbook.config.ApplicationConfig;
import kr.or.connect.guestbook.dao.GuestbookDao;
import kr.or.connect.guestbook.dto.Guestbook;

public class GuestbookDaoTest {
	public static void main(String[] args) {
		AbstractApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		GuestbookDao guestbookDao = ac.getBean(GuestbookDao.class);
		
		Guestbook guestbook = new Guestbook();
		guestbook.setName("유재석");
		guestbook.setContent("똥마려워요");
		guestbook.setRegdate(new Date());
		Long id = guestbookDao.insert(guestbook);
		System.out.println("id : " + id);
		
		ac.close();
	}
}
