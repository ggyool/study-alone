package org.ggyool.reservation.dao;

public class PromotionSqls {
	public static final String SELECT_BY_ID = 
	"SELECT promotion.id AS id, promotion.product_id AS productId " + 
	", file_info.save_file_name AS productImageUrl " + 
	"FROM promotion INNER JOIN product_image " + 
	"ON promotion.product_id = product_image.product_id AND product_image.type = 'th' " + 
	"INNER JOIN file_info ON product_image.file_id = file_info.id " + 
	"ORDER BY promotion.id;";
}
