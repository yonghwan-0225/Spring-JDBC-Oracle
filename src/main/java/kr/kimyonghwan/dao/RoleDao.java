package kr.kimyonghwan.dao;

//변수를 클래스 이름없이 바로 가져다 사용가능
import static kr.kimyonghwan.dao.RoleDaoSqls.*;

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

import kr.kimyonghwan.dto.Role;

@Repository
public class RoleDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

	public RoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("nation");
	}

	public List<Role> selectAll() { // 바인딩한 값을 전달할 목적으로 생성된 객체
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);

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
		Map<String, ?> params = Collections.singletonMap("Order_NO", id);
		return jdbc.update(DELETE_BY_ORDER_NO, params);
	}

	public Role selectById(Integer id) {
		try {
			Map<String, ?> params = Collections.singletonMap("Order_NO", id);
			return jdbc.queryForObject(SELECT_BY_ORDER_NO, params, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
