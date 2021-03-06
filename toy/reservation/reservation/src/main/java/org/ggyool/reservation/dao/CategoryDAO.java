package org.ggyool.reservation.dao;

import static org.ggyool.reservation.dao.CategorySqls.COUNT_PRODUCTS_BY_CATEGORY_ID;
import static org.ggyool.reservation.dao.CategorySqls.SELECT_ALL;
import static org.ggyool.reservation.dao.CategorySqls.SELECT_WITH_COUNT;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.ggyool.reservation.entity.CategoryEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<CategoryEntity> rowMapper = BeanPropertyRowMapper.newInstance(CategoryEntity.class);
	
	public CategoryDAO(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("category")
				.usingGeneratedKeyColumns("id");
	}
	
	public Integer insert(CategoryEntity CategoryEntity) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(CategoryEntity);
		return insertAction.executeAndReturnKey(params).intValue();
	}
	
	public List<CategoryEntity> selectAll(){
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
	}
	// queryForList 안쓰고 query 쓰는걸로 하나 남겨두었음
	public List<HashMap<String, Object>> selectWithCount(){
		return jdbc.query(SELECT_WITH_COUNT, Collections.emptyMap(), new RowMapper<HashMap<String, Object>>() {
			@Override
			public HashMap<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("count", rs.getInt("count"));
				map.put("id", rs.getInt("id"));
				map.put("name", rs.getString("name"));
				return map;
			}
		});
	}
	
	public Integer countProducts(Integer categoryId) {
		Map<String, Integer> params = Collections.singletonMap("categoryId", categoryId);
		return jdbc.queryForObject(COUNT_PRODUCTS_BY_CATEGORY_ID, params, Integer.class);
	}

}








