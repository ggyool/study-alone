package org.ggyool.reservation.service.impl;

import org.ggyool.reservation.dao.DisplayInfoImageDAO;
import org.ggyool.reservation.dto.DisplayInfoImageDTO;
import org.ggyool.reservation.service.DisplayInfoImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisplayInfoImageServiceImpl implements DisplayInfoImageService{
	
	@Autowired
	DisplayInfoImageDAO displayInfoImageDao;
	
	@Override
	public DisplayInfoImageDTO getImage(Integer displayInfoId) {
		return displayInfoImageDao.selectById(displayInfoId);
	}

}
