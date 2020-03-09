package org.ggyool.reservation.dao;

public class ProductPriceSqls {
	public static final String SELECT_BY_PRODUCT_ID = 
	"SELECT create_date AS createDate " + 
	", discount_rate AS discountRate " + 
	", modify_date AS modifyDate " + 
	", price " + 
	", price_type_name AS priceTypeName " + 
	", product_id AS productId " + 
	", id AS productPriceId " + 
	"FROM product_price AS ppt " + 
	"WHERE ppt.product_id = :productId";
	
	public static final String SELECT_BY_ID = 
	"SELECT create_date AS createDate " + 
	", discount_rate AS discountRate " + 
	", modify_date AS modifyDate " + 
	", price " + 
	", price_type_name AS priceTypeName " + 
	", product_id AS productId " + 
	", id AS productPriceId " + 
	"FROM product_price AS ppt " + 
	"WHERE ppt.id = :productPriceId";
	
}
