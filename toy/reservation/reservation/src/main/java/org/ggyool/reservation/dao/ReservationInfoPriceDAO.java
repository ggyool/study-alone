package org.ggyool.reservation.dao;

import static org.ggyool.reservation.dao.ReservationInfoPriceSqls.SELECT_BY_RESERVATION_INFO_ID;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.ggyool.reservation.entity.ReservationInfoPriceEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationInfoPriceDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ReservationInfoPriceEntity> rowMapperReservationInfoPriceEntity = BeanPropertyRowMapper.newInstance(ReservationInfoPriceEntity.class);
	
	public ReservationInfoPriceDAO(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("reservation_info_price")
				.usingGeneratedKeyColumns("id");
	}
	public Integer insert(ReservationInfoPriceEntity reservationPriceEntity) {
//		Map<String, Object> params = new HashMap<>();
//		params.put("reservation_info_id", reservationPriceEntity.getReservationInfoId());
//		params.put("product_price_id", reservationPriceEntity.getProductPriceId());
//		params.put("count", reservationPriceEntity.getCount());
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationPriceEntity);
		return insertAction.executeAndReturnKey(params).intValue();
	}
	// ReservationInfoPriceVO + productPriceId + discountRate
	public List<Map<String, Object>> selectByReservationInfoId(Integer reservationInfoId){
		String sql = SELECT_BY_RESERVATION_INFO_ID;
		Map<String, Object> params = Collections.singletonMap("reservationInfoId", reservationInfoId);
		return jdbc.queryForList(sql, params);
	}
}






