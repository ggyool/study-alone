package org.ggyool.reservation.service;

import java.util.List;
import java.util.Map;

public interface ProductService {
	public static final Integer LIMIT = 4;
	public List<Map<String, Object>> getPrductsByCategory(Integer categoryId, int start);
}
				