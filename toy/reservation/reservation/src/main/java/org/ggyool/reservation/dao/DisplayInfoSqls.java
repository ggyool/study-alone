package org.ggyool.reservation.dao;

public class DisplayInfoSqls {
	public static final String SELECT_BY_ID = 
			"SELECT dit.create_date AS createDate "
			+ ", dit.id AS displayInfoId "
			+ ", dit.email AS email "
			+ ", dit.homepage AS homepage "
			+ ", dit.modify_date AS modifyDate "
			+ ", dit.opening_hours AS openingHours "
			+ ", dit.place_lot AS placeLot "
			+ ", dit.place_name AS placeName "
			+ ", dit.place_street AS placeStreet "
			+ ", dit.product_id AS productId "
			+ ", dit.tel AS telephone "
			+ ", pt.content AS productContent "
			+ ", pt.description AS productDescription "
			+ ", pt.event AS productEvent "
			+ ", pt.category_id AS categoryId "
			+ ", ct.name AS categoryName "
			+ "FROM  display_info AS dit JOIN product AS pt "
			+ "ON dit.product_id = pt.id "
			+ "JOIN category AS ct "
			+ "ON pt.category_id = ct.id "
			+ "WHERE dit.id  = :displayInfoId";

}
