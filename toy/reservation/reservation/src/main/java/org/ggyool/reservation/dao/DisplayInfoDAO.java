package org.ggyool.reservation.dao;

import static org.ggyool.reservation.dao.DisplayInfoSqls.SELECT_BY_ID;

import java.util.Collections;

import javax.sql.DataSource;

import org.ggyool.reservation.dto.DisplayInfoDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DisplayInfoDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfoDTO> displayInfoMapper= BeanPropertyRowMapper.newInstance(DisplayInfoDTO.class);
	public DisplayInfoDAO(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	public DisplayInfoDTO selectById(Integer displayInfoId) {
		String sql = SELECT_BY_ID;
		return jdbc.queryForObject(sql, Collections.singletonMap("displayInfoId", displayInfoId), displayInfoMapper);
	}
}