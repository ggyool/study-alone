package org.ggyool.reservation.dao;

import static org.ggyool.reservation.dao.CommentSqls.SELECT_AVERAGE_SCORE;
import static org.ggyool.reservation.dao.CommentSqls.SELECT_BY_PRODUCT_ID;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.ggyool.reservation.dto.CommentDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAO {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<CommentDTO> commentMapper = BeanPropertyRowMapper.newInstance(CommentDTO.class);
	
	public CommentDAO(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	public List<CommentDTO> selectByProductId(Integer productId){
		String sql = SELECT_BY_PRODUCT_ID;
		return jdbc.query(sql, Collections.singletonMap("productId", productId), commentMapper);
	}
	public Double selectAverageScore(Integer productId) {
		String sql = SELECT_AVERAGE_SCORE;
		return jdbc.queryForObject(sql, Collections.singletonMap("productId", productId), Double.class);
	}
}
