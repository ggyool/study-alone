package org.ggyool.reservation.dao;

import static org.ggyool.reservation.dao.DisplayInfoImageSqls.SELECT_BY_ID;

import java.util.Collections;

import javax.sql.DataSource;

import org.ggyool.reservation.dto.DisplayInfoImageDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DisplayInfoImageDAO {	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfoImageDTO> displayInfoImageMapper= BeanPropertyRowMapper.newInstance(DisplayInfoImageDTO.class);
	public DisplayInfoImageDAO(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	public DisplayInfoImageDTO selectById(Integer displayInfoId) {
		String sql = SELECT_BY_ID;	
		return jdbc.queryForObject(sql, Collections.singletonMap("displayInfoId", displayInfoId), displayInfoImageMapper);
	}
}
