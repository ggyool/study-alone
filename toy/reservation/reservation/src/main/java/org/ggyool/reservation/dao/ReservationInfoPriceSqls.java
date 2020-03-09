package org.ggyool.reservation.dao;

public class ReservationInfoPriceSqls {
	public static final String SELECT_BY_RESERVATION_INFO_ID =  
	"SELECT ript.id AS reservationInfoPriceId " + 
	",ript.reservation_info_id AS reservationInfoId " + 
	",ript.product_price_id AS productPriceId " + 
	",ript.count AS count " + 
	"FROM reservation_info_price AS ript " + 
	"WHERE reservation_info_id = :{reservationInfoId}";
}
