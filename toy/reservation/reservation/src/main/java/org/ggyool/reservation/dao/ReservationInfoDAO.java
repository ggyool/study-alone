package org.ggyool.reservation.dao;

import javax.sql.DataSource;

import org.ggyool.reservation.vo.ReservationInfoVO;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationInfoDAO {
private SimpleJdbcInsert insertAction;
	
	public ReservationInfoDAO(DataSource dataSource) {
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("reservation_info")
				.usingGeneratedKeyColumns("id");
	}
	public Integer insert(ReservationInfoVO reservationInfoVO) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfoVO);
		return insertAction.executeAndReturnKey(params).intValue();
	}
}
