package org.ggyool.reservation.dao;

import static org.ggyool.reservation.dao.ProductSqls.SELECT;
import static org.ggyool.reservation.dao.ProductSqls.SELECT_BY_CATEGORY;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.ggyool.reservation.entity.ProductEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ProductEntity> rowMapper = BeanPropertyRowMapper.newInstance(ProductEntity.class);
	
	public ProductDAO(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("product")
				.usingGeneratedKeyColumns("id");
	}
	
	public Integer insert(ProductEntity productEntity) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(productEntity);
		return insertAction.executeAndReturnKey(params).intValue();
	}

	public List<Map<String, Object>> selectByCategoryId(Integer categoryId, int start, int limit){
		String sql = SELECT_BY_CATEGORY;
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.queryForList(sql, params);
	}
	
	public ProductEntity select(Integer productId) {
		String sql = SELECT;
		return jdbc.queryForObject(sql, Collections.singletonMap("productId", productId), rowMapper);
	}
}




