package org.ggyool.reservation.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.ggyool.reservation.dao.ReservationInfoDAO;
import org.ggyool.reservation.dto.ReservationParamDTO;
import org.ggyool.reservation.service.ReservationInfoService;
import org.ggyool.reservation.vo.ReservationInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationInfoServiceImpl implements ReservationInfoService{
	
	@Autowired
	ReservationInfoDAO reservationInfoDAO;  
	
	@Override
	public ReservationInfoVO addReservationInfo(ReservationParamDTO reservationParamDTO) {
		ReservationInfoVO reservationInfoVO = new ReservationInfoVO(reservationParamDTO);
		reservationInfoVO.setReservationDate(generateReservatioDate(reservationParamDTO.getReservationYearMonthDay()));
		Date currentDate = new Date();
		reservationInfoVO.setModifyDate(currentDate);
		reservationInfoVO.setCreateDate(currentDate);
		Integer id = reservationInfoDAO.insert(reservationInfoVO);
		reservationInfoVO.setReservationInfoId(id);
		return reservationInfoVO;
	}
	
	// 입력 시간으로 부터 1~5일후를 공연일으로 생성
	public Date generateReservatioDate(Date date) {
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(date);
		Integer addSecond = 60*60*24 + (int)(Math.random() * 4*60*60*24);  
		calendar.add(Calendar.SECOND, addSecond);
		date = calendar.getTime();
		return date;
	}
}




