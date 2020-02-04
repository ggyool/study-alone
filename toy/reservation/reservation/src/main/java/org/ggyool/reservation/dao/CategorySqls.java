package org.ggyool.reservation.dao;

public class CategorySqls {
	public static final String SELECT_ALL 
	= "SELECT id, name FROM category ORDER BY id";
	
	public static final String SELECT_WITH_COUNT
	= "SELECT category.id AS id, category.name AS name, COUNT(category.name) AS count " + 
	"FROM category INNER JOIN product " + 
	"ON category.id = product.category_id " + 
	"INNER JOIN display_info ON product.id = display_info.product_id " + 
	"GROUP BY category.id";
	
	public static final String COUNT_PRODUCTS_BY_CATEGORY_ID
	= "SELECT COUNT(category.name) AS count " + 
	"FROM category INNER JOIN product " + 
	"ON category.id = product.category_id AND category.id=:categoryId " + 
	"INNER JOIN display_info ON product.id = display_info.product_id " + 
	"GROUP BY category.id";
	;
}
