package org.ggyool.reservation.service.impl;

import java.util.List;

import org.ggyool.reservation.dao.ReservationInfoPriceDAO;
import org.ggyool.reservation.service.ReservationInfoPriceService;
import org.ggyool.reservation.vo.ReservationInfoPriceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationInfoPriceServiceImpl implements ReservationInfoPriceService{
	
	@Autowired
	ReservationInfoPriceDAO reservationPriceDao;
	
	@Override
	// 부모 트랜잭션을 사용하기 위해 default 인듯?) 
	@Transactional(propagation=Propagation.REQUIRED)
	public List<ReservationInfoPriceVO> addReservationPrices(List<ReservationInfoPriceVO> reservationPriceList,
			Integer reservationInfoId) {
		try {
			int len = reservationPriceList.size();
			for(int i=0; i<len; ++i) {
				reservationPriceList.get(i).setReservationInfoId(reservationInfoId);
				Integer id = reservationPriceDao.insert(reservationPriceList.get(i));
				reservationPriceList.get(i).setReservationInfoPriceId(id);
			}
			return reservationPriceList;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ReservationInfoPriceVO> getsByReservationInfoId(Integer reservationInfoId) {
		return reservationPriceDao.selectByReservationInfoId(reservationInfoId);
	}
	
}
