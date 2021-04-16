package kr.or.connect.daoexam.dao;

public class RoleDaoSqls {
	public static final String SELECT_ALL = "SELECT role_id, description FROM role ORDER BY role_id";
	// 상수 static final, 상수 변수명은 대문자로 해주웁시이다
	public static final String UPDATE = "UPDATE role SET description = :description WHERE role_id = :roleId";
	// query 문의 변수 _소문자 -> :대문자로 전환
	public static final String DELETE_BY_ROLE_ID  = "DELETE FROM role WHERE role_id = :roleId";
	//	"DELETE FROM role WHERE role_id = ?"
	public static final String SELECT_BY_ROLE_ID = "SELECT role_id, description FROM role WHERE role_id = :roleId";
}

