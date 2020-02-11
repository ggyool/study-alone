package org.ggyool.reservation.dao;

import static org.ggyool.reservation.dao.PromotionSqls.SELECT_ON_PROMOTION;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public List<Map<String, Object>> selectOnPromotion(){
		return jdbc.queryForList(SELECT_ON_PROMOTION, Collections.emptyMap());
	}
}








