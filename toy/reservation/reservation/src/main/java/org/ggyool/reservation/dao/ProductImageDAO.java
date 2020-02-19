package org.ggyool.reservation.dao;

import static org.ggyool.reservation.dao.ProductImageSqls.SELECT_BY_ID;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.ggyool.reservation.dto.ProductImageDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductImageDAO {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductImageDTO> productImageMapper= BeanPropertyRowMapper.newInstance(ProductImageDTO.class);
	public ProductImageDAO(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	public List<ProductImageDTO> selectById(Integer productId){
		String sql = SELECT_BY_ID;
		return jdbc.query(sql, Collections.singletonMap("productId", productId), productImageMapper);
	}
}
