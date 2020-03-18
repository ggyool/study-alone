package org.ggyool.reservation.dao;

public class CommentImageSqls {
	public static final String SELECT_BY_COMMENT_ID =
	"SELECT fit.content_type AS contentType " + 
	", fit.create_date AS createDate " + 
	", fit.delete_flag AS deleteFlag " + 
	", rucit.file_id AS fileId " + 
	", fit.file_name AS fileName " + 
	", rucit.id AS imageId " + 
	", fit.modify_date AS modifyDate " +
	", rucit.reservation_info_id AS reservationInfoId " + 
	", rucit.reservation_user_comment_id AS reservationUserCommentId " + 
	", fit.save_file_name AS saveFileName " + 
	"FROM reservation_user_comment_image AS rucit " + 
	"JOIN file_info AS fit " + 
	"ON rucit.file_id = fit.id " + 
	"WHERE rucit.reservation_user_comment_id = :commentId";
	
	public static final String SELECT_BY_ID = 
	"SELECT rucit.id AS commentImageId " +
	", rucit.file_id AS fileId " +
	", fit.file_name AS fileName " +
	", fit.save_file_name AS saveFileName " +
	", fit.content_type AS contentType " +
	", fit.delete_flag AS deleteFlag " +
	", fit.create_date AS createDate " +
	", fit.modify_date AS modifyDate " +
	"FROM reservation_user_comment_image AS rucit " +
	"JOIN file_info AS fit " +
	"ON rucit.file_id = fit.id " +
	"WHERE rucit.id = :commentImageId";
}
