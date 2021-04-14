package kr.or.connect.jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.jdbcexam.DB;
import kr.or.connect.jdbcexam.dto.*;

public class RoleDao {
	// github 업로드용으로 보안정보 클래스화
	private static String dburl = DB.Url();
	private static String dbUser = DB.User();
	private static String dbpasswd = DB.Passwd();
	private static String classpath = "org.mariadb.jdbc.Driver";

	public List<Role> getRoles() {
//		List의 객체에 접근 할 수 있는 ListIterator를 반환한다.
		List<Role> list = new ArrayList<>();

		try {
			Class.forName(classpath);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT description, role_id FROM role ORDER BY role_id DESC";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
//			소괄호로 가둔 변수 선언은 try가 끝나면 알아서 close해준다
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					String description = rs.getString(1);
					int id = rs.getInt("role_id");
					Role role = new Role(id, description);
					list.add(role); // rs.next()에 false 반환때까지 무한 반복,
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public int editRole(Role role) {
		int updateCount = 0;
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			Class.forName(classpath);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "UPDATE role SET description=? WHERE role_id=?";

		try {
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			ps = conn.prepareStatement(sql);

			ps.setString(1, role.getDescription());
			ps.setInt(2, role.getRoleId());

			updateCount = ps.executeUpdate();
			// 실행하면 업데이트 횟수를 리턴스함

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 파이널리에 적어서, 뭐든지 무조건 닫아 버린다.
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return updateCount;
	}

	public int addRole(Role role) {
		int insertCount = 0;
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			Class.forName(classpath);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO role (role_id, description) VALUES (?,?)";

		try {
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			ps = conn.prepareStatement(sql);

			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());

			insertCount = ps.executeUpdate();
			// 실행하면 업데이트 횟수를 리턴스함

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 파이널리에 적어서, 뭐든지 무조건 닫아 버린다.
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return insertCount;

	}

	public int deleteRole(Role role) {
		int deleteCount = 0;
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			Class.forName(classpath);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "DELETE FROM role WHERE role_id = ?";

		try {
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			ps = conn.prepareStatement(sql);

			ps.setInt(1, role.getRoleId());

			deleteCount = ps.executeUpdate();
			// 실행하면 업데이트 횟수를 리턴스함

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 파이널리에 적어서, 뭐든지 무조건 닫아 버린다.
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return deleteCount;

	}

	public Role getRole(Integer roleId) {
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

//		예외처리 시작
		try {
			Class.forName(classpath);
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "SELECT role_id, description FROM role WHERE role_id = ?";
//			prepareStatement 특징 물음표의 정체? : 이후 setInt와 동기화 되는데, 첫번째 ? 부터 숫자 태그가 붙는다.
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);
//			첫번째 물음표에 roleId의 값을 넣는다.
			rs = ps.executeQuery();

			if (rs.next()) {
				String description = rs.getString("description");
//				숫자도가능 (rs.getString("1")), 이러면 쿼리문으로 가져온 컬럼순서에서 첫번째를 꺼내줌
				int id = rs.getInt("role_id");
				role = new Role(id, description);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 파이널리에 적어서, 뭐든지 무조건 닫아 버린다.
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
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
