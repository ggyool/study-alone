package org.ggyool.reservation.dao;

public class ProductSqls {
	public static final String SELECT_BY_CATEGORY =
	"SELECT product.id AS productId, product.content AS productContent, product.description AS productDescription " + 
	", display_info.id AS displayInfoId, display_info.place_name AS placeName " + 
	", file_info.save_file_name AS productImageUrl " + 
	"FROM product INNER JOIN display_info " + 
	"ON product.id = display_info.product_id AND product.category_id LIKE IF(:categoryId IS NULL, '%', :categoryId) " +
	"INNER JOIN product_image ON product.id = product_image.product_id AND product_image.type = 'th' " + 
	"INNER JOIN file_info ON product_image.file_id = file_info.id " + 
	"ORDER BY display_info.id limit :start, :limit";
	
	public static final String SELECT =
	"SELECT id, "
	+ "category_id AS categoryId, "
	+ "description, "
	+ "content, "
	+ "event, "
	+ "create_date AS createDate, "
	+ "modify_date AS modifyDate "
	+ "FROM product "
	+ "WHERE id=:productId";
}

