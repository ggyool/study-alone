package org.ggyool.reservation.dao;

import static org.ggyool.reservation.dao.CommentImageSqls.SELECT_BY_COMMENT_ID;
import static org.ggyool.reservation.dao.CommentImageSqls.SELECT_BY_ID;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.ggyool.reservation.dto.CommentImageDTO;
import org.ggyool.reservation.vo.CommentImageVO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentImageDAO {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<CommentImageDTO> commentImageDTOMapper = BeanPropertyRowMapper.newInstance(CommentImageDTO.class);
	private RowMapper<CommentImageVO> commentImageVOMapper = BeanPropertyRowMapper.newInstance(CommentImageVO.class);
	
	public CommentImageDAO(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	public List<CommentImageDTO> selectByCommentId(Integer commentId){
		String sql = SELECT_BY_COMMENT_ID;	
		return jdbc.query(sql, Collections.singletonMap("commentId", commentId), commentImageDTOMapper);
	}
	public CommentImageVO selectById(Integer commentImageId) {
		String sql = SELECT_BY_ID;	
		return jdbc.queryForObject(sql, Collections.singletonMap("commentImageId", commentImageId), commentImageVOMapper);
	}
}
