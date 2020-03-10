package org.ggyool.reservation.dao;

import static org.ggyool.reservation.dao.ProductPriceSqls.SELECT_BY_ID;
import static org.ggyool.reservation.dao.ProductPriceSqls.SELECT_BY_PRODUCT_ID;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.ggyool.reservation.entity.ProductPriceEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductPriceDAO {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductPriceEntity> productPriceMapper = BeanPropertyRowMapper.newInstance(ProductPriceEntity.class);
	public ProductPriceDAO(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	public List<ProductPriceEntity> selectByProductId(Integer productId){
		String sql = SELECT_BY_PRODUCT_ID;
		return jdbc.query(sql, Collections.singletonMap("productId", productId), productPriceMapper);
	}
	public ProductPriceEntity selectById(Integer productPriceId){
		String sql = SELECT_BY_ID;
		return jdbc.queryForObject(sql, Collections.singletonMap("productPriceId", productPriceId), productPriceMapper);
	}
}
