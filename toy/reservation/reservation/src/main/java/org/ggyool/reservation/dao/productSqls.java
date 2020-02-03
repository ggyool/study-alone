package org.ggyool.reservation.dao;

public class productSqls {
	public static final String SELECT_TEST =
	"SELECT product.*, display_info.* " + 
	"FROM product LEFT JOIN display_info "
	+ "ON product.id = display_info.product_id "
	+ "WHERE category_id = :categoryId ORDER BY display_info.id limit :start, :limit";
}

