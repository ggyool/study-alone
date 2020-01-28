package org.ggyool.daoexam.dao;

// static import 를 하면 클래스 명 아래에서 사용 시 생략할 수 있다.
import static org.ggyool.daoexam.dao.RoleDaoSqls.DELETE_BY_ROLE_ID;
import static org.ggyool.daoexam.dao.RoleDaoSqls.SELECT_ALL;
import static org.ggyool.daoexam.dao.RoleDaoSqls.SELECT_BY_ROLE_ID;
import static org.ggyool.daoexam.dao.RoleDaoSqls.UPDATE;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.ggyool.daoexam.dto.Role;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	// BeanPropertyRowMapper 는 db의 column명 role_id 와 dto의 member roldId 를 맞춰준다.
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);
	
	public RoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("role");
	}
	
	public List<Role> selectAll(){
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
	}
	
	public int insert(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		// execute 안에는 Map<string, ?> 를 넣어야 한다.
		return insertAction.execute(params);
	}
	
	public int update(Role role) {
		// parameter 이름 맞춰서 map 으로 바꿔준다.
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return jdbc.update(UPDATE, params);
	}
	
	// 위 처럼 SqlParameterSource 안쓰고 Integer 하나만 필요하므로 singletoneMap 이용하여 직접 Map 생성
	public int deleteById(Integer id) {
		Map<String, ?> params = Collections.singletonMap("roleId", id);
		return jdbc.update(DELETE_BY_ROLE_ID, params);
	}
	
	public Role selectById(Integer id) {
		try {
			Map<String, ?> params = Collections.singletonMap("roleId", id);
			// 한건 select 는 queryForObject
			return jdbc.queryForObject(SELECT_BY_ROLE_ID, params, rowMapper);
		} catch(EmptyResultDataAccessException e) {
			// 해당 조건의 값이 없으면 해당 Exception 발생하기 떄문에 return null
			return null;
		}
		
	}
}
