package org.ggyool.reservation.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.ggyool.reservation.vo.ReservationInfoVO;
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
		Map<String, Object> params = new HashMap<>();
		params.putIfAbsent("id", reservationInfoVO.getReservationInfoId());
		params.putIfAbsent("product_id", reservationInfoVO.getProductId());
		params.putIfAbsent("display_info_id", reservationInfoVO.getDisplayInfoId());
		params.putIfAbsent("reservation_name", reservationInfoVO.getReservationName());
		params.putIfAbsent("reservation_tel", reservationInfoVO.getReservationTelephone());
		params.putIfAbsent("reservation_email", reservationInfoVO.getReservationEmail());
		params.putIfAbsent("reservation_date", reservationInfoVO.getReservationDate());
		params.putIfAbsent("cancel_flag", reservationInfoVO.isCancelYn());
		params.putIfAbsent("create_date", reservationInfoVO.getCreateDate());
		params.putIfAbsent("modify_date", reservationInfoVO.getModifyDate());
		return insertAction.executeAndReturnKey(params).intValue();
	}
}
