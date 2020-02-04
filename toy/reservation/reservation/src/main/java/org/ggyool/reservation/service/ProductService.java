package org.ggyool.reservation.service;

import java.util.HashMap;
import java.util.List;

public interface ProductService {
	public static final Integer LIMIT = 4;
	public List<HashMap<String, Object>> getPrductsByCategory(Integer categoryId, int start);
}
				