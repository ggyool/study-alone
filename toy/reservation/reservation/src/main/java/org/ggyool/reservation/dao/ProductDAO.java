package org.ggyool.reservation.dao;

import static org.ggyool.reservation.dao.ProductSqls.SELECT_BY_CATEGORY;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.ggyool.reservation.dto.ProductDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
//	private RowMapper<ProductDTO> rowMapper = BeanPropertyRowMapper.newInstance(ProductDTO.class);
	
	public ProductDAO(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("product")
				.usingGeneratedKeyColumns("id");
	}
	
	public Integer insert(ProductDTO productDTO) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(productDTO);
		return insertAction.executeAndReturnKey(params).intValue();
	}

	public List<HashMap<String, Object>> selectByCategoryId(Integer categoryId, int start, int limit){
		String sql = SELECT_BY_CATEGORY;
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(sql, params, new RowMapper<HashMap<String, Object>>() {
			@Override
			public HashMap<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
				HashMap<String, Object> map = new HashMap<>();
				map.put("productId", rs.getInt("productId"));
				map.put("displayInfoId", rs.getInt("displayInfoId"));
				map.put("productContent", rs.getString("productContent"));
				map.put("productDescription", rs.getString("productDescription"));
				map.put("placeName", rs.getString("placeName"));
				map.put("productImageUrl", rs.getString("productImageUrl"));
				return map;
			}
		});	
	}
}




