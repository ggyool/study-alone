package org.ggyool.reservation.dao;

import javax.sql.DataSource;

import org.ggyool.reservation.vo.ReservationInfoPriceVO;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationInfoPriceDAO {
	
	private SimpleJdbcInsert insertAction;
	
	public ReservationInfoPriceDAO(DataSource dataSource) {
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("reservation_info_price")
				.usingGeneratedKeyColumns("id");
	}
	public Integer insert(ReservationInfoPriceVO reservationPriceVo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationPriceVo);
		return insertAction.executeAndReturnKey(params).intValue();
	}
}
