package kr.kimyonghwan.dao;

//변수를 클래스 이름없이 바로 가져다 사용가능
import static kr.kimyonghwan.dao.RoleDaoSqls.SELECT_ALL;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.kimyonghwan.dto.Role;


@Repository
public class RoleDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);
	
		public RoleDao(DataSource dataSource) {
			this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		}
		
	public List<Role> selectAll(){ //바인딩한 값을 전달할 목적으로 생성된 객체
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
	}
	
	
	
}
