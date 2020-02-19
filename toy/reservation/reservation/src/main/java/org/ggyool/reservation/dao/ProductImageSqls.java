package org.ggyool.reservation.dao;

public class ProductImageSqls {
	public static final String SELECT_BY_ID = 	
			"SELECT fit.content_type AS contentType " + 
			", fit.create_date AS createDate " + 
			", fit.delete_flag AS deleteFlag " + 
			", pit.file_id AS fileInfoId " + 
			", fit.file_name AS fileName " + 
			", fit.modify_date AS modifyDate " + 
			", pit.product_id AS productId " + 
			", pit.id AS productImageId " + 
			", fit.save_file_name AS saveFIleName " + 
			", pit.type AS type " + 
			"FROM product_image AS pit JOIN file_info AS fit " + 
			"ON pit.file_id = fit.id " + 
			"WHERE pit.product_id = :productId";
}
