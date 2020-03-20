package org.ggyool.reservation.dao;

import javax.sql.DataSource;

import org.ggyool.reservation.entity.FileInfoEntity;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class FileInfoDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	FileInfoDAO(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("file_info")
				.usingGeneratedKeyColumns("id");
	}
	
	public Integer insert(FileInfoEntity fileInfoEntity) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(fileInfoEntity);
		return insertAction.executeAndReturnKey(params).intValue();
	}
}
