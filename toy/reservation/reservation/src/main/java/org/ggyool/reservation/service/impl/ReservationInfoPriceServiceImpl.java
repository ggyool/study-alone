package org.ggyool.reservation.service.impl;

import java.util.List;

import org.ggyool.reservation.dao.ReservationInfoPriceDAO;
import org.ggyool.reservation.entity.ReservationInfoPriceEntity;
import org.ggyool.reservation.service.ReservationInfoPriceService;
import org.ggyool.reservation.vo.ReservationInfoPriceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationInfoPriceServiceImpl implements ReservationInfoPriceService{
	
	@Autowired
	ReservationInfoPriceDAO reservationPriceDAO;
	
	@Override
	// 부모 트랜잭션을 사용하기 위해 default 인듯?) 
	@Transactional(propagation=Propagation.REQUIRED)
	public List<ReservationInfoPriceEntity> addReservationPrices(List<ReservationInfoPriceEntity> reservationPriceList,
			Integer reservationInfoId) {
		try {
			int len = reservationPriceList.size();
			for(int i=0; i<len; ++i) {
				reservationPriceList.get(i).setReservationInfoId(reservationInfoId);
				Integer id = reservationPriceDAO.insert(reservationPriceList.get(i));
				reservationPriceList.get(i).setReservationInfoPriceId(id);
			}
			return reservationPriceList;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ReservationInfoPriceVO> getsByReservationInfoId(Integer reservationInfoId) {
		return reservationPriceDAO.selectByReservationInfoId(reservationInfoId);
	}
	
	@Override
	public Long calcTotalPrice(Integer reservationInfoId) {
		Long totalPrice = 0L;
		List<ReservationInfoPriceVO> list = this.getsByReservationInfoId(reservationInfoId); 
		for(ReservationInfoPriceVO vo : list) {
			Integer price = vo.getPrice();
			Double discountRate = vo.getDiscountRate();
			totalPrice += applyDiscountRate(price, discountRate);
		}
		return totalPrice;
	}
	
	//할인율 적용하여 반올림 (백의자리부터 유효숫자)
	public Long applyDiscountRate(Integer price, Double discountRate) {
		Double beforeRoundPrice = price * (100D-discountRate)/100;
		Long appliedPrice = Math.round(beforeRoundPrice/100) * 100;
		return appliedPrice;
	}
}
