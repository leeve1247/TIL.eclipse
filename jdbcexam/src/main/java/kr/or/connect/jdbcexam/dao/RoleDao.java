package kr.or.connect.jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.connect.jdbcexam.db;
import kr.or.connect.jdbcexam.dto.*;

public class RoleDao {
	//github 업로드용으로 보안정보 클래스화
	private static String dburl = db.Url();
	private static String dbUser = db.User();
	private static String dbpasswd = db.Passwd();
	
	public Role getRole(Integer roleId) {
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
//		예외처리 시작
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "SELECT role_id, description FROM role WHERE role_id = ?";
//			물음표의 정체? : 이후 setInt와 동기화 되는데, 첫번째 ? 부터 숫자 태그가 붙는다.
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);
//			첫번째 물음표에 roleId의 값을 넣는다.
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String description = rs.getString("description");
//				숫자도가능 (rs.getString("1")), 이러면 쿼리문으로 가져온 컬럼순서에서 첫번째를 꺼내줌
				int id = rs.getInt("role_id");
				role = new Role(id, description);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		//파이널리에 적어서, 뭐든지 무조건 닫아 버린다.
			if(conn != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		}
		
		return role;
	}

}
