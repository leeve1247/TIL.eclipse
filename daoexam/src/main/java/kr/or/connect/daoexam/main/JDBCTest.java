package kr.or.connect.daoexam.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
import kr.or.connect.daoexam.dao.RoleDao;
import kr.or.connect.daoexam.dto.Role;

public class JDBCTest {
	public static void main(String[] args) {
		ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		RoleDao roleDao = ac.getBean(RoleDao.class);

		Role role = new Role();
		role.setroleId(333);
		role.setDescription("Programmer");

		/*
		 * int count = roleDao.update(role); System.out.println(count + "건 수정하였습니다.");
		 */

		int count = roleDao.insert(role);
		System.out.println(count + "건 입력하였습니다.");

		Role resultRole = roleDao.selectById(333);
		System.out.println(resultRole.toString());

		int deleteCount = roleDao.deleteById(333);
		System.out.println(deleteCount + "건 삭제하였습니다.");
		ac.close();
	}
}
