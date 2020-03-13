package org.ggyool.reservation.dao;

public class ReservationInfoPriceSqls {
	public static final String SELECT_VO_BY_RESERVATION_INFO_ID =  
	"SELECT ript.id AS reservationInfoPriceId " + 
	",ript.reservation_info_id AS reservationInfoId " + 
	",ript.product_price_id AS productPriceId " + 
	",ript.count AS count " + 
	",ppt.price AS price " +
	",ppt.discount_rate AS discountRate " +
	"FROM reservation_info_price AS ript " + 
	"JOIN product_price AS ppt " +
	"ON ript.product_price_id = ppt.id " + 
	"WHERE reservation_info_id = :{reservationInfoId}";
	
	public static final String SELECT_BY_RESERVATION_INFO_ID =
	"SELECT ript.id AS reservationInfoPriceId " + 
	",ript.reservation_info_id AS reservationInfoId " + 
	",ript.product_price_id AS productPriceId " + 
	",ript.count AS count " + 
	"FROM reservation_info_price AS ript " +  
	"WHERE reservation_info_id = :{reservationInfoId}";
}
