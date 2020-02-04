package org.ggyool.reservation.dao;

import static org.ggyool.reservation.dao.PromotionSqls.SELECT_ON_PROMOTION;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class PromotionDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	public PromotionDAO(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("promotion")
				.usingGeneratedKeyColumns("id");
	}
	
	public List<HashMap<String, Object>> selectOnPromotion(){
		return jdbc.query(SELECT_ON_PROMOTION, Collections.emptyMap(), new RowMapper<HashMap<String, Object>>(){
			@Override
			public HashMap<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
				HashMap<String, Object> map = new HashMap<>();
				map.put("id", rs.getInt("id"));
				map.put("productId", rs.getInt("productId"));
				map.put("productImageUrl", rs.getString("productImageUrl"));
				return map;
			}
		});
	}
}








