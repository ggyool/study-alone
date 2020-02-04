package org.ggyool.reservation.service.impl;

import java.util.HashMap;
import java.util.List;

import org.ggyool.reservation.dao.PromotionDAO;
import org.ggyool.reservation.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PromotionServiceImpl implements PromotionService{

	@Autowired
	PromotionDAO promotionDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<HashMap<String, Object>> getPromotions() {
		return promotionDao.selectOnPromotion();
	}
	
	
}
