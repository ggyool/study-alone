package org.ggyool.reservation.dao;

import javax.sql.DataSource;

import org.ggyool.reservation.entity.ReservationUserCommentImageEntity;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationUserCommentImageDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	ReservationUserCommentImageDAO(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("reservation_user_comment_image")
				.usingGeneratedKeyColumns("id");
	}
	
	public Integer insert(ReservationUserCommentImageEntity reservationUserCommentImageEntity){
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationUserCommentImageEntity);
		return insertAction.executeAndReturnKey(params).intValue();
	}
}
