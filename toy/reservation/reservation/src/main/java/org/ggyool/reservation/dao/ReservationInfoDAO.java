package org.ggyool.reservation.dao;

import static org.ggyool.reservation.dao.ReservationInfoSqls.SELECT_BY_EMAIL;
import static org.ggyool.reservation.dao.ReservationInfoSqls.SELECT_BY_ID;
import static org.ggyool.reservation.dao.ReservationInfoSqls.UPDATE_AS_CANCEL;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.ggyool.reservation.entity.ReservationInfoEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationInfoDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ReservationInfoEntity> rowMapperreservationInfoEntity = BeanPropertyRowMapper.newInstance(ReservationInfoEntity.class);

	ReservationInfoDAO(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("reservation_info")
				.usingGeneratedKeyColumns("id");
	}
	// 이름이 달라서 맵으로
	public Integer insert(ReservationInfoEntity reservationInfoEntity) {
		Map<String, Object> params = new HashMap<>();
		params.putIfAbsent("id", reservationInfoEntity.getReservationInfoId());
		params.putIfAbsent("product_id", reservationInfoEntity.getProductId());
		params.putIfAbsent("display_info_id", reservationInfoEntity.getDisplayInfoId());
		params.putIfAbsent("reservation_name", reservationInfoEntity.getReservationName());
		params.putIfAbsent("reservation_tel", reservationInfoEntity.getReservationTelephone());
		params.putIfAbsent("reservation_email", reservationInfoEntity.getReservationEmail());
		params.putIfAbsent("reservation_date", reservationInfoEntity.getReservationDate());
		params.putIfAbsent("cancel_flag", reservationInfoEntity.isCancelYn());
		params.putIfAbsent("create_date", reservationInfoEntity.getCreateDate());
		params.putIfAbsent("modify_date", reservationInfoEntity.getModifyDate());
		return insertAction.executeAndReturnKey(params).intValue();
	}
	
	public List<ReservationInfoEntity> selectByEmail(String reservationEmail){
		String sql = SELECT_BY_EMAIL;
		return jdbc.query(sql, Collections.singletonMap("reservationEmail", reservationEmail), rowMapperreservationInfoEntity);		
	}
	
	public Boolean updateAsCancel(Integer reservationInfoId) {
		String sql = UPDATE_AS_CANCEL;
		return jdbc.update(sql, Collections.singletonMap("reservationInfoId", reservationInfoId))>0?true:false;
	}
	
	public ReservationInfoEntity selectById(Integer reservationInfoId) {
		String sql = SELECT_BY_ID;
		return jdbc.queryForObject(sql, Collections.singletonMap("reservationInfoId", reservationInfoId), rowMapperreservationInfoEntity);
	}
}







