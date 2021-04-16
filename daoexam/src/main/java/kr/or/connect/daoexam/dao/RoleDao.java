package kr.or.connect.daoexam.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.daoexam.dto.Role;
import static kr.or.connect.daoexam.dao.RoleDaoSqls.*;
// static을 사용할 경우 class 명을 적을 필요없이 즉각 반영 가능
@Repository
public class RoleDao {
	private NamedParameterJdbcTemplate jdbc;
	//Spring JDBC에서 가장 중요한 객체가 JdbcTemplate
	//이름을 이용해서 바인딩 하거나, 결과 값을 가져올 때 사용할 수 있어요.
	private SimpleJdbcInsert insertAction;	
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);
//	BeanPropertyRowMapper는 dbms와 java의 단어를 구분하는 역할을 수행한다.(role_id, roleId 를 똑같게 해준다.)
	public RoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("role");
	}
	
	
	public List<Role> selectAll(){	//메소드의 첫번째 단어는 소문자
		return jdbc.query(SELECT_ALL, Collections.<String, Object>emptyMap() , rowMapper);
//		query() 메서드는 결과가 여러건이었을 경우 내부적으로 반복적으로 DTO를 생성, 최종적으론 list를 반환
//		(DTO란 옮겨지는 데이터 객체를 생각하자, 트럭에 실린 짐짝)
	}
	
	public int insert(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return insertAction.execute(params);
	}
	
	public int update(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return jdbc.update(UPDATE, params);
	}
	
	public int deleteById(Integer id) {
		Map<String, ?> params = Collections.singletonMap("roleId", id);
		//Map은 마치 Dictionary 타입과 같다아
		return jdbc.update(DELETE_BY_ROLE_ID, params);
	}
	
	public Role selectById(Integer id) {
		try {
			Map<String, ?> params = Collections.singletonMap("roleId", id);
			return jdbc.queryForObject(SELECT_BY_ROLE_ID, params, rowMapper);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}


	
	
}
