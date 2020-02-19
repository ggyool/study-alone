package org.ggyool.reservation.dao;

public class CommentSqls {
	public static final String SELECT_BY_PRODUCT_ID = 
	"SELECT ruct.comment AS comment " + 
	", ruct.id AS commentId " + 
	", ruct.create_date AS createDate " + 
	", ruct.modify_date AS modifyDate " + 
	", ruct.product_id AS productId " + 
	", rit.reservation_date AS reservationDate " + 
	", rit.reservation_email AS reservationEmail " + 
	", rit.id AS reservationInfoId " + 
	", rit.reservation_name AS reservationName " + 
	", rit.reservation_tel AS reservationTelephone " + 
	", ruct.score AS score " + 
	"FROM reservation_user_comment AS ruct " + 
	"JOIN reservation_info AS rit " + 
	"ON ruct.reservation_info_id = rit.id " + 
	"WHERE ruct.product_id = :productId";
	
	public static final String SELECT_AVERAGE_SCORE = 
	"SELECT ROUND(AVG(score), 1) " + 
	"FROM reservation_user_comment " + 
	"WHERE product_id = :productId";
}
