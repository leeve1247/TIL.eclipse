package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDVCExam4 {
	public static void main(String[] args) {
		int roleId = 500;
		
		Role role = new Role(roleId);
		RoleDao dao = new RoleDao();
		int deleteCount = dao.deleteRole(role);
		
		System.out.println(deleteCount);
	}
}
