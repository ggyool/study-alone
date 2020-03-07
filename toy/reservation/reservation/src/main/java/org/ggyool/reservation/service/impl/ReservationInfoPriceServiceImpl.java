package org.ggyool.reservation.service.impl;

import java.util.List;

import org.ggyool.reservation.dao.ReservationInfoPriceDAO;
import org.ggyool.reservation.service.ReservationInfoPriceService;
import org.ggyool.reservation.vo.ReservationInfoPriceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationInfoPriceServiceImpl implements ReservationInfoPriceService{
	
	@Autowired
	ReservationInfoPriceDAO reservationPriceDao;
	
	@Override
	@Transactional
	public List<ReservationInfoPriceVO> addReservationPrices(List<ReservationInfoPriceVO> reservationPriceList) {
		int len = reservationPriceList.size();
		for(int i=0; i<len; ++i) {
			Integer id = reservationPriceDao.insert(reservationPriceList.get(i));
			reservationPriceList.get(i).setReservationInfoPriceId(id);
		}
		return reservationPriceList;
	}
	
}
