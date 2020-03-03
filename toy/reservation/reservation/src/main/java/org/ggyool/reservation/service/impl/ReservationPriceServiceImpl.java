package org.ggyool.reservation.service.impl;

import java.util.List;

import org.ggyool.reservation.dao.ReservationPriceDAO;
import org.ggyool.reservation.service.ReservationPriceService;
import org.ggyool.reservation.vo.ReservationPriceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationPriceServiceImpl implements ReservationPriceService{
	
	@Autowired
	ReservationPriceDAO reservationPriceDao;
	
	@Override
	@Transactional
	public List<ReservationPriceVO> addReservationPrices(List<ReservationPriceVO> reservationPriceList) {
		int len = reservationPriceList.size();
		for(int i=0; i<len; ++i) {
			Integer id = reservationPriceDao.insert(reservationPriceList.get(i));
			reservationPriceList.get(i).setId(id);
		}
		return reservationPriceList;
	}
	
}
