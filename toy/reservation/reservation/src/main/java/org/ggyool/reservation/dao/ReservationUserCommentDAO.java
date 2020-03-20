package org.ggyool.reservation.dao;

import javax.sql.DataSource;

import org.ggyool.reservation.entity.ReservationUserCommentEntity;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationUserCommentDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	ReservationUserCommentDAO(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("reservation_user_comment")
				.usingGeneratedKeyColumns("id");
	}
	
	public Integer insert(ReservationUserCommentEntity reservationUserCommentEntity) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationUserCommentEntity);
		return insertAction.executeAndReturnKey(params).intValue();
	}
}
