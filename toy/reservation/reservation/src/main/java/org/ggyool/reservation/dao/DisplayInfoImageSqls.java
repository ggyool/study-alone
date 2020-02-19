package org.ggyool.reservation.dao;

public class DisplayInfoImageSqls {
	public static final String SELECT_BY_ID =	
	"SELECT fit.content_type AS contentType " +
	", fit.create_date AS createDate " + 
	", fit.delete_flag AS deleteFlag " + 
	", diit.display_info_id AS displayInfoId " + 
	", diit.id AS displayInfoImageId " + 
	", diit.file_id AS fileId " + 
	", fit.file_name AS fileName " + 
	", fit.modify_date AS modifyDate " + 
	", fit.save_file_name AS saveFileName " + 
	"FROM display_info_image AS diit JOIN file_info AS fit " + 
	"ON diit.file_id = fit.id " + 
	"WHERE diit.display_info_id = :displayInfoId";
}