package org.ggyool.reservation.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.ggyool.reservation.dao.ReservationInfoDAO;
import org.ggyool.reservation.service.ReservationInfoService;
import org.ggyool.reservation.vo.ReservationInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationInfoServiceImpl implements ReservationInfoService{
	
	@Autowired
	ReservationInfoDAO reservationInfoDAO;  
	
	@Override
	public ReservationInfoVO addReservationInfo(ReservationInfoVO reservationInfoVO, Date reservationYearMonthDay) {
		reservationInfoVO.setReservationDate(generateReservatioDate());
		Integer id = reservationInfoDAO.insert(reservationInfoVO);
		reservationInfoVO.setId(id);
		return reservationInfoVO;
	}
	
	// 현재 시간으로 부터 1~5일후를 공연일으로 생성
	public Date generateReservatioDate() {
		Calendar calendar = Calendar.getInstance(); 
		Integer addSecond = 60*60*24 + (int)(Math.random() * 4*60*60*24);  
		calendar.add(Calendar.SECOND, addSecond);
		Date date = calendar.getTime();
		return date;
	}
}




