package org.ggyool.reservation.dao;

import static org.ggyool.reservation.dao.ReservationInfoPriceSqls.SELECT_BY_RESERVATION_INFO_ID;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.ggyool.reservation.vo.ReservationInfoPriceVO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationInfoPriceDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ReservationInfoPriceVO> rowMapperReservationInfoPriceVO = BeanPropertyRowMapper.newInstance(ReservationInfoPriceVO.class);
	
	public ReservationInfoPriceDAO(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("reservation_info_price")
				.usingGeneratedKeyColumns("id");
	}
	public Integer insert(ReservationInfoPriceVO reservationPriceVO) {
		Map<String, Object> params = new HashMap<>();
		params.put("reservation_info_id", reservationPriceVO.getReservationInfoId());
		params.put("product_price_id", reservationPriceVO.getProductPriceId());
		params.put("count", reservationPriceVO.getCount());
		return insertAction.executeAndReturnKey(params).intValue();
	}
	public List<ReservationInfoPriceVO> selectByReservationInfoId(Integer reservationInfoId){
		String sql = SELECT_BY_RESERVATION_INFO_ID;
		Map<String, Object> params = Collections.singletonMap("reservationInfoId", reservationInfoId);
		return jdbc.query(sql, params, rowMapperReservationInfoPriceVO);
	}
}






