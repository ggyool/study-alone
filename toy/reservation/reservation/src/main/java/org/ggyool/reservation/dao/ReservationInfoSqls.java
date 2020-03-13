package org.ggyool.reservation.dao;

public class ReservationInfoSqls {
	public static final String SELECT_BY_EMAIL = 
	"SELECT rit.id AS reservationInfoId "
	+ ",rit.product_id AS productId "
	+ ",rit.display_info_id AS displayInfoId "
	+ ",rit.reservation_name AS reservationName "
	+ ",rit.reservation_tel AS reservationTelephone "
	+ ",rit.reservation_email AS reservationEmail "
	+ ",rit.reservation_date AS reservationDate "
	+ ",rit.cancel_flag AS cancelYn "
	+ ",rit.create_date AS createDate "
	+ ",rit.modify_date AS modifyDate "
	+ "FROM reservation_info AS rit "
	+ "WHERE rit.reservation_email = :{reservationEmail} "
	+ "ORDER BY rit.reservation_date";
	
	public static final String UPDATE_AS_CANCEL = 
	"UPDATE reservation_info SET cancel_flag=1 WHERE id=:{reservationInfoId}";
	
	public static final String SELECT_BY_ID =
	"SELECT rit.id AS reservationInfoId "
	+ ",rit.product_id AS productId "
	+ ",rit.display_info_id AS displayInfoId "
	+ ",rit.reservation_name AS reservationName "
	+ ",rit.reservation_tel AS reservationTelephone "
	+ ",rit.reservation_email AS reservationEmail "
	+ ",rit.reservation_date AS reservationDate "
	+ ",rit.cancel_flag AS cancelYn "
	+ ",rit.create_date AS createDate "
	+ ",rit.modify_date AS modifyDate "
	+ "FROM reservation_info AS rit "
	+ "WHERE rit.id = :{reservationInfoId}";

}
