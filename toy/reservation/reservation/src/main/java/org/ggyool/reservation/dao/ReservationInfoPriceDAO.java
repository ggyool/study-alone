package org.ggyool.reservation.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.ggyool.reservation.vo.ReservationInfoPriceVO;
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
	public Integer insert(ReservationInfoPriceVO reservationPriceVO) {
		Map<String, Object> params = new HashMap<>();
		params.put("reservation_info_id", reservationPriceVO.getReservationInfoId());
		params.put("product_price_id", reservationPriceVO.getProductPriceId());
		params.put("count", reservationPriceVO.getCount());
		return insertAction.executeAndReturnKey(params).intValue();
	}
}
