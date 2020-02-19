package org.ggyool.reservation.service.impl;

import org.ggyool.reservation.dao.DisplayInfoDAO;
import org.ggyool.reservation.dto.DisplayInfoDTO;
import org.ggyool.reservation.service.DisplayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisplayInfoServiceImpl implements DisplayInfoService{
	
	@Autowired
	DisplayInfoDAO displayInfoDao;
	
	@Override
	public DisplayInfoDTO get(Integer displayInfoId) {
		return displayInfoDao.selectById(displayInfoId);
	}

}
